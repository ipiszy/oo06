package com.bid.data;

public class UserInfo {

	public String userName;
	public double userBalance = 0;
	public String userPass;
	public String userBankAccount;
	public String userMailBox;

	UserInfo(String name, int balance, String pswd, String bankAccount, String mailBox)
	{
		this.userName = name;
		this.userBalance = balance;
		this.userPass = pswd;
		this.userBankAccount = bankAccount;
		this.userMailBox = mailBox;
	}

//	boolean setuserBalance(String userName,int charge);
//
//	boolean setuserPass(String userName,String newPass);
//
//	boolean setuserBankAccount(String userName,String newBankAccount);
//
//	boolean setuserMailBox(String userName,String newMailBox)
//	public String getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

