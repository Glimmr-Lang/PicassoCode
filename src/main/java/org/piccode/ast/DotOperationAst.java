package org.piccode.ast;

import org.piccode.rt.Context;
import org.piccode.rt.PiccodeException;
import org.piccode.rt.PiccodeModule;
import org.piccode.rt.PiccodeObject;
import org.piccode.rt.PiccodeValue;

/**
 *
 * @author hexaredecimal
 */
public class DotOperationAst implements Ast {

	public Ast lhs;
	public Ast rhs;

	public DotOperationAst(Ast lhs, Ast rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public String toString() {
		return lhs + "." + rhs;
	}

	@Override
	public PiccodeValue execute() {

		if (lhs instanceof IdentifierAst id && Context.modules.containsKey(id.text)) {
			var mod = Context.modules.get(id.text);

			if (!(rhs instanceof CallAst) && !(rhs instanceof IdentifierAst)) {
				throw new PiccodeException("No node " + rhs + " found in module " + id.text);
			}

			return process(id, mod);
		}

		var left = lhs.execute();

		if (left instanceof PiccodeModule mod) {
			return process(new IdentifierAst(mod.name), mod);
		}

		if (!(left instanceof PiccodeObject)) {
			throw new PiccodeException("Invalid expression on the left side of `.` : " + lhs);
		}

		var obj = (PiccodeObject) left;

		String key = null;
		if (rhs instanceof IdentifierAst id) {
			key = id.text;
		} else {
			key = rhs.execute().raw().toString();
		}

		var value = obj.getValue(key);
		if (value == null) {
			throw new PiccodeException("Field `" + key + "` is not part of " + obj.raw());
		}

		return value;
	}

	private PiccodeValue process(IdentifierAst id, PiccodeModule mod) {
		if (rhs instanceof IdentifierAst _id) {
			for (var node : mod.nodes) {
				if (node instanceof VarDecl vd && vd.name.equals(_id.text)) {
					return node.execute();
				}
				if (node instanceof FunctionAst func && func.name.equals(_id.text)) {
					node.execute();
					return Context.top.getValue(_id.text);
				}
				if (node instanceof ModuleAst _mod && _mod.name.equals(_id.text)) {
					node.execute();
					return Context.modules.get(_id.text);
				}
			}

			throw new PiccodeException("No function or identifier " + _id.text + " found in module " + id.text);
		}

		var call = (CallAst) rhs;

		if (!(call.expr instanceof IdentifierAst)) {
			throw new PiccodeException("Invalid function reference in module access module " + id.text + ": " + call.expr);
		}

		var _id = (IdentifierAst) call.expr;
		for (var node : mod.nodes) {
			if (node instanceof VarDecl vd && vd.name.equals(_id.text)) {
				return node.execute();
			}
			if (node instanceof FunctionAst func && func.name.equals(_id.text)) {
				node.execute();
				//return Context.top.getValue(_id.text);
				return call.execute();
			}
			if (node instanceof ModuleAst _mod && _mod.name.equals(_id.text)) {
				node.execute();
				return Context.modules.get(_id.text);
			}
		}

		throw new PiccodeException("No function or identifier " + _id.text + " found in module " + id.text);
	}
}
