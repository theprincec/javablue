package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ClosingResourcesExample {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("testfile.txt");
		
		PrintWriter writer = new PrintWriter(file);
		writer.write("This text was written from Java");
		
	}

}
