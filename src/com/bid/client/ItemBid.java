package com.bid.client;

import com.bid.exchange.Item;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;

public class ItemBid implements EntryPoint {

	private final FlexTable itemDetail = new FlexTable();
	private final FlexTable bidInfo = new FlexTable();
	private final Button wantBid = new Button("\u51FA\u4EF7\uFF01");
	private final DialogBox beginBid = new DialogBox();

	private final IGetItemServiceAsync getItemService = GWT
			.create(IGetItemService.class);

	private final IItemBidServiceAsync itemBidService = GWT
			.create(IItemBidService.class);

	private long itemId;

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub

		itemId = Long.parseLong(com.google.gwt.user.client.Window.Location
				.getParameter("itemId"));
		initWidget();
		RootPanel.get("gwt_item").add(itemDetail);
		RootPanel.get("bidding").add(wantBid);
		RootPanel.get("bidInfo").add(bidInfo);
		//RootPanel.get("beginBid").add(beginBid);
		getItem(itemDetail);
	}

	void initWidget() {
		FlexCellFormatter cellFormatter = itemDetail.getFlexCellFormatter();
		itemDetail.addStyleName("cw-FlexTable");
		itemDetail.setWidth("45em");
		itemDetail.setCellSpacing(5);
		itemDetail.setCellPadding(3);
		cellFormatter.setHorizontalAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_LEFT);
		// flexTable.setHTML(0, 0,
		// "<img src=\" + /resource/bidding_header.jpg\" alt=\".o0O Bidding\" border=\"0\" >");
		cellFormatter.setHorizontalAlignment(0, 1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		cellFormatter.setColSpan(0, 1, 2);
		
		wantBid.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				beginBid.show();
				
			}
			
		});

		beginBid.setText("\u51FA\u4EF7");
		beginBid.setGlassEnabled(true);
		
		final FlexTable beginBidTable = new FlexTable();
		// final HorizontalPanel beginBidPanel = new HorizontalPanel();
		beginBid.setWidget(beginBidTable);
		beginBidTable.setWidget(0, 0, new Label("\u8BF7\u8F93\u5165\u6240\u51FA\u4EF7\u683C\uFF1A"));
		final TextBox moneyBox = new TextBox();
		beginBidTable.setWidget(0, 1, moneyBox);
		final Button submitBid = new Button("出价!");
		beginBidTable.setWidget(0, 2, submitBid);
		final Button close = new Button("\u5173\u95ED");

		cellFormatter = beginBidTable.getFlexCellFormatter();
		cellFormatter.setColSpan(1, 0, 3);
		cellFormatter.setColSpan(2, 0, 3);

		beginBidTable.setWidget(1, 0, close);
		final Label error = new Label();
		beginBidTable.setWidget(2, 0, error);

		submitBid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				double money = Double.parseDouble(moneyBox.getText());
				itemBid(money);
				error.setText("");
			}

			void itemBid(double money) {
				itemBidService.itemBid(itemId, money,
						new AsyncCallback<Boolean>() {
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								error.setText("\u51FA\u9519\u5566\uFF01\u8BF7\u518D\u8BD5\u4E00\u6B21\uFF1A\uFF09");
							}

							@Override
							public void onSuccess(Boolean result) {
								// TODO Auto-generated method stub
								beginBid.hide();
								getItem(itemDetail);
							}

						});
			}
		});

		close.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				beginBid.hide();
			}

		});

		bidInfo.setWidget(0, 0, new Label("\u51FA\u4EF7\u4EBA"));
		bidInfo.setWidget(0, 1, new Label("\u6240\u51FA\u4EF7\u683C"));
		// bidInfo.setWidget(0, 2, new Label("出价时间"));

	}

	void getItem(final FlexTable itemDetail) {

		getItemService.getItem(itemId, new AsyncCallback<Item>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				System.out.println(caught.toString());
			}

			@Override
			public void onSuccess(Item result) {
				// TODO Auto-generated method stub
				if (result != null) {
					Image image = new Image();
					image.setUrl(result.getImageURL());
					itemDetail.setWidget(0, 1, image);

					FlexTable texts = new FlexTable();
					Label header = new Label(result.getItemName());
					TextArea des = new TextArea();
					des.setText(result.getItemDes());
					Label status = new Label("\u5F53\u524D\u72B6\u6001\uFF1A"
							+ result.getItemStatus());
					
					Label basePrice = new Label("\u8D77\u59CB\u4EF7\u683C\uFF1A"
							+ new Double(result.getItemFloorPrice()).toString());
					Label deadline = new Label("\u622A\u6B62\u65E5\u671F\uFF1A"
							+ result.getItemBidDeadline().toString());
					
					// Label latestPrice = new Label("当前价格：" + new
					// Double(result.getItemHighestBidPrice()).toString());
					// Label bidUser = new Label("当前价格出价人：" +
					// result.getItemHighestBidUserName());

					texts.setWidget(0, 0, header);
					texts.setWidget(1, 0, des);
					texts.setWidget(2, 0, status);
					texts.setWidget(3, 0, basePrice);
					texts.setWidget(4, 0, deadline);
					// texts.setWidget(5, 0, latestPrice);
					// texts.setWidget(6, 0, bidUser);

					itemDetail.setWidget(0, 2, texts);

					if (!result.getItemHighestBidUserName().equals("none")){
						bidInfo.setWidget(1, 0, new Label(result
							.getItemHighestBidUserName()));
						bidInfo.setWidget(1, 1, new Label(new Double(result
							.getItemHighestBidPrice()).toString()));
					// bidInfo.setWidget(1, 2, new
					// Label(result.getItemPostTimestamp().toString()));
					}
				}
			}
		});
	}
}
