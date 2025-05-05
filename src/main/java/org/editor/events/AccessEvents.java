package org.editor.events;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.Action;
import javax.swing.JTextArea;
import org.editor.AccessFrame;
import org.editor.EditorWindow;
import org.editor.icons.Icons;
import org.editor.util.It;
import org.piccode.backend.Compiler;

/**
 *
 * @author hexaredecimal
 */
public class AccessEvents {

	public static void compile(JTextArea msgs) {
		var app = EditorWindow.the();
		var code = app.editor_panel.textArea.getText();

		msgs.setText("Compilation started: " + LocalDateTime.now());
		Compiler.compile(code, msgs);
	}
}
