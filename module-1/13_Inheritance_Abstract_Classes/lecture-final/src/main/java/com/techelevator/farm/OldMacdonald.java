package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal cow = new Cow();
		cow.sleep();
		Chicken chicken = new Chicken();
		FarmAnimal cat = new Cat();
		cat.sleep();
		
		/*
		 * FarmAnimal cannot be instantiated because it is Abstract
		 */
		//FarmAnimal genericAnimal = new FarmAnimal("animal", "sound");
		
		FarmAnimal[] animals = new FarmAnimal[] { cow, chicken, new Sheep(), cat };

		System.out.println("Animals on the farm: ");
		for (FarmAnimal animal : animals) {
			System.out.println(animal.getName());
		}
		
		System.out.println();
		
		Singable[] singers = new Singable[] { cow, chicken, 
					new Sheep(), new Tractor(), cat, new MusicBox()};

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