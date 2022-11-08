package ui.layout;

import ui.UiElement;

public class HorizontalLayout implements Layout {

	@Override
	public void layout(UiElement uiElement) {
		int offsetX = 0;
		int width = 0;
		int maxHeight = 0;
		
		for (int i = 0; i < uiElement.getChildCount(); i++) {
			UiElement child = uiElement.getChildAt(i);
			child.setLayoutX(offsetX);
			
			int childWidth = child.getBorderBoxWidth() + child.getMargin().getHorizontalInsets();
			int childHeight = child.getBorderBoxHeight() + child.getMargin().getVerticalInsets();
			
			offsetX += childWidth;
			width +=  childWidth;
			maxHeight = childHeight > maxHeight ? childHeight : maxHeight;
		}
		
		if (width > uiElement.getWidth()) {
			uiElement.setLayoutWidth(width - uiElement.getWidth());
		} else {
			uiElement.setLayoutWidth(0);
		}
		
		if (maxHeight > uiElement.getHeight()) {
			uiElement.setLayoutHeight(maxHeight - uiElement.getHeight());
		} else {
			uiElement.setLayoutHeight(0);
		}
	}
	
}
