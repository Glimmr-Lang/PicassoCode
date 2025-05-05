package org.editor.icons;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author hexaredecimal
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public class ImageLoader {

	private static final Map<String, ImageData> data = new HashMap<>();

	static {
		loadDefault();
	}

	public static int loadImage(String path) {
		if (data.containsKey(path)) {
			return data.get(path).index;
		}

		var fp = new File(path);

		if (!fp.exists()) {
			return 0;
		}

		try {
			Image img = null; 
			if (fp.getName().endsWith(".gif")) {
				img = Toolkit.getDefaultToolkit().getImage(path);
			} else {
				img = ImageIO.read(fp);
			}
			if (img != null) {
				var index = data.keySet().size();
				data.put(path, new ImageData(img, index));
				return index;
			} else {
				return 0;
			}
		} catch (IOException e) {
			return 0;
		}
	}

	private static void loadDefault() {
		var path = "/misc/misc.png";
		var icn = Icons.class.getResource(path);
		try {
			var image = ImageIO.read(icn);
			data.put(path, new ImageData(image, 0));
		} catch (IOException ex1) {
		}
	}

	public static Image getImage(int index) {
		return getImageAt(index).image;
	}

	private static ImageData getImageAt(int index) {
		var values = data.values();
		if (index > 0 && index < values.size()) {
			for (var value : values) {
				if (value.index == index) {
					return value;
				}
			}
		}

		var path = "/misc/misc.png";
		return data.get(path);
	}

	private static class ImageData {

		public Image image;
		public int index;

		public ImageData(Image image, int index) {
			this.image = image;
			this.index = index;
		}
	}
}
