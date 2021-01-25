package com.techelevator.weather;

public class Weather {
	
	
	private final static String[] DAYS_OF_THE_WEEK = {
			"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
	};
	
	//State (member variables/data/properties)
	private int dayOfWeek;
	private int tempInFarenheit;
	private String forecast;
	
	
	
	//How to instantiate Class (constructor)
	
//  Getters and Setters provide (public) access to the private member variables
	
//	Getters always:
//		start with get
//		have a return type
//		have 0 parameters
//		almost always public
	
	
	public int getTempInFarenheit() {
		return this.tempInFarenheit;
	}
	
//	Setters always:
//		have a void as return type
//		take 1 parameter
//		start with set
//		have the same name as getter (except with set)
//		mostly public
	
	public void setTempInFarenheit() {
		this.tempInFarenheit = tempInFarenheit; 
	}
	
	public String getForecast() {
		return this.forecast;
	}
	public void setForecast() {
		this.forecast = forecast; 
	}
	
	//How to instantiate Class (constructor)
	
//	Constructors are:
//		methods with slightly special rules 
//		names the same as the class name
//		no return type
//		always required when calling new on a class
//		automatically provided if you define 0 constructors 
//		usually public
		
		
	
//	(overloading--instantiating based on the number of arguments)
	
	public Weather(int day) {
		this.dayOfWeek = day;
	}
	public Weather(int day, int tempInFarenheit, String forecast) {
		this.dayOfWeek = day;
		this.tempInFarenheit = tempInFarenheit;
		this.forecast = forecast;
		
	}
	
	
	
	
	
	
	
	//Behavior (methods)
	
	
	
	
	private void validateDayOfWeek(int day) {
		if (day<1 ||day>7) {
			this.dayofWeek = DEFAULT_DAY;
		}else {
			this.dayOfWeek = day;
		}
	}
	
	
	
	

}
