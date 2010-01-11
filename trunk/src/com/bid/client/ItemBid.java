package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class ItemBid implements EntryPoint {

	private final FlexTable flexTable = new FlexTable();

	private final IGetItemServiceAsync getItemService = GWT
	.create(IGetItemService.class);
		
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
		

	}
	
	void initWidget(){
		FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
	    flexTable.addStyleName("cw-FlexTable");
	    flexTable.setWidth("45em");
	    flexTable.setCellSpacing(5);
	    flexTable.setCellPadding(3);

	    cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT);
	    //flexTable.setHTML(0, 0, "<img src=\" + /resource/bidding_header.jpg\" alt=\".o0O Bidding\" border=\"0\" >");
	    cellFormatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
	    cellFormatter.setColSpan(0, 1, 2);
	    
	}

	void getItem(FlexTable flexTable){
		int itemId = Integer.parseInt(com.google.gwt.user.client.Window.Location.getParameter("itemId"));
		getItemService.getItem(itemId, new AsyncCallback<Item>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Item result) {
				// TODO Auto-generated method stub
				Image image = new Image();
				
				//flexTable.setWidget(0, 0, new Image(result.));
				
			}
			
		});
		
		{
			
		}
		
	}

}
