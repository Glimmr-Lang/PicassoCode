package org.editor;

import org.editor.events.Events;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.editor.events.AccessEvents;
import org.editor.icons.Icons;

/**
 *
 * @author hexaredecimal
 */
public class AccessFrame extends JPanel {

	public static JTextArea msgs;
	
	public AccessFrame(int width) {
		super(new BorderLayout());

		// Add horizontal button bar to the top
		this.add(getAccessBar(), BorderLayout.NORTH);

		// Create scrollable text area
		msgs = new JTextArea();
		msgs.setLineWrap(true);
		msgs.setWrapStyleWord(true);
		var scroll = new JScrollPane(msgs);
		this.add(scroll, BorderLayout.CENTER);
	}

	private Component getAccessBar() {
		JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Horizontal layout

		Action[] actions = {Events.compileAction, Events.commitAction, Events.commitAction, Events.exportAction};
		
		for (var action: actions) {
			JButton btn = new JButton(action);
			btn.setText("");
			buttonBar.add(btn);
		}

		return buttonBar;
	}

}
