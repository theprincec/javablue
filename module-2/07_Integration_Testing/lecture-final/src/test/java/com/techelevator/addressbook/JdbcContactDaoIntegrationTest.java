package com.techelevator.addressbook;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcContactDaoIntegrationTest {

	/*
	 * STEP 1: define member variables for the connection, DAO, and JdbcTemplate (optional)
	 */
	private static SingleConnectionDataSource dataSource;  // must be static
	private ContactDao contactDao;
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * STEP 2: Define a @BeforeClass that setups the datasource
	 */
	@BeforeClass
	public static void createDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/addressbook");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);  // set autoCommit = false to create Transaction scope
	}
	
	/*
	 * STEP 3: Define @AfterClass and destroy the datasource
	 */
	@AfterClass
	public static void destroyDataSource() {
		dataSource.destroy();
	}
	
	/*
	 * STEP 4: Define @After to rollback the current transaction
	 */
	@After
	public void rollbackTransation() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	/*
	 * STEP 5: Define @Before to instantiate the DAO being tested and the JdbcTemplate, and to setup 
	 * 		   any reusable data (if needed).  This will be unique for every integration test class.
	 */
	@Before
	public void setup() {
		contactDao = new JdbcContactDao(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/*
	 * STEP 6: Write the tests
	 */
	
	/*
	 * TESTING SELECT (READ)
	 * 
	 * 1. Create and store and then insert dummy data 
	 * 2. Select the dummy data
	 * 3. Assert that the data returned by the select is the same as what we inserted
	 */
	@Test
	public void testing_select_with_single_result() {
		/*
		 * ARRANGE
		 */
		// Create the Dummy data and store it
		Contact createdTestContact = getTestContact();
		// Insert it into the table and get the id
		String sql = "INSERT INTO contact (contact_id, first_name, last_name) VALUES (DEFAULT, ?, ?) RETURNING contact_id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, createdTestContact.getFirstName(), createdTestContact.getLastName());
		result.next();
		createdTestContact.setContactId( result.getInt("contact_id") );
		
		/*
		 * ACT
		 */
		Contact contactFromDatabase = contactDao.get( createdTestContact.getContactId() );
		
		/*
		 * ASSERT
		 */
		Assert.assertNotNull( contactFromDatabase );
		Assert.assertEquals(createdTestContact, contactFromDatabase);
	}
	
	@Test
	public void testing_select_with_multiple_results_with_pre_count() {
		/*
		 * ARRANGE
		 */
		// Get the original count of the number of rows on the table
		List<Contact> originalList = contactDao.list();
		int originalCount = originalList.size();
		// Insert some rows either using the DAO or JdbcTemplate
		contactDao.save( getTestContact() );
		contactDao.save( getTestContact() );
		
		/*
		 * ACT
		 */
		List<Contact> listAfterInserts = contactDao.list();
		
		/*
		 * ASSERT 
		 */
		// Assert that the new row count is larger than the original by the  number we inserted
		Assert.assertEquals(originalCount + 2, listAfterInserts.size());
	}
	
	@Test
	public void testing_select_with_multiple_results_with_truncation() {
		/*
		 * ARRANGE
		 */
		// Truncate (delete) ALL data from the table
		truncateContactTable();
		// Insert some rows either using the DAO or the JdbcTemplate
		contactDao.save( getTestContact() );
		contactDao.save( getTestContact() );
		
		/*
		 * ACT
		 */
		List<Contact> listAfterInserts = contactDao.list();
		
		/*
		 * ASSERT
		 */
		// Assert that the number of rows we inserted is what is returned
		Assert.assertEquals(2, listAfterInserts.size());
	}
	

	/*
	 * TESTING INSERT (CREATE)
	 * 
	 * 1. Create and store data in a variable of the data type needed for the insert
	 * 2. insert the dummy data
	 * 3. Select the inserted data
	 * 4. Assert that the selected data is the same as what we inserted
	 */
	@Test
	public void testing_insert() {
		/*
		 * ARRANGE
		 */
		// Create and store dummy data
		Contact createdTestContact = getTestContact();
		
		/*
		 * ACT
		 */
		contactDao.save(createdTestContact);
		
		/*
		 * ASSERT
		 */
		// Assert that the generated id was created and set
		Assert.assertTrue( createdTestContact.getContactId() > 0 );
		// Use SELECT to get the inserted row from the database - can use either an existing DAO method OR JdbcTemplate
		Contact contactFromDatabase = contactDao.get( createdTestContact.getContactId() );
		// Assert the contact retrieved from the database is equal to the one we inserted
		Assert.assertEquals(createdTestContact, contactFromDatabase);
	}
	
	/*
	 * TESTING UPDATE 
	 * 
	 * 1. Insert dummy data into the table
	 * 2. Update the data using the DAO and store what we changed
	 * 3. Select the updated record from the table
	 * 4. Assert that the record has the changes from the update
	 */
	@Test
	public void testing_update() {
		/*
		 * ARRANGE
		 */
		// Create dummy data
		Contact createdTestContact = getTestContact();
		//Insert Dummy data into the table
		contactDao.save(createdTestContact);
		//Make change to that data and store
		createdTestContact.setFirstName("UpdatedFirstName");
		createdTestContact.setLastName("UpdatedLastName");
		
		/*
		 * ACT
		 */
		contactDao.update(createdTestContact);
		
		/*
		 * ASSERT
		 */
		// retrieve the record from the table using the id
		Contact updatedContactFromDatabase = contactDao.get(  createdTestContact.getContactId() );
		// Assert that the it is equal to the updated data
		Assert.assertEquals(createdTestContact, updatedContactFromDatabase);
	}
	
	/*
	 * TESTING DELETE
	 * 
	 * 1. Insert dummy data into the table
	 * 2. Delete it
	 * 3. Try to select it and verify it doesn't exist
	 */
	@Test
	public void testing_delete() {
		/*
		 * ARRANGE
		 */
		// Create dummy data
		Contact createdTestContact = getTestContact();
		// Insert Dummy data into the table - can use DAO or JdbcTemplate
		contactDao.save(createdTestContact);
		
		/*
		 * ACT
		 */
		contactDao.delete( createdTestContact.getContactId() );
		
		/* 
		 * ASSERT
		 */
		// Try to the Select the row from the table and verify no data returned
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM contact WHERE contact_id = ?", createdTestContact.getContactId() );
		Assert.assertFalse( results.next() );
	}
	
	private void truncateContactTable() {
		String sql = "TRUNCATE contact CASCADE";
		jdbcTemplate.update(sql);
	}
	
	private Contact getTestContact() {
		Contact createdTestContact = new Contact();
		createdTestContact.setFirstName("TestFirst");
		createdTestContact.setLastName("TestLast");
		return createdTestContact;
	}
	
}
