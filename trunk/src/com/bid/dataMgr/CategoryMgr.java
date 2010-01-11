package com.bid.dataMgr;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bid.data.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CategoryMgr {

	private static Log log = LogFactory.getLog(CategoryMgr.class);

	public List<Category> getAllCategories() {
		Session s = HibernateUtility.currentSession();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		try {
			HibernateUtility.beginTransaction();

			List sortList = s.createSQLQuery(
					"SELECT sortID, sortName from sorts").list();
			HibernateUtility.commitTransaction();

			for (Object obj : sortList) {
				Object[] o = (Object[]) obj;
				long sortID = Long.parseLong(o[0].toString());
				String sortName = o[1].toString();
				categoryList.add(new Category(sortID, sortName));
			}

		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtility.closeSession();

		return categoryList;
	}

}
