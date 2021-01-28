package com.techelevator;

import org.junit.*;

public class AnimalGroupNameTest {

	private AnimalGroupName animalGroupName;
	
	@Before
	public void setup() {
		animalGroupName = new AnimalGroupName();
	}
	
	@Test
	public void rhino_returns_crash() {
		// Arrange
		// Act
		String herdName = animalGroupName.getHerd("Rhino");
		// Assert
		Assert.assertEquals("Crash", herdName);
	}
	
}
