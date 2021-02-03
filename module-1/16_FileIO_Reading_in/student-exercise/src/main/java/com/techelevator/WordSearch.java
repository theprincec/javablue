package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException{
		
		
		File file = null;
		
		System.out.print("What would you like to search for? ");
		String searchTerm = input.nextLine();
		

		while (true) {
			System.out.println("Where is it located (file name)? >>> ");
			String pathToFile = input.nextLine();
			
			/*
			 * File object represents a file.  The constructor
			 * takes an argument of the path to the file as a string
			 */
			file = new File(pathToFile);
			
			if (!file.exists() || !file.isFile()) {
				System.out.println("This file does not exist.");
			} else {
				break;
			}
		}
		
		
		try (Scanner fileScanner = new Scanner(file)) {
			
			int lineNumber = 0;
			while (fileScanner.hasNextLine()) {
				String lineFromFile = fileScanner.nextLine();
				System.out.println(lineFromFile);
				lineNumber++;
				
				if (lineFromFile.contains(searchTerm)) {
					System.out.println( lineNumber + "\n" + lineFromFile );
					System.out.println();
				}
			}

		//return searchTerm;
		
		}
	}}
