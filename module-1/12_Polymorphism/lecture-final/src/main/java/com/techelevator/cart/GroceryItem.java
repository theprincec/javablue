package com.techelevator.cart;

public class GroceryItem implements Inventory {

	private String name;
	private boolean perishable;
	private double price;
	private double weight;
		
	public GroceryItem(String name, boolean perishable, double price, double weight) {
		super();
		this.name = name;
		this.perishable = perishable;
		this.price = price;
		this.weight = weight;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name + ( perishable ? " (Perishable)" : "");
	}

	@Override
	public double calculateShipping(int distance) {
		
		double shipping = weight * distance;
		
		if (perishable) {
			shipping *= 2;
		}
		
		return shipping;
	}

	
	
}
