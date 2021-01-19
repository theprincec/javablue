package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		
		
		
		Scanner in = new Scanner(System.in);
		//String nextStep = in.nextLine();
		//while (!(nextStep.equals("/q"))){
		
		System.out.print("Enter the temperature and system (separated by a space): ");
		String enteredTemp = in.nextLine();
		String [] tempAsArray = enteredTemp.split(" ");
		
		
		//double returnTemp = Double.parseDouble(tempAsArray[0]);
		String returnTemp = tempAsArray[0];
		//String returnTempType = tempAsArray[1];
		
		System.out.println(returnTemp);
		//System.out.println(returnTempType);
		
		String farenheit = "f", celsius = "c";
		

		
//		double tempAsDouble = Double.parseDouble(tempArray[0]);
//		String degreeType = tempArray[1];
//		
		double finalTemp = Double.parseDouble(returnTemp);
		
		
		if (tempAsArray[1].equals(farenheit)) {
			finalTemp = (finalTemp * .55556) - 32;
			System.out.print(finalTemp + " degrees Celsius");
		} else {
			finalTemp = (finalTemp * 1.4) + 32;
			System.out.print(finalTemp + " degrees Farenheit");
		}
		System.out.println("Do you want to determine any other temperatures. Enter any key to continue. Enter 'f' to exit");
		String nextStep = in.nextLine();
		
		
		

	}

}
