package com.bid.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bid.client.IGetSellerBiddedsService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GetSellerBiddedsService extends RemoteServiceServlet 
implements IGetSellerBiddedsService {

	@Override
	public List<ItemDigest> getSellerBiddeds() {
		// TODO Auto-generated method stub
		HttpSession session = this.getThreadLocalRequest().getSession();
		String id = session.getAttribute("id").toString();
		if (id == null)
			return new ArrayList<ItemDigest>();
		return new DataBoundary().queryItemsBidded(id);
	}
}
