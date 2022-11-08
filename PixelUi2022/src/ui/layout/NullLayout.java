package ui.layout;

import ui.UiElement;

public class NullLayout implements Layout {

	@Override
	public void layout(UiElement uiElement) {
		for (int i = 0; i < uiElement.getChildCount(); i++) {
			UiElement child = uiElement.getChildAt(i);
			child.setLayoutX(0);
			child.setLayoutY(0);
		}
		uiElement.setLayoutWidth(0);
		uiElement.setLayoutHeight(0);
	}

}
