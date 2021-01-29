package com.techelevator.review.interfaces.items;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryItemReader implements ItemReader {

	@Override
	public Map<String, Item> read() {
		
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		
		items.put("A", new Item("New Kids On the Block T-Shirt", 20));
		items.put("B", new Item("Tiger Print Flame Thrower", 2501));
		items.put("C", new Item("1000 Live Bees", 15));
		items.put("D", new Item("Barney vs Godzilla", 5.50));
		
		return items;
	}

}
