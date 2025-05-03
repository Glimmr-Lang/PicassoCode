package org.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
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
	private int gridSize = 50;

	private int lastMouseX, lastMouseY;
	private BufferedImage gridImage;
	private Point lastDragPoint;
	public static Graphics2D gfx = null;
	private long lastTime;
	private float deltaTime; // in seconds
	private int lastGridOffsetX;
	private int lastGridOffsetY;
	private boolean snapToGrid = true;
	private int mouseX = -1;
	private int mouseY = -1;

	
	public CanvasFrame() {
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
	private boolean gridImageNeedsUpdate() {
		return gridImage == null
						|| offsetX != lastGridOffsetX
						|| offsetY != lastGridOffsetY;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		gfx = g2;

		if (gridImageNeedsUpdate()) {
			drawGrid();
		}

		g2.drawImage(gridImage, 0, 0, null);
		
		// Smooth rendering
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawGrid();
		g2.setColor(Color.BLACK);
		if (!Compiler.main_loop.isEmpty()) {
			Context.top.putLocal("dt", new PiccodeNumber(String.format("%s", deltaTime)));
			try {
				AccessFrame.msgs.setText("");
				for (var stmt : Compiler.main_loop) {
					stmt.execute();
				}
			} catch (Exception e) {
				Compiler.main_loop.clear();
			}
		}

		drawCrosshair(g2);

	}

	// Mouse listeners for panning
	@Override
	public void mousePressed(MouseEvent e) {
		lastMouseX = e.getX();
		lastMouseY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
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
		return (value / gridSize) * gridSize;
	}


	// Empty overrides
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
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

		// Draw grid
		g2.setColor(new Color(230, 230, 230));
		for (int x = -offsetX % gridSize; x < getWidth(); x += gridSize) {
			g2.drawLine(x, 0, x, getHeight());
		}
		for (int y = -offsetY % gridSize; y < getHeight(); y += gridSize) {
			g2.drawLine(0, y, getWidth(), y);
		}

		// Draw axis numbers
		g2.setColor(Color.GRAY);
		for (int x = -offsetX % gridSize; x < getWidth(); x += gridSize) {
			int value = (x + offsetX) / gridSize;
			g2.drawString(Integer.toString(value), x + 2, 12);
		}
		for (int y = -offsetY % gridSize; y < getHeight(); y += gridSize) {
			int value = (y + offsetY) / gridSize;
			g2.drawString(Integer.toString(value), 2, y - 2);
		}
		lastGridOffsetX = offsetX;
		lastGridOffsetY = offsetY;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	private void drawCrosshair(Graphics2D g2) {
		if (snapToGrid && mouseX >= 0 && mouseY >= 0) {
			int snappedX = snap(mouseX);
			int snappedY = snap(mouseY);

			g2.setColor(Color.RED);
			g2.drawLine(snappedX, 0, snappedX, getHeight()); // vertical
			g2.drawLine(0, snappedY, getWidth(), snappedY);  // horizontal

			// Optional: draw a small circle at the intersection
			int radius = 4;
			g2.fillOval(snappedX - radius, snappedY - radius, radius * 2, radius * 2);
		}
	}

}
