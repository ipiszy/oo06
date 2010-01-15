package com.bid.server;





import com.bid.client.IPostItemService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.Item;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PostItemService implements IPostItemService {
public class PostItemService extends RemoteServiceServlet 
implements IPostItemService {
	public boolean postItem(Item item){





		return new DataBoundary().submitItem(item);
	}

}
