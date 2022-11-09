package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class BevelBorder extends AbstractBorder {

	private Color light;
	private Color shadow;
	
	public BevelBorder(Color light, Color shadow) {
		this.light = light;
		this.shadow = shadow;
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		g2d.setColor(light);
		g2d.drawLine(x, y, x + width - 1, y);
		g2d.drawLine(x, y, x, y + height - 1);
		g2d.setColor(shadow);
		g2d.drawLine(x + 1, y + height - 1, x + width - 1, y + height - 1);
		g2d.drawLine(x + width - 1, y + 1, x + width - 1, y + height - 1);
	}

	@Override
	public Insets getInsets() {
		return new Insets(1, 1, 1, 1);
	}

}
