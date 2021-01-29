package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

public class LectureTest {

	/*
	 * A Private member variable to instantiate the class we are testing
	 */
	private Lecture lecture;
	
	/*
	 * Before runs before EACH test.
	 * Instantiate a new object of the class being tested so that 
	 * every test starts from the same state
	 */
	@Before
	public void setup() {
		lecture = new Lecture();
	}
	
	/*
	 * After runs after EACH test
	 * After is used to cleanup after a test runs and often is not needed
	 */
	@After
	public void cleanup() {
	}
		
	/*
	 * Tests for or35
	 * 
	 * - multiple of 3 but not 5
	 * - multiple of 5 but not 3
	 * - multiple of 3 and 5
	 * - not a multiple of 3 or 5
	 * - Negative multiple of 3 or 5
	 * - zero
	 */
	@Test
	public void or35_multiple_of_3_but_not_5() {
		// Arrange (if needed)
		// Act
		boolean result = lecture.or35(9);
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void or35_multuple_of_5_but_not_3() {
		// Arrange
		// Act 
		boolean result = lecture.or35(10);
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void or35_multiple_of_both_3_and_5() {
		// Arrange
		// Act
		boolean result = lecture.or35(15);
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void or35_not_multiple_of_3_or_5() {
		// Arrange
		// Act
		boolean result = lecture.or35(7);
		// Assert
		Assert.assertFalse(result);
	}
		
	/*
	 * When a test fails we need to verify if the test or the code is correct 
	 * based on the requirements.  If the tests is correct then either the
	 * code can be fixed or the test just left failing, depending on the 
	 * situation.
	 */
	@Test
	public void or35_zero() {
		// Arrange
		// Act
		boolean result = lecture.or35(0);
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test 
	public void or35_negative_multiple_of_3__or_5() {
		// Arrange
		//Act
		boolean result = lecture.or35(-6);
		// Assert
		Assert.assertFalse(result);
	}

	/*
	 * Tests for Caught Speeding
	 * 
	 * AssertEquals with an integer
	 */
	@Test
	public void caughtspeeding_driving_60_when_not_birthday() {
		// Arrange
		// Act
		int result = lecture.caughtSpeeding(60, false);
		// Assert
		Assert.assertEquals(0, result);  // (value we expect, the actual value)
	}
	
	/*
	 * Tests for firstTwo
	 * 
	 * Testing with a String returned (Assert Equals with a String)
	 * 
	 * Other things we should test with String
	 * 	- exactly 2 characters
	 *  - case sensitive (if required)
	 *  - null
	 *  - empty string
	 *  - less than 2 characters
	 */
	@Test
	public void firsttwo_returns_first_2_for_string_longer_than_2() {
		// Arrange
		// Act
		String result = lecture.firstTwo("Hello");
		// Assert
		Assert.assertEquals("He", result);
	}
	
	@Test
	public void firsttwo_null() {
		// Arrange
		// Act
		String result = lecture.firstTwo(null);
		// Assert
		Assert.assertNull(result);
	}
	
	@Test
	public void firsttwo_empty_string() {
		// Arrange
		// Act
		String result = lecture.firstTwo("");
		// Assert
		Assert.assertEquals("The string was empty", "", result);
	}
	
	/*
	 * No 4 Letter Words
	 * 
	 * Testing with List or Array
	 */
	@Test
	public void list_does_not_include_4_letter_words() {
		
		// Arrange
		String[] originalWords = {"Train", "Boat", "Car"};
		String[] expectedWords = {"Train", "Car"};
		
		// Act
		List<String> actualResult = lecture.no4LetterWords(originalWords);
		
		// Assert
		// Assert that the returned List of words is the same list of words in our expectedWor
		Assert.assertNotNull("Return was null", actualResult);
		String[] actualResultsAsArray = actualResult.toArray(new String[actualResult.size()]);
		Assert.assertArrayEquals(expectedWords, actualResultsAsArray);
	}
	
	/*
	 * Rob Peter to Pay Paul
	 * 
	 * Testing with Map (or other complex data structures)
	 */
	@Test
	public void peter_gives_half_of_money_to_paul() {
		// Arrange - create and populate the map to use as input
		Map<String, Integer> peterPaul = new HashMap<String, Integer>();
		peterPaul.put("Peter", 2000);
		peterPaul.put("Paul", 500);
		
		// Act
		Map<String, Integer> result = lecture.robPeterToPayPaul(peterPaul);
		
		// Assert
		// When using a collection with a primitive, assertEquals will not
		// autobox a value, so it must be instantiated explicitly
		Assert.assertEquals("Expected Peter to have 1000, but he had " + result.get("Peter"),
				new Integer(1000), result.get("Peter"));
		Assert.assertEquals("Paul has unexpected amount", new Integer(1500), result.get("Paul"));
	}
	
	
	/* 
	 * Testing with Double - with no rounding error
	 */
	@Test
	public void third_of_9() {
		double result = lecture.thirdDouble(9);
		// assertEquals(expected, actual, delta)
		//    The delta is difference allowed between the 2 numbers
		Assert.assertEquals(3, result, 0);
	}
	
	/*
	 * Testing with Double - with a rounding error
	 */
	@Test
	public void third_of_5() {
		double result = lecture.thirdDouble(5);
		Assert.assertEquals(1.66, result, .009);
	}
	
	/*
	 * Testing with our own objects
	 * 
	 * Using private assert methods
	 */
	@Test
	public void dog_returns_the_same_dog_with_private_assert() {
		
		// Arrane
		Dog ourDog = new Dog("Fiddo", "poodle", 7);
		
		// Act 
		Dog returnedDog = lecture.returnOurDog(ourDog);
		
		// Assert
		// Assert Equals doesn't work unless the class has a .equals override
		// because it is 2 different dog objects with the same values
		// Assert.assertEquals(ourDog, returnedDog);
		assertDogEquals(ourDog, returnedDog);
	}
	
	/*
	 * That if an assert fails, even in a different method, while the test is running
	 * the test fails.  So we can build our own asserts for complex objects using
	 * private methods that assert the individual values
	 */
	private void assertDogEquals(Dog expected, Dog actual) {
		Assert.assertEquals(expected.getBreed(), actual.getBreed());
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getAge(), actual.getAge());
	}
	
	
	/*
	 * Testing with our own objects
	 * 
	 * 
	 */
	@Test
	public void dog_returns_the_same_dog() {
		
		// Arrange
		Dog ourDog = new Dog("Fiddo", "poodle", 7);
		
		// Act 
		Dog returnedDog = lecture.returnOurDog(ourDog);
		
		// Assert
		// We can use assertEquals as long as the class has the equals method
		// overridden with what it means for 2 objects of that type to be equal
		Assert.assertEquals(ourDog, returnedDog);

	}
	
}
