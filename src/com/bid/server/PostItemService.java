package com.bid.server;

import com.bid.client.IPostItemService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.Item;

public class PostItemService implements IPostItemService {
	public boolean postItem(Item item){
		return new DataBoundary().submitItem(item);
	}

}
