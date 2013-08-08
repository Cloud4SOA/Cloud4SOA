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

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT Implementation of the PaaS Credentials view.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class PaaSCredentialsViewGxtImpl extends ContentPanel implements
		PaaSCredentialsView {

	private Presenter presenter;

	Button acceptButton;
	Button cancelButton;

	FormPanel providerForm;
	FormPanel credentialsForm;

	FieldSet providerFieldSet;
	FieldSet credentialsFieldSet;

	public PaaSCredentialsViewGxtImpl() {

		initializeView();

	}

	// Single column layout, multiple forms
	private void initializeView() {
		setBodyBorder(true);
		addStyleName("c4s-white-bg");
		setHeading("Application Deployment: PaaS Credentials");
		// setHeight(450);

		FormData formData = new FormData("100%");

		LayoutContainer vc = new LayoutContainer();
		vc.setLayout(new RowLayout(Orientation.VERTICAL));

		add(vc);

		providerForm = new FormPanel();
		providerForm.setHeaderVisible(false);
		credentialsForm = new FormPanel();
		credentialsForm.setHeaderVisible(false);

		providerFieldSet = new FieldSet();
		providerForm.add(providerFieldSet, formData);

		credentialsFieldSet = new FieldSet();
		credentialsForm.add(credentialsFieldSet, formData);

		providerFieldSet.setHeading("PaaS Provider");
		providerFieldSet.setCheckboxToggle(false);
		providerFieldSet.setCollapsible(false);
		providerFieldSet.setStyleAttribute("padding", "8px");

		FormLayout providerformLayout = new FormLayout();
		providerformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

		providerFieldSet.setLayout(providerformLayout);

		credentialsFieldSet.setHeading("User Credentials in PaaS Provider");
		credentialsFieldSet.setCheckboxToggle(false);
		credentialsFieldSet.setCollapsible(false);
		credentialsFieldSet.setStyleAttribute("padding", "8px");

		FormLayout credentialsformLayout = new FormLayout();
		credentialsformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);
		credentialsFieldSet.setLayout(credentialsformLayout);

		FormLayout applicationformLayout = new FormLayout();
		applicationformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

		// height=-1 Component computed size
		vc.add(providerForm, new RowData(1, -1, new Margins(0)));
		vc.add(credentialsForm, new RowData(1, -1, new Margins(0)));

		ToolBar toolbar = new ToolBar();
		toolbar.addStyleName("c4s-white-bg");
		
		acceptButton = new Button("Next");
		cancelButton = new Button("Cancel");
		
		toolbar.add(new FillToolItem());
		toolbar.add(cancelButton);
		toolbar.add(acceptButton);		
		
		setBottomComponent(toolbar);

		acceptButton.addListener(Events.Select, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				presenter.onCredentialsAccepted();
			}
		});

		cancelButton.addListener(Events.Select, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				presenter.onCredentialsCancelled();
			}
		});

		FormButtonBinding binding = new FormButtonBinding(credentialsForm);
		binding.addButton(acceptButton);
	}

	@Override
	public void bindPaaSOfferingForm(final PaaSOfferingModel paasOfferingModel) {

		providerFieldSet.removeAll();

		// build the application details form
		MetadataCache.getInstance().buildDynamicForm(
				MetadataMapper.CONTEXT_DEPLOYMENT_FORM, paasOfferingModel,
				providerFieldSet, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						Info.display("error",
								"Something went wrong: " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {

						FormBinding formBinding = new FormBinding(providerForm,
								true);
						formBinding.bind(paasOfferingModel);
						formBinding.setUpdateOriginalValue(true);

						providerForm.layout();

					}
				});
	}

	@Override
	public void bindCredentialsForm(final UserCredentialsModel credentialsModel) {

		credentialsFieldSet.removeAll();

		// build the application details form
		MetadataCache.getInstance().buildDynamicForm(
				MetadataMapper.CONTEXT_DEPLOYMENT_FORM, credentialsModel,
				credentialsFieldSet, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						Info.display("error",
								"Something went wrong: " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {

						FormBinding formBinding = new FormBinding(
								credentialsForm, true);
						formBinding.bind(credentialsModel);
						formBinding.setUpdateOriginalValue(true);

						credentialsForm.layout();

					}
				});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
