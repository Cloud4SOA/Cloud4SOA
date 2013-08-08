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

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;

import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT implementation of the application editor.
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAPolicyEditorViewGxtImpl extends Composite implements SLAPolicyEditorView {

    interface Binder extends UiBinder<Component, SLAPolicyEditorViewGxtImpl> {
    }

    private Presenter presenter;

    private static Binder binder = GWT.create(Binder.class);

    @UiField
    VerticalPanel mainPanel;

    @UiField
    ContentPanel policiesPanel;

    @UiField
    Button addPolicyButton;

    @UiField
    ContentPanel editorPanel;

    @UiField
    Button cancelButton;
    
    @UiField
    Button nextButton;

    public SLAPolicyEditorViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));

        addPolicyButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonAdd()));
        addPolicyButton.setToolTip("Add a new SLA policy");
        
        nextButton.setToolTip("Proceed with deployment");
        cancelButton.setToolTip("Cancel deployment");
    }

    @GxtUiHandler(uiField = "addPolicyButton", eventType = GxtEvent.Select)
    public void handleSaveButtonClick(ButtonEvent buttonEvent) {
    	presenter.addSLAPolicy();
    }
    
    @GxtUiHandler(uiField = "cancelButton", eventType = GxtEvent.Select)
    public void handleCancelButtonClick(ButtonEvent buttonEvent) {
    	presenter.onSLAPolicyCancel();
    }
    
    @GxtUiHandler(uiField = "nextButton", eventType = GxtEvent.Select)
    public void handleNextButtonClick(ButtonEvent buttonEvent) {
    	presenter.onSLAPolicyDone();
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private boolean slaPoliciesDone;

    private void finalizeLayout() {
        if (slaPoliciesDone) {
            // everything is done

            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable reason) {
                    Info.display("error", reason.getMessage());
                }

                @Override
                public void onSuccess() {
                    mainPanel.layout();
                    mainPanel.setVisible(true);
                    scrollToSelectedWidget();
                }
            });
        }
    }

    private Container scrollHere;

    private void scrollToSelectedWidget() {
        if (isRendered()) {
            if (scrollHere == null) {
                editorPanel.getLayoutTarget().scrollTo("top", 0, new FxConfig(300));

            } else {
                int mainTop = mainPanel.getLayoutTarget().getY();
                int containerHeight = editorPanel.getHeight();
                int scrollTop = scrollHere.getLayoutTarget().getY();
                int scrollHeight = scrollHere.getHeight();
                editorPanel.getLayoutTarget().scrollTo("top", scrollTop - mainTop - containerHeight / 2 + scrollHeight / 2, new FxConfig(300));
                scrollHere.addStyleName("c4s-highlight-new-component");
            }
        }
    }

    @Override
	public void bindSLAPolicies(final List<SLAPolicyModel> slaPolicies) {
    	slaPoliciesDone = slaPolicies.isEmpty();
        policiesPanel.removeAll();

        for (int i = 0; i < slaPolicies.size(); i++) {

            final SLAPolicyModel slaPolicyModel = slaPolicies.get(i);

            final FormPanel slaPolicyFormPanel = new FormPanel();
            slaPolicyFormPanel.setHeaderVisible(false);
            slaPolicyFormPanel.setLayout(new FlowLayout());

            policiesPanel.add(slaPolicyFormPanel);


            final FieldSet slaPolicyFieldSet = new FieldSet();
            slaPolicyFieldSet.setCollapsible(false);
            slaPolicyFieldSet.setExpanded(true);

            slaPolicyFieldSet.setHeading("SLA Policy");

            FormLayout slaPolicyFormLayout = new FormLayout();
            slaPolicyFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
            slaPolicyFormLayout.setLabelWidth(200);
            slaPolicyFormLayout.setLabelPad(10);

            slaPolicyFieldSet.setLayout(slaPolicyFormLayout);

            slaPolicyFormPanel.add(slaPolicyFieldSet);

            if (Boolean.TRUE.equals(slaPolicyModel.get(Strings.NEW_COMPONENT))) {
            	slaPolicyModel.set(Strings.NEW_COMPONENT, false);
                scrollHere = slaPolicyFieldSet;
            }

            final int currentIndex = i;

            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_SLA_POLICY_EDITOR, slaPolicyModel, slaPolicyFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                    slaPoliciesDone = true;
                    finalizeLayout();
                }

                @Override
                public void onSuccess(Void result) {
                    FormBinding formBinding = new FormBinding(slaPolicyFormPanel, true);
                    formBinding.bind(slaPolicyModel);
                    formBinding.setUpdateOriginalValue(true);
                    

                    //Detect combobox widget changes to populate expression text form
                    //Detect changes in policy for validation
//                    List<Component> items = slaPolicyFieldSet.getItems();
//                    
//                    ComboBox cbItem = null;
//                    TextField tfExp = null;
//             
//                    
//                    for (Component item: items){
//                    	if (item instanceof ComboBox)
//                    		cbItem = (ComboBox) item;
//                    	else if (item instanceof TextField)
//                    		if (((TextField)item).getName().equals (SLAPolicyModel.EXPRESSION))
//                    			tfExp = (TextField) item;
//                    }
//                    
//                    final ComboBox cbMetricType = cbItem;
//                    final TextField tfExpression = tfExp;
//                    
//                    if (cbMetricType!=null && tfExpression!=null){
//                    	cbMetricType.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
//
//							@Override
//							public void selectionChanged(SelectionChangedEvent<ModelData> se) {
//								tfExpression.setValue(se.getSelectedItem().get(SLAPolicyModel.EXPRESSION));
//								slaPolicyModel.set(SLAPolicyModel.EXPRESSION, se.getSelectedItem().get(SLAPolicyModel.EXPRESSION));
//							}
//						});
//                    }
                    
                   
                    ToolBar toolBar = new ToolBar();
                    toolBar.addStyleName("c4s-remove-border");
                    toolBar.addStyleName("c4s-white-bg");
                    toolBar.setAlignment(Style.HorizontalAlignment.RIGHT);

                    Button removeButton = new Button("Remove", new SelectionListener<ButtonEvent>() {
                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            presenter.onSLAPolicyDeleteButtonClick(slaPolicyModel);
                        }
                    });
                    removeButton.setToolTip("Remove the SLA policy");

                    removeButton.setScale(Style.ButtonScale.LARGE);
                    removeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
                    removeButton.setIconAlign(Style.IconAlign.RIGHT);

                    toolBar.add(removeButton);

                    slaPolicyFieldSet.add(toolBar);

                    if (currentIndex == slaPolicies.size() - 1) {
                    	slaPoliciesDone = true;
                        finalizeLayout();
                    }
                }
            });

        }
    }

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView#enableToProceed()
	 */
	@Override
	public void enableToProceed(boolean enabled) {
		this.nextButton.setEnabled(enabled);
		if (enabled){
			this.nextButton.setTitle("Proceed with deployment");
			this.nextButton.setToolTip("Proceed with deployment");
		}else{
			this.nextButton.setTitle("There are incomplete or not valid SLA policy fields");
			this.nextButton.setToolTip("There are incomplete or not valid SLA policy fields");
		}
	}
}
