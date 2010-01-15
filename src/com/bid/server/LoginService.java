package com.bid.server;

import javax.servlet.http.HttpSession;

import com.bid.client.ILoginService;
import com.bid.dataMgr.DataBoundary;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginService extends RemoteServiceServlet 
implements ILoginService {

	@Override
	public boolean logIn(String id, String psw) {
		// TODO Auto-generated method stub
		boolean result;
		HttpSession session;
		result = new DataBoundary().login(id, psw);
		
		if (result == true){
			session = this.getThreadLocalRequest().getSession();
			session.setAttribute("id", id);
		}	
		return result; 
	}

}
