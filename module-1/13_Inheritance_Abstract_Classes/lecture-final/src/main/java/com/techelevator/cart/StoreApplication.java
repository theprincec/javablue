package com.techelevator.cart;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StoreApplication {

	private final static ShoppingCart cart = new ShoppingCart();
	private final static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Map<String, Inventory> items = getInventory();

		String userSelection = "";
		
		while (true) {
			printItems(items);
			
			System.out.print("Select an item or (C)heckout >>>");
			userSelection = in.nextLine();
			
			if (userSelection.equalsIgnoreCase("C")) {
				break;
			}
			
			Inventory item = items.get(userSelection.toUpperCase());
			if (item == null) {
				System.out.println("Item not found!");
			} else {
				cart.add(item);
			}
			
		}
		
		System.out.println();
		
		System.out.print("How far do you need to ship it >>>");
		int distance = in.nextInt();
		in.nextLine();
		
		System.out.println();
		
		
		System.out.println("Your cart contains " + cart.numberOfItems() + " items");
		// Checkout
		for (Inventory item : cart.items()) {
			System.out.println( item.getName() + " - $" 
						+ item.getPrice() + " - Shipping: $"
						+ item.calculateShipping( distance ));
		}
		
		System.out.println("Total Price: " + cart.getTotalPrice());
		
		
		
	}
	
	private static void printItems(Map<String, Inventory> items) {
		
		for (Entry<String, Inventory> item : items.entrySet()) {
			System.out.println( item.getKey() + ") " + item.getValue().getName());
		}
		
	}
	
	
	private static Map<String, Inventory> getInventory() {
		Map<String, Inventory> items = new LinkedHashMap<String, Inventory>();
		
		items.put("A1", new Furniture("Chair", 75, 12));
		items.put("B1", new FlameThrower());
		items.put("C1", new FishingGoods("Tacklebox", 25, .10));
		items.put("D1", new GroceryItem("Milk", true, 2.50, .25));
		items.put("D2", new GroceryItem("Broccoli", true, 1.95, .05));
		
		return items;
		
	}

}
