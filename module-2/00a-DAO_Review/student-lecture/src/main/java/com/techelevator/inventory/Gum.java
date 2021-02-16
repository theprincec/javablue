package com.techelevator.inventory;

public class Gum extends Item {

	public Gum(String name, double price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return "Chew Chew, Yum!";
	}
}
