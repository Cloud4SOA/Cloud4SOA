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

import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import eu.cloud4soa.frontend.widget.usermanagement.client.images.ComponentSelectorImages;

/**
 * Menu that offers the various components that can be added to a PaaS or Application profile.
 *
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ComponentSelectorMenu extends Menu {

    public interface ComponentSelectionListener {

        void hardwareNetworkComponentSelected(MenuEvent ce);

        void hardwareComputeComponentSelected(MenuEvent ce);

        void hardwareHttpRequestHandlerComponentSelected(MenuEvent ce);

        void hardwareStorageComponentSelected(MenuEvent ce);

        void softwareGenericComponentSelected(MenuEvent ce);

        void softwareSqlDatabaseComponentSelected(MenuEvent ce);

        void softwareNoSqlDatabaseComponentSelected(MenuEvent ce);

    }

    public ComponentSelectorMenu(final ComponentSelectionListener listener) {


        MenuItem hardwareComponentsItem = new MenuItem("Hardware components",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareComponent())
        );
        hardwareComponentsItem.setToolTip("Select an hardware component category in the submenu.");

        MenuItem hardwareNetworkComponentItem = new MenuItem("Network",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareNetworkComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.hardwareNetworkComponentSelected(ce);
                    }
                }
        );
        hardwareNetworkComponentItem.setToolTip("Add a Network component to your application profile.");

        MenuItem hardwareComputeComponentItem = new MenuItem("Compute",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareComputeComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.hardwareComputeComponentSelected(ce);
                    }
                }
        );
        hardwareComputeComponentItem.setToolTip("Add a Compute component to your application profile.");


        MenuItem hardwareHttpRequestHandlerComponentItem = new MenuItem("HTTP Request Handler",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareHttpRequestComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.hardwareHttpRequestHandlerComponentSelected(ce);
                    }
                }
        );
        hardwareHttpRequestHandlerComponentItem.setToolTip("Add a HTTP Request Handler component to your application profile.");

        MenuItem hardwareStorageComponentItem = new MenuItem("Storage",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.hardwareStorageComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.hardwareStorageComponentSelected(ce);
                    }
                }
        );
        hardwareStorageComponentItem.setToolTip("Add a Storage component to your application profile.");

        Menu hardwareComponentsMenu = new Menu();
        hardwareComponentsMenu.add(hardwareNetworkComponentItem);
        hardwareComponentsMenu.add(hardwareComputeComponentItem);
        hardwareComponentsMenu.add(hardwareHttpRequestHandlerComponentItem);
        hardwareComponentsMenu.add(hardwareStorageComponentItem);


        hardwareComponentsItem.setSubMenu(hardwareComponentsMenu);
        add(hardwareComponentsItem);


        MenuItem softwareComponentsItem = new MenuItem("Software components",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareComponent())
        );
        softwareComponentsItem.setToolTip("Select a software component category in the submenu");


        MenuItem softwareGenericComponentItem = new MenuItem("Generic software component",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareGenericComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.softwareGenericComponentSelected(ce);
                    }
                }
        );
        softwareGenericComponentItem.setToolTip("Add a Software component to your application profile.");

        MenuItem softwareSqlDatabaseComponentItem = new MenuItem("SQL Database",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareSqlDatabaseComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.softwareSqlDatabaseComponentSelected(ce);
                    }
                }
        );
        softwareSqlDatabaseComponentItem.setToolTip("Add a SQL Database component to your application profile.");

        MenuItem softwareNoSqlDatabaseComponentItem = new MenuItem("NoSQL Database",
                AbstractImagePrototype.create(ComponentSelectorImages.INSTANCE.softwareNoSqlDatabaseComponent()),
                new SelectionListener<MenuEvent>() {
                    @Override
                    public void componentSelected(MenuEvent ce) {
                        listener.softwareNoSqlDatabaseComponentSelected(ce);
                    }
                }
        );
        softwareNoSqlDatabaseComponentItem.setToolTip("Add a NoSQL Database component to your application profile.");

        Menu softwareComponentsMenu = new Menu();
        softwareComponentsMenu.add(softwareGenericComponentItem);
        softwareComponentsMenu.add(softwareSqlDatabaseComponentItem);
        softwareComponentsMenu.add(softwareNoSqlDatabaseComponentItem);

        softwareComponentsItem.setSubMenu(softwareComponentsMenu);

        add(softwareComponentsItem);

    }
}
