package com.bid.dataMgr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bid.data.Deposits;
import com.bid.data.Items;
import com.bid.data.Sorts;
import com.bid.data.Users;
import com.bid.exchange.Item;

public class TimerMgr {
	
	public boolean registerDeadline(Date deadline, final long itemId){
		final Timer thisTimer = new Timer();
		TimerTask tt = new TimerTask(){
			Boolean notRepeats = true;
			public void run() {
				doCleaning(itemId);
				if(true) thisTimer.cancel();				
			}};
		long cmpValue = deadline.getTime() - (new Date()).getTime();
		if(cmpValue <= 0) return false;
		thisTimer.schedule(tt, cmpValue);
		return true;
	}
	
	public void startUp(){
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction();
			List itemsList = s.createSQLQuery("select * from items").list();
			HibernateUtility.commitTransaction();
			for (Object obj : itemsList) {
				long itemId = ((BigInteger) (((Object[]) obj)[0])).longValue();
				String itemName = (((Object[]) obj)[1]).toString();
				String itemDes = (((Object[]) obj)[2]).toString();
				String itemBidRule;
				if(((Object[]) obj)[3] == null)
					itemBidRule = null;
				else
					itemBidRule = (((Object[]) obj)[3]).toString();
				Double itemFloorPrice = (Double) (((Object[]) obj)[4]);
				Double itemHighestBidprice = (Double) (((Object[]) obj)[5]);
				String itemHighestBidUserName = (((Object[]) obj)[6])
						.toString();
				String itemStatus = (String) (((Object[]) obj)[7]);
				String itemCargoName;
				if(((Object[]) obj)[8] == null)
					itemCargoName = null;
				else
					itemCargoName = (((Object[]) obj)[8]).toString();
				
				long itmeCargoId = 0;
				if(((Object[]) obj)[8] != null)
					itmeCargoId = ((BigInteger) (((Object[]) obj)[9])).longValue();
				
				long sortId = ((BigInteger) (((Object[]) obj)[10])).longValue();
				String postUserName;
				if(((Object[]) obj)[11] == null)
					postUserName = null;
				else
					postUserName = (((Object[]) obj)[11]).toString();
				String imageUrl;
				if(((Object[]) obj)[12] == null)
					imageUrl = null;
				else
					imageUrl = (((Object[]) obj)[12]).toString();
				Date itemBidDeadline = (Date) (((Object[]) obj)[13]);
				Date itemPostTimestamp = (Date) (((Object[]) obj)[14]);
				Users bidUser, postUser;
				Sorts sort;
				Set<Deposits> deposits = new HashSet<Deposits>();
				HibernateUtility.beginTransaction();
				bidUser = (Users) s.get(Users.class, itemHighestBidUserName);
				HibernateUtility.commitTransaction();
				HibernateUtility.beginTransaction();
				postUser = (Users) s.get(Users.class, postUserName);
				HibernateUtility.commitTransaction();
				HibernateUtility.beginTransaction();
				sort = (Sorts) s.get(Sorts.class, sortId);
				HibernateUtility.commitTransaction();
				Items newItem = new Items(bidUser, postUser, sort, itemName,
						itemDes, null, itemFloorPrice,
						itemHighestBidprice, itemStatus, itemCargoName,
						itmeCargoId, imageUrl, itemBidDeadline,
						itemPostTimestamp, deposits);
				newItem.setItemId(itemId);
				
				Date now = new Date();
				if(itemBidDeadline.after(now))
					this.registerDeadline(itemBidDeadline, itemId);
				else if(itemStatus == Item.ONBID)
				{
					//如果发现它过时了&&它的标志还是没有过时的标志
					newItem.setItemStatus(Item.OBSOLETE);
					HibernateUtility.beginTransaction();
					s.update(newItem);
					HibernateUtility.commitTransaction();
				}
			}
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
	}
	
	private void doCleaning(long itemId){
		Session s = HibernateUtility.currentSession();
		try {
			//1修改状态
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			item.setItemStatus(Item.OBSOLETE);
			HibernateUtility.beginTransaction();
			s.saveOrUpdate(item);
			HibernateUtility.commitTransaction();
			//2还钱
			HibernateUtility.beginTransaction();
			List depositsList = s.createSQLQuery(
					"select userName, moneyFrozen from Deposits where itemId = "
								+ itemId).list();
			HibernateUtility.commitTransaction();
			
			UserMgr userMgr = new UserMgr();
			for (Object obj : depositsList) {
				String userName = (((Object[]) obj)[0]).toString();
				Double moneyFrozen = (Double) (((Object[]) obj)[1]);
				userMgr.transfer(userName, moneyFrozen, itemId);
			}
		}
		catch (HibernateException e){
			HibernateUtility.commitTransaction();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
	}
	
	private static Log log = LogFactory.getLog(UserMgr.class);
}
