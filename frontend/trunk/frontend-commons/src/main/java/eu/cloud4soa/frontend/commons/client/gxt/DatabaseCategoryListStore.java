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

import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareCategoryModel;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;

/**
 * List store for database category
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DatabaseCategoryListStore extends ListStore<SoftwareCategoryModel> {
    public DatabaseCategoryListStore() {
        super(new BaseListLoader<ListLoadResult<SoftwareCategoryModel>>(new RpcProxy<ListLoadResult<SoftwareCategoryModel>>() {
            private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

            @Override
            protected void load(Object o, AsyncCallback<ListLoadResult<SoftwareCategoryModel>> callBack) {
                modelManagerService.retrieveDatabaseCategories(callBack);
            }
        }));
    }
}
