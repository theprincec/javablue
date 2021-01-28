package com.techelevator;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	@Override
	public int withdraw(int amountToWithdraw) {
		// TODO Auto-generated method stub
		//return getBalance();
		//if (getBalance()>-100) {
		
		
			if ((getBalance()-amountToWithdraw)>-100) {
				//int newBalance = getBalance();
				super.withdraw(amountToWithdraw );
				//return newBalance ;
				if (getBalance()<0) {
					super.withdraw(10);
				}
				return getBalance();
			} else {
				return getBalance();
			}
//
//		} else return
		
//		return super.withdraw(amountToWithdraw);
	}
	
//	public CheckingAccount() {
//		super()
//	}
	
	

}
