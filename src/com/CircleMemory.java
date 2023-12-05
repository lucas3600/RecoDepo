package com;

import javafx.scene.shape.Circle;

public class CircleMemory extends Circle{
	private double  iniX;
	private double iniY;
	private double iniRadius;
	
	public CircleMemory(double x,double y,double radius) {
		super(x,y,radius);
		iniX = x;
		iniY = y;
		iniRadius = radius;
	}

	public double getIniX() {
		return iniX;
	}


	public double getIniY() {
		return iniY;
	}



	public double getIniRadius() {
		return iniRadius;
	}


	
	
}
