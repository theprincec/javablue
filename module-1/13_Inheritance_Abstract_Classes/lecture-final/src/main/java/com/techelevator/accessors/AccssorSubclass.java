package com.techelevator.accessors;

/*
 * Subclass of the AccessorExamples in the same package
 */
public class AccssorSubclass extends AccessorExamples {

	private void methodA() {
		
		// Public Method from AccessorExamples are available
		this.availableEverywhere();
		
		
		// Protected method is available since this is a subclass
		this.availableToSubclasses();
		
		// Default method is available since this is a subclass in the
		// same package
		this.availableInTheSamePackage();
		
		
		// The private method availableOnlyInThisClass() is not available
	}
	
	
}
