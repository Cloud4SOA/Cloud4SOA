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
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.PASSWORD;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

/**
 * Define the user editor form
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserEditorMetadata extends EntityMetadata implements IsSerializable {

    public UserEditorMetadata() {

        field(FieldMetadata.create(UserModel.USER_ACCOUNTNAME)
                .label("Account")
                .editType(TEXT)
                .regex("[\\w]*", "Please type a single word with only letters and digits with no spaces and punctuations.")
                .tooltip("The account name")
        );
        field(FieldMetadata.create(UserModel.EMAIL)
                .label("Email")
                .editType(TEXT)
                .tooltip("User email")
        );
        field(FieldMetadata.create(UserModel.USER_FIRSTNAME)
                .label("Name")
                .editType(TEXT)
                .tooltip("User first name")
        );
        field(FieldMetadata.create(UserModel.USER_SURNAME)
                .label("User surname")
                .editType(TEXT)
                .tooltip("User surname")
        );
        field(FieldMetadata.create(UserModel.USER_PASSWORD)
                .label("Password")
                .editType(PASSWORD)
                .tooltip("User password")
        );

        field(FieldMetadata.create(UserModel.USER_ROLE_ADMINISTRATOR)
                .label(Strings.EMPTY)
                .boxLabel("Administrator")
                .editType(EditType.CHECKBOX)
                .tooltip("Set the user as administrator")
        );

        field(FieldMetadata.create(UserModel.USER_ROLE_BROWSE)
                .label(Strings.EMPTY)
                .boxLabel("Allow faceted search")
                .editType(EditType.CHECKBOX)
                .tooltip("Allow the user to access the faceted search")
        );
        field(FieldMetadata.create(UserModel.USER_ROLE_MATCH)
                .label(Strings.EMPTY)
                .boxLabel("Allow matchmaking")
                .editType(EditType.CHECKBOX)
                .tooltip("Allow the user to access the matchmaking (and the application profile editor")
        );

        field(FieldMetadata.create(UserModel.USER_ROLE_DEPLOY)
                .label(Strings.EMPTY)
                .boxLabel("Allow deploy")
                .editType(EditType.CHECKBOX)
                .tooltip("Allow the user to deploy applications")
        );

        field(FieldMetadata.create(UserModel.USER_ROLE_MIGRATE)
                .label(Strings.EMPTY)
                .boxLabel("Allow migrate")
                .editType(EditType.CHECKBOX)
                .tooltip("Allow the user to migrate applications")
        );

        field(FieldMetadata.create(UserModel.USER_ROLE_MONITOR)
                .label(Strings.EMPTY)
                .boxLabel("Allow monitor")
                .editType(EditType.CHECKBOX)
                .tooltip("Allow the user to monitor applications")
        );

    }
}
