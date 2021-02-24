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

import java.util.List;

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


    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */


}
