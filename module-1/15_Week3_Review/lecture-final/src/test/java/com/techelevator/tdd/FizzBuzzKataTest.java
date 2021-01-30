package com.techelevator.tdd;

import org.junit.*;

public class FizzBuzzKataTest {

	private FizzBuzzKata fizzBuzz;
	
	@Before
	public void setup() {
		fizzBuzz = new FizzBuzzKata();
	}
	
	@Test 
	public void divisible_by_3_returns_fizz() {
		Assert.assertEquals("Fizz", fizzBuzz.fizzBuzz(9));
		Assert.assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
		Assert.assertEquals("Fizz", fizzBuzz.fizzBuzz(99));
	}
	
	@Test
	public void divisible_by_5_returns_buzz() {
		Assert.assertEquals("Buzz", fizzBuzz.fizzBuzz(10));
		Assert.assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
		Assert.assertEquals("Buzz", fizzBuzz.fizzBuzz(100));
	}
	
	@Test
	public void divisible_by_3_and_5_returns_fizzbuzz() {
		Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
	}
	
	@Test
	public void divisible_by_neither_3_or_5_returns_the_number() {
		Assert.assertEquals("1", fizzBuzz.fizzBuzz(1));
		Assert.assertEquals("98", fizzBuzz.fizzBuzz(98));
		Assert.assertEquals("37", fizzBuzz.fizzBuzz(37));
	}
	
	@Test
	public void number_less_than_1_returns_empty_string() {
		Assert.assertEquals("", fizzBuzz.fizzBuzz(0));
		Assert.assertEquals("", fizzBuzz.fizzBuzz(-1));
	}
	
	@Test
	public void number_greater_than_100_returns_empty_string() {
		Assert.assertEquals("", fizzBuzz.fizzBuzz(101));
	}
}
