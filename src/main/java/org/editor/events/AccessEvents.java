package org.editor.events;

import java.awt.event.ActionEvent;
import org.editor.AccessFrame;
import org.editor.EditorWindow;
import org.piccode.backend.Compiler;

/**
 *
 * @author hexaredecimal
 */
public class AccessEvents {

	public static void compileAndRender(ActionEvent e) {
		var ed = EditorWindow.getSelectedEditor();
		if (ed == null) {
			return;
		}
    var code  = ed.textArea.getText();
		AccessFrame.writeSuccess("Compilation started: ");
		Compiler.compile(code, true);
	}
	
	public static void compile(ActionEvent e) {
		var ed = EditorWindow.getSelectedEditor();
		if (ed == null) {
			return;
		}
    var code  = ed.textArea.getText();
		AccessFrame.writeSuccess("Compilation started: ");
		Compiler.compile(code, false);
	}
}
