package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.City;

@Component
public class JdbcCityDao implements CityDao{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcCityDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public List<City> getCitiesByCountryCode(String code) {
		SqlRowSet rows = jdbcTemplate.queryForRowSet(
				"SELECT id, name FROM city WHERE countryCode = ?", code);
		List<City> cities = new ArrayList<City>();
		while (rows.next()) {
			cities.add( new City(rows.getLong("id"), rows.getString("name")));
		}
		return cities;
	}

}
