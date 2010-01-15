package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetItemServiceAsync {
	void getItem(long itemId, AsyncCallback<Item> callback);
}
