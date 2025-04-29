package org.piccode.ast;

/**
 *
 * @author hexaredecimal
 */
public class IdentifierAst extends Ast {
	public String text; 

	public IdentifierAst(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
