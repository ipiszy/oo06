package com.bid.exchange;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Add getter and Setter to this simple struct-like class?
 * all public fields would be enough
 * @author Sepsky
 *
 */
public class UserInfo implements IsSerializable{
	public static String NONE = "none";

	private String userName;
	private double userBalance = 0;
	private String userPass;
	private String userBankAccount;
	private String userMailBox;

	public UserInfo(){
		
	}
	public UserInfo(String name, double balance, String pswd, String bankAccount, String mailBox)
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
	public void dump() {
		System.out.println(this.toString());
	}

	public String toString(){
		String tmp = "";
		tmp = tmp.concat("userName: "+this.userName+" ");
		tmp = tmp.concat("passwd:"+ this.userPass+" ");
		tmp = tmp.concat("userBalance: "+this.userBalance+" ");
		tmp = tmp.concat("bankAccount: "+this.userBankAccount+" ");
		tmp = tmp.concat("userEmail"+this.userMailBox);
		return tmp;
	}
}

