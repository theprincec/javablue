package com.techelevator;

public class SquareWall extends RectangleWall {
	private int sideLength;

	public SquareWall(String name, String color, int sideLength) {
		super(name, color, sideLength, sideLength);
		this.sideLength = sideLength;
	}

	public int getSideLength() {
		return sideLength;
	}

	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return sideLength*sideLength;
	}
	
	
	public String toString() {
		return getName() + " (" + sideLength + "x" + sideLength + ") square";
	}
	
	
	

}
