package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class MessageBoxBorder extends AbstractBorder {
	
	private Color outerColor = Color.WHITE;
	private Color innerColor = Color.BLACK;
	
	public MessageBoxBorder(Color outerColor, Color innerColor) {
		this.outerColor = outerColor;
		this.innerColor = innerColor;
	}
	
	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setColor(outerColor);
		g2d.drawRoundRect(x, y, width - 1, height - 1, 6, 6);
		g2d.setColor(innerColor);
		g2d.drawRoundRect(x + 1, y + 1, width - 3, height - 3, 4, 4);
	}

	@Override
	public Insets getInsets() {
		return new Insets(2, 2, 2, 2);
	}

	public Color getOuterColor() {
		return outerColor;
	}

	public void setOuterColor(Color outerColor) {
		this.outerColor = outerColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

}
