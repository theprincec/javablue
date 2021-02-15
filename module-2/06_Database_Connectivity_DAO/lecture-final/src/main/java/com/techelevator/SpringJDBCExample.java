package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		
		// STEP 1: Create a DataSource
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");
		
		// STEP 2: Instantiate a JdbcTemplatae and pass it the DataSource
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		
		
		// STEP 3: Use the JdbcTemplate methods to execute queries and get results
		//         update() method for statements that do not return data (INSERT, UPDATE, DELETE)
		//         queryForRowSet() method for statements that return data (SELECT and INSERT WITH RETURNING)
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String category = "Comedy";
		String sqlFilmsByCategory =  "SELECT film.title, film.release_year "+
									 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
									 "JOIN category ON category.category_id = film_category.category_id "+
									 "WHERE category.name = ?";
		
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */
		
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByCategory, category);
		
		System.out.println(category+" Films:");
		while(results.next()) {  // The "next" method advances the cursor to the next row.  If a row exists, it returns true, otherwise false
			String filmTitle = results.getString("title");  // this is the title column from teh SELECT statment above
			int releaseYear = results.getInt("release_year");
			System.out.println(filmTitle+" ("+releaseYear+")");
		}
		
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) "
				+ "VALUES (?, ?, ?)";
		
		dvdstoreJdbcTemplate.update(sqlCreateActor, 1000, "Craig", "Castelaz");
		
		
		
		
		/* The next example makes use of the world database, so we need a new 
		 * DataSource for creating connections to that database. */
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate worldJdbcTemplate = new JdbcTemplate(worldDataSource);
		
		/*
		 * Sequences are often used to generate a unique Id value prior to inserting
		 * a new record.
		 * 
		 * There 3 ways to get a generated id (sequence) for use in a surrogate primary key.  
		 */
		/*
		 * Using a SELECT nextVal() 
		 */
		String sqlGetNextId = "SELECT nextval('seq_city_id')";
		results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);
		results.next(); // advances to the first row.  next() must always be called on a RowSet, even if only getting 1 row
		int id =  results.getInt(1);   // returns the id as an int.  1 refers to the first column (at index 1)
		
		System.out.println("New city id: "+id);
		
		/*
		 * Now create a new city record using the generated id 
		 */
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) "+
								  "VALUES(?, ?, ?, ?, ?)";
		
		worldJdbcTemplate.update(sqlCreateNewCity, id, "Smallville", "USA", "Kansas", 45001);
	}
	
	
	
	/*
	 * In the below methods are 3 examples of different ways to INSERT and get a generated ID in PostgreSQL
	 * 
	 * SELECT for nextVal() - simplest solution with most code
	 * RETURNING as RowSet - slightly more advanced with less code
	 * RETURNING as Object - most advanced and least code
	 * 
	 * All 3 objects are OK to use, so use which ever pattern for getting the code
	 * makes the most sense to you. 
	 * 
	 */
	
	
	/*
	 * The nextVal() method can be called to get the next sequence number and then used in the insert
	 *
	 * Simplest solution, but most code
	 */
	private void getSequenceUsingNextVal(JdbcTemplate worldJdbcTemplate) {
		
		// STEP 1: create a SELECT using the sequence and nextval()
		String sqlGetNextId = "SELECT nextval('seq_city_id')";
		// STEP 2: used JdbcTemplate queryForRowSet to get the next id
		SqlRowSet results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);
		// STEP 3: call next() to advance the cursor to the first row
		results.next(); 
		// STEP 4: used getInt(1) to get the id as an int.  1 refers to the first column, which is at index 1
		int id =  results.getInt(1);   
	
		/*
		 * STEP 5: Create an INSERT using the generated id as a parameter for the id column
		 */
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) "+
								  "VALUES(?, ?, ?, ?, ?)";
		worldJdbcTemplate.update(sqlCreateNewCity, id, "IdFromNextVal", "USA", "Kansas", 45001);
	
	}
	
	/*
	 * The INSERT can be done using DEFAULT to generate the ID and the RETURNING clause
	 * added to the statement to return the generated id.
	 * 
	 * When using Returning a SELECT will automatically be done after the INSERT, so 
	 * queryForRowSet must be used instead of update()
	 * 
	 * Slightly more advanced with less code
	 */
	private void getSequenceUsingReturning(JdbcTemplate worldJdbcTemplate) {
		
		// STEP 1: Create an INSERT using DEFAULT for the id and adding RETURNING for the id column
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) "+
				  "VALUES(DEFAULT, ?, ?, ?, ?) RETURNING id";

		// STEP 2: Use queryForRowSet() to do the INSERT and returning the rowSet created by the automatic SELECT done by RETURNING
		SqlRowSet results = worldJdbcTemplate.queryForRowSet(sqlCreateNewCity, "IdFromReturning", "USA", "Kansas", 45001);
		
		// STEP 3: call next() to advance the cursor to the first row
		results.next(); 
		
		// STEP 4: used getInt("id") to get the id as an int.  Where "id" is the column name being returned
		int id =  results.getInt("id");  
	}
	
	
	/*
	 * The INSERT can be done using DEFAULT to generate the ID and the RETURNING clause
	 * added to the statement to return the generated id.
	 * 
	 * Since the RETURNING will automatically SELECT and return the new id, queryForObject can
	 * be used to directly get the ID into the Integer wrapper class
	 * 
	 * Most advanced and least code
	 */
	private void getSequenceUsingReturningWithQueryForObject(JdbcTemplate worldJdbcTemplate) {
		
		// STEP 1: Create an INSERT using DEFAULT for the id and adding RETURNING for the id column
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) "+
				  "VALUES(DEFAULT, ?, ?, ?, ?) RETURNING id";

		// STEP 2: Use queryForObject() setting Integer.class as the return type (Second argument).  Just the id will be returned instead of the RowSet
		Integer id = worldJdbcTemplate.queryForObject(sqlCreateNewCity, Integer.class, "IdFromReturning", "USA", "Kansas", 45001);
		
	}
	
}
