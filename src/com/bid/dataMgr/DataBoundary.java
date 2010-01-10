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
	 *  ���룺��Ʒ��Ψһ��ʾ
	 *  �������Ʒ����ϸ����
	 */
	public Item getItemInfo(long itemId){
		Item thisItem = null;
		thisItem = itemMgr.queryItem(itemId);
		return thisItem;
	}

	/**
	 *	���룺�û���Ψһ��ʾ���û�������
	 *	������û��Ƿ��¼�ɹ�
	 *	���ã�������˺ͷ������˶�֪���û������¼״̬
	 */
	public boolean login(String userName, String psw){
		if(this.isUserValid(userName, psw))
			userMgr.login(userName);
		
		return false;
	}

	/**
	 *	���룺�û�����Ϣ
	 *	������û��Ƿ�ע��ɹ� 
	 *	���ã�������������һ���û�
	 */
	public boolean register(UserInfo userInfo){
		if(!userMgr.hasUser(userInfo.userName)){
			userMgr.addUser(userInfo);
		}
		
		return false;
	}

	/**
	 *	���룺 
	 */
	public void requestPostItem(){/**--------------------���ǻ������ľ�ʾ��----------------------------------------*/
	}

	/**
	 *	���룺��Ʒ����ϸ����
	 *	�������Ʒ�Ƿ��ύ�ɹ�
	 */
	public boolean submitItem(Item thisItem){
		boolean isSubmmitted = false;
		if(itemMgr.addItem(thisItem))
			isSubmmitted = timerMgr.registerDeadline(thisItem.getItemId(), thisItem.getTime());
		
		return isSubmmitted;
	}

	/**
	 * 	���룺��Ʒ��Ψһ��ʾ����Ʒ�Ļ�����
	 * 	�������
	 * 	���ã�������˺ͷ������˶�֪����Ʒ�ѷ���
	 */
	public void confirmDelivery(long itemId, long receiptId){
		itemMgr.updateDelivery(itemId, receiptId);
	}
	
	/**
	 * 	���룺��Ʒ��Ψһ��ʾ����Ʒ�Ļ�����
	 * 	�������
	 * 	���ã�������˺ͷ������˶�֪����Ʒ���յ�
	 */
	public void confirmReceipt(long itemId){
		itemMgr.updateReceipt(itemId);
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
			itemMgr.queryCurPrice(itemId);
		
		return curPrice;
	}

	/**
	 *	���ã��������Ϳͻ����˶�֪��ĳһλ�û�Ϊĳһ����Ʒ����һ���۸� 
	 */	
	public boolean  offerPrice(double money, long itemId, String userName){
		//1�ѳ��۵��û������Ʒ֮��Ĺ�ϵ��
		//2���û��������Ͽ�ȥĳ��(���)���
		boolean offered = userMgr.charge(userName, money);
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
	
	public List<ItemDigest> getDryingItems ( long from, long to, long categoryId ) {
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
		userMgr.isValid(userName, psw);
		return false;
	}
	
	private ItemMgr itemMgr;
	private UserMgr userMgr;
	private TimerMgr timerMgr;
	private CategoryMgr categoryMgr;
}
