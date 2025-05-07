package org.editor;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import org.editor.events.Actions;
import org.editor.icons.Icons;
import org.editor.menu.Menus;

import org.fife.rsta.ui.CollapsibleSectionPanel;
//import org.fife.rsta.ui.DocumentMap;
import org.fife.rsta.ui.GoToDialog;
import org.fife.rsta.ui.SizeGripIcon;
import org.fife.rsta.ui.search.FindDialog;
import org.fife.rsta.ui.search.ReplaceDialog;
import org.fife.rsta.ui.search.ReplaceToolBar;
import org.fife.rsta.ui.search.SearchEvent;
import org.fife.rsta.ui.search.SearchListener;
import org.fife.rsta.ui.search.FindToolBar;
import org.fife.ui.rsyntaxtextarea.ErrorStrip;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;
import org.fife.ui.rtextarea.SearchResult;

/**
 *
 * @author hexaredecimal
 */
public final class EditorWindow extends JFrame implements SearchListener{

	private static JTabbedPane tabs = new JTabbedPane();
	private static HashMap<Integer, CodeEditor> tabEditors;
	public static EditorWindow win = null;
	public static JLabel current_file = new JLabel();
	public static JLabel line_info = new JLabel();
	public static JLabel line_perc = new JLabel();
	public static JLabel charset = new JLabel();
	public static JProgressBar seekBar = new JProgressBar();

