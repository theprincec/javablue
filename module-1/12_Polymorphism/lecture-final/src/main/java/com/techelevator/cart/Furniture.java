package com.techelevator.cart;

public class Furniture implements Inventory {

	private String name;
	private double price;
	private int weight;
	
	public Furniture(String name, double price, int weight) {
		this.price = price;
		this.weight = weight;
		this.name = name;
	}
	
	
	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double calculateShipping(int distance) {
		return (weight * .5) * distance;
	}

	
}
