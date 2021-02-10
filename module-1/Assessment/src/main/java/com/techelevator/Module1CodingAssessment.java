package com.techelevator;

public class Module1CodingAssessment {

	private static HotelReservation testReservation;



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		//Car carNotTrailer = new Car(false, random);
		
		testReservation = new HotelReservation("testReservationName", 2);
	
		//System.out.println(testReservation.estimatedTotal);
	
		double total = testReservation.estimatedTotal;
		
		double checkedRoom= 0;
		
		checkedRoom = testReservation.checkRoom(true, false);
		//total = 75;
		
		
		
		System.out.println(total);
		System.out.println(checkedRoom);
		System.out.println(testReservation.toString());
		
	
	
	}
}
