package com.techelevator.inventory.reader;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.inventory.Candy;
import com.techelevator.inventory.Chip;
import com.techelevator.inventory.Drink;
import com.techelevator.inventory.Gum;
import com.techelevator.inventory.Item;
import com.techelevator.inventory.Slot;

public class JdbcInventoryReader implements InventoryReader {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcInventoryReader(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Map<String, Slot> read() throws FileNotFoundException {
		Map<String, Slot> inventory = new LinkedHashMap<String, Slot>();
		
		String sql = "SELECT slot, name, price, type FROM inventory";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while (rows.next()) {
			String itemKey = rows.getString("slot");
			Slot slot = mapRowToSlot(rows);
			inventory.put(itemKey, slot);
		}
		return inventory;
	}
	
	private Slot mapRowToSlot(SqlRowSet row) {
		Item item = null;
		String type = row.getString("type");
		String name = row.getString("name");
		double price = row.getDouble("price");
		
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

}
