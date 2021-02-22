package com.techelevator.chucknorris;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class JokeApp {

	private final static String ENDPOINT = "http://api.icndb.com/jokes/random?exclude=explicit";
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {

		String url = ENDPOINT;
		
		System.out.println("Show only nerdy category?");
		String choice = in.nextLine();
		
		
		if (choice.equalsIgnoreCase("Y")) {
			url += "&limitTo=nerdy";
		}
		
		Joke joke = restTemplate.getForObject(url, Joke.class);
		
		System.out.println( joke.getValue().getJoke() );
		

	}

}
