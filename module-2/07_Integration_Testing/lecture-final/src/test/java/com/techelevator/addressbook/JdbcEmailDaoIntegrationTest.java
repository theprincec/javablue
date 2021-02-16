package com.techelevator.addressbook;

import java.sql.SQLException;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmailDaoIntegrationTest {
	
	private int contactId;
	
	private static SingleConnectionDataSource dataSource;  
	private EmailDao emailDao;
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
	
	/*
	 * Email has a Foreign Relationship on a contact id
	 * 1. Insert a contact and store the id, then in the tests we will use that contact for the foreign key
	 */
	@Before
	public void setup() {
		emailDao = new JdbcEmailDao(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "INSERT INTO contact (contact_id, first_name, last_name) VALUES (DEFAULT, 'TestFirst', 'TestLast') RETURNING contact_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		result.next();
		this.contactId = result.getInt("contact_id");
	}
	
	@Test
	public void insert_email() {
		// Arrange - create an email object and store it
		Email email = new Email();
		email.setContactId(this.contactId);
		email.setEmailAddress("test@test.com");
		email.setType("WORK");
		email.setDescription(null);
		
		// Act - call the save()
		emailDao.save(email);
		
		// Assert - verify the id created, select the email from the database and verify the returned email is the one we stored
		Assert.assertTrue( email.getEmailId() > 0 );
		
		Email emailFromDatabase = emailDao.get( email.getEmailId() );
		assertEmailsEqual(email, emailFromDatabase);
	}
	
	private void assertEmailsEqual(Email expected, Email actual) {
		Assert.assertEquals(expected.getEmailId(), actual.getEmailId());
		Assert.assertEquals(expected.getContactId(), actual.getContactId());
		Assert.assertEquals(expected.getEmailAddress(), actual.getEmailAddress());
		Assert.assertEquals(expected.getType(), actual.getType());
		Assert.assertEquals(expected.getDescription(), actual.getDescription());
	}
	
}
