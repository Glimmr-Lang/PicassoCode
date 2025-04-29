package org.piccode.ast;

/**
 *
 * @author hexaredecimal
 */
public class ImportAst extends Ast {
	public String pkg;
	public String module;

	public ImportAst(String pkg, String module) {
		this.pkg = pkg;
		this.module = module;
	}

	@Override
	public String toString() {
		return "import " + pkg + ":" + module;
	}

	
}
