package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.RemoteService;

public interface IGetSellerBiddedsService extends RemoteService{
	List<ItemDigest> getSellerBiddeds(String id);

}
