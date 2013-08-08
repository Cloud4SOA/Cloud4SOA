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
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT Implementation of the "createDB" view.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class CreateDBViewGxtImpl extends ContentPanel implements CreateDBView {

	private Presenter presenter;

	Button createDBButton;

	FileUploadField dbInitializationfileUpload;
	SoftwareComponentModel softwareComponentModel;

	FormPanel dbForm;
	FieldSet dbFieldSet;

	public CreateDBViewGxtImpl() {

		initializeView();

	}

	// Single column layout, multiple forms
	private void initializeView() {
		setBodyBorder(true);
		addStyleName("c4s-white-bg");
		setHeading("Application Deployment: Create Database");

		FormData formData = new FormData("100%");

		LayoutContainer vc = new LayoutContainer();
		vc.setLayout(new RowLayout(Orientation.VERTICAL));

		add(vc);

		// DBSoftwareComponent
		dbForm = new FormPanel();
		dbForm.setHeaderVisible(false);
		dbFieldSet = new FieldSet();

		dbForm.add(dbFieldSet, formData);

		dbFieldSet.setHeading("Database");
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

		createDBButton = new Button("Create DB");
		dbForm.setButtonAlign(HorizontalAlignment.CENTER);
//		dbForm.getButtonBar().add(createDBButton);

		FormButtonBinding binding = new FormButtonBinding(dbForm);
		binding.addButton(createDBButton);

		createDBButton.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				// Checking passwords
				if (!getSoftwareComponentModel().<String> get(
						SoftwareComponentModel.DB_PASSWORD).equals(
						getSoftwareComponentModel().<String> get(
								SoftwareComponentModel.DB_PASSWORD2))) {
					// Passwords don't match. Warning.
					DialogHelper
							.showErrorDialog("Passwords don't match. Please, enter new passwords");
					// Resetting passwords
					getSoftwareComponentModel().set(
							SoftwareComponentModel.DB_PASSWORD, null);
					getSoftwareComponentModel().set(
							SoftwareComponentModel.DB_PASSWORD2, null);
					bindDBForm(getSoftwareComponentModel());
				} else {
					presenter.onDBCreationClick();
				}
			}
		});
		
		Button cancelButton = new Button("Cancel");
		add (cancelButton);
		
		cancelButton.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				presenter.onCancelDBCreationClick();
			}
		});

		ToolBar toolbar = new ToolBar();
		toolbar.addStyleName("c4s-white-bg");
		
		toolbar.add(new FillToolItem());
		toolbar.add(cancelButton);
		toolbar.add(createDBButton);		
		
		setBottomComponent(toolbar);
		
		// Handling completed archive submission
		dbForm.addListener(Events.Submit, new Listener<FormEvent>() {
			@Override
			public void handleEvent(FormEvent be) {
				presenter.onDBCreationUploadComplete();
			}
		});
	}

	@Override
	public void bindDBForm(SoftwareComponentModel softwareComponentModel) {
		this.softwareComponentModel = softwareComponentModel;

		dbFieldSet.removeAll();

		// build the application details form
		MetadataCache.getInstance().buildDynamicForm(
				MetadataMapper.CONTEXT_DBCREATION_FORM, softwareComponentModel,
				dbFieldSet, new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						Info.display("error",
								"Something went wrong: " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {

						dbInitializationfileUpload = new FileUploadField();
						dbInitializationfileUpload
								.setFieldLabel("DB Initialization Script");
						dbInitializationfileUpload.setAllowBlank(true);
						// without a name file upload doesn't work on FF
						dbInitializationfileUpload.setName("app-binary");
						dbFieldSet.add(dbInitializationfileUpload);

						FormBinding formBinding = new FormBinding(dbForm, true);
						formBinding.bind(getSoftwareComponentModel());
						formBinding.setUpdateOriginalValue(true);

						dbForm.layout();

					}
				});
	}

	/**
	 * @return
	 */
	private SoftwareComponentModel getSoftwareComponentModel() {
		return softwareComponentModel;
	}

	@Override
	public void submitDBInitializationFiles() {
		dbForm.submit();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.cloud4soa.frontend.widget.usermanagement.client.views.CreateDBView
	 * #isInitializationRequested()
	 */
	@Override
	public boolean isInitializationRequested() {
		return dbInitializationfileUpload.getValue() != null
				&& !dbInitializationfileUpload.getValue().isEmpty();
	}

}
