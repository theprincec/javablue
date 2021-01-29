package com.techelevator.review.abstrract;

import java.math.BigDecimal;

public class WillCallTicketAbstractExample extends TicketAbstractExample {
	
	private String ticketHolderName;
	
	public WillCallTicketAbstractExample(double price, String ticketHolderName) {
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
