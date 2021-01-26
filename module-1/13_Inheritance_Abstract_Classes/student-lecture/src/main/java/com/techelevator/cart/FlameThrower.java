package com.techelevator.cart;

public class FlameThrower implements Inventory {

	@Override
	public double getPrice() {
		return 500;
	}

	@Override
	public String getName() {
		return "Flame Thrower";
	}

	@Override
	public double calculateShipping(int distance) {
		return 400;
	}

}
