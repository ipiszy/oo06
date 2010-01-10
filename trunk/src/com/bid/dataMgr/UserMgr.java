package com.bid.dataMgr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bid.data.Users;
import com.bid.exchange.UserInfo;

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
			
			HibernateUtility.beginTransaction();
			Users user = (Users) s.get(Users.class, userInfo.getUserName());
			HibernateUtility.commitTransaction();
			if(user!=null){
				flag = false;
			}else
			{
				user = new Users();
				user.setUserName(userInfo.getUserName());
				user.setUserPass(userInfo.getUserPass());
				user.setUserBalance(userInfo.getUserBalance());
				user.setUserBankAccount(userInfo.getUserBankAccount());
				user.setUserMailBox(userInfo.getUserMailBox());
	
				HibernateUtility.beginTransaction();
				s.saveOrUpdate(user);
				HibernateUtility.commitTransaction();
			}
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
	
	
	public static void main(String[] args){
		
//          System.out.println(new UserMgr().selectAll());
//          System.out.println(new UserMgr().queryAccount("ipiszy"));
//          System.out.println(new UserMgr().delAccount("ipiszy"));
         

		System.out.println(new UserMgr().addUser(new UserInfo("ipiszy", 0,
				"Applicant", "ipiszy", "ipiszy")));
		System.out.println(new UserMgr().addUser(new UserInfo(   "ipiszy", 0,
				"Applicant", "ipiszy", "ipiszy")));
        
        System.out.println(new UserMgr().isValid("ipiszy", "Applicant"));
        System.out.println(new UserMgr().isValid("aay", "a"));
        System.out.println(new UserMgr().addUser(new UserInfo(
                "aay", 0, "123", "ipiszy", "ipiszy")));
        System.out.println(new UserMgr().isValid("aay", "123"));
	}

	public void login(String userName) {
		// TODO Auto-generated method stub
		
	}

}
