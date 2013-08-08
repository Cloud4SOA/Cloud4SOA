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

import java.util.List;

import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.ss.client.exceptions.GwtSecurityException;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@SuppressWarnings("NonSerializableServiceParameters")
@RemoteServiceRelativePath("ApplicationDeploymentService")
public interface ApplicationDeploymentService extends RemoteService {

    String deployApplication(String applicationUriId, String paaSInstanceUri, String archiveName, 
    		String slaTemplateId, List<SLAPolicyModel> slaPolicies) throws GwtSecurityException;

    void startApplication(String applicationInstanceUriId, String publicKey, String secretKey) throws GwtSecurityException;

    void stopApplication(String applicationInstanceUriId, String publicKey, String secretKey) throws GwtSecurityException;

    void removeApplication(String applicationInstanceUriId, String publicKey, String secretKey) throws GwtSecurityException;

    ListLoadResult<ApplicationModel> retrieveAllDeployedApplicationProfiles(ListLoadConfig config) throws GwtSecurityException;

    void clearFiles() throws GwtSecurityException;

    void undeployApplication(String applicationInstanceUriId, String publicKey, String secretKey) throws GwtSecurityException;

    void createDatabase(String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId) throws GwtSecurityException;

    void initializeDatabase(String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId) throws GwtSecurityException;

    void dumpDatabase(String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId) throws GwtSecurityException;

    void migrateDatabase(String applicationUriId, String paaSOfferingUriId) throws GwtSecurityException;

    void migrateApplication(String applicationUriId, String paaSOfferingUriId) throws GwtSecurityException;

    void commitMigration(String applicationUriId) throws GwtSecurityException;

    void rollbackMigration(String applicationUriId) throws GwtSecurityException;

    void storeUserExperienceRate(String appURI, int rating) throws GwtSecurityException;

}
