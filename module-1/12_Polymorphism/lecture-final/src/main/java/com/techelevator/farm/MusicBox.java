package com.techelevator.farm;

public class MusicBox implements Singable, Sellable {

	@Override
	public int getPrice() {
		return 15;
	}

	@Override
	public String getSound() {
		return "Lalalala";
	}

	@Override
	public String getName() {
		return "Music Box";
	}

	@Override
	public int doSomething(double x) {
		return (int) x * 15;
	}

}
