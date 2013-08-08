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
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
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
@SuppressWarnings("NonSerializableServiceParameters")
@RemoteServiceRelativePath("ModelManagerService")
public interface ModelManagerService extends RemoteService {
    //ApplicationProfile methods
    String storeApplicationProfile(ApplicationModel applicationInstance) throws GwtSecurityException;

    @Deprecated
    void updateApplicationProfile(ApplicationModel applicationInstance) throws GwtSecurityException;

    void removeApplicationProfile(String applicationInstanceUriId) throws GwtSecurityException;

    ListLoadResult<DisplayableKeyValueModelData> retrieveDynamicEntityList(String type) throws GwtSecurityException;

    DisplayableKeyValueModelData retrieveOneDynamicEntity(String type, String key) throws GwtSecurityException;

    ApplicationModel retrieveOneApplicationInstance(String uriId) throws GwtSecurityException;

    ApplicationModel createApplicationFromTemplate(String template) throws GwtSecurityException;

    void updateApplicationInstance(ApplicationModel applicationInstance) throws GwtSecurityException;

    PagingLoadResult<ApplicationModel> retrieveCurrentUserApplicationProfiles(PagingLoadConfig config) throws GwtSecurityException;

    PagingLoadResult<ApplicationModel> retrieveCurrentUserApplications(PagingLoadConfig config) throws GwtSecurityException;

    ListLoadResult<ApplicationModel> retrieveAllDeployedApplicationProfiles(ListLoadConfig config) throws GwtSecurityException;

    void addApplicationHardwareComponent(String applicationUriId, String componentType) throws GwtSecurityException;

    void addApplicationSoftwareComponent(String applicationUriId, String componentType) throws GwtSecurityException;

    void removeApplicationHardwareComponent(String applicationUriId, HardwareComponentModel hardwareComponentModel) throws GwtSecurityException;

    void removeApplicationSoftwareComponent(String applicationUriId, SoftwareComponentModel softwareComponentModel) throws GwtSecurityException;


    PagingLoadResult<PaaSOfferingModel> retrieveCurrentUserPaaSOfferings(PagingLoadConfig config) throws GwtSecurityException;

    PaaSOfferingModel retrieveOnePaaSOffering(String uriId) throws GwtSecurityException;

    void updatePaaSOffering(PaaSOfferingModel paaSOfferingModel) throws GwtSecurityException;

    String storePaaSOffering(PaaSOfferingModel paaSOfferingModel) throws GwtSecurityException;

    HardwareComponentModel createHardwareComponent(String hardwareComponentType) throws GwtSecurityException;

    SoftwareComponentModel createSoftwareComponent(String softwareComponentType) throws GwtSecurityException;

    void removeOfferHardwareComponent(String applicationUriId, HardwareComponentModel hardwareComponentModel) throws GwtSecurityException;

    void removeOfferSoftwareComponent(String applicationUriId, SoftwareComponentModel softwareComponentModel) throws GwtSecurityException;

    /**
     * Retrieve the entity metadata for building the form for the entity identified by the give parameter.
     * For some entities a context can differentiate the way a form is built.
     * <p/>
     * Browser side code may want to cache these results since they are not going to change during
     * the lifecycle of the application.
     *
     * @param entity  The entity to retrieve metadata for.
     * @param context The context where the entity is going to be represented
     * @return Metadata that describe the form for editing or viewing the given entity.
     */
    EntityMetadata retrieveEntityMetadata(String context, String entity) throws GwtSecurityException;


    /*
     The following two methods do nothing. For weird reason using EntityMetadata and FieldMetadata classes
     in a service methods signature is the only way to get them included in the serialization white list.
     Usually the GWT compiler put classes in the while list if one of these condition is meet:
      1) The class is part of a GWT-RPC method signature
      2) The class is reachable navigation the properties of a class from 1)
      3) The class has the IsSerializable interface

      Both EntityMetadata and FieldMetadata theoretically meet 2) and 3), however they are not picked up.
      The following useless method allow them to meet 1).
     */

    FieldMetadata whiteList2();

    EditType whiteList3();

    MeasurementModel whiteList4();


    ListLoadResult<ProgrammingLanguageModel> retrieveProgrammingLanguages() throws GwtSecurityException;

    ListLoadResult<HardwareCategoryModel> retrieveHardwareCategories() throws GwtSecurityException;

    ListLoadResult<HardwareCategoryModel> retrieveCommunicationCategories() throws GwtSecurityException;

    ListLoadResult<HardwareCategoryModel> retrieveComputationCategories() throws GwtSecurityException;

    ListLoadResult<HardwareCategoryModel> retrieveStorageCategories() throws GwtSecurityException;

    ListLoadResult<SoftwareCategoryModel> retrieveSoftwareCategories() throws GwtSecurityException;

    ListLoadResult<SoftwareCategoryModel> retrieveDatabaseCategories() throws GwtSecurityException;

    ListLoadResult<SoftwareCategoryModel> retrieveSqlDatabaseCategories() throws GwtSecurityException;

    ListLoadResult<SoftwareCategoryModel> retrieveNoSqlDatabaseCategories() throws GwtSecurityException;

    PagingLoadResult<UserModel> retrieveAllUsers(PagingLoadConfig config);

    UserModel retrieveOneUser(String uriId);

    void removeUser(String uriId);


}
