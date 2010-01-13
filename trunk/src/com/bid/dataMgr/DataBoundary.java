package com.bid.dataMgr;

import java.util.List;
import java.util.Map;

import com.bid.exchange.Category;
import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;
import com.bid.exchange.UserInfo;

public class DataBoundary {
	
	public DataBoundary(){
		itemMgr = new ItemMgr();
		userMgr = new UserMgr();
		categoryMgr = new CategoryMgr();
	}
	
	public long addCategory(String categoryName){
		return (categoryMgr.addCategory(categoryName));
	}
	
	public List<ItemDigest> queryBiddingItems(String userName){
		return (itemMgr.queryBiddingItems(userName));
	}
	
	
	public List<ItemDigest> queryItemsBought(String userName){
		return (itemMgr.queryItemsBought(userName));
	}
	
	public List<ItemDigest> queryItemsBidded(String userName){
		return (itemMgr.queryItemsBidded(userName));
	}
	
	public Item getItem(long itemId){
		Item thisItem = itemMgr.queryItem(itemId);
		return thisItem;
		
	}
	
	public UserInfo getUser(String userName){
		return (userMgr.getUser(userName));
	}

	/**
	 *	输入：用户的唯一标示，用户的密码
	 *	输出：用户是否登录成功
	 *	作用：浏览器端和服务器端都知道用户进入登录状态
	 */
	public boolean login(String userName, String psw){
		boolean logined = this.isUserValid(userName, psw);
		
		return logined;
	}

	/**
	 *	输入：用户的信息
	 *	输出：用户是否注册成功 
	 *	作用：服务器端增加一个用户
	 */
	public boolean register(UserInfo userInfo){
		if(!userMgr.hasUser(userInfo.getUserName())){
			userMgr.addUser(userInfo);
			return true;
		}
		
		return false;
	}

	/**
	 *	输入：货品的详细资料
	 *	输出：货品是否提交成功
	 */
	public boolean submitItem(Item thisItem){
		return (itemMgr.addItem(thisItem));
	}

	/**
	 * 	输入：货品的唯一标示、货品的货单号
	 * 	输出：无
	 * 	作用：浏览器端和服务器端都知道货品已发出
	 */
	public boolean confirmDelivery(long itemId, long receiptId, String cargoCmp){
		return (itemMgr.updateDelivery(itemId, receiptId, cargoCmp));
	}
	
	/**
	 * 	输入：货品的唯一标示、货品的货单号
	 * 	输出：无
	 * 	作用：浏览器端和服务器端都知道货品已收到
	 */
	public boolean confirmReceipt(long itemId){
		return (itemMgr.updateReceipt(itemId));
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
			curPrice = itemMgr.queryCurPrice(itemId);
		
		return curPrice;
	}
	
	/**
	 * 作用：给某个用户的账号上充值
	 */
	public boolean charge(double money, String userName){
		return (userMgr.charge(userName, money));
	}

	/**
	 *	作用：服务器和客户器端都知道某一位用户为某一个商品出了一个价格 
	 */	
	public boolean  offerPrice(double money, long itemId, String userName){
		//1把出价的用户与其货品之间的关系绑定
		//2从用户的账面上扣去某个(差额)金额
		//0计算差额
		double deltaMoney;
		Map<String, Double> bidUsers = itemMgr.queryReturnMoney(itemId);
		if(bidUsers.containsKey(userName))
			deltaMoney = -money + bidUsers.get(userName);
		else
			deltaMoney = -money;
		boolean offered = userMgr.transfer(userName, deltaMoney, itemId);
		if(offered)
			itemMgr.biddedBy(itemId, userName, money);
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
	
	public List<ItemDigest> getDyingItems ( long from, long to, long categoryId ) {
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
		return userMgr.isValid(userName, psw);
	}
	
	private ItemMgr itemMgr;
	private UserMgr userMgr;
	private CategoryMgr categoryMgr;

}
