package com.techelevator;

import java.util.Scanner;

/*
 * 1. Take user input
 * 2. Use that input to do some work
 * 3. Display a response
 */
public class CatPackingCalculator {

	public static void main(String[] args) {
		/*
		 * What are the boxes dimensions - length, width, height
		 * Calculate the boxes volume
		 * Determine how many cats can fit in that volume
		 * Give the answer
		 */
		double averageVolumeOfHouseCat = 0.083;
		double estimatePackingDensityOfCat = 0.5;
		
		Scanner input = new Scanner( System.in );
		
		System.out.print("What is the length of the container in feet: ");
		String lengthOfContainer = input.nextLine();
		double containerLengthInFeet = Double.parseDouble( lengthOfContainer );
		
		System.out.print("What is the width of the container in feet: ");
		String widthOfContainer = input.nextLine();
		double containerWidthInFeet = Double.parseDouble( widthOfContainer );
		
		System.out.print("What is the height of the container in feet: ");
		String heightOfContainer = input.nextLine();
		double containerHeightInFeet = Double.parseDouble( heightOfContainer );

		double containerVolume = containerLengthInFeet 
								* containerWidthInFeet 
								* containerHeightInFeet;
		double catsByVolume = containerVolume / averageVolumeOfHouseCat;
		double packedCats = catsByVolume * estimatePackingDensityOfCat;
		
		System.out.println();
		
		System.out.printf("%-15s %-15s %-15s %-25s %n", "Height", "Width", "Length", "Cats in Box");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-6.0f %n", containerHeightInFeet, 
								containerWidthInFeet, containerLengthInFeet, packedCats);
	}

}
