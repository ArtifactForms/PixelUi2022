package ui.border;

import ui.Graphics2;

public class EmptyBorder extends AbstractBorder {

	private Insets insets;

	public EmptyBorder(int top, int left, int bottom, int right) {
		insets = new Insets(top, left, bottom, right);
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
	}

	@Override
	public Insets getInsets() {
		return new Insets(insets);
	}

}
