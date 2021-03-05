package com.techelevator.cities.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class City {
	
	private long id;
	@NotBlank(message="name is required")
	private String name;
	@NotBlank(message="countryCode is required")
	private String countryCode;
	@NotBlank(message="district is required")
	private String district;
	@Min(value=0, message="population must be at least 0")
	private int population;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
