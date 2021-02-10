package com.techelevator;

public class HotelReservation {

	private String name;
	private int numberOfNights;
	
	public HotelReservation(String name, int numberOfNights) {
		this.name = name;
		this.numberOfNights = numberOfNights;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getName() {
		return name;
	}
	
	public double getEstimatedTotal() {
		return 59.99 * this.numberOfNights;
	}
	
	public double calculateActualTotal(boolean requiresCleaning, boolean usedMinibar) {
		
		double total = getEstimatedTotal();
		
		if (usedMinibar) {
			total += 12.99;
		}
		if (requiresCleaning && usedMinibar) {
			total += (34.99 * 2);
		} else if (requiresCleaning && !usedMinibar) {
			total+= 34.99;
		}
		
		return total;
		
	}
	
	@Override
	public String toString() {
		return "RESERVATION - " + this.name + " - " + getEstimatedTotal();
	}
 }
