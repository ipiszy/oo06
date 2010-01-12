package com.bid.dataMgr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bid.data.Items;
import com.bid.data.Sorts;
import com.bid.exchange.Category;

public class CategoryMgr {

	private static Log log = LogFactory.getLog(CategoryMgr.class);
	private int categoryCnt = 0;
	
	public CategoryMgr(){
		categoryCnt  = this.getAllCategories().size();
	}
	
	public long addCategory(String sortName){
		Session s = HibernateUtility.currentSession();
		long returnValue = -1;
		try {
			//public Sorts(String sortName, Set<Items> itemses)
			Sorts sort = new Sorts(sortName, new HashSet<Items>());
			HibernateUtility.beginTransaction();
			s.saveOrUpdate(sort);
			HibernateUtility.commitTransaction();
			categoryCnt++;
			returnValue = categoryCnt;

		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}

		HibernateUtility.closeSession();
		return returnValue;
	}

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
