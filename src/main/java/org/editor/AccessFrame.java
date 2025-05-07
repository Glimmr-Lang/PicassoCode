package org.editor;

import org.editor.events.Actions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author hexaredecimal
 */
public class AccessFrame extends JPanel {

	public static JTextPane msgs;
	
	public AccessFrame(int width) {
		super(new BorderLayout());

		this.add(getAccessBar(), BorderLayout.NORTH);

		msgs = new JTextPane();
		msgs.setEditable(false);
		msgs.setBackground(Color.BLACK);
		var scroll = new JScrollPane(msgs);
		this.add(scroll, BorderLayout.CENTER);
	}

	public static void writeError(String text) {
		StyledDocument doc = msgs.getStyledDocument();
		Style redStyle = (Style) doc.addStyle("RedStyle", null);
		StyleConstants.setForeground((MutableAttributeSet) redStyle, Color.RED);
		StyleConstants.setBackground((MutableAttributeSet) redStyle, new Color(255,0,0, 255/9));
		var line = getPaddedLine(text);
		try {
			doc.insertString(doc.getLength(), "[ERROR]: " + line, redStyle);
		} catch (BadLocationException ex) {
			Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void writeWarning(String text) {
		StyledDocument doc = msgs.getStyledDocument();
		Style orangeStyle = (Style) doc.addStyle("OrangeStyle", null);
		StyleConstants.setForeground((MutableAttributeSet) orangeStyle, Color.ORANGE);
		StyleConstants.setBackground((MutableAttributeSet) orangeStyle, new Color(237,150,52, 255/6));
		var line = getPaddedLine(text);
		try {
			doc.insertString(doc.getLength(),"[WARNING]: " + line, orangeStyle);
		} catch (BadLocationException ex) {
			Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void writeSuccess(String text) {
		StyledDocument doc = msgs.getStyledDocument();
		Style greenStyle = (Style) doc.addStyle("GreenStyle", null);
		StyleConstants.setForeground((MutableAttributeSet) greenStyle, Color.GREEN);
		StyleConstants.setBackground((MutableAttributeSet) greenStyle, new Color(0,255,0, 255/14));
		var line = getPaddedLine(text);
		try {
			doc.insertString(doc.getLength(), "[SUCCESS]: " + line, greenStyle);
		} catch (BadLocationException ex) {
			Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void writeString(String text) {
		StyledDocument doc = msgs.getStyledDocument();
		Style greenStyle = (Style) doc.addStyle("GreenStyle", null);
		StyleConstants.setForeground((MutableAttributeSet) greenStyle, Color.GREEN);
		StyleConstants.setBackground((MutableAttributeSet) greenStyle, new Color(0,255,0, 255/14));
		var line = getPaddedLine(text);
		try {
			doc.insertString(doc.getLength(), "[LOG]: " + line, greenStyle);
		} catch (BadLocationException ex) {
			Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void writeLines(String... text) {
		for (var line: text){
			writeString(line);
		}
	}

	private static String getPaddedLine(String text) {
		/*
		FontMetrics fm = msgs.getFontMetrics(msgs.getFont());
		int charWidth = fm.charWidth(' ');

		// Fudge factor to account for borders/padding/scrollbar
		int fudgePixels = 20;
		int charsPerLine = (msgs.getWidth() - fudgePixels) / charWidth;

		// Clip text if it's longer than one line
		String base = text.length() > charsPerLine
						? text.substring(0, charsPerLine - 3) + "..."
						: text;

		int paddingLength = Math.max(0, charsPerLine - base.length());
		return base + " ".repeat(paddingLength) + "\n";
	*/
		return text + "\n";
	}


	private Component getAccessBar() {
		JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Horizontal layout

		Action[] actions = {Actions.compileAction, Actions.renderAction, Actions.commitAction, Actions.exportAction};
		
		for (var action: actions) {
			JButton btn = new JButton(action);
			btn.setText("");
			buttonBar.add(btn);
		}

		return buttonBar;
	}

}
