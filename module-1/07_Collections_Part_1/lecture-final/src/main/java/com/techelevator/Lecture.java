package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
		List<String> instructors = new ArrayList<String>();
		
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Kevin");
	
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for ( int i = 0; i < instructors.size(); i++) {
			System.out.println( instructors.get( i ) );
		}
		
		
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		instructors.add("John");
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(3, "Rachelle");
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		instructors.remove( 0 );
		
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean isMattInList = instructors.contains( "Matt" );
		
		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorsArray = instructors.toArray( new String[instructors.size()] );
		
		// Arrays into a list
		List<String> instructorsList = Arrays.asList( instructorsArray );
	
		
		// This doesn't work, because int is a primitive data type and List can only hold Reference Types
		//List<int> numbers = new ArrayList<int>();
		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */
		Integer employees = new Integer(25);
		Integer piecesOfCake = new Integer("24");
		
		if (employees > piecesOfCake) {
			System.out.println("Not enough cake");
		}
		Integer integerWrapper = 10;
		int intY = 20;
		intY = integerWrapper + 5;
		integerWrapper = intY + 10;
		
//		Double accountBalance = null;
//		double newBalance = accountBalance + 100;

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add( 10 );
		numbers.add( 20 );
		numbers.add( 30 );
		numbers.add( 40 );
		
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println( numbers.get(i) );
		}
		
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		for ( Integer number : numbers ) {
			System.out.println( number );
		}
		
		for (String name : instructors ) {
			System.out.println(name);
		}
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		Queue<String> tasks = new LinkedList<String>();

		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Cean counters");
		tasks.offer("Scrub ceiling");
		
		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		
		while ( !tasks.isEmpty() ) {
			
			System.out.println("The next task: " + tasks.peek() );
			String taskBeingProcessed = tasks.poll();
			System.out.println("Processing the next task: " + taskBeingProcessed );
			
		}
		
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack<String> history = new Stack<String>();
		
		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		history.push("google.com");
		history.push("techelevator.com");
		history.push("codinghorror.com");
		history.push("stackoverflow.com");
		
		
		////////////////////
		// POPPING THE STACK
		////////////////////
		while ( !history.isEmpty() ) {
			System.out.println("The last item added: " + history.peek() );
			String lastItem = history.pop();
			System.out.println( lastItem );
		}
		
		// Stack can be used to reverse a set of data
		int[] nums = { 10, 20, 30, 40, 50 };
		Stack<Integer> numStack = new Stack<Integer>();
		
		for (int n : nums) {
			numStack.push( n );
		}
		
		List<Integer> reversedList = new ArrayList<Integer>();
		while ( !numStack.isEmpty() ) {
			reversedList.add( numStack.pop() );
		}

	}
}
