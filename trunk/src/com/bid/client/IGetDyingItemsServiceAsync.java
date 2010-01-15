package com.bid.client;

import java.util.List;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetDyingItemsServiceAsync {
	void getDyingItems(long from, long to, long categoryId, AsyncCallback<List<ItemDigest>> callback);
}
