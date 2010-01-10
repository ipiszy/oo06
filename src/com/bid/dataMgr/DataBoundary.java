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
		categoryMgr = new CategoryMgr();
	}

	public void startUp(){
		
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

	/**
	 *	输入：用户的唯一标示，用户的密码
	 *	输出：用户是否登录成功
	 *	作用：浏览器端和服务器端都知道用户进入登录状态
	 */
	public boolean login(String userName, String psw){
		if(this.isUserValid(userName, psw))
			userMgr.login(userName);
		
		return false;
	}

	/**
	 *	输入：用户的信息
	 *	输出：用户是否注册成功 
	 *	作用：服务器端增加一个用户
	 */
	public boolean register(UserInfo userInfo){
		if(!userMgr.hasUser(userInfo.userName)){
			userMgr.addUser(userInfo);
		}
		
		return false;
	}

	/**
	 *	输入： 
	 */
	public void requestPostItem(){/**--------------------我是华丽丽的警示线----------------------------------------*/
	}

	/**
	 *	输入：货品的详细资料
	 *	输出：货品是否提交成功
	 */
	public boolean submitItem(Item thisItem){
		boolean isSubmmitted = false;
		if(itemMgr.addItem(thisItem))
			isSubmmitted = timerMgr.registerDeadline(thisItem.getItemId(), thisItem.getTime());
		
		return isSubmmitted;
	}

	/**
	 * 	输入：货品的唯一标示、货品的货单号
	 * 	输出：无
	 * 	作用：浏览器端和服务器端都知道货品已发出
	 */
	public void confirmDelivery(long itemId, long receiptId){
		itemMgr.updateDelivery(itemId, receiptId);
	}
	
	/**
	 * 	输入：货品的唯一标示、货品的货单号
	 * 	输出：无
	 * 	作用：浏览器端和服务器端都知道货品已收到
	 */
	public void confirmReceipt(long itemId){
		itemMgr.updateReceipt(itemId);
	}

	//???receipt password

	//???suicide

	/**
	 *	作用：提供货品的目前价 
	 */
	public double /*curPrice*/ requestBid(long itemId){
		double curPrice = -1;//-1表示出错
		//1检验货品是否存在(optional)
		//2检查货品是否在拍卖时限内
		//3获得当前价格
		if(itemMgr.isAlive(itemId))
			itemMgr.queryCurPrice(itemId);
		
		return curPrice;
	}

	/**
	 *	作用：服务器和客户器端都知道某一位用户为某一个商品出了一个价格 
	 */	
	public boolean  offerPrice(double money, long itemId, String userName){
		//1把出价的用户与其货品之间的关系绑定
		//2从用户的账面上扣去某个(差额)金额
		boolean offered = userMgr.charge(userName, money);
		return offered;
	} 
	
	public List<Category> getCategories(){
		List<Category> cList = null;//null表示出错
		cList = categoryMgr.getAllCategories();
		return cList;
	}
	
	public List<ItemDigest> getDyingItems(long from, long to){
		List<ItemDigest> iList = null;//null表示出错
		iList = itemMgr.queryDyingItems(from, to);
		return iList;
	}
	
	public List<ItemDigest> getDryingItems ( long from, long to, long categoryId ) {
		List<ItemDigest> iList = null;//null表示出错
		iList = itemMgr.queryDyingItems(from, to, categoryId);
		return iList;
	}
	
	public List<ItemDigest> getLatestItems(long from, long to){
		List<ItemDigest> iList = null;//null表示出错
		iList = itemMgr.queryLatestItems(from, to);
		return iList;
	}
	
	public List<ItemDigest> getLatestItems ( long from, long to, long categoryId ) {
		List<ItemDigest> iList = null;//null表示出错
		iList = itemMgr.queryLatestItems(from, to, categoryId);
		return iList;
	}

	private boolean isUserValid(String userName, String psw){
		userMgr.isValid(userName, psw);
		return false;
	}
	
	private ItemMgr itemMgr;
	private UserMgr userMgr;
	private TimerMgr timerMgr;
	private CategoryMgr categoryMgr;
}
