package com.techelevator.addressbook;

public class Email {

	private int emailId;
	private int contactId;
	private String emailAddress;
	private String type;
	private String description;
	
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Email [emailId=" + emailId + ", contactId=" + contactId + ", emailAddress=" + emailAddress + ", type="
				+ type + ", description=" + description + "]";
	}
	
}
