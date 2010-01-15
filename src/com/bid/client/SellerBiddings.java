package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.core.client.EntryPoint;



import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SellerBiddings implements EntryPoint {

	private final FlexTable historyBiddingsTable = new FlexTable();
	private final IGetSellerBiddingsServiceAsync sellerBiddingsService = GWT
	.create(IGetSellerBiddingsService.class);
	
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub

		RootPanel.get("options").add(new Options());
		RootPanel.get("sellerBiddings").add(historyBiddingsTable);

		Label label = new Label("\u6B63\u5728\u62CD\u5356\u7269\u54C1\u8BB0\u5F55");
		historyBiddingsTable.setWidget(0, 0, label);
		historyBiddingsTable.getFlexCellFormatter().setColSpan(0, 0, 3);
		addRow();

	}
	
	void addRow(){
		sellerBiddingsService.getSellerBiddings(new AsyncCallback<List<ItemDigest>>(){











			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<ItemDigest> result) {
				// TODO Auto-generated method stub
				for (int i=1; i<=result.size(); i++){
					historyBiddingsTable.setWidget(i, 0, new HTML("<a href=\"/bid/itemBid.html?itemId="
							+ result.get(i).getItemId() + "\">" 
							+ result.get(i).getName() + "</a>"));
					historyBiddingsTable.setWidget(i, 1, new Label(result.get(i).getD().toString()));
					historyBiddingsTable.setWidget(i, 2, new Label(new Double(result.get(i).getLatestPrice()).toString()));
					
				}
			}
			
		});
		
	}

}
