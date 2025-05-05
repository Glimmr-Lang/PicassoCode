package org.editor.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.editor.EditorWindow;
import org.editor.icons.Icons;

/**
 *
 * @author hexaredecimal
 */
public final class AppAction extends AbstractAction {

	private final ActionListener handler;

	private AppAction(String name, Icon icon, String tooltip, String shortcut, ActionListener handler) {
		super(name, icon);
		putValue(SHORT_DESCRIPTION, tooltip);
		if (shortcut != null) {
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortcut));
		}
		this.handler = handler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		handler.actionPerformed(e);
	}

	public void bindTo(JComponent component, String id) {
		KeyStroke ks = (KeyStroke) getValue(ACCELERATOR_KEY);
		if (ks != null) {
			InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap am = component.getActionMap();
			im.put(ks, id);
			am.put(id, this);
		}
	}

	// === Builder Pattern ===
	private String _name;
	private Icon _icon;
	private String _tooltip;
	private String _shortcut;
	private ActionListener _handler;

	public static AppAction create(String name) {
		AppAction action = new AppAction(null, null, null, null, e -> {
		});
		action._name = name;
		return action;
	}

	public static AppAction from(Action original, String icon) {
		String name = (String) original.getValue(Action.NAME);
		String tooltip = (String) original.getValue(Action.SHORT_DESCRIPTION);
		KeyStroke ks = (KeyStroke) original.getValue(Action.ACCELERATOR_KEY);
		String shortcut = ks != null ? getShortcutString(ks) : null;

		return AppAction.create(name)
						.icon(icon)
						.tooltip(tooltip)
						.shortcut(shortcut)
						.handler(original::actionPerformed)
						.build();
	}

	public static String getShortcutString(KeyStroke ks) {
		if (ks == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		int modifiers = ks.getModifiers();
		if ((modifiers & InputEvent.CTRL_DOWN_MASK) != 0) {
			sb.append("control ");
		}
		if ((modifiers & InputEvent.SHIFT_DOWN_MASK) != 0) {
			sb.append("shift ");
		}
		if ((modifiers & InputEvent.ALT_DOWN_MASK) != 0) {
			sb.append("alt ");
		}
		if ((modifiers & InputEvent.META_DOWN_MASK) != 0) {
			sb.append("meta ");
		}

		sb.append(KeyEvent.getKeyText(ks.getKeyCode()).toUpperCase());

		return sb.toString().trim();
	}



	public AppAction icon(String icon) {
		this._icon = Icons.getIcon(icon);
		return this;
	}

	public AppAction tooltip(String tooltip) {
		this._tooltip = tooltip;
		return this;
	}

	public AppAction shortcut(String shortcut) {
		this._shortcut = shortcut;
		return this;
	}

	public AppAction handler(ActionListener handler) {
		this._handler = handler;
		return this;
	}

	public AppAction build() {
		AppAction real = new AppAction(_name, _icon, _tooltip, _shortcut, _handler);
		real.bindTo(EditorWindow.root, _name.toLowerCase());
		return real;
	}
}
