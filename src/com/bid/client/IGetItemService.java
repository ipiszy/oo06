package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getItem")
public interface IGetItemService extends RemoteService{
	Item getItem(long itemId);
}
