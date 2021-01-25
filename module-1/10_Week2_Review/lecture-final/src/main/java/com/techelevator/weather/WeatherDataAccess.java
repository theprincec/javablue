package com.techelevator.weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherDataAccess {

	public Map<String, List<Weather>> getWeatherForCity() {
		
		/*
		 * Create a new HashMap to hold the forecasts for the cities
		 * Create a list of weather where each item represents a day
		 * Add the list to the Map with the city name a key
		 * Repeat creating a list and adding to the map for each city we want 
		 * After all cities are added, return the map
		 */
		
		Map<String, List<Weather>> cityForecast = new HashMap<String, List<Weather>>();
		
		List<Weather> cityWeather = new ArrayList<Weather>();
		
		// Set the values using the constructor overload
		Weather weather = new Weather(1, 35, "Sunny");
		cityWeather.add(weather);
		
		// Or set the values using the setters
		weather = new Weather(2);
		weather.setForecast("Cloudy");
		weather.setTempInFahrenheit(43);
		cityWeather.add(weather);
		
		// Instantiate the object and immediately add it to the list
		cityWeather.add( new Weather(3, 20, "Snow") );
		
		cityWeather.add( new Weather(4, 60, "Rain") );
		cityWeather.add( new Weather(5, 19, "Cloudy") );
		cityWeather.add( new Weather(6, 43, "Partly Sunny") );
		cityWeather.add( new Weather(7, 50, "Partly Cloudy") );
		
		// Add the List for Columbus to the Map
		cityForecast.put("COLUMBUS", cityWeather);
		
		// Instantiate a new List for Cleveland
		cityWeather = new ArrayList<Weather>();
		
		cityWeather.add( new Weather(1, 20, "Windy") );
		cityWeather.add( new Weather(2, 13, "Cloudy") );
		cityWeather.add( new Weather(3, 10, "Snow") );
		cityWeather.add( new Weather(4, 32, "Cloudy") );
		cityWeather.add( new Weather(5, 8, "Cloudy") );
		cityWeather.add( new Weather(6, 34, "Rain") );
		cityWeather.add( new Weather(7, 23, "Partly Cloudy") );
		
		// Add the List for Cleveland to the Map
		cityForecast.put("CLEVELAND", cityWeather);
		
		
		
		return cityForecast;
		
	}
	
}
