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

public class PostForm extends Composite {
	
	private final IPostItemServiceAsync postItemService = GWT
	.create(IPostItemService.class);

	
	private final IPostGetCategoriesServiceAsync postGetCategoriesService = GWT
	.create(IPostGetCategoriesService.class);
	
	private final List<Category> cateList = new ArrayList<Category>();

	public PostForm() {

		FlexTable flexTable = new FlexTable();
		flexTable.setStyleName("cw-FlexTable td");
		initWidget(flexTable);
		flexTable.setSize("520px", "579px");
		
		Label label = new Label("\u62CD\u5356\u7269\u54C1\u8BE6\u5355");
		label.setStyleName("gwt-Label-large");
		flexTable.setWidget(0, 0, label);
		
		Label label_1 = new Label("\u540D\u79F0");
		flexTable.setWidget(1, 0, label_1);
		label_1.setWidth("");
		
		TextBox textBox = new TextBox();
		flexTable.setWidget(1, 1, textBox);
		final TextBox itemName = new TextBox();
		flexTable.setWidget(1, 1, itemName);
		
		Label lblurl = new Label("\u5B9E\u7269\u7167\u7247");
		flexTable.setWidget(2, 0, lblurl);
		
		TextBox textBox_1 = new TextBox();
		flexTable.setWidget(2, 1, textBox_1);
		final TextBox imageURL = new TextBox();
		flexTable.setWidget(2, 1, imageURL);
		flexTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		
		Label lblurl_1 = new Label("\u8BF7\u8F93\u5165URL\u5730\u5740");
		lblurl_1.setStyleName("gwt-Label-small");
		flexTable.setWidget(2, 2, lblurl_1);
		
		Label label_2 = new Label("\u8D77\u4EF7");
		flexTable.setWidget(3, 0, label_2);
		
		TextBox textBox_2 = new TextBox();
		flexTable.setWidget(3, 1, textBox_2);
		final TextBox basePrice = new TextBox();
		flexTable.setWidget(3, 1, basePrice);
		
		Label label_4 = new Label("\u622A\u6B62\u65E5\u671F");
		flexTable.setWidget(4, 0, label_4);
		
		DateBox dateBox = new DateBox();
		final DateBox dateBox = new DateBox();
		flexTable.setWidget(4, 1, dateBox);
		
		Label label_5 = new Label("\u622A\u6B62\u65F6\u95F4");
		flexTable.setWidget(5, 0, label_5);
		
		ListBox comboBox = new ListBox();
		comboBox.addItem("00\uFF1A00");
		comboBox.addItem("01\uFF1A00");
		comboBox.addItem("02\uFF1A00");
		comboBox.addItem("03\uFF1A00");
		comboBox.addItem("04\uFF1A00");
		comboBox.addItem("05\uFF1A00");
		comboBox.addItem("06\uFF1A00");
		comboBox.addItem("07\uFF1A00");
		comboBox.addItem("08\uFF1A00");
		comboBox.addItem("09\uFF1A00");
		comboBox.addItem("10\uFF1A00");
		comboBox.addItem("11\uFF1A00");
		comboBox.addItem("12\uFF1A00");
		comboBox.addItem("13\uFF1A00");
		comboBox.addItem("14\uFF1A00");
		comboBox.addItem("15\uFF1A00");
		comboBox.addItem("16\uFF1A00");
		comboBox.addItem("17\uFF1A00");
		comboBox.addItem("18\uFF1A00");
		comboBox.addItem("19\uFF1A00");
		comboBox.addItem("20\uFF1A00");
		comboBox.addItem("21\uFF1A00");
		comboBox.addItem("22\uFF1A00");
		comboBox.addItem("23\uFF1A00");
		flexTable.setWidget(5, 1, comboBox);
		
		Label label_3 = new Label("\u5206\u7C7B\u76EE\u5F55");
		flexTable.setWidget(6, 0, label_3);
		
		ListBox comboBox_1 = new ListBox();
		flexTable.setWidget(6, 1, comboBox_1);
		final ListBox category = new ListBox();
		getCategories(category);
		
		flexTable.setWidget(6, 1, category);
		
		Label label_6 = new Label("\u7269\u54C1\u63CF\u8FF0");
		flexTable.setWidget(7, 0, label_6);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flexTable.setWidget(7, 1, verticalPanel);
			
		RichTextArea richTextArea = new RichTextArea();	
		final RichTextArea des = new RichTextArea();	
		
		RichTextToolbar richTextToolbar = new RichTextToolbar((RichTextArea) richTextArea);
		RichTextToolbar richTextToolbar = new RichTextToolbar((RichTextArea) des);
		verticalPanel.add(richTextToolbar);
		verticalPanel.add(richTextArea);
		verticalPanel.add(des);
		
		Button submit = new Button("\u63D0\u4EA4\uFF01");
		flexTable.setWidget(8, 0, submit);
		flexTable.getFlexCellFormatter().setColSpan(8, 0, 2);
		flexTable.getCellFormatter().setHorizontalAlignment(8, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		final Label error = new Label("");
		flexTable.setWidget(9, 0, error);
		flexTable.getCellFormatter().setVisible(9, 0, false);
		//flexTable.getCellFormatter().setVisible(9, 0, false);
		flexTable.getFlexCellFormatter().setColSpan(9, 0, 2);

		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				error.setText("");
				postItemService.postItem(new Item(), new AsyncCallback<Boolean>(){
				error.setVisible(false);
				
				int i = category.getSelectedIndex();
				
				Item item = new Item
				(itemName.getText(),des.toString(), 
						Double.parseDouble(basePrice.getText()),
						cateList.get(i).getId(),"",dateBox.getValue(),
						imageURL.getText());
				
				postItemService.postItem(item, new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						error.setText("RPC call failed");
						
						error.setText("RPC call failed");
						error.setVisible(true);
					}

					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						if (result.equals(Boolean.TRUE))
							error.setText("Success!");
						else
							error.setText("Failed! Please try again.");
					}
					
						error.setVisible(true);
					}					
				});
			}
			  
			}			  
		  });
	}

	
	void getCategories(final ListBox category){
		postGetCategoriesService.getCategories(new AsyncCallback<List<Category>>(){
			public void onFailure(Throwable caught) {
				System.out.println(caught.toString());
			}
			public void onSuccess(List<Category> result) {
				for (int i = 0; i < result.size(); i++) {
					cateList.add(result.get(i));
					category.addItem(result.get(i).getName());
				}			
			}
		});
	}
}
