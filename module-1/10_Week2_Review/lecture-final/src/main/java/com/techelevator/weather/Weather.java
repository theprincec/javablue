package com.techelevator.weather;

public class Weather {

	private final static String[] DAYS_OF_THE_WEEK = {
		"Sunday", "Monday", "Tuesday", "Wednesday", 
		"Thursday", "Friday", "Saturday"
	};
	
	private final static int DEFAULT_DAY = 1;
	
	// State  (data - member variables)
	private int dayOfWeek;
	private int tempInFahrenheit;
	private String forecast;
	
	/*
	 *  Getters and Setters provide public access to
	 *  the private member variables
	 */
	public int getTempInFahrenheit() {
		return this.tempInFahrenheit;
	}
	public void setTempInFahrenheit(int tempInFahrenheit) {
		this.tempInFahrenheit = tempInFahrenheit;	
	}
	
	public String getForecast() {
		return this.forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	// Derived Property (getter) doesn't store a value, but calculates
	public String getDayOfWeek() {
		return DAYS_OF_THE_WEEK[this.dayOfWeek - 1];
	}
	
	// How to instantiate the class (constructor)
	public Weather(int day) {
		validateDayOfWeek(day);
	}
	public Weather(int day, int tempInFahrenheit, String forecast) {
		validateDayOfWeek(day);
		this.tempInFahrenheit = tempInFahrenheit;
		this.forecast = forecast;
	}
	
	// Behavior  (methods)
	private void validateDayOfWeek(int day) {
		if (day < 1 || day > 7) {
			this.dayOfWeek = DEFAULT_DAY;
		} else {
			this.dayOfWeek = day;
		}
	}
	
	/* 
	 * Static methods are called from the data type (class name)
	 * instead of the instance
	 */
	public static int convertFahrenheitToCelsius(int fahrenheit) {
		return (fahrenheit - 30) / 2;
	}
}
