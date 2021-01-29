package com.techelevator.review.interfaces.tickets;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RegularTicketWithInterface implements TicketInterface {

	private BigDecimal price;

	public RegularTicketWithInterface(double price) {
		this.price = new BigDecimal(price);
	}
	
	@Override
	public BigDecimal getPrice() {
		return this.price;
	}

	@Override
	public String getType() {
		return "Regular Ticket";
	}

	@Override
	public BigDecimal getFee() {
		return price.multiply( new BigDecimal(.20) );
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
