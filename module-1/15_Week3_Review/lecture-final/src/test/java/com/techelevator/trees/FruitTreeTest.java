package com.techelevator.trees;

import org.junit.*;

public class FruitTreeTest {

	private FruitTree fruitTree;
	
	@Before
	public void setup() {
		fruitTree = new FruitTree("Apples", 10);
	}
	
	/*
	 * Verify constructor with different values (type of fruit and number)
	 * 
	 * -Pick more fruit than the tree has
	 * -Pick the exact amount of fruit
	 * -Pick an allowed amount of fruit
	 * - Pick zero fruit
	 * - Pick negative fruit
	 * 
	 * -pick allowed amount twice
	 * -pick allowed amount twice, then more than allowed
	 * 
	 * -Fruit tree starts with the correct fruit
	 * -Fruit tree starts with the correct amount of fruit
	 */
	
	@Test
	public void tree_has_correct_fruit() {
		Assert.assertEquals("Apples", fruitTree.getTypeOfFruit());
	}
	
	@Test
	public void tree_has_correct_amount_of_fruit() {
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_too_much_fruit() {
		// Arrange
		// Act
		Assert.assertFalse( fruitTree.pickFruit(11) );
		// Assert
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft() );
	}
	
	@Test
	public void pick_exact_amount_of_fruit() {
		// Arrange
		// Act
		Assert.assertTrue( fruitTree.pickFruit(10) );
		// Assert
		Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft() );
	}
	
	@Test
	public void pick_allowed_amount_of_fruit() {
		// Arrange
		// Act
		Assert.assertTrue( fruitTree.pickFruit(5) );
		// Assert
		Assert.assertEquals(5, fruitTree.getPiecesOfFruitLeft() );
	}
	
	@Test
	public void pick_zero_fruit() {
		// Arrange
		// Act
		Assert.assertTrue( fruitTree.pickFruit(0) );
		// Assert
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft() );
	}
	
	@Test
	public void pick_negative_fruit() {
		// Arrange
		// Act
		Assert.assertFalse("pickFruit returned True", fruitTree.pickFruit(-1) );
		// Assert
		Assert.assertEquals("Tree has wrong amount of fruit: " + fruitTree.getPiecesOfFruitLeft(),
				10, fruitTree.getPiecesOfFruitLeft() );
	}
	
	@Test
	public void pick_allowed_amount_twice() {
		// Arrange - setting up the object's state needed for the test
		fruitTree.pickFruit(3);
		// Act - a single action that is the test
		boolean result = fruitTree.pickFruit(4);
		// Assert - verifying the result and the side effects (how the object's state has changed)
		Assert.assertTrue("pickFruit returned false", result);
		Assert.assertEquals(3, fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_allowed_amount_twice_then_more_than_allowed() {
		
		/*
		 * If the values or calculations are large or complicated, they
		 * can be done in code and stored as part of the arrange and then
		 * used in the test and asserts.
		 */
		int startingFruit = fruitTree.getPiecesOfFruitLeft();
		int firstPick = 2;
		int secondPick = 4;
		int expectedRemaining = startingFruit - firstPick - secondPick;
		int overPick = expectedRemaining + 1;
		
		
		// Arrange
		fruitTree.pickFruit(firstPick);
		fruitTree.pickFruit(secondPick);
		
		// Act
		boolean result = fruitTree.pickFruit(overPick);
		
		// Assert
		Assert.assertFalse(result);
		Assert.assertEquals(expectedRemaining, fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void tree_can_hold_different_type_of_fruit( ) {
		// Arrange
		/*
		 * A second object with different state can be instantiated in a test
		 * if needed for what is being tested. 
		 */
		FruitTree pearTree = new FruitTree("Pears", 5);
		// Act
		String fruitType = pearTree.getTypeOfFruit();
		// Assert
		Assert.assertEquals("Pears", fruitType);
	}
}
