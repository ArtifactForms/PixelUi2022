package ui.layout;

import ui.UiElement;

public class VerticalLayout implements Layout {

	@Override
	public void layout(UiElement uiElement) {
		int offsetY = 0;
		int height = 0;
		int maxWidth = 0;
		
		for (int i = 0; i < uiElement.getChildCount(); i++) {
			UiElement child = uiElement.getChildAt(i);
			child.setLayoutY(offsetY);
			
			int childWidth = child.getBorderBoxWidth() + child.getMargin().getHorizontalInsets();
			int childHeight = child.getBorderBoxHeight() + child.getMargin().getVerticalInsets();
			
			offsetY += childHeight;
			height +=  childHeight;
			maxWidth = childWidth > maxWidth ? childWidth : maxWidth;
		}
		
		if (maxWidth > uiElement.getWidth()) {
			uiElement.setLayoutWidth(maxWidth - uiElement.getWidth());
		} else {
			uiElement.setLayoutWidth(0);
		}
		
		if (height > uiElement.getHeight()) {
			uiElement.setLayoutHeight(height - uiElement.getHeight());
		} else {
			uiElement.setLayoutHeight(0);
		}
	}
	
}
