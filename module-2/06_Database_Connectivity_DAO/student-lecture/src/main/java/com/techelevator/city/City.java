package com.techelevator.city;

/*
 * The Data Object (also called a Java Bean, Business Object, or Domain Object) represents
 * 1 row returned from the Query.  Usually representing a table, but can also represent the
 * columns of more advanced queries that join multiple tables.
 */
public class City {
	
	/*
	 * Private member variables for each value
	 */
	private Long id;
	private String name;
	private String countryCode;
	private String district;
	private int population;

	/*
	 * A Data Object (Java Bean) must always have a no argument constructor.  
	 * If no constructor overloads are needed, then the default constructor can be used.
	 */
	
	
	/*
	 * Both Getter and Setter for all member variables are required
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
