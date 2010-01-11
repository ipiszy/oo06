package com.bid.dataMgr;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
	
	public ItemMgr(){
		itemCnt = 0;
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction(); 
			List idList = s.createSQLQuery("SELECT COUNT(itemId) FROM items").list();
			HibernateUtility.commitTransaction();
			for(Object obj : idList){
				itemCnt = (Integer)(((Object[])obj)[0]);
			}
		}
		catch (HibernateException e) { 
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
	}


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
			Date d = item.getItemBidDeadline();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
	}
	
	/**
	 * Query all item digests
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
			Date d = item.getItemBidDeadline();
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
			queryResult.add(new Item((long)item.getItemId(), item.getItemName(),
					item.getItemDes(), item.getItemFlourPrice().doubleValue(),
					item.getSortId(), item.getPostUser(), item.getItemBidDeadline(), 
					item.getItemHighestBidprice(),
					item.getItemHighestBidUserName(), 
					0, item.getItemStatus(),  item.getImageUrl(),
					item.getItemPostTimestamp()));
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
		String SQLQuery =
			"SELECT   TOP   "+ (from - to) +"   *   FROM   items   WHERE   postTimestamp" +
			"   IN   (SELECT   TOP   " + from +"    postTimestamp   FROM   items   " +
			"ORDER   BY   postTimestamp   ASC)   ORDER   BY   postTimestamp   DESC";/**----------------我是华丽丽的警示线-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = item.getItemBidDeadline();
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
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery =
			"SELECT   TOP   "+ (from - to) +"   *   FROM   "+
			"(select * from items where categoryId = " + categoryId + ")" +
			"postTimestamp" +
			"   IN   (SELECT   TOP   " + from +"    postTimestamp   FROM   items   " +
			"ORDER   BY   postTimestamp   ASC)   ORDER   BY   postTimestamp   DESC";/**----------------我是华丽丽的警示线-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = item.getItemBidDeadline();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
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
		String SQLQuery =
			"SELECT   TOP   "+ (from - to) +"   *   FROM   items   WHERE   itemBidDeadline" +
			"   IN   (SELECT   TOP   " + from +"    itemBidDeadline   FROM   items   " +
			"ORDER   BY   itemBidDeadline   ASC)   ORDER   BY   itemBidDeadline   DESC";/**----------------我是华丽丽的警示线-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = item.getItemBidDeadline();
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
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery =
			"SELECT   TOP   "+ (from - to) +"   *   FROM   "+
			"(select * from items where categoryId = " + categoryId + ")" +
			" itemBidDeadline" +
			"   IN   (SELECT   TOP   " + from +"    itemBidDeadline   FROM   items   " +
			"ORDER   BY   itemBidDeadline   ASC)   ORDER   BY   itemBidDeadline   DESC";/**----------------我是华丽丽的警示线-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for(Items item : detailList){
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFlourPrice();
			double latestPrice = item.getItemHighestBidprice();
			Date d = item.getItemBidDeadline();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice, latestPrice, d));
		}
		return queryResult;
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
			//itemId由后台统一发放
			long itemId = itemCnt + 1;/**---------------我是警示线，id是int型-----------------------------*/
			Items saveItem = new Items((int) itemId, thisItem.getItemName(),
					thisItem.getItemDes(),
					null, thisItem.getItemFloorPrice(),
					thisItem.getItemHighestBidPrice(),
					thisItem.getItemHighestBidUserName(),
					Item.ONBID,
					thisItem.getItemCargoName(),
					thisItem.getItemCargoID(),
					thisItem.getSortID(),
					thisItem.getPostUserName(),
					thisItem.getImageURL(),
					thisItem.getItemBidDeadline(),
					thisItem.getItemPostTimestamp());
			s.saveOrUpdate(saveItem);
			HibernateUtility.commitTransaction();
			itemCnt++;
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
	public boolean updateDelivery(long itemId, long receiptId, String cargoCmp){/**-------有错--------*/
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			item.setItemStatus(Item.ONDELIVER);
			item.setItmeCargoId((int)receiptId);/**-----id有错*/
			item.setItemCargoName(cargoCmp);
			} catch (HibernateException e) {
				HibernateUtility.commitTransaction();
				log.fatal(e);
				return false;
		}
		HibernateUtility.closeSession();
		return true;
	}

	/**
	 * Update the receipt information
	 * @param itemId
	 * @return
	 */
	public boolean updateReceipt(long itemId){
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			item.setItemStatus(Item.DELIVERED);
			} catch (HibernateException e) {
				HibernateUtility.commitTransaction();
				log.fatal(e);
				return false;
		}
		HibernateUtility.closeSession();
		return true;
	}

	/**
	 * Query the item information by the give item id <b>itemId<b> 
	 * @param itemId
	 * @return
	 */
	public Item queryItem(long itemId){
		Session s = HibernateUtility.currentSession();
		Item thisItem = null;
		try {
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();/**itemId 类型错*/
			thisItem = new Item((int)itemId, item.getItemName(),
					item.getItemDes(), item.getItemFlourPrice(),
					item.getSortId(), item.getPostUser(),
					item.getItemBidDeadline(),
					item.getItemHighestBidprice(),
					item.getItemHighestBidUserName(),
					0, Item.ONBID, item.getImageUrl(),
					item.getItemPostTimestamp());
			} catch (HibernateException e) {
				HibernateUtility.commitTransaction();
				log.fatal(e);
				}
			HibernateUtility.closeSession();
			return thisItem;
		}

	/**
	 * Query the current price (i.e. the highest bid price) of item <b>itemId<b>
	 * @param itemId
	 * @return
	 */
	public double/*(curPrice)*/ queryCurPrice(long itemId){
		Session s = HibernateUtility.currentSession();
		double curPrice = -1;
		try {
			HibernateUtility.beginTransaction();
			Items items = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			curPrice = items.getItemHighestBidprice();
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
		return curPrice;
	}

	/**
	 * 
	 * @param userName
	 * @param offerMoney
	 * @return
	 */
//	public double /*Money*/ queryTransferPrice(String userName, double offerMoney){
//		return 0;
//	}

	/**
	 * 
	 * @param userName
	 * @param offerMoney
	 * @return
	 */
//	public double /*Money*/ transferPrice(String userName, double offerMoney){
//		return 0;
//	}

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public Map<String /*user*/, Double/*money*/> queryReturnMoney(long itemId) {
		Session s = HibernateUtility.currentSession();
		Map<String, Double> queryResult = new HashMap<String, Double>();
		try {
			HibernateUtility.beginTransaction(); 
			List depositsList = s.createSQLQuery("select userName, moneyFrozen from Deposits where itemId = " + itemId).list();
			HibernateUtility.commitTransaction();
			for(Object obj : depositsList){
				String userName = (((Object[])obj)[0]).toString();
				Double moneyFrozen = (Double)(((Object[])obj)[1]);
				queryResult.put(userName, moneyFrozen);
			}
		}
		catch (HibernateException e) { 
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
		return queryResult;
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
			
			returnValue = returnValue & (items.getItemStatus() == Item.ONBID);

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
		List<Items> queryResult = new ArrayList<Items>();
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
				int sortId = (Integer)(((Object[])obj)[5]);
				String postUser = (((Object[])obj)[6]).toString();
				String imageUrl = (((Object[])obj)[7]).toString();
				Double itemHighestBidprice = (Double)(((Object[])obj)[8]);
				String itemHighestBidUserName = (((Object[])obj)[9]).toString();
				Integer itmeStatus = (Integer)(((Object[])obj)[10]);
				String itemCargoName = (((Object[])obj)[11]).toString();
				Integer itmeCargoId = (Integer)(((Object[])obj)[12]);
				Date itemBidDeadline = (Date)(((Object[])obj)[13]);
				Date itemPostTimestamp = (Date)(((Object[])obj)[14]);
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
	private long itemCnt = 0;
}
