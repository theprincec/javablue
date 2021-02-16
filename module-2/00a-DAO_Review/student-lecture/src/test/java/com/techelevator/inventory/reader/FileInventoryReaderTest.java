package com.techelevator.inventory.reader;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.*;

import com.techelevator.inventory.Slot;

public class FileInventoryReaderTest {

	private FileInventoryReader reader;
	
	@Before
	public void setup() {
		reader = new FileInventoryReader("vendingmachine.csv");
	}
	
	@Test
	public void read_inventory_from_file() throws FileNotFoundException {
		Map<String, Slot> items = reader.read();
		Assert.assertEquals(16, items.size());
	}
	
}
