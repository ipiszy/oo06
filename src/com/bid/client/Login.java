package com.bid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Login implements EntryPoint {

	private final ILoginServiceAsync logInService = GWT
			.create(ILoginService.class);

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub

		final Label idLabel = new Label("Id: ");
		final TextBox idBox = new TextBox();
		final Label passLabel = new Label("Password: ");
		final PasswordTextBox passBox = new PasswordTextBox();
		final CheckBox stayCheck = new CheckBox();
		final Label stayLabel = new Label("Stay Sign In");
		final Button logInButton = new Button("Sign In");
		final Label error = new Label();
		error.setStyleName("error");

		final HTML signupHTML = new HTML(
				"<div class=\"hand\" " +
				"onclick=\"document.location=\'/bid/Bid.html\'\">" +
				"<a id=\"buyerSignUpLink\" style=\"text-decoration: none;\" " +
				"href=\"/bid/Bid.html\"><span class=\"signup\">" +
				"Sign up now </span></a></div>");
		
		final Label signupLabel = new Label();
		signupLabel.setStyleName("hand");
		signupLabel.addStyleName("text-decoration: none;");

		RootPanel.get("IdLabel").add(idLabel);
		RootPanel.get("IdContainer").add(idBox);
		RootPanel.get("PassLabel").add(passLabel);
		RootPanel.get("PasswdContainer").add(passBox);
		RootPanel.get("StayCheck").add(stayCheck);
		RootPanel.get("StayLabel").add(stayLabel);
		RootPanel.get("SubmitContainer").add(logInButton);
		RootPanel.get("ErrorContainer").add(error);
		RootPanel.get("SignupBackground").add(signupHTML);

		idBox.setFocus(true);
		idBox.selectAll();

		class LogInHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				logIn();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					logIn();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void logIn() {
				logInService.logIn(idBox.getText(), passBox.getText(),
						new AsyncCallback<Boolean>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								error
										.setText("Remote Procedure Call - Failure");
							}

							public void onSuccess(Boolean result) {
								if (result.equals(result.TRUE)) {

								} else {
									error.setText("id or password false");
									idBox.setFocus(true);
								}

							}
						});
			}
		}

		// Add a handler to send the name to the server
		LogInHandler handler = new LogInHandler();
		logInButton.addClickHandler(handler);
		passBox.addKeyUpHandler(handler);

	}

}
