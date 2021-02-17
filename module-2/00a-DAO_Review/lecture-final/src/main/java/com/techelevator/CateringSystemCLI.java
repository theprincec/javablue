package com.techelevator;

import java.io.FileNotFoundException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.inventory.reader.FileInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.JdbcInventoryReader;
import com.techelevator.log.JdbcLogDao;
import com.techelevator.log.LogDao;
import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;
	private VendingMachine vendingMachine;
	private BasicDataSource dataSource;
	
	public CateringSystemCLI(Menu menu) {
		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/vendingmachine");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		this.menu = menu;
	}

	public void run() {
		LogDao log = new JdbcLogDao(dataSource);
		InventoryReader inventoryReader = getInventoryReader();
		
		try {
			// Can pass a DAO in the constructor to be used in the class
			vendingMachine = new VendingMachine(inventoryReader);
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
				// Can pass a DAO as an argument to a method to be used
				menu.exampleOfUsingLogInAnotherClass(log);
			} else if (choice == 2) {
				int amountToAdd = menu.getAmountToAdd();
				vendingMachine.addMoney(amountToAdd, log);
			} else {
				// Exit
				System.out.println("Thank you!");
				System.exit(1);
			}
		}
	}	
	
	private InventoryReader getInventoryReader() {
	
		InventoryReader reader = null;
	
		while (true) {
			String selection = menu.getResponseFromUser("Use (D)atabase of (F)ile: ");
			
			if (selection.equalsIgnoreCase("F")) {
				String filename = menu.getResponseFromUser("Inventory File name:");
				reader = new FileInventoryReader(filename);
				break;
			
			} else if (selection.equalsIgnoreCase("D")) {
				
				reader = new JdbcInventoryReader(dataSource);
				break;
			
			} else {
				menu.showErrorToUser("Invalid selection!");
			}
		}
		
		return reader;

	}
	
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
