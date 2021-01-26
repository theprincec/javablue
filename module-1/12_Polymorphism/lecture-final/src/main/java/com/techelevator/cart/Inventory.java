package com.techelevator.cart;

public interface Inventory {

	double getPrice();
	String getName();
	double calculateShipping( int distance );
}
