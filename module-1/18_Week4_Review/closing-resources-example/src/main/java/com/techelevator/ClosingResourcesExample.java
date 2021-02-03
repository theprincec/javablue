package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ClosingResourcesExample {

	public static void main(String[] args) throws IOException {
		
		File file = new File("testfile.txt");
		
		try (PrintWriter writer = new PrintWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
		
			writer.write("This text was written from Java with Try with Resource");
		
		
		}
		

	}

}
