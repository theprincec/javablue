package com.techelevator.calculator;

public class ScientificCalculator extends Calculator {

	public ScientificCalculator(double startingValue) {
		super(startingValue);
	}

	public void pow(int exponent) {
		super.setTotal(0);
	}
	
	public void log(int base) {
		super.setTotal(0);
	}
	
	// An Override uses the same method signature as a method in a 
	// superclass to provide functionality specific for the subclass. 
	// The override version will then be inherited by subclasses of this class.
	@Override
	public void add(double amount) {

		// Allows the subclass to call the superclasses's original version of the
		// method from within an override
		super.add(amount);
	}
}
