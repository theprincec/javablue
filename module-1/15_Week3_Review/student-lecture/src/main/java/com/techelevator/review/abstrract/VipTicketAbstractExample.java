package com.techelevator.review.abstrract;

import java.math.BigDecimal;

public class VipTicketAbstractExample extends TicketAbstractExample {

	private BigDecimal upCharge;
	
	public VipTicketAbstractExample(double price, double upCharge) {
		super(price, "VIP Ticket");
		this.upCharge = new BigDecimal(upCharge);
	}
	
	@Override
	public BigDecimal getFee() {
		return getPrice().multiply(new BigDecimal(.20)).add( upCharge );
	}
	
}
