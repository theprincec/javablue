package com.techelevator;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	
	private double annualSalary;
	
	
	public int getEmployeeId() {
		return this.employeeId;
		
	}
	public String getFirstName() {
		return this.firstName;
		
	}
	public String getLastName() {
		return this.lastName;
		
	}
	public String getDepartment() {
		return this.department;
		
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId =employeeId  ;
		
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
		
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
		
	}
	public void setDepartment(String department) {
		this.department=department;
		
	}
	
	public String getFullName() {
		return firstName + lastName;
	}
	
	
	
	public void Airplane(int employeeId, String firstName, String lastName, double annualSalary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = firstName;
		this.annualSalary = annualSalary;
		
	}
	
	
	public void raiseSalary(double percent) {
		this.annualSalary= this.annualSalary*(1+percent) ;
	}
	
	
	
	

}
