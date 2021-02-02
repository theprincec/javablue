package com.techelevator.exceptions;

import java.util.Scanner;

public class ExceptionsExamples {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int[] nums = {1,2,3};
		
		int x = 0;
		int y = 0;
		
		/*
		 * The try block identifies "risky" code that may cause
		 * an exception
		 */
		try {
			x += 10;
			int n = nums[3];
			x += n; // Due to the exception on the line above this line is skipped
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough elements in the array for that index");
		}

		System.out.println("X is " + x);
		
		
		String str = "abc";
		int numAsStr = 0;
		
		try {
			System.out.println("Line 1");
			str.toUpperCase();
			str.charAt(15);
			System.out.println("Line 2");
			numAsStr = Integer.parseInt(str);
			System.out.println("Line 3");
		} catch (NumberFormatException e) {
			System.out.println("Unable to parse string " + e.getMessage());
		} catch (NullPointerException e) {
			str = "";
		} catch (Exception e) {  // Exception uses polymorphism to catch all exceptions
			System.out.println("Something went wrong " + e.getMessage());
		} finally {
			numAsStr += 50;
			System.out.println("finally runs");
		}
		
		
		System.out.println(numAsStr);
		
		while (true) {
			System.out.print("Enter a number to parse >>>");
			String userStr = input.nextLine();
			
			if (userStr.length() == 0) {
				userStr = null;
			}
			
			ClassA classA = new ClassA();
			try {
				classA.methodA(userStr);
			} catch (NumberFormatException e) {
				System.out.println("Can't convert " + userStr + " please try again!");
			} catch (IncorrectStringValueException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
