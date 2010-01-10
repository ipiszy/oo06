package com.bid.client;

import java.util.List;

import com.bid.data.Category;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getCategories")
public interface IGetCategoriesService extends RemoteService{

	List<Category> getCategories();

}