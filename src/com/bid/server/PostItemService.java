package com.bid.server;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.bid.client.IPostItemService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.Item;
import com.bid.exchange.ItemDigest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PostItemService extends RemoteServiceServlet 
implements IPostItemService {
	public boolean postItem(Item item){
		HttpSession session = this.getThreadLocalRequest().getSession();
		String id = session.getAttribute("id").toString();
		if (id == null)
			return false;
		item.setPostUserName(id);
		return new DataBoundary().submitItem(item);
	}

}
