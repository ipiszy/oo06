package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("post")
public interface IPostItemService extends RemoteService{
	boolean postItem(Item item);
}
