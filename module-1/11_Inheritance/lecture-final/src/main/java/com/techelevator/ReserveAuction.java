package com.techelevator;

public class ReserveAuction extends Auction {

	private int reservePrice;
	
	public ReserveAuction(String itemName, int reservePrice) {
		super(itemName);
		this.reservePrice = reservePrice;
	}
	
	public int getReservePrice() {
		return this.reservePrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		// Check if auction meets the reserve price, if no reject  (ReserveAuction)
		// if yes, place the bid (Auction)
		// return if they are winning
		
		boolean isWinningBid = false;
		
		if (offeredBid.getBidAmount() >= reservePrice) {
			isWinningBid = super.placeBid(offeredBid);  // invoke the placeBid method on the superclass
		}
		
		return isWinningBid;
	}
}
