package com.techelevator.cities.dao;

import java.util.List;

import com.techelevator.cities.model.City;

public interface CityDao {

	List<City> list();
	City get(long cityId);
	List<City> searchByCountryCode(String countryCode);
	City add(City city);
	City update(City city);
	void delete(long cityId);
}
