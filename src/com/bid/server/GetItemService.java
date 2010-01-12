package com.bid.server;

import com.bid.client.IGetItemService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.Item;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GetItemService extends RemoteServiceServlet 
implements IGetItemService {

	@Override
	public Item getItem(long itemId) {
		// TODO Auto-generated method stub
		return new DataBoundary().getItem(itemId);
	}

}
