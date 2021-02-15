package com.techelevator.addressbook;

import java.util.List;

public interface AddressDao {

	Address get(int addressId);
	List<Address> getForContact(int contactId);
	void save(Address address, int contactId);
	void update(Address address);
	void delete(int addressId);
	void deleteForContact(int contactId);
}
