package org.piccode.ast;

import java.util.List;

/**
 *
 * @author hexaredecimal
 */
public class ModuleAst extends Ast {
	public String name;
	public List<Ast> nodes;

	public ModuleAst(String name, List<Ast> nodes) {
		this.name = name;
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("module ");
		sb.append(name).append(" {\n");
		for (var node: nodes) {
			sb.append(node.toString().indent(4));
		}
		sb.append("}");
		return sb.toString();
	}
	
}
