package com.bid.dataMgr;

import java.util.List;
import java.util.Map;

import com.bid.data.Item;
import com.bid.data.ItemDigest;

public class ItemMgr {
	//createItem()

	public List<ItemDigest> queryBiddedItems(){
		return null;
	}

	public List<ItemDigest> queryLatestItems(){
		return null;
	}

	public List<ItemDigest> queryDyingItems(){
		return null;
	}

	public boolean addItem(Item thisItem){
		return false;
	}

	public boolean updateDelivery(long itemId, long receiptId){
		return false;
	}

	public boolean updateReceipt(long itemId){
		return false;
	}

	public Item queryItem(long itemId){
		return null;
	}

	public double/*(curPrice)*/ queryCurPrice(long itemId){
		return 0;
	}

	public double /*Money*/ queryTransferPrice(String userName, double offerMoney){
		return 0;
	}

	public double /*Money*/ transferPrice(String userName, double offerMoney){
		return 0;
	}

	public Map<String /*user*/, Double/*money*/> queryReturnMoney(long itemId) {
		return null;
	}

	public boolean isAlive(long itemId) {
		// TODO Auto-generated method stub
		return false;
	}
}
