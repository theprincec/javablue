package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the temperature and system (separated by a space): ");
		String enteredTemp = in.nextLine();
		String [] tempAsArray = enteredTemp.split(" ");
		
		//double returnTemp = Double.parseDouble(tempAsArray[0]);
		String returnTemp = tempAsArray[0];
		String returnTempType = tempAsArray[1];
		
		System.out.println(returnTemp);
		System.out.println(returnTempType);
		
		
		

		
//		double tempAsDouble = Double.parseDouble(tempArray[0]);
//		String degreeType = tempArray[1];
//		
		double finalTemp = Double.parseDouble(returnTemp);
		
		
		if (returnTempType == "f") {
			finalTemp = (finalTemp * .55556) - 32;
			System.out.print(returnTemp + " degrees");
		} else {
			finalTemp = Double.parseDouble((returnTemp * 1.4) - 32);
			System.out.print(returnTemp + " degrees");
		}

	}

}
