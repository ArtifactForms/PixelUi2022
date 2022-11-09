package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class MatteBorder extends AbstractBorder {

	private int x;
	private int y;
	private int width;
	private int height;
	private Insets insets;
	private Color color;
	private Graphics2 g2d;

	public MatteBorder(int top, int left, int bottom, int right, Color color) {
		insets = new Insets(top, left, bottom, right);
		this.color = color;
	}

	private void renderTopBorder() {
		g2d.fillRect(x + insets.left, y, width - insets.left - insets.right, insets.top);
	}

	private void renderBottomBorder() {
		g2d.fillRect(x + insets.left, y + height - insets.bottom, width - insets.left - insets.right, insets.bottom);
	}

	private void renderLeftBorder() {
		g2d.fillRect(x, y, insets.left, height);
	}

	private void renderRightBorder() {
		g2d.fillRect(x + width - insets.right, y, insets.right, height);
	}
	
	private void setBorderFrame(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	private void setGraphicsContext(Graphics2 g2d) {
		this.g2d = g2d;
	}
	
	private void setColor() {
		g2d.setColor(color);
	}
	
	private void renderBorderParts() {
		renderTopBorder();
		renderBottomBorder();
		renderLeftBorder();
		renderRightBorder();
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		setBorderFrame(x, y, width, height);
		setGraphicsContext(g2d);
		setColor();
		renderBorderParts();
	}

	@Override
	public Insets getInsets() {
		return new Insets(insets);
	}

}
