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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.gxt.PaaSOfferingListStore;

/**
 * GXT implementation for the PaaSOffering list view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class PaaSOfferingListViewGxtImpl extends Composite implements PaaSOfferingListView {

    interface Binder extends UiBinder<Component, PaaSOfferingListViewGxtImpl> {
    }

    interface ViewDataProvider {
        public ListStore<PaaSOfferingModel> instanceStore();

    }


    private ListStore<PaaSOfferingModel> instanceListStore = new PaaSOfferingListStore();

    private Presenter presenter;

    private static Binder binder = GWT.create(Binder.class);

    @UiField
    ContentPanel gridPanel;

    @UiField
    Grid instanceGrid;

    @UiField
    Button newButton;

    public PaaSOfferingListViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));

        final PagingToolBar pagingToolBar = new PagingToolBar(50);
        pagingToolBar.bind((PagingLoader) instanceListStore.getLoader());
        gridPanel.setBottomComponent(pagingToolBar);

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


    @UiFactory
    public ViewDataProvider viewDataProvider() {
        return new ViewDataProvider() {
            @Override
            public ListStore<PaaSOfferingModel> instanceStore() {
                return instanceListStore;
            }
        };
    }

    @GxtUiHandler(uiField = "instanceGrid", eventType = GxtEvent.RowClick)
    public void handleRowClick(GridEvent<PaaSOfferingModel> event) {
        if (event.getModel() != null) {
            presenter.onSelectedInstanceChange(event.getModel().getKey());
        }
    }

    @GxtUiHandler(uiField = "newButton", eventType = GxtEvent.Select)
    public void handleNewButtonClick(ButtonEvent event) {
        presenter.onNewButtonClick();
    }


}
