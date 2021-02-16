package com.techelevator.inventory.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.Candy;
import com.techelevator.inventory.Chip;
import com.techelevator.inventory.Drink;
import com.techelevator.inventory.Gum;
import com.techelevator.inventory.Item;
import com.techelevator.inventory.Slot;

public class FileInventoryReader implements InventoryReader {

	private File inventoryFile;
	
	public FileInventoryReader(String filename) {
		inventoryFile = new File(filename);
	}
	

	@Override
	public Map<String, Slot> read() throws FileNotFoundException {
		List<String>  linesFromFile = readLinesFromFile();
		Map<String, Slot> inventory = new LinkedHashMap<String, Slot>();
		
		for (String line : linesFromFile) {
			String[] parts = line.split("\\|");
			String key = parts[0];
			Slot slot = createSlot(parts[3], parts[1],Double.parseDouble(parts[2]));
			inventory.put(key, slot);
		}
		
		return inventory;
	}
	
	private Slot createSlot(String type, String name, double price) {
		Item item = null;
		
		if (type.equalsIgnoreCase("Chip")) {
			item = new Chip(name, price);
		} else if (type.equalsIgnoreCase("Candy")) {
			item = new Candy(name, price);
		} else if (type.equalsIgnoreCase("Drink")) {
			item = new Drink(name, price);
		} else if (type.equalsIgnoreCase("Gum")) {
			item = new Gum(name, price);
		}
		
		return new Slot(item);
		
	}
	
	
	private List<String> readLinesFromFile() throws FileNotFoundException {
		
		List<String> linesFromFile = new ArrayList<String>();
		try (Scanner fileReader = new Scanner(inventoryFile)) {
			while (fileReader.hasNextLine()) {
				linesFromFile.add(fileReader.nextLine());
			}
		}
		
		return linesFromFile;
	}

}
