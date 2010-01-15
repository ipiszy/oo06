package com.bid.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bid.client.IGetSellerBiddingsService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GetSellerBiddingsService extends RemoteServiceServlet
implements IGetSellerBiddingsService {

	@Override
	public List<ItemDigest> getSellerBiddings() {
		// TODO Auto-generated method stub
		
		HttpSession session = this.getThreadLocalRequest().getSession();
		String id = session.getAttribute("id").toString();
		if (id == null)
			return new ArrayList<ItemDigest>();
		return new DataBoundary().queryBiddingItems(id);
	}

}
