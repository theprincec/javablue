package com.techelevator.chucknorris;

import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

public class JokeApp {

	//public JokeApp(DataSource datasource) {
		//venueDAO = new JDBCVenueDAO(datasource);
	//}
	
	// STEP 2: Instantiate a JdbcTemplatae and pass it the DataSource
	/* The JdbcTemplate is the main interface we use to interact with databases using
	 * Spring JDBC. */
	
	//JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
	

//	JokeApp application = new JokeApp(dataSource, menu);
//	application.run();
	

		
	private final static String ENDPOINT = "http://api.icndb.com/jokes/random?exclude=explicit";
	
	private final static String END = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/";
	private final static String KEY = "?key=ca9b93dd-8df7-4fd7-bc5a-866b7b5dac4a";
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		BasicDataSource wordDataSource = new BasicDataSource();
		wordDataSource.setUrl("jdbc:postgresql://localhost:5432/WordBase");
		wordDataSource.setUsername("postgres");
		wordDataSource.setPassword("postgres1");
		
		JdbcTemplate wordJdbcTemplate = new JdbcTemplate(wordDataSource);

		
		System.out.println("Type enter a word to seatch for:");
		String newWordToSearch = in.next();

		
		String url = END + newWordToSearch + KEY;
		
		//restTemplate connected to API to get syns
		//needs an exception handler
		Root[] theWord = restTemplate.getForObject(url, Root[].class);
		
		System.out.println(theWord[0].getMeta().getSyns().get(0));
		
		
		

		

		

	}

}
