package com.techelevator.addressbook;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAddressIntegrationTest {

	private int contactId;
	
	private static SingleConnectionDataSource dataSource;  
	private AddressDao addressDao;
	private JdbcTemplate jdbcTemplate;
	

	@BeforeClass
	public static void createDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);  
	}
	
	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}
	
	@After
	public void rollbackTransation() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	// Insert a contact to use as our foreign key
	@Before
	public void setup() {
		addressDao = new JdbcAddressDao(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "INSERT INTO contact (contact_id, first_name, last_name) VALUES (DEFAULT, 'TestFirst', 'TestLast') RETURNING contact_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		result.next();
		contactId = result.getInt("contact_id");
	}
	
	/*
	 * Testing a method that uses a Many-to-Many relationship
	 * 
	 * 1. Create an address and insert it
	 * 2. Create a contact_address table row using the address it and contact id  (join table)
	 * 3. Select the address using the method and the contact id
	 * 4. Assert it is the address that was inserted
	 */
	@Test
	public void get_address_by_contact() {
		/*
		 * ARRANGE
		 */
		// Create the Address
		Address address = new Address();
		address.setLineOne("TestLineOne");
		address.setCity("TestCity");
		address.setDistrict("TestDistrict");
		address.setPostalCode("55555");
		address.setCountryCode("XYZ");
		address.setType("HOME");
		
		String sql = "INSERT INTO address (address_id, line_1, line_2, city, district, postal_code, country_code, type) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?) RETURNING address_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, address.getLineOne(), address.getLineTwo(), address.getCity(), address.getDistrict(), address.getPostalCode(), address.getCountryCode(), address.getType());
		result.next();
		address.setAddressId( result.getInt("address_id"));
		
		// Create the Contact_Address table row
		String insertContactAddressSql = "INSERT INTO contact_address (contact_id, address_id) VALUES (?, ?)";
		jdbcTemplate.update(insertContactAddressSql, this.contactId, address.getAddressId());
		
		/*
		 * ACT
		 */
		List<Address> returnedAddresses = addressDao.getForContact(this.contactId);
		
		/*
		 * ASSERT
		 */
		Assert.assertEquals(1, returnedAddresses.size());
		Assert.assertEquals(address, returnedAddresses.get(0) );
	}
	
}
