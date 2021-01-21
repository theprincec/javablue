package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lecture {

	public static void main(String[] args) {


		System.out.println();		
		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();

		/* DECLARE AND INSTANTIATE A SET */
		// HashSet does not maintain order
		//Set<Integer> setOfNumbers = new HashSet<Integer>();
		
		// LinkedHashSet maintains Order of Insertion
		//Set<Integer> setOfNumbers = new LinkedHashSet<Integer>();
		
		// TreeSet does not allow null and maintains the natural order of the data type it is holding
		Set<Integer> setOfNumbers = new TreeSet<Integer>();
		
		/* ADD ITEMS TO THE SET */
		setOfNumbers.add(1);
		setOfNumbers.add(30);
		setOfNumbers.add(10);
		setOfNumbers.add(301);
		setOfNumbers.add(301);  // duplicates are ignored without warning or error
		setOfNumbers.add(5);
		setOfNumbers.add(5708);
		setOfNumbers.add(24332424);
		
		/* LOOP OVER A SET */
		
		for ( Integer number : setOfNumbers ) {
			System.out.println(number);
		}

		
		/*USE CASE:  USE A SET TO REMOVE DUPLICATES AND ORDER THE ARRAY */
		String[] instructorWorkLog = {"Rachelle", "John", "Matt", "Kevin", "Rachelle", "Steve", "John", "Rachelle" };
		
		Set<String> workSet = new HashSet<String>();
		for (String contributor : instructorWorkLog) {
			workSet.add( contributor );
		}
		
		for (String name : workSet) {
			System.out.println( name );
		}

		
		
		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();
		
		/* DECLARING AND INSTANTIATING A MAP */
		// Map<KeyDataType, ValueDataType>
		Map<String, String> animalNoises = new HashMap<String, String>();
		
		
		/* ADDING ITEMS TO A MAP */
		// Items are added using .put(key, value)
		animalNoises.put("Cow", "Moo");
		animalNoises.put("Chicken", "Cluck");
		animalNoises.put("Dog", "Bark");
		animalNoises.put("Cat", "Meow");
		// Keys must be unique, but the values do not
		animalNoises.put("Lion", "Roar");
		animalNoises.put("Duck", "Roar");
		
		
		/* UPDATING AN ITEM IN A MAP */

		// Use put with an existing key
		animalNoises.put("Duck", "Quack");

		/* RETRIEVING AN ITEM FROM A MAP */
		// Retrieve an item using get( key )
		String catNoise = animalNoises.get("Cat");
		System.out.println(catNoise);
		
		// If the key doesn't exist, then get() returns null
		String wolfNoise = animalNoises.get("Wolf");
		if (wolfNoise != null) {
			System.out.println("The Wolf says " + wolfNoise);
		} else {
			System.out.println("Wolf does not exist in the map");
		}
		
		/* REMOVING AN ITEM FROM A MAP */
		
		// Can remove a key/value pair using .remove(key)
		// remove() returns the value and then removes the key/value from the map
		String lionNoise = animalNoises.remove("Lion");
		System.out.println("The Lion says " + lionNoise);
		
		// If the key does not exists, the null returned - lionNoiseAfterRemove will be null
		String lionNoiseAfterRemove = animalNoises.remove("Lion");
		System.out.println("The Lion now says " + lionNoiseAfterRemove);
		
		/* CHECK IF AN ITEM EXISTS */
		// containsKey(key) returns TRUE if the KEY exists in the Map
		boolean catExists = animalNoises.containsKey("Cat");  // returns true if the key is in the map
		boolean wolfExists = animalNoises.containsKey("Wolf");  // returns false if the map does not contain the key
		// containsValue(value) returns TRUE if the VALUE exists in the Map
		boolean meowExists = animalNoises.containsValue("Meow"); // returns true if the value exists at least once in the map
		boolean baaExists = animalNoises.containsValue("Baa"); // returns false if the value does not exists in the map
		
		System.out.println();
		
		
		/* LOOPING OVER A MAP */
		// Loop through a map by looping through the Keys
		// Then using the keys to get the value
		for (String key : animalNoises.keySet()) {
			System.out.println("Key: " + key);
			System.out.println("Value: " + animalNoises.get(key) );
		}
		
		
		// Looping through a map by looping through the entry set
		for (Entry<String, String> entry : animalNoises.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue() );
		}
		

		System.out.println();
		
		/* THE MAP KEY AND VALUE DATA TYPES */
		// Key and Value do not need to be the same type, but both must be Reference Types
		Map<Integer, Double> accounts = new HashMap<Integer, Double>();
		accounts.put(12345, 100d);
		accounts.put(56789, 200d);
		
		// Transfer half of Map 12345's money to account 56789
		double halfOfAccount12345 = accounts.get(12345) / 2.0;
		accounts.put(12345, accounts.get(12345) - halfOfAccount12345);
		accounts.put(56789, accounts.get(56789) + halfOfAccount12345);

		
		
		
		
		System.out.println();
		System.out.println("####################");
		System.out.println("      MAP ORDER     ");
		System.out.println("####################");
		System.out.println();
	
		/*
		 * The Order that a Map stores the keys is dependent on the Implementation class used.
		 * 
		 * HashMap - does not retain order
		 * LinkedHashMap - retains the order of insertion
		 * TreeMap - maintains Natural Order for the Data Type of the key
		 */
		
		System.out.println("The values where inserted in the following order: 2, 10, 25, 1");
		
		System.out.println();
		System.out.println("  HASHMAP");
		System.out.println("Does not retain any order.  Instead it uses it's own internal ordering");
		
		Map<Integer, String> hashMapNumbersToWords = new HashMap<Integer, String>();
		
		hashMapNumbersToWords.put(2,  "Two");
		hashMapNumbersToWords.put(10, "Ten");
		hashMapNumbersToWords.put(25, "Twenty-Five");
		hashMapNumbersToWords.put(1,  "One");
		
		for (Integer number : hashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + hashMapNumbersToWords.get(number));
		}		
		
		
		System.out.println();
		System.out.println("  LINKED HASHMAP");
		System.out.println("Retains the Order of Insertion");

		Map<Integer, String> linkedHashMapNumbersToWords = new LinkedHashMap<Integer, String>();
		
		linkedHashMapNumbersToWords.put(2,  "Two");
		linkedHashMapNumbersToWords.put(10, "Ten");
		linkedHashMapNumbersToWords.put(25, "Twenty-Five");
		linkedHashMapNumbersToWords.put(1,  "One");
		
		for (Integer number : linkedHashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + linkedHashMapNumbersToWords.get(number));
		}	
		
		
		System.out.println();
		System.out.println("  TREEMAP");
		System.out.println("Maintains the Natural Order of the Data Type");
		System.out.println();
		System.out.println("Natural Order when numbers are Integer");
		
		Map<Integer, String> treeMapNumbersToWords = new TreeMap<Integer, String>();
		
		treeMapNumbersToWords.put(2,  "Two");
		treeMapNumbersToWords.put(10, "Ten");
		treeMapNumbersToWords.put(25, "Twenty-Five");
		treeMapNumbersToWords.put(1,  "One");
		
		for (Integer number : treeMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + treeMapNumbersToWords.get(number));
		}	


		System.out.println();
		System.out.println("TreeMap Natural Order when numbers are String");

		Map<String, String> treeMapNumbersAsStrings = new TreeMap<String, String>();
		
		treeMapNumbersAsStrings.put("2",  "Two");
		treeMapNumbersAsStrings.put("10", "Ten");
		treeMapNumbersAsStrings.put("25", "Twenty-Five");
		treeMapNumbersAsStrings.put("1",  "One");
		
		for (String number : treeMapNumbersAsStrings.keySet()) {
			System.out.println(number + " is " + treeMapNumbersAsStrings.get(number));
		}	


	}

}
