package com.bid.client;

import java.util.List;
import com.bid.exchange.Category;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getBidCategories")
public interface IGetBidCategoriesService extends RemoteService{
	List<Category> getCategories();
}
