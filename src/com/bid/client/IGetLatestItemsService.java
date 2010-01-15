package com.bid.client;

import java.util.List;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getLatestItems")
public interface IGetLatestItemsService extends RemoteService {
	List<ItemDigest> getLatestItems(long from, long to, long categoryId);

}
