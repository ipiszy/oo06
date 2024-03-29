package com.bid.dataMgr;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bid.data.Hello;

public class HelloManager {
	public String list() {
		Session session = HibernateUtility.currentSession();
		Transaction transaction = null;
		StringBuffer result = new StringBuffer("");
		try {
			transaction = session.beginTransaction();
			List hellos = session.createQuery("from Hello").list();
			for (Iterator iterator = hellos.iterator(); iterator.hasNext();) {
				Hello hello = (Hello) iterator.next();
				result.append(hello.getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			return result.toString();
		}
	}

	public static void main(String [] arg){
		System.out.println("testing hibernate");
		System.out.println(new HelloManager().list());
	}
}
