package org.editor.fs;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hexaredecimal
 */
public class FileFilter {
	public static final FileNameExtensionFilter picsFilter = new FileNameExtensionFilter("Piccasso Script Files", "pics");
	public static final FileNameExtensionFilter mdFilter = new FileNameExtensionFilter("Markdown Files", "md");
	public static final FileNameExtensionFilter allFilter = new FileNameExtensionFilter("All Files (*.*)", "*");
}
