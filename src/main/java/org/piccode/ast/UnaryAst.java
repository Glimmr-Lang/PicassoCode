package org.piccode.ast;

import org.piccode.rt.PiccodeValue;

/**
 *
 * @author hexaredecimal
 */
public class UnaryAst implements Ast{
	public String op;
	public Ast expr;

	public UnaryAst(String op, Ast expr) {
		this.op = op;
		this.expr = expr;
	}

	@Override
	public String toString() {
		return String.format("%s %s", op, expr);
	}

	@Override
	public PiccodeValue execute() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	
}
