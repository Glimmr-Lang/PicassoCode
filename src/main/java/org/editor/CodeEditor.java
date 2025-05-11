package org.editor;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import org.editor.icons.Icons;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.CodeTemplateManager;
import org.fife.ui.rsyntaxtextarea.FileLocation;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TextEditorPane;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author hexaredecimal
 */
public class CodeEditor extends JPanel {

	public TextEditorPane textArea;
	public Path file = null;
	private boolean isTmp;

	public CodeEditor() {
		super(new BorderLayout());
		textArea = new TextEditorPane();
		textArea.setCodeFoldingEnabled(true);

		var atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		atmf.putMapping("text/piccode", "org.piccode.tokenmaker.PiccodeScriptTokenMaker");
		textArea.setSyntaxEditingStyle("text/piccode");
		textArea.setMarkOccurrences(true);
		RSyntaxTextArea.setTemplatesEnabled(true);
		// textArea.addParser(new EditorParser());		

		var provider = createCompletionProvider();
		AutoCompletion ac = new AutoCompletion(provider);
		ac.install(textArea);

		var sp = new RTextScrollPane(textArea);
		sp.setLineNumbersEnabled(true); // Line numbers are enabled by default
		sp.setFoldIndicatorEnabled(true);
		sp.setIconRowHeaderEnabled(true);

		var gutter = sp.getGutter();
		gutter.setBookmarkingEnabled(true);
		gutter.setBookmarkIcon(Icons.getIcon("bookmark"));

		try {
			var fp = File.createTempFile("piccasso-", "-tmp");
			file = fp.toPath();
			fp.deleteOnExit();
			isTmp = true;
		} catch (IOException ex) {
			Logger.getLogger(CodeEditor.class.getName()).log(Level.SEVERE, null, ex);
		}

		textArea
						.addCaretListener(e -> {
							getCursorPositionText(this);
						});

		this.add(sp, BorderLayout.CENTER);
	}

	public boolean saveFile() {
		if (isTmp) {
			return saveFileAs();
		}

		try {
			textArea.save();
			EditorWindow.current_file.setText("Written to " + file);
			return true;
		} catch (IOException e) {
			return saveFileAs();
		}
	}

	public boolean isIsTmp() {
		return isTmp;
	}

	public void setIsTmp(boolean isTmp) {
		this.isTmp = isTmp;
	}

	public boolean saveFileAs() {
		var fileChooser = new JFileChooser(".");
		int status = fileChooser.showSaveDialog(EditorWindow.win);
		if (status != JFileChooser.APPROVE_OPTION) {
			EditorWindow.current_file.setText("Save cancelled");
			return false;
		}
		var path = fileChooser.getSelectedFile();
		var loc = FileLocation.create(path);
		try {
			textArea.saveAs(loc);
			textArea.load(loc);
			file = path.toPath();
			getCursorPositionText(this);
			EditorWindow.current_file.setText("Written to " + path);
			return true;
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(EditorWindow.win, ex);
			return false;
		}
	}

	public static void getCursorPositionText(CodeEditor ed) {
		try {
			var textArea = ed.textArea;
			int caret = textArea.getCaretPosition();
			int line = textArea.getLineOfOffset(caret);
			int col = caret - textArea.getLineStartOffset(line);
			int lines = textArea.getLineCount();
			var ln_str = "Ln " + (line + 1) + ", Col " + (col + 1);
			var perc = (line / (double) lines) * 100;
			EditorWindow.current_file.setText(ed.file.toString());
			EditorWindow.line_info.setText(ln_str);
			var perc_str = perc == 100 ? "Bottom" : perc == 0 ? "Top" : String.format("%.0f%%", perc);
			EditorWindow.line_perc.setText(perc_str);
			EditorWindow.seekBar.setValue(Integer.parseInt(String.format("%.0f", perc)));
		} catch (BadLocationException e) {
			var ln_str = "Ln 1 Col 1";
			var perc_str = "00%";
			EditorWindow.line_info.setText(ln_str);
			EditorWindow.line_perc.setText(perc_str);
			EditorWindow.seekBar.setValue(0);
		}
	}

	public String filePathTruncated() {
		var path = file.toFile().getName();
		return (path.length() > 25) ? path + "..." : path;
	}

	private CompletionProvider createCompletionProvider() {

		DefaultCompletionProvider provider = new DefaultCompletionProvider();

		provider.setAutoActivationRules(true, ".");

		provider.addCompletion(new BasicCompletion(provider, "import"));
		provider.addCompletion(new BasicCompletion(provider, "function"));
		provider.addCompletion(new BasicCompletion(provider, "let`"));
		provider.addCompletion(new BasicCompletion(provider, "if"));
		provider.addCompletion(new BasicCompletion(provider, "else"));
		provider.addCompletion(new BasicCompletion(provider, "when"));
		provider.addCompletion(new BasicCompletion(provider, "is"));
		provider.addCompletion(new BasicCompletion(provider, "module"));

		provider.addCompletion(new ShorthandCompletion(provider, "mod", "module ModuleName {}"));
		provider.addCompletion(new ShorthandCompletion(provider, "ifelse", "if true { } else { }"));
		provider.addCompletion(new ShorthandCompletion(provider, "function", "function name() = 0"));
		provider.addCompletion(new ShorthandCompletion(provider, "import", "import mod"));
		provider.addCompletion(new ShorthandCompletion(provider, "pkg", "input pkg:"));
		provider.addCompletion(new ShorthandCompletion(provider, "when", "when true {}"));

		return provider;

	}

	public static void createTemplateManager() {
		CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();
		String[][] templates = {
			{"drawRect", "drawRect(x, y, w, h)"},
			{"drawOval", "drawOval(x, y, w, h)"},
			{"drawSquare", "drawSquare(x, y, side)"},
			{"drawString", "drawString(str, x, y)"},
			{"drawPolygon", "drawPolygon(xarray, yarray)"},
			{"drawPolyline", "drawPolyline(xarray, yarray)"},
			{"drawImage", "drawImage(id, x, y, w, h)"},
			{"color", "color(r, g, b)"},};
		for (var template : templates) {
			var ct = new StaticCodeTemplate(template[0], template[1], null);
			ctm.addTemplate(ct);
		}
	}
}
