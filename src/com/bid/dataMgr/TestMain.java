package com.bid.dataMgr;

import java.util.Date;
import java.util.List;

import com.bid.data.Category;
import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;

public class TestMain {
	public static void main(String[]arg){
		DataBoundary b = new DataBoundary();
		
		/*// login test
		System.out.print("------------->");
		System.out.println(b.login("sepsky", "sepskypass"));
		System.out.print("------------->");
		System.out.println(b.login("sepsky", "sepskypas"));		
		System.out.print("------------->");
		System.out.println(b.login("sepsk", "sepskypass"));
		
		// browse test
		
		List<ItemDigest> itemlist;
		Item sampleItem;
		
		System.out.println("testing getDyingItems(long , long ):");
		itemlist = b.getDyingItems(2, 4);
		Iterator<ItemDigest> iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getDyingItems(long , long , long ):");
		itemlist = b.getDyingItems(2, 4, 1001);
		iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getLatestItems(long , long ):");
		itemlist = b.getLatestItems(2, 4);
		iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getLatestItems(long , long, long ):");
		itemlist = b.getLatestItems(2, 4, 1001);
		iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getItem(long ):");
		sampleItem = b.getItem(90001);
		sampleItem.dump();
		
		System.out.println("testing getItem(long ):");
		sampleItem  = b.getItem(90001);
		sampleItem.dump();*/

		
		// bid test
		
		//test of methods
		List<ItemDigest> retV;
		//retV = b.charge(1000, "sepsky");
		//System.out.println(retV);
		
		//retV = b.offerPrice(300000, 90001, "sepsky");
		//System.out.println(retV);
		
		//retV = b.register(new UserInfo("witchj", 3000, "hello from witch", "CloudBankAccount", "witchj@cloud"));
		//System.out.println(retV);
		
		//retV = b.submitItem(new Item(0, "Sweep?", "Sweep used by witchj", 1000,
		//		1001, "witchj", new Date(), -1, "", 0, Item.ONBID, null, new Date()));
		//System.out.println(retV);
		
		//retV = b.confirmDelivery(90001, 0, "witchCmp");
		//System.out.println(retV);
		
		//retV = b.getCategories();
		//for(Category obj : retV)
		//	System.out.println(obj.getId() +":" +obj.getName());
		
		//retV = b.confirmReceipt(90001);
		//System.out.println(retV);
		
		retV = b.queryBiddingItems("sepsky");
		for(ItemDigest obj : retV)
			System.out.println(obj.getItemId() +":" +obj.getName());
		
		//retV = b.requestBid(90002);
		//System.out.println(retV);
	}
}
