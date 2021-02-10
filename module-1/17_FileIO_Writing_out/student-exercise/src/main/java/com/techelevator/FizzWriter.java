package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {
	
	private final static String FILE_NAME = "FizzBuzzText.txt";
	private final static int UPPER_LIMIT = 300;

	public static String main(String[] args) throws IOException {
		
		File file = new File(FILE_NAME);
		
		file.createNewFile();
		
		try (PrintWriter printWriter = new PrintWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
			for (int i = 1 ; i <= UPPER_LIMIT ; i++) {
				//printWriter.println(getOutput(i));
				bufferedWriter.write(getFizzbuzz(i) + "\n");  // \n is a carriage return
				//bufferedWriter.write(getOutput(i) + System.getProperty("line.separator")); 
					/*
					 * System.getProperty("line.separator") gets the carriage return used 
					 * by the current Operating System.
					 */
			}
		}
		
		//System.out.println("Printing is Finished!");
		return "Printing is Finished!";
		
			
	}

		
	private static String getFizzbuzz(int i) {
		
		String color = String.valueOf(i);
		
		if (i%3==0 && i%5==0) {
			color = "FizzBuzz";
		}
		else if (i%3==0) {
			color = "Fizz";
		}
		else if (i%5==0) {
			color = "Buzz";
		}
		return color;
		
	}
	
	
	private static String getOutput(int i1) {
		
		String output = String.valueOf(i1);
		
		if (i1 % 5 == 0) {
			output = "RED";
		} else if (i1 % 7 == 0) {
			output = "BLUE";
		} else if (i1 % 9 == 0) {
			output = "GREEN";
		}
		
		return output;
	}
		
		
		
		
		
		
//		If the number is divisible by 3 or contains a 3, print “Fizz.”
//		If the number is divisible by 5 or contains a 5, print “Buzz.”
//		If the number is divisible by 3 and 5, print “FizzBuzz.”
//		Otherwise, print the number.


}
