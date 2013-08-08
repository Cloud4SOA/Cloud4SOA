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

package eu.cloud4soa.frontend.commons.client.utils;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.dialog.KeysFormDialog;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;

public  class  PaaSCommandManagement{
	private UserManagementAndSecurityServiceAsync userService = GWT.create(UserManagementAndSecurityService.class);
	private String publicKey;
	private String privateKey;
	private String accountName;
	
	public <T extends PaaSCommandExecution>  void managePaaSCommand(
			final LayoutContainer view, final T commander, 
			final String message, final C4SCommand command,
			final ApplicationModel application) {
		
		//Get user account for PaaS keys from the SOA layer
        userService.readUserCredentialsForPaaS(application.<String>get(ApplicationModel.PAAS_PROVIDER_URIID),
                new AsyncCallback<UserCredentialsModel>(){

					@Override
					public void onFailure(Throwable caught) {
						promptUserForKeys(view, message, command, application, commander);
					}

					@Override
					public void onSuccess(UserCredentialsModel result) {
						
						if (result!=null){ //Credentials obtained
							publicKey = result.<String>get(UserCredentialsModel.PUBLIC_KEY);
							privateKey = result.<String>get(UserCredentialsModel.PRIVATE_KEY);
							accountName = result.<String>get(UserCredentialsModel.ACCOUNT_NAME);
														
							promptUserForConfirmation(view, message, command, application, commander);
						}else{
							promptUserForKeys(view, message, command, application, commander);
						}	
					}
		});
	}

	private void promptUserForConfirmation(LayoutContainer container,  
			 String message,  final C4SCommand command,
			 final ApplicationModel application, final PaaSCommandExecution commander) {
		final Dialog dialog = DialogHelper.showConfirmationDialog("Confirmation", message);
		
		Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Accepted", "Apply " + command
						+ " on application " + application.getTitle());
				
				dialog.hide();
				
				executeCommand(command, application, commander, false);
			}
		};	
		dialog.getButtonById(Dialog.YES).addSelectionListener((SelectionListener<ButtonEvent>) onOKEvent);
		
		Listener<ButtonEvent> onCancelEvent = new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Rejected", "Apply " + command
						+ " on application " + application);
				dialog.hide();
				//Ignored
			}
		};
		dialog.getButtonById(Dialog.NO).addSelectionListener((SelectionListener<ButtonEvent>) onCancelEvent);
	}
	
	private void promptUserForKeys(LayoutContainer container,  
			 String message,  final C4SCommand command,
			 final ApplicationModel application, final PaaSCommandExecution commander) {
		
		final KeysFormDialog dialog = new KeysFormDialog(message, (String)application.get(ApplicationModel.PAAS_PROVIDER));
		container.layout();
		Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Accepted", "Apply " + command
						+ " on application " + application.getTitle());
				
				publicKey = dialog.getPublicKey();
				privateKey = dialog.getPrivateKey();
				accountName = dialog.getAccountName();
				
				dialog.hide();
				
				executeCommand(command, application, commander, true);
			}
		};							
		dialog.setOKEvent(onOKEvent);
		
		Listener<ButtonEvent> onCancelEvent = new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Rejected", "Apply " + command
						+ " on application " + application);
				dialog.hide();
				//Ignored
			}
		};
		dialog.setCancelEvent(onCancelEvent);
		dialog.show();
	}
	
	private void executeCommand (final C4SCommand command,
			final ApplicationModel application, final PaaSCommandExecution commander, boolean saveCredentials){
		
		if (saveCredentials){
			UserCredentialsModel credentials = new UserCredentialsModel();
			credentials.set(UserCredentialsModel.USER_URIID, application.get(ApplicationModel.OWNER_URIID));
			credentials.set(UserCredentialsModel.PAAS_URIID, application.get(ApplicationModel.PAAS_PROVIDER_URIID));
			credentials.set(UserCredentialsModel.PUBLIC_KEY, publicKey);
			credentials.set(UserCredentialsModel.PRIVATE_KEY, privateKey);
			credentials.set(UserCredentialsModel.ACCOUNT_NAME, accountName);
			
			userService.storeUserCredentialsForPaaS(credentials,
					new AsyncCallback<Void>(){

						@Override
						public void onFailure(Throwable caught) {
							GWT.log("Error storing user credentials for PaaS");
							commander.executeCommand(application, command, publicKey, privateKey);
						}


						@Override
						public void onSuccess(Void result) {
							GWT.log("Successful store of user credentials for PaaS");
							commander.executeCommand(application, command, publicKey, privateKey);
						}
				
			});
		}
		
		commander.executeCommand(application, command, publicKey, privateKey);
	}

}


