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

import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.ModelKeyProvider;
import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import eu.cloud4soa.frontend.commons.client.gxt.ApplicationComponentsTreeStore;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueTreeModelData;
import eu.cloud4soa.frontend.widget.usermanagement.client.images.ComponentSelectorImages;

/**
 * GXT Implementation for the tools view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationToolsViewGxtImpl extends Composite implements ApplicationToolsView {

    private Presenter presenter;

    interface Binder extends UiBinder<Component, ApplicationToolsViewGxtImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);


//    @UiField
//    ContentPanel hardwareComponentsForm;

    @UiField
    ContentPanel applicationComponentsPanel;

    public ApplicationToolsViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));
        initializeComponentsTree();
//        initializeHardwareTree();
    }

    private void initializeComponentsTree() {
        ApplicationComponentsTreeStore applicationComponentsTreeStore = new ApplicationComponentsTreeStore();

        applicationComponentsTreeStore.setKeyProvider(new ModelKeyProvider<DisplayableKeyValueTreeModelData>() {
            @Override
            public String getKey(DisplayableKeyValueTreeModelData model) {
                return "node_" + model.getKey();
            }
        });

        final TreePanel<DisplayableKeyValueTreeModelData> applicationComponentsTree = new TreePanel<DisplayableKeyValueTreeModelData>(applicationComponentsTreeStore);

        applicationComponentsTree.setId("softwareComponentsTreeState");

        applicationComponentsTree.setIconProvider(new ModelIconProvider<DisplayableKeyValueTreeModelData>() {
            @Override
            public AbstractImagePrototype getIcon(DisplayableKeyValueTreeModelData model) {

                if (model.getKey().equals("hardware-requirements"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareComponent());
                else if (model.getKey().equals("software-requirements"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareComponent());
                else if (model.getKey().equals("communication-requirement"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareNetworkComponent());
                else if (model.getKey().equals("computation-requirement"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareComputeComponent());
                else if (model.getKey().equals("request-requirement"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareHttpRequestComponent());
                else if (model.getKey().equals("storage-requirement"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareStorageComponent());
                else if (model.getKey().equals("software-requirements-db"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareDatabaseComponent());
                else if (model.getKey().equals("software-requirements-db-sql"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareSqlDatabaseComponent());
                else if (model.getKey().equals("software-requirements-db-nosql"))
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareNoSqlDatabaseComponent());
                else
                    return AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.requirements());
            }
        });

        applicationComponentsTree.setStateful(true);
        applicationComponentsTree.setLabelProvider(new ModelStringProvider<DisplayableKeyValueTreeModelData>() {
            @Override
            public String getStringValue(DisplayableKeyValueTreeModelData model, String property) {
                return model.getDisplayName();
            }
        });

        Menu applicationComponentsContextMenu = new Menu();
        MenuItem addSoftwareComponentItem = new MenuItem();
        addSoftwareComponentItem.setText("Add component");

        applicationComponentsContextMenu.add(addSoftwareComponentItem);

        addSoftwareComponentItem.addSelectionListener(new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                DisplayableKeyValueTreeModelData selected = applicationComponentsTree.getSelectionModel().getSelectedItem();
                presenter.onApplicationComponentSelected(selected.getModelData());
            }
        });

        applicationComponentsTree.setContextMenu(applicationComponentsContextMenu);


        applicationComponentsPanel.setLayout(new FitLayout());
        applicationComponentsPanel.add(applicationComponentsTree);

    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
