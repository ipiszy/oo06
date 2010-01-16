package com.bid.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class registerform extends Composite {

	public registerform() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("452px", "492px");
		
		Label lblUsername = new Label("\u7528\u6237\u540D");
		absolutePanel.add(lblUsername, 20, 76);
		lblUsername.setSize("139px", "68px");
		
		TextBox textBox = new TextBox();
		absolutePanel.add(textBox, 180, 76);
		
		Label lblPassword = new Label("\u5BC6\u7801");
		absolutePanel.add(lblPassword, 20, 121);
		lblPassword.setSize("82px", "24px");
		
		PasswordTextBox passwordTextBox = new PasswordTextBox();
		absolutePanel.add(passwordTextBox, 180, 121);
		passwordTextBox.setSize("216px", "34px");
		
		Label lblConfirmPassword = new Label("\u786E\u8BA4\u5BC6\u7801");
		absolutePanel.add(lblConfirmPassword, 20, 166);
		lblConfirmPassword.setSize("221px", "56px");
		
		PasswordTextBox passwordTextBox_1 = new PasswordTextBox();
		absolutePanel.add(passwordTextBox_1, 180, 166);
		passwordTextBox_1.setSize("216px", "34px");
		
		Label lblBankAccount = new Label("\u94F6\u884C\u8D26\u6237");
		absolutePanel.add(lblBankAccount, 20, 211);
		lblBankAccount.setSize("160px", "24px");
		
		TextBox textBox_3 = new TextBox();
		absolutePanel.add(textBox_3, 180, 211);
		
		Label lblEmail = new Label("\u90AE\u7BB1");
		absolutePanel.add(lblEmail, 20, 256);
		lblEmail.setSize("82px", "24px");
		
		TextBox textBox_4 = new TextBox();
		absolutePanel.add(textBox_4, 180, 256);
		
		Label lblOthers = new Label("\u5176\u4ED6");
		absolutePanel.add(lblOthers, 20, 301);
		lblOthers.setSize("82px", "24px");
		
		TextBox textBox_5 = new TextBox();
		absolutePanel.add(textBox_5, 180, 301);
		
		Label lblRegisterSheet = new Label("\u7528\u6237\u6CE8\u518C");
		lblRegisterSheet.setStyleName("gwt-Label1");
		absolutePanel.add(lblRegisterSheet, 3, 3);
		lblRegisterSheet.setSize("467px", "63px");
		
		Button button = new Button("New button");
		button.setText("\u6211\u8981\u6CE8\u518C^^");
		absolutePanel.add(button, 80, 361);
		button.setSize("100", "35");
		
		Button button_1 = new Button("New button");
		button_1.setText("\u6211\u8981\u91CD\u586B~~");
		absolutePanel.add(button_1, 236, 360);
		button_1.setSize("100", "35");
		
		Label lblL = new Label("");
		absolutePanel.add(lblL, 88, 421);
	}
}
