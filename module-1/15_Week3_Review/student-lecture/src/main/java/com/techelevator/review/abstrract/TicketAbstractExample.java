package com.techelevator.review.abstrract;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class TicketAbstractExample {
	
	private BigDecimal price;
	private String type;
	
	public TicketAbstractExample(double price, String ticketType) {
		this.price = new BigDecimal(price);
		this.type = ticketType;
	}
	
	public abstract BigDecimal getFee();
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getType() {
		return this.type;
	}
	
	public BigDecimal getTotalPrice() {
		return calculateTotalPrice( 0 );
	}

	public BigDecimal getTotalPrice(double discount) {
		return calculateTotalPrice( discount );
	}
	
	private BigDecimal calculateTotalPrice(double discount) {
		BigDecimal totalCost = price.add( getFee() );
		totalCost = totalCost.add(totalCost.multiply( new BigDecimal(discount)));
		totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);
		return totalCost;
	}

}
