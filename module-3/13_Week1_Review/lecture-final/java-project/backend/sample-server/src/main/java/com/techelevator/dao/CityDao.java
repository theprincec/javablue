package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.City;

public interface CityDao {

	List<City> getCitiesByCountryCode(String code);
}
