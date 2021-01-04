package Learn_Detect;

import lejos.robotics.Color;

public class MyColor {
	public Color myColor;

	public MyColor(Color c) {
		myColor = c;
	}

	public MyColor() {
		myColor = null;
	}

	public double myDistance(Color c) {
		double x = Math.pow(c.getBlue() - myColor.getBlue(), 2) + Math.pow(c.getGreen() - myColor.getGreen(), 2)
				+ Math.pow(c.getRed() - myColor.getRed(), 2);
		return Math.sqrt(x);

	}
	
}
