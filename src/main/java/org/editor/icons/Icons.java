package org.editor.icons;

import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author hexaredecimal
 */
public class Icons {
		private static String[] icons = {
			"about",
			"add",
			"add-file",
			"add-row",
			"add-property",
			"appicon",
			"automatic",
			"book",
			"bookmark",
			"brush",
			"brush-fat",
			"cancel",
			"chatbot",
			"clear-symbol",
			"close",
			"code-file", 
			"code-folder",
			"color",
			"compare-git",
			"copy-to-clipboard",
			"cut",
			"delete-document",
			"delete-file",
			"delete-folder",
			"delete-row",
			"delete-trash",
			"edit-property",
			"edit-file",
			"edit-property",
			"exit", 
			"export",
			"file",
			"find",
			"find-and-replace",
			"folder",
			"folder-tree",
			"graph",
			"grid",
			"group-objects",
			"hot-article",
			"image-file",
			"layout",
			"license",
			"line",
			"logout",
			"navigation-toolbar-bottom",
			"navigation-toolbar-left",
			"navigation-toolbar-top",
			"new-window",
			"open-in-browser",
			"options",
			"paint",
			"paint-bucket",
			"paint-palete",
			"paste",
			"panorama",
			"pi",
			"plugin",
			"point",
			"project-setup",
			"redo",
			"remove",
			"rename",
			"restore-page",
			"restore-window",
			"right-navigation-toolbar",
			"ruler",
			"run",
			"save",
			"save-all",
			"save-as",
			"save-close",
			"search",
			"select-all",
			"settings",
			"shortcut",
			"show-property",
			"sigma",
			"software-installer",
			"store",
			"pointer",
			"system-task",
			"time-machine",
			"tools",
			"undo",
			"visual-effects",
			"xxx-folder"
		};
	
	private static HashMap<String, ImageIcon> map= new HashMap<>();
	
	public static void loadIcons() {
		for (var icon: icons) {
			var path = String.format("/icons/%s.png", icon);
			var icn = Icons.class.getResource(path);
			if (map.containsKey(icon)) {
				System.err.println("Icon " + icon + " is alread loaded. Skipping");
				continue;
			}

			if (icn == null) {
				map.put(icon, null);
				continue;
			}
			var _icon = new ImageIcon(icn);
			map.put(icon, _icon);
			System.err.println("Icon " + icon + " loaded successfully [" + path + "]");
		}
	}

	public static ImageIcon getIcon(String icon) {
		var ico = map.get(icon);
		if (ico == null) {
			// return the first available
			for (var kv: map.entrySet()) {
				return kv.getValue();
			}
		}
		return ico;
	}
}
