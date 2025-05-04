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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import org.editor.icons.Icons;
import org.editor.menu.Menus;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RecordableTextAction;

/**
 *
 * @author hexaredecimal
 */
public class EditorWindow extends JFrame {

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

		Icons.loadIcons();
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
		var icons = List.of("folder-tree", "search", "compare-git", "export", "chatbot");
		for (int index = 0; index < icons.size(); index++) {
			var icon = Icons.getIcon(icons.get(index));
			JButton btn = new JButton(icon);
			btn.setToolTipText("Tool: " + tooltips[index]); // Tooltip
			top_buttons.add(btn);
		}

// Bottom settings button
		JPanel bottom_button = new JPanel(new BorderLayout());
		bottom_button.setOpaque(false);

		JButton settingsBtn = new JButton(Icons.getIcon("settings"));
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

		var canvas_panel = CanvasFrame.the();
		JScrollPane scrollPane = new JScrollPane(canvas_panel);

		JPanel render_panel = new JPanel(new BorderLayout());
		render_panel.add(makeCoolbar(canvas_panel.getHeight()), BorderLayout.EAST);
		render_panel.add(scrollPane, BorderLayout.CENTER);
		canvas_split.setLeftComponent(render_panel);

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


	private JPanel makeCoolbar(int height) {
		JPanel cool_bar = new JPanel(new BorderLayout());
		cool_bar.setPreferredSize(new Dimension(50, height));

// Top button group
		JPanel top_buttons = new JPanel(new GridLayout(9, 1));
		top_buttons.setOpaque(false); // transparent to inherit background

		String[] icons = {"grid", "point", "ruler", "add-row","paint", "brush", "brush-fat", "paint-bucket", "visual-effects"};
		String[] tooltips = {"toggle grid", "toggle point", "toggle ruler", "toggle snap","paint", "brush", "thick bruch", "bucket-tool", "effects"};
		for (int index = 0; index < tooltips.length; index++) {
			var icon = Icons.getIcon(icons[index]);
			JButton btn = new JButton(icon);
			btn.setToolTipText(tooltips[index]); // Tooltip
			if (tooltips[index].equals("toggle point")) {
				btn.addActionListener(a -> {
					CanvasFrame.the().showHighlight = !CanvasFrame.the().showHighlight;
				});
			}
			if (tooltips[index].equals("toggle ruler")) {
				btn.addActionListener(a -> {
					CanvasFrame.the().showRuler = !CanvasFrame.the().showRuler;
				});
			}

			if (tooltips[index].equals("toggle grid")) {
				btn.addActionListener(a -> {
					CanvasFrame.the().showGrid = !CanvasFrame.the().showGrid;
				});
			}
			if (tooltips[index].equals("toggle snap")) {
				btn.addActionListener(a -> {
					CanvasFrame.the().snapToGrid = !CanvasFrame.the().snapToGrid;
				});
			}
			top_buttons.add(btn);
		}

// Bottom settings button
		JPanel bottom_button = new JPanel(new BorderLayout());
		bottom_button.setOpaque(false);

		JButton settingsBtn = new JButton("", Icons.getIcon("settings"));
		settingsBtn.setToolTipText("Settings");

		bottom_button.add(settingsBtn, BorderLayout.SOUTH);

// Add top and bottom parts to cool_bar
		cool_bar.add(top_buttons, BorderLayout.NORTH);
		cool_bar.add(bottom_button, BorderLayout.SOUTH);

		return cool_bar;
	}


}
