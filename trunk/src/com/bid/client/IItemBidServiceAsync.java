package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IItemBidServiceAsync {
	void itemBid(long itemId, double money,
			AsyncCallback<Boolean> callback);
}
