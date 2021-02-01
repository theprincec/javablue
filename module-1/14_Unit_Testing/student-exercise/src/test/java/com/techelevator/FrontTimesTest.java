package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {
	
	
	private FrontTimes frontTimes;
	
	
	@Before
	public void setup() {
		frontTimes = new FrontTimes();
	}
	
	
	
	
	/* Given a string and a non-negative int n, we'll say that the front of the
	 * string is the first 3 chars, or whatever is there if the string is less than
	 * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
	 * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
	 * "AbcAbcAbc"
	 */

	@Test
	public void word_with_a_negative() {
		String word = "Wordup";
		int num = -1;
		
		String actualCharacters = frontTimes.generateString(word, num);
		
		Assert.assertEquals("", actualCharacters);

	}
	
	
	@Test
	public void word_with_less_than_3characters() {
		String word = "Yo";
		int num = 3;
		
		String actualCharacters = frontTimes.generateString(word, num);
		
		Assert.assertEquals("YoYoYo", actualCharacters);

	}
	
	@Test
	public void word_with_0characters() {
		String word = "";
		int num = 3;
		
		String actualCharacters = frontTimes.generateString(word, num);
		
		Assert.assertEquals("", actualCharacters);

	}
	
	@Test
	public void word_with_CoCo_and_2_returns() {
		String word = "CoCo";
		int num = 2;
		
		String actualCharacters = frontTimes.generateString(word, num);
		
		Assert.assertEquals("CoCCoC", actualCharacters);

	}
	
	
	
	
	
	

}
