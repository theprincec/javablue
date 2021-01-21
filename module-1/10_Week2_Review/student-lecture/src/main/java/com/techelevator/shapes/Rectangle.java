package com.techelevator.shapes;

public class Rectangle {

	// State
	private int length;
	private int width;
	
	// How to instantiate a Rectangle Object  (how to a build a Rectangle)
	
	/*
	 * The no-argument default constructor is implicity used by Java 
	 * unless an explicit constructor is set.  Meaning, if this is the
	 * only constructor needed, then it doesn't need to be included.
	 */
	public Rectangle() {}
	
	public Rectangle( int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	// Behavior
	/*
	 * Public methods provide the way others use the object
	 */
	public boolean isLargerThan(Rectangle other) {
		boolean isLarger = calculateIfLarger(other);
		return isLarger;
	}
	
	public boolean isLargerThan( int otherWidth, int otherLength) {
		return this.getArea() > (otherWidth * otherLength);
	}
	
	/*
	 * Private methods do work internal to the workings of the object
	 */
	private boolean calculateIfLarger(Rectangle other) {
		return this.getArea() > other.getArea();
	}
	
	@Override
	public boolean equals(Object other) {
		Rectangle otherRectangle = (Rectangle) other;
		
		return otherRectangle.getLength() == this.length && 
				otherRectangle.getWidth() == this.width;
	}
	
	@Override
	public String toString() {
		return this.width + "x" + this.length + " - " + this.getArea();
	}
	
	
	// Getters provide access to publically retrieve the value of a member 
	// variable
	public int getLength() {
		return this.length;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	// Setter provides access to publically set the value of a member variable
	public void setLength(int length) {
		this.length = Math.abs(length);
	}
	
	public void setWidth(int width) {
		this.width = Math.abs(width);
	}
	
	/*
	 * A Dervived property is one that is calculated as needed
	 * It is NOT stored as a member variable, but is calculated (derived) from
	 * the existing member variables.
	 */
	public int getArea() {
		return this.width * this.length;
	}
}
