package com.techelevator.accessors.anotherPackage;

import com.techelevator.accessors.AccessorExamples;

public class AcessorSubClassInOtherPackage extends AccessorExamples {

	private void methodC() {
		
		// Public method is available
		this.availableEverywhere();
		
		// Protected method is available since this is a 
		// subclass of the AccessorExamples
		this.availableToSubclasses();
		
		// Default method availableInTheSamePackage() is not available
		
		// Private method availableOnlyInThisClass() is not available
		
	}
	
	
}
