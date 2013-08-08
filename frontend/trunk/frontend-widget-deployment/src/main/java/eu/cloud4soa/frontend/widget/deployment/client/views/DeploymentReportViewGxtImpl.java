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

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT Implementation of the "deploy application report" view.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class DeploymentReportViewGxtImpl extends ContentPanel implements
		DeploymentReportView {

	private Presenter presenter;

	Button acceptButton;

	FormPanel applicationForm;

	FieldSet applicationFieldSet;

	public DeploymentReportViewGxtImpl() {

		initializeView();

	}

	// Single column layout, multiple forms
	private void initializeView() {
		setBodyBorder(true);
		addStyleName("c4s-white-bg");
		setHeading("Deployment report");

		FormData formData = new FormData("100%");

		LayoutContainer vc = new LayoutContainer();
		vc.setLayout(new RowLayout(Orientation.VERTICAL));

		add(vc);

		FormLayout providerformLayout = new FormLayout();
		providerformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

		applicationForm = new FormPanel();
		applicationForm.setHeaderVisible(false);
		applicationFieldSet = new FieldSet();

		applicationForm.add(applicationFieldSet, formData);

		applicationFieldSet.setHeading("Application");
		applicationFieldSet.setCheckboxToggle(false);
		applicationFieldSet.setCollapsible(false);
		applicationFieldSet.setStyleAttribute("padding", "8px");

		FormLayout applicationformLayout = new FormLayout();
		applicationformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

		applicationFieldSet.setLayout(applicationformLayout);

		vc.add(applicationForm, new RowData(1, -1, new Margins(0)));

		applicationForm.setEncoding(FormPanel.Encoding.MULTIPART);
		applicationForm.setMethod(FormPanel.Method.POST);
		applicationForm.setAction("applicationArtifactUpload");

		acceptButton = new Button("Accept");
		applicationForm.setButtonAlign(HorizontalAlignment.CENTER);

		acceptButton.addListener(Events.Select, new Listener<ButtonEvent>() {

			@Override
			public void handleEvent(ButtonEvent be) {
				presenter.onDeploymentReportAcceptedClick();
			}
		});
		
		ToolBar toolbar = new ToolBar();
		toolbar.addStyleName("c4s-white-bg");
		
		toolbar.add(new FillToolItem());
		toolbar.add(acceptButton);	
		
		setBottomComponent(toolbar);
	}

	@Override
	public void bindDeploymentReportForm(final ApplicationModel applicationModel) {

		applicationFieldSet.removeAll();

		// build the application details form
		MetadataCache.getInstance().buildDynamicForm(
				MetadataMapper.CONTEXT_DEPLOYMENT_REPORT, applicationModel,
				applicationFieldSet, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						Info.display("error",
								"Something went wrong: " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {
						LabelField label = new LabelField();
						label.setText("Application sucessfully deployed");
						applicationFieldSet.add(label);

						FormBinding formBinding = new FormBinding(
								applicationForm, true);
						formBinding.bind(applicationModel);
						formBinding.setUpdateOriginalValue(true);

						applicationForm.layout();

					}
				});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
