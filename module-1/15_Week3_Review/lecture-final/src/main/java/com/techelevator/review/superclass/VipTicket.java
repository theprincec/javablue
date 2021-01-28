package com.techelevator.review.superclass;

import java.math.BigDecimal;

public class VipTicket extends Ticket {

	private BigDecimal upCharge;
	
	public VipTicket(double price, double upCharge) {
		super(price, "VIP Ticket");
		this.upCharge = new BigDecimal(upCharge);
	}
	
	@Override
	public BigDecimal getFee() {
		return super.getFee().add( upCharge );
	}
	
}
