package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetSellerBiddingsServiceAsync {
	void getSellerBiddings(String id, AsyncCallback<List<ItemDigest>> callback);

}
