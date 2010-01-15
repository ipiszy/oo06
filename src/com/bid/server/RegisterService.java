package com.bid.server;

import com.bid.client.IRegisterService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.UserInfo;

public class RegisterService implements IRegisterService {

	@Override
	public boolean register(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return new DataBoundary().register(userInfo);
	}

}
