package org.editor.menu;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		fileMenu.add(createMenuItem("New Project"));
		fileMenu.add(createMenuItem("New File"));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Open Project"));

		JMenu recents = new JMenu("Recent Projects");
		fileMenu.add(recents);
		
		fileMenu.add(createMenuItem("Close Project"));

		fileMenu.add(createMenuItem("Open File"));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Save"));
		fileMenu.add(createMenuItem("Save As"));
		fileMenu.add(createMenuItem("Save All"));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem("Export"));
		fileMenu.addSeparator();

		var exit_menu = createMenuItem("Exit");
		exit_menu.addActionListener((a) -> System.exit(0));
		fileMenu.add(exit_menu);
		
		menu_bar.add(fileMenu);
	}

	private static void addEditMenu(JMenuBar menu_bar) {
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.UNDO_ACTION)));
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.REDO_ACTION)));
		editMenu.addSeparator();
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.CUT_ACTION)));
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.COPY_ACTION)));
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.PASTE_ACTION)));
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.DELETE_ACTION)));
		editMenu.addSeparator();
		editMenu.add(createMenuItem(RTextArea.getAction(RTextArea.SELECT_ALL_ACTION)));
		menu_bar.add(editMenu);
	}

	private static void addNavigateMenu(JMenuBar menu_bar) {
		JMenu navMenu = new JMenu("Navigage");
		
		JMenu tabs = new JMenu("Tabs");
		navMenu.add(tabs);
		
		tabs.add(createMenuItem("Goto Tab"));
		tabs.add(createMenuItem("Add Tab"));
		tabs.add(createMenuItem("Remove Tab"));
		tabs.addSeparator();
		tabs.add(createMenuItem("Remove All Tabs"));
		tabs.addSeparator();
		tabs.add(createMenuItem("[Tab: 0]"));
		
		navMenu.addSeparator();
		navMenu.add(createMenuItem("Goto file"));
		
		menu_bar.add(navMenu);
	}

	private static void addRunMenu(JMenuBar menu_bar) {
		JMenu runMenu = new JMenu("Run");
		runMenu.add(createMenuItem("Compile"));
		runMenu.add(createMenuItem("Render"));
		runMenu.addSeparator();
		runMenu.add(createMenuItem("Run Options"));
		menu_bar.add(runMenu);
	}

	private static void addToolMenu(JMenuBar menu_bar) {
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.add(createMenuItem("AI"));
		toolsMenu.add(createMenuItem("Plugins"));
		toolsMenu.addSeparator();
		toolsMenu.add(createMenuItem("Options"));
		menu_bar.add(toolsMenu);
	}
	
	private static void addHelp(JMenuBar menu_bar) {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(createMenuItem("Documentation"));
		helpMenu.add(createMenuItem("Website"));
		helpMenu.add(createMenuItem("License"));
		helpMenu.addSeparator();
		helpMenu.add(createMenuItem("About"));
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
}
