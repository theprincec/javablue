package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {
	
	private AnimalGroupName animalGroupName;
	
	
	@Before
	public void setup() {
		animalGroupName = new AnimalGroupName();
	}
	

	
	

    /*
     * Given the name of an animal, return the name of a group of that animal
     * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
     *
     * The animal name should be case insensitive so "elephant", "Elephant", and
     * "ELEPHANT" should all return "herd".
     *
     * If the name of the animal is not found, null, or empty, return "unknown".
     *
     * Rhino -> Crash
     * Giraffe -> Tower
     * Elephant -> Herd
     * Lion -> Pride
     * Crow -> Murder
     * Pigeon -> Kit
     * Flamingo -> Pat
     * Deer -> Herd
     * Dog -> Pack
     * Crocodile -> Float
     *
     * GetHerd("giraffe") → "Tower"
     * GetHerd("") -> "unknown"
     * GetHerd("walrus") -> "unknown"
     * GetHerd("Rhino") -> "Crash"
     * GetHerd("rhino") -> "Crash"
     * GetHerd("elephants") -> "unknown"
     *
     */
	
	
	
//	@Test
//	public void string_hello_returns_hlo() {
//		// Arrange
//		String word = "Hello";
//		
//		// Act
//		String expectedWord = stringBits.getBits(word);
//		
//		// Assert
//		Assert.assertEquals( "Hlo", expectedWord);
//	}
	
	
	
	
	
	@Test
	public void elephant_returns_Herd() {
		String animal = "elephant";
		
		String expectedHerd = animalGroupName.getHerd(animal);
		
		Assert.assertEquals("Herd", expectedHerd);
		
	}
	
	
	@Test
	public void ELEPHANT_in_caps_returns_Herd() {
		String animal = "ELEPHANT";
		
		String expectedHerd = animalGroupName.getHerd(animal);
		
		Assert.assertEquals("Herd", expectedHerd);
		
	}
	
	@Test
	public void PiGEon_in_mixedCase_returns_Herd() {
		String animal = "PiGEon";
		
		String expectedHerd = animalGroupName.getHerd(animal);
		
		Assert.assertEquals("Kit", expectedHerd);
		
	}
	
	@Test
	public void animal_outside_map_returns_unknown() {
		String animal = "crabs";
		
		String expectedHerd = animalGroupName.getHerd(animal);
		
		Assert.assertEquals("unknown", expectedHerd);
		
	}
	
	@Test
	public void null_returns_unknown() {
		//String animal = "crabs";
		
		String expectedHerd = animalGroupName.getHerd(null);
		
		Assert.assertEquals("unknown", expectedHerd);
		
	}
	
	@Test
	public void empty_returns_unknown() {
		String animal = "";
		
		String expectedHerd = animalGroupName.getHerd(animal);
		
		Assert.assertEquals("unknown", expectedHerd);
		
	}
	
	
}
