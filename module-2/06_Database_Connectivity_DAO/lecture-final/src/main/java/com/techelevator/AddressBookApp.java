package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.addressbook.Contact;
import com.techelevator.addressbook.ContactDao;
import com.techelevator.addressbook.JdbcContactDao;

public class AddressBookApp {

	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		ContactDao contactDao = new JdbcContactDao(dataSource);
		
		List<Contact> contacts = contactDao.list();
		
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
		Contact contactWithIdThree = contactDao.get(3);
		
		System.out.println(contactWithIdThree);
		
		Contact newContact = new Contact();
		newContact.setFirstName("Jane");
		newContact.setLastName("Doe");
		
		contactDao.save( newContact );
		
		System.out.println( newContact );
		
		newContact.setFirstName("Updated");
		
		contactDao.update(newContact);
		
		System.out.println( contactDao.get( newContact.getContactId() ));
		
		contactDao.delete( newContact.getContactId() );
		
		System.out.println( contactDao.get( newContact.getContactId() ));
		
	}

}
