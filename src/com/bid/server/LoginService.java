package com.bid.server;

import com.bid.client.ILoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginService extends RemoteServiceServlet 
implements ILoginService {

	@Override
	public boolean logIn(String id, String psw) {
		// TODO Auto-generated method stub
		return false;
	}

}
