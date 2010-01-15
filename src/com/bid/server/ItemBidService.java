package com.bid.server;

import javax.servlet.http.HttpSession;

import com.bid.client.IItemBidService;
import com.bid.dataMgr.DataBoundary;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ItemBidService extends RemoteServiceServlet implements
		IItemBidService {
	public boolean itemBid(long itemId, double money) {
		HttpSession session;
		session = this.getThreadLocalRequest().getSession();
		Object obj = session.getAttribute("id");
		if (obj == null)
			return false;
		String id = obj.toString();
		return new DataBoundary().offerPrice(money, itemId, id);
	}

}