	private CollapsibleSectionPanel csp;
	public static FindDialog findDialog;
	public static ReplaceDialog replaceDialog;
	

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
		tabs = new JTabbedPane();
		tabEditors = new HashMap<>();
		addTab(null);
		addPlusTab(tabs);
		Actions.loadActions();
		initSearchDialogs();

		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}

		var width = 900;
		var height = 600;

		JPanel main_panel = new JPanel(new BorderLayout());

		Action[] app_actions = {
			Actions.showFileTreeAction,
			Actions.searchAction,
			Actions.commitAction,
			Actions.exportAction,
			Actions.AIAction,
			Actions.communityAction,
			Actions.pluginsAction,};
		var side_panel = makeCoolbar(height, app_actions);

		main_panel.add(side_panel, BorderLayout.WEST);

		JSplitPane editor_split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		editor_split.setDividerLocation(width - 300);

		var pluginSpace = new JPanel();
		JSplitPane plugin_split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		plugin_split.setLeftComponent(editor_split);
		plugin_split.setDividerLocation(width - 100);
		plugin_split.setRightComponent(pluginSpace);
		main_panel.add(plugin_split, BorderLayout.CENTER);

		editor_split.setLeftComponent(tabs);

		JSplitPane canvas_split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		canvas_split.setDividerLocation(height - 250);
		editor_split.setRightComponent(canvas_split);

		var canvas_panel = CanvasFrame.the();
		JScrollPane scrollPane = new JScrollPane(canvas_panel);

		JPanel render_panel = new JPanel(new BorderLayout());

		Action[] render_actions = {
			Actions.normalAction,
			Actions.gridAction,
			Actions.pointAction,
			Actions.rulerAction,
			Actions.snapAction,
			Actions.brushAction,
			Actions.thickBrushAction,
			Actions.paintBucketAction,
			Actions.effectsAction,};
		var short_cuts = makeCoolbar(canvas_panel.getHeight(), render_actions);
		short_cuts.setBorder(BorderFactory.createEmptyBorder());
		render_panel.add(short_cuts, BorderLayout.EAST);
		render_panel.add(scrollPane, BorderLayout.CENTER);
		canvas_split.setLeftComponent(render_panel);

		var access_panel = new AccessFrame(width);
		canvas_split.setRightComponent(access_panel);

		JMenuBar menu_bar = new JMenuBar();
		this.setJMenuBar(menu_bar);

		Menus.addMenus(menu_bar);

		Action[] tool_actions = {
			Actions.newProjectAction,
			Actions.newFileAction,
			Actions.openFileAction,
			Actions.openProjectAction,
			null,
			Actions.saveAction,
			Actions.saveAsAction,
			Actions.saveAllAction,
			null,
			Actions.undoAction,
			Actions.redoAction,
			Actions.copyAction,
			Actions.cutAction,
			Actions.pasteAction,
			null,
			Actions.compileAction,
			Actions.renderAction,
			null,
			Actions.exportAction,
			Actions.exitAction,
			null,
			Actions.normalAction,
			Actions.gridAction,
			Actions.pointAction,
			Actions.rulerAction,
			Actions.snapAction,
			Actions.brushAction,
			Actions.thickBrushAction,
			Actions.paintBucketAction,
			Actions.effectsAction,
			null,
			Actions.docsAction,
			Actions.websiteAction,
			Actions.aboutAction
		};

		var tool_bar = makeToolBar(tool_actions);
		main_panel.add(tool_bar, BorderLayout.PAGE_START);

		current_file = new JLabel();
		line_info = new JLabel();
		line_perc = new JLabel();
		charset = new JLabel();
		seekBar = new JProgressBar();
		seekBar.setValue(50);

		var file = getSelectedEditor().file;

		if (file != null) {
			current_file.setText(file.getName());
		} else {
			current_file.setText("[NONE]");
		}
		
		var bottom_bar = makeLRToolBar(new Component[]{
			current_file,
			null
		}, new Component[]{
			line_info,
			line_perc,
			seekBar,
			null,
			charset,
		});
		main_panel.add(bottom_bar, BorderLayout.PAGE_END);
		
		tabs.addChangeListener(c -> {
			var ed = getSelectedEditor();
			if (ed == null) {
				return;
			}
			CodeEditor.getCursorPositionText(ed.textArea);
		});
		
		this.add(main_panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initSearchDialogs() {
		findDialog = new FindDialog(this, this);
		replaceDialog = new ReplaceDialog(this, this);

		SearchContext context = findDialog.getSearchContext();
		replaceDialog.setSearchContext(context);
	}
	public static void addTab(ActionEvent e) {
		var index = tabs.getTabCount();
		var editor = new CodeEditor();
		if (index > 0) {
			tabs.remove(index - 1);
			index = tabs.getTabCount();
		}
		tabEditors.put(index, editor);
		tabs.addTab("", editor);
		tabs.setTabComponentAt(tabs.getTabCount() - 1, makeTabHeader(tabs, editor.file == null ? "Tab " + index : editor.file.getName()));
		if (index > 0) addPlusTab(tabs);
	}

	public static CodeEditor getSelectedEditor() {
		int index = tabs.getSelectedIndex();
		return tabEditors.get(index);
	}

	private static void addPlusTab(JTabbedPane tabs) {
		var editor = new CodeEditor(); // will never be shown
		tabs.addTab("", editor);

		JButton plusBtn = new JButton();
		plusBtn.setIcon(Icons.getIcon("add"));
		plusBtn.setMargin(new Insets(0, 8, 0, 8));
		plusBtn.setBorder(BorderFactory.createEmptyBorder());
		plusBtn.setContentAreaFilled(false);
		plusBtn.setFocusPainted(false);
		plusBtn.addActionListener(EditorWindow::addTab);
		tabs.setTabComponentAt(tabs.getTabCount() - 1, plusBtn);
	}

	private static Component makeTabHeader(JTabbedPane tabs, String title) {
		JPanel tabHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		tabHeader.setOpaque(false);

		JLabel titleLabel = new JLabel(title + " ");
		JButton closeButton = new JButton(Icons.getIcon("close"));

		closeButton.setMargin(new Insets(0, 5, 0, 5));
		closeButton.setFocusable(false);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setOpaque(false);
		closeButton.setForeground(Color.RED);
		closeButton.setFont(closeButton.getFont().deriveFont(Font.BOLD, 12));

		closeButton.addActionListener(e -> {
			int index = tabs.indexOfTabComponent(tabHeader);
			if (index != -1) {
				tabEditors.remove(index);
				tabs.remove(index);
			}
		});

		tabHeader.add(titleLabel);
		tabHeader.add(closeButton);

		return tabHeader;
	}

	private JPanel makeCoolbar(int height, Action... actions) {
		JPanel cool_bar = new JPanel(new BorderLayout());
		cool_bar.setPreferredSize(new Dimension(50, height));
		JPanel top_buttons = new JPanel(new GridLayout(10, 1));
		top_buttons.setOpaque(false); // transparent to inherit background

		for (var action : actions) {
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

	private JToolBar makeToolBar(Action... actions) {
		JToolBar cool_bar = new JToolBar();
		for (var action : actions) {
			if (action == null) {
				var sep = new JSeparator(JSeparator.VERTICAL);
				cool_bar.add(sep);
				continue;
			}
			JButton btn = new JButton(action);
			btn.setText("");
			cool_bar.add(btn);
		}
		return cool_bar;
	}

	private JToolBar makeLRToolBar(Component[] llbls, Component[] rlbls) {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setLayout(new BorderLayout());

		// LEFT panel
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		for (var lbl : llbls) {
			if (lbl == null) {
				leftPanel.add(new JSeparator(SwingConstants.VERTICAL));
			} else {
				leftPanel.add(lbl);
			}
		}

		// RIGHT panel
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		for (var lbl : rlbls) {
			if (lbl == null) {
				rightPanel.add(new JSeparator(SwingConstants.VERTICAL));
			} else {
				rightPanel.add(lbl);
			}
		}

		// Add them to the toolbar using BorderLayout
		toolBar.add(leftPanel, BorderLayout.WEST);
		toolBar.add(rightPanel, BorderLayout.EAST);

		return toolBar;
	}

	@Override
	public void searchEvent(SearchEvent se) {
		SearchEvent.Type type = se.getType();
		SearchContext context = se.getSearchContext();
		SearchResult result;
		var textArea = getSelectedEditor().textArea;

		switch (type) {
			default: // Prevent FindBugs warning later
			case MARK_ALL:
				result = SearchEngine.markAll(textArea, context);
				break;
			case FIND:
				result = SearchEngine.find(textArea, context);
				if (!result.wasFound() || result.isWrapped()) {
					UIManager.getLookAndFeel().provideErrorFeedback(textArea);
				}
				break;
			case REPLACE:
				result = SearchEngine.replace(textArea, context);
				if (!result.wasFound() || result.isWrapped()) {
					UIManager.getLookAndFeel().provideErrorFeedback(textArea);
				}
				break;
			case REPLACE_ALL:
				result = SearchEngine.replaceAll(textArea, context);
				JOptionPane.showMessageDialog(null, result.getCount()
								+ " occurrences replaced.");
				break;
		}
	}

	@Override
	public String getSelectedText() {
		return getSelectedEditor().textArea.getSelectedText();
	}

}
