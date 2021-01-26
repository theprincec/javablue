package com.techelevator.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Inventory> items = new ArrayList<Inventory>();
	
	public void add(Inventory item) {
		items.add(item);
	}
	
	public int numberOfItems() {
		return items.size();
	}
	
	public List<Inventory> items() {
		return items;
	}
	
	public double getTotalPrice() {
		double total = 0d;
		
		for (Inventory item : items) {
			total += item.getPrice();
		}
		
		return total;
	}
}
