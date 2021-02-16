package com.techelevator.addressbook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmailDao implements EmailDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcEmailDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Email get(int emailId) {
		
		Email email = null;
		String sql = "SELECT email_id, contact_id, email_address, type, description FROM email WHERE email_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, emailId);
		
		if (rows.next()) {
			email = mapRowToEmail(rows);
		}
		
		return email;
	}

	@Override
	public List<Email> getForContact(int contactId) {
		List<Email> emails = new ArrayList<Email>();
		String sql = "SELECT email_id, contact_id, email_address, type, description FROM email WHERE contact_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contactId);
		
		if (rows.next()) {
			emails.add( mapRowToEmail(rows) );
		}
		
		return emails;
	}

	@Override
	public void save(Email email) {
		String sql = "INSERT INTO email (email_id, contact_id, email_address, type, description) VALUES (DEFAULT, ?, ?, ?, ?)";
		Integer emailId = jdbcTemplate.queryForObject(sql, Integer.class, email.getContactId(), email.getEmailAddress(), email.getType(), email.getDescription());
		email.setEmailId(emailId);
	}

	@Override
	public void update(Email email) {
		String sql = "UPDATE email SET email_address = ?, type = ?, description = ? WHERE email_id = ?";
		jdbcTemplate.update(sql, email.getEmailAddress(), email.getType(), email.getDescription(), email.getEmailId());
	}

	@Override
	public void delete(int emailId) {
		String sql = "DELETE FROM email WHERE email_id = ?";
		jdbcTemplate.update(sql, emailId);
	}

	@Override
	public void deleteForContact(int contactId) {
		String sql = "DELETE FROM email WHERE contact_id = ?";
		jdbcTemplate.update(sql, contactId);
	}
	
	private Email mapRowToEmail(SqlRowSet row) {
		Email email = new Email();
		email.setEmailId( row.getInt("email_id") );
		email.setContactId( row.getInt("contact_id") );
		email.setEmailAddress( row.getString("email_address") );
		email.setType( row.getString("type") );
		email.setDescription( row.getString("description") );
		return email;
	}
	
}
