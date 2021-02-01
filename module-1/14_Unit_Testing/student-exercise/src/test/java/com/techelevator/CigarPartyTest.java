package com.techelevator;

import org.junit.*;

public class CigarPartyTest {
	
	
	
	private CigarParty cigarParty;
	
	
	
	
	@Before
	public void setup() {
		cigarParty = new CigarParty();
	}
	
	
	
//	When squirrels get together for a party, they like to have cigars. A squirrel party is successful
//    when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
//    there is no upper bound on the number of cigars. Return true if the party with the given values is
//    successful, or false otherwise.
//    haveParty(30, false) → false
//    haveParty(50, false) → true
//    haveParty(70, true) → true
	
	
//    public boolean haveParty(int cigars, boolean isWeekend) {
//        int minimumCigarCount = 40;
//        int maximumCigarCount = 60;
//
//        boolean hasMinimumCigars = cigars >= minimumCigarCount;
//        boolean withinMaxRangeOfCigars = (!isWeekend && cigars <= maximumCigarCount) || isWeekend;
//        boolean successful = hasMinimumCigars && withinMaxRangeOfCigars;
//
//        return successful;
	
	
	
	
	
	
	@Test
	public void is_30cigs_successful() {
		int numOfCigars = 30;
		boolean isWeekend = false;
		
		boolean actualResult = cigarParty.haveParty(numOfCigars, isWeekend);
		
		Assert.assertFalse("This should be a poor party", actualResult);
		
	}
	
	@Test
	public void is_45cigs_successful() {
		int numOfCigars = 45;
		boolean isWeekend = false;
		
		boolean actualResult = cigarParty.haveParty(numOfCigars, isWeekend);
		
		Assert.assertTrue("This should be a poor party", actualResult);
		
	}
	
	@Test
	public void is_80cigs_successful() {
		int numOfCigars = 80;
		boolean isWeekend = false;
		
		boolean actualResult = cigarParty.haveParty(numOfCigars, isWeekend);
		
		Assert.assertFalse("This should be a poor party", actualResult);
		
	}
	@Test
	public void is_80cigs_successful_onWeekend() {
		int numOfCigars = 80;
		boolean isWeekend = true;
		
		boolean actualResult = cigarParty.haveParty(numOfCigars, isWeekend);
		
		Assert.assertTrue("This should be a poor party", actualResult);
		
	}
	
	
	
	
	

}
