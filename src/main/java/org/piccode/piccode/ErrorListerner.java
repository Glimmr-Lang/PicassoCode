package org.piccode.piccode;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author hexaredecimal
 */
public class ErrorListerner extends BaseErrorListener {

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
					Object offendingSymbol,
					int line, int charPositionInLine,
					String msg, RecognitionException e) {
		System.err.printf("Syntax error at line %d, column %d: %s%n",
						line, charPositionInLine, msg);
	}
}
