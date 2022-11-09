package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class InsetBorder implements Border {
	
	private Color lightColor;
	private Color shadowColor;
	
	public InsetBorder(Color lightColor, Color shadowColor) {
		this.lightColor = lightColor;
		this.shadowColor = shadowColor;
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		g2d.setColor(shadowColor);
		g2d.drawLine(x, y, x + width - 2, y);
		g2d.drawLine(x, y, x, y + height - 2);
		g2d.setColor(lightColor);
		g2d.drawLine(x + 1, y + height - 1, x + width -1, y + height - 1);
		g2d.drawLine(x + width - 1, y + 1, x + width -1, y + height - 1);
	}

	@Override
	public Insets getInsets() {
		return new Insets(1, 1, 1, 1);
	}

}
