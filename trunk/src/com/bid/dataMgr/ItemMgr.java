package com.bid.dataMgr;

import java.util.List;
import java.util.Map;

import com.bid.data.Item;
import com.bid.data.ItemDigest;

public class ItemMgr {
	//createItem()


	// what does this method do?
	public List<ItemDigest> queryBiddedItems(){
		return null;
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
	public boolean addItem(Item thisItem){
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
		// TODO Auto-generated method stub
		return false;
	}
}
