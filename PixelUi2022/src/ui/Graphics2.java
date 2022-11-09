package ui;

import java.awt.Color;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

public interface Graphics2 {
	
	void setColor(Color color);
	
	void drawLine(int x0, int y0, int x1, int y1);
	
	void drawRect(int x, int y, int width, int height);
	
	void fillRect(int x, int y, int width, int height);
	
	void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight);
	
	void translate(int x, int y);
	
	void drawString(String text, int x, int y);
	
	void drawImage(BufferedImage image, int x, int y);
	
	void fillArea(Area area);
	
	void textSize(int textSize);

}
