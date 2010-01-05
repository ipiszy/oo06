package com.bid.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ILoginServiceAsync {
	void logIn(String id, String psw, AsyncCallback<Boolean> callback);
}
