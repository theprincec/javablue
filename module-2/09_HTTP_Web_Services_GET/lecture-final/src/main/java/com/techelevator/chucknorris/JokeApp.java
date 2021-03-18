package com.techelevator.chucknorris;

import java.util.Scanner;

import com.techelevator.chucknorris.Word;

import org.springframework.web.client.RestTemplate;

public class JokeApp {

	
	//https://www.dictionaryapi.com/api/v3/references/thesaurus/json/college?key=ca9b93dd-8df7-4fd7-bc5a-866b7b5dac4a;
	//https://www.dictionaryapi.com/api/v3/references/thesaurus/json/
		//college      searchTerm
		//?key=ca9b93dd-8df7-4fd7-bc5a-866b7b5dac4a	
	
		
		
		
		
		
	private final static String ENDPOINT = "http://api.icndb.com/jokes/random?exclude=explicit";
	
	private final static String END = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/";
	private final static String KEY = "?key=ca9b93dd-8df7-4fd7-bc5a-866b7b5dac4a";
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {

		//String url = ENDPOINT;
		
		System.out.println("Show only nerdy category?");
		String choice = in.nextLine();

		
		String url = END + "college" + KEY;
		
		if (choice.equalsIgnoreCase("Y")) {
//			getSearchWord(choice);
			
			
			//url += "&limitTo=nerdy";
		}
		
		//Joke joke = restTemplate.getForObject(url, Joke.class);
		
		//System.out.println( joke.getValue().getJoke() );
		
		Word theWord = restTemplate.getForObject(url, Word.class);
		
		System.out.println(theWord);
		

		

		

	}

}
