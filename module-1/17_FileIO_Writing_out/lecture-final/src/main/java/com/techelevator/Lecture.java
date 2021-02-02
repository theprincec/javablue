package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */
		System.out.print("Path to File: ");
		String pathToFile = userInput.nextLine();
		
		File fileFromUserPath = new File(pathToFile);
		
		/*
		 * File object has methods to give information about the file or
		 * directory it is representing such as the name, path, size, etc.
		 */
		System.out.println("File name: " + fileFromUserPath.getName() );
		System.out.println("Absolute path: " + fileFromUserPath.getAbsolutePath() );
		System.out.println("Is File: " + fileFromUserPath.isFile() );
		System.out.println("Is Directory: " + fileFromUserPath.isDirectory() );
		System.out.println("Size: " + fileFromUserPath.length() );

		System.out.print("Path for a new Directory: ");
		String newDirectoryPath = userInput.nextLine();
		
		/*
		 * The File Object can represent either a directory/file that exists or a new one
		 * that does not yet exist
		 */
		File fileForNewDirectory = new File(newDirectoryPath);
		
		System.out.println("Name: " + fileForNewDirectory.getName() );
		System.out.println("Exist: " + fileForNewDirectory.exists() );
		System.out.println("Size: " + fileForNewDirectory.length() );
		
		System.out.println("--------- create the new directory --------");
		/*
		 * A directory can be created using mkdir().  It will create the directory with the path and
		 * name given in the constructor.  This directory cannot already exist.
		 */
		fileForNewDirectory.mkdir();
		
		System.out.println("Name: " + fileForNewDirectory.getName() );
		System.out.println("Absolute path: " + fileForNewDirectory.getAbsolutePath() );
		System.out.println("Exist: " + fileForNewDirectory.exists() );
		System.out.println("Size: " + fileForNewDirectory.length() );
		
		System.out.print("New File name: ");
		String newFileName = userInput.nextLine();
		
		/*
		 * The File constructor has an overload that can take the path and the filename
		 * as separate arguments
		 */
		File fileForNewFile = new File(fileForNewDirectory.getAbsolutePath(), newFileName);
		
		System.out.println("Name: " + fileForNewFile.getName() );
		System.out.println("Exist: " + fileForNewFile.exists() );
		System.out.println("Size: " + fileForNewFile.length() );
		
		System.out.println("--------- create the new file --------");
		
		/*
		 * createNewFile() can be used to create a new file on the file system.  It will be 
		 * created at the path and name given in the constructor of the File object.  The file
		 * must not already exist.
		 */
		fileForNewFile.createNewFile();
		
		System.out.println("Name: " + fileForNewFile.getName() );
		System.out.println("Absolute path: " + fileForNewFile.getAbsolutePath() );
		System.out.println("Exist: " + fileForNewFile.exists() );
		System.out.println("Size before writing: " + fileForNewFile.length() );
	
	
		/* 
		 * PrintWriter can be used to write to the file
		 * It should always be instantiated in a try-with-resource and is
		 * passed a File object that is representing the file to write to.
		 */
		try (PrintWriter writer = new PrintWriter(fileForNewFile)) {
			writer.println("This line was printing from our Java code");
		}
		
		System.out.println("Size after writing: " + fileForNewFile.length() );
	}

}
