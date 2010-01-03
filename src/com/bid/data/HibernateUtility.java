package com.bid.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.*;

/** @pdOid 99006061-8d05-4d3a-9a05-473d2391ccd8 */

public class HibernateUtility {

   /** @pdOid 5569b518-2344-455e-b365-ec17d1016d37 */

   private static final SessionFactory sessionFactory;

   

   /** @exception HibernateException

    * @pdOid 24988c2b-f84f-42a2-a9e4-909be5131505 */

   private static Session openSession() throws HibernateException {
   	return getSessionFactory().openSession();
   }

   

   /** @exception HibernateException

    * @pdOid 1572e789-cb85-4b84-8704-0106325c5ef9 */

   private static SessionFactory getSessionFactory() throws HibernateException {
   	return sessionFactory;
   }

   

   /** @pdOid 6f6ebcc5-cbb6-49d1-a785-afa469fa25e7 */

   static Log logger = LogFactory.getLog(HibernateUtility.class);

   

   /** @pdOid df4a2101-d558-4461-8930-60c2a12135d8 */

   public static final ThreadLocal tLocalsess = new ThreadLocal();

   /** @pdOid 1b25610b-745c-4bdf-a66c-1ffef10210eb */

   public static final ThreadLocal tLocaltx = new ThreadLocal();

   

   /** @pdOid 4ae999d8-6061-4848-8b65-b9d68223e6e6 */

   public static Session currentSession() {
   	Session session = (Session) tLocalsess.get();
   	try {
   		if (session == null || !session.isOpen()) {
   			session = openSession();
   			tLocalsess.set(session);
   		}
   	} catch (HibernateException e) {
   		e.printStackTrace();
   		logger.error(e);
   	}
   	return session;
   }

   

   /** @pdOid 0aa1c589-29b1-4c77-bc47-134cfa1b74b0 */

   public static void closeSession() {
   	Session session = (Session) tLocalsess.get();
   	tLocalsess.set(null);
   	try {
   		if (session != null && session.isOpen()) {
   			session.close();
   		}
   	} catch (HibernateException e) {
   		e.printStackTrace();
   		logger.error(e);
   	}
   }

   

   /** @pdOid b7a6d39b-9021-4507-8550-b48db8f7cb8f */

   public static void beginTransaction() {
   	System.out.println("begin tx");
   	Transaction tx = (Transaction) tLocaltx.get();
   	try {
   		if (tx == null) {
   			tx = currentSession().beginTransaction();
   			tLocaltx.set(tx);
   		}
   	} catch (HibernateException e) {
   		e.printStackTrace();
   		logger.error(e);
   	}
   }

   

   /** @pdOid a8c54021-0df8-4bb0-b2ac-b8e114de7df6 */

   public static void commitTransaction() {
   	Transaction tx = (Transaction) tLocaltx.get();
   	try {
   		if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
   			tx.commit();
   		tLocaltx.set(null);
   		System.out.println("commit tx");
   	} catch (HibernateException e) {
   		e.printStackTrace();
   		logger.error(e);
   		HibernateUtility.rollbackTransaction();
   	}
   }

   

   /** @pdOid 14118b68-adfb-4c27-8432-0d2c584ba413 */

   public static void rollbackTransaction() {
   	Transaction tx = (Transaction) tLocaltx.get();
   	try {
   		if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
   			tx.rollback();
   	} catch (HibernateException e) {
   		e.printStackTrace();
   		logger.error(e);
   	}
   }

   

   static 	{
   		try {
   			sessionFactory = new Configuration().configure()
   					.buildSessionFactory();
   			
   		} catch (Throwable ex) {
   			ex.printStackTrace();
   			throw new ExceptionInInitializerError(ex);
   		}
   	}



}
