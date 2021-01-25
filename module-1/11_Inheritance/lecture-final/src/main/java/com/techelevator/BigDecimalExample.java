package com.techelevator;

import java.math.BigDecimal;

public class BigDecimalExample {

	public static void main(String[] args) {
	
		
		BigDecimal amount = new BigDecimal(100);
		BigDecimal zeroAmount = BigDecimal.ZERO;
		
		BigDecimal newAmount = amount.add(new BigDecimal(50));
		amount = amount.add(new BigDecimal(50));
	}

}
