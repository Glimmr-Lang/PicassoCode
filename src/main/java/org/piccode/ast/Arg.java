package org.piccode.ast;

/**
 *
 * @author hexaredecimal
 */
public class Arg extends Ast {
	public String name;
	public Ast def_val;

	public Arg(String name, Ast def_val) {
		this.name = name;
		this.def_val = def_val;
	}

	public Arg(String name) {
		this.name = name;
		this.def_val = null;
	}

	@Override
	public String toString() {
		if (def_val == null) {
			return name;
		}
		return name  + "=" + def_val;
	}
	
}
