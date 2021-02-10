package com.techelevator;

import org.junit.*;

public class HotelReservationTest {

	private HotelReservation reservation;
	
	@Before
	public void setup() {
		reservation = new HotelReservation("Rachelle", 2);
	}
	
	
	@Test
	public void estimated_total() {
		// Arrange 
		// Act
		double actual = reservation.getEstimatedTotal();
		// Assert
		Assert.assertEquals((59.99 * 2), actual, .009);
	}
	
	@Test
	public void actual_total_with_minibar_and_cleaning() {
		double actual = reservation.calculateActualTotal(true, true);
		double expected = (59.99 * 2) + 12.99 + (34.99 * 2);
		Assert.assertEquals(expected, actual, .009);
	}
}
