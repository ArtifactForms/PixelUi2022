package ui.border;

import java.awt.Color;

import ui.Graphics2;

public class KeyLabelBorder extends AbstractBorder {
	
	private MatteBorder matteBorder;
	private MessageBoxBorder messageBoxBorder;
	private CompoundBorder compoundBorder;
	private CompoundBorder compoundBorderOuter;
	
	public KeyLabelBorder(Color shadow, Color background) {
		matteBorder = new MatteBorder(1, 1, 2, 1, shadow);
		messageBoxBorder = new MessageBoxBorder(Color.WHITE, Color.BLACK);
		compoundBorder = new CompoundBorder(messageBoxBorder, matteBorder);
		compoundBorderOuter = new CompoundBorder(compoundBorder, new MatteBorder(3, 3, 2, 3, background));
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		compoundBorderOuter.renderBorder(g2d, x, y, width, height);
	}

	@Override
	public Insets getInsets() {
		return new Insets(compoundBorderOuter.getInsets());
	}

}
