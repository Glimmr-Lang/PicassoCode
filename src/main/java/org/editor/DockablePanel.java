package org.editor;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import org.editor.icons.Icons;

/**
 *
 * @author hexaredecimal
 */
public class DockablePanel extends JPanel implements Dockable {
	private DockKey key;

	public DockablePanel(LayoutManager layout) {
		super(layout);
		key = new DockKey("dock-" + System.nanoTime());
	}

	public DockablePanel(LayoutManager layout, String id) {
		super(layout);
		key = new DockKey(id);
	}
	
	public DockablePanel(LayoutManager layout, String id, String name, String tip, String icon) {
		super(layout);
		key = new DockKey(id, name, tip, Icons.getIcon(icon));
	}
	
	@Override
	public DockKey getDockKey() {
		return key;
	}

	@Override
	public Component getComponent() {
		return this;
	}
	
}
