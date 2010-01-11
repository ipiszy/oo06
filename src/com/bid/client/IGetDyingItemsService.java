package com.bid.client;

import java.util.List;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getDyingItems")
public interface IGetDyingItemsService extends RemoteService{

	List<ItemDigest> getDyingItems(long from, long to);

}