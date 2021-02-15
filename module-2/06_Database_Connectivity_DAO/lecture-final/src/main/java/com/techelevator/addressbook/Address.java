package com.techelevator.addressbook;

public class Address {

	private int addressId;
	private String lineOne;
	private String lineTwo;
	private String city;
	private String district;
	private String postalCode;
	private String countryCode;
	private String type;
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getLineOne() {
		return lineOne;
	}
	
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	
	public String getLineTwo() {
		return lineTwo;
	}
	
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", lineOne=" + lineOne + ", lineTwo=" + lineTwo + ", city=" + city
				+ ", district=" + district + ", postalCode=" + postalCode + ", countryCode=" + countryCode + ", type="
				+ type + "]";
	}
	
	
}
