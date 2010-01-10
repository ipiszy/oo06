package com.bid.client;
import java.util.List;
import com.bid.data.Category;
import com.bid.data.ItemDigest;
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
	
	private final HTML cateList = new HTML();
	private final FlexTable flexTable = new FlexTable();
	
	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
	
		FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
	    flexTable.addStyleName("cw-FlexTable");
	    flexTable.setWidth("45em");
	    flexTable.setCellSpacing(5);
	    flexTable.setCellPadding(3);

	    // Add some text
	    cellFormatter.setHorizontalAlignment(0, 0,
	        HasHorizontalAlignment.ALIGN_LEFT);
	    flexTable.setHTML(0, 0, "<img src=\"/resource/bidding_header.jpg\" alt=\".o0O Bidding\" border=\"0\" >");

	    // Return the panel
		RootPanel.get("categories").add(cateList);
		RootPanel.get("gwt_results").add(flexTable);
		getCategories(cateList);
		getDyingItems(flexTable);
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
	
	private void getDyingItems(final FlexTable flexTable){
		getDyingItemsService.getDyingItems(0, 7, new AsyncCallback<List<ItemDigest>>(){
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
				vp.add(new HTML("<a href=\"/Bid.html?itemId="
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
