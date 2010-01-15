package com.bid.client;

import java.util.ArrayList;
import java.util.List;
import com.bid.exchange.Category;
import com.bid.exchange.Item;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class PostForm extends Composite {
	
	private final IPostItemServiceAsync postItemService = GWT
	.create(IPostItemService.class);
	
	private final IGetCategoriesServiceAsync getCategoriesService = GWT
	.create(IGetCategoriesService.class);

	public PostForm() {

		FlexTable flexTable = new FlexTable();
		flexTable.setBorderWidth(0);
		flexTable.setStyleName("cw-FlexTable td");
		initWidget(flexTable);
		flexTable.setSize("520px", "520px");
		
		Label label = new Label("\u62CD\u5356\u7269\u54C1\u8BE6\u5355");
		label.setStyleName("gwt-Label-large");
		flexTable.setWidget(0, 0, label);
		
		Label label_1 = new Label("\u540D\u79F0");
		label_1.setStyleName("gwt-Label-post");
		flexTable.setWidget(1, 0, label_1);
		label_1.setSize("100", "40");
		
		final TextBox itemName = new TextBox();
		flexTable.setWidget(1, 1, itemName);
		
		Label lblurl = new Label("\u5B9E\u7269\u7167\u7247");
		lblurl.setStyleName("gwt-Label-post");
		flexTable.setWidget(2, 0, lblurl);
		lblurl.setSize("130", "20");
		
		final TextBox imageURL = new TextBox();
		imageURL.setText("\u8BF7\u8F93\u5165URL\u5730\u5740");
		flexTable.setWidget(2, 1, imageURL);
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		
		Label label_2 = new Label("\u8D77\u4EF7");
		label_2.setStyleName("gwt-Label-post");
		flexTable.setWidget(3, 0, label_2);
		
		final TextBox basePrice = new TextBox();
		flexTable.setWidget(3, 1, basePrice);
		
		Label label_4 = new Label("\u622A\u6B62\u65E5\u671F");
		label_4.setStyleName("gwt-Label-post");
		flexTable.setWidget(4, 0, label_4);
		
		final DateBox dateBox = new DateBox();
		flexTable.setWidget(4, 1, dateBox);
		
		Label label_3 = new Label("\u5206\u7C7B\u76EE\u5F55");
		label_3.setStyleName("gwt-Label-post");
		flexTable.setWidget(5, 0, label_3);
		
		final ListBox category = new ListBox();
		final List<Category> cateList = new ArrayList<Category>();
		getCategories(cateList);
		for (int i=0; i<cateList.size(); i++){
			category.addItem(cateList.get(i).getName());
		}
		flexTable.setWidget(5, 1, category);
		category.setSize("220", "38");
		
		Label label_6 = new Label("\u7269\u54C1\u63CF\u8FF0");
		label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		label_6.setStyleName("gwt-Label-post");
		flexTable.setWidget(6, 0, label_6);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flexTable.setWidget(6, 1, verticalPanel);
			
		final RichTextArea des = new RichTextArea();	
		des.setStylePrimaryName("gwt-RichTextArea1");
		des.setStyleName("gwt-RichTextArea1");
		
		RichTextToolbar richTextToolbar = new RichTextToolbar((RichTextArea) des);
		verticalPanel.add(richTextToolbar);
		verticalPanel.add(des);
		des.setWidth("530px");
		
		Button submit = new Button("\u63D0\u4EA4\uFF01~~~~~~");
		flexTable.setWidget(8, 0, submit);
		flexTable.getFlexCellFormatter().setColSpan(8, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(8, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setHorizontalAlignment(6, 0, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setHorizontalAlignment(7, 0, HasHorizontalAlignment.ALIGN_LEFT);
		flexTable.getCellFormatter().setVerticalAlignment(7, 0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setVerticalAlignment(4, 0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setVerticalAlignment(5, 0, HasVerticalAlignment.ALIGN_TOP);
		flexTable.getCellFormatter().setVerticalAlignment(6, 0, HasVerticalAlignment.ALIGN_TOP);

		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			
				
				int i = category.getItemCount();
				
				Item item = new Item
				(itemName.getText(),des.toString(), 
						Double.parseDouble(basePrice.getText()),
						cateList.get(i).getId(),"",dateBox.getValue(),
						imageURL.getText());
				
				postItemService.postItem(item, new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
			//			error.setText("RPC call failed");						
					}

					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
			//			if (result.equals(Boolean.TRUE))
			//				error.setText("Success!");
			//			else
			//				error.setText("Failed! Please try again.");
					}					
				});
			}			  
		  });
	}
	
	void getCategories(final List<Category> cateList){
		getCategoriesService.getCategories(new AsyncCallback<List<Category>>(){
			public void onFailure(Throwable caught) {
			}
			public void onSuccess(List<Category> result) {
				for (int i = 0; i < result.size(); i++) {
					cateList.add(result.get(i));
				}			
			}
		});
	}
}
