package org.piccode.ast;

import java.util.List;

/**
 *
 * @author hexaredecimal
 */
public class FunctionAst extends Ast {

	public String name;
	public Arg arg;
	public Ast body;

	public FunctionAst(String name, Arg arg, Ast body) {
		this.name = name;
		this.arg = arg;
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
			.append("function ")
			.append(name)
		  .append("(");
		if (arg != null) {
			sb.append(arg);
		}
		sb.append(") = ");
		sb.append(body);
		return sb.toString();
	}

}
