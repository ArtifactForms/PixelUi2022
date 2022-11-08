package ui.layout;

import ui.UiElement;

public class LayoutAnchor {

	private UiElement uiElement;
	private UiElement parent;
	private Anchor anchor;

	public LayoutAnchor(Anchor anchor) {
		this.anchor = anchor;
	}

	public void anchor(UiElement uiElement) {
		if (uiElement.isRoot())
			return;

		setUiElement(uiElement);
		setParent(uiElement.getParent());
		layoutByAnchor();
	}

	private void layoutByAnchor() {
		switch (anchor) {
		case VERTICAL_WIDE:
			anchorVerticalWide();
			break;
		case HORIZONTAL_WIDE:
			anchorHorizontalWide();
			break;
		case TOP_LEFT:
			layoutTopLeft();
			break;
		case TOP_RIGHT:
			layoutTopRight();
			break;
		case BOTTOM_RIGHT:
			layoutBottomRight();
			break;
		case BOTTOM_LEFT:
			layoutBottomLeft();
			break;
		case CENTER_LEFT:
			layoutCenterLeft();
			break;
		case CENTER_TOP:
			layoutCenterTop();
			break;
		case CENTER_RIGHT:
			layoutCenterRight();
			break;
		case CENTER_BOTTOM:
			layoutCenterBottom();
			break;
		case CENTER:
			layoutCenter();
			break;
		case LEFT_WIDE:
			layoutLeftWide();
			break;
		case TOP_WIDE:
			layoutTopWide();
			break;
		case RIGHT_WIDE:
			layoutRightWide();
			break;
		case BOTTOM_WIDE:
			layoutBottomWide();
			break;
		case VERTICAL_CENTER_WIDE:
			layoutVerticalCenterWide();
			break;
		case HORIZONTAL_CENTER_WIDE:
			layoutHorizontalCenterWide();
			break;
		case FULL_RECTANGLE:
			layoutFullRectangle();
			break;
		default:
			break;
		}
	}

	private void setUiElement(UiElement uiElement) {
		this.uiElement = uiElement;
	}

	private void setParent(UiElement parent) {
		this.parent = parent;
	}

	private void setToParentInnerCoordinates() {
		setToParentInnerX();
		setToParentInnerY();
	}

	private void setToParentInnerX() {
		uiElement.setLayoutX(0);
	}

	private void setToParentInnerY() {
		uiElement.setLayoutY(0);
	}

	private void setToParentInnerWidth() {
		int parentWidth = parent.getContentWidth();
		int childWidth = uiElement.getBorderBoxWidth();
		int layoutWidth = parentWidth - childWidth;
		uiElement.setLayoutWidth(layoutWidth);
	}

	private void setToParentInnerHeight() {
		int parentHeight = parent.getContentHeight();
		int childHeight = uiElement.getBorderBoxHeight();
		int layoutHeight = parentHeight - childHeight;
		uiElement.setLayoutHeight(layoutHeight);
	}

	private void centerHorizontal() {
		int parentWidth = parent.getWidth() + parent.getLayoutWidth();
		int offsetX = Math.abs(parentWidth - uiElement.getBorderBoxWidth()) / 2;
		uiElement.setLayoutX(offsetX);
	}

	private void centerVertical() {
		int parentHeight = parent.getHeight() + parent.getLayoutHeight();
		int offsetY = Math.abs(parentHeight - uiElement.getBorderBoxHeight()) / 2;
		uiElement.setLayoutY(offsetY);
	}
	
	private void anchorHorizontalWide() {
		setToParentInnerWidth();
	}
	
	private void anchorVerticalWide() {
		setToParentInnerHeight();
	}

	private void anchorRight() {
		int offset = (parent.getWidth() + parent.getLayoutWidth());
		offset -= uiElement.getBorderBoxWidth();
		uiElement.setLayoutX(offset);
	}

	private void anchorBottom() {
		int offset = (parent.getHeight() + parent.getLayoutHeight());
		offset -= uiElement.getBorderBoxHeight();
		uiElement.setLayoutY(offset);
	}

	private void layoutTopLeft() {
		setToParentInnerCoordinates();
	}

	private void layoutTopRight() {
		anchorRight();
		setToParentInnerY();
	}

	private void layoutBottomRight() {
		anchorRight();
		anchorBottom();
	}

	private void layoutBottomLeft() {
		setToParentInnerX();
		anchorBottom();
	}

	private void layoutCenterLeft() {
		setToParentInnerX();
		centerVertical();
	}

	private void layoutCenterTop() {
		setToParentInnerY();
		centerHorizontal();
	}

	private void layoutCenterRight() {
		centerVertical();
		anchorRight();
	}

	private void layoutCenterBottom() {
		centerHorizontal();
		anchorBottom();
	}

	private void layoutCenter() {
		centerVertical();
		centerHorizontal();
	}

	private void layoutLeftWide() {
		setToParentInnerCoordinates();
		setToParentInnerHeight();
	}

	private void layoutTopWide() {
		setToParentInnerCoordinates();
		setToParentInnerWidth();
	}

	private void layoutRightWide() {
		anchorRight();
		setToParentInnerY();
		setToParentInnerHeight();
	}

	private void layoutBottomWide() {
		setToParentInnerX();
		anchorBottom();
		setToParentInnerWidth();
	}

	private void layoutVerticalCenterWide() {
		centerHorizontal();
		setToParentInnerY();
		setToParentInnerHeight();
	}

	private void layoutHorizontalCenterWide() {
		setToParentInnerX();
		setToParentInnerWidth();
		centerVertical();
	}

	private void layoutFullRectangle() {
		setToParentInnerCoordinates();
		setToParentInnerWidth();
		setToParentInnerHeight();
	}

	public Anchor getAnchor() {
		return anchor;
	}

	public void setAnchor(Anchor anchor) {
		this.anchor = anchor;
	}

}
