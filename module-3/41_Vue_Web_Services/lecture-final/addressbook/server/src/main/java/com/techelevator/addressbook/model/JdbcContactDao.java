package com.techelevator.addressbook.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcContactDao implements ContactDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcContactDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Contact> list() {
		String sql = "SELECT contact_id, first_name, last_name FROM contact";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		List<Contact> contacts = new ArrayList<Contact>();
		while (rows.next()) {
			contacts.add( mapRowToContact(rows) );
		}
		
		return contacts;
	}

	@Override
	public Contact get(int contactId) {
		String sql = "SELECT contact_id, first_name, last_name FROM contact " + 
				"WHERE contact_id = ?";
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contactId);
		
		if ( rows.next() ) {
			return mapRowToContact(rows);
		}
		
		return null;
	}

	@Override
	public void save(Contact contact) {
		// Get the next Sequence Id
		// Set the contact object Id with that sequence #
		// use the sequence number as the contactId in the insert
		String sql = "INSERT INTO contact (contact_id, first_name, last_name) VALUES (DEFAULT, ?, ?) RETURNING contact_id";
		
		// Because we are using RETURNING must use queryForRowSet(), WITHOUT RETURNING would use update()
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contact.getFirstName(), contact.getLastName());
		if ( rows.next() ) {
			contact.setContactId( rows.getInt("contact_id") );
		}
		
	}

	@Override
	public void update(Contact contact) {
		String sql = "UPDATE contact SET first_name = ?, last_name = ? WHERE contact_id = ?";
		jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getContactId());
		
	}

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id = ?";
		jdbcTemplate.update(sql, contactId);
		
	}
	
	private Contact mapRowToContact(SqlRowSet row) {
		Contact contact = new Contact();
		contact.setContactId( row.getInt("contact_id") );
		contact.setFirstName( row.getString("first_name") );
		contact.setLastName( row.getString("last_name") );
		return contact;
	}

}
