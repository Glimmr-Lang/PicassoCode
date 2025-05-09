package org.editor.events;


import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import org.editor.EditorWindow;
import org.editor.dialogs.AboutDialog;
import org.fife.rsta.ui.GoToDialog;

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
}
