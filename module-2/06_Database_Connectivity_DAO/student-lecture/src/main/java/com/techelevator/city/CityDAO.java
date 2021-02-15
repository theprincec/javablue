package com.techelevator.city;

import java.util.List;

/*
 * The DAO Interface defines the method (CRUD) available for the DAO. Not all
 * CRUD operations need to be defined, and multiple methods may be defined for each.
 * 
 * The methods use the DAO Data Object as returns and arguments, but may use other
 * Data Types as needed.
 */
public interface CityDAO {

	public void save(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city);
	public void delete(long id);
	
}
