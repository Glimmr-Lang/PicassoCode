package org.piccode.rt.modules;

import java.util.List;
import javax.swing.JOptionPane;
import org.editor.AccessFrame;
import org.piccode.rt.PiccodeNumber;
import org.piccode.rt.PiccodeString;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeIOModule {
	
	public static void addFunctions() {
		NativeFunctionFactory.create("print", List.of("value"), (args, namedArgs) -> {
			var value = namedArgs.get("value").toString();
			AccessFrame.writeString(value);
			return new PiccodeNumber("0");
		});
		
		NativeFunctionFactory.create("read", List.of("msg"), (args, namedArgs) -> {
			var value = namedArgs.get("msg");
			var result = JOptionPane.showInputDialog(value);
			if (result == null) {
				return new PiccodeString("No input provided");
			}
			return new PiccodeString(result);
		});
		
	}
	
}
