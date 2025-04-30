package org.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
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
		

		
		RTextScrollPane sp = new RTextScrollPane(textArea);
		sp.setLineNumbersEnabled(true); // Line numbers are enabled by default
		sp.setFoldIndicatorEnabled(true);
		sp.setIconRowHeaderEnabled(true);
		
		this.add(sp, BorderLayout.CENTER);
	}
	
}
