package com.techelevator;

import org.junit.*;

public class Less20Test {
	
private Less20 less20;
	
	
	@Before
	public void setup() {
		less20 = new Less20();
	}
	
	
	
	
	 /*
    Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
    and 39 return true, but 40 returns false.
    (Hint: Think "mod".)
    less20(18) → true
    less20(19) → true
    less20(20) → false
*/

	@Test
	public void in_range_of_20() {
		int num = 19;
		//int num = -1;
		
		boolean actualResult = less20.isLessThanMultipleOf20(num);
		
		Assert.assertTrue("This was a fail it's not within range", actualResult);

	}
	
	
	@Test
	public void in_range_of_multiple_of_20() {
		int num = 79;
		//int num = -1;
		
		boolean actualResult = less20.isLessThanMultipleOf20(num);
		
		Assert.assertTrue("This was a fail it's not within range", actualResult);

	}
	
	
	@Test
	public void out_range_of_multiple_of_20() {
		int num = 74;
		//int num = -1;
		
		boolean actualResult = less20.isLessThanMultipleOf20(num);
		
		Assert.assertTrue("This was a fail it's not within range", actualResult);

	}
	
	
	@Test
	public void negative_range_of_multiple_of_20() {
		int num = -21;
		//int num = -1;
		
		boolean actualResult = less20.isLessThanMultipleOf20(num);
		
		Assert.assertTrue("This was a fail it's not within range", actualResult);

	}
	
	
	
	
	//no negative numbers
	
	@Test
	public void negative_in_range_of_multiple_of_20() {
		int num = -19;
		//int num = -1;
		
		boolean actualResult = less20.isLessThanMultipleOf20(num);
		
		Assert.assertTrue("This was a fail it's not within range", actualResult);

	}
	
	
	
	
	

}
