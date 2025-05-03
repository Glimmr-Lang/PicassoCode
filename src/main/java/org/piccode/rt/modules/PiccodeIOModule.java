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
public class PiccodeIO {
	
	public static void addFunctions(JTextArea msgs) {
		
		NativeFunction print = new NativeFunction("print", List.of("value"), Map.of("value", new PiccodeString(""))) {
			@Override
			public PiccodeValue invoke(List<PiccodeValue> args, Map<String, PiccodeValue> namedArgs) {
				var value = namedArgs.get("value");
				msgs.setText(msgs.getText() + "\n" + value);
				return new PiccodeNumber("0");
			}

			@Override
			public Object raw() {
				return this;
			}
		};

		NativeFunction read = new NativeFunction("read", List.of("msg"), Map.of("msg", new PiccodeString("Enter your input"))) {
			@Override
			public PiccodeValue invoke(List<PiccodeValue> args, Map<String, PiccodeValue> namedArgs) {
				var value = namedArgs.get("msg");
				var result = JOptionPane.showInputDialog(value);

				if (result == null) {
					return new PiccodeString("No input provided");
				}

				return new PiccodeString(result);
			}

			@Override
			public Object raw() {
				return this;
			}
		};
		Context.addGlobal("pic_nat_read", read);
		Context.addGlobal("pic_nat_print", print);
	}
	
}
