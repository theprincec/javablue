package com.techelevator.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.inventory.Slot;

public class Menu {

	private static final Scanner in = new Scanner(System.in);
	
	
	public String getResponseFromUser(String question) {
		System.out.println(question);
		return in.nextLine();
	}
	
	public void showErrorToUser(String error) {
		System.out.println("**** " + error + " ****");
	}
	
	public int getSelectionFromMainMenu() {
		
		int selection = 0;
		
		while (selection == 0) {
			System.out.println("(1) Display Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			
			String userSelection = in.nextLine();
			// Make sure the user selected 1, 2, 3 here and have them retry if they didn't
	
			try {
				selection = Integer.parseInt(userSelection);
			} catch (NumberFormatException e)  {
				System.out.println("Please enter a number");
				selection = 0;
			}
		}
		
		return selection;
	}
	
	public void displayItems(Map<String, Slot> items) {
		for (Entry<String, Slot> itemEntry : items.entrySet()) {
			System.out.print(itemEntry.getKey() + "  ");
			System.out.print(itemEntry.getValue().getItem().getName() + " ");
			System.out.print("$" + itemEntry.getValue().getItem().getPrice());
			System.out.println(" - " + itemEntry.getValue().getCount());
		}
	}
}
