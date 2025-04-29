package org.piccode.ast;

/**
 *
 * @author hexaredecimal
 */
public class StringAst extends Ast {
	public String text; 

	public StringAst(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
