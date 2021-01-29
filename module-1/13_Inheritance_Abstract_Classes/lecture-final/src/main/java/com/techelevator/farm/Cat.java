package com.techelevator.farm;

public final class Cat extends FarmAnimal {

	public Cat() {
		super("Cat", "Meow");
	}
	
	
/*
 * Trying to Override getSound() causes a compile error,
 * because getSound() is declared final in the superclass
 */
//	@Override
//	public String getSound() {
//		return "MEOW!!!";
//	}
	
	
	@Override
	public String eat() {
		return "The cat crunches some food";
	}
}
