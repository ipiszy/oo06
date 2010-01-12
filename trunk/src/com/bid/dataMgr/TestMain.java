package com.bid.dataMgr;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
//		sampleItem = b.getItem(90001);
//		sampleItem.dump();
//
//		
//		//test of methods
//		
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
//
//		retV = b.submitItem(new Item(0, "Sweep?", "Sweep used by witchj", 1000,
//				1001, "witchj", new Date(), -1, "", 0, Item.ONBID, null, new Date()));
//		System.out.println(retV);
//		
//		retV = b.confirmDelivery(90001, 0, "witchCmp");
//		System.out.println(retV);
//		
//		
//		List<Category> retCatList = b.getCategories();
//		for(Category obj : retCatList)
//			System.out.println(obj.getId() +":" +obj.getName());
//		
//		retV = b.confirmReceipt(90001);
//		System.out.println(retV);
		
		List<ItemDigest> retItemDigList = b.queryBiddingItems("sepsky");
		for(ItemDigest obj : retItemDigList)
			System.out.println(obj.getItemId() +":" +obj.getName());
		
		retItemDigList = b.queryBiddedItems("sepsky");
		for(ItemDigest obj : retItemDigList)
			System.out.println(obj.getItemId() +":" +obj.getName());
		
		System.out.println(b.requestBid(90002));
	}
}
