package com.techelevator.review.interfaces.tickets;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VipTicketWithInterface implements TicketInterface {

	private BigDecimal upCharge;
	private BigDecimal price;

	public VipTicketWithInterface(double price, double upCharge) {
		this.price = new BigDecimal(price);
		this.upCharge = new BigDecimal(upCharge);
	}
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String getType() {
		return "VIP Ticket";
	}

	@Override
	public BigDecimal getFee() {
		return price.multiply( new BigDecimal(.20) ).add(upCharge);
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
