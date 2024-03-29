package com.bid.data;

// Generated 2010-1-13 1:54:57 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	private String userName;
	private String userPass;
	private Double userBalance;
	private String userBankAccount;
	private String userMailBox;
	private Set<Items> itemsesForItemHighestBidUserName = new HashSet<Items>(0);
	private Set<Items> itemsesForPostUser = new HashSet<Items>(0);
	private Set<Deposits> depositses = new HashSet<Deposits>(0);

	public Users() {
	}

	public Users(String userName, String userPass) {
		this.userName = userName;
		this.userPass = userPass;
	}

	public Users(String userName, String userPass, Double userBalance,
			String userBankAccount, String userMailBox,
			Set<Items> itemsesForItemHighestBidUserName,
			Set<Items> itemsesForPostUser, Set<Deposits> depositses) {
		this.userName = userName;
		this.userPass = userPass;
		this.userBalance = userBalance;
		this.userBankAccount = userBankAccount;
		this.userMailBox = userMailBox;
		this.itemsesForItemHighestBidUserName = itemsesForItemHighestBidUserName;
		this.itemsesForPostUser = itemsesForPostUser;
		this.depositses = depositses;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Double getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserBankAccount() {
		return this.userBankAccount;
	}

	public void setUserBankAccount(String userBankAccount) {
		this.userBankAccount = userBankAccount;
	}

	public String getUserMailBox() {
		return this.userMailBox;
	}

	public void setUserMailBox(String userMailBox) {
		this.userMailBox = userMailBox;
	}

	public Set<Items> getItemsesForItemHighestBidUserName() {
		return this.itemsesForItemHighestBidUserName;
	}

	public void setItemsesForItemHighestBidUserName(
			Set<Items> itemsesForItemHighestBidUserName) {
		this.itemsesForItemHighestBidUserName = itemsesForItemHighestBidUserName;
	}

	public Set<Items> getItemsesForPostUser() {
		return this.itemsesForPostUser;
	}

	public void setItemsesForPostUser(Set<Items> itemsesForPostUser) {
		this.itemsesForPostUser = itemsesForPostUser;
	}

	public Set<Deposits> getDepositses() {
		return this.depositses;
	}

	public void setDepositses(Set<Deposits> depositses) {
		this.depositses = depositses;
	}

}
