package com.techelevator.addressbook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAddressDao implements AddressDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcAddressDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Address get(int addressId) {
		Address address = null;
		
		String sql = "SELECT address_id, line_1, line_2, city, district, postal_code, country_code, type " + 
				"FROM address WHERE address_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, addressId);
		
		if (rows.next()) {
			address = mapRowToAddress(rows);
		}
		
		return address;
	}
	
	@Override
	public List<Address> getForContact(int contactId) {
		
		List<Address> addresses = new ArrayList<Address>();
		
		String sql = "SELECT address.address_id, line_1, line_2, city, district, postal_code, country_code, type " + 
				"FROM address " + 
				"JOIN contact_address ON address.address_id = contact_address.address_id " + 
				"WHERE contact_address.contact_id = ?";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, contactId);
		
		while (rows.next()) {
			addresses.add( mapRowToAddress(rows) );
		}
		
		return addresses;
	}

	@Override
	public void save(Address address, int contactId) {
		String sql = "INSERT INTO address (address_id, line_1, line_2, city, district, postal_code, country_code, type) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
		Integer addressId = jdbcTemplate.queryForObject(sql, Integer.class, address.getLineOne(), address.getLineTwo(), address.getCity(),
				address.getDistrict(), address.getPostalCode(), address.getCountryCode(), address.getType() );
		address.setAddressId(addressId);

		saveContactAddress(addressId, contactId);
	}
	
	@Override
	public void update(Address address) {
		String sql = "UPDATE address SET line_1 = ?, line_2 = ?, city = ?, district = ?, postal_code = ?, country_code = ?, type = ? WHERE address_id = ?";
		jdbcTemplate.update(sql, address.getLineOne(), address.getLineTwo(), address.getCity(), address.getDistrict(), 
								address.getPostalCode(), address.getCountryCode(), address.getAddressId() );
	}

	@Override
	public void delete(int addressId) {
		String sql = "DELETE FROM address WHERE address_id = ?";
		jdbcTemplate.update(sql, addressId);
		
	}
	
	@Override
	public void deleteForContact(int contactId) {
		String sql = "DELETE FROM address WHERE address_id IN (SELECT address_id FROM contact_address WHERE contact_id = ?)";
		jdbcTemplate.update(sql, contactId);
	}
	
	private void saveContactAddress(int addressId, int contactId) {
		String sql = "INSERT INTO contact_address (contact_id, address_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, contactId, addressId);
	}
	
	private Address mapRowToAddress(SqlRowSet row) {
		Address address = new Address();
		address.setAddressId( row.getInt("address_id") );
		address.setLineOne( row.getString("line_1") );
		address.setLineTwo( row.getString("line_2") );
		address.setCity( row.getString("city") );
		address.setDistrict( row.getString("district") );
		address.setPostalCode( row.getString("postal_code") );
		address.setCountryCode( row.getString("country_code") );
		address.setType( row.getString("type") );
		return address;
	}
}
