package com.bid.dataMgr;

import java.util.Iterator;
import java.util.List;

import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;

public class TestMain {
	public static void main(String[]arg){
		DataBoundary b = new DataBoundary();
		
		// login test
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
		itemlist = b.getDyingItems(0, 250);
		Iterator<ItemDigest> iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getDyingItems(long , long , long ):");
		itemlist = b.getDyingItems(0, 250, 1001);
		iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getLatestItems(long , long ):");
		itemlist = b.getLatestItems(0, 250);
		iter = itemlist.iterator();
		while (iter.hasNext()){
			ItemDigest it = iter.next();
			it.dump();
		}
		
		System.out.println("testing getLatestItems(long , long, long ):");
		itemlist = b.getLatestItems(0, 250, 1001);
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
		sampleItem.dump();

		
		// bid test
		
		
		
	}
}
