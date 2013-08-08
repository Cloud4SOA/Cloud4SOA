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

import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreFilter;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.gxt.ApplicationProfileListStore;

/**
 * A GXT implementation of the application profile list.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationProfileListViewGxtImpl extends Composite implements ApplicationProfileListView {

    interface Binder extends UiBinder<Component, ApplicationProfileListViewGxtImpl> {
    }

    interface ViewDataProvider {
        public ListStore<ApplicationModel> instanceStore();

    }

    private ListStore<ApplicationModel> instanceListStore = new ApplicationProfileListStore();

    private Presenter presenter;

    private static Binder binder = GWT.create(Binder.class);

    private String applicationStatus = "all";

    @UiField
    ContentPanel gridPanel;

    private PagingToolBar pagingToolBar;

    @UiField
    Grid instanceGrid;

    @UiField
    Button newButton;

    public ApplicationProfileListViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));
        pagingToolBar = new PagingToolBar(50);
        pagingToolBar.bind((PagingLoader) instanceGrid.getStore().getLoader());
        gridPanel.setBottomComponent(pagingToolBar);

        Menu templateMenu = new Menu();

        templateMenu.add(new MenuItem("Empty profile", new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                presenter.onNewButtonClick("c4s-template-empty");
            }
        }));

        templateMenu.add(new MenuItem("Basic Java Application", new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                presenter.onNewButtonClick("c4s-template-basic-java");
            }
        }));

        templateMenu.add(new MenuItem("Basic Java Application with database", new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                presenter.onNewButtonClick("c4s-template-basic-java-db");
            }
        }));

        newButton.setMenu(templateMenu);
    }

    @Override
    public void load() {
        instanceListStore.getLoader().setSortField(applicationStatus);

        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                ;
            }

            @Override
            public void onSuccess() {
                pagingToolBar.refresh();
            }
        });

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
        if ("deployed".equals(applicationStatus))
            gridPanel.setHeading("Your deployed applications");
    }


    @UiFactory
    public ViewDataProvider viewDataProvider() {
        return new ViewDataProvider() {
            @Override
            public ListStore<ApplicationModel> instanceStore() {
                return instanceListStore;
            }
        };
    }

    @GxtUiHandler(uiField = "instanceGrid", eventType = GxtEvent.RowClick)
    public void handleRowClick(GridEvent<ApplicationModel> event) {
        if (event.getModel() != null) {
            presenter.onSelectedInstanceChange(event.getModel().getKey());
        }
    }

//    @GxtUiHandler(uiField = "newButton", eventType = GxtEvent.Select)
//    public void handleNewButtonClick(ButtonEvent event) {
//        presenter.onNewButtonClick("c4s-template-empty");
//    }
//

}
