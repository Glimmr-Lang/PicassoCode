package org.piccode.rt.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.piccode.rt.Context;
import org.piccode.rt.NativeFunction;
import org.piccode.rt.PiccodeNumber;
import org.piccode.rt.PiccodeString;
import org.piccode.rt.PiccodeValue;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeIOModule {
	
	public static void addFunctions(JTextArea msgs) {
		NativeFunctionFactory.create("print", List.of("value"), (args, namedArgs) -> {
				var value = namedArgs.get("value");
				msgs.setText(msgs.getText() + "\n" + value);
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
