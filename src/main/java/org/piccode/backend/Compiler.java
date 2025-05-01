package org.piccode.backend;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.editor.errors.IDEErrorListener;
import org.piccode.antlr4.PiccodeScriptLexer;
import org.piccode.antlr4.PiccodeScriptParser;
import org.piccode.ast.PiccodeVisitor;
import org.piccode.rt.Context;
import org.piccode.rt.NativeFunction;
import org.piccode.rt.PiccodeBoolean;
import org.piccode.rt.PiccodeNumber;
import org.piccode.rt.PiccodeValue;
import org.piccode.rt.modules.PiccodeIO;

/**
 *
 * @author hexaredecimal
 */
public class Compiler {

	public static void compile(String code, JTextArea msgs) {

		var lexer = new PiccodeScriptLexer(CharStreams.fromString(code));
		var parser = new PiccodeScriptParser(new CommonTokenStream(lexer));
		lexer.removeErrorListeners();
		parser.removeErrorListeners();

		IDEErrorListener errorListener = new IDEErrorListener();
		lexer.addErrorListener(errorListener);
		parser.addErrorListener(errorListener);

		var visitor = new PiccodeVisitor();

		msgs.setText(msgs.getText() + "\nParsing: " + LocalDateTime.now());
		var result = visitor.visit(parser.stmts());
		Context.top.pushStack();
		Context.top.putLocal("true", new PiccodeBoolean("true"));
		Context.top.putLocal("false", new PiccodeBoolean("false"));
		addGlobalFunctions(msgs);
		msgs.setText(msgs.getText() + "\nExec: " + LocalDateTime.now());
		result.execute();
	}

	private static void addGlobalFunctions(JTextArea msgs) {
		PiccodeIO.addFunctions(msgs);
	}
}
