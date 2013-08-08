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

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;

import java.util.HashMap;
import java.util.Map;

/**
 * Provide various utility methods to retrieve and work with entity metadata.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MetadataCache {

    private static MetadataCache instance;

    /**
     * Set this to true for debugging
     */
    private static boolean DO_NOT_CACHE = false;

    public static MetadataCache getInstance() {
        if (instance == null)
            instance = new MetadataCache();

        return instance;
    }

    private ModelManagerServiceAsync modelManager = GWT.create(ModelManagerService.class);

    private Map<String, EntityMetadata> cache = new HashMap<String, EntityMetadata>();


    /**
     * Build a dynamic form with metadata from the given entity in the specified container.
     *
     * @param modelData     The model of the form to be rendered
     * @param container     The container where the form should be built
     * @param asyncCallback Callback for actions to be done after building the form.
     */
    public void buildDynamicForm(final String context, final DynamicFormModel modelData, final LayoutContainer container, final AsyncCallback<Void> asyncCallback) {

        runWithMetadata(context, modelData.getFormType(), new AsyncCallback<EntityMetadata>() {
            @Override
            public void onFailure(Throwable caught) {
                asyncCallback.onFailure(caught);
            }

            @Override
            public void onSuccess(EntityMetadata entityMetadata) {
                for (FieldMetadata fieldMetadata : entityMetadata.getFieldsMetadata())
                    fieldMetadata.addField(container, modelData);

                asyncCallback.onSuccess(null);
            }
        });

    }

    /**
     * Execute a callback with the metadata resolve for the given entity. Execution could by sync or async
     * depending on the entity metadata is already retrieved, hence found in cache, or not.
     *
     * @param entity        The entity that identifies metadata
     * @param asyncCallback Callback for actions to be done with the metadata
     */
    public void runWithMetadata(final String context, final String entity, final AsyncCallback<EntityMetadata> asyncCallback) {

        EntityMetadata entityMetadata = cache.get(Strings.join(context, entity));
        if (entityMetadata == null || DO_NOT_CACHE)
            modelManager.retrieveEntityMetadata(context, entity, new AsyncCallback<EntityMetadata>() {
                @Override
                public void onFailure(Throwable caught) {
                    asyncCallback.onFailure(caught);
                }

                @Override
                public void onSuccess(EntityMetadata result) {
                    cache.put(Strings.join(context, entity), result);
                    asyncCallback.onSuccess(result);
                }
            });

        else
            asyncCallback.onSuccess(entityMetadata);

    }

}
