package com.techelevator.review.polymorphism;

import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.review.interfaces.items.FileItemReader;
import com.techelevator.review.interfaces.items.Item;
import com.techelevator.review.interfaces.items.ItemReader;
import com.techelevator.review.interfaces.items.MemoryItemReader;

import java.util.Scanner;

public class PolymorphismWithInterfaces {

	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		ItemReader reader = null;
		
		while (reader == null) {
			System.out.print("Read Inventory from (M)emory or (F)ile >>>");
			String userSelection = in.nextLine();
			
			if (userSelection.equalsIgnoreCase("M")) {
				reader = new MemoryItemReader();
			} else if (userSelection.equalsIgnoreCase("F")) {
				reader = new FileItemReader("inventory.csv");
			} else {
				System.out.println("Unknown Selection!");
			}
		}

		Map<String, Item> items = reader.read();
		
		for (Entry<String, Item> entry : items.entrySet()) {
			
			System.out.println(entry.getKey() + ") " 
					+ entry.getValue().getName() + " : $" 
					+ entry.getValue().getPrice());
		}
		

	}

}
