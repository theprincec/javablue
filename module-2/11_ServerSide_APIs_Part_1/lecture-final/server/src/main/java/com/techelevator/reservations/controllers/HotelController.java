package com.techelevator.reservations.controllers;

import com.techelevator.cities.dao.CityDao;
import com.techelevator.cities.model.City;
import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;
    
  
    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path="/hotels", method=RequestMethod.GET)
    public List<Hotel> list(@RequestParam(required=false) String city, @RequestParam(required=false, defaultValue="") String state) {
    	
    	if (city == null && state.length() == 0) {
    		return hotelDAO.list();
    	}
    	
    	List<Hotel> filteredHotels = new ArrayList<Hotel>();
    	List<Hotel> hotels = hotelDAO.list();
    	
    	for (Hotel hotel : hotels) {
    		if (city != null) {
    			if (hotel.getAddress().getCity().equalsIgnoreCase(city)) {
    				filteredHotels.add(hotel);
    			}
    		} else {
    			if (hotel.getAddress().getState().equalsIgnoreCase(state)) {
    				filteredHotels.add(hotel);
    			}
    		}
    	}
    	
    	return filteredHotels;
    }
    

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path="/hotels/{id}", method=RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
    	return hotelDAO.get(id);
    }
    
    /**
     * Return All Reservations
     */
    @RequestMapping(path="/reservations",  method=RequestMethod.GET)
    public List<Reservation> listReservations() {
    	return reservationDAO.findAll();
    }
    
    /**
     * Return Reservation by Id
     * @param id
     * @return
     */
    @RequestMapping(path="/reservations/{id}", method=RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
    	return reservationDAO.get(id);
    }
    
    /**
     * Get Reservations for a hotel by the hotel id
     * @param hotelID
     * @return
     */
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
    public List<Reservation> listReversationsByHotel(@PathVariable(name="id") int hotelID) {
    	return reservationDAO.findByHotel(hotelID);
    }
    
    /**
     * Add a Reservation to a Hotel
     * @param reservation
     * @param hotelID
     * @return
     */
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable(name="id") int hotelID) {
    	return reservationDAO.create(reservation, hotelID);
    }
    


}
