package com.bid.dataMgr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.bid.data.Deposits;
import com.bid.data.DepositsId;
import com.bid.data.Items;
import com.bid.data.Sorts;
import com.bid.data.Users;
import com.bid.exchange.Category;
import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;
import com.bid.exchange.UserInfo;

public class ItemMgr {
	// createItem()

	/**
	 * Query items that have been bidded by a certain person
	 * 
	 * @param userName
	 * @return
	 */
	public List<ItemDigest> queryBiddingItems(String userName) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemHighestBidUserName = '"
				+ userName + "' and itemStatus = '" + Item.ONBID+"'";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Query items that have been bidded by a certain person
	 * 
	 * @param userName
	 * @return
	 */
	public List<ItemDigest> queryBiddedItems(String userName) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemHighestBidUserName = '"
				+ userName + "' and itemStatus != '" + Item.ONBID+"'";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * For seller, query all the items on sale
	 */
	public List<ItemDigest> sellerQueryOnSaleItems(String userName) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where postUser = '"
				+ userName + "' and itemStatus = '" + Item.ONBID+"'";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}
	
	
	/**
	 * for the seller, query all item sold
	 * 
	 */
	public List<ItemDigest> sellerQuerySoldItems(String userName) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where postUser = '"
				+ userName + "' and itemStatus != '" + Item.ONBID+"' and itemHighestBidUserName != 'none'";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}
	
	/**
	 * for the seller, query all the items he/she is unable to sell it out 
	 */
	
	public List<ItemDigest> sellerQueryFailItems(String userName) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where postUser = '"
				+ userName + "' and itemStatus != '" + Item.ONBID+"' and itemHighestBidUserName = 'none'";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}
	
	
	
	/**
	 * Query all item digests
	 * 
	 * @return
	 */
	public List<ItemDigest> queryItemDigests() {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Query all items
	 * 
	 * @return
	 */
	public List<Item> queryItems() {
		List<Item> queryResult = new ArrayList<Item>();
		String SQLQuery = "select * from items";
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			queryResult.add(new Item((long) item.getItemId(), item
					.getItemName(), item.getItemDes(), item.getItemFloorPrice()
					.doubleValue(), item.getSorts().getSortId(), item.getUsersByPostUser().getUserName(), item
					.getItemBidDeadLine(), item.getItemHighestBidPrice(), item
					.getUsersByItemHighestBidUserName().getUserName(), 0, item.getItemStatus(), item
					.getImageUrl(), item.getItemPostTimestamp()));
		}
		return queryResult;
	}

	/**
	 * Query the recently posted items with the sequence number between
	 * <b>from<b> to <b>to<b>
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public List<ItemDigest> queryLatestItems(long from, long to) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemStatus = '"
				+ Item.ONBID + "' order by itemPostTimestamp desc limit "
				+ from + ", " + (to - from);
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Query the recently posted items of the category <b>categoryId<b> with the
	 * sequence number between <b>from<b> to <b>to<b>
	 * 
	 * @param from
	 * @param to
	 * @param categoryId
	 * @return
	 */
	public List<ItemDigest> queryLatestItems(long from, long to, long categoryId) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemStatus = '"
				+ Item.ONBID + "' and sortID = " + categoryId
				+ " order by itemPostTimestamp desc limit " + from + ", "
				+ (to - from);

		// "SELECT   TOP   "+ (to- from) +"   *   FROM   "+
		// "(select * from items where categoryId = " + categoryId + ")" +
		// "postTimestamp" +
		// "   IN   (SELECT   TOP   " + from
		// +"    postTimestamp   FROM   items   " +
		// "ORDER   BY   postTimestamp   ASC)   ORDER   BY   postTimestamp   DESC";/**----------------我是华丽丽的警示线-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Query the items going to be obsolete with the sequence number between
	 * <b>from<b> to <b>to<b>
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public List<ItemDigest> queryDyingItems(long from, long to) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemStatus = '"
				+ Item.ONBID + "' order by itemBidDeadline asc limit "
				+ from + ", " + (to - from);

		// "SELECT   TOP   "+ (to- from)
		// +"   *   FROM   items   WHERE   itemBidDeadline" +
		// "   IN   (SELECT   TOP   " + from
		// +"    itemBidDeadline   FROM   items   " +
		// "ORDER   BY   itemBidDeadline   ASC)   ORDER   BY   itemBidDeadline   DESC";/**----------------我是华丽丽的警示线-----------------------------------*/
		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Query the items going to be obsolete of the category <b>categoryId<b>
	 * with the sequence number between <b>from<b> to <b>to<b>
	 * 
	 * @param from
	 * @param to
	 * @param categoryId
	 * @return
	 */
	public List<ItemDigest> queryDyingItems(long from, long to, long categoryId) {
		List<ItemDigest> queryResult = new ArrayList<ItemDigest>();
		String SQLQuery = "select * from items where itemStatus = '"
				+ Item.ONBID + "' and sortID = " + categoryId
				+ " order by itemBidDeadline asc limit " + from + ", "
				+ (to - from);

		List<Items> detailList = this.execSQLQuery(SQLQuery);
		for (Items item : detailList) {
			String imageURL = item.getImageUrl();
			String name = item.getItemName();
			double basePrice = item.getItemFloorPrice();
			double latestPrice = item.getItemHighestBidPrice();
			Date d = item.getItemBidDeadLine();
			long itemId = item.getItemId();
			queryResult.add(new ItemDigest(itemId, imageURL, name, basePrice,
					latestPrice, d));
		}
		return queryResult;
	}

	/**
	 * Add new item to the database
	 * 
	 * @param thisItem
	 * @return
	 */
	public boolean addItem(Item thisItem) {
		boolean flag = false;
		Session s = HibernateUtility.currentSession();
		try {
			//先获得需要的users以及category
			Users bidUser = null, postUser = null;
			Sorts sort;
			Set<Deposits> deposits = new HashSet<Deposits>();
			if(thisItem.getItemHighestBidUserName() != null){
				HibernateUtility.beginTransaction();
				bidUser = (Users) s.get(Users.class, thisItem.getItemHighestBidUserName());
				HibernateUtility.commitTransaction();
			}
			if(thisItem.getPostUserName() != null){
				HibernateUtility.beginTransaction();
				postUser = (Users) s.get(Users.class, thisItem.getPostUserName());
				HibernateUtility.commitTransaction();
			}
			HibernateUtility.beginTransaction();
			sort = (Sorts) s.get(Sorts.class, thisItem.getSortID());
			HibernateUtility.commitTransaction();
			HibernateUtility.beginTransaction();
			//Items(Users usersByItemHighestBidUserName, Users usersByPostUser,
			//Sorts sorts, String itemName, String itemDes, String itemBidRule,
			//Double itemFloorPrice, Double itemHighestBidPrice,
			//String itemStatux, String itemCargoName, Long itemCargoId,
			//String imageUrl, Date itemBidDeadLine, Date itemPostTimestamp,
			//Set<Deposits> depositses)
			Items saveItem = new Items(bidUser, postUser, sort, thisItem.getItemName(),
					thisItem.getItemDes(), null, thisItem.getItemFloorPrice(),
					thisItem.getItemHighestBidPrice(), Item.ONBID, thisItem
							.getItemCargoName(), thisItem.getItemCargoID(),
					thisItem.getImageURL(), thisItem.getItemBidDeadline(),
					thisItem.getItemPostTimestamp(), deposits);
			s.saveOrUpdate(saveItem);
			HibernateUtility.commitTransaction();
			flag = true;
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}
		HibernateUtility.closeSession();
		return flag;
	}

	/**
	 * Update the delivery information
	 * 
	 * @param itemId
	 * @param receiptId
	 * @return
	 */
	public boolean updateDelivery(long itemId, long receiptId, String cargoCmp) {
		/** -------有错-------- */
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();

			if(item == null)
				return false;

			HibernateUtility.beginTransaction();
			item.setItemStatus(Item.ONDELIVER);
			item.setItemCargoId(receiptId);
			/** -----id有错 */
			item.setItemCargoName(cargoCmp);			
			s.saveOrUpdate(item);
			HibernateUtility.commitTransaction();
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
	 * 
	 * @param itemId
	 * @return
	 */
	public boolean updateReceipt(long itemId) {
		Session s = HibernateUtility.currentSession();
		try {
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			
			if(item == null)
				return false;

			HibernateUtility.beginTransaction();
			item.setItemStatus(Item.DELIVERED);
			s.saveOrUpdate(item);
			HibernateUtility.commitTransaction();
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
	 * 
	 * @param itemId
	 * @return
	 */
	public Item queryItem(long itemId) {
		Session s = HibernateUtility.currentSession();
		Item thisItem = null;
		try {
			HibernateUtility.beginTransaction();
			Items item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			Users bidUser, postUser;
			Sorts sort;
			Set<Deposits> deposits = new HashSet<Deposits>();
			HibernateUtility.beginTransaction();
			bidUser = (Users) s.get(
					Users.class, 
					item.getUsersByItemHighestBidUserName().getUserName());
			HibernateUtility.commitTransaction();
			HibernateUtility.beginTransaction();
			postUser = (Users) s.get(Users.class, item.getUsersByPostUser().getUserName());
			HibernateUtility.commitTransaction();
			HibernateUtility.beginTransaction();
			sort = (Sorts) s.get(Sorts.class, item.getSorts().getSortId());
			HibernateUtility.commitTransaction();
			HibernateUtility.beginTransaction();
			/** itemId 类型错 */
			//Item(long itemid, String itemname, String des, 
			//double floorprice, long sortId, String postUserName, Date deadline,
			//double highestBidPrice, String highestBidUserName, 
			//int itemBidRule, String itemStatus, String imageURL,
			//Date postTimestamp
			//)
			thisItem = new Item(item.getItemId(), item.getItemName(), item.getItemDes(),
					item.getItemFloorPrice(), item.getSorts().getSortId(), item.getUsersByPostUser().getUserName(),
					item.getItemBidDeadLine(), item.getItemHighestBidPrice(), 
					item.getUsersByItemHighestBidUserName().getUserName(),
					0, item.getItemStatus(), item.getImageUrl(), item.getItemPostTimestamp());
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
		return thisItem;
	}

	/**
	 * Query the current price (i.e. the highest bid price) of item <b>itemId<b>
	 * 
	 * @param itemId
	 * @return
	 */
	public double/* (curPrice) */queryCurPrice(long itemId) {
		Session s = HibernateUtility.currentSession();
		double curPrice = -1;
		try {
			HibernateUtility.beginTransaction();
			Items items = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			curPrice = items.getItemHighestBidPrice();
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
	// public double /*Money*/ queryTransferPrice(String userName, double
	// offerMoney){
	// return 0;
	// }

	/**
	 * 
	 * @param userName
	 * @param offerMoney
	 * @return
	 */
	// public double /*Money*/ transferPrice(String userName, double
	// offerMoney){
	// return 0;
	// }

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	public Map<String /* user */, Double/* money */> queryReturnMoney(long itemId) {
		Session s = HibernateUtility.currentSession();
		Map<String, Double> queryResult = new HashMap<String, Double>();
		try {
			HibernateUtility.beginTransaction();
			List depositsList = s.createSQLQuery(
					"select userName, moneyFrozen from Deposits where itemId = "
							+ itemId).list();
			HibernateUtility.commitTransaction();
			for (Object obj : depositsList) {
				String userName = (((Object[]) obj)[0]).toString();
				Double moneyFrozen = (Double) (((Object[]) obj)[1]);
				queryResult.put(userName, moneyFrozen);
			}
		} catch (HibernateException e) {
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
			else if (!(items.getItemBidDeadLine().before(new Date())))
				returnValue = true;
			else
				returnValue = false;

			returnValue = returnValue && (items.getItemStatus() == Item.ONBID);

		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			log.fatal(e);
			returnValue = false;
		}
		HibernateUtility.closeSession();
		return returnValue;
	}

	private List execSQLQuery(String SQLQuery) {
		Session s = HibernateUtility.currentSession();
		List<Items> queryResult = new ArrayList<Items>();
		try {
			HibernateUtility.beginTransaction();
			List itemsList = s.createSQLQuery(SQLQuery).list();
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
				String itmeStatus = (String) (((Object[]) obj)[7]);
				String itemCargoName;
				if(((Object[]) obj)[8] == null)
					itemCargoName = null;
				else
					itemCargoName = (((Object[]) obj)[8]).toString();
				long itmeCargoId = ((BigInteger) (((Object[]) obj)[9])).longValue();
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
				queryResult.add(new Items(bidUser, postUser, sort, itemName,
						itemDes, null, itemFloorPrice,
						itemHighestBidprice, Item.ONBID, itemCargoName,
						itmeCargoId, imageUrl, itemBidDeadline,
						itemPostTimestamp, deposits));
			}
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
		}
		HibernateUtility.closeSession();
		return queryResult;
	}

	public boolean biddedBy(long itemId, String userName, double money) {

		boolean flag = false;
		Session s = HibernateUtility.currentSession();
		try {
			Users user;
			Items item;
			HibernateUtility.beginTransaction();
			user = (Users) s.get(Users.class, userName);
			HibernateUtility.commitTransaction();
			HibernateUtility.beginTransaction();
			item = (Items) s.get(Items.class, itemId);
			HibernateUtility.commitTransaction();
			HibernateUtility.beginTransaction();
			//Deposits(DepositsId id, Users users, Items items, Double moneyFrozen)
			Deposits saveDep = new Deposits(new DepositsId(itemId, userName), user, item,
					money);
			s.saveOrUpdate(saveDep);
			HibernateUtility.commitTransaction();
			flag = true;
		} catch (HibernateException e) {
			HibernateUtility.commitTransaction();
			e.printStackTrace();
			log.fatal(e);
			flag = false;
		}
		HibernateUtility.closeSession();
		return flag;
	}

	private static Log log = LogFactory.getLog(UserMgr.class);
}
