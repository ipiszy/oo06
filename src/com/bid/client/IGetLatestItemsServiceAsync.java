package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetLatestItemsServiceAsync {

	void getLatestItems(long from, long to, long categoryId,
			AsyncCallback<List<ItemDigest>> callback);

}
