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

package eu.cloud4soa.frontend.widget.deployment.client.views;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;

/**
 * GXT Implementation of the "deploy application" view.
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public abstract class DeployApplicationViewGxtImpl extends Composite implements
		DeployApplicationView {

	private Presenter presenter;

	interface Binder extends UiBinder<Component, DeployApplicationViewGxtImpl> {
	}

	private static Binder binder = GWT.create(Binder.class);

	private TextField<String> offerName;

	private TextField<String> paaSProvider;

	private TextField<String> publicKey;

	private TextField<String> secretKey;

	private TextField<String> accountName;

	private TextField<String> applicationName;

	private TextField<String> applicationVersion;

	private TextField<String> applicationDescription;

	@UiField
	Button deployButton;

	FileUploadField fileUpload;

	@UiField
	FormPanel uploadFormPanel;

	public DeployApplicationViewGxtImpl() {
		initComponent(binder.createAndBindUi(this));

		LayoutContainer columnContainer = new LayoutContainer();
		columnContainer.setLayout(new ColumnLayout());

		FormData formData = new FormData("100%");

		FieldSet providerFieldSet = new FieldSet();
		FormLayout providerFormLayout = new FormLayout();
		providerFormLayout.setLabelAlign(FormPanel.LabelAlign.TOP);
		providerFieldSet.setLayout(providerFormLayout);
		providerFieldSet.setStyleAttribute("padding", "8px");
		providerFieldSet.setHeading("PaaS Provider");
		providerFieldSet.setCheckboxToggle(false);
		providerFieldSet.setCollapsible(false);

		LayoutContainer leftColumn = new LayoutContainer();
		leftColumn.setLayout(new FlowLayout());
		leftColumn.add(providerFieldSet, new FlowData(3));

		FieldSet applicationFieldSet = new FieldSet();
		FormLayout rightColumnLayout = new FormLayout();
		rightColumnLayout.setLabelAlign(FormPanel.LabelAlign.TOP);
		applicationFieldSet.setLayout(rightColumnLayout);
		applicationFieldSet.setStyleAttribute("padding", "8px");
		applicationFieldSet.setHeading("Application");
		applicationFieldSet.setCheckboxToggle(false);
		applicationFieldSet.setCollapsible(false);

		LayoutContainer rightColumn = new LayoutContainer();
		rightColumn.setLayout(new FlowLayout());
		rightColumn.add(applicationFieldSet, new FlowData(3));

		offerName = new TextField<String>();
		offerName.setFieldLabel("Offer Name");
		providerFieldSet.add(offerName, formData);

		paaSProvider = new TextField<String>();
		paaSProvider.setFieldLabel("Provider");
		providerFieldSet.add(paaSProvider, formData);

		publicKey = new TextField<String>();
		publicKey.setFieldLabel("Public Key");
		publicKey.setAllowBlank(false);
		providerFieldSet.add(publicKey, formData);

		secretKey = new TextField<String>();
		secretKey.setPassword(true);
		secretKey.setFieldLabel("Secret Key");
		secretKey.setAllowBlank(false);
		providerFieldSet.add(secretKey, formData);

		accountName = new TextField<String>();
		accountName.setFieldLabel("Account name");
		providerFieldSet.add(accountName, formData);

		applicationName = new TextField<String>();
		applicationName.setFieldLabel("Name");
		applicationName.setAllowBlank(false);
		applicationFieldSet.add(applicationName, formData);

		applicationVersion = new TextField<String>();
		applicationVersion.setFieldLabel("Version");
		applicationFieldSet.add(applicationVersion, formData);

		applicationDescription = new TextField<String>();
		applicationDescription.setFieldLabel("Description");
		applicationFieldSet.add(applicationDescription, formData);

		fileUpload = new FileUploadField();
		fileUpload.setFieldLabel("Application binary");
		fileUpload.setAllowBlank(false);
		// without a name file upload doesn't work on FF
		fileUpload.setName("app-binary");
		applicationFieldSet.add(fileUpload, formData);

		columnContainer.add(leftColumn, new ColumnData(.5));
		columnContainer.add(rightColumn, new ColumnData(.5));

		uploadFormPanel.add(columnContainer, new FormData("100%"));

		uploadFormPanel.setEncoding(FormPanel.Encoding.MULTIPART);
		uploadFormPanel.setMethod(FormPanel.Method.POST);
		uploadFormPanel.setAction("applicationArtifactUpload");

		FormButtonBinding binding = new FormButtonBinding(uploadFormPanel);
		binding.addButton(deployButton);

	}

	// @Override
	// public HasValue<String> getOfferName() {
	// return new GxtValue<String>(offerName);
	// }
	//
	// @Override
	// public HasValue<String> getPaaSProvider() {
	// return new GxtValue<String>(paaSProvider);
	// }
	//
	// @Override
	// public HasValue<String> getPublicKey() {
	// return new GxtValue<String>(publicKey);
	// }
	//
	// @Override
	// public HasValue<String> getSecretKey() {
	// return new GxtValue<String>(secretKey);
	// }
	//
	// @Override
	// public HasValue<String> getAccountName() {
	// return new GxtValue<String>(accountName);
	// }
	//
	// @Override
	// public HasValue<String> getApplicationName() {
	// return new GxtValue<String>(applicationName);
	// }
	//
	// @Override
	// public HasValue<String> getApplicationVersion() {
	// return new GxtValue<String>(applicationVersion);
	// }
	//
	// @Override
	// public HasValue<String> getApplicationDescription() {
	// return new GxtValue<String>(applicationDescription);
	// }

	@Override
	public void submitFile() {
		uploadFormPanel.submit();
	}

	@GxtUiHandler(uiField = "deployButton", eventType = GxtEvent.Select)
	public void handleDeployButtonClick(ButtonEvent event) {
		presenter.onDeployClick();
	}

	@GxtUiHandler(uiField = "uploadFormPanel", eventType = GxtEvent.Submit)
	public void handleSubmitComplete(FormEvent event) {
		presenter.onDeployUploadComplete();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
