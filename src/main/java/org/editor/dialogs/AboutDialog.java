package org.editor.dialogs;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.editor.icons.Icons;
import org.editor.panels.AboutPanel;

/**
 *
 * @author hexaredecimal
 */
public class AboutDialog extends JDialog {

	public AboutDialog(Frame owner) {
		super(owner, true);

		var center_panel = new JPanel(new BorderLayout());
		center_panel.add(new AboutPanel(), BorderLayout.CENTER);

		var okButton = new JButton(Icons.getIcon("cancel"));
		okButton.addActionListener(e -> this.dispose());
		var south_panel = new JPanel(new BorderLayout());
		south_panel.add(okButton, BorderLayout.EAST);
		south_panel.setBorder(new EmptyBorder(20, 40, 20, 40));

		center_panel.add(south_panel, BorderLayout.SOUTH);
		this.add(center_panel);

		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
}
