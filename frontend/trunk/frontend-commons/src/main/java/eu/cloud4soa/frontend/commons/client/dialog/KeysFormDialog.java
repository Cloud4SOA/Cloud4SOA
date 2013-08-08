/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.commons.client.dialog;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class KeysFormDialog extends Window {
	
	private TextField<String> publicKey;
	private TextField<String> privateKey;
	private TextField<String> accountName;
	
	private Listener<ButtonEvent> onOKEvent;
	private Listener<ButtonEvent> onCancelEvent;
	
	private String message;
	private String message2;
	
	private Button okButton;
	private Button cancelButton;
			
	public KeysFormDialog(String message, String provider) {
		this.message = message;
		this.message2 = "Please, provide your keys for " + provider;
		this.setHeading("Confirmation");
		this.setLayout(new RowLayout(Orientation.VERTICAL));
	}

	public void setOKEvent(Listener<ButtonEvent> onOKEvent) {
		this.onOKEvent = onOKEvent;
	}
	
	public void setCancelEvent(Listener<ButtonEvent> onCancelEvent) {
		this.onCancelEvent = onCancelEvent;
	}
	
	public String getAccountName(){
		return accountName.getValue();
	}
	
	public String getPublicKey(){
		return publicKey.getValue();
	}
	
	public String getPrivateKey(){
		return privateKey.getValue();
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index); 
	    createForm();  
		
		if (onOKEvent != null)
			okButton.addSelectionListener((SelectionListener<ButtonEvent>) onOKEvent);
		if (onCancelEvent != null)
			cancelButton.addSelectionListener((SelectionListener<ButtonEvent>) onCancelEvent);

	}
	
  private void createForm() { 
	    FormPanel form = new FormPanel();  
	    form.setHeaderVisible(false);
	    form.setFrame(true); 
	    
	    LabelField lblmessage1 = new LabelField (message);
	    LabelField lblmessage2 = new LabelField (message2);
	    form.add (lblmessage1, new FormData("100%"));
	    form.add (lblmessage2, new FormData("100%"));
	    
	    accountName = new TextField<String>();  
	    accountName.setFieldLabel("Account name");  
	    accountName.setAllowBlank(false);  
	    form.add(accountName, new FormData("90%"));  
	  
	    publicKey = new TextField<String>();  
	    publicKey.setFieldLabel("Public Key");  
	    publicKey.setAllowBlank(false);  
	    form.add(publicKey, new FormData("90%"));  
	  
	    privateKey = new TextField<String>();  
	    privateKey.setFieldLabel("Private Key");  
	    privateKey.setAllowBlank(false);  
	    privateKey.setPassword(true);
	    form.add(privateKey, new FormData("90%"));   
	  
	    okButton = new Button("OK");  
	    form.addButton(okButton);  
	    
	    cancelButton = new Button("Cancel");
	    form.addButton(cancelButton);  
	  
	    form.setButtonAlign(HorizontalAlignment.CENTER);  
	  
	    FormButtonBinding binding = new FormButtonBinding(form);  
	    binding.addButton(okButton);  
	  
	    add(form);  
	  }  
}