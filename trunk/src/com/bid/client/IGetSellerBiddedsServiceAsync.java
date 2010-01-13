package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetSellerBiddedsServiceAsync {

	void getSellerBiddeds(String id, AsyncCallback<List<ItemDigest>> callback);

}
