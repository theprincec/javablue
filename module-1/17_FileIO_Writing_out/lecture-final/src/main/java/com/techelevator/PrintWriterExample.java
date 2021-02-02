package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	/*
	 * Steps to write to a file
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * Step 1:  Create a File object that represents the file being written to
		 *          This file must exist when using PrintWriter.  If it doesn't exist 
		 *          it must be created.
		 */
		File fileToWriteTo = new File("fileBeingWrittenTo.txt");
		fileToWriteTo.createNewFile();
		
		/*
		 * Step 2: Create a PrintWriter (or other FileWriter) in a try-with-resource and
		 *         pass it the File object that represents the file to write to.
		 */
		try (PrintWriter printWriter = new PrintWriter( fileToWriteTo ) ) {
			/*
			 * Step 3:  Call the print(), println(), or printf() method on the print writer
			 *          and pass it the string to write to the file.  We can repeat this
			 *          as many times as needed.  Each call to println() will write to a 
			 *          new line.
			 */
			printWriter.println("This is the text to write to the file");
			printWriter.println("This is the second line");
			printWriter.println("This is the third line");
			
		}

	}

}
