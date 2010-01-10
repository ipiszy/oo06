package com.bid.client;
import java.util.ArrayList;
import java.util.List;

import com.bid.data.Category;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Browse implements EntryPoint {

	private final IGetCategoriesServiceAsync getCategoriesService = GWT
	.create(IGetCategoriesService.class);
	
	private final HTML cateList = new HTML();
	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
		RootPanel.get("categories").add(cateList);
		getCategories(cateList);
		
	}
	
	private void getCategories(final HTML cateList) {
		getCategoriesService.getCategories(new AsyncCallback<List<Category>>(){
			public void onFailure(Throwable caught) {
			}
			public void onSuccess(List<Category> result) {
				String html="";
				for (int i = 0; i < result.size(); i++) {
					html += "<li><a href=\"/Bid.html?catagoryId="
							+ result.get(i).getId() + "\">" 
							+ result.get(i).getName() + "</a></li>\n";
				}
				cateList.setHTML(html);
			}
		});
	}
}
