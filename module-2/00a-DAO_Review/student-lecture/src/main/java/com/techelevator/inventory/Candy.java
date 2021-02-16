package com.techelevator.inventory;

public class Candy extends Item {

	public Candy(String name, double price) {
		super(name, price);
	}

	@Override
	public String eat() {
		return "Munch Munch, Yum!";
	}
}
