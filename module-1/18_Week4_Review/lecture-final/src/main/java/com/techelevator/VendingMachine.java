package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.Slot;
import com.techelevator.inventory.reader.FileInventoryReader;
import com.techelevator.inventory.reader.InventoryReader;

public class VendingMachine {

	private Inventory inventory;
	
	public VendingMachine(String filename) throws FileNotFoundException {
		InventoryReader reader = new FileInventoryReader(filename);
		inventory = new Inventory(reader);
	}
	
	public Map<String, Slot> getInventory() {
		return inventory.getItems();
	}
}
