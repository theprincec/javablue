package com.techelevator.inventory;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.inventory.reader.InventoryReader;

public class Inventory {

	private Map<String, Slot> items;
	
	public Inventory(InventoryReader reader ) throws FileNotFoundException {
		items = reader.read();
	}
	
	public Map<String, Slot> getItems() {
		return this.items;
	}
}
