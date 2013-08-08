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
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

import java.util.List;

/**
 * GXT implementation of the application editor.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorViewGxtImpl extends Composite implements ApplicationEditorView {

    interface Binder extends UiBinder<Component, ApplicationEditorViewGxtImpl> {
    }

    private Presenter presenter;

    private static Binder binder = GWT.create(Binder.class);

    @UiField
    FieldSet applicationDetailsFieldSet;

    @UiField
    FieldSet slaFieldSet;

    @UiField
    FormPanel applicationDetailsForm;

    @UiField
    FormPanel slaForm;

    @UiField
    VerticalPanel mainPanel;

    @UiField
    Button saveButton;

    @UiField
    Button closeButton;

    @UiField
    ContentPanel softwareComponentsPanel;

    @UiField
    ContentPanel hardwareComponentsPanel;

    @UiField
    Button addComponentButton;

    @UiField
    ContentPanel editorPanel;

    @UiField
    Button searchButton;

    @UiField
    Button deleteButton;


    public ApplicationEditorViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));

        FormLayout detailsFormLayout = new FormLayout();
        detailsFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
        detailsFormLayout.setLabelWidth(200);
        detailsFormLayout.setLabelPad(10);
        applicationDetailsFieldSet.setLayout(detailsFormLayout);

        FormLayout slaFormLayout = new FormLayout();
        slaFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
        slaFormLayout.setLabelWidth(200);
        slaFormLayout.setLabelPad(10);
        slaFieldSet.setLayout(slaFormLayout);

        saveButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonCheck()));
        saveButton.setToolTip("Save the PaaS Offering");

        closeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRewind()));
        closeButton.setToolTip("Go back to the list of PaaS Offerings");

        deleteButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
        deleteButton.setToolTip("Remove this application profile");

        searchButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonSearch()));
        searchButton.setToolTip("Search PaaS offering that matches this application profile");

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
                presenter.addSoftwareNoSqlDatabaseComponent();
            }
        }));

    }

    @GxtUiHandler(uiField = "saveButton", eventType = GxtEvent.Select)
    public void handleSaveButtonClick(ButtonEvent buttonEvent) {
        presenter.onApplicationDetailsSaveButtonClick();
    }


    @GxtUiHandler(uiField = "closeButton", eventType = GxtEvent.Select)
    public void handleCloseButtonClick(ButtonEvent buttonEvent) {
        presenter.onApplicationDetailsCloseButtonClick();
    }


    @GxtUiHandler(uiField = "searchButton", eventType = GxtEvent.Select)
    public void handleSearchButtonClick(ButtonEvent buttonEvent) {
        presenter.onApplicationDetailsSearchButtonClick();
    }

    @GxtUiHandler(uiField = "deleteButton", eventType = GxtEvent.Select)
    public void handleDeleteButtonClick(ButtonEvent buttonEvent) {
        presenter.onApplicationDetailsDeleteButtonClick();
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private boolean applicationDetailsDone;
    private boolean slaFieldsDone;
    private boolean softwareComponentsDone;
    private boolean hardwareComponentsDone;

    private void finalizeLayout() {
        if (applicationDetailsDone && slaFieldsDone && softwareComponentsDone && hardwareComponentsDone) {
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
    public void bindInstance() {

        scrollHere = null;
        mainPanel.setVisible(false);

        if (presenter.getInstance() != null) {
            mainPanel.setVisible(false);

            applicationDetailsFieldSet.removeAll();

            applicationDetailsDone = false;

            // build the application details form
            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_APPLICATION_EDITOR, presenter.getInstance(), applicationDetailsFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                    applicationDetailsDone = true;
                    finalizeLayout();
                }

                @Override
                public void onSuccess(Void result) {

                    FormBinding formBinding = new FormBinding(applicationDetailsForm, true);
                    formBinding.bind(presenter.getInstance());
                    formBinding.setUpdateOriginalValue(true);

                    applicationDetailsDone = true;
//                    mainPanel.layout();
                    finalizeLayout();
                }
            });

            bindSoftwareComponents(presenter.getInstance().getSoftwareComponents());

            bindHardwareComponents(presenter.getInstance().getHardwareComponents());

            slaFieldSet.removeAll();

            slaFieldsDone = false;
            // build the application sla form
            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_APPLICATION_EDITOR_SLA, presenter.getInstance(), slaFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                    slaFieldsDone = true;
                    finalizeLayout();
                }

                @Override
                public void onSuccess(Void result) {

                    FormBinding formBinding = new FormBinding(slaForm, true);
                    formBinding.bind(presenter.getInstance());
                    formBinding.setUpdateOriginalValue(true);

//                    slaForm.layout();
                    slaFieldsDone = true;
                    finalizeLayout();
                }
            });
        }
    }


    private void bindHardwareComponents(final List<HardwareComponentModel> hardwareComponents) {
        hardwareComponentsDone = hardwareComponents.isEmpty();
        hardwareComponentsPanel.removeAll();

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

            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_APPLICATION_EDITOR, hardwareComponentModel, hardwareComponentFieldSet, new AsyncCallback<Void>() {
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
                    removeButton.setToolTip("Remove the requirement from the application profile.");

                    removeButton.setScale(Style.ButtonScale.LARGE);
                    removeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
                    removeButton.setIconAlign(Style.IconAlign.RIGHT);

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
        softwareComponentsDone = softwareComponents.isEmpty();
        softwareComponentsPanel.removeAll();

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

            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_APPLICATION_EDITOR, softwareComponentModel, softwareComponentFieldSet, new AsyncCallback<Void>() {
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

                    removeButton.setToolTip("Remove the requirement from the application profile.");

                    removeButton.setScale(Style.ButtonScale.LARGE);
                    removeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
                    removeButton.setIconAlign(Style.IconAlign.RIGHT);

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
