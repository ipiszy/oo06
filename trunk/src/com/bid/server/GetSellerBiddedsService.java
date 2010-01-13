package com.bid.server;

import java.util.List;

import com.bid.client.IGetSellerBiddedsService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.ItemDigest;

public class GetSellerBiddedsService implements IGetSellerBiddedsService {

	@Override
	public List<ItemDigest> getSellerBiddeds(String id) {
		// TODO Auto-generated method stub
		return new DataBoundary().queryItemsBidded(id);
	}

}
