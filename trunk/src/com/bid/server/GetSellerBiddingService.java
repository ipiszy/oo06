package com.bid.server;

import java.util.List;

import com.bid.client.IGetSellerBiddingsService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.ItemDigest;

public class GetSellerBiddingService implements IGetSellerBiddingsService {

	@Override
	public List<ItemDigest> getSellerBiddings(String id) {
		// TODO Auto-generated method stub
		return new DataBoundary().queryBiddingItems(id);
	}

}
