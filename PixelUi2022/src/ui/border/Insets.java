package ui.border;

public class Insets {

	public int top;
	public int left;
	public int bottom;
	public int right;
	
	public Insets() {
		this(0, 0, 0, 0);
	}
	
	public Insets(Insets insets) {
		this(insets.top, insets.left, insets.bottom, insets.right);
	}
	
	public Insets(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}
	
	public void add(Insets other) {
		top += other.top;
		left += other.left;
		bottom += other.bottom;
		right += other.right;
	}
	
	public void set(int size) {
		set(size, size, size, size);
	}
	
	public void set(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}
	
	public int getHorizontalInsets() {
		return left + right;
	}
	
	public int getVerticalInsets() {
		return top + bottom;
	}
	
}
