package com.bid.client;

import com.bid.exchange.UserInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IRegisterServiceAsync {

	void register(UserInfo userInfo, AsyncCallback<Boolean> callback);

}
