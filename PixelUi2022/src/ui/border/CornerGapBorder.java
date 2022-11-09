package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class CornerGapBorder implements Border {

	private int x;
	private int y;
	private int width;
	private int height;
	private int size;
	private Color color;
	private Graphics2 g2d;
	
	public CornerGapBorder(int size, Color color) {
		this.size = size;
		this.color = color;
	}
	
	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		setGraphicsContext(g2d);
		setBorderFrame(x, y, width, height);
		setColor();
		renderRectangles();
	}
	
	private void renderRectangles() {
		renderNorthRectangle();
		renderWestRectangle();
		renderSouthRectangle();
		renderEastRectangle();
	}
	
	private void renderNorthRectangle() {
		renderRectangle(x + size, y, getRectangleWidth(), size);
	}
	
	private void renderWestRectangle() {
		renderRectangle(x, y + size, size, getRectangleHeight());
	}
	
	private void renderSouthRectangle() {
		renderRectangle(x + size, y + height - size, getRectangleWidth(), size);
	}
	
	private void renderEastRectangle() {
		renderRectangle(x + width - size, y + size, size, getRectangleHeight());
	}
	
	private void renderRectangle(int x, int y, int width, int height) {
		g2d.fillRect(x, y, width, height);
	}
	
	private int getRectangleWidth() {
		return width - size - size;
	}
	
	private int getRectangleHeight() {
		return height - size - size;
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(size, size, size, size);
	}
	
	private void setColor() {
		g2d.setColor(color);
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
 
}
