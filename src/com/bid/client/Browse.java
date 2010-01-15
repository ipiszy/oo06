package com.bid.client;
import java.util.List;
import com.bid.exchange.Category;
import com.bid.exchange.ItemDigest;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class Browse implements EntryPoint {

	private final IGetCategoriesServiceAsync getCategoriesService = GWT
	.create(IGetCategoriesService.class);
	
	private final IGetDyingItemsServiceAsync getDyingItemsService = GWT
	.create(IGetDyingItemsService.class);
	
	private final IGetLatestItemsServiceAsync getLatestItemsService = GWT
	.create(IGetLatestItemsService.class);
	
	private final HTML cateList = new HTML();
	private final FlexTable flexTable = new FlexTable();
	private final FlexTable flexTable_new = new FlexTable();
	
	private long categoryId = 0;
	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
		String categoryString = com.google.gwt.user.client.Window.Location.getParameter("categoryId");
		if (categoryString != null)
			categoryId = Long.parseLong(categoryString);
	
		FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
	    flexTable.addStyleName("cw-FlexTable");
	    flexTable.setWidth("45em");
	    flexTable.setCellSpacing(5);
	    flexTable.setCellPadding(3);

	    // Add some text
	    cellFormatter.setHorizontalAlignment(0, 0,
	        HasHorizontalAlignment.ALIGN_LEFT);
	    

		cellFormatter = flexTable_new.getFlexCellFormatter();
		flexTable_new.addStyleName("cw-FlexTable");
		flexTable_new.setWidth("45em");
		flexTable_new.setCellSpacing(5);
		flexTable_new.setCellPadding(3);

	    // Add some text
	    cellFormatter.setHorizontalAlignment(0, 0,
	        HasHorizontalAlignment.ALIGN_LEFT);
	    
	    
	    // Return the panel
		RootPanel.get("categories").add(cateList);
		RootPanel.get("gwt_results").add(flexTable);
		RootPanel.get("gwt_results_new").add(flexTable_new);
		getCategories(cateList);
		getDyingItems(flexTable);
		getLatestItems(flexTable_new);
		
		Label label = new Label("\u6211\u5FEB\u5230\u671F\u4E86\uFF0C\u5FEB\u70B9\u6765\u62CD\u6211^_^");
		flexTable.setWidget(0, 0, label);
	}
	
	private void getCategories(final HTML cateList) {
		getCategoriesService.getCategories(new AsyncCallback<List<Category>>(){
			public void onFailure(Throwable caught) {
			}
			public void onSuccess(List<Category> result) {
				String html="";
				for (int i = 0; i < result.size(); i++) {
					html += "<li><a href=\"/bid/browse.html?catagoryId="
							+ result.get(i).getId() + "\">" 
							+ result.get(i).getName() + "</a></li>\n";
				}
				cateList.setHTML(html);
			}
		});
	}
	
	private void getDyingItems(final FlexTable flexTable){
		getDyingItemsService.getDyingItems(0, 7, categoryId, new AsyncCallback<List<ItemDigest>>(){
			public void onFailure(Throwable caught){
			}
			public void onSuccess(List<ItemDigest> result){
				
				if (result == null)
					return;
				
				for (int i=0; i<Math.min(7, result.size()); i++){
					flexTable.setWidget(i/4+1, i%4, init(result.get(i)));

					if (i%4 == 3)
						 flexTable.getFlexCellFormatter().setRowSpan(0, 1, i/4 + 1);
				}
			}
			
			private Widget init(ItemDigest itemDigest){
				VerticalPanel vp = new VerticalPanel();
				vp.setSpacing(5);
				
				Image image = new Image();
				image.setUrl(itemDigest.getImageURL());
				vp.add(image);
				vp.add(new HTML("<a href=\"/bid/itemBid.html?itemId="
							+ itemDigest.getItemId() + "\">" 
							+ itemDigest.getName() + "</a>"));
				vp.add(new Label("base price : " + itemDigest.getBasePrice()));
				vp.add(new Label("latest price : " + itemDigest.getLatestPrice()));
				vp.add(new Label("deadline : " + itemDigest.getD()));
		
				return vp;
			}
		});
	}

	private void getLatestItems(final FlexTable flexTable){
		getLatestItemsService.getLatestItems(0, 7, categoryId, new AsyncCallback<List<ItemDigest>>(){
			public void onFailure(Throwable caught){
			}
			public void onSuccess(List<ItemDigest> result){
				
				if (result == null)
					return;
				
				for (int i=0; i<Math.min(7, result.size()); i++){
					flexTable.setWidget(i/4+1, i%4, init(result.get(i)));

					if (i%4 == 3)
						 flexTable.getFlexCellFormatter().setRowSpan(0, 1, i/4 + 1);
				}
			}
			
			private Widget init(ItemDigest itemDigest){
				VerticalPanel vp = new VerticalPanel();
				vp.setSpacing(5);
				
				Image image = new Image();
				image.setUrl(itemDigest.getImageURL());
				vp.add(image);
				vp.add(new HTML("<a href=\"/bid/itemBid.html?itemId="
							+ itemDigest.getItemId() + "\">" 
							+ itemDigest.getName() + "</a>"));
				vp.add(new Label("base price : " + itemDigest.getBasePrice()));
				vp.add(new Label("latest price : " + itemDigest.getLatestPrice()));
				vp.add(new Label("deadline : " + itemDigest.getD()));
		
				return vp;
			}
		});
	}
}
