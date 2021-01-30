package com.techelevator.tdd;

public class FizzBuzzKata {

	private final static int RANGE_BOTTOM = 1;
	private final static int RANGE_TOP = 100;
	
	private final static String EMPTY_STRING = "";
	private final static String FIZZ = "Fizz";
	private final static String BUZZ = "Buzz";
	
	public String fizzBuzz(int number) {
		
		String originalNumber = String.valueOf(number);
		
		if (isOutOfRange(number)) {
			return EMPTY_STRING;
		} else if (isDivisibleBy3And5(number)) {
			return FIZZ + BUZZ;
		} else if (isDivisibleBy3(number)) {
			return FIZZ;
		} else if (isDivisibleBy5(number)) {
			return BUZZ;
		} else {
			return originalNumber;
		}
		
	}
	
	private boolean isOutOfRange(int number) {
		return  (number < RANGE_BOTTOM || number > RANGE_TOP);
	}
	
	private boolean isDivisibleBy3And5(int number) {
		return number % 3 == 0 && number % 5 == 0;
	}
	
	private boolean isDivisibleBy3(int number) {
		return number % 3 == 0;
	}
	
	private boolean isDivisibleBy5(int number) {
		return number % 5 == 0;
	}
	
}
