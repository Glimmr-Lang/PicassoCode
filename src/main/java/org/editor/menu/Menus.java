package org.editor.menu;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.editor.events.Events;
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
		fileMenu.add(new JMenuItem(Events.newProjectAction));
		fileMenu.add(new JMenuItem(Events.newFileAction));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem(Events.openProjectAction));

		JMenu recents = new JMenu("Recent Projects");
		recents.setIcon(Icons.getIcon("time-machine"));
		fileMenu.add(recents);
		
		fileMenu.add(new JMenuItem(Events.closeProjectAction));
		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem(Events.openFileAction));
		
		JMenu recentfiles = new JMenu("Recent Files");
		recentfiles.setIcon(Icons.getIcon("restore-page"));
		fileMenu.add(recentfiles);
		
		fileMenu.add(new JMenuItem(Events.closeFileAction));
		fileMenu.addSeparator();
		

		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem(Events.saveAction));
		fileMenu.add(new JMenuItem(Events.saveAsAction));
		fileMenu.add(new JMenuItem(Events.saveAllAction));

		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem(Events.exportAction));
		fileMenu.addSeparator();

		fileMenu.add(new JMenuItem(Events.exitAction));
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
		menu_bar.add(editMenu);
	}

	private static void addNavigateMenu(JMenuBar menu_bar) {
		JMenu navMenu = new JMenu("Navigage");
		
		JMenu tabs = new JMenu("Tabs");
		tabs.setIcon(Icons.getIcon("layout"));
		navMenu.add(tabs);
		
		tabs.add(new JMenuItem(Events.gotoTabAction));
		tabs.add(new JMenuItem(Events.addTabAction));
		tabs.add(new JMenuItem(Events.removeTabAction));
		tabs.addSeparator();
		tabs.add(new JMenuItem(Events.removeAllTabsAction));
		tabs.addSeparator();
		tabs.add(createMenuItem("[Tab: 0]", "restore-window"));
		
		navMenu.addSeparator();
		navMenu.add(new JMenuItem(Events.gotoFileAction));
		
		menu_bar.add(navMenu);
	}

	private static void addRunMenu(JMenuBar menu_bar) {
		JMenu runMenu = new JMenu("Run");
		runMenu.add(new JMenuItem(Events.compileAction));
		runMenu.add(new JMenuItem(Events.renderAction));
		runMenu.addSeparator();
		runMenu.add(new JMenuItem(Events.runOptionsAction));
		menu_bar.add(runMenu);
	}

	private static void addToolMenu(JMenuBar menu_bar) {
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.add(new JMenuItem(Events.AIAction));
		toolsMenu.add(new JMenuItem(Events.pluginsAction));
		toolsMenu.addSeparator();
		toolsMenu.add(new JMenuItem(Events.optionsAction));
		menu_bar.add(toolsMenu);
	}
	
	private static void addHelp(JMenuBar menu_bar) {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(new JMenuItem(Events.docsAction));
		helpMenu.add(new JMenuItem(Events.websiteAction));
		helpMenu.add(new JMenuItem(Events.licenseAction));
		helpMenu.addSeparator();
		helpMenu.add(new JMenuItem(Events.aboutAction));
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
	
	private static JMenuItem createMenuItem(String icon, Action action, String tooltip) {
		JMenuItem item = new JMenuItem(action);
		item.setIcon(Icons.getIcon(icon));
		item.setToolTipText(tooltip); // Swing annoyingly adds tool tip text to the menu item
		return item;
	}
	
}
