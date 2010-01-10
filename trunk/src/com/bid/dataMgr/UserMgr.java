package com.bid.dataMgr;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bid.data.UserInfo;
import com.bid.data.Users;

public class UserMgr {
	private static Log log = LogFactory.getLog(UserMgr.class);

	public boolean isValid(String userName, String psw) {
		Session s = HibernateUtility.currentSession();
		boolean returnValue = false;
		try {
			HibernateUtility.beginTransaction();
			Users user = (Users) s.get(Users.class, userName);
			HibernateUtility.commitTransaction();

			if (user == null)
				returnValue = false;
			else if (!user.getUserPass().equals(psw))
				returnValue = false;
			else
				returnValue = true;
			// else if (user.isDisabled() == true)
			// returnString = "disabled";
			// else
			// returnString = user.getType();

		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			log.fatal(e);
			returnValue = false;
		}
		HibernateUtility.closeSession();
		return returnValue;
	}

	public boolean addUser(UserInfo userInfo) {
		boolean flag = true;
		Session s = HibernateUtility.currentSession();
		try {
			Users user = new Users();
			user.setUserName(userInfo.userName);
			user.setUserPass(userInfo.userPass);
			user.setUserBalance(userInfo.userBalance);
			user.setUserBankAccount(userInfo.userBankAccount);
			user.setUserMailBox(userInfo.userMailBox);

			HibernateUtility.beginTransaction();
			s.saveOrUpdate(user);
			HibernateUtility.commitTransaction();
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}

		HibernateUtility.closeSession();
		return flag;

	}

	public boolean charge(String userName, double money) {
		// TODO
		return false;
	}

	public boolean transfer(double money/* (+,-) */) {
		// TODO
		return false;
	}

	// is this necessary?
	// Wu Fenggang
	public void login(String userName) {
		// TODO Auto-generated method stub

	}

	public boolean hasUser(String userName) {
		Session s = HibernateUtility.currentSession();
		boolean returnValue = false;
		try {
			HibernateUtility.beginTransaction();
			Users user = (Users) s.get(Users.class, userName);
			HibernateUtility.commitTransaction();

			if (user == null)
				returnValue = false;
			returnValue = true;

		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			log.fatal(e);
			returnValue = false;
		}
		HibernateUtility.closeSession();
		return returnValue;
	}

}
