package com.techelevator.shapes;

public class RecantagleDemoClass {

	public static void main(String[] args) {
		
		
		Rectangle rect = new Rectangle(10, 30);
		Rectangle rect2 = new Rectangle();
		Rectangle rect3 = new Rectangle();
		
		rect.setLength(-10);
		rect.setWidth(15);
		
		rect2.setLength( 12 );
		rect2.setWidth( 8 );
		
		System.out.println( rect.getLength() );
		System.out.println( rect2.getLength() );
		
		System.out.println( rect.getArea() );
		
		System.out.println( rect.isLargerThan(rect2) );

		rect3.setLength( 100 );
		rect3.setWidth( 75 );
		
		rect.isLargerThan( rect3 );
		
		boolean isLarger = rect3.isLargerThan(rect2);
		isLarger = rect3.isLargerThan(50, 60);
		
		Rectangle sameSizeAsRect1 = new Rectangle(rect.getLength(), rect.getWidth());
		
		if (rect.equals(sameSizeAsRect1)) {
			System.out.println("The Rectangles are equal");
		} else {
			System.out.println("The Rectangles are not equal");
		}
		
		System.out.println( rect );
		
		String rectangleAsString = rect.toString();
		
		
	}

}
