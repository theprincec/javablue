package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the length and unit (separated by a space): ");
		String enteredLength = in.nextLine();
		System.out.print("Is this meters or feet? ");
		String enteredUnit = in.nextLine();
		String [] lengthAsArray = enteredLength.split(" ");
		
		//double returnTemp = Double.parseDouble(tempAsArray[0]);
		String lengthAmount = lengthAsArray[0];
		//String lengthUnit = lengthAsArray[1];
		
		System.out.println(Double.parseDouble(lengthAmount));
		//System.out.println(lengthUnit);
		System.out.println(enteredUnit);
		
		double lengthAsDouble = 0;
		
		String meters = "m", feet = "f";
		
//		The foot to meter conversion formula is:
//
//		    m = f * 0.3048
//
//		The meter to foot conversion formula is:
//
//		    f = m * 3.2808399
		
		if (enteredUnit.equals(meters)) {
			lengthAsDouble = Double.parseDouble(lengthAmount)* 0.3048;
			System.out.println("Your length is " + lengthAsDouble + " feet");
		} else if (enteredUnit.equals(feet)) {
			lengthAsDouble = Double.parseDouble(lengthAmount)* 3.2808399;
			System.out.println("Your length is " + lengthAsDouble + " meters");
		} else if (!(enteredUnit == "f") || !(enteredUnit == "m")) {
			System.out.println("This is not a valid unit type. Please rerun with using 'm' for meters or 'f' for feet");
			
		}
		
		

		
//		double tempAsDouble = Double.parseDouble(tempArray[0]);
//		String degreeType = tempArray[1];
//		
		
		
//		double finalTemp = Double.parseDouble(returnTemp);
//		
//		
//		if (returnTempType == "f") {
//			finalTemp = (finalTemp * .55556) - 32;
//			System.out.print(returnTemp + " degrees");
//		} else {
//			finalTemp = Double.parseDouble((returnTemp * 1.4) - 32);
//			System.out.print(returnTemp + " degrees");
//		}
//

	}

}
