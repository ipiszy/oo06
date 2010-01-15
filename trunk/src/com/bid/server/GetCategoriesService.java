package com.bid.server;

import java.util.ArrayList;
import java.util.List;

import com.bid.client.IGetCategoriesService;
import com.bid.dataMgr.DataBoundary;
import com.bid.exchange.Category;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GetCategoriesService extends RemoteServiceServlet
implements IGetCategoriesService {

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		/*List<Category> categories = new ArrayList<Category>();
		
		categories.add(new Category(134,"2345tr3"));
		categories.add(new Category(134,"e34rt"));
		categories.add(new Category(134,"trgf"));
		*/
		//return categories;
		
		return new DataBoundary().getCategories();
	}
}
