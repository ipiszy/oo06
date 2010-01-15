package com.bid.server;

import com.bid.client.ISellerDeliveryService;
import com.bid.dataMgr.DataBoundary;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SellerDeliveryService extends RemoteServiceServlet 
implements ISellerDeliveryService {

	@Override
	public boolean delivery(long itemId, String cargoName, long cargoId) {
		// TODO Auto-generated method stub
		return new DataBoundary().confirmDelivery(itemId, cargoId, cargoName);
	}

}
