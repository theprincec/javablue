package com.techelevator.log;

import java.time.LocalDate;

public class Log {

	private long id;
	private String action;
	private double beginningBalance;
	private double endingBalance;
	private LocalDate entryDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public double getBeginningBalance() {
		return beginningBalance;
	}
	public void setBeginningBalance(double beginningBalance) {
		this.beginningBalance = beginningBalance;
	}
	public double getEndingBalance() {
		return endingBalance;
	}
	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	
	
	
}
