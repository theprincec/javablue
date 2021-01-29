package com.techelevator.farm;

public class Sheep extends FarmAnimal implements Sellable {

	public Sheep() {
		super("Sheep", "baa!");
	}

	@Override
	public int getPrice() {
		return 300;
	}

	@Override
	public String eat() {
		return "The sheep eats";
	}
	
	
}
