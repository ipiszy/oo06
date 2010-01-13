package com.bid.exchange;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Item implements IsSerializable {
	// constant values for the bidding status
	public final static String ONBID = "ONBID";
	public final static String OBSOLETE = "OBSOLETE";
	public final static String ONDELIVER = "ONDELIVER";
	public final static String DELIVERED = "DELIVERED";

	// static information which must be provide when posting obsolete
	private long itemID = 0;
	private String itemName;
	private String itemDes;
	//Sting itemBidRule;
	private double itemFloorPrice;
	private long sortID;
	private String postUserName;
	private Date deadline;
	private String imageURL;
	private Date postTimestamp;

	
	
	// dynamic information which would change during the bidding process
	private double itemHighestBidPrice = 0;
	private String itemHighestBidUserName = null;
	private int itemBidRule = 0;	//default
	private String itemStatus = ONBID;
	private String itemCargoName = null;
	private long itemCargoID = 0; // not available
	

	public Item(){
		
	}
	public Item(long itemid, String itemname, String des, 
			double floorprice, long sortId, String postUserName, Date deadline,
			double highestBidPrice, String highestBidUserName, 
			int itemBidRule, String itemStatus, String imageURL,
			Date postTimestamp, String itemCargoName, long itemCargoId
			){
		this.itemID = itemid;
		this.itemName = itemname;
		this.itemDes = des;
		this.itemFloorPrice = floorprice;
		this.sortID = sortId;
		this.deadline = deadline;
		this.itemHighestBidPrice = highestBidPrice;
		this.itemHighestBidUserName = highestBidUserName;
		this.itemBidRule = itemBidRule;
		this.itemStatus = itemStatus;
		this.imageURL = imageURL;
		this.postTimestamp = postTimestamp;
		this.postUserName = postUserName;
		this.itemCargoName = itemCargoName;
		this.itemCargoID = itemCargoId;
	}

	
	public Item(String itemname, String des, 
			double floorprice, long sortId, String postUserName, Date deadline,
			double highestBidPrice, String highestBidUserName, 
			int itemBidRule, String itemStatus, String imageURL,
			Date postTimestamp, String itemCargoName, long itemCargoId
			){
		this.itemName = itemname;
		this.itemDes = des;
		this.itemFloorPrice = floorprice;
		this.sortID = sortId;
		this.deadline = deadline;
		this.itemHighestBidPrice = highestBidPrice;
		this.itemHighestBidUserName = highestBidUserName;
		this.itemBidRule = itemBidRule;
		this.itemStatus = itemStatus;
		this.imageURL = imageURL;
		this.postTimestamp = postTimestamp;
		this.postUserName = postUserName;
		this.itemCargoName = itemCargoName;
		this.itemCargoID = itemCargoId;
	}


	public long getItemId() {
		return this.itemID;
	}

	/**
	 * 
	 * @return
	 */
	public Date getTime() {
		return this.deadline;
	}

	private void setItemID(long itemID) {
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

	public void setItemBidRule(int itemBidRule) {
		this.itemBidRule = itemBidRule;
	}

	public double getItemBidRule() {
		return itemBidRule;
	}

	public void setItemHighestBidPrice(int itemHighestBidPrice) {
		this.itemHighestBidPrice = itemHighestBidPrice;
	}

	public double getItemHighestBidPrice() {
		return itemHighestBidPrice;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public String getItemHighestBidUserName() {
		return itemHighestBidUserName;
	}

	public void setItemHighestBidUserName(String ItemHighestBidUserName) {
		this.itemHighestBidUserName = ItemHighestBidUserName;
	}
	
	

	public void setItemAvailableSeconds(Date date) {
		this.deadline = date;
	}

	public Date getItemAvailableSeconds() {
		return deadline;
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

	public long getItemCargoID() {
		return itemCargoID;
	}

	public void setSortID(int sortID) {
		this.sortID = sortID;
	}

	public long getSortID() {
		return sortID;
	}

	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}

	public String getPostUserName() {
		return postUserName;
	}
	public void dump() {
		System.out.println("dumping the content of a Item object");
		System.out.println(this.toString());
	}
	public String getImageURL() {
		return imageURL;
	}
	public Date getItemBidDeadline() {
		return deadline;
	}
	public Date getItemPostTimestamp() {
		return this.postTimestamp;
	}
	
	public String  toString(){
		String tmp = "";
		tmp = tmp.concat("itemName: "+this.itemName+" ");
		tmp = tmp.concat("itemID: "+ this.itemID+" ");
		tmp = tmp.concat("\n");
		tmp = tmp.concat("basePrice: "+this.itemFloorPrice+" ");
		tmp = tmp.concat("latestPrice: "+ this.itemHighestBidPrice+" ");
//		tmp.concat("\n");
//		tmp.concat("Date: "+d+"  ");
//		tmp.concat("URL: "+this.imageURL);

		return tmp;
	}
	
}