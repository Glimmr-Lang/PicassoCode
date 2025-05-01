package org.piccode.rt;

import java.util.List;
import org.piccode.ast.Ast;


/**
 *
 * @author hexaredecimal
 */
public class PiccodeModule implements PiccodeValue{
	public String name; 
	public List<Ast> nodes; 

	public PiccodeModule(String name, List<Ast> nodes) {
		this.name = name;
		this.nodes = nodes;
	}
	
	@Override
	public Object raw() {
		return name;
	}

	@Override
	public String toString() {
		return "module " + name;
	}
	
}
