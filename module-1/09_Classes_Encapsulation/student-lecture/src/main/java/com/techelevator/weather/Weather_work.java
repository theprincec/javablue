package com.techelevator.weather;

public class Weather_work {
	
	
	// public returntype name
	public Map<String, List<Weather>> getWeatherForCity() {
		
		// create a new HashMap to hold the forecasts for the cities
		//Create a list of weather where each item represents a day
		// add a list to the map withthe city name a key
		//repeat creating a list and addinf the the map for each city we want 
		//after all cities are added
		
		//creates map called cityForecast
		
		Map<String, List<Weather>> cityForecast = new HashMap<String, List<Weather>>();
		
		//creates map called cityWeather
		List<Weather> cityWeather = new ArrayList<Weather>();
		
		
		//Set the values using the constructor overload (Weather = data type)(weather = variable name)
		Weather weather = new Weather(1,35,"Sunny");
				
		//or set the values using setters
		weather = new Weather(2);
		weathe
		
		
		
		
		
		
		
		
		return cityForecast;
		
	}

}
