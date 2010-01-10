package com.bid.client;

import java.util.List;

import com.bid.data.Category;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IGetCategoriesServiceAsync {
	void getCategories(AsyncCallback<List<Category>> callback);
}
