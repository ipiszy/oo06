package com.bid.server;

import java.util.List;

import com.bid.client.IGetLatestItemsService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.ItemDigest;

public class GetLatestItemsService implements IGetLatestItemsService {

	@Override
	public List<ItemDigest> getLatestItems(long from, long to, long categoryId) {
		// TODO Auto-generated method stub
		return new DataBoundary().getLatestItems(from, to, categoryId);
	}

}
