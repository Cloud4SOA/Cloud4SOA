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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.ss.client.exceptions.GwtSecurityException;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;

import java.util.List;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@RemoteServiceRelativePath("UserManagementAndSecurityService")
public interface UserManagementAndSecurityService extends RemoteService {
    void createNewAccount(UserModel userInstance, String username, String password);
    void updateUserInstance(UserModel userInstance);
    UserModel getUserInstance(String userInstanceUriId);

    UserModel getCurrentUser() throws GwtSecurityException;

    @Deprecated
    UserModel authenticateUser(String username, String password) throws GwtSecurityException;

    @Deprecated
    void logout();
    boolean isLoggedIn();
    boolean isUserInRole(String role);
	boolean isAccountNameInUse(String accountName);
	void removeUserCredentialsForPaaS(UserCredentialsModel credentials);
	void storeUserCredentialsForPaaS(UserCredentialsModel credentials);
	void updateUserCredentialsForPaaS(UserCredentialsModel credentials);
	UserCredentialsModel readUserCredentialsForPaaS(String paaSInstanceUriId);
	List<UserCredentialsModel> readAllUserCredentialsForPaaS();
    String getC4sMode();
    UserModel currentUser() throws GwtSecurityException;

}
