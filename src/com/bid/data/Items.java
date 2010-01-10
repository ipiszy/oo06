package com.bid.data;

// Generated 2010-1-10 18:44:40 by Hibernate Tools 3.2.4.GA

/**
 * Items generated by hbm2java
 */
public class Items implements java.io.Serializable {

	private int itemId;
	private String itemName;
	private String itemDes;
	private String itemBidRule;
	private Double itemFlourPrice;
	private Double itemHighestBidprice;
	private String itemHighestBidUserName;
	private Integer itmeStatus;
	private Integer itemAvailableSeconds;
	private String itemCargoName;
	private Integer itmeCargoId;
	private int sortId;
	private String postUser;

	public Items() {
	}

	public Items(int itemId, int sortId) {
		this.itemId = itemId;
		this.sortId = sortId;
	}

	public Items(int itemId, String itemName, String itemDes,
			String itemBidRule, Double itemFlourPrice,
			Double itemHighestBidprice, String itemHighestBidUserName,
			Integer itmeStatus, Integer itemAvailableSeconds,
			String itemCargoName, Integer itmeCargoId, int sortId,
			String postUser) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDes = itemDes;
		this.itemBidRule = itemBidRule;
		this.itemFlourPrice = itemFlourPrice;
		this.itemHighestBidprice = itemHighestBidprice;
		this.itemHighestBidUserName = itemHighestBidUserName;
		this.itmeStatus = itmeStatus;
		this.itemAvailableSeconds = itemAvailableSeconds;
		this.itemCargoName = itemCargoName;
		this.itmeCargoId = itmeCargoId;
		this.sortId = sortId;
		this.postUser = postUser;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDes() {
		return this.itemDes;
	}

	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}

	public String getItemBidRule() {
		return this.itemBidRule;
	}

	public void setItemBidRule(String itemBidRule) {
		this.itemBidRule = itemBidRule;
	}

	public Double getItemFlourPrice() {
		return this.itemFlourPrice;
	}

	public void setItemFlourPrice(Double itemFlourPrice) {
		this.itemFlourPrice = itemFlourPrice;
	}

	public Double getItemHighestBidprice() {
		return this.itemHighestBidprice;
	}

	public void setItemHighestBidprice(Double itemHighestBidprice) {
		this.itemHighestBidprice = itemHighestBidprice;
	}

	public String getItemHighestBidUserName() {
		return this.itemHighestBidUserName;
	}

	public void setItemHighestBidUserName(String itemHighestBidUserName) {
		this.itemHighestBidUserName = itemHighestBidUserName;
	}

	public Integer getItmeStatus() {
		return this.itmeStatus;
	}

	public void setItmeStatus(Integer itmeStatus) {
		this.itmeStatus = itmeStatus;
	}

	public Integer getItemAvailableSeconds() {
		return this.itemAvailableSeconds;
	}

	public void setItemAvailableSeconds(Integer itemAvailableSeconds) {
		this.itemAvailableSeconds = itemAvailableSeconds;
	}

	public String getItemCargoName() {
		return this.itemCargoName;
	}

	public void setItemCargoName(String itemCargoName) {
		this.itemCargoName = itemCargoName;
	}

	public Integer getItmeCargoId() {
		return this.itmeCargoId;
	}

	public void setItmeCargoId(Integer itmeCargoId) {
		this.itmeCargoId = itmeCargoId;
	}

	public int getSortId() {
		return this.sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public String getPostUser() {
		return this.postUser;
	}

	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}

}