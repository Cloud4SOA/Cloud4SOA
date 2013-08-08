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
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.gxt.UserListStore;

import java.util.ArrayList;
import java.util.List;

/**
 * GXT implementation of the User List view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserListViewImpl extends LayoutContainer implements UserListView {

    private Presenter presenter;

    private ListStore<UserModel> userListStore;

    private PagingToolBar pagingToolBar;


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public UserListViewImpl() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new FitLayout());

        ContentPanel gridPanel = new ContentPanel();
        gridPanel.setBodyBorder(true);
        gridPanel.setHeading("Registered users");
        gridPanel.setHeaderVisible(true);
        gridPanel.setLayout(new FitLayout());
        gridPanel.setButtonAlign(Style.HorizontalAlignment.CENTER);
        gridPanel.setHeight(300);

        ToolBar top = new ToolBar();
//        Button newButton = new Button();
//        newButton.setEnabled(true);
//        newButton.setText("New");
//        top.add(newButton);
        top.add(new FillToolItem());
        gridPanel.setTopComponent(top);

        List<ColumnConfig> columnConfigs = new ArrayList<ColumnConfig>();

        ColumnConfig accountColumn = new ColumnConfig(UserModel.USER_ACCOUNTNAME, "Username", 100);
        accountColumn.setHeader("Username");
        columnConfigs.add(accountColumn);

        ColumnConfig firstNameColumn = new ColumnConfig(UserModel.USER_FIRSTNAME, "Name", 100);
        firstNameColumn.setHeader("Name");
        columnConfigs.add(firstNameColumn);

        ColumnConfig surnameColumn = new ColumnConfig(UserModel.USER_SURNAME, "Surname", 100);
        surnameColumn.setHeader("Surname");
        columnConfigs.add(surnameColumn);

        ColumnConfig emailColumn = new ColumnConfig(UserModel.USER_EMAIL, "Email", 100);
        emailColumn.setHeader("Email");
        columnConfigs.add(emailColumn);


        ColumnModel columnModel = new ColumnModel(columnConfigs);

        userListStore = new UserListStore();


        Grid instanceGrid = new Grid(userListStore, columnModel);
        instanceGrid.setAutoExpandColumn(UserModel.EMAIL);
        instanceGrid.setBorders(false);
        instanceGrid.setAutoWidth(true);
        instanceGrid.setStripeRows(true);
        instanceGrid.setColumnLines(true);
        instanceGrid.setColumnReordering(true);

        pagingToolBar = new PagingToolBar(50);
        pagingToolBar.bind((PagingLoader) userListStore.getLoader());
        gridPanel.setBottomComponent(pagingToolBar);

        gridPanel.add(instanceGrid);

        instanceGrid.addListener(Events.RowClick, new Listener<GridEvent<UserModel>>() {
            @Override
            public void handleEvent(GridEvent<UserModel> event) {
                if (event != null)
                    presenter.onSelectedRowChange(event.getModel().getKey());
            }
        });

        this.add(gridPanel);
    }

    @Override
    public void load() {

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
}
