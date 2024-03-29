package com.bid.data;

// Generated 2010-1-13 1:54:57 by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Items generated by hbm2java
 */
public class Items implements java.io.Serializable {

	private long itemId;
	private Users usersByItemHighestBidUserName;
	private Users usersByPostUser;
	private Sorts sorts;
	private String itemName;
	private String itemDes;
	private String itemBidRule;
	private Double itemFloorPrice;
	private Double itemHighestBidPrice;
	private String itemStatus;
	private String itemCargoName;
	private Long itemCargoId;
	private String imageUrl;
	private Date itemBidDeadLine;
	private Date itemPostTimestamp;
	private Set<Deposits> depositses = new HashSet<Deposits>(0);

	public Items() {
	}

	public Items(Sorts sorts, String itemName, Date itemBidDeadLine,
			Date itemPostTimestamp) {
		this.sorts = sorts;
		this.itemName = itemName;
		this.itemBidDeadLine = itemBidDeadLine;
		this.itemPostTimestamp = itemPostTimestamp;
	}

	public Items(Users usersByItemHighestBidUserName, Users usersByPostUser,
			Sorts sorts, String itemName, String itemDes, String itemBidRule,
			Double itemFloorPrice, Double itemHighestBidPrice,
			String itemStatus, String itemCargoName, Long itemCargoId,
			String imageUrl, Date itemBidDeadLine, Date itemPostTimestamp,
			Set<Deposits> depositses) {
		this.usersByItemHighestBidUserName = usersByItemHighestBidUserName;
		this.usersByPostUser = usersByPostUser;
		this.sorts = sorts;
		this.itemName = itemName;
		this.itemDes = itemDes;
		this.itemBidRule = itemBidRule;
		this.itemFloorPrice = itemFloorPrice;
		this.itemHighestBidPrice = itemHighestBidPrice;
		this.itemStatus = itemStatus;
		this.itemCargoName = itemCargoName;
		this.itemCargoId = itemCargoId;
		this.imageUrl = imageUrl;
		this.itemBidDeadLine = itemBidDeadLine;
		this.itemPostTimestamp = itemPostTimestamp;
		this.depositses = depositses;
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Users getUsersByItemHighestBidUserName() {
		return this.usersByItemHighestBidUserName;
	}

	public void setUsersByItemHighestBidUserName(
			Users usersByItemHighestBidUserName) {
		this.usersByItemHighestBidUserName = usersByItemHighestBidUserName;
	}

	public Users getUsersByPostUser() {
		return this.usersByPostUser;
	}

	public void setUsersByPostUser(Users usersByPostUser) {
		this.usersByPostUser = usersByPostUser;
	}

	public Sorts getSorts() {
		return this.sorts;
	}

	public void setSorts(Sorts sorts) {
		this.sorts = sorts;
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

	public Double getItemFloorPrice() {
		return this.itemFloorPrice;
	}

	public void setItemFloorPrice(Double itemFloorPrice) {
		this.itemFloorPrice = itemFloorPrice;
	}

	public Double getItemHighestBidPrice() {
		return this.itemHighestBidPrice;
	}

	public void setItemHighestBidPrice(Double itemHighestBidPrice) {
		this.itemHighestBidPrice = itemHighestBidPrice;
	}

	public String getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemCargoName() {
		return this.itemCargoName;
	}

	public void setItemCargoName(String itemCargoName) {
		this.itemCargoName = itemCargoName;
	}

	public Long getItemCargoId() {
		return this.itemCargoId;
	}

	public void setItemCargoId(Long itemCargoId) {
		this.itemCargoId = itemCargoId;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getItemBidDeadLine() {
		return this.itemBidDeadLine;
	}

	public void setItemBidDeadLine(Date itemBidDeadLine) {
		this.itemBidDeadLine = itemBidDeadLine;
	}

	public Date getItemPostTimestamp() {
		return this.itemPostTimestamp;
	}

	public void setItemPostTimestamp(Date itemPostTimestamp) {
		this.itemPostTimestamp = itemPostTimestamp;
	}

	public Set<Deposits> getDepositses() {
		return this.depositses;
	}

	public void setDepositses(Set<Deposits> depositses) {
		this.depositses = depositses;
	}

}
