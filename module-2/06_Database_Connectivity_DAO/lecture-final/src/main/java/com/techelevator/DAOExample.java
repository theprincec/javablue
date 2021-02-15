package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	/*
	 * Example of using a DAO
	 */
	public static void main(String[] args) {
	
		// STEP 1: Create a DataSource
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		// STEP 2: Instantiate the DAO Implementation class with the DataSource
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		// STEP 3: Use the DAO methods to access the database
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville);
		
		City theCity = dao.findCityById(510);
		
	}

}
