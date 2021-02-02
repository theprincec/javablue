package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedWriterExample {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Create a file and PrintWriter the same as before
		 */
		File fileToWriteTo = new File("bufferedFile.txt");
		fileToWriteTo.createNewFile();
		
		/*
		 * To add buffering a Print Writer is still needed and will still do the writing.
		 * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
		 * write to the file and the buffered writer will provide buffering.
		 */
		try (PrintWriter printWriter = new PrintWriter(fileToWriteTo);
				BufferedWriter bufferedWriter = new BufferedWriter( printWriter) ) {
			
			bufferedWriter.write("This text writes to the file using a buffer, but we must "
					+ "add our own carriage returns\n");
			//printWriter.println("This text goes in the file");
		}

	}

}
