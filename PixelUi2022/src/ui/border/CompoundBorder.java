package ui.border;

import ui.Graphics2;

public class CompoundBorder extends AbstractBorder {

	private Border outerBorder;
	private Border innerBorder;

	public CompoundBorder(Border outerBorder, Border innerBorder) {
		this.outerBorder = outerBorder;
		this.innerBorder = innerBorder;
	}

	@Override
	public Insets getInsets() {
		Insets insets = new Insets(outerBorder.getInsets());
		insets.add(innerBorder.getInsets());
		return insets;
	}

	private void renderOuterBorder(Graphics2 g2d, int x, int y, int width, int height) {
		outerBorder.renderBorder(g2d, x, y, width, height);
	}

	private void renderInnerBorder(Graphics2 g2d, int x, int y, int width, int height) {
		Insets outerInsets = outerBorder.getInsets();
		x += outerInsets.left;
		y += outerInsets.top;
		width -= outerInsets.left + outerInsets.right;
		height -= outerInsets.top + outerInsets.bottom;
		innerBorder.renderBorder(g2d, x, y, width, height);
	}

	@Override
	public void renderBorder(Graphics2 g2d, int x, int y, int width, int height) {
		renderOuterBorder(g2d, x, y, width, height);
		renderInnerBorder(g2d, x, y, width, height);
	}

}
