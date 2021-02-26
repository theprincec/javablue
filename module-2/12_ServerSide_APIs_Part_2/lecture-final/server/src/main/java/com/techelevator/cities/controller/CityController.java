package com.techelevator.cities.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.cities.dao.CityDao;
import com.techelevator.cities.exception.CityNotFoundException;
import com.techelevator.cities.model.City;

@RestController
@RequestMapping("/cities")
public class CityController {

	private CityDao cityDao;
	
	public CityController(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	// http://localhost:8080/cities?code=GBR - GET cities by country code
	// http://localhost:8080/cities  - GET All Cities
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<City> list(@RequestParam(required=false, name="code") String countryCode) {
		
		if (countryCode != null) {
			return cityDao.searchByCountryCode(countryCode);
		}
		
		return cityDao.list();
	}
	
	//http://localhost:8080/cities/119  - GET City by Id
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public City get(@PathVariable int id) throws CityNotFoundException {
		City city = cityDao.get(id);
		if (city == null) {
			throw new CityNotFoundException();
		}
		return city;
	}
	
	// http://localhost:8080/cities  - POST (add) a City
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="", method=RequestMethod.POST)
	public City add(@Valid @RequestBody City city) {
		return cityDao.add(city);
	}
	
	// http://localhost:8080/cities/119 - PUT (update) a City
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public City update(@PathVariable int id, @Valid @RequestBody City city) throws CityNotFoundException {
		if (cityDao.get(id) == null) {
			throw new CityNotFoundException();
		}
		
		city.setId(id);
		return cityDao.update(city);
	}
	
	// http://loalhost:8080/cities/119 - DELETE city
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) throws CityNotFoundException {
		if (cityDao.get(id) == null) {
			throw new CityNotFoundException();
		}
		cityDao.delete(id);
	}
	
	
}
