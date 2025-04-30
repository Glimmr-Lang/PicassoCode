package org.editor.errors;

/**
 *
 * @author hexaredecimal
 */

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.*;

public class IDEErrorListener extends BaseErrorListener {

	public static class SyntaxErrorInfo {

		public final int line;
		public final int charPositionInLine;
		public final String message;

		public SyntaxErrorInfo(int line, int charPositionInLine, String message) {
			this.line = line;
			this.charPositionInLine = charPositionInLine;
			this.message = message;
		}
	}

	private final List<SyntaxErrorInfo> syntaxErrors = new ArrayList<>();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
					int line, int charPositionInLine,
					String msg, RecognitionException e) {
		syntaxErrors.add(new SyntaxErrorInfo(line, charPositionInLine, msg));
	}

	public List<SyntaxErrorInfo> getSyntaxErrorInfos() {
		return syntaxErrors;
	}
}
