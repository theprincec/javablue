package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        
        BuyoutAuction buyoutAuction = new BuyoutAuction("Book", 15);
        
        buyoutAuction.placeBid(new Bid("John", 10));
        buyoutAuction.placeBid(new Bid("Steve", 23));
        buyoutAuction.placeBid(new Bid("Rachelle", 15));
        
        ReserveAuction reserveAuction = new ReserveAuction("Record", 21);
        reserveAuction.placeBid(new Bid("John", 20));
        reserveAuction.placeBid(new Bid("Matt", 25));
        reserveAuction.placeBid(new Bid("Kevin", 27));
        
        
        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);
        
        for (Auction auction : auctions) {
        	auction.placeBid(new Bid("John", 20));
        	
        	if (auction instanceof BuyoutAuction) {
        		BuyoutAuction buyout = (BuyoutAuction) auction;
        	}
        	
        }
        
        
        
    }
}
