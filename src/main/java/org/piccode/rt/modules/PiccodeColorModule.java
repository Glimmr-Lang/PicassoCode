package org.piccode.rt.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.piccode.rt.PiccodeArray;
import org.piccode.rt.PiccodeNumber;
import org.piccode.rt.PiccodeTuple;
import org.piccode.rt.PiccodeValue;


/**
 *
 * @author hexaredecimal
 */
public class PiccodeColorModule {
	public static void addFunctions() {
		
		NativeFunctionFactory.create("createcolora", List.of("r", "g", "b", "a"), (args, namedArgs) -> {
			var r = (int) (double)namedArgs.get("r").raw();
			var g = (int) (double)namedArgs.get("g").raw();
			var b = (int) (double)namedArgs.get("b").raw();
			var a = (int) (double)namedArgs.get("a").raw();
			var color = new Color(r, g, b, a).getRGB();
			return new PiccodeNumber("" + color);
		});
		
		
	}
}
