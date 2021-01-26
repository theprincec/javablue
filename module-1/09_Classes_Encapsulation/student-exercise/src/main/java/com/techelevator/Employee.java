package com.techelevator;

public class Employee {
	
	//variables
	private int employeeId;
	private String firstName;
	private String lastName;
	//private String fullName;
	private String department;
	private double annualSalary;
	

	//constructors
	public void Employee(int employeeId, String firstName, String lastName, double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = salary;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//getters
//	public int getEmployeeId() {
//		return this.employeeId;
//		
//	}
//	public String getFirstName() {
//		return this.firstName;
//		
//	}
//	public String getLastName() {
//		return this.lastName;
//		
//	}
//	public String getDepartment() {
//		return this.department;
//		
//	}
//	
//	public double getAnnualSalary() {
//		return annualSalary;
//		
//	}
	
	
	//setters
//	public void setEmployeeId(int employeeId) {
//		this.employeeId =employeeId  ;
//		
//	}
//	public void setFirstName(String firstName) {
//		this.firstName=firstName;
//		
//	}
//	public void setLastName(String lastName) {
//		this.lastName=lastName;
//		
//	}
//	public void setDepartment(String department) {
//		this.department=department;
//		
//	}
	
	public int getEmployeeId() {
		return employeeId;
	}












	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}












	public String getFirstName() {
		return firstName;
	}












	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}












	public String getLastName() {
		return lastName;
	}












	public void setLastName(String lastName) {
		this.lastName = lastName;
	}












	public String getDepartment() {
		return department;
	}












	public void setDepartment(String department) {
		this.department = department;
	}












	public double getAnnualSalary() {
		return annualSalary;
	}












	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}












	//derived variables
	public String getFullName() {
		return this.lastName + ", " + this.firstName;
	}
	
	

	
	//methods
	public void raiseSalary(double percent) {
		//double percentAdjustment = percent/100;
		this.annualSalary += (this.annualSalary/100) * percent;
		
	}
	
	
	
	

}
