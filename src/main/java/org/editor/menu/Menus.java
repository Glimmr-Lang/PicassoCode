package org.editor.menu;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	}

	private static void addFileMenu(JMenuBar menu_bar) {
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(createMenuItem("New Project", "project-setup"));
		fileMenu.add(createMenuItem("New File", "add-file"));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Open Project", "code-folder"));

		JMenu recents = new JMenu("Recent Projects");
		recents.setIcon(Icons.getIcon("time-machine"));
		fileMenu.add(recents);
		
		fileMenu.add(createMenuItem("Close Project", "xxx-folder"));
		fileMenu.addSeparator();

		fileMenu.add(createMenuItem("Open File", "file"));
		JMenu recentfiles = new JMenu("Recent Files");
		recentfiles.setIcon(Icons.getIcon("restore-page"));
		fileMenu.add(recentfiles);
		fileMenu.add(createMenuItem("Close File", "close"));
		fileMenu.addSeparator();
		

		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Save", "save"));
		fileMenu.add(createMenuItem("Save As", "save-as"));
		fileMenu.add(createMenuItem("Save All", "save-all"));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Export", "export"));
		fileMenu.addSeparator();

		var exit_menu = createMenuItem("Exit", "logout");
		exit_menu.addActionListener((a) -> System.exit(0));
		fileMenu.add(exit_menu);
		
		menu_bar.add(fileMenu);
	}

	private static void addEditMenu(JMenuBar menu_bar) {
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(createMenuItem("undo", RTextArea.getAction(RTextArea.UNDO_ACTION)));
		editMenu.add(createMenuItem("redo", RTextArea.getAction(RTextArea.REDO_ACTION)));
		editMenu.addSeparator();
		editMenu.add(createMenuItem("cut", RTextArea.getAction(RTextArea.CUT_ACTION)));
		editMenu.add(createMenuItem("copy-to-clipboard", RTextArea.getAction(RTextArea.COPY_ACTION)));
		editMenu.add(createMenuItem("paste", RTextArea.getAction(RTextArea.PASTE_ACTION)));
		editMenu.add(createMenuItem("clear-symbol", RTextArea.getAction(RTextArea.DELETE_ACTION)));
		editMenu.addSeparator();
		editMenu.add(createMenuItem("select-all", RTextArea.getAction(RTextArea.SELECT_ALL_ACTION)));
		menu_bar.add(editMenu);
	}

	private static void addNavigateMenu(JMenuBar menu_bar) {
		JMenu navMenu = new JMenu("Navigage");
		
		JMenu tabs = new JMenu("Tabs");
		tabs.setIcon(Icons.getIcon("layout"));
		navMenu.add(tabs);
		
		tabs.add(createMenuItem("Goto Tab", "shortcut"));
		tabs.add(createMenuItem("Add Tab", "add"));
		tabs.add(createMenuItem("Remove Tab", "close"));
		tabs.addSeparator();
		tabs.add(createMenuItem("Remove All Tabs", "exit"));
		tabs.addSeparator();
		tabs.add(createMenuItem("[Tab: 0]", "restore-window"));
		
		navMenu.addSeparator();
		navMenu.add(createMenuItem("Goto file", "hot-article"));
		
		menu_bar.add(navMenu);
	}

	private static void addRunMenu(JMenuBar menu_bar) {
		JMenu runMenu = new JMenu("Run");
		runMenu.add(createMenuItem("Compile", "run"));
		runMenu.add(createMenuItem("Render", "panorama"));
		runMenu.addSeparator();
		runMenu.add(createMenuItem("Run Options", "automatic"));
		menu_bar.add(runMenu);
	}

	private static void addToolMenu(JMenuBar menu_bar) {
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.add(createMenuItem("AI", "chatbot"));
		toolsMenu.add(createMenuItem("Plugins", "plugin"));
		toolsMenu.addSeparator();
		toolsMenu.add(createMenuItem("Options", "options"));
		menu_bar.add(toolsMenu);
	}
	
	private static void addHelp(JMenuBar menu_bar) {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(createMenuItem("Documentation", "book"));
		helpMenu.add(createMenuItem("Website", "open-in-browser"));
		helpMenu.add(createMenuItem("License", "license"));
		helpMenu.addSeparator();
		helpMenu.add(createMenuItem("About", "about"));
		menu_bar.add(helpMenu);
	}
	
	private static JMenuItem createMenuItem(Action action) {
		JMenuItem item = new JMenuItem(action);
		item.setToolTipText(null); // Swing annoyingly adds tool tip text to the menu item
		return item;
	}
	
	private static JMenuItem createMenuItem(String text) {
		JMenuItem item = new JMenuItem(text);
		return item;
	}
	
	private static JMenuItem createMenuItem(String text, String icon) {
		JMenuItem item = new JMenuItem(text, Icons.getIcon(icon));
		return item;
	}
	
	private static JMenuItem createMenuItem(String icon, Action action) {
		JMenuItem item = new JMenuItem(action);
		item.setIcon(Icons.getIcon(icon));
		item.setToolTipText(null); // Swing annoyingly adds tool tip text to the menu item
		return item;
	}
	
}
