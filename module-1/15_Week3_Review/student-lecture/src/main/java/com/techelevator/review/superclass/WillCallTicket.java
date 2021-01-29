package com.techelevator.review.superclass;

import java.math.BigDecimal;

public class WillCallTicket extends Ticket {
	
	private String ticketHolderName;
	
	public WillCallTicket(double price, String ticketHolderName) {
		super(price, "Will Call Ticket");
		this.ticketHolderName = ticketHolderName;
	}
	
	public String getTicketHolderName() {
		return this.ticketHolderName;
	}
	
	@Override
	public BigDecimal getFee() {
		return getPrice().multiply( new BigDecimal(.10) );
	}
}
