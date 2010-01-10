package com.bid.data;

/**
 * Add getter and Setter to this simple struct-like class?
 * all public fields would be enough
 * @author Sepsky
 *
 */
public class UserInfo implements java.io.Serializable{

	private String userName;
	private double userBalance = 0;
	private String userPass;
	private String userBankAccount;
	private String userMailBox;

	public UserInfo(){
		
	}
	public UserInfo(String name, int balance, String pswd, String bankAccount, String mailBox)
	{
		this.setUserName(name);
		this.setUserBalance(balance);
		this.setUserPass(pswd);
		this.setUserBankAccount(bankAccount);
		this.setUserMailBox(mailBox);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public double getUserBalance() {
		return userBalance;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserBankAccount(String userBankAccount) {
		this.userBankAccount = userBankAccount;
	}

	public String getUserBankAccount() {
		return userBankAccount;
	}

	public void setUserMailBox(String userMailBox) {
		this.userMailBox = userMailBox;
	}

	public String getUserMailBox() {
		return userMailBox;
	}

}

