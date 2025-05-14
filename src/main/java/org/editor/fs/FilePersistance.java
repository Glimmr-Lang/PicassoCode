package org.editor.fs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hexaredecimal
 */
public class FilePersistance {
	private static final List<String> EMPTY = new ArrayList<>();
	private static final String RECENT_FILES = "./etc/rf/xxx.yy";
	private static final String RECENT_PROJECTS = "./etc/rf/xxx.yy";

	public static List<String> getRecentFiles() {
		return getFiles(RECENT_FILES);
	}

	public static List<String> getRecentProjects() {
		return getFiles(RECENT_PROJECTS);
	}

	public static boolean isFilePersisted(Path path) {
		var name = path.toString();
		return getRecentFiles().contains(name);
	}

	public static boolean isProjectPersisted(Path path) {
		var name = path.toString();
		return getRecentFiles().contains(name);
	}

	public static void persistProject(Path path) {
		persistTo(path, RECENT_PROJECTS);
	}
	
	public static void persistFile(Path path) {
		persistTo(path, RECENT_PROJECTS);
	}

	
	private static void persistTo(Path path, String dir) {
		if (isFilePersisted(path)) {
			return;
		}
		var files = getRecentFiles();
		files.addFirst(path.toString());
		var dest = new File(dir).toPath();
		try {
			Files.write(dest, files);
		} catch (IOException ex) {
			Logger.getLogger(FilePersistance.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	private static List<String> getFiles(String file) {
		var fp = new File(file);

		
		if (!fp.exists()) {
			try {
				fp.createNewFile();
				return EMPTY;
			} catch (IOException ex) {
				return EMPTY;
			}
		}

		try {
			var contents = Files.readString(fp.toPath());
			var items = contents
				.lines()
				.limit(15) // TODO: Allow this to be customizable throw the settings
				.toList();
			var mutableList = new ArrayList<String>();
			items.forEach(item -> mutableList.add(item));
			return mutableList;
		} catch (IOException ex) {
			return EMPTY;
		}
	}
}
