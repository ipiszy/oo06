package com.bid.server;

import java.util.List;

import com.bid.client.IPostGetCategoriesService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.Category;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PostGetCategoriesService extends RemoteServiceServlet implements
		IPostGetCategoriesService {

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return new DataBoundary().getCategories();
	}

}
