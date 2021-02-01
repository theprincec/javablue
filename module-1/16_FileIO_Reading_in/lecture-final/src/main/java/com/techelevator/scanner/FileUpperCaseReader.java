package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUpperCaseReader {

	public static void main(String[] args) {
		

		File file = new File("Dracula.txt");
		
		try (Scanner textReader = new Scanner(file)) {
			
			int lineNumber = 0;
			while( textReader.hasNextLine() && lineNumber < 500 ) {
				
				String nextLineOfFile = textReader.nextLine();
				lineNumber++;
				
				System.out.println( lineNumber + ") " + nextLineOfFile.toUpperCase());
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}
		
	}
	
}
