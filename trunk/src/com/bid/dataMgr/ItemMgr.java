package com.bid.dataMgr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bid.data.Items;
import com.bid.data.Users;
import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;

public class ItemMgr {
	//createItem()


	/**
	 * Query items that have been bidded by a certain person
	 * @param userName
	 * @return
	 */
	public List<ItemDigest> queryBiddedItems(String userName){
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemHighestBidUserName = " + userName;
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = null;// = item.getItemAvailableSeconds();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
	}
	
	/**
	 * Query all items
	 * @return
	 */
	public List<ItemDigest> queryItemDigests(){
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = null;// = item.getItemAvailableSeconds();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
	}

	
	/**
	 * Query all items
	 * @return
	 */
	public List<Item> queryItems(){
		List<Item> queryResult = new ArrayList<Item>();
		String SQLQuery = "select * from items";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			/*queryResult.add(new Item(item.getItemId(), item.getItemName(),
					item.getItemDes(), item.getItemFlourPrice().doubleValue(),
					item.getSortId(), item.getPostUser(), item.getItemBidDeadline()));*/
		}
		return queryResult;
	}

	/**
	 * Query the recently posted items 
	 * with the price between <b>from<b> to <b>to<b>
	 * @param from 
	 * @param to
	 * @return
	 */
	public List<ItemDigest> queryLatestItems(long from, long to){
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where";/**----------------���ǻ������ľ�ʾ��-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = null;// = item.getItemAvailableSeconds();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Query the recently posted items of the category <b>categoryId<b>
	 * with the price between <b>from<b> to <b>to<b>
	 * @param from
	 * @param to
	 * @param categoryId
	 * @return
	 */
	public List<ItemDigest> queryLatestItems( long from, long to, long categoryId ){
		return null;
	}

	/**
	 * Query the items going to be obsolete
	 * with the price between <b>from<b> to <b>to<b>
	 * @param from
	 * @param to
	 * @return
	 */
	public List<ItemDigest> queryDyingItems(long from, long to){
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items";
		List<Items> detailList = this.execSQLQuery(SQLQuery);/**----------------���ǻ������ľ�ʾ��2-----------------------------------*/
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = null;// = item.getItemAvailableSeconds();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
	}
	
	/**
	 * Query the items going to be obsolete of the category <b>categoryId<b>
	 * with the price between <b>from<b> to <b>to<b>
	 * @param from
	 * @param to
	 * @param categoryId
	 * @return
	 */
	public List<ItemDigest> queryDyingItems( long from, long to, long categoryId ){
		return null;/**----------------���ǻ������ľ�ʾ��3-----------------------------------*/
	}

	/**
	 * Add new item to the database
	 * @param thisItem
	 * @return
	 */
	public boolean addItem(Item thisItem){
		boolean flag;
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction();
			/*Items saveItem = new Items(itemId, itemName, itemDes,
					 itemBidRule, itemFlourPrice, itemHighestBidprice,
					 itemHighestBidUserName, itmeStatus,
					 itemCargoName, itmeCargoId, sortId, 
					 postUser, imageUrl, itemBidDeadline, 
					 itemPostTimestamp);
			s.saveOrUpdate(saveItem);*/
			HibernateUtility.commitTransaction();
			}
		catch (HibernateException e) {
			HibernateUtility.commitTransaction();  
			e.printStackTrace(); 
			log.fatal(e);
			flag = false;
			}
		HibernateUtility.closeSession();
		return true;
	}

	/**
	 * Update the delivery information
	 * @param itemId
	 * @param receiptId
	 * @return
	 */
	public boolean updateDelivery(long itemId, long receiptId){
		return false;
	}

	/**
	 * Update the receipt information
	 * @param itemId
	 * @return
	 */
	public boolean updateReceipt(long itemId){
		return false;
	}

	/**
	 * Query the item information by the give item id <b>itemId<b> 
	 * @param itemId
	 * @return
	 */
	public Item queryItem(long itemId){
		return null;
	}

	/**
	 * Query the current price (i.e. the highest bid price) of item <b>itemId<b>
	 * @param itemId
	 * @return
	 */
	public double/*(curPrice)*/ queryCurPrice(long itemId){
		return 0;
	}

	/**
	 * 
	 * @param userName
	 * @param offerMoney
	 * @return
	 */
	public double /*Money*/ queryTransferPrice(String userName, double offerMoney){
		return 0;
	}

	/**
	 * 
	 * @param userName
	 * @param offerMoney
	 * @return
	 */
	public double /*Money*/ transferPrice(String userName, double offerMoney){
		return 0;
	}

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public Map<String /*user*/, Double/*money*/> queryReturnMoney(long itemId) {
		return null;
	}

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public boolean isAlive(long itemId) {
		Session s = HibernateUtility.currentSession();
		boolean returnValue = false;
		try {
			HibernateUtility.beginTransaction();
			Items items = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();

			if (items == null)
				returnValue = false;
			else if (!(items.getItemBidDeadline().after(new Date())))
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
	
	private List execSQLQuery(String SQLQuery){
		Session s = HibernateUtility.currentSession();  
		ArrayList<Items> queryResult = new ArrayList<Items>();
		try {
			HibernateUtility.beginTransaction(); 
			List itemsList = s.createSQLQuery(SQLQuery).list();
			HibernateUtility.commitTransaction();
			for(Object obj : itemsList){
				int itemId = (Integer)(((Object[])obj)[0]);
				String itemName = (((Object[])obj)[1]).toString();
				String itemDes = (((Object[])obj)[2]).toString();
				String itemBidRule = (((Object[])obj)[3]).toString();
				Double itemFlourPrice = (Double)(((Object[])obj)[4]);
				Integer itemAvailableSeconds = (Integer)(((Object[])obj)[5]);
				int sortId = (Integer)(((Object[])obj)[6]);
				String postUser = (((Object[])obj)[7]).toString();
				String imageUrl = (((Object[])obj)[8]).toString();
				Double itemHighestBidprice = (Double)(((Object[])obj)[9]);
				String itemHighestBidUserName = (((Object[])obj)[10]).toString();
				Integer itmeStatus = (Integer)(((Object[])obj)[11]);
				String itemCargoName = (((Object[])obj)[12]).toString();
				Integer itmeCargoId = (Integer)(((Object[])obj)[13]);
				Date itemBidDeadline = (Date)(((Object[])obj)[14]);
				Date itemPostTimestamp = (Date)(((Object[])obj)[15]);
				queryResult.add(new Items(itemId, itemName, itemDes,
						 itemBidRule, itemFlourPrice, itemHighestBidprice,
						 itemHighestBidUserName, itmeStatus,
						 itemCargoName, itmeCargoId, sortId, 
						 postUser, imageUrl, itemBidDeadline, 
						 itemPostTimestamp));
				}
			} catch (HibernateException e) { 
				HibernateUtility.commitTransaction();
				e.printStackTrace();
				log.fatal(e);
			}
			HibernateUtility.closeSession(); 
			return queryResult; 
	}
	private static Log log = LogFactory.getLog(UserMgr.class);
}