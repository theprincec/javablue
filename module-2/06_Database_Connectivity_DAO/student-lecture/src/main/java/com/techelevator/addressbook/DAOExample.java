package com.techelevator.addressbook;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public interface DAOExample {
	
	
	public static void main(String[] args) {
		
		// STEP 1: Create a DataSource
		BasicDataSource dataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		// STEP 2: Instantiate the DAO Implementation class with the DataSource
		ContactDAO dao = new JdbcContactDao(dataSource);
		
		// STEP 3: Use the DAO methods to access the database
		List <>
		
		
		
		
	}	

}
