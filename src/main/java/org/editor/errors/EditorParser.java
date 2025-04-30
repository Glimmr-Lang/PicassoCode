package org.editor.errors;

import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.editor.errors.IDEErrorListener.SyntaxErrorInfo;
import org.fife.ui.rsyntaxtextarea.RSyntaxDocument;
import org.fife.ui.rsyntaxtextarea.parser.AbstractParser;
import org.fife.ui.rsyntaxtextarea.parser.DefaultParseResult;
import org.fife.ui.rsyntaxtextarea.parser.DefaultParserNotice;
import org.fife.ui.rsyntaxtextarea.parser.ParseResult;
import org.piccode.antlr4.PiccodeScriptLexer;
import org.piccode.antlr4.PiccodeScriptParser;
import org.piccode.ast.PiccodeVisitor;

/**
 *
 * @author hexaredecimal
 */
public class EditorParser extends AbstractParser  {

	@Override
	public ParseResult parse(RSyntaxDocument doc, String style) {
		DefaultParseResult result = new DefaultParseResult(this);

		try {
			String code = doc.getText(0, doc.getLength());

			var lexer = new PiccodeScriptLexer(CharStreams.fromString(code));
			var tokens = new CommonTokenStream(lexer);
			var parser = new PiccodeScriptParser(tokens);

			// Setup error listener
			IDEErrorListener errorListener = new IDEErrorListener();
			lexer.removeErrorListeners();
			parser.removeErrorListeners();
			lexer.addErrorListener(errorListener);
			parser.addErrorListener(errorListener);

			var visitor = new PiccodeVisitor();
			visitor.visit(parser.stmts());

			// Report any collected syntax errors to the RSyntax framework
			for (SyntaxErrorInfo info : errorListener.getSyntaxErrorInfos()) {
				int offset = getOffset(doc, info.line, info.charPositionInLine);
				result.addNotice(new DefaultParserNotice(this, info.message, info.line, offset, 1));
			}

		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		return result;
	}

	private int getOffset(RSyntaxDocument doc, int line, int column) throws BadLocationException {
		Element root = doc.getDefaultRootElement();
		if (line - 1 >= root.getElementCount()) {
			return -1;
		}
		int lineStart = root.getElement(line - 1).getStartOffset();
		return lineStart + column;
	}

}
