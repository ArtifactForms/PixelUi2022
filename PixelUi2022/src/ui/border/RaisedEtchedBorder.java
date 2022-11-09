package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class RaisedEtchedBorder extends AbstractBorder {

	private Color lightColor;
	private Color darkColor;
	
	public RaisedEtchedBorder(Color lightColor, Color darkColor) {
		this.lightColor = lightColor;
		this.darkColor = darkColor;
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		g2d.setColor(darkColor);
		g2d.drawRect(x, y, width - 1, height - 1);
		g2d.setColor(darkColor);
		g2d.drawRect(x + 1, y + 1, width - 2, height - 2);
		g2d.setColor(lightColor);
		g2d.drawRect(x, y, width - 2, height - 2);
	}

	@Override
	public Insets getInsets() {
		return new Insets(2, 2, 2, 2);
	}

}
