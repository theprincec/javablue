package com.techelevator.cities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="City not found")
public class CityNotFoundException extends Exception {

	private static final long serialVersionUID = -7366616662755394633L;

	public CityNotFoundException() {
		super("City not found");
	}
}
