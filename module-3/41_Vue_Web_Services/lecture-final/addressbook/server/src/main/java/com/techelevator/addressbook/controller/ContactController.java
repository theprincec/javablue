package com.techelevator.addressbook.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.addressbook.model.Contact;
import com.techelevator.addressbook.model.ContactDao;

@CrossOrigin
@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	private ContactDao contactDao;
	
	public ContactController(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Contact> list() {
		return contactDao.list();
	}
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public Contact add(@RequestBody Contact contact) {
		contactDao.save(contact);
		return contact;
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public void update(@RequestBody Contact contact) {
		contactDao.update(contact);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		contactDao.delete(id);
	}
}
