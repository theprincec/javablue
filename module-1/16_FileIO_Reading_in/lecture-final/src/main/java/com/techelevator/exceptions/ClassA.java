package com.techelevator.exceptions;

public class ClassA {

	public void methodA(String str) throws IncorrectStringValueException {

		ClassB classB = new ClassB();
		classB.methodB(str);

		
	}
}
