package com.techelevator;

public class ArraysAndLoops {

	public static void main(String[] args) {
		
		/*
		 * Declaring a variable of the data type String Array (String[])
		 * named instructors
		 * new creates a new array of type String  ( new String[])
		 * the size is set to 5 ( [5] )
		 * = assigns the new array to the variable named instructors
		 */
		String[] instructors  = new String[5];
		
		instructors[0] = "John";
		instructors[1] = "Rachelle";
		instructors[2] = "Steve";
		instructors[3] = "Matt";
		instructors[4] = "Kevin";

		//instructors[5] = "soemthing else";
		
		System.out.println( instructors[1] );
		
		instructors[0] = instructors[0] + " Fulton";

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };		
		
		// () contains the boolean expression where the loop
		//    will continue while true and stop when false
		// () has 3 parts divided by ;
		// Part 1: incrementer (optional) - a variable to hold a value to change
		// Part 2: a boolean condition using the incrementer. That starts true
		// Part 3: an iterator expression (change that occurs after each loop) that changes the incrementor
		for ( int i = 0 ; i < 10 ; i++) {
			// This is the code that will execute
			System.out.println( i );
		}
		
		int sum = 0;
		
		for ( int i = 1 ; i < 101; i++) {	
			sum += i;
		}
		
		System.out.println( sum );
		
		int evenSum = 0;
		for ( int i = 0; i < 101; i++) {
			if ( i % 2 == 0) {
				evenSum += i;
			}
		}
		System.out.println( evenSum );
		
		int evenSum2 = 0;
		for ( int i = 2; i < 101; i += 2) {
				evenSum2 += i;
		}
		System.out.println( evenSum2 );
		
		for ( int x = 100 ; x >= 0 ; x--) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		for ( int i = 0 ; i < 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		
		for ( int i = 0 ; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		
		for ( int i = 0 ; i < 10; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
		/*
		 * Incrementor can start at 0 and go up by 1, just like an index
		 * so we can use an incrementer as the index of an array to access
		 * each element in an array in order.
		 */
		for (int i = 0; i < instructors.length ; i++) {
			System.out.println( instructors[i] );
		}
		
		/*
		 * For every other number in the array multiple by 2 and print it
		 * For every number divisible by three print Fizz
		 * 
		 */
		
		for (int i = 0; i < nums.length ; i++) {
			
			if ( i % 2 == 1) {
				nums[i] = nums[i] * 2;
				System.out.println( nums[i] );
			}
			if ( nums[i] % 3 == 0) {
				System.out.println("Fizz");
			}
			
			
		}
		
		/*
		 * print all the numbers in nums
		 * For each number if divisible by 4 (n  % 4 == 0), then
		 * skip the next number.
		 */
		for (int i = 0; i < nums.length; i++) {
			if ( nums[i] % 4 == 0) {
				i++;
			}
			System.out.println(i);
		}
		
		/*
		 * for each number, add the next number to it and print it
		 */
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				System.out.println( nums[i] );
			} else {
				int newNumber = nums[i] + nums[i + 1];
				System.out.println(newNumber);			
			}
		}
	}

}
