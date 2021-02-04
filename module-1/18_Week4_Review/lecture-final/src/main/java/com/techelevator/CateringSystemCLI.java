package com.techelevator;

import java.io.FileNotFoundException;

import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;
	private VendingMachine vendingMachine;
	
	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		
		//TODO: Remove hard coded file name
		String filename = menu.getResponseFromUser("Inventory File name:");
		
		try {
			vendingMachine = new VendingMachine(filename);
		} catch (FileNotFoundException e) {
			menu.showErrorToUser(e.getMessage());
			System.exit(1);
		}
		
		
		while (true) {
			/*
			Display the Starting Menu and get the users choice
			
			IF the User Choice is Display Vending Machine Items, 
				THEN display vending machine items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/
			int choice = menu.getSelectionFromMainMenu();
			if (choice == 1) {
				menu.displayItems(vendingMachine.getInventory());
			} else if (choice == 2) {
				// Purchase Items
			} else {
				// Exit
				System.out.println("Thank you!");
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
