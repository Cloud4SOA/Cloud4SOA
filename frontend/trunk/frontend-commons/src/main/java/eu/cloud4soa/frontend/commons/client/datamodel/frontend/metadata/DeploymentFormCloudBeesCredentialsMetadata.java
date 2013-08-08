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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.metadata;

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

/**
 * Credentials for CloudBees
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DeploymentFormCloudBeesCredentialsMetadata extends EntityMetadata implements IsSerializable {
    public DeploymentFormCloudBeesCredentialsMetadata() {

        field(FieldMetadata.create(UserCredentialsModel.PUBLIC_KEY)
                .label("API key").editType(TEXT)
                .tooltip("The CloudBees API Key")
                .allowBlank(false));
        field(FieldMetadata.create(UserCredentialsModel.PRIVATE_KEY)
                .label("Secret Key").editType(TEXT)
                .tooltip("The CloudBees Secret Key")
                .allowBlank(false).password(true));
        field(FieldMetadata.create(UserCredentialsModel.ACCOUNT_NAME)
                .label("Account").editType(TEXT)
                .tooltip("The CloudBees account")
                .allowBlank(true));
    }
}
