package com.bid.client;

import com.bid.exchange.UserInfo;
import com.google.gwt.user.client.rpc.RemoteService;

public interface IRegisterService extends RemoteService {
	boolean register(UserInfo userInfo);

}
