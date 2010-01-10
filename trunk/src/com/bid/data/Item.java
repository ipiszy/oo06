package com.bid.data;

public class Item {
	// constant values for the bidding status
	public final static int ONBID = 0;
	public final static int OBSOLETE = 1;

	// static information which must be provide when posting obsolete
	private long itemID;
	private String itemName;
	private String itemDes;
	//Sting itemBidRule;
	private int itemFloorPrice;
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
			int floorprice, int sortid, String postUserName, int ttl){
		this.itemID = itemid;
		this.itemName = itemname;
		this.itemDes = des;
		this.itemFloorPrice = floorprice;
		this.sortID = sortid;
		this.itemAvailableSeconds = ttl;
	}

//	boolean updateitemName(int itemID, String newName);
//
//	boolean updateitemDes(int itemID, String newDes);
//
//	boolean updateitemHighestBidPrice(int itemID, int newHighestBidPrice);
//
//	boolean updateitemHighestBidUserName(int itemID, String newHighestBidPrice);
//
//	boolean updateitemStatus(int itemID,int newStatus);
//
//	boolean updateitemAvailableSeconds(int itemID, int newAvailableSeconds);
//
//	boolean updateitemCargoName(int itemID,String CargoName);
//
//	boolean updataitemCargoID(int itemID, int CargoID);

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

	public int getItemFloorPrice() {
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
