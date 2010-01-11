package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getItem")
public interface IGetItemService {
	Item getItem(long itemId);
}
