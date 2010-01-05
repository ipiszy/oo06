package com.bid.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface ILoginService extends RemoteService{

	boolean logIn(String id, String psw);

}
