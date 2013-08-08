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
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT Implementation of the createDB report view.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class DBCreationReportViewGxtImpl extends ContentPanel implements
		DBCreationReportView {

	private Presenter presenter;

	Button acceptButton;

	FileUploadField dbInitializationfileUpload;

	FormPanel dbForm;
	FieldSet dbFieldSet;

	public DBCreationReportViewGxtImpl() {

		initializeView();

	}

	// Single column layout, multiple forms
	private void initializeView() {
		setBodyBorder(true);
		addStyleName("c4s-white-bg");
		setHeading("Application Deployment: Database creation report");

		FormData formData = new FormData("100%");

		LayoutContainer vc = new LayoutContainer();
		vc.setLayout(new RowLayout(Orientation.VERTICAL));

		add(vc);

		// DBSoftwareComponent
		dbForm = new FormPanel();
		dbForm.setHeaderVisible(false);
		dbFieldSet = new FieldSet();

		dbForm.add(dbFieldSet, formData);

		dbFieldSet.setHeading("Database Information");
		dbFieldSet.setCheckboxToggle(false);
		dbFieldSet.setCollapsible(false);
		dbFieldSet.setStyleAttribute("padding", "8px");

		FormLayout applicationformLayout = new FormLayout();
		applicationformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

		dbFieldSet.setLayout(applicationformLayout);

		// height=-1 Component computed size
		vc.add(dbForm, new RowData(1, -1, new Margins(0)));

		dbForm.setEncoding(FormPanel.Encoding.MULTIPART);
		dbForm.setMethod(FormPanel.Method.POST);
		dbForm.setAction("applicationArtifactUpload");

		acceptButton = new Button("Accept");
		dbForm.setButtonAlign(HorizontalAlignment.CENTER);

		acceptButton.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				presenter.onDBCreationReportAcceptedClick();
			}
		});
		
		ToolBar toolbar = new ToolBar();
		toolbar.addStyleName("c4s-white-bg");
		
		toolbar.add(new FillToolItem());
		toolbar.add(acceptButton);	
		
		setBottomComponent(toolbar);
	}

	@Override
	public void bindDBCreationReportForm(
			final SoftwareComponentModel softwareComponentModel) {

		dbFieldSet.removeAll();

		// build the application details form
		MetadataCache.getInstance().buildDynamicForm(
				MetadataMapper.CONTEXT_DBCREATION_REPORT,
				softwareComponentModel, dbFieldSet, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						Info.display("error",
								"Something went wrong: " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {
						LabelField label = new LabelField();
						label.setText("Database sucessfully created");
						dbFieldSet.add(label);

						FormBinding formBinding = new FormBinding(dbForm, true);
						formBinding.bind(softwareComponentModel);
						formBinding.setUpdateOriginalValue(true);

						dbForm.layout();

					}
				});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
