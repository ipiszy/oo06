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
	 *	���룺�û���Ψһ��ʾ���û�������
	 *	������û��Ƿ��¼�ɹ�
	 *	���ã�������˺ͷ������˶�֪���û������¼״̬
	 */
	public boolean login(String userName, String psw){
		boolean logined = this.isUserValid(userName, psw);
		
		return logined;
	}

	/**
	 *	���룺�û�����Ϣ
	 *	������û��Ƿ�ע��ɹ� 
	 *	���ã�������������һ���û�
	 */
	public boolean register(UserInfo userInfo){
		if(!userMgr.hasUser(userInfo.getUserName())){
			userMgr.addUser(userInfo);
			return true;
		}
		
		return false;
	}

	/**
	 *	���룺��Ʒ����ϸ����
	 *	�������Ʒ�Ƿ��ύ�ɹ�
	 */
	public boolean submitItem(Item thisItem){
		return (itemMgr.addItem(thisItem));
	}

	/**
	 * 	���룺��Ʒ��Ψһ��ʾ����Ʒ�Ļ�����
	 * 	�������
	 * 	���ã�������˺ͷ������˶�֪����Ʒ�ѷ���
	 */
	public boolean confirmDelivery(long itemId, long receiptId, String cargoCmp){
		return (itemMgr.updateDelivery(itemId, receiptId, cargoCmp));
	}
	
	/**
	 * 	���룺��Ʒ��Ψһ��ʾ����Ʒ�Ļ�����
	 * 	�������
	 * 	���ã�������˺ͷ������˶�֪����Ʒ���յ�
	 */
	public boolean confirmReceipt(long itemId){
		return (itemMgr.updateReceipt(itemId));
	}

	//???receipt password

	//???suicide

	/**
	 *	���ã��ṩ��Ʒ��Ŀǰ�� 
	 */
	public double /*curPrice*/ requestBid(long itemId){
		double curPrice = -1;//-1��ʾ����
		//1�����Ʒ�Ƿ����(optional)
		//2����Ʒ�Ƿ�������ʱ����
		//3��õ�ǰ�۸�
		if(itemMgr.isAlive(itemId))
			curPrice = itemMgr.queryCurPrice(itemId);
		
		return curPrice;
	}
	
	/**
	 * ���ã���ĳ���û����˺��ϳ�ֵ
	 */
	public boolean charge(double money, String userName){
		return (userMgr.charge(userName, money));
	}

	/**
	 *	���ã��������Ϳͻ����˶�֪��ĳһλ�û�Ϊĳһ����Ʒ����һ���۸� 
	 */	
	public boolean  offerPrice(double money, long itemId, String userName){
		//1�ѳ��۵��û������Ʒ֮��Ĺ�ϵ��
		//2���û��������Ͽ�ȥĳ��(���)���
		//0������
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
		List<Category> cList = null;//null��ʾ����
		cList = categoryMgr.getAllCategories();
		return cList;
	}
	
	public List<ItemDigest> getDyingItems(long from, long to){
		List<ItemDigest> iList = null;//null��ʾ����
		iList = itemMgr.queryDyingItems(from, to);
		return iList;
	}
	
	public List<ItemDigest> getDyingItems ( long from, long to, long categoryId ) {
		List<ItemDigest> iList = null;//null��ʾ����
		iList = itemMgr.queryDyingItems(from, to, categoryId);
		return iList;
	}
	
	public List<ItemDigest> getLatestItems(long from, long to){
		List<ItemDigest> iList = null;//null��ʾ����
		iList = itemMgr.queryLatestItems(from, to);
		return iList;
	}
	
	public List<ItemDigest> getLatestItems ( long from, long to, long categoryId ) {
		List<ItemDigest> iList = null;//null��ʾ����
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
