package com.bid.server;

import com.bid.client.IItemBidService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ItemBidService extends RemoteServiceServlet implements
		IItemBidService {
	public boolean itemBid(long itemId, double money) {
		return false;
	}

}
