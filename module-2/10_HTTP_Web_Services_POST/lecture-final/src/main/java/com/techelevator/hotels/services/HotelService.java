package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String BASE_URL;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {
    BASE_URL = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
	  Reservation reservation = makeReservation(newReservation); // This line has nothing to do with an API
	  
	  /*
	   * POST
	   */
	  
	  String url = BASE_URL + "hotels/" + reservation.getHotelID() + "/reservations";
	  
	  // STEP 1: Instantiate a HttpHeaders and set the Content Type to application/json
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	 
	  // STEP 2: Instantiate a HttpEntity object, which will represent the request and
	  //         on it will set the headers and the object to serialize to JSON.
	  //         <T> - defines the data type the HttpEntity will serialize to JSON
	  HttpEntity<Reservation> entity = new HttpEntity<Reservation>(reservation, headers);
	  
	  try {
		  reservation = restTemplate.postForObject(url, entity, Reservation.class);
	  } catch (RestClientResponseException e) {
		  console.printError(e.getRawStatusCode() + " " + e.getStatusText());
	  } catch (ResourceAccessException e) {
		  console.printError(e.getMessage());
	  }
	  
	  return reservation;
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param CSV
   * @return
   */
  public Reservation updateReservation(String CSV) {
	  Reservation reservation = makeReservation(CSV); // This line has nothing to do with an API
	  
	  /*
	   * PUT
	   */
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);

	  HttpEntity<Reservation> entity = new HttpEntity<Reservation>(reservation, headers);
	  
	  try {
		  // use the put() method
		  restTemplate.put(BASE_URL + "reservations/" + reservation.getId(), entity);
	  } catch (RestClientResponseException e) {
		  console.printError(e.getRawStatusCode() + " " + e.getStatusText());
	  } catch (ResourceAccessException e) {
		  console.printError(e.getMessage());
	  }
	  
	  return reservation;
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
	  /*
	   * DELETE
	   */
	  try {
		  // uses the delete() method on restTemplate
		  restTemplate.delete(BASE_URL + "reservations/" + id);
	  } catch (RestClientResponseException e) {
		  console.printError(e.getRawStatusCode() + " " + e.getStatusText());
	  } catch (ResourceAccessException e) {
		  console.printError(e.getMessage());
	  }
    
  }



  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    try {
    	hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException e) {
    	/*
    	 * RestClientResponseException is the parent class of the exceptions thrown
    	 * when a 400 or 500 HTTP Response code is returned.  
    	 * 
    	 * rawStatusCode contains the HTTP Response Code number (404)
    	 * statusText contains the description of the code (Not Found)
    	 */
    	console.printError(e.getRawStatusCode() + " " + e.getStatusText());
    } catch (ResourceAccessException e) {
    	/*
    	 * ResourceAccessException occurs when a server can not be connected to due to 
    	 * either the server not running, not existing, or a network/internet problem
    	 */
    	console.printError(e.getMessage());
    }
    return hotels;
  }

  /* DON'T MODIFY ANY METHODS BELOW */
  
  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  
  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  private Reservation makeReservation(String CSV) {
    String[] parsed = CSV.split(",");

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) {
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
