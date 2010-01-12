package com.bid.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("itemBid")
public interface IItemBidService extends RemoteService{
	boolean itemBid(long itemId, double money);
}
