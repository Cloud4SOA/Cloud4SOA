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

package eu.cloud4soa.frontend.commons.client.services.soa;

import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.ss.client.exceptions.GwtSecurityException;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
public interface ModelManagerServiceAsync {
    //ApplicationProfile methods
    void storeApplicationProfile(ApplicationModel applicationInstance, AsyncCallback<String> async);

    @Deprecated
    void updateApplicationProfile(ApplicationModel applicationInstance, AsyncCallback<Void> callback);

    void removeApplicationProfile(String applicationInstanceUriId, AsyncCallback<Void> callback);

    void retrieveCurrentUserApplicationProfiles(PagingLoadConfig config, AsyncCallback<PagingLoadResult<ApplicationModel>> async);
    
    void retrieveAllDeployedApplicationProfiles(ListLoadConfig config, AsyncCallback<ListLoadResult<ApplicationModel>> async);

    void retrieveDynamicEntityList(String type, AsyncCallback<ListLoadResult<DisplayableKeyValueModelData>> async);

    void retrieveProgrammingLanguages(AsyncCallback<ListLoadResult<ProgrammingLanguageModel>> async);

    void retrieveOneApplicationInstance(String uriId, AsyncCallback<ApplicationModel> async);

    void updateApplicationInstance(ApplicationModel applicationInstance, AsyncCallback<Void> async);

    void addApplicationSoftwareComponent(String applicationUriId, String componentType, AsyncCallback<Void> async);

    void removeApplicationHardwareComponent(String applicationUriId, HardwareComponentModel hardwareComponentModel, AsyncCallback<Void> async);

    void removeApplicationSoftwareComponent(String applicationUriId, SoftwareComponentModel softwareComponentModel, AsyncCallback<Void> async);




    void retrieveOneDynamicEntity(String type, String key, AsyncCallback<DisplayableKeyValueModelData> async);


    void retrieveEntityMetadata(String context, String entity, AsyncCallback<EntityMetadata> async);

    /*
    The following methods do nothing. For weird reason using EntityMetadata and FieldMetadata classes
    in a service methods signature is the only way to get them included in the serialization white list.
    Usually the GWT compiler put classes in the while list if one of these condition is meet:
     1) The class is part of a GWT-RPC method signature
     2) The class is reachable navigating the properties of a class from 1)
     3) The class has the IsSerializable interface

     Both EntityMetadata and FieldMetadata theoretically meet 2) and 3), however they are not picked up.
     The following useless method allow them to meet 1).
    */
    void whiteList2(AsyncCallback<FieldMetadata> async) throws GwtSecurityException;

    void whiteList3(AsyncCallback<EditType> async);

    void retrieveCommunicationCategories(AsyncCallback<ListLoadResult<HardwareCategoryModel>> async);

    void retrieveComputationCategories(AsyncCallback<ListLoadResult<HardwareCategoryModel>> async);

    void retrieveStorageCategories(AsyncCallback<ListLoadResult<HardwareCategoryModel>> async);

    void retrieveSoftwareCategories(AsyncCallback<ListLoadResult<SoftwareCategoryModel>> async);

    void retrieveDatabaseCategories(AsyncCallback<ListLoadResult<SoftwareCategoryModel>> async);

    void retrieveSqlDatabaseCategories(AsyncCallback<ListLoadResult<SoftwareCategoryModel>> async);

    void retrieveNoSqlDatabaseCategories(AsyncCallback<ListLoadResult<SoftwareCategoryModel>> async);

    void retrieveHardwareCategories(AsyncCallback<ListLoadResult<HardwareCategoryModel>> async);

    void retrieveCurrentUserPaaSOfferings(PagingLoadConfig config, AsyncCallback<PagingLoadResult<PaaSOfferingModel>> async);

    void retrieveOnePaaSOffering(String uriId, AsyncCallback<PaaSOfferingModel> async);

    void updatePaaSOffering(PaaSOfferingModel paaSOfferingModel, AsyncCallback<Void> async);

    void storePaaSOffering(PaaSOfferingModel paaSOfferingModel, AsyncCallback<String> async);

    void createHardwareComponent(String hardwareComponentType, AsyncCallback<HardwareComponentModel> async);

    void createSoftwareComponent(String softwareComponentType, AsyncCallback<SoftwareComponentModel> async);

    void removeOfferHardwareComponent(String applicationUriId, HardwareComponentModel hardwareComponentModel, AsyncCallback<Void> async);

    void removeOfferSoftwareComponent(String applicationUriId, SoftwareComponentModel softwareComponentModel, AsyncCallback<Void> async);

    void addApplicationHardwareComponent(String applicationUriId, String componentType, AsyncCallback<Void> async);

    void retrieveCurrentUserApplications(PagingLoadConfig config, AsyncCallback<PagingLoadResult<ApplicationModel>> async);

    void retrieveAllUsers(PagingLoadConfig config, AsyncCallback<PagingLoadResult<UserModel>> async);

    void retrieveOneUser(String uriId, AsyncCallback<UserModel> async);

    void removeUser(String uriId, AsyncCallback<Void> async);

    void createApplicationFromTemplate(String template, AsyncCallback<ApplicationModel> async);

    void whiteList4(AsyncCallback<MeasurementModel> async);
}
