package com.techelevator.addressbook;

import java.util.List;

public interface ContactDao {

	List<Contact> list();
	Contact get(int contactId);
	void save(Contact contact);
	void update(Contact contact);
	void delete(int contactId);
	
}
