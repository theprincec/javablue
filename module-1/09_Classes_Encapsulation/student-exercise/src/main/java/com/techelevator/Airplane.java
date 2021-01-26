package com.techelevator;

public class Airplane {
	
	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;
	

	private int availableFirstClassSeats;
	private int availableCoachSeats;
	
	
	
	
	public String getPlaneNumber() {
		return this.planeNumber;
		
	}
	//public int getPlaneNumber() {
		//return this.planeNumber;
	//}
	public int getBookedFirstClassSeats() {
		return this.bookedFirstClassSeats;
		
	}
	public int getTotalFirstClassSeats() {
		return this.totalFirstClassSeats;
		
	}
	public int getTotalCoachSeats() {
		return this.totalCoachSeats;
	}
	
	public int getBookedCoachSeats() {
		return this.bookedCoachSeats;
	}
	
	//setters
	
	//public void  setPlaneNumber(String planeNumber) {
		//this.planeNumber=planeNumber;	
	//}

	public void getBookedFirstClassSeats(int bookedFirstClassSeats) {
		this.bookedFirstClassSeats=bookedFirstClassSeats;
		
	}
	public void getTotalFirstClassSeats(int totalFirstClassSeats) {
		this.totalFirstClassSeats=totalFirstClassSeats;
		
	}
	public void getTotalCoachSeats(int totalCoachSeats) {
		this.totalCoachSeats=totalCoachSeats;
	}
	
	public void getBookedCoachSeats(int bookedCoachSeats) {
		this.bookedCoachSeats=bookedCoachSeats;
	}
	
	
	
	//derived
	public int getAvailableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}
	public int getAvailableCoachSeats() {
		return totalCoachSeats - bookedCoachSeats;
	}

	
	//constructors
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		
	}
	
	
	//methods
	
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass==true) {
			bookedFirstClassSeats+=totalNumberOfSeats;
		} 
		else {
			bookedCoachSeats+=totalNumberOfSeats;
		}
		if (bookedFirstClassSeats<totalFirstClassSeats || bookedCoachSeats<totalCoachSeats) {
			return true;
		} else {
			return false;
		}
	}
	
	
	

}
