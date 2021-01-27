package com.techelevator;

public class FruitTree {
	
	
	private int piecesOfFruitLeft;
	private String typeOfFruit;
	
	
	
	
	
	public int getPiecesOfFruitLeft() {
		return this.piecesOfFruitLeft;
		
	}
	public String getTypeOfFruit() {
		return this.typeOfFruit;
		
	}

//	public void setPiecesOfFruitLeft(int piecesOfFruitLeft) {
//		this.piecesOfFruitLeft =piecesOfFruitLeft  ;
//		
//	}
//	public void setTypeOfFruit(String typeOfFruit) {
//		this.typeOfFruit=typeOfFruit;
//	}
		
		
		
	//constructor
	public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
		this.piecesOfFruitLeft = piecesOfFruitLeft;
		this.typeOfFruit = typeOfFruit;
	}
	
	
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if (numberOfPiecesToRemove<=piecesOfFruitLeft) {
			piecesOfFruitLeft-=numberOfPiecesToRemove;
			return true;
		} else {
			return false;
		}
	}

}
