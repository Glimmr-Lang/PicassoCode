package org.piccode.rt.modules;

import java.awt.Color;
import java.util.List;
import org.editor.CanvasFrame;
import org.editor.icons.ImageLoader;
import org.piccode.rt.PiccodeArray;
import org.piccode.rt.PiccodeUnit;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeGfxModule {

	public static void addFunctions() {
		NativeFunctionFactory.create("drawline", List.of("x1", "y1", "x2", "y2"), (args, namedArgs) -> {
			var x1 = (int) (double) namedArgs.get("x1").raw();
			var x2 = (int) (double) namedArgs.get("x2").raw();
			var y1 = (int) (double) namedArgs.get("y1").raw();
			var y2 = (int) (double) namedArgs.get("y2").raw();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;
			CanvasFrame.gfx.drawLine(xoff + x1, yoff + y1, xoff + x2, yoff + y2);
			return new PiccodeUnit();
		});

		NativeFunctionFactory.create("drawrect", List.of("x", "y", "w", "h"), (args, namedArgs) -> {
			var x = (int) (double) namedArgs.get("x").raw();
			var y = (int) (double) namedArgs.get("y").raw();
			var w = (int) (double) namedArgs.get("w").raw();
			var h = (int) (double) namedArgs.get("h").raw();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;
			CanvasFrame.gfx.drawRect(xoff + x, yoff + y, w, h);
			return new PiccodeUnit();
		});

		NativeFunctionFactory.create("drawoval", List.of("x", "y", "w", "h"), (args, namedArgs) -> {
			var x = (int) (double) namedArgs.get("x").raw();
			var y = (int) (double) namedArgs.get("y").raw();
			var w = (int) (double) namedArgs.get("w").raw();
			var h = (int) (double) namedArgs.get("h").raw();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;
			CanvasFrame.gfx.drawOval(xoff + x, yoff + y, w, h);
			return new PiccodeUnit();
		});

		NativeFunctionFactory.create("drawstring", List.of("str", "x", "y"), (args, namedArgs) -> {
			var str = namedArgs.get("str").raw().toString();
			var x = (int) (double) namedArgs.get("x").raw();
			var y = (int) (double) namedArgs.get("y").raw();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;
			CanvasFrame.gfx.drawString(str, xoff + x, yoff + y);
			return new PiccodeUnit();
		});

		NativeFunctionFactory.create("drawpolygon", List.of("xarrr", "yarrr"), (args, namedArgs) -> {
			var xa = ((PiccodeArray) namedArgs.get("xarrr").raw()).getList();
			var ya = ((PiccodeArray) namedArgs.get("yarrr").raw()).getList();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;

			int[] xarr = new int[xa.size()];
			int[] yarr = new int[ya.size()];

			for (int i = 0; i < xa.size(); i++) {
				xarr[i] = (int) (double) xa.get(i).raw();
				xarr[i] += xoff;
			}

			for (int i = 0; i < ya.size(); i++) {
				yarr[i] = (int) (double) ya.get(i).raw();
				yarr[i] += yoff;
			}
			CanvasFrame.gfx.drawPolygon(xarr, yarr, 0);
			return new PiccodeUnit();
		});
		NativeFunctionFactory.create("drawpolyline", List.of("xarrr", "yarrr"), (args, namedArgs) -> {
			var xa = ((PiccodeArray) namedArgs.get("xarrr").raw()).getList();
			var ya = ((PiccodeArray) namedArgs.get("yarrr").raw()).getList();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;

			int[] xarr = new int[xa.size()];
			int[] yarr = new int[ya.size()];

			for (int i = 0; i < xa.size(); i++) {
				xarr[i] = (int) (double) xa.get(i).raw();
				xarr[i] += xoff;
			}

			for (int i = 0; i < ya.size(); i++) {
				yarr[i] = (int) (double) ya.get(i).raw();
				yarr[i] += yoff;
			}
			CanvasFrame.gfx.drawPolyline(xarr, yarr, 0);
			return new PiccodeUnit();
		});

		NativeFunctionFactory.create("drawimage", List.of("id", "x", "y", "w", "h"), (args, namedArgs) -> {
			var id= (int) (double) namedArgs.get("id").raw();
			var x= (int) (double) namedArgs.get("x").raw();
			var y= (int) (double) namedArgs.get("y").raw();
			var w= (int) (double) namedArgs.get("w").raw();
			var h= (int) (double) namedArgs.get("h").raw();
			var xoff = CanvasFrame.offsetX;
			var yoff = CanvasFrame.offsetY;

			var img = ImageLoader.getImage(id);
			
			CanvasFrame.gfx.drawImage(img, x + xoff, y + yoff, w, h, CanvasFrame.the());
			return new PiccodeUnit();
		});


		NativeFunctionFactory.create("color", List.of("color"), (args, namedArgs) -> {
			var rgb = (int) (double) namedArgs.get("color").raw();
			CanvasFrame.gfx.setColor(new Color(rgb));
			return new PiccodeUnit();
		});

		
	}
}
