package com.techelevator;

public class BuyoutAuction extends Auction {

	private int buyoutPrice;
	
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale);
		this.buyoutPrice = buyoutPrice;
	}

	public int getBuyoutPrice() {
		return buyoutPrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		// Check if the Buyout price is meet, if set to the winning bid (Specific to BuyoutAuction)
		// if not, then check if it is the high bid (General to an Auction)
		// return true/false if it is the winning bid
		boolean isCurrentWinningBid = false;
		
		if (getHighBid().getBidAmount() < buyoutPrice) {
			if (offeredBid.getBidAmount() >= buyoutPrice) {
				offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
			}
			isCurrentWinningBid = super.placeBid(offeredBid); // Can call the original version in the superclass
		}
		
		return isCurrentWinningBid;
	}
}
