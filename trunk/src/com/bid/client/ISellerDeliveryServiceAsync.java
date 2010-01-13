package com.bid.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ISellerDeliveryServiceAsync {

	void delivery(long itemId, String cargoName, long cargoId,
			AsyncCallback<Boolean> callback);

}
