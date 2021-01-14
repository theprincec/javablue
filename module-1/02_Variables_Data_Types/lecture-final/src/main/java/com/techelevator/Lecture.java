package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		// Step 1 - declare the variable
		//    Declaration defines the data type and the name;
		
		int numberOfExercises;
		
		// Step 2 - assign a value to the variable 
		//    Assignment sets the value that the variable will hold
		numberOfExercises = 26;
		
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		
		// Step 1 (Declaration) and Step 2 (Assignment) can be done on 1 line
		double half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		// Use the String data type and assign it any string of characters in double quotes
		String name = "Tech Elevator";
		
		System.out.println(name);
		
		String nameWithControlCharacters = "\"\tTech\nElevator\"";
		System.out.println(nameWithControlCharacters);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		// Java treats literal numbers with a decimal point as a double by default, adding
		// and f to the end of the number tells Java that you want it treated as a float.
		float pi = 3.1416f;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "your name";
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numbersOfButtonsOnMyMouse = 3;
		
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentageOfBatteryLeftOnMyPhone = 45;
		
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double one = 12.3;
		double addition = one + 32.1;
		System.out.println( addition );
		/*
		12. Create a String that holds your full name.
		*/
		String firstName = "John";
		String fullName = firstName + " Fulton";
		
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, " + fullName;
		System.out.println( hello );
		
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire";
		
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw" + 2;
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw += 0;
		
		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println( 4.4 / 2.2);
		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println( 5.4 / 2);
		/*
		20. What is 5 divided by 2?
		*/
		System.out.println( 5 / 2);
		
		// 5 / 2 results in 2 due to integer division
		// 5.0 / 2   OR  5 / 2.0  results in 2.5 
		
		double answer = 5 / 2;  // is still 2.0
		double answer2 = 5 / (double) 2;  // is 2.5
		double answer3 = (double) 5 / 2;  // is 2.5
		
		// but...
		double answer4 = (double) ( 5 / 2);  // is 2.0
		
		
		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println( 5.0 / 2);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println( 66.6 / 100);
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int remainder = 5 % 2;
		System.out.println( remainder );
		/*
		24. What is 1,000,000,000 * 3?
		*/
		int bigNumber = 1000000000 * 3;
		System.out.println(bigNumber);
		
		// Widening 
		float smallNumber = 2.0f;
		double largerType = smallNumber;
		
		
		// Narrowing with explict casting
		double numberOne = 5.6;
		float smallerType = (float) numberOne;
		
		long numberTwo = 2;
		int smallerWholeNumber = (int) numberTwo;
		
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;
		
		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
	}

}
