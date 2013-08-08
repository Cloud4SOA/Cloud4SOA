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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT implementation for the User Editor view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserEditorViewImpl extends LayoutContainer implements UserEditorView {

    private Presenter presenter;

    VerticalPanel mainPanel;
    FieldSet userFieldSet;
    FormPanel userForm;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public UserEditorViewImpl() {
        initialize();
    }

    private void initialize() {

        this.setLayout(new FitLayout());
        this.addStyleName("c4s-white-bg");

        ContentPanel editorPanel = new ContentPanel();
        editorPanel.setHeaderVisible(true);
        editorPanel.setBorders(true);
        editorPanel.setHeading("User");
        editorPanel.setScrollMode(Style.Scroll.AUTO);

        ToolBar toolBar = new ToolBar();
        toolBar.addStyleName("c4s-white-bg");

        Button closeButton = new Button("Back", new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent buttonEvent) {
                presenter.onCloseButtonClick();
            }
        });

        Button saveButton = new Button("Save", new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent buttonEvent) {
                presenter.onSaveButtonClick();
            }
        });

        Button deleteButton = new Button("Delete", new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent buttonEvent) {
                presenter.onDeleteButtonClick();
            }
        });

        closeButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRewind()));
        closeButton.setToolTip("Go back to the user list");
        closeButton.setScale(Style.ButtonScale.LARGE);
        closeButton.setIconAlign(Style.IconAlign.BOTTOM);

        saveButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonCheck()));
        saveButton.setToolTip("Save the user");
        saveButton.setScale(Style.ButtonScale.LARGE);
        saveButton.setIconAlign(Style.IconAlign.BOTTOM);

        deleteButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
        deleteButton.setToolTip("Remove the user");
        deleteButton.setScale(Style.ButtonScale.LARGE);
        deleteButton.setIconAlign(Style.IconAlign.BOTTOM);

        toolBar.add(closeButton);
        toolBar.add(saveButton);
        toolBar.add(new FillToolItem());
        toolBar.add(deleteButton);

        editorPanel.setTopComponent(toolBar);

        mainPanel = new VerticalPanel();
        mainPanel.setSpacing(2);
        mainPanel.setVisible(false);

        userForm = new FormPanel();
        userForm.setHeaderVisible(false);

        userFieldSet = new FieldSet();
        userFieldSet.setHeading("User details");

        FormLayout userFormLayout = new FormLayout();
        userFormLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
        userFormLayout.setLabelWidth(200);
        userFormLayout.setLabelPad(10);
        userFieldSet.setLayout(userFormLayout);

        userForm.add(userFieldSet);

        mainPanel.add(userForm);
        editorPanel.add(mainPanel);
        this.add(editorPanel);
    }

    @Override
    public void bindInstance() {
        if (presenter.getInstance() != null) {
            mainPanel.setVisible(false);
            userFieldSet.removeAll();

            MetadataCache.getInstance().buildDynamicForm(MetadataMapper.CONTEXT_USER_EDITOR, presenter.getInstance(), userFieldSet, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                    mainPanel.setVisible(true);
                }

                @Override
                public void onSuccess(Void result) {
                    FormBinding formBinding = new FormBinding(userForm, true);
                    formBinding.bind(presenter.getInstance());
                    mainPanel.layout();
                    mainPanel.setVisible(true);
                }
            });
        }
    }
}
