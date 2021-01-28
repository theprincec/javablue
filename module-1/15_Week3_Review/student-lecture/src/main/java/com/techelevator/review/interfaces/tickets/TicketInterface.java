package com.techelevator.review.interfaces.tickets;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface TicketInterface {
	
	BigDecimal getPrice();
	String getType();
	BigDecimal getFee();
	BigDecimal getTotalPrice();
	BigDecimal getTotalPrice(double discount);
	

}
