package com.techelevator.weather;

import java.util.*;
import java.util.Scanner;


public class Weather_App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ask user what city
		//get the forecast for that city
		//display the forecast
		
		
	private final static Scanner input = Scanner(System.in);	
		
		// instantiating a WeatherDataAccess object
		WeatherDataAccess  weatherData = new WeatherDataAccess();
		
		
		//Using the WeatherDataAccess object to retrieve the map of the weather for cities
		Map<String,List<Weather>> cityForecast = weatherData.getWeatherForCity();
		
		
		System.out.print("what city (Columbus or Cleveland?");
		String citySelected = input.nextLine();
		
		System.out.print("(F)ahrenheit or (C)elsius>>>>>");
		String tempScaleSelected  = input.nextLine();
		
		List <Weather> forecast = cityForecasts.get(citySelected.toUpperCase());
		
		System.out.println(); //blank line
		
		
		System.out.println("The forecast for " + citySelected);
		
		for (Weather day : forecast) {
			System.out.print( day.getDayOfWeek() + " - ");
			
			int temp = day. getTempInFahrenheit()
		}

	}

}
