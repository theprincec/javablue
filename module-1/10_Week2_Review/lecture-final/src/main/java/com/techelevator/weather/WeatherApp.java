package com.techelevator.weather;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WeatherApp {

	private final static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Ask the user what city
		// Get the forecast for that city
		// display the forecast
		
		// Instantiating a WeatherDataAccess object 
		WeatherDataAccess weatherData = new WeatherDataAccess();
		
		// Using the WeatherDataAccess object to retrieve the map of the weather
		// for cities
		Map<String, List<Weather>> cityForecasts = weatherData.getWeatherForCity();
		
		System.out.print("What City (Columbus or Cleveland) >>>");
		String citySelected = input.nextLine();
		
		System.out.print("(F)ahrenheit or (C)elsius >>>");
		String tempScaleSelected = input.nextLine();
		
		List<Weather> forecast = cityForecasts.get(citySelected.toUpperCase());
		
		System.out.println();  // prints a blank line to the console
		
		System.out.println("The forecast for " + citySelected);
		
		for (Weather day : forecast) {
			System.out.print( day.getDayOfWeek() + " - ");
			
			int temp = day.getTempInFahrenheit();
			if (tempScaleSelected.equalsIgnoreCase("C")) {
				temp = Weather.convertFahrenheitToCelsius(temp);
			}
			System.out.print(temp + tempScaleSelected + " - ");
			System.out.println(day.getForecast());
		}
		
	

	}

}
