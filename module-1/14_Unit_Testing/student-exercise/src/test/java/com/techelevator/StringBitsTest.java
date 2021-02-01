package com.techelevator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {
	
	private StringBits stringBits;
	
	/*
	 * Before runs before EACH test.
	 * Instantiate a new object of the class being tested so that 
	 * every test starts from the same state
	 */
	
	
	
	@Before
	public void setup() {
		stringBits = new StringBits();
	}
	
	
	
	
	
	
	
	
	/*
	 * Given a string, return a new string made of every other char starting with
	 * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
	 * → "H" GetBits("Heeololeo") → "Hello"
	 */
	
	
//	@Test
//	public void peter_gives_half_of_money_to_paul() {
//		// Arrange - create and populate the map to use as input
//		Map<String, Integer> peterPaul = new HashMap<String, Integer>();
//		peterPaul.put("Peter", 2000);
//		peterPaul.put("Paul", 500);
//		
//		// Act
//		Map<String, Integer> result = lecture.robPeterToPayPaul(peterPaul);
//		
//		// Assert
//		// When using a collection with a primitive, assertEquals will not
//		// autobox a value, so it must be instantiated explicitly
//		Assert.assertEquals("Expected Peter to have 1000, but he had " + result.get("Peter"),
//				new Integer(1000), result.get("Peter"));
//		Assert.assertEquals("Paul has unexpected amount", new Integer(1500), result.get("Paul"));
//	}
	
//	public StringBits getStringBits() {
//		return stringBits;
//	}








	@Test
	public void string_hello_returns_hlo() {
		// Arrange
		String word = "Hello";
		
		// Act
		String expectedWord = stringBits.getBits(word);
		
		// Assert
		Assert.assertEquals( "Hlo", expectedWord);
	}
	
	
	@Test
	public void string_hello_not_returns_hlo() {
		// Arrange
		String word = "Hello";
		
		// Act
		String expectedWord = stringBits.getBits(word);
		
		// Assert
		Assert.assertNotEquals("returns wrong answer", "Hol", expectedWord);
		
	}
	
	
	@Test
	public void string_empty_returns_empty() {
		// Arrange
		String word = "";
		
		// Act
		String expectedWord = stringBits.getBits(word);
		
		// Assert
		Assert.assertEquals( "", expectedWord);
		
	}
	
	@Test
	public void null_returns_empty_string() {
		// Arrange
		//String word;
		
		// Act
		String expectedWord = stringBits.getBits(null);
		
		// Assert
		Assert.assertNotNull(expectedWord);
		
		
		
		//String result = lecture.firstTwo(null);
		// Assert
		//Assert.assertNull(result);
		
	}
	
	
	
	

}
