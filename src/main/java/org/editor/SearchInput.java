package org.editor;

/**
 *
 * @author hexaredecimal
 */

import javax.swing.*;
import java.awt.*;

public class SearchInput extends JTextField {

	private String placeholder;

	public SearchInput(String placeholder, int columns) {
		super(columns);
		this.setToolTipText("Search...");
		this.placeholder = placeholder;
		setOpaque(false); // Optional: allows background painting if needed
	}

	public void setPlaceholder(String text) {
		this.placeholder = text;
		repaint();
	}

	public String getPlaceholder() {
		return this.placeholder;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (getText().isEmpty() && !isFocusOwner()) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setFont(getFont().deriveFont(Font.ITALIC));
			g2.setColor(Color.GRAY);

			Insets insets = getInsets();
			int padding = (getHeight() - getFont().getSize()) / 2 + getFont().getSize() - 2;

			g2.drawString(placeholder, insets.left + 2, padding);
			g2.dispose();
		}
	}
}

