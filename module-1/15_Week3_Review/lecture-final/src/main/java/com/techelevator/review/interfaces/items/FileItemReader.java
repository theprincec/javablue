package com.techelevator.review.interfaces.items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileItemReader implements ItemReader {

	private File inventoryFile;
	
	public FileItemReader(String filename) {
		inventoryFile = new File(filename);
	}
	
	
	@Override
	public Map<String, Item> read() {
		List<String> lines = readLinesFromFile();
		return buildItemsFromLines(lines);
	}
	
	private Map<String, Item> buildItemsFromLines(List<String> lines) {
		
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		
		for (String line : lines) {
			String[] parts = line.split(",");
			items.put(parts[0], new Item(parts[1], Double.parseDouble(parts[2])));
		}
		
		return items;
		
	}
	
	
	private List<String> readLinesFromFile() {
		List<String> lines = new ArrayList<String>();
		
		try (Scanner file = new Scanner(inventoryFile)) {
			
			while (file.hasNextLine()) {
				lines.add(file.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			// This is bad - don't do this
			e.printStackTrace();
		}
		
		return lines;
	}

}
