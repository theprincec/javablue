package com.techelevator.review.interfaces.items;

public class Item {

	private String name;
	private double price;
	
	public Item() {}
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
