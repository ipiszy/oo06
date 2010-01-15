package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getSellerBiddeds")
public interface IGetSellerBiddedsService extends RemoteService{
	List<ItemDigest> getSellerBiddeds();
}
