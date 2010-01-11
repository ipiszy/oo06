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
			queryResult.add(new Item(item.getItemId(), item.getItemName(),
					item.getItemDes(), item.getItemFlourPrice().doubleValue(),
					item.getSortId(), item.getPostUser(), item.getItemAvailableSeconds().intValue()));
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
		return null;
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
		return null;
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
		return null;
	}

	/**
	 * Add new item to the database
	 * @param thisItem
	 * @return
	 */
	public boolean addItem(Items thisItem){
		return false;
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
	public Items queryItem(long itemId){
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
		// TODO Auto-generated method stub
		return false;
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
				queryResult.add(new Items(itemId, itemName, itemDes,
						 itemBidRule, itemFlourPrice, itemHighestBidprice,
						 itemHighestBidUserName, itmeStatus,
						 itemAvailableSeconds, itemCargoName, itmeCargoId,
						 sortId, postUser, imageUrl));
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
