package com.techelevator.accessors;

public class AccessorExamples {

	/*
	 * Public Access
	 * 
	 * Available everywhere
	 */
	public void availableEverywhere() {
		
	}
	

	/*
	 *  Protected Access
	 *  
	 * Available to any class or subclass in the hierarchy
	 * In Java also available to any class in the same package,
	 *    but package level usage is discouraged
	 */
	
	protected void availableToSubclasses() {
		
	}
	
	/*
	 * Default Access
	 * 
	 * Available to any class or subclass in the same package
	 * Not available to subclasses in other packages
	 */
	void availableInTheSamePackage() {
		
	}
	
	/*
	 * Private Access
	 * 
	 * Only Available in this class
	 */
	private void availableOnlyInThisClass() {
		
	}
}
