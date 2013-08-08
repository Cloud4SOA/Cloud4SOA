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

package eu.cloud4soa.frontend.widget.usermanagement.client.views;

import java.util.List;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeListener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT implementation of the offer editor.
 * 
 * @author Stefano Travelli (Cyntelix)
 * @author Yosu Gorroñogoitia (Atos)
 */
public class OfferEditorROViewGxtImpl extends Composite implements
		OfferEditorROView {

	interface Binder extends UiBinder<Component, OfferEditorROViewGxtImpl> {
	}

	private Presenter presenter;

	private static Binder binder = GWT.create(Binder.class);

	@UiField
	FormPanel offerDetailsForm;

	@UiField
	ContentPanel softwareComponentsPanel;

	@UiField
	ContentPanel hardwareComponentsPanel;

	@UiField
	FieldSet offerDetailsFieldSet;

	@UiField
	VerticalPanel mainPanel;

	public OfferEditorROViewGxtImpl() {
		initComponent(binder.createAndBindUi(this));

		// setHeight(200);

		FormLayout detailsFormLayout = new FormLayout();
		detailsFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
		detailsFormLayout.setLabelWidth(200);
		detailsFormLayout.setLabelPad(10);
		offerDetailsFieldSet.setLayout(detailsFormLayout);

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void bindPaaSOffering(final PaaSOfferingModel paaSOfferingModel) {

		if (paaSOfferingModel == null) {
			mainPanel.setVisible(false);
		} else {
			mainPanel.setVisible(true);

			offerDetailsFieldSet.removeAll();

			// build the application details form
			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_OFFER_VIEWER, paaSOfferingModel,
					offerDetailsFieldSet, new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {

							FormBinding formBinding = new FormBinding(
									offerDetailsForm, true);
							formBinding.bind(paaSOfferingModel);
							formBinding.setUpdateOriginalValue(true);

							offerDetailsForm.layout();

						}
					});

			bindSoftwareComponents(paaSOfferingModel.getSoftwareComponents());

			bindHardwareComponents(paaSOfferingModel.getHardwareComponents());

			paaSOfferingModel.addChangeListener(new ChangeListener() {
				@Override
				public void modelChanged(ChangeEvent event) {
					Info.display("change", event.toString());
				}
			});

		}
	}

	private void bindHardwareComponents(
			List<HardwareComponentModel> hardwareComponents) {
		hardwareComponentsPanel.removeAll();

		for (final HardwareComponentModel hardwareComponentModel : hardwareComponents) {

			final FormPanel hardwareComponentFormPanel = new FormPanel();
			hardwareComponentFormPanel.setHeaderVisible(false);
			hardwareComponentFormPanel.setLayout(new FlowLayout());

			hardwareComponentsPanel.add(hardwareComponentFormPanel);

			final FieldSet hardwareComponentFieldSet = new FieldSet();
			hardwareComponentFieldSet.setCollapsible(false);
			hardwareComponentFieldSet.setExpanded(true);

			hardwareComponentFieldSet.setHeading(hardwareComponentModel
					.getFormTitle());

			FormLayout hardwareComponentFormLayout = new FormLayout();
			hardwareComponentFormLayout
					.setLabelAlign(FormPanel.LabelAlign.RIGHT);
			hardwareComponentFormLayout.setLabelWidth(200);
			hardwareComponentFormLayout.setLabelPad(10);

			hardwareComponentFieldSet.setLayout(hardwareComponentFormLayout);

			hardwareComponentFormPanel.add(hardwareComponentFieldSet);

			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_OFFER_VIEWER,
					hardwareComponentModel, hardwareComponentFieldSet,
					new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {
							FormBinding formBinding = new FormBinding(
									hardwareComponentFormPanel, true);
							formBinding.bind(hardwareComponentModel);
							formBinding.setUpdateOriginalValue(true);

							hardwareComponentsPanel.layout();
						}
					});

		}
	}

	private void bindSoftwareComponents(
			List<SoftwareComponentModel> softwareComponents) {
		softwareComponentsPanel.removeAll();

		for (final SoftwareComponentModel softwareComponentModel : softwareComponents) {

			final FormPanel softwareComponentFormPanel = new FormPanel();
			softwareComponentFormPanel.setHeaderVisible(false);
			softwareComponentFormPanel.setLayout(new FlowLayout());

			softwareComponentsPanel.add(softwareComponentFormPanel);

			final FieldSet softwareComponentFieldSet = new FieldSet();
			softwareComponentFieldSet.setCollapsible(false);
			softwareComponentFieldSet.setExpanded(true);

			softwareComponentFieldSet.setHeading(softwareComponentModel
					.getFormTitle());

			FormLayout softwareComponentFormLayout = new FormLayout();
			softwareComponentFormLayout
					.setLabelAlign(FormPanel.LabelAlign.RIGHT);
			softwareComponentFormLayout.setLabelWidth(200);
			softwareComponentFormLayout.setLabelPad(10);

			softwareComponentFieldSet.setLayout(softwareComponentFormLayout);

			softwareComponentFormPanel.add(softwareComponentFieldSet);

			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_OFFER_VIEWER,
					softwareComponentModel, softwareComponentFieldSet,
					new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {
							FormBinding formBinding = new FormBinding(
									softwareComponentFormPanel, true);
							formBinding.bind(softwareComponentModel);
							formBinding.setUpdateOriginalValue(true);

							softwareComponentsPanel.layout();
						}
					});
		}
	}

}
