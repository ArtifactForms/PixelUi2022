package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class LineBorder extends AbstractBorder {

	private int size;
	private Color color;
	
	public LineBorder(int size, Color color) {
		this.size = size;
		this.color = color;
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		g2d.setColor(color);
		for (int i = 0; i < size; i++) {
			g2d.drawRect(x + i, y + i, width - i - i - 1, height - i - i - 1);
		}
	}

	@Override
	public Insets getInsets() {
		return new Insets(size, size, size, size);
	}
	
}
