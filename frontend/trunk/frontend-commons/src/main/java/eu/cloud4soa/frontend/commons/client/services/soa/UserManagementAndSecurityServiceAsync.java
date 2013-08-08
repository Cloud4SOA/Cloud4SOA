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

import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;

import java.util.List;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
public interface UserManagementAndSecurityServiceAsync {
    void createNewAccount(UserModel userInstance, String username, String password, AsyncCallback<Void> callback);

    void getUserInstance(String userInstanceUriId, AsyncCallback<UserModel> callback);

    void authenticateUser(String username, String password, AsyncCallback<UserModel> callback);

    void updateUserInstance(UserModel userInstance, AsyncCallback<Void> async);

    void logout(AsyncCallback<Void> async);

    void currentUser(AsyncCallback<UserModel> async);

    void isLoggedIn(AsyncCallback<Boolean> async);

    void isUserInRole(String role, AsyncCallback<Boolean> async);

    void isAccountNameInUse(String accountName, AsyncCallback<Boolean> async);

    void removeUserCredentialsForPaaS(UserCredentialsModel credentials, AsyncCallback<Void> async);

    void storeUserCredentialsForPaaS(UserCredentialsModel credentials, AsyncCallback<Void> async);

    void updateUserCredentialsForPaaS(UserCredentialsModel credentials, AsyncCallback<Void> async);

    void readUserCredentialsForPaaS(String paaSInstanceUriId, AsyncCallback<UserCredentialsModel> async);

    void readAllUserCredentialsForPaaS(AsyncCallback<List<UserCredentialsModel>> async);

    void getCurrentUser(AsyncCallback<UserModel> async);

    void getC4sMode(AsyncCallback<String> async);
}
