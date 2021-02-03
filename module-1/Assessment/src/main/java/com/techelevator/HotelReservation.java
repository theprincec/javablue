package com.techelevator;

public class HotelReservation {
	
	
//	`name`: indicates the name on the reservation.
//    * `number of nights`: indicates how many nights the reservation is for.
//    * `estimated total`: indicates the estimated total using `number of nights` times a daily rate of $59.99.
//	
	

	private String name;
	private int numberOfNights;
	double estimatedTotal;
	
	
	public HotelReservation(String name, int numberOfNights) {
		this.name = name;
		this.numberOfNights = numberOfNights;
		this.estimatedTotal = numberOfNights*59.99;
	}
	
	
	
//	If the minibar was used, a fee of $12.99 is added to the estimated total.
//    * If the room requires cleaning, a fee of $34.99 is added to the estimated total.
//    * The cleaning fee is doubled if the minibar was used.
	
	public double checkRoom(boolean requiresCleaning, boolean usedMinibar) {
		if (requiresCleaning) {
			estimatedTotal+=34.99;
		}
		if (usedMinibar) {
			estimatedTotal += 12.99;
		}
		return estimatedTotal;
	}
	
	

	public String toString() {
		//System.out.println("RESERVATION -" + name + "- " + estimatedTotal);
		return "RESERVATION - " + name + " - " + estimatedTotal;
	}
	
	
	

}
