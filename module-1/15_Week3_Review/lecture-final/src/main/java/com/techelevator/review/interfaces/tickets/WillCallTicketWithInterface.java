package com.techelevator.review.interfaces.tickets;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WillCallTicketWithInterface implements TicketInterface {

	private String ticketHolderName;
	private BigDecimal price;
	
	public WillCallTicketWithInterface(double price, String ticketHolderName) {
		this.price = new BigDecimal(price);
		this.ticketHolderName = ticketHolderName;
	}
	
	public String getTicketHolderName() {
		return this.ticketHolderName;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String getType() {
		return "Will Call Ticket";
	}

	@Override
	public BigDecimal getFee() {
		return price.multiply( new BigDecimal(.10) );
	}

	@Override
	public BigDecimal getTotalPrice() {
		return calculateTotalPrice(0);
	}

	@Override
	public BigDecimal getTotalPrice(double discount) {
		return calculateTotalPrice(discount);
	}
	
	private BigDecimal calculateTotalPrice(double discount) {
		BigDecimal totalCost = price.add( getFee() );
		totalCost = totalCost.add(totalCost.multiply( new BigDecimal(discount)));
		totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);
		return totalCost;
	}

}
