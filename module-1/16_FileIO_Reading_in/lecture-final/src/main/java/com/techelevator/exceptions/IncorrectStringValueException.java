package com.techelevator.exceptions;

public class IncorrectStringValueException extends Exception {
	
	private String originalString;
	
	public IncorrectStringValueException(String message, String originalString) {
		super(message);
		this.originalString = originalString;
	}
	
	
	public String getOriginalString() {
		return this.originalString;
	}
}
