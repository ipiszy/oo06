package com.bid.server;

import java.util.List;

import com.bid.client.IGetDyingItemsService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GetDyingItemsService extends RemoteServiceServlet 
implements IGetDyingItemsService {

	@Override
	public List<ItemDigest> getDyingItems(long from, long to) {
		// TODO Auto-generated method stub
	/*	List<ItemDigest> result = new ArrayList<ItemDigest>();
		ItemDigest itemDigest;
		
		for (long i=from; i<to; i++){
			itemDigest = new ItemDigest(
					100, 
					"http://www.google.com/images/firefox/firefox35_v1.png", 
					"ipiszy", 
					10.0,
					10.45, 
					new Date()
					);
			result.add(itemDigest);
		}
		return result;
*/
		return new DataBoundary().getDyingItems(from, to);
	}

}
