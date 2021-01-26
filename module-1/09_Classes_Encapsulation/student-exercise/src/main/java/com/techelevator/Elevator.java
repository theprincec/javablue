package com.techelevator;

public class Elevator {
	
	private int currentFloor;
	private int numberOfFloors;
	private boolean doorOpen;
	
	
	
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	public boolean isDoorOpen() {
		return doorOpen;
	}
	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}
	
	
	
	//constructors
	public void Elevator(int numberOfLevels) {
		this.currentFloor = 1;
		this.numberOfFloors = numberOfLevels;
		this.doorOpen = false;
	}
	
	
	
	
//	methods
	
	
	public void openDoor() {
		doorOpen= true ;
	}
	public void closeDoor() {
		doorOpen=false ;
	}
	public void goUp(int desiredFloor) {
		if (doorOpen || desiredFloor<=numberOfFloors) {
			currentFloor=desiredFloor;
		}
	}
	public void goDown(int desiredFloor) {
		if (doorOpen || desiredFloor>1) {
			currentFloor=desiredFloor;
		}
	}
	

}
