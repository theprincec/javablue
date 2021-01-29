package com.techelevator.review.abstrract;

import java.math.BigDecimal;

public class RegularTicketAbstractExample extends TicketAbstractExample {

	public RegularTicketAbstractExample(double price) {
		super(price, "Regular Ticket");
	}

	@Override
	public BigDecimal getFee() {
		return getPrice().multiply( new BigDecimal(.20) );
	}

}
