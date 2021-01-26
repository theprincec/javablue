package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal[] animals = new FarmAnimal[] { new Cow(), new Chicken(), new Sheep(), new Cat() };
		
		System.out.println("Animals on the farm: ");
		for (FarmAnimal animal : animals) {
			System.out.println(animal.getName());
		}
		
		System.out.println();
		
		Singable[] singers = new Singable[] { new Cow(), new Chicken(), 
					new Sheep(), new Tractor(), new Cat(), new MusicBox() };

		for (Singable singer : singers) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		
		Sellable[] itemsForSale = new Sellable[] { new Cow(), new Chicken(), 
														new Sheep(), new MusicBox() };
		
		System.out.println("For Sale:");
		for (Sellable item : itemsForSale) {
			System.out.println(item.getName() + " $" + item.getPrice());
		}
	}
}