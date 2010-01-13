package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.StackPanel;

public class Post implements EntryPoint {

	@Override
	public void onModuleLoad() {
		init();
	}
	
	  public void init() {
		  RootPanel.get("options").add(new Options());
		  RootPanel.get("postForm").add(new PostForm());	  
		  }
}
