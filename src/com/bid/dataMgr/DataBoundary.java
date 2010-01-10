package com.bid.dataMgr;

import java.util.List;

import com.bid.data.Category;
import com.bid.data.Item;
import com.bid.data.ItemDigest;
import com.bid.data.UserInfo;

public class DataBoundary {
	
	public DataBoundary(){
		itemMgr = new ItemMgr();
		userMgr = new UserMgr();
		timerMgr = new TimerMgr();
	}

	/**
	 *  输入：货品的唯一标示
	 *  输出：货品的详细描述
	 */
	public Item getItemInfo(long itemId){
		Item thisItem = null;
		thisItem = itemMgr.queryItem(itemId);
		return thisItem;
	}

	public boolean login(String userName, String psw){
		return false;
	}

	public void register(UserInfo userInfo){
	}

	public void requestPostItem(){
	}

	public void submitItem(){
	}

	public void confirmDelivery(long itemId, long receiptId){
	}

	public void confirmReceipt(long itemId){
	}

	//???receipt password

	//???suicide

	public double /*curPrice*/ requestBid(long itemId){
		return 0;
	}

	public boolean  offerPrice(double money, long itemId){
		return false;
	}

	 

	public boolean charge(double name, String userName) {
		return false;
	}
	
	public List<Category> getCatagories(){
		return null;
	}
	
	public List<ItemDigest> getDyingItems(long from, long to){
		return null;
	}
	
	public List<ItemDigest> getDryingItems ( long from, long to, long categoryId ) {
		return null;
	}
	
	public List<ItemDigest> getLatestItems(long from, long to){
		return null;
	}
	
	public List<ItemDigest> getLatestItems ( long from, long to, long categoryId ) {
		return null;
	}

	private boolean isUserValid(String userName, String psw){
		return false;
	}
	
	private ItemMgr itemMgr;
	private UserMgr userMgr;
	private TimerMgr timerMgr;
}
