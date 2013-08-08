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

import com.extjs.gxt.ui.client.data.*;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentService;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;

/**
 * The GXT list store for the current user's deployed application profiles.
 *
 * @author Stefano Travelli (Cyntelix)
 * @author Yosu Gorroñogoitia (Atos)
 */
public class DeployedApplicationListStore extends ListStore<ApplicationModel> {
    public DeployedApplicationListStore() {
        super(new BaseListLoader<ListLoadResult<ApplicationModel>>(new RpcProxy<ListLoadResult<ApplicationModel>>() {
            private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

            @Override
            protected void load(Object loadConfig, AsyncCallback<ListLoadResult<ApplicationModel>> listLoadResultAsyncCallback) {
                ListLoadConfig config = (ListLoadConfig) loadConfig;
                modelManagerService.retrieveAllDeployedApplicationProfiles(config, listLoadResultAsyncCallback);
            }
        }));
    }
}
