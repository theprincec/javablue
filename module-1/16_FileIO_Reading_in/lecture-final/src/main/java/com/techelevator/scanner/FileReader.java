package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	private static final Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		File file = null;
		
		while (true) {
			System.out.println("File name >>>");
			String pathToFile = userInput.nextLine();
			
			/*
			 * File object represents a file.  The constructor
			 * takes an argument of the path to the file as a string
			 */
			file = new File(pathToFile);
			
			if (!file.exists() || !file.isFile()) {
				System.out.println("File does not exist.");
			} else {
				break;
			}
		}
		
		/*
		 * a try-with-resource automatically closes
		 * a resource when the try block ends or there is an exception
		 * 
		 */
		try (Scanner fileScanner = new Scanner(file)) {
		
			while (fileScanner.hasNextLine()) {
				String lineFromFile = fileScanner.nextLine();
				System.out.println(lineFromFile);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
