package com.bid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Post implements EntryPoint {
	

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		RootPanel.get("options").add(init());
	}
	
	  public Widget init() {
		    // Create a new stack panel
		    DecoratedStackPanel stackPanel = new DecoratedStackPanel();
		    stackPanel.setWidth("200px");

		    // Add the Post folders
		    VerticalPanel postVP = new VerticalPanel();
		    postVP.add(new Label("A"));
		    stackPanel.add(postVP,getHeaderString("A"));

		    // Add the History folders
		    VerticalPanel historyVP = new VerticalPanel();
		    postVP.add(new Label("B"));
		    stackPanel.add(historyVP,getHeaderString("B"));

		    
		    // Add the admin folders
		    VerticalPanel adminVP = new VerticalPanel();
		    postVP.add(new Label("C"));
		    stackPanel.add(adminVP,getHeaderString("C"));

		    
		    // Return the stack panel
		    return stackPanel;
		  }
	  
	  private String getHeaderString(String text) {
		    // Add the image and text to a horizontal panel
		    HorizontalPanel hPanel = new HorizontalPanel();
		    hPanel.setSpacing(0);
		    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		    HTML headerText = new HTML(text);
		    headerText.setStyleName("cw-StackPanelHeader");
		    hPanel.add(headerText);

		    // Return the HTML string for the panel
		    return hPanel.getElement().getString();
		  }




}
