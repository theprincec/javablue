package com.techelevator;

public class SavingsAccount extends BankAccount {
	
	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
		// TODO Auto-generated constructor stub
	}
	
	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
		// TODO Auto-generated constructor stub
	}
	
	
	public int getBalance() {
		return getBalance();
	}
	
	
	@Override
	public int withdraw(int amountToWithdraw) {
		if ((getBalance()-amountToWithdraw)>=0) {
			int newBalance = getBalance();
			if (newBalance<150) {
				newBalance-=2;
			}
			newBalance -= amountToWithdraw;
			return newBalance;
				
		} else {
			return getBalance();
		}
		
	}
	
	

}
