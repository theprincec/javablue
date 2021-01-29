package com.techelevator.farm;

public abstract class FarmAnimal implements Singable  {
	private String name;
	private String sound;
	private boolean isSleeping = false;
	
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	/*
	 * Abstract methods can only be declared in abstract classes.
	 * Abstract methods must be Overriden by any concrete (implementation) subclass of
	 * this abstract class.
	 */
	public abstract String eat();
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public final String getSound() {
		if (isSleeping) {
			return "Zzzzzzz...";
		}
		return sound;
	}

	@Override
	public int doSomething(double x) {
		// TODO Auto-generated method stub
		return (int) x * 34;
	}
	
	public boolean isSleeping() {
		return this.isSleeping;
	}
	
	public void sleep() {
		this.isSleeping = true;
	}
	
	public void wake() {
		this.isSleeping = false;
	}

}