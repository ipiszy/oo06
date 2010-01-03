package com.bid.data;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class testHibernate {
	public static void main(String[] argv) {
		Session session = HibernateUtility.currentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List hellos = session.createQuery("from Hello").list();
			for (Iterator iterator = hellos.iterator(); iterator.hasNext();) {
				Hello hello = (Hello) iterator.next();
				System.out.println(hello.getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
	}

}
