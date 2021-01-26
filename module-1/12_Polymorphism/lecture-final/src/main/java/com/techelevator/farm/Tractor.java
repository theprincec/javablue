package com.techelevator.farm;

public class Tractor implements Singable {
	
	@Override
	public String getSound() {
		return "Rrrrrrr";
	}
	
	@Override
	public String getName() {
		return "Tractor";
	}

	@Override
	public int doSomething(double x) {
		
		return (int) x * 10;
	}
	
	
}
