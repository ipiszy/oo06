package com.bid.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("sellerDelivery")
public interface ISellerDeliveryService extends RemoteService{
	boolean delivery(long itemId, String cargoName, long cargoId);

}
