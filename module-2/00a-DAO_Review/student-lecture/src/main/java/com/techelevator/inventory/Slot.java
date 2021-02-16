package com.techelevator.inventory;

public class Slot {

	private int count = 5;
	private Item item;
	
	public Slot(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getCount() {
		return this.count;
	}
}
