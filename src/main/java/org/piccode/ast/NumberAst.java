package org.piccode.ast;

/**
 *
 * @author hexaredecimal
 */
public class NumberAst extends Ast {
	public String text; 

	public NumberAst(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
