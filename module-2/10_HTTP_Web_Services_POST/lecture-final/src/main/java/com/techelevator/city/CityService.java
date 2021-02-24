package com.techelevator.city;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class CityService {

	private final static String CITY_API_URL = "https://5f9719b611ab98001603b7c0.mockapi.io/api/cities";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	/*
	 * GET List of entities
	 */
	public List<City> getAllCities() {
		
		City[] cities = restTemplate.getForObject(CITY_API_URL, City[].class);
		
		return Arrays.asList(cities);
		
	}
	
	/*
	 * GET single entity
	 */
	public City getById(int cityId) {
		return restTemplate.getForObject(CITY_API_URL + "/" + cityId, City.class);
	}
	
	/*
	 * POST
	 */
	public City save(City city) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<City> entity = new HttpEntity<City>(city, headers);
		
		return restTemplate.postForObject(CITY_API_URL, entity, City.class);
	}
	
	/*
	 * PUT
	 */
	public void update(City city) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<City> entity = new HttpEntity<City>(city, headers);
		
		restTemplate.put(CITY_API_URL + "/" + city.getId(), entity);
	}
	
	/*
	 * DELETE 
	 */
	public void delete(int cityId) {
		restTemplate.delete(CITY_API_URL + "/" + cityId);
	}
}
