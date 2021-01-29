package com.techelevator;

import java.util.ArrayList;
import java.util.List;

//import com.techelevator.cart.Inventory;

public class BankCustomer {
	private String name;
	private String address;
	private String phoneNumber;
	private List<Accountable> accounts = new ArrayList<Accountable>();
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Accountable> getAccounts() {
		return accounts;
	}
	
	public int getDebt() {
		return getDebt();
	}
			
	
	
	
	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount);
	}
	
	
	
	//
	public boolean isVip() {
		for (Accountable account : accounts) {
			if (account.getBalance() > 24999) { 
				return true;
			}
		}
		return false;
	}
	
	//doesnt account for debt
	//if (account.getBalance() + account.getDebt() > 24999)
	
	
	
	
	
//	name	String	X	X	Returns the account holder name that the account belongs to.
//	address	String	X	X	Returns the address of the customer.
//	phoneNumber	String	X	X	Returns the phone number of the customer.
//	accounts	List<Accountable>	X		Returns the customer's list of Accountables as an array.
	
	

}
