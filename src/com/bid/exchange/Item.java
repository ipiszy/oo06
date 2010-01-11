package com.bid.exchange;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Item implements IsSerializable {
	// constant values for the bidding status
	public final static int ONBID = 0;
	public final static int OBSOLETE = 1;

	// static information which must be provide when posting obsolete
	private long itemID;
	private String itemName;
	private String itemDes;
	//Sting itemBidRule;
	private double itemFloorPrice;
	private int sortID;
	private String postUserName;
	private int itemAvailableSeconds ;

	
	
	// dynamic information which would change during the bidding process
	private int itemHighestBidPrice = 0;
	private int itemStatus = ONBID;
	private String itemCargoName = null;
	private int itemCargoID = -1; // not available
	

	public Item(){
		
	}
	public Item(int itemid, String itemname, String des, 
			double floorprice, int sortid, String postUserName, int ttl){
		this.itemID = itemid;
		this.itemName = itemname;
		this.itemDes = des;
		this.itemFloorPrice = floorprice;
		this.sortID = sortid;
		this.itemAvailableSeconds = ttl;
	}


	public long getItemId() {
		return this.itemID;
	}

	/**
	 * 
	 * @return
	 */
	public long getTime() {
		return this.itemAvailableSeconds;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}

	public String getItemDes() {
		return itemDes;
	}

	public void setItemFloorPrice(int itemFloorPrice) {
		this.itemFloorPrice = itemFloorPrice;
	}

	public double getItemFloorPrice() {
		return itemFloorPrice;
	}

	public void setItemHighestBidPrice(int itemHighestBidPrice) {
		this.itemHighestBidPrice = itemHighestBidPrice;
	}

	public int getItemHighestBidPrice() {
		return itemHighestBidPrice;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemAvailableSeconds(int itemAvailableSeconds) {
		this.itemAvailableSeconds = itemAvailableSeconds;
	}

	public int getItemAvailableSeconds() {
		return itemAvailableSeconds;
	}

	public void setItemCargoName(String itemCargoName) {
		this.itemCargoName = itemCargoName;
	}

	public String getItemCargoName() {
		return itemCargoName;
	}

	public void setItemCargoID(int itemCargoID) {
		this.itemCargoID = itemCargoID;
	}

	public int getItemCargoID() {
		return itemCargoID;
	}

	public void setSortID(int sortID) {
		this.sortID = sortID;
	}

	public int getSortID() {
		return sortID;
	}

	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}

	public String getPostUserName() {
		return postUserName;
	}
	
}