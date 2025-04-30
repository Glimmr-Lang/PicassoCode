package org.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.editor.errors.EditorParser;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.RTextScrollPane;


/**
 *
 * @author hexaredecimal
 */
public class CodeEditor extends JPanel {

	public CodeEditor() {
		super(new BorderLayout());
		RSyntaxTextArea textArea = new RSyntaxTextArea();
		textArea.setCodeFoldingEnabled(true);
		
		AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		atmf.putMapping("text/piccode", "org.piccode.tokenmaker.PiccodeScriptTokenMaker");
		textArea.setSyntaxEditingStyle("text/piccode");
		textArea.addParser(new EditorParser());		

		CompletionProvider provider = createCompletionProvider();
		AutoCompletion ac = new AutoCompletion(provider);
		ac.install(textArea);
		
		RTextScrollPane sp = new RTextScrollPane(textArea);
		sp.setLineNumbersEnabled(true); // Line numbers are enabled by default
		sp.setFoldIndicatorEnabled(true);
		sp.setIconRowHeaderEnabled(true);
		
		this.add(sp, BorderLayout.CENTER);
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

		return provider;

	}
}
