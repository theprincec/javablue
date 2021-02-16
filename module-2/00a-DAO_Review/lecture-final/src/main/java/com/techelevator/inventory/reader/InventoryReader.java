package com.techelevator.inventory.reader;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.inventory.Item;
import com.techelevator.inventory.Slot;

public interface InventoryReader {

	Map<String, Slot> read() throws FileNotFoundException;
}
