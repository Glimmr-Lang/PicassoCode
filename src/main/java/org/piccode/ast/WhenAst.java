package org.piccode.ast;

import java.util.List;
import org.piccode.rt.PiccodeException;
import org.piccode.rt.PiccodeValue;

/**
 *
 * @author hexaredecimal
 */
public class WhenAst implements Ast {
	public Ast cond;
	public List<WhenCase> cases;
	public Ast else_case;

	public WhenAst(Ast cond, List<WhenCase> cases, Ast else_case) {
		this.cond = cond;
		this.cases = cases;
		this.else_case = else_case;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("when ").append(cond).append("{\n");
		for (var when_c: cases) {
			sb.append(when_c.toString().indent(4));
		}

		if (else_case != null) {
			sb.append(String.format("else %s", else_case).indent(4));
		}
		sb.append("}");
		return sb.toString();
	}

	@Override
	public PiccodeValue execute() {
		var cond_value = cond.execute();

		for (var match_case: cases) {
				if (isMatching(match_case.match, cond_value)) {
					return match_case.value.execute();
				}
		}

		if (else_case == null) {
			throw new PiccodeException("Inexhaustive when expression has hit an unexpected state where no pattern was matched: when " + cond + " { ...");
		}
		
		return else_case.execute();
	}

	private boolean isMatching(List<Ast> match, PiccodeValue cond_value) {
		for (var node: match) {
			if (node instanceof IdentifierAst id) {
				continue; // TODO: Add Ids to the symtable
			}

			var value = node.execute();
			if (node.equals(cond_value)) {
				return true;
			}
		}

		return false;
	}
}
