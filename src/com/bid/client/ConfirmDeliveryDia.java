package com.bid.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ConfirmDeliveryDia extends DialogBox {
	ConfirmDeliveryDia dia = this;
	final ISellerDeliveryServiceAsync sellerDeliveryService = GWT
	.create(ISellerDeliveryService.class);
	final long itemId;

	public ConfirmDeliveryDia(long itemIdOut) {
		
		this.itemId = itemIdOut;
		setHTML("\u786E\u8BA4\u53D1\u8D27");
		
		final FlexTable flexTable = new FlexTable();
		setWidget(flexTable);
		flexTable.setSize("266px", "256px");
		
		Label label = new Label("\u8D27\u8FD0\u516C\u53F8");
		flexTable.setWidget(0, 0, label);
		
		final TextBox textBox = new TextBox();
		flexTable.setWidget(0, 1, textBox);
		
		Label label_1 = new Label("\u8D27\u5355\u53F7");
		flexTable.setWidget(1, 0, label_1);
		
		final TextBox textBox_1 = new TextBox();
		flexTable.setWidget(1, 1, textBox_1);
		
		HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		flexTable.setWidget(2, 0, horizontalSplitPanel);
		
		Button button = new Button("New button");

		button.setText("\u786E\u8BA4");
		horizontalSplitPanel.setLeftWidget(button);
		button.setSize("100%", "100%");
		
		Button button_1 = new Button("New button");
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dia.hide();
			}
		});
		button_1.setText("\u53D6\u6D88");
		horizontalSplitPanel.setRightWidget(button_1);
		button_1.setSize("100%", "100%");
		flexTable.getFlexCellFormatter().setColSpan(2, 0, 2);
		
		final Label error = new Label("");
		error.setHeight("");
		flexTable.setWidget(3, 0, error);
		flexTable.getFlexCellFormatter().setColSpan(3, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				sellerDeliveryService.delivery(itemId, textBox.getText(), Long.parseLong(textBox_1.getText()), new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						error.setText("error!");
					}

					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						if (result.equals(Boolean.TRUE))
							error.setText("RPC error, do you login?");
						else
							error.setText("Succeded!");
					}
					
				});
			}
		});
	}

}
