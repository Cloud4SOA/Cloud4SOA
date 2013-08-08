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

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.widget.*;
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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

import java.util.List;

/**
 * GXT implementation of the offer editor.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferEditorViewGxtImpl extends Composite implements OfferEditorView {

    interface Binder extends UiBinder<Component, OfferEditorViewGxtImpl> {
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
    Button saveButton;

    @UiField
    Button closeButton;

    @UiField
    FieldSet offerDetailsFieldSet;

    @UiField
    VerticalPanel mainPanel;

    @UiField
    Button addComponentButton;

    @UiField
    ContentPanel editorPanel;


    private boolean offerDetailsDone;
    //    private boolean slaFieldsDone;
    private boolean softwareComponentsDone;
    private boolean hardwareComponentsDone;


    public OfferEditorViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));

        FormLayout detailsFormLayout = new FormLayout();
        detailsFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
        detailsFormLayout.setLabelWidth(200);
        detailsFormLayout.setLabelPad(10);
        offerDetailsFieldSet.setLayout(detailsFormLayout);


        saveButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonCheck()));
        saveButton.setToolTip("Save the PaaS Offering");

        closeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRewind()));
        closeButton.setToolTip("Go back to the list of PaaS Offerings");


        addComponentButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonAdd()));
        addComponentButton.setToolTip("Add a new component to the PaaS Offering");

        addComponentButton.setMenu(new ComponentSelectorMenu(new ComponentSelectorMenu.ComponentSelectionListener() {

            @Override
            public void hardwareNetworkComponentSelected(MenuEvent ce) {
                presenter.addHardwareNetworkComponent();
            }

            @Override
            public void hardwareComputeComponentSelected(MenuEvent ce) {
                presenter.addHardwareComputeComponent();
            }

            @Override
            public void hardwareHttpRequestHandlerComponentSelected(MenuEvent ce) {
                presenter.addHardwareHttpRequestHandlerComponent();
            }

            @Override
            public void hardwareStorageComponentSelected(MenuEvent ce) {
                presenter.addHardwareStorageComponent();
            }

            @Override
            public void softwareGenericComponentSelected(MenuEvent ce) {
                presenter.addSoftwareGenericComponent();
            }

            @Override
            public void softwareSqlDatabaseComponentSelected(MenuEvent ce) {
                presenter.addSoftwareSqlDatabaseComponent();
            }

            @Override
            public void softwareNoSqlDatabaseComponentSelected(MenuEvent ce) {
                presenter.addNoSqlDatabaseComponent();
            }
        }));

    }

    private void finalizeLayout() {
        if (offerDetailsDone && /*slaFieldsDone && */softwareComponentsDone && hardwareComponentsDone) {
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


    @GxtUiHandler(uiField = "saveButton", eventType = GxtEvent.Select)
    public void handleSaveButtonClick(ButtonEvent buttonEvent) {
        presenter.onSaveButtonClick();
    }

    @GxtUiHandler(uiField = "closeButton", eventType = GxtEvent.Select)
    public void handleCloseButtonClick(ButtonEvent buttonEvent) {
        presenter.onCloseButtonClick();
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindPaaSOffering(final PaaSOfferingModel paaSOfferingModel) {

        mainPanel.setVisible(false);
        if (paaSOfferingModel != null) {

            offerDetailsDone = false;
            offerDetailsFieldSet.removeAll();

            // build the application details form
            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_OFFER_EDITOR, paaSOfferingModel, offerDetailsFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                }

                @Override
                public void onSuccess(Void result) {

                    FormBinding formBinding = new FormBinding(offerDetailsForm, true);
                    formBinding.bind(paaSOfferingModel);
                    formBinding.setUpdateOriginalValue(true);

                    offerDetailsDone = true;
                    finalizeLayout();
                }
            });

            bindSoftwareComponents(paaSOfferingModel.getSoftwareComponents());

            bindHardwareComponents(paaSOfferingModel.getHardwareComponents());

        }
    }


    private void bindHardwareComponents(final List<HardwareComponentModel> hardwareComponents) {
        hardwareComponentsPanel.removeAll();
        hardwareComponentsDone = hardwareComponents.isEmpty();

        if (hardwareComponentsDone)
            finalizeLayout();

        for (int i = 0; i < hardwareComponents.size(); i++) {

            final HardwareComponentModel hardwareComponentModel = hardwareComponents.get(i);

            final FormPanel hardwareComponentFormPanel = new FormPanel();
            hardwareComponentFormPanel.setHeaderVisible(false);
            hardwareComponentFormPanel.setLayout(new FlowLayout());

            hardwareComponentsPanel.add(hardwareComponentFormPanel);

            final FieldSet hardwareComponentFieldSet = new FieldSet();
            hardwareComponentFieldSet.setCollapsible(false);
            hardwareComponentFieldSet.setExpanded(true);

            hardwareComponentFieldSet.setHeading(hardwareComponentModel.getFormTitle());

            FormLayout hardwareComponentFormLayout = new FormLayout();
            hardwareComponentFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
            hardwareComponentFormLayout.setLabelWidth(200);
            hardwareComponentFormLayout.setLabelPad(10);

            hardwareComponentFieldSet.setLayout(hardwareComponentFormLayout);

            hardwareComponentFormPanel.add(hardwareComponentFieldSet);

            if (Boolean.TRUE.equals(hardwareComponentModel.get(Strings.NEW_COMPONENT))) {
                hardwareComponentModel.set(Strings.NEW_COMPONENT, false);
                scrollHere = hardwareComponentFieldSet;
            }

            final int currentIndex = i;

            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_OFFER_EDITOR, hardwareComponentModel, hardwareComponentFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                    hardwareComponentsDone = true;
                    finalizeLayout();
                }

                @Override
                public void onSuccess(Void result) {
                    FormBinding formBinding = new FormBinding(hardwareComponentFormPanel, true);
                    formBinding.bind(hardwareComponentModel);
                    formBinding.setUpdateOriginalValue(true);

                    ToolBar toolBar = new ToolBar();
                    toolBar.addStyleName("c4s-remove-border");
                    toolBar.addStyleName("c4s-white-bg");
                    toolBar.setAlignment(Style.HorizontalAlignment.RIGHT);

                    Button removeButton = new Button("Remove", new SelectionListener<ButtonEvent>() {
                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            presenter.onHardwareComponentDeleteButtonClick(hardwareComponentModel);
                        }
                    });
                    removeButton.setToolTip("Remove the offered hardware feature from the PaaS Offering.");

                    removeButton.setScale(Style.ButtonScale.LARGE);
                    removeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
                    removeButton.setIconAlign(Style.IconAlign.BOTTOM);


                    toolBar.add(removeButton);

                    hardwareComponentFieldSet.add(toolBar);

                    if (currentIndex == hardwareComponents.size() - 1) {
                        hardwareComponentsDone = true;
                        finalizeLayout();
                    }
                }
            });

        }
    }

    private void bindSoftwareComponents(final List<SoftwareComponentModel> softwareComponents) {
        softwareComponentsPanel.removeAll();
        softwareComponentsDone = softwareComponents.isEmpty();

        if (softwareComponentsDone)
            finalizeLayout();

        for (int i = 0; i < softwareComponents.size(); i++) {

            final SoftwareComponentModel softwareComponentModel = softwareComponents.get(i);

            final FormPanel softwareComponentFormPanel = new FormPanel();
            softwareComponentFormPanel.setHeaderVisible(false);
            softwareComponentFormPanel.setLayout(new FlowLayout());

            softwareComponentsPanel.add(softwareComponentFormPanel);

            final FieldSet softwareComponentFieldSet = new FieldSet();
            softwareComponentFieldSet.setCollapsible(false);
            softwareComponentFieldSet.setExpanded(true);

            softwareComponentFieldSet.setHeading(softwareComponentModel.getFormTitle());

            FormLayout softwareComponentFormLayout = new FormLayout();
            softwareComponentFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
            softwareComponentFormLayout.setLabelWidth(200);
            softwareComponentFormLayout.setLabelPad(10);

            softwareComponentFieldSet.setLayout(softwareComponentFormLayout);

            softwareComponentFormPanel.add(softwareComponentFieldSet);

            if (Boolean.TRUE.equals(softwareComponentModel.get(Strings.NEW_COMPONENT))) {
                softwareComponentModel.set(Strings.NEW_COMPONENT, false);
                scrollHere = softwareComponentFieldSet;
            }

            final int currentIndex = i;

            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_OFFER_EDITOR, softwareComponentModel, softwareComponentFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                    softwareComponentsDone = true;
                    finalizeLayout();
                }

                @Override
                public void onSuccess(Void result) {
                    FormBinding formBinding = new FormBinding(softwareComponentFormPanel, true);
                    formBinding.bind(softwareComponentModel);
                    formBinding.setUpdateOriginalValue(true);

                    ToolBar toolBar = new ToolBar();
                    toolBar.addStyleName("c4s-remove-border");
                    toolBar.addStyleName("c4s-white-bg");
                    toolBar.setAlignment(Style.HorizontalAlignment.RIGHT);

                    Button removeButton = new Button("Remove", new SelectionListener<ButtonEvent>() {
                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            presenter.onSoftwareComponentDeleteButtonClick(softwareComponentModel);
                        }
                    });
                    removeButton.setToolTip("Remove the offered software feature from the PaaS Offering.");

                    removeButton.setScale(Style.ButtonScale.LARGE);
                    removeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
                    removeButton.setIconAlign(Style.IconAlign.BOTTOM);


                    toolBar.add(removeButton);

                    softwareComponentFieldSet.add(toolBar);

                    if (currentIndex == softwareComponents.size() - 1) {
                        softwareComponentsDone = true;
                        finalizeLayout();
                    }
                }
            });
        }
    }

}
