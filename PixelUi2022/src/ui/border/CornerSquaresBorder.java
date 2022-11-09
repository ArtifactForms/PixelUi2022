package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class CornerSquaresBorder extends AbstractBorder {
	
	private int squareSize;
	private Color color;
	
	public CornerSquaresBorder(int squareSize, Color color) {
		this.squareSize = squareSize;
		this.color = color;
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		g2d.setColor(color);
		g2d.drawRect(x, y, width - 1, height - 1);
		g2d.drawRect(x, y, squareSize - 1, squareSize - 1);
		g2d.drawRect(x + width - squareSize, y, squareSize - 1, squareSize - 1);
		g2d.drawRect(x + width - squareSize, y + height - squareSize, squareSize - 1, squareSize - 1);
		g2d.drawRect(x, y + height - squareSize, squareSize - 1, squareSize - 1);
	}

	@Override
	public Insets getInsets() {
		return new Insets(squareSize, squareSize, squareSize, squareSize);
	}

}
