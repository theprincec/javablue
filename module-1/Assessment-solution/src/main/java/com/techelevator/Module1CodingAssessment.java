package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		
		HotelReservation reservation = new HotelReservation("John Fulton", 2);
		
		System.out.println("Name: " + reservation.getName());
		System.out.println("Number of Nights: " + reservation.getNumberOfNights());
		reservation.setNumberOfNights(3);
		System.out.println("Number of Nights after set: " + reservation.getNumberOfNights());
		System.out.println("Estimate Total: " + reservation.getEstimatedTotal());
	
		List<HotelReservation> reservations = new ArrayList<HotelReservation>();
	
		try (Scanner fileScanner = new Scanner(new File("./data-files/HotelInput.csv"))) {
			
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] parts = line.split(",");
				String name = parts[0];
				int numberOfNights = Integer.parseInt(parts[1].trim());
				HotelReservation newReservation = new HotelReservation(name, numberOfNights);
				reservations.add(newReservation);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		
		double totalOfAllReservations = 0;
		
		for (HotelReservation currentReservation : reservations) {
			totalOfAllReservations += currentReservation.getEstimatedTotal();
			System.out.println(currentReservation);
		}
		
		System.out.println("Total: " + totalOfAllReservations);
		
	}

}
