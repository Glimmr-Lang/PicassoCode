package org.editor.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.editor.icons.Icons;

/**
 *
 * @author hexaredecimal
 */
public class FileTreePanel extends DockablePanel {

	public JTree file_tree;

	public FileTreePanel() {
		super(new BorderLayout(), "files", "files", "File listing (cwd)", "folder-tree");

		file_tree = new JTree();
		file_tree.setCellRenderer(new FileTreeCellRenderer());
		file_tree.putClientProperty("JTree.showLines", Boolean.TRUE);
		file_tree.putClientProperty("JTree.lineStyle", "Angled");
		//file_tree.setRowHeight(24); // or a reasonable number depending on your font size

		loadDirectory(System.getProperty("user.dir"));

		this.add(file_tree, BorderLayout.CENTER);
	}

	private void loadDirectory(String file) {
		File fp = new File(file);
		if (!fp.exists()) {
			System.err.println("error: " + file + " does not extit");
			return;
		}

		if (fp.isFile()) {
			return;
		}

		if (fp.isDirectory()) {
			DefaultTreeModel model = (DefaultTreeModel) file_tree.getModel();
			DefaultMutableTreeNode top = new DefaultMutableTreeNode(fp);
			model.setRoot(top);
			file_tree.setModel(model);
			createNodes(top, fp);
		}
	}

	private void createNodes(DefaultMutableTreeNode top, File fp) {
		File[] files = fp.listFiles();

		for (File file : files) {
			if (file.isFile()) {
				DefaultMutableTreeNode f = new DefaultMutableTreeNode(file);
				top.add(f);
			} else {
				DefaultMutableTreeNode dir = new DefaultMutableTreeNode(file);
				createNodes(dir, file);
				top.add(dir);
			}
		}
	}

	class FileTreeCellRenderer extends DefaultTreeCellRenderer {

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value,
						boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			Object userObject = node.getUserObject();

			if (userObject instanceof File file) {
				if (file.isDirectory() && file.getName().equals("src")) {
					setIcon(Icons.getIcon("code-folder"));
				} else if (file.isDirectory()) {
					setIcon(Icons.getIcon("folder"));
				} else if (file.getName().endsWith(".pics")) {
					setIcon(Icons.getIcon("code-file"));
				} else if (file.getName().endsWith(".md")) {
					setIcon(Icons.getIcon("markdown"));
				} else {
					setIcon(Icons.getIcon("file"));
				}
				setText(file.getName());
			}

			return this;
		}
	}

}
