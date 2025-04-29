package org.piccode.ast;

import java.util.List;

/**
 *
 * @author hexaredecimal
 */
public class ClosureAst extends Ast {
	public Arg arg;
	public Ast body;

	public ClosureAst(Arg arg, Ast body) {
		this.arg = arg;
		this.body = body;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
			.append("")
		  .append("(");
		if (arg != null) {
			sb.append(arg);
		}
		sb.append(") => ");
		sb.append(body);
		return sb.toString();
	}

}
