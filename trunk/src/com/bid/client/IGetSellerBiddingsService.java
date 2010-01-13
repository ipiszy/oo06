package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getSellerBiddings")
public interface IGetSellerBiddingsService extends RemoteService{

	List<ItemDigest> getSellerBiddings(String id);
	
}
