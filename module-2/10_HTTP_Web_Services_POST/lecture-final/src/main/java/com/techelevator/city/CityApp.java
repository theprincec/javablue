package com.techelevator.city;

import java.util.List;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

public class CityApp {

	public static void main(String[] args) {
		
		try {
			CityService cityService = new CityService();
			
			List<City> cities = cityService.getAllCities();
			
			for (City city : cities) {
				System.out.println(city);
			}
			
			City city = new City();
			city.setName("fromJava");
			city.setDistrict("Ohio");
			city.setPopulation(10);
			city.setCountryCode("USA");
			
			City returnedCity = cityService.save(city);
			
			System.out.print(returnedCity);
			
			returnedCity.setName("UpdatedFromJava");
			returnedCity.setPopulation(500);
			
			cityService.update(returnedCity);
			
			cityService.delete(returnedCity.getId());
			
		} catch (RestClientResponseException e) {
			System.out.println(e.getRawStatusCode() + " " + e.getStatusText());
		} catch (ResourceAccessException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
