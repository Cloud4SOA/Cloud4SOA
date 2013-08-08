package com.cloud4soa.facetedsearch.client;

import com.cloud4soa.facetedsearch.client.ui.FacetedSearch;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class C4S_FacetedSearch implements EntryPoint {
	
	private static final String SERVER_ERROR = "An error occurred while attempting to contact the server. Please check your network connection and try again.";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		FacetedSearch fsearch = new FacetedSearch();
		RootPanel.get("facetedsearch-main").add(fsearch);
	}
	
	
}

/*
final Button sendButton = new Button("Send");
final TextBox nameField = new TextBox();
nameField.setText("GWT User");
final Label errorLabel = new Label();

// We can add style names to widgets
sendButton.addStyleName("sendButton");

// Add the nameField and sendButton to the RootPanel
// Use RootPanel.get() to get the entire body element
RootPanel.get("facetedsearch-main").add(nameField);
RootPanel.get("facetedsearch-main").add(sendButton);
RootPanel.get("facetedsearch-main").add(errorLabel);

// Focus the cursor on the name field when the app loads
nameField.setFocus(true);
nameField.selectAll();

// Create the popup dialog box
final DialogBox dialogBox = new DialogBox();
dialogBox.setText("Remote Procedure Call");
dialogBox.setAnimationEnabled(true);
final Button closeButton = new Button("Close");
// We can set the id of a widget by accessing its Element
closeButton.getElement().setId("closeButton");
final Label textToServerLabel = new Label();
final HTML serverResponseLabel = new HTML();
VerticalPanel dialogVPanel = new VerticalPanel();
dialogVPanel.addStyleName("dialogVPanel");
dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
dialogVPanel.add(textToServerLabel);
dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
dialogVPanel.add(serverResponseLabel);
dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
dialogVPanel.add(closeButton);
dialogBox.setWidget(dialogVPanel);

// Add a handler to close the DialogBox
closeButton.addClickHandler(new ClickHandler() {
	public void onClick(ClickEvent event) {
		dialogBox.hide();
		sendButton.setEnabled(true);
		sendButton.setFocus(true);
	}
});

// Create a handler for the sendButton and nameField
class MyHandler implements ClickHandler, KeyUpHandler {
	//Fired when the user clicks on the sendButton.
	public void onClick(ClickEvent event) {
		sendNameToServer();
	}

	 //Fired when the user types in the nameField.
	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			sendNameToServer();
		}
	}

	//Send the name from the nameField to the server and wait for a response.
	private void sendNameToServer() {
		// First, we validate the input.
		errorLabel.setText("");
		String textToServer = nameField.getText();
		if (!FieldVerifier.isValidName(textToServer)) {
			errorLabel.setText("Please enter at least four characters");
			return;
		}

		// Then, we send the input to the server.
		sendButton.setEnabled(false);
		textToServerLabel.setText(textToServer);
		serverResponseLabel.setText("");
		greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox
								.setText("Remote Procedure Call - Failure");
						serverResponseLabel
								.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel
								.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
	}
}

// Add a handler to send the name to the server
MyHandler handler = new MyHandler();
sendButton.addClickHandler(handler);
nameField.addKeyUpHandler(handler);
*/
