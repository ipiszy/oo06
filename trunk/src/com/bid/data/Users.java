package com.bid.data;

// Generated 2010-1-11 0:22:20 by Hibernate Tools 3.2.4.GA

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

	private String userName;
	private Double userBalance;
	private String userPass;
	private String userBankAccount;
	private String userMailBox;

	public Users() {
	}

	public Users(String userName, String userBankAccount) {
		this.userName = userName;
		this.userBankAccount = userBankAccount;
	}

	public Users(String userName, Double userBalance, String userPass,
			String userBankAccount, String userMailBox) {
		this.userName = userName;
		this.userBalance = userBalance;
		this.userPass = userPass;
		this.userBankAccount = userBankAccount;
		this.userMailBox = userMailBox;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
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

}
