package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
	
	
	private HotelReservation hotelReservation;
	
	
	
	@Before
	public void setup() {
	hotelReservation = new HotelReservation("name", 1);
	}
	
	
	
	@Test
	public void name_christan_with_1_night() {
		hotelReservation = new HotelReservation("christian", 1);
		
		//String expectedTotal =
		
		double actualTotal = hotelReservation.estimatedTotal;
		
		Assert.assertEquals(59.99, actualTotal, 0);
		
	}
	
	
	@Test
	public void name_christan_with_1_cleaning() {
		hotelReservation = new HotelReservation("christian", 1);
		
		double expectedTotal = 154.97 - 59.99;
		
		double actualTotal = hotelReservation.checkRoom(true, false);
		
		Assert.assertEquals(expectedTotal, actualTotal, 0);
		
	}
	
	
	
	

}


