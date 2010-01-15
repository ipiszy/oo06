package com.bid.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ConfirmDeliveryButton extends Composite {
	final long itemId;

	public ConfirmDeliveryButton(long itemIdOut) {
		this.itemId = itemIdOut;
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				new ConfirmDeliveryDia(itemId).show();
			}
		});
		button.setText("\u786E\u8BA4\u53D1\u8D27");
		initWidget(button);
		button.setSize("91px", "37px");
	}

}
