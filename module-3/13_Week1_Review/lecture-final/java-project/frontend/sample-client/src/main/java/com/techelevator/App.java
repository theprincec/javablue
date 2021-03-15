package com.techelevator;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Scanner in = new Scanner(System.in);
	private static RestTemplate restTemplate = new RestTemplate();
	
    public static void main( String[] args )
    {
    	
        System.out.print( "Country code >>>" );
        String code = in.nextLine();
        
        String url = "http://localhost:8080/cities?code=" + code;
        
        City[] cities = restTemplate.getForObject(url, City[].class);
        
        for (City city : cities) {
        	System.out.println(city.getName());
        }
    }
}
