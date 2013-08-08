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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.cloud4soa.frontend.commons.client.services.soa;

import java.util.List;

import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.ss.client.exceptions.GwtSecurityException;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */

public interface ApplicationDeploymentServiceAsync {
	void startApplication(String applicationInstanceUriId, String publicKey,
			String secretKey, AsyncCallback<Void> callback);

	void stopApplication(String applicationInstanceUriId, String publicKey,
			String secretKey, AsyncCallback<Void> callback);

	void removeApplication(String applicationInstanceUriId, String publicKey,
			String secretKey, AsyncCallback<Void> callback);

	void retrieveAllDeployedApplicationProfiles(ListLoadConfig config,
			AsyncCallback<ListLoadResult<ApplicationModel>> callback)
            throws GwtSecurityException;

    void clearFiles(AsyncCallback<Void> async);

	void deployApplication(String applicationUriId, String paaSInstanceUri, 
			String archiveName, String slaTemplateId, List<SLAPolicyModel> slaPolicies, AsyncCallback<String> async);

	void undeployApplication(String applicationInstanceUriId, String publicKey,
			String secretKey, AsyncCallback<Void> callback);

	void createDatabase(String applicationInstanceUriId,
			String paaSInstanceUriId, String dbStorageComponentUriId,
			AsyncCallback<Void> callback);

	void initializeDatabase(String applicationInstanceUriId,
			String paaSInstanceUriId, String dbStorageComponentUriId,
			AsyncCallback<Void> callback);

	void dumpDatabase(String applicationInstanceUriId,
			String paaSInstanceUriId, String dbStorageComponentUriId,
			AsyncCallback<Void> callback);

    void migrateDatabase(String applicationUriId, String paaSOfferingUriId, AsyncCallback<Void> async);

    void migrateApplication(String applicationUriId, String paaSOfferingUriId, AsyncCallback<Void> async);

    void commitMigration(String applicationUriId, AsyncCallback<Void> async);

    void rollbackMigration(String applicationUriId, AsyncCallback<Void> async);
    
    void storeUserExperienceRate(String appURI, int rating, AsyncCallback<Void> async);
}
