package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    
    @RequestMapping(method=RequestMethod.GET)
    public List<Auction> list(){
    	List<Auction> auctions = new ArrayList<>();
    	auctions = dao.list();
    	
    	return auctions;
    }
   
    
    //not passing
    @RequestMapping(path="/auctions/{id}", method=RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	return dao.get(id);
    }
    
    
    @RequestMapping(method=RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
    	return dao.create(auction);
    }
    
    
    //causing errors
//    @RequestMapping( method=RequestMethod.GET)
//    public List<Auction> searchByTitle(@RequestParam (required=false) String searchTerm){
//    	List<Auction> auctions = new ArrayList<>();
//    	auctions = dao.searchByTitle(searchTerm);
//    	
//    	return auctions;
//    }
    
    
    
    
    
}
