package com.techelevator;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Slot;
import com.techelevator.inventory.reader.FileInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.log.Log;
import com.techelevator.log.LogDao;

public class VendingMachine {

	private Inventory inventory;
	private int balance;
	
	public VendingMachine(InventoryReader reader) throws FileNotFoundException {
		inventory = new Inventory(reader);
	}
	
	public Map<String, Slot> getInventory() {
		return inventory.getItems();
	}
	
	public void addMoney(int amount, LogDao log) {
		int startingBalance = balance;
		balance += amount;
		
		Log logEntry = new Log();
		logEntry.setAction("ADD MONEY");
		logEntry.setBeginningBalance(startingBalance);
		logEntry.setEndingBalance(balance);
		logEntry.setEntryDate(LocalDate.now());
		
		log.save(logEntry);
	}
	
}
