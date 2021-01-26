package com.techelevator.accessors;

public class AnotherClassInPackage {

	private void methodB() {
		
		AccessorExamples accessors = new AccessorExamples();
		
		// public methods are available
		accessors.availableEverywhere();
		
		// Default methods from the same package are available
		accessors.availableInTheSamePackage();
		
		
		// Protected methods are available in the same package, but
		// this use is discouraged for Protected
		accessors.availableToSubclasses();
		
		// The private method availableOnlyInThisClass() is not available
		
	}
	
}
