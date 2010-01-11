package com.bid.exchange;

import java.util.Date;

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
	private Date date;

	
	
	// dynamic information which would change during the bidding process
	private double itemHighestBidPrice = 0;
	private String itemHighestBidUserName = null;
	private int itemBidRule = 0;	//default
	private int itemStatus = ONBID;
	private String itemCargoName = null;
	private int itemCargoID = -1; // not available
	

	public Item(){
		
	}
	public Item(int itemid, String itemname, String des, 
			double floorprice, int sortid, String postUserName, Date date,
			double highestBidPrice, String highestBidUserName, int itemBidRule){
		this.itemID = itemid;
		this.itemName = itemname;
		this.itemDes = des;
		this.itemFloorPrice = floorprice;
		this.sortID = sortid;
		this.date = date;
		this.itemHighestBidPrice = highestBidPrice;
		this.itemHighestBidUserName = highestBidUserName;
		this.itemBidRule = itemBidRule;
	}


	public long getItemId() {
		return this.itemID;
	}

	/**
	 * 
	 * @return
	 */
	public Date getTime() {
		return this.date;
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

	public double getItemHighestBidPrice() {
		return itemHighestBidPrice;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public String getItemHighestBidUserName() {
		return itemHighestBidUserName;
	}

	public void setItemHighestBidUserName(String ItemHighestBidUserName) {
		this.itemHighestBidUserName = ItemHighestBidUserName;
	}
	
	

	public void setItemAvailableSeconds(Date date) {
		this.date = date;
	}

	public Date getItemAvailableSeconds() {
		return date;
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