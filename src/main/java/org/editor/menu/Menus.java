package org.editor.menu;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import org.editor.EditorWindow;
import org.editor.SearchInput;
import org.editor.events.Actions;
import org.editor.fs.FilePersistance;
import org.editor.icons.Icons;
import org.fife.ui.rtextarea.RTextArea;

/**
 *
 * @author hexaredecimal
 */
public class Menus {

	public static void addMenus(JMenuBar menu_bar) {
		addFileMenu(menu_bar);
		addEditMenu(menu_bar);
		addNavigateMenu(menu_bar);
		addRunMenu(menu_bar);
		addToolMenu(menu_bar);
		addHelp(menu_bar);

		// Glue to push the rest to the right
		menu_bar.add(Box.createHorizontalGlue());

		// Search field (limit max size)
		var searchField = new SearchInput("Search...", 15);
		var searchSize = searchField.getPreferredSize();
		searchField.setMaximumSize(new Dimension(150, searchSize.height)); // Limit max width
		menu_bar.add(searchField);
		menu_bar.add(Box.createRigidArea(new Dimension(5, 0)));

		Action[] actions = {Actions.navBottom, Actions.navTop, Actions.navLeft, Actions.navRight};
		for (var action : actions) {
			JButton btn = new JButton(action);
			btn.setText("");
			menu_bar.add(btn);
		}
	}

	private static void addFileMenu(JMenuBar menu_bar) {
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem(Actions.newProjectAction));
		fileMenu.add(new JMenuItem(Actions.newFileAction));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem(Actions.openProjectAction));

		JMenu recents = new JMenu("Recent Projects");
		recents.setIcon(Icons.getIcon("time-machine"));
		fileMenu.add(recents);

		fileMenu.add(new JMenuItem(Actions.closeProjectAction));
		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem(Actions.openFileAction));

		JMenu recentfiles = new JMenu("Recent Files");
		recentfiles.setIcon(Icons.getIcon("restore-page"));

		FilePersistance
						.getRecentFiles()
						.forEach(item -> {
							var fp = new File(item);
							var menuItem = createMenuItem(fp.getName(), "file", (e) -> {
								var path = fp.toPath();
								EditorWindow.addTab(path, null);
							});
							recentfiles.add(menuItem);
						});

		fileMenu.add(recentfiles);

		fileMenu.add(new JMenuItem(Actions.closeFileAction));

		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem(Actions.saveAction));
		fileMenu.add(new JMenuItem(Actions.saveAsAction));
		fileMenu.add(new JMenuItem(Actions.saveAllAction));

		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem(Actions.exportAction));
		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem(Actions.exitAction));
		menu_bar.add(fileMenu);
	}

	private static void addEditMenu(JMenuBar menu_bar) {
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(createMenuItem("undo", RTextArea.getAction(RTextArea.UNDO_ACTION), "Undo the changes made"));
		editMenu.add(createMenuItem("redo", RTextArea.getAction(RTextArea.REDO_ACTION), "Redo the changes made"));
		editMenu.addSeparator();
		editMenu.add(createMenuItem("cut", RTextArea.getAction(RTextArea.CUT_ACTION), "Cut the text into the system clipboard"));
		editMenu.add(createMenuItem("copy-to-clipboard", RTextArea.getAction(RTextArea.COPY_ACTION), "Copy the text into the system clipboard"));
		editMenu.add(createMenuItem("paste", RTextArea.getAction(RTextArea.PASTE_ACTION), "Paste from the system clipboard"));
		editMenu.add(createMenuItem("clear-symbol", RTextArea.getAction(RTextArea.DELETE_ACTION), "Delete selection"));
		editMenu.addSeparator();
		editMenu.add(createMenuItem("select-all", RTextArea.getAction(RTextArea.SELECT_ALL_ACTION), "Delete selection"));
		editMenu.addSeparator();
		editMenu.add(new JMenuItem(Actions.findAction));
		editMenu.add(new JMenuItem(Actions.replaceAction));
		editMenu.addSeparator();
		editMenu.add(new JMenuItem(Actions.gotoLine));
		menu_bar.add(editMenu);
	}

	private static void addNavigateMenu(JMenuBar menu_bar) {
		JMenu navMenu = new JMenu("Navigage");

		JMenu tabs = new JMenu("Tabs");
		tabs.setIcon(Icons.getIcon("layout"));
		navMenu.add(tabs);

		tabs.add(new JMenuItem(Actions.gotoTabAction));
		tabs.add(new JMenuItem(Actions.addTabAction));
		tabs.add(new JMenuItem(Actions.removeTabAction));
		tabs.addSeparator();
		tabs.add(new JMenuItem(Actions.removeAllTabsAction));
		tabs.addSeparator();
		tabs.add(createMenuItem("[Tab: 0]", "restore-window"));

		navMenu.addSeparator();
		navMenu.add(new JMenuItem(Actions.gotoFileAction));

		menu_bar.add(navMenu);
	}

	private static void addRunMenu(JMenuBar menu_bar) {
		JMenu runMenu = new JMenu("Run");
		runMenu.add(new JMenuItem(Actions.compileAction));
		runMenu.add(new JMenuItem(Actions.renderAction));
		runMenu.addSeparator();
		runMenu.add(new JMenuItem(Actions.runOptionsAction));
		menu_bar.add(runMenu);
	}

	private static void addToolMenu(JMenuBar menu_bar) {
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.add(new JMenuItem(Actions.AIAction));
		toolsMenu.add(new JMenuItem(Actions.pluginsAction));
		toolsMenu.addSeparator();
		toolsMenu.add(new JMenuItem(Actions.optionsAction));
		toolsMenu.addSeparator();

		JMenu renderToolsMenu = new JMenu("Tools");
		renderToolsMenu.setIcon(Icons.getIcon("tools"));

		renderToolsMenu.add(new JMenuItem(Actions.normalAction));
		renderToolsMenu.add(new JMenuItem(Actions.gridAction));
		renderToolsMenu.add(new JMenuItem(Actions.pointAction));
		renderToolsMenu.add(new JMenuItem(Actions.rulerAction));
		renderToolsMenu.add(new JMenuItem(Actions.snapAction));
		renderToolsMenu.add(new JMenuItem(Actions.brushAction));
		renderToolsMenu.add(new JMenuItem(Actions.thickBrushAction));
		renderToolsMenu.add(new JMenuItem(Actions.paintBucketAction));
		renderToolsMenu.add(new JMenuItem(Actions.effectsAction));

		toolsMenu.add(renderToolsMenu);
		menu_bar.add(toolsMenu);
	}

	private static void addHelp(JMenuBar menu_bar) {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(new JMenuItem(Actions.docsAction));
		helpMenu.add(new JMenuItem(Actions.websiteAction));
		helpMenu.add(new JMenuItem(Actions.licenseAction));
		helpMenu.addSeparator();
		helpMenu.add(new JMenuItem(Actions.aboutAction));
		menu_bar.add(helpMenu);
	}

	private static JMenuItem createMenuItem(String text, String icon) {
		JMenuItem item = new JMenuItem(text, Icons.getIcon(icon));
		return item;
	}

	private static JMenuItem createMenuItem(String text, String icon, ActionListener listener) {
		JMenuItem item = new JMenuItem(text, Icons.getIcon(icon));
		item.addActionListener(listener);
		return item;
	}

	private static JMenuItem createMenuItem(String icon, Action action, String tooltip) {
		JMenuItem item = new JMenuItem(action);
		item.setIcon(Icons.getIcon(icon));
		item.setToolTipText(tooltip); // Swing annoyingly adds tool tip text to the menu item
		return item;
	}

}
