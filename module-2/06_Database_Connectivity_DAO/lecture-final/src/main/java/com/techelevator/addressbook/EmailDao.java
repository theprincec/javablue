package com.techelevator.addressbook;

import java.util.List;

public interface EmailDao {

	Email get(int emailId);
	List<Email> getForContact(int contactId);
	void save(Email email);
	void update(Email email);
	void delete(int emailId);
	void deleteForContact(int contactId);
}
