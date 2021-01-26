package com.techelevator.accessors.anotherPackage;

import com.techelevator.accessors.AccessorExamples;

public class AnotherClassInDifferentPackage {

	private void methodD() {
		
		AccessorExamples accessors = new AccessorExamples();
		
		// Public method is available
		accessors.availableEverywhere();
		
		// Protected method availableToSubclasses() is not available
		
		// Default method availableInTheSamePackage() is not available 
		
		// Private method availableOnlyInThisClass() is not available
	}
}
