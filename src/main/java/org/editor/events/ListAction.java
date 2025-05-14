package org.editor.events;

/**
 *
 * @author hexaredecimal
 */
import java.awt.event.*;
import javax.swing.*;


// Reference: https://stackoverflow.com/questions/4344682/double-click-event-on-jlist-element
public class ListAction implements MouseListener {

	private static final KeyStroke ENTER = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

	private JList list;
	private KeyStroke keyStroke;

	/*
     *  Add an Action to the JList bound by the default KeyStroke
	 */
	public ListAction(JList list, Action action) {
		this(list, action, ENTER);
	}

	/*
     *  Add an Action to the JList bound by the specified KeyStroke
	 */
	public ListAction(JList list, Action action, KeyStroke keyStroke) {
		this.list = list;
		this.keyStroke = keyStroke;

		//  Add the KeyStroke to the InputMap
		InputMap im = list.getInputMap();
		im.put(keyStroke, keyStroke);

		//  Add the Action to the ActionMap
		setAction(action);

		//  Handle mouse double click
		list.addMouseListener(this);
	}

	/*
     *  Add the Action to the ActionMap
	 */
	public void setAction(Action action) {
		list.getActionMap().put(keyStroke, action);
	}

	//  Implement MouseListener interface
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Action action = list.getActionMap().get(keyStroke);

			if (action != null) {
				ActionEvent event = new ActionEvent(
								list,
								ActionEvent.ACTION_PERFORMED,
								"");
				action.actionPerformed(event);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
