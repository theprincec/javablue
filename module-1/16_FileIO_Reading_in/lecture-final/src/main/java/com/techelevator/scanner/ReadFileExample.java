package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * The path can be just the name (relative), if 
		 * the file is in the root of the project directory, 
		 * otherwise it needs to be an absolute path.
		 * 
		 * Example: /Users/student/Development/java-blue-material/module-1/16_FileIO_Reading_in/lecture-final/rtn.txt
		 */
		String pathToFile = "rtn.txt";
		
		/*
		 * Step 1 : Create a File object passing it the path to the file
		 */
		File fileObject = new File( pathToFile );

		/*
		 * Step 2: Create a Scanner in a try-with-resource and use the instantiated File Object
		 *         as the input stream.  The try-with-resource guarantees that the file
		 *         connection is closed and cleaned up when the block ends.
		 *         
		 *  The checked FileNotFoundException can either be caught and dealt with using a 
		 *  catch, or passed on using throws
		 */
		try ( Scanner fileScanner = new Scanner( fileObject ) ) {
			 
			/*
			 * Step 3: In the try, loop while the Scanner returns True for hasNextLine()
			 *         The hasNextLine() method returns true if there is another line in 
			 *         the file and false if the scanner is at the end of the file
			 */
			while ( fileScanner.hasNextLine() ) {
				/*
				 * Step 4: If hasNextLine() is true, then call nextLine() to get the next line
				 *         of the file (up to the next carriage return) as a String
				 */
				String lineFromFile = fileScanner.nextLine();
			}
		}
		

	}

}
