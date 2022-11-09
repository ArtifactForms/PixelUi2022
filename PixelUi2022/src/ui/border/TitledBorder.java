package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class TitledBorder extends AbstractBorder {

	private int size;
	private String text;
	private Color textColor;
	private MatteBorder border;

	public TitledBorder(String text, int size, Color textColor, Color color) {
		this.text = text;
		this.size = size;	
		this.textColor = textColor;
		border = new MatteBorder(9 + size, size, size, size, color);
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		border.renderBorder(g2d, x, y, width, height);
		g2d.translate(x + size, y + size);
		g2d.setColor(textColor);
		g2d.setFont("monogram_extended.ttf", 16);
		g2d.textSize(16);
		g2d.drawString(text, 0, 7);
		g2d.translate(-x - size, -y - size);
	}

	@Override
	public Insets getInsets() {
		return border.getInsets();
	}

}
