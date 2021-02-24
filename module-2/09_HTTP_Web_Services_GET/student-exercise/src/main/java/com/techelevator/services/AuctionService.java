package com.techelevator.services;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    public static final String BASE_URL = "http://localhost:3000/auctions";
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();


    public Auction[] listAllAuctions() {
    	String endpointURL = BASE_URL;
    	Auction[] auctions = restTemplate.getForObject(endpointURL, Auction[].class);
        // api code here
        return auctions;
    }

    public Auction listDetailsForAuction(int id) {
    	//http://localhost:3000/auctions/?id=1
    	String endpointURL = BASE_URL + "/" + id;
    	Auction auction = restTemplate.getForObject(endpointURL, Auction.class);
        
        return auction;
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        // http://localhost:3000/auctions/?title=Bell Computer Monitor
    	String endpointURL = "http://localhost:3000/auctions?title_like=" + title; 
    	Auction[] auctions = restTemplate.getForObject(endpointURL, Auction[].class);
        return auctions;

    }

    public Auction[] findAuctionsSearchPrice(double price) {
        // http://localhost:3000/auctions/?currentBid_lte=101
    	String endpointURL = "http://localhost:3000/auctions?currentBid_lte=" + price;
    	//String endpointURL = BASE_URL + "/?currentBid_lte=" + price;
    	Auction[] auctions = restTemplate.getForObject(endpointURL, Auction[].class);
    	return auctions;
    
    }

}
