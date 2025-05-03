package org.piccode.rt.modules;

import java.util.ArrayList;
import java.util.List;
import org.piccode.rt.PiccodeArray;
import org.piccode.rt.PiccodeString;
import org.piccode.rt.PiccodeValue;


/**
 *
 * @author hexaredecimal
 */
public class PiccodeArrayModule {
	public static void addFunctions() {
		NativeFunctionFactory.create("array_concat", List.of("l", "r"), (args, namedArgs) -> {
				var l= ((PiccodeArray) namedArgs.get("l")).getList();
				var r= ((PiccodeArray) namedArgs.get("r")).getList();
				var c = new ArrayList<PiccodeValue>();
				l.forEach((a) -> c.add(a));
				r.forEach((a) -> c.add(a));
				return new PiccodeArray(c);
		});
		
		NativeFunctionFactory.create("array_tostring", List.of("arr"), (args, namedArgs) -> {
				var arr = ((PiccodeArray) namedArgs.get("arr")).getList();
				return new PiccodeString(arr.toString());
		});
		
		NativeFunctionFactory.create("array_join", List.of("arr", "sep"), (args, namedArgs) -> {
				var arr = ((PiccodeArray) namedArgs.get("arr")).getList();
				var sep = namedArgs.get("sep").toString();
				var strArr = arr
					.stream()
					.map((a) -> a.toString())
					.toArray(String[]::new);

				var join = String.join(sep, strArr);
				return new PiccodeString(join);
		});
	}
}
