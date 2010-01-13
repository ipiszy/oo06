package com.bid.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Hyperlink;

public class Options extends Composite {

	public Options() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("gwt-VerticalPanel");
		verticalPanel.setSize("92px", "232px");
		initWidget(verticalPanel);
		
		Hyperlink hyperlink = new Hyperlink("\u6211\u8981\u5356", false, "\\post.html");
		verticalPanel.add(hyperlink);
		
		
		Hyperlink hyperlink_1 = new Hyperlink("\u67E5\u770B\u6B63\u5728\u62CD\u5356\u7269\u54C1", false, "\\sellerBiddings.html");
		verticalPanel.add(hyperlink_1);
		
		Hyperlink hyperlink_2 = new Hyperlink("\u67E5\u770B\u5DF2\u62CD\u5356\u5B8C\u6210\u7269\u54C1", false, "\\sellerBidded.html");
		verticalPanel.add(hyperlink_2);
	}

}
