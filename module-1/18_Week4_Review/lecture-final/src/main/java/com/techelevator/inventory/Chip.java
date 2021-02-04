package com.techelevator.inventory;

public class Chip extends Item {

	public Chip(String name, double price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return "Crunch Crunch, Yum!";
	}

}
