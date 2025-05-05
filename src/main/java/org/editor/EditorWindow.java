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
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import org.editor.events.AppAction;
import org.editor.events.Events;
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
	
	public static JRootPane root = null;
	public EditorWindow() {
		super("Piccode - DashBoard");

		root = getRootPane();
		Icons.loadIcons();
		editor_panel = new CodeEditor();
		Events.loadActions();

		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}

		var width = 900;
		var height = 600;

		JPanel main_panel = new JPanel(new BorderLayout());

		Action[] app_actions = {
			Events.showFileTreeAction, 
			Events.searchAction, 
			Events.commitAction, 
			Events.exportAction,
			Events.AIAction, 
		};
		var side_panel = makeCoolbar(height, app_actions);
		
		main_panel.add(side_panel, BorderLayout.WEST);

		JSplitPane editor_split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		editor_split.setDividerLocation(width - 300);
		main_panel.add(editor_split, BorderLayout.CENTER);

		editor_split.setLeftComponent(editor_panel);

		JSplitPane canvas_split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		canvas_split.setDividerLocation(height - 250);
		editor_split.setRightComponent(canvas_split);

		var canvas_panel = CanvasFrame.the();
		JScrollPane scrollPane = new JScrollPane(canvas_panel);

		JPanel render_panel = new JPanel(new BorderLayout());
		
		Action[] render_actions = {
			Events.gridAction, 
			Events.pointAction, 
			Events.rulerAction, 
			Events.snapAction, 
			Events.brushAction, 
			Events.thickBrushAction, 
			Events.paintBucketAction, 
			Events.effectsAction, 
		};
		var short_cuts = makeCoolbar(canvas_panel.getHeight(), render_actions);
		render_panel.add(short_cuts, BorderLayout.EAST);
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


	private JPanel makeCoolbar(int height, Action ... actions) {
		JPanel cool_bar = new JPanel(new BorderLayout());
		cool_bar.setPreferredSize(new Dimension(50, height));
		JPanel top_buttons = new JPanel(new GridLayout(9, 1));
		top_buttons.setOpaque(false); // transparent to inherit background

		for (var action: actions) {
			JButton btn = new JButton(action);
			btn.setText("");
			top_buttons.add(btn);
		}

		JPanel bottom_button = new JPanel(new BorderLayout());
		bottom_button.setOpaque(false);

		JButton settingsBtn = new JButton("", Icons.getIcon("settings"));
		settingsBtn.setToolTipText("Settings");

		bottom_button.add(settingsBtn, BorderLayout.SOUTH);
		cool_bar.add(top_buttons, BorderLayout.NORTH);
		cool_bar.add(bottom_button, BorderLayout.SOUTH);
		return cool_bar;
	}
}
