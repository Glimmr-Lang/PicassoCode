package org.piccode.rt;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author hexaredecimal
 */
public class Context {
	private static HashMap<String, PiccodeValue> global_scope = new HashMap<>();
	private Stack<HashMap<String, PiccodeValue>> scope_stack;

	public static Context top = new Context();
	public static HashMap<String, PiccodeModule> modules = new HashMap<>();
	
	public Context() {
		scope_stack = new Stack<>();
	}

	public static void addGlobal(String name, PiccodeValue value) {
		global_scope.put(name, value);
	}

	public void pushStack() {
		scope_stack.push(new HashMap<>());
	}

	public void dropStackFrame() {
		scope_stack.pop();
	}

	public void putLocal(String name, PiccodeValue value) {
		var frame = scope_stack.peek();
		frame.put(name, value);
	}

	public PiccodeValue getValue(String name) {
		if (scope_stack.isEmpty()) {
			return global_scope.get(name);
		}
		var frame = scope_stack.peek();
		var value = frame.get(name);
		if (value == null) {
			return global_scope.get(name);
		}
		return value;
	}
}
