package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IPostItemServiceAsync {

	void postItem(Item item, AsyncCallback<Boolean> callback);

}
