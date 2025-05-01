package org.piccode.ast;

import org.piccode.rt.PiccodeString;
import org.piccode.rt.PiccodeValue;

/**
 *
 * @author hexaredecimal
 */
public class StringAst implements Ast {
	public String text; 

	public StringAst(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

	@Override
	public PiccodeValue execute() {
		return new PiccodeString(text);
	}

}
