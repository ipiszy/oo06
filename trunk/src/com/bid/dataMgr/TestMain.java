package com.bid.dataMgr;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bid.exchange.Category;
import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;
import com.bid.exchange.UserInfo;

public class TestMain {
	public static void main(String[]arg){
		DataBoundary b = new DataBoundary();
		
		
		boolean retV;

		List<ItemDigest> itemlist;
		Item sampleItem;
		Iterator<ItemDigest> iter;
		
		
//		System.out.println(b.login("sepsky", "sepskypass"));
//		System.out.println(b.login("sepsky", "sepskypas"));		
//		System.out.println(b.login("sepsk", "sepskypass"));
//		
//		
//		System.out.println("-------testing getDyingItems(long , long ):---------");
//		itemlist = b.getDyingItems(2, 4);
//		iter = itemlist.iterator();
//		while (iter.hasNext()){
//			ItemDigest it = iter.next();
//			it.dump();
//		}
//		
//		System.out.println("-------testing getDyingItems(long , long , long ):-------");
//		itemlist = b.getDyingItems(2, 4, 1001);
//		iter = itemlist.iterator();
//		while (iter.hasNext()){
//			ItemDigest it = iter.next();
//			it.dump();
//		}
//		
//		System.out.println("-------testing getLatestItems(long , long ):-------");
//		itemlist = b.getLatestItems(2, 4);
//		iter = itemlist.iterator();
//		while (iter.hasNext()){
//			ItemDigest it = iter.next();
//			it.dump();
//		}
//		
//		System.out.println("-------testing getLatestItems(long , long, long ):-------");
//		itemlist = b.getLatestItems(2, 4, 1001);
//		iter = itemlist.iterator();
//		while (iter.hasNext()){
//			ItemDigest it = iter.next();
//			it.dump();
//		}
//		
//		System.out.println("-------testing getItem(long ):-------");
//		sampleItem = b.getItem(1);
//		sampleItem.dump();

		
		//test of methods
		
//		retV = b.charge(1000, "sepsky");
//		System.out.println(retV);
//		
//		retV = b.offerPrice(300000, 90001, "sepsky");
//		System.out.println(retV);
//		
//		retV = b.register(new UserInfo("witchj", 3000, "hello from witch", "CloudBankAccount", "witchj@cloud"));
//		System.out.println(retV);
//		
//		System.out.println("-------testing DataBoundary.getUser()-------");
//		UserInfo userinfo = b.getUser("litt");
//		System.out.println("<"+userinfo+">");
//		userinfo.dump();
//		

//		public UserInfo(String name, double balance, String pswd, String bankAccount, String mailBox)
//		retV = b.register(new UserInfo("sepsky", 10000, "pass", "BA", "sepsky@mail"));
//		System.out.println(retV);
//		retV = b.register(new UserInfo("litt", 10000, "pass", "BA", "litt@mail"));
//		System.out.println(retV);
//		retV = b.register(new UserInfo(UserInfo.NONE, 10000, "pass", "BA", "none@mail"));
//		System.out.println(retV);
//		UserInfo user = b.getUser("sepsky");
//		user.dump();
		
		// TODO
		//long categoryId = b.addCategory("comic");
		//Item newItem = new Item(0, "Sweep?", "Sweep used by witchj", 1000,
		//		11, "litt", new Date(), 1000, UserInfo.NONE, 0, Item.ONBID, null, new Date(), "flying", 0);
		//retV = b.submitItem(newItem);
		//System.out.println(retV);
		
		//retV = b.confirmDelivery(90001, 0, "witchCmp");
		//System.out.println(retV);
		
		
		
		/*List<Category> retCatList = b.getCategories();
		for(Category obj : retCatList)
			System.out.println(obj.getId() +":" +obj.getName());
		
		retV = b.confirmReceipt(1);
		System.out.println(retV);*/
		
		
		//TODO
//		System.out.println("-------queryBiddingItems()---------");
//		List<ItemDigest> retItemDigList = b.queryBiddingItems("sepsky");
//		for(ItemDigest obj : retItemDigList)
//			System.out.println(obj.getItemId() +":" +obj.getName());
		
//		System.out.println("-------queryBiddedItems()---------");
//		retItemDigList = b.queryBiddedItems("sepsky");
//		for(ItemDigest obj : retItemDigList)
//			System.out.println(obj.getItemId() +":" +obj.getName());

//		System.out.println("-------RequestBid()---------");

//		System.out.println(b.requestBid(2));
		
		//new Several articles and bidds them
		//fenggang.wu bids several articles
		//b.charge(10000, "litt");
		//b.charge(10000, "sepsky");

		/*Date postDate = new Date();
		Date deadDate = new Date();
		int hour = postDate.getHours();
		deadDate.setHours(hour + 3);
		b.submitItem(new Item(0, "test2", "Magical test2 by witchj", 1000,
			11, "witchj", deadDate, 1000, UserInfo.NONE, 0, Item.ONBID, null, postDate, null, 0));
		//b.charge(10000, "sepsky");
		//b.charge(10000, "litt");
		/*double price = b.requestBid(10);
		b.offerPrice(price + 1000, 10, "sepsky");//3000
		price = b.requestBid(10);
		b.offerPrice(price + 1000, 10, "litt");//4000
		/*price = b.requestBid(10);
		b.offerPrice(price + 1000, 10, "sepsky");//5000
		price = b.requestBid(10);
		b.offerPrice(price + 1000, 10, "litt");//6000
		price = b.requestBid(10);
		b.offerPrice(price + 1000, 10, "sepsky");//7000
		price = b.requestBid(10);
		b.offerPrice(price + 1000, 10, "litt");//8000
		*/
		//list all ok?
	//	List<ItemDigest> retlist = b.queryItemsBidded("sepsky");
	//	for(ItemDigest iitem : retlist)
	//		iitem.dump();
		b.startUp();
	}
}
