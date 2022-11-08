package ui.border;

import ui.Graphics2;

public interface Border {

	void renderBorder(Graphics2 g2d, int x, int y, int width, int height);
	
	Insets getInsets();
	
}
