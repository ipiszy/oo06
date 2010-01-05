package com.bid.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ILoginService extends RemoteService{

	boolean logIn(String id, String psw);

}
