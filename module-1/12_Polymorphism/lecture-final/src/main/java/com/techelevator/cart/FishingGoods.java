package com.techelevator.cart;

public class FishingGoods implements Inventory {

	private String name;
	private double price;
	private double discount;
	
	public FishingGoods(String name, double price, double discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	
	@Override
	public double getPrice() {
		return price - (price * discount);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double calculateShipping(int distance) {
		return 10;
	}

}
