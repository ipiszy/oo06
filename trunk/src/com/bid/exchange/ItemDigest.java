package com.bid.exchange;

import java.util.Date;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ItemDigest implements IsSerializable {
	static public String ONBID = Item.ONBID;
	static public String ONDELIEVER = Item.ONDELIVER;
	static public String OBSOLETE = Item.OBSOLETE;
	static public String DELIVERED = Item.DELIVERED;
	String imageURL;
	String name;
	double basePrice;
	double latestPrice;
	long cargoId;
	String cargoName;
	Date d;
	long itemId;
	int itemStatus;
	
	public int getStatus(){
		return itemStatus;
	}
	
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	
	public long getCargoId() {
		return cargoId;
	}
	public void setCargoId(long cargoId) {
		this.cargoId = cargoId;
	}
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getLatestPrice() {
		return latestPrice;
	}
	public void setLatestPrice(double latestPrice) {
		this.latestPrice = latestPrice;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public ItemDigest(long itemId, String imageURL, String name, double basePrice,
			double latestPrice, Date d, String cargoName, long cargoId, int itemStatus) {
		super();
		this.itemId = itemId;
		this.imageURL = imageURL;
		this.name = name;
		this.basePrice = basePrice;
		this.latestPrice = latestPrice;
		this.d = d;
	}
	public ItemDigest() {
	}
	public void dump() {
		System.out.println("dumping the content of a ItemDigest object");
		System.out.println(this.toString());
	}	
	
	
	//@OVERRIDE
	public String toString(){
		String tmp = "";
		tmp = tmp.concat("itemName: "+name+" ");
		tmp = tmp.concat("itemID: "+ this.itemId+" ");
		tmp = tmp.concat("\n");
		tmp = tmp.concat("basePrice: "+this.basePrice+" ");
		tmp = tmp.concat("latestPrice: "+ this.latestPrice+" ");
		tmp = tmp.concat("\n");
		tmp = tmp.concat("Date: "+d+"  ");
		tmp = tmp.concat("URL: "+this.imageURL);

		return tmp;
	}
}




