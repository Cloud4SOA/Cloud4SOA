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

package eu.cloud4soa.frontend.commons.client.gxt;

import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.services.ApplicationComponentsTreeService;
import eu.cloud4soa.frontend.commons.client.services.ApplicationComponentsTreeServiceAsync;

import java.util.List;

/**
 * The tree store for application components asynchronous loader machinery.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationComponentsTreeStore extends TreeStore<DisplayableKeyValueTreeModelData> {
    public ApplicationComponentsTreeStore() {
        super(new BaseTreeLoader<DisplayableKeyValueTreeModelData>(new RpcProxy<List<DisplayableKeyValueTreeModelData>>() {

            private ApplicationComponentsTreeServiceAsync softwareComponentsTreeService = GWT.create(ApplicationComponentsTreeService.class);

            // this overrides from RpcProxy
            @Override
            protected void load(Object loadConfig, AsyncCallback<List<DisplayableKeyValueTreeModelData>> callback) {

                softwareComponentsTreeService.getComponentChildren((DisplayableKeyValueTreeModelData) loadConfig, callback);

            }
        }) {

            // this overrides from BaseTreeLoader in order to inform the load about which elements has children.
            @Override
            public boolean hasChildren(DisplayableKeyValueTreeModelData parent) {

                return parent.hasChildren();
            }
        });
    }
}
