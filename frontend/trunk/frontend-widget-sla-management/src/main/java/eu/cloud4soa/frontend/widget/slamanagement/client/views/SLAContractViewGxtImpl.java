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

package eu.cloud4soa.frontend.widget.slamanagement.client.views;

import java.util.List;

import com.extjs.gxt.ui.client.binding.FormBinding;
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

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermBLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermSLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT implementation of the SLA Contract view.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractViewGxtImpl extends Composite implements
		SLAContractView {

	interface Binder extends UiBinder<Component, SLAContractViewGxtImpl> {
	}

	private Presenter presenter;

	private static Binder binder = GWT.create(Binder.class);

	@UiField
	FormPanel sLAContractContextForm;

	@UiField
	FormPanel sLAContractServiceForm;

	@UiField
	ContentPanel gtPanel;

	@UiField
	FieldSet sLAContractContextFieldSet;

	@UiField
	FieldSet sLAContractServiceFieldSet;

	@UiField
	VerticalPanel mainPanel;

	public SLAContractViewGxtImpl() {
		initComponent(binder.createAndBindUi(this));

		// setHeight(200);

		FormLayout slaTemplateContextFormLayout = new FormLayout();
		slaTemplateContextFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
		slaTemplateContextFormLayout.setLabelWidth(200);
		slaTemplateContextFormLayout.setLabelPad(10);

		FormLayout slaTemplateServiceFormLayout = new FormLayout();
		slaTemplateServiceFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
		slaTemplateServiceFormLayout.setLabelWidth(200);
		slaTemplateServiceFormLayout.setLabelPad(10);

		sLAContractContextFieldSet.setLayout(slaTemplateContextFormLayout);
		sLAContractServiceFieldSet.setLayout(slaTemplateServiceFormLayout);

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void bindSLAContract(final SLAContractModel sLAContractModel) {

		if (sLAContractModel == null) {
			mainPanel.setVisible(false);
		} else {
			mainPanel.setVisible(true);

			sLAContractContextFieldSet.removeAll();
			sLAContractServiceFieldSet.removeAll();

			// build the application details form
			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_SLA_CONTRACT_EDITOR,
					sLAContractModel.getContext(), sLAContractContextFieldSet,
					new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {

							FormBinding formBinding = new FormBinding(
									sLAContractContextForm, true);
							formBinding.bind(sLAContractModel.getContext());
							formBinding.setUpdateOriginalValue(true);

							sLAContractContextForm.layout();

						}
					});

			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_SLA_CONTRACT_EDITOR,
					sLAContractModel.getService(), sLAContractServiceFieldSet,
					new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {

							FormBinding formBinding = new FormBinding(
									sLAContractServiceForm, true);
							formBinding.bind(sLAContractModel.getService());
							formBinding.setUpdateOriginalValue(true);

							sLAContractServiceForm.layout();

						}
					});

			bindSLAContractGuaranteeTerms(sLAContractModel.getGuaranteeTerms());

		}
	}

	private void bindSLAContractGuaranteeTerms(
			List<SLAContractGuaranteeTermModel> guaranteeTermsModel) {
		gtPanel.removeAll();

		for (final SLAContractGuaranteeTermModel gtModel : guaranteeTermsModel) {

			final FieldSet gtFieldSet = new FieldSet();
			gtFieldSet.setCollapsible(false);
			gtFieldSet.setExpanded(true);

			gtFieldSet.setHeading("Guarantee Term");
			gtPanel.add(gtFieldSet);

			// SLO
			final SLAContractGuaranteeTermSLOModel gtSLOModel = gtModel
					.getServiceLevelObjectives();

			final FormPanel gtSLOFormPanel = new FormPanel();
			gtSLOFormPanel.setHeaderVisible(false);
			gtSLOFormPanel.setLayout(new FlowLayout());

			gtFieldSet.add(gtSLOFormPanel);

			final FieldSet gtSLOFieldSet = new FieldSet();
			gtSLOFieldSet.setCollapsible(false);
			gtSLOFieldSet.setExpanded(true);

			gtSLOFieldSet.setHeading("Service Level Objectives");

			FormLayout gtSLOFormLayout = new FormLayout();
			gtSLOFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
			gtSLOFormLayout.setLabelWidth(200);
			gtSLOFormLayout.setLabelPad(10);

			gtSLOFieldSet.setLayout(gtSLOFormLayout);

			gtSLOFormPanel.add(gtSLOFieldSet);

			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_SLA_CONTRACT_EDITOR, gtSLOModel,
					gtSLOFieldSet, new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {
							FormBinding formBinding = new FormBinding(
									gtSLOFormPanel, true);
							formBinding.bind(gtSLOModel);
							formBinding.setUpdateOriginalValue(true);

							gtPanel.layout();
						}
					});

			// BLO
			final SLAContractGuaranteeTermBLOModel gtBLOModel = gtModel
					.getBusinessLevelObjectives();

			final FormPanel gtBLOFormPanel = new FormPanel();
			gtBLOFormPanel.setHeaderVisible(false);
			gtBLOFormPanel.setLayout(new FlowLayout());

			gtFieldSet.add(gtBLOFormPanel);

			final FieldSet gtBLOFieldSet = new FieldSet();
			gtBLOFieldSet.setCollapsible(false);
			gtBLOFieldSet.setExpanded(true);

			gtBLOFieldSet.setHeading("Business Level Objectives");

			FormLayout gtBLOFormLayout = new FormLayout();
			gtBLOFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
			gtBLOFormLayout.setLabelWidth(200);
			gtBLOFormLayout.setLabelPad(10);

			gtBLOFieldSet.setLayout(gtBLOFormLayout);

			gtBLOFormPanel.add(gtBLOFieldSet);

			MetadataCache.getInstance().buildDynamicForm(
					MetadataMapper.CONTEXT_SLA_CONTRACT_EDITOR, gtBLOModel,
					gtBLOFieldSet, new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							Info.display("error", "Something went wrong: "
									+ caught.toString());
						}

						@Override
						public void onSuccess(Void result) {
							FormBinding formBinding = new FormBinding(
									gtBLOFormPanel, true);
							formBinding.bind(gtBLOModel);
							formBinding.setUpdateOriginalValue(true);

							gtPanel.layout();
						}
					});
		}
	}
}
