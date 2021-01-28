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
	
	
//	public int getBalance() {
//		return getBalance();
//	}
	
	
	@Override
	public int withdraw(int amountToWithdraw) {
//		if ((getBalance()-amountToWithdraw)>=0) {
//			if (getBalance()<150) {
//				super.withdraw(amountToWithdraw + 2);
//			}
//			//super.withdraw(amountToWithdraw);
//			
//			return getBalance();
//				
//		} else {
//			return getBalance();
//		}
		
		
		
        if(this.getBalance() - amountToWithdraw  > 0) {
            if(this.getBalance() - amountToWithdraw < 150){
            return super.withdraw(amountToWithdraw + 2);
            }
         } if (this.getBalance() >= 150){
        	 return super.withdraw(amountToWithdraw);
        	 //return this.getBalance();
         } 
         return this.getBalance();

        	 
		
		
//	    @Override 
//	    public int withdraw(int amountToWithdraw){
//	        int newBalance = this.getBalance();
//	        int serviceCharge = 2;
//	        
//	        if(this.getBalance() - amountToWithdraw < 0  ) {
//	            newBalance = this.getBalance();
//	        }
//	         
//	        if(this.getBalance() - amountToWithdraw < 150 && this.getBalance() - amountToWithdraw > 0) {
//	            newBalance = super.withdraw(amountToWithdraw + serviceCharge);
//	        }
//	        
//	        if(this.getBalance() >= 150) {
//	            newBalance = super.withdraw(amountToWithdraw);
//	        }
//	        return newBalance;
	        
	    //}
		
		
    }
	
	
	
	
	
//	if ((getBalance()-amountToWithdraw)>-100) {
//		
//		super.withdraw(amountToWithdraw );
//		
//		if (getBalance()<0) {
//			super.withdraw(10);
//		}
//		return getBalance();
//	} else {
//		return getBalance();
//	}
	

}
