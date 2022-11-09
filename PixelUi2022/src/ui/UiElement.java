package ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import ui.border.Border;
import ui.border.Insets;
import ui.layout.Anchor;
import ui.layout.Layout;
import ui.layout.LayoutAnchor;
import ui.layout.NullLayout;

public class UiElement {

	private int x;
	private int y;
	private int layoutX;
	private int layoutY;
	private int layoutWidth;
	private int layoutHeight;
	private int width;
	private int height;
	private boolean opaque;
	private Border border;
	private Insets margin;
	private Insets padding;
	private Color background;
	private Layout layout;
	private LayoutAnchor layoutAnchor;
	private UiElement parent;
	private List<UiElement> children;

	public UiElement() {
		opaque = true;
		margin = new Insets();
		padding = new Insets();
		background = Color.GRAY;
		layout = new NullLayout();
		layoutAnchor = new LayoutAnchor(Anchor.NONE);
		children = new ArrayList<UiElement>();
	}
	
	private void layout() {
		getLayout().layout(this);
		layoutAnchor.anchor(this);
		layoutChildren();
	}
	
	private void layoutChildren() {
		for (int i = 0; i < getChildCount(); i++) {
			UiElement child = getChildAt(i);
			child.layout();
		}
	}

	public void render(Graphics2 g2d) {
		g2d.translate(getLayoutX(), getLayoutY());
		renderBackground(g2d);
		renderBorder(g2d);
		renderContent(g2d);
		renderChildren(g2d);
		g2d.translate(-getLayoutX(), -getLayoutY());
	}

	protected void renderBackground(Graphics2 g2d) {
		if (!opaque)
			return;
		g2d.setColor(getBackground());
		g2d.fillRect(getContentBoxX(), getContentBoxY(), getContentBoxWidth(), getContentBoxHeight());
	}

	protected void renderContent(Graphics2 g2d) {

	}

	protected void renderBorder(Graphics2 g2d) {
		if (border == null)
			return;
		border.renderBorder(g2d, getBorderBoxX(), getBorderBoxY(), getBorderBoxWidth(), getBorderBoxHeight());
	}

	protected void renderChildren(Graphics2 g2d) {
		g2d.translate(getContentX(), getContentY());

		for (int i = 0; i < getChildCount(); i++) {
			UiElement child = getChildAt(i);
			child.render(g2d);
		}

		g2d.translate(-getContentX(), -getContentY());
	}

	public void add(UiElement uiElement) {
		if (uiElement == null)
			return;
		uiElement.setParent(this);
		children.add(uiElement);
		layout();
	}
	
	public void setLayoutAnchor(Anchor anchor) {
		layoutAnchor.setAnchor(anchor);
	}
	
	public boolean isRoot() {
		return getParent() == null;
	}
	
	public UiElement getParent() {
		return parent;
	}
	
	protected void setParent(UiElement parent) {
		this.parent = parent;
	}
	
	public int getChildCount() {
		return children.size();
	}
	
	public UiElement getChildAt(int index) {
		return children.get(index);
	}

	public int getContentX() {
		return x + getMarginLeft() + getBorderInsets().left + padding.left;
	}

	public int getContentY() {
		return y + getMarginTop() + getBorderInsets().top + padding.top;
	}

	public int getBorderBoxX() {
		return x + getMarginLeft();
	}

	public int getBorderBoxY() {
		return y + getMarginTop();
	}

	public int getBorderBoxWidth() {
		int width = getWidth();
		Insets borderInsets = getBorderInsets();
		width += borderInsets.getHorizontalInsets();
		width += padding.getHorizontalInsets();
		width += layoutWidth;
		return width;
	}

	public int getBorderBoxHeight() {
		int height = getHeight();
		Insets borderInsets = getBorderInsets();
		height += borderInsets.getVerticalInsets();
		height += padding.getVerticalInsets();
		height += getLayoutHeight();
		return height;
	}

	public int getContentBoxX() {
		return getMarginLeft() + getBorderInsets().left;
	}

	public int getContentBoxY() {
		return getMarginTop() + getBorderInsets().top;
	}

	public int getContentBoxWidth() {
		return getWidth() + getLayoutWidth() + getHorizontalPadding();
	}

	public int getContentBoxHeight() {
		return getHeight() + getLayoutHeight() + getVerticalPadding();
	}
	
	public int getContentWidth() {
		return getWidth() + getLayoutWidth();
	}
	
	public int getContentHeight() {
		return getHeight() + getLayoutHeight();
	}

	public Insets getBorderInsets() {
		if (border == null)
			return new Insets();
		return border.getInsets();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Border getBorder() {
		return border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}
	
	public int getHorizontalPadding() {
		return padding.getHorizontalInsets();
	}
	
	public int getVerticalPadding() {
		return padding.getVerticalInsets();
	}

	public Insets getMargin() {
		return margin;
	}
	
	public int getMarginLeft() {
		return margin.left;
	}
	
	public void setMarginLeft(int marginLeft) {
		margin.left = marginLeft;
	}
	
	public int getMarginRight() {
		return margin.right;
	}
	
	public void setMarginRight(int marginRight) {
		margin.right = marginRight;
	}
	
	public int getMarginTop() {
		return margin.top;
	}
	
	public void setMarginTop(int marginTop) {
		margin.top = marginTop;
	}
	
	public int getMarginBottom() {
		return margin.bottom;
	}
	
	public void setMarginBottom(int marginBottom) {
		margin.bottom = marginBottom;
	}

	public void setMargin(int margin) {
		this.margin.set(margin);
	}

	public Insets getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding.set(padding);
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public int getLayoutX() {
		return layoutX;
	}

	public void setLayoutX(int layoutX) {
		this.layoutX = layoutX;
	}

	public int getLayoutY() {
		return layoutY;
	}

	public void setLayoutY(int layoutY) {
		this.layoutY = layoutY;
	}

	public int getLayoutWidth() {
		return layoutWidth;
	}

	public void setLayoutWidth(int layoutWidth) {
		this.layoutWidth = layoutWidth;
	}

	public int getLayoutHeight() {
		return layoutHeight;
	}

	public void setLayoutHeight(int layoutHeight) {
		this.layoutHeight = layoutHeight;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		if (layout == null) {
			this.layout = new NullLayout();
		} else {
			this.layout = layout;
		}	
		layout();
	}

	public boolean isOpaque() {
		return opaque;
	}

	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}

}
