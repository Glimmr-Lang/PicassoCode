package org.editor.events;

import java.time.LocalDateTime;
import javax.swing.JTextArea;
import org.editor.EditorWindow;
import org.piccode.backend.Compiler;

/**
 *
 * @author hexaredecimal
 */
public class AccessEvents {

	public static void compile(JTextArea msgs) {
		var app = EditorWindow.the();
		var code = app.getSelectedEditor().textArea.getText();

		msgs.setText("Compilation started: " + LocalDateTime.now());
		Compiler.compile(code, msgs);
	}
}
