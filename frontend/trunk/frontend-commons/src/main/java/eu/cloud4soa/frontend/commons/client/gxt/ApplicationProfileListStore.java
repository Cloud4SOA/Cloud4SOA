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

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;

/**
 * The GXT list store for the current user application profiles.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationProfileListStore extends ListStore<ApplicationModel> {


    /**
     * Retrieve applications with the given status. Null status means no deployment information.
     * Status == "all" means any application regardless of the status (the same results from the other constructor).
     *
     * The status code must be set in the sortField of the config (ok, that's ugly but there's no other way to pass
     * a parameter here).
     *
     */
    public ApplicationProfileListStore() {

        super(new BasePagingLoader<PagingLoadResult<ApplicationModel>>(new RpcProxy<PagingLoadResult<ApplicationModel>>() {
            private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

            @Override
            protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<ApplicationModel>> pagingLoadResultAsyncCallback) {
                final PagingLoadConfig config = (PagingLoadConfig) loadConfig;
                modelManagerService.retrieveCurrentUserApplications(config, pagingLoadResultAsyncCallback);
            }
        }));
    }

}
