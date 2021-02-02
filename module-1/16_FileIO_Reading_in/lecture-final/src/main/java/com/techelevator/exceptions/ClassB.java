package com.techelevator.exceptions;

public class ClassB {

	public void methodB(String str) throws IncorrectStringValueException {
		
		if (str.equals("789")) {
			throw new IncorrectStringValueException("Unable to parse 789", str);
		}
		
		
		try {
			str.toUpperCase();
		} catch (NullPointerException e) {
			str = "0";
		}
		
		Integer.parseInt(str);
	
	
	}
}
