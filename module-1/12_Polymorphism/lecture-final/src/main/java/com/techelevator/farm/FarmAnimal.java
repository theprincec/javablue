package com.techelevator.farm;

public class FarmAnimal implements Singable  {
	private String name;
	private String sound;
	
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSound() {
		return sound;
	}

	@Override
	public int doSomething(double x) {
		// TODO Auto-generated method stub
		return (int) x * 34;
	}

}