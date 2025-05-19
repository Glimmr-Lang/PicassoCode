package org.piccode.backend;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.editor.AccessFrame;
import org.editor.errors.IDEErrorListener;
import org.piccode.antlr4.PiccodeScriptLexer;
import org.piccode.antlr4.PiccodeScriptParser;
import org.piccode.ast.Ast;
import org.piccode.ast.FunctionAst;
import org.piccode.ast.ImportAst;
import org.piccode.ast.ModuleAst;
import org.piccode.ast.PiccodeVisitor;
import org.piccode.ast.StatementList;
import org.piccode.rt.Context;
import org.piccode.rt.NativeFunction;
import org.piccode.rt.PiccodeBoolean;
import org.piccode.rt.PiccodeException;
import org.piccode.rt.PiccodeNumber;
import org.piccode.rt.PiccodeValue;
import org.piccode.rt.modules.PiccodeArrayModule;
import org.piccode.rt.modules.PiccodeColorModule;
import org.piccode.rt.modules.PiccodeGfxModule;
import org.piccode.rt.modules.PiccodeIOModule;
import org.piccode.rt.modules.PiccodeMathModule;
import org.piccode.rt.modules.PiccodeResourceModule;
import org.piccode.rt.modules.PiccodeStringModule;
import org.piccode.rt.modules.PiccodeTupleModule;

/**
 *
 * @author hexaredecimal
 */
public class Compiler {

	public static List<Ast> main_loop = new ArrayList<>();

	public static void compile(String code, boolean render) {

		var lexer = new PiccodeScriptLexer(CharStreams.fromString(code));
		var parser = new PiccodeScriptParser(new CommonTokenStream(lexer));
		lexer.removeErrorListeners();
		parser.removeErrorListeners();

		IDEErrorListener errorListener = new IDEErrorListener();
		lexer.addErrorListener(errorListener);
		parser.addErrorListener(errorListener);

		var visitor = new PiccodeVisitor();

		AccessFrame.writeWarning("Starting Parsing");
		var result = (StatementList) visitor.visit(parser.stmts());
		Context.top.pushStack();
		Context.top.putLocal("true", new PiccodeBoolean("true"));
		Context.top.putLocal("false", new PiccodeBoolean("false"));
		addGlobalFunctions();
		AccessFrame.writeWarning("Staring execution");
		try {
			main_loop.clear();
			for (var stmt : result.nodes) {
				if (stmt instanceof FunctionAst || stmt instanceof ImportAst || stmt instanceof ModuleAst) {
					stmt.execute();
					continue;
				}
				if (render) {
					main_loop.add(stmt);
				}else {
					stmt.execute();
				}
			}
			AccessFrame.writeSuccess("Compilation successful:  ");
		} catch (Exception rte) {
			rte.printStackTrace();
			AccessFrame.writeError(rte.getMessage());
		} finally {
			Context.top.dropStackFrame();
		}
	}

	private static void addGlobalFunctions() {
		PiccodeIOModule.addFunctions();
		PiccodeArrayModule.addFunctions();
		PiccodeStringModule.addFunctions();
		PiccodeTupleModule.addFunctions();
		PiccodeMathModule.addFunctions();
		PiccodeGfxModule.addFunctions();
		PiccodeResourceModule.addFunctions();
		PiccodeColorModule.addFunctions();
	}
}
