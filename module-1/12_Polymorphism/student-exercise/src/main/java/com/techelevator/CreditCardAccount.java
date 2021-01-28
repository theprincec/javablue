package com.techelevator;

public class CreditCardAccount implements Accountable{
	
	private String accountHolder;
	private String accountNumber;
	private int debt;
	
	
	
	public String getAccountHolder() {
		return accountHolder;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getDebt() {
		return -(debt);
	}
	
	

	public CreditCardAccount(String accountHolder, String accountNumber) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		debt = 0;
	}
	
	

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return debt;
	}
	
	
	public int pay(int amountToPay) {
		debt = debt + amountToPay;
		return -(debt);
	}
	
	public int charge(int amountToCharge) {
		debt = debt - amountToCharge;
		return -(debt);
	}
	
	

//	pay(int amountToPay)	int	Removes amountToPay from the amount owed 
//							and returns the new total amount owed.
//	charge(int amountToCharge)	int	Adds amountToCharge to the amount owed, 
//								and returns the new total amount owed.
	
	
	
	

}
