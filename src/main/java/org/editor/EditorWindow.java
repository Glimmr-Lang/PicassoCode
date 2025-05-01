package org.editor;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import org.editor.menu.Menus;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RecordableTextAction;

/**
 *
 * @author hexaredecimal
 */
public class EditorWindow extends JFrame {

	private static final List<ImageIcon> icons = List.of(
					new ImageIcon(EditorWindow.class.getResource("/icons/files.png")),
					new ImageIcon(EditorWindow.class.getResource("/icons/search.png")),
					new ImageIcon(EditorWindow.class.getResource("/icons/git.png")),
					new ImageIcon(EditorWindow.class.getResource("/icons/export.png")),
					new ImageIcon(EditorWindow.class.getResource("/icons/ai.png")),
					new ImageIcon(EditorWindow.class.getResource("/icons/settings.png"))
	);

	public CodeEditor editor_panel;
	private static EditorWindow win = null;

	public static EditorWindow the() {
		if (win == null) {
			win = new EditorWindow();
		}
		return win;
	}
	
	public EditorWindow() {
		super("Piccode - DashBoard");

		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}

		var width = 900;
		var height = 600;

		JPanel main_panel = new JPanel(new BorderLayout());

		JPanel cool_bar = new JPanel(new BorderLayout());
		cool_bar.setPreferredSize(new Dimension(50, height));

// Top button group
		JPanel top_buttons = new JPanel(new GridLayout(5, 1));
		top_buttons.setOpaque(false); // transparent to inherit background

		String[] tooltips = {"Show File tree", "Search...", "Use git", "Export to png", "Use a LLM"};
		for (int index = 0; index < icons.size() - 1; index++) {
			var icon = icons.get(index);
			JButton btn = new JButton(icon);
			btn.setToolTipText("Tool: " + tooltips[index]); // Tooltip
			top_buttons.add(btn);
		}

// Bottom settings button
		JPanel bottom_button = new JPanel(new BorderLayout());
		bottom_button.setOpaque(false);

		JButton settingsBtn = new JButton(icons.getLast());
		settingsBtn.setToolTipText("Settings");

		bottom_button.add(settingsBtn, BorderLayout.SOUTH);

// Add top and bottom parts to cool_bar
		cool_bar.add(top_buttons, BorderLayout.NORTH);
		cool_bar.add(bottom_button, BorderLayout.SOUTH);

		main_panel.add(cool_bar, BorderLayout.WEST);

		JSplitPane editor_split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		editor_split.setDividerLocation(width - 300);
		main_panel.add(editor_split, BorderLayout.CENTER);

		editor_panel = new CodeEditor();
		editor_split.setLeftComponent(editor_panel);

		JSplitPane canvas_split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		canvas_split.setDividerLocation(height - 250);
		editor_split.setRightComponent(canvas_split);

		var canvas_panel = new CanvasFrame();
		canvas_split.setLeftComponent(canvas_panel);

		var access_panel = new AccessFrame(width);
		canvas_split.setRightComponent(access_panel);

		JMenuBar menu_bar = new JMenuBar();
		this.setJMenuBar(menu_bar);

		Menus.addMenus(menu_bar);

		this.add(main_panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}



}
