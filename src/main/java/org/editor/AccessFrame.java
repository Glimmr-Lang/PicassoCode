package org.editor;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;
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

import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;

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
		StyleConstants.setBackground((MutableAttributeSet) redStyle, new Color(255, 0, 0, 255 / 9));
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
		StyleConstants.setBackground((MutableAttributeSet) orangeStyle, new Color(237, 150, 52, 255 / 6));
		var line = getPaddedLine(text);
		try {
			doc.insertString(doc.getLength(), "[WARNING]: " + line, orangeStyle);
		} catch (BadLocationException ex) {
			Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void writeSuccess(String text) {
		StyledDocument doc = msgs.getStyledDocument();
		Style greenStyle = (Style) doc.addStyle("GreenStyle", null);
		StyleConstants.setForeground((MutableAttributeSet) greenStyle, Color.GREEN);
		StyleConstants.setBackground((MutableAttributeSet) greenStyle, new Color(0, 255, 0, 255 / 14));
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
		StyleConstants.setBackground((MutableAttributeSet) greenStyle, new Color(0, 255, 0, 255 / 14));
		var line = getPaddedLine(text);
		try {
			doc.insertString(doc.getLength(), "[LOG]: " + line, greenStyle);
		} catch (BadLocationException ex) {
			Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void writeLines(String... text) {
		for (var line : text) {
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

		for (var action : actions) {
			JButton btn = new JButton(action);
			btn.setText("");
			buttonBar.add(btn);
		}

		return buttonBar;
	}

	public static class AccessFrameOutputStream extends OutputStream {

		public static final PrintStream out = new PrintStream(new AccessFrameOutputStream(), true, StandardCharsets.UTF_8);

		private final StringBuilder buffer = new StringBuilder();
		private static final Pattern ANSI_PATTERN = Pattern.compile("\u001B\\[([\\d;]*)m");

		private AttributeSet activeStyle = defaultStyle();  // actual style to use
		private boolean useDefault = true;                  // if true, keep using defaultStyle

		@Override
		public void write(int b) {
			if (b == '\n') {
				flushBuffer();
			} else {
				buffer.append((char) b);
			}
		}

		@Override
		public void write(byte[] b, int off, int len) {
			buffer.append(new String(b, off, len, StandardCharsets.UTF_8));
			if (buffer.toString().endsWith("\n")) {
				flushBuffer();
			}
		}

		@Override
		public void flush() {
			flushBuffer();
		}

		private void flushBuffer() {
			String raw = buffer.toString();
			buffer.setLength(0);

			SwingUtilities.invokeLater(() -> {
				Matcher matcher = ANSI_PATTERN.matcher(raw);
				int last = 0;

				while (matcher.find()) {
					if (matcher.start() > last) {
						String text = raw.substring(last, matcher.start());
						append(text, activeStyle);
					}

					// Update current style
					String codeStr = matcher.group(1);
					if (codeStr.isEmpty() || codeStr.equals("0")) {
						activeStyle = defaultStyle();
						useDefault = true;
					} else {
						activeStyle = parseAnsiCode(codeStr);
						useDefault = false;
					}

					last = matcher.end();
				}

				if (last < raw.length()) {
					String text = raw.substring(last);
					append(text, activeStyle);
				}
			});
		}

		private void append(String text, AttributeSet style) {
			try {
				StyledDocument doc = msgs.getStyledDocument();
				doc.insertString(doc.getLength(), text, style);
				msgs.setCaretPosition(doc.getLength());
			} catch (BadLocationException ex) {
				Logger.getLogger(AccessFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		private AttributeSet parseAnsiCode(String codeStr) {
			SimpleAttributeSet attrs = new SimpleAttributeSet();

			String[] codes = codeStr.split(";");
			for (String part : codes) {
				int code;
				try {
					code = Integer.parseInt(part);
				} catch (NumberFormatException e) {
					continue;
				}

				// Reset handled in flushBuffer, we don't return early here
				if (ansiColorMap.containsKey(code)) {
					StyleConstants.setForeground(attrs, ansiColorMap.get(code));
				} else {
					StyleConstants.setForeground(attrs, Color.WHITE);
				}
			}

			// Set default background every time
			StyleConstants.setBackground(attrs, Color.BLACK);

			return attrs;
		}

		private static AttributeSet defaultStyle() {
			SimpleAttributeSet def = new SimpleAttributeSet();
			StyleConstants.setForeground(def, Color.WHITE);
			StyleConstants.setBackground(def, Color.BLACK);
			return def;
		}

		private static final Map<Integer, Color> ansiColorMap = new HashMap<>();

		static {
			ansiColorMap.put(30, Color.BLACK);
			ansiColorMap.put(31, Color.RED);
			ansiColorMap.put(32, Color.GREEN);
			ansiColorMap.put(33, Color.YELLOW);
			ansiColorMap.put(34, Color.BLUE);
			ansiColorMap.put(35, Color.MAGENTA);
			ansiColorMap.put(36, Color.CYAN);
			ansiColorMap.put(37, Color.LIGHT_GRAY);
			ansiColorMap.put(90, Color.DARK_GRAY);
			ansiColorMap.put(91, new Color(255, 85, 85));
			ansiColorMap.put(92, new Color(80, 255, 80));
			ansiColorMap.put(93, new Color(255, 255, 85));
			ansiColorMap.put(94, new Color(85, 85, 255));
			ansiColorMap.put(95, new Color(255, 85, 255));
			ansiColorMap.put(96, new Color(85, 255, 255));
			ansiColorMap.put(97, Color.WHITE);
		}
	}

}
