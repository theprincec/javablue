package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CityDao;
import com.techelevator.model.City;

@RestController
public class CityController {

	private CityDao cityDao;
	
	public CityController(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	@RequestMapping(path="/cities", method=RequestMethod.GET)
	public List<City> getByCountryCode(@RequestParam(name="code") String countryCode){
		return cityDao.getCitiesByCountryCode(countryCode);
	}
	
}
