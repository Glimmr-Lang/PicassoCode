package org.editor.util;

/**
 *
 * @author hexaredecimal
 */
public class It {
	public static void panic(String message) {
		throw new RuntimeException("PANIC: " + message);
	} 

	public static void panic() {
		panic("");
	}


	public static void todo(String message) {
		throw new RuntimeException("TODO: " + message);
	}

	public static void todo() {
		todo("");
	}

	public static void unreachable(String message) {
		throw new RuntimeException("UNREACHABLE: " + message);
	}

	public static void unreachable() {
		unreachable("");
	}
}
