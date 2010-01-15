package com.bid.client;

import java.util.List;

import com.bid.exchange.ItemDigest;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SellerBiddeds implements EntryPoint {
	
	private final FlexTable historyBiddedsTable = new FlexTable();
	private final IGetSellerBiddedsServiceAsync sellerBiddedsService = GWT
	.create(IGetSellerBiddedsService.class);

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub

		RootPanel.get("options").add(new Options());
		RootPanel.get("sellerBiddeds").add(historyBiddedsTable);

		Label label = new Label("\u6B63\u5728\u62CD\u5356\u7269\u54C1\u8BB0\u5F55");
		historyBiddedsTable.setWidget(0, 0, label);
		historyBiddedsTable.getFlexCellFormatter().setColSpan(0, 0, 3);
		addRow();

	}
	
	void addRow(){
		sellerBiddedsService.getSellerBiddeds(new AsyncCallback<List<ItemDigest>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<ItemDigest> result) {
				// TODO Auto-generated method stub
				for (int i=1; i<=result.size(); i++){
					historyBiddedsTable.setWidget(i, 0, new HTML("<a href=\"/bid/itemBid.html?itemId="
							+ result.get(i).getItemId() + "\">" 
							+ result.get(i).getName() + "</a>"));
					historyBiddedsTable.setWidget(i, 1, new Label(result.get(i).getD().toString()));
					historyBiddedsTable.setWidget(i, 2, new Label(new Double(result.get(i).getLatestPrice()).toString()));
					if (result.get(i).getStatus().equals(ItemDigest.OBSOLETE)){
						historyBiddedsTable.setWidget(i, 3, new ConfirmDeliveryButton(result.get(i).getItemId()));
						historyBiddedsTable.getFlexCellFormatter().setColSpan(i, 3, 2);
						historyBiddedsTable.getFlexCellFormatter().setHorizontalAlignment(i, 3, HasHorizontalAlignment.ALIGN_CENTER);
					}
					else{
						historyBiddedsTable.setWidget(i, 3, new Label(result.get(i).getCargoName()));
						historyBiddedsTable.setWidget(i, 4, new Label(new Long(result.get(i).getCargoId()).toString()));
						if (result.get(i).getStatus().equals(ItemDigest.ONDELIEVER))
							historyBiddedsTable.setWidget(i, 5, new Label("on delivery"));
						else if (result.get(i).getStatus().equals(ItemDigest.DELIVERED))
							historyBiddedsTable.setWidget(i, 5, new Label("deliveried"));
					}	
				}
			}
		});	
	}
}
