package org.piccode.rt.modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.editor.icons.ImageLoader;
import org.piccode.rt.PiccodeArray;
import org.piccode.rt.PiccodeNumber;
import org.piccode.rt.PiccodeTuple;
import org.piccode.rt.PiccodeValue;


/**
 *
 * @author hexaredecimal
 */
public class PiccodeResourceModule {
	public static void addFunctions() {
		
		NativeFunctionFactory.create("loadpaint", List.of("src"), (args, namedArgs) -> {
			var path = namedArgs.get("src").toString();
			var index = ImageLoader.loadImage(path);

			return new PiccodeNumber("" + index);
		});
		
		
	}
}
