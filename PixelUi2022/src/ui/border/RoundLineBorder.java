package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class RoundLineBorder implements Border {

	private Color color;
	
	public RoundLineBorder(Color color) {
		this.color = color;
	}
	
	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		g2d.setColor(color);
		g2d.drawRoundRect(x, y, width - 1, height - 1, 6, 6);
	}

	@Override
	public Insets getInsets() {
		return new Insets(1, 1, 1, 1);
	}

}
