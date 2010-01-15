package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetSellerBiddingsServiceAsync {
	void getSellerBiddings(AsyncCallback<List<ItemDigest>> callback);

}
