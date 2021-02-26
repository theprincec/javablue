package com.techelevator.demo;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techelevator.hotels.models.Hotel;

public class LoginExample {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/";
		
		/*
		 * LOGIN
		 */
		
		// First Login and get the token
		
		// Step 1: Build the object for the message body
		LoginDetail login = new LoginDetail();
		login.setUsername("user");
		login.setPassword("password");
		
		// Step 2: Build the Header and request entity
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LoginDetail> loginRequest = new HttpEntity<LoginDetail>(login, headers); 
		
		// Step 3: do a POST request and get the response using exchange()
		// exchange( url, HttpMethod, HttpEntity, data type to return )
		ResponseEntity<Map> responseEntity = restTemplate.exchange(url  +"login", HttpMethod.POST, loginRequest, Map.class);
		
		// Step 4: call getBody() on the Request Entity to get the deserialized object from the request
		Map responseValues = responseEntity.getBody();
		
		// Step 5: Store the token for later use
		String token = (String) responseValues.get("token");
		
		System.out.println(token);
		
		/*
		 * USING THE TOKEN FOR A GET REQUEST
		 */
		
		// Step 1: Create a header for the Bearer Token (JWT)
		HttpHeaders getRequestHeader = new HttpHeaders();
		getRequestHeader.setBearerAuth(token);
		
		// Create an entity without a body type for the headers
		HttpEntity getRequestEntity = new HttpEntity(getRequestHeader);
		
		// Step 2: Use exchange() to send the GET request since we need the headers
		Hotel hotel = restTemplate.exchange(url + "hotels/1", HttpMethod.GET, getRequestEntity, Hotel.class).getBody();
	
		System.out.println(hotel);
	}

}
