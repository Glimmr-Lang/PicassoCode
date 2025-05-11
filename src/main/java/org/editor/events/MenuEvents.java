package org.editor.events;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import org.editor.CodeEditor;
import org.editor.EditorWindow;
import org.editor.dialogs.AboutDialog;
import org.fife.rsta.ui.GoToDialog;
import org.fife.ui.rsyntaxtextarea.FileLocation;

/**
 *
 * @author hexaredecimal
 */
public class MenuEvents {

	public static void gotoLineEvent(ActionEvent e) {
		var findDialog = EditorWindow.findDialog;
		var replaceDialog = EditorWindow.replaceDialog;
		if (findDialog.isVisible()) {
			findDialog.setVisible(false);
		}
		if (replaceDialog.isVisible()) {
			replaceDialog.setVisible(false);
		}
		GoToDialog dialog = new GoToDialog(EditorWindow.win);
		var textArea = EditorWindow.getSelectedEditor().textArea;
		dialog.setMaxLineNumberAllowed(textArea.getLineCount());
		dialog.setVisible(true);
		int line = dialog.getLineNumber();
		if (line > 0) {
			try {
				textArea.setCaretPosition(textArea.getLineStartOffset(line - 1));
			} catch (BadLocationException ble) { // Never happens
				UIManager.getLookAndFeel().provideErrorFeedback(textArea);
				ble.printStackTrace();
			}
		}
	}

	static void replaceEvent(ActionEvent e) {
		var replaceDialog = EditorWindow.replaceDialog;
		var findDialog = EditorWindow.findDialog;
		if (findDialog.isVisible()) {
			findDialog.setVisible(false);
		}
		replaceDialog.setVisible(true);
	}

	static void findEvent(ActionEvent e) {
		var replaceDialog = EditorWindow.replaceDialog;
		var findDialog = EditorWindow.findDialog;
		if (replaceDialog.isVisible()) {
			replaceDialog.setVisible(false);
		}
		findDialog.setVisible(true);
	}
	
	public static void aboutDialog(ActionEvent e) {
		var _ = new AboutDialog(EditorWindow.win);
	}

	public static void closeTab(ActionEvent e) {
		EditorWindow.removeTab();
	}
	
	public static void closeAllTabs(ActionEvent e) {
		EditorWindow.removeAllTabs();
	}

	static void openFile(ActionEvent e) {
		// TODO: Use the System object to get the current pwd
		var fileChooser = new JFileChooser(".");
		int status = fileChooser.showOpenDialog(EditorWindow.win);
		if (status != JFileChooser.APPROVE_OPTION) {
			return;
		}

		var fp = fileChooser.getSelectedFile();
		var path = fp.toPath();
		try {
			EditorWindow.addTab(path, null);
			var loc = FileLocation.create(fp);
			var ed = EditorWindow.getSelectedEditor();
			ed.setIsTmp(false);
			ed.textArea.load(loc);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(EditorWindow.win, ex);
		}
	}

	static void saveFile(ActionEvent e) {
			if (EditorWindow.tabsCount() == 1) {
				return;
			}
			var ed = EditorWindow.getSelectedEditor();
			ed.saveFile();
	}
	
	static void saveFileAs(ActionEvent e) {
			if (EditorWindow.tabsCount() == 1) {
				return;
			}
			var ed = EditorWindow.getSelectedEditor();
			ed.saveFileAs();
	}

	static void closeFile(ActionEvent e) {
		closeTab(e);
	}

	static void quit(ActionEvent e) {
		closeAllTabs(e);
		System.exit(0);
	}
}
