package org.editor;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import org.piccode.backend.Compiler;
import org.piccode.rt.Context;
import org.piccode.rt.PiccodeNumber;

/**
 *
 * @author hexaredecimal
 */
public class CanvasFrame extends JPanel implements MouseListener, MouseMotionListener {

	public static int offsetX = 0;
	public static int offsetY = 0;
	private static int SCALE = 50;

	private int lastMouseX, lastMouseY;
	private BufferedImage gridImage;
	private Point lastDragPoint;
	public static Graphics2D gfx = null;
	private long lastTime;
	private float deltaTime; // in seconds
	private int lastGridOffsetX;
	private int lastGridOffsetY;
	public boolean snapToGrid = true;
	public boolean showGrid = true;
	public boolean showHighlight = true;
	public boolean showRuler = true;
	private int mouseX = -1;
	private int mouseY = -1;

	private boolean selecting = false;
	private Point selectionStart = null;
	private Point selectionEnd = null;

	private static CanvasFrame _the = null;

	private CanvasFrame() {
		super(new BorderLayout());
		this.setBackground(new Color(18, 18, 18));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		drawGrid();
		setPreferredSize(new Dimension(getWidth(), getHeight()));
		Timer timer = new Timer(16, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint(getVisibleRect());
				long now = System.nanoTime();
				deltaTime = (now - lastTime) / 1_000_000_000f; // convert ns to seconds
				lastTime = now;
			}
		});
		timer.start();
	}

	public static CanvasFrame the() {
		if (_the == null) {
			_the = new CanvasFrame();
		}

		return _the;
	}

	private boolean gridImageNeedsUpdate() {
		return gridImage == null
						|| offsetX != lastGridOffsetX
						|| offsetY != lastGridOffsetY;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		drawGrid();

		g2.drawImage(gridImage, 0, 0, null);

		// Smooth rendering
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		if (!Compiler.main_loop.isEmpty()) {
			Context.top.putLocal("dt", new PiccodeNumber(String.format("%s", deltaTime)));
			try {
				AccessFrame.msgs.setText("");
				gfx = g2;
				for (var stmt : Compiler.main_loop) {
					stmt.execute();
				}
			} catch (Exception e) {
				Compiler.main_loop.clear();
			}
		}

		drawSelection(g2);
		if (showHighlight) {
			drawCrosshair(g2);
		}

	}

	private void drawSelection(Graphics2D g2) {
		if (selecting && selectionStart != null && selectionEnd != null) {
			Point start = selectionStart;
			Point end = selectionEnd;

			if (snapToGrid) {
				start = new Point(snap(start.x), snap(start.y));
				end = new Point(snap(end.x), snap(end.y));
			}

			int x = Math.min(start.x, end.x) + offsetX;
			int y = Math.min(start.y, end.y) + offsetY;
			int w = Math.abs(start.x - end.x);
			int h = Math.abs(start.y - end.y);

			// Fill (translucent blue)
			g2.setColor(new Color(30, 144, 255, 40)); // DodgerBlue with alpha
			g2.fillRect(x, y, w, h);

			// Border (dashed)
			g2.setColor(new Color(30, 144, 255));
			Stroke oldStroke = g2.getStroke();
			g2.setStroke(createDashedStroke(1.5f));
			g2.drawRect(x, y, w, h);
			g2.setStroke(oldStroke);
		}
	}

	private static Stroke createDashedStroke(float thickness) {
		return new BasicStroke(
						thickness,
						BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_MITER,
						10.0f,
						new float[]{5.0f, 5.0f},
						0.0f
		);
	}

	// Mouse listeners for panning
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			selectionStart = e.getPoint();
			selectionEnd = e.getPoint();
			selecting = true;
			repaint();
		}
		lastMouseX = e.getX();
		lastMouseY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e) && selecting) {
			selectionEnd = e.getPoint();
			repaint();
			return;
		}

		int mouseX = snapToGrid ? snap(e.getX()) : e.getX();
		int mouseY = snapToGrid ? snap(e.getY()) : e.getY();

		int dx = mouseX - lastMouseX;
		int dy = mouseY - lastMouseY;

		offsetX -= dx;
		offsetY -= dy;

		if (snapToGrid) {
			offsetX = snap(offsetX);
			offsetY = snap(offsetY);
		}

		lastMouseX = e.getX();
		lastMouseY = e.getY();
		repaint();
	}

	private int snap(int value) {
		return (value / SCALE) * SCALE;
	}

	// Empty overrides
	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (selectionStart != null && selectionEnd != null && selectionStart.distance(selectionEnd) < 5) {
				// Small click, cancel selection
				selecting = false;
				selectionStart = null;
				selectionEnd = null;
			}
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

		if (snapToGrid) {
			mouseX = snap(mouseX);
			mouseY = snap(mouseY);
		}

		lastMouseX = mouseX;
		lastMouseY = mouseY;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseX = -1;
		mouseY = -1;
		repaint();
	}

	private void drawGrid() {
		int w = getWidth();
		int h = getHeight();
		if (w <= 0 || h <= 0) {
			return;
		}
		gridImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = gridImage.createGraphics();
		// Fill background
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		if (showGrid) {
			// Draw grid
			g2.setColor(new Color(230, 230, 230));
			for (int x = -offsetX % SCALE; x < getWidth(); x += SCALE) {
				g2.drawLine(x, 0, x, getHeight());
			}
			for (int y = -offsetY % SCALE; y < getHeight(); y += SCALE) {
				g2.drawLine(0, y, getWidth(), y);
			}
		}

		if (showRuler) {
			// Draw axis numbers
			g2.setColor(Color.GRAY);
			for (int x = -offsetX % SCALE; x < getWidth(); x += SCALE) {
				int value = (x + offsetX) / SCALE;
				g2.drawString(Integer.toString(value * SCALE), x + 2, 12);
			}
			for (int y = -offsetY % SCALE; y < getHeight(); y += SCALE) {
				int value = (y + offsetY) / SCALE;
				g2.drawString(Integer.toString(value * SCALE), 2, y - 2);
			}
		}

		g2.setColor(Color.BLUE);
		g2.drawString("x", getWidth() - 20, 20);
		g2.setColor(Color.RED);
		g2.drawString("y", 8, getHeight() - 5);

		g2.setColor(Color.GRAY);
		int x = (-offsetX % SCALE + offsetX) / SCALE;
		int y = (-offsetY % SCALE + offsetY) / SCALE;
		x *= SCALE;
		y *= SCALE;

		g2.drawString(String.format("(x: %s, y: %s)", x + mouseX, y + mouseY), getWidth() - 100, getHeight() - 5);

		lastGridOffsetX = offsetX;
		lastGridOffsetY = offsetY;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	private void drawCrosshair(Graphics2D g2) {
		if (mouseX >= 0 && mouseY >= 0) {

			if (snapToGrid) {
				mouseX = snap(mouseX);
				mouseY = snap(mouseY);
			}
			
			g2.setColor(Color.RED);
			g2.drawLine(mouseX, 0, mouseX, getHeight()); // vertical
			g2.drawLine(0, mouseY, getWidth(), mouseY);  // horizontal

			// Optional: draw a small circle at the intersection
			int radius = 4;
			g2.fillOval(mouseX - radius, mouseY - radius, radius * 2, radius * 2);
		}
	}

}
