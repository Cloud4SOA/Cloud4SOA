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

package eu.cloud4soa.frontend.commons.server.services.soa;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.ss.client.exceptions.GwtSecurityException;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.soa.UserPaaSCredentials;
import eu.cloud4soa.api.soa.UserManagementAndSecurityModule;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.server.semanticdao.PaaSOfferingRepository;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.UserCredentialsMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@SuppressWarnings({"GwtServiceNotRegistered"})
@Secured("IS_AUTHENTICATED_REMEMBERED")
public class UserManagementAndSecurityServiceImpl extends RemoteServiceServlet implements UserManagementAndSecurityService {
    final Logger logger = LoggerFactory.getLogger(UserManagementAndSecurityServiceImpl.class);

    @Qualifier("userManagementAndSecurityModule")
    @Autowired
    UserManagementAndSecurityModule userManagementAndSecurityModuleSoaService;

    @Autowired
    PaaSOfferingRepository paaSOfferingRepository;

    @Autowired
    C4sSubject c4sSubject;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }


    @Value("#{systemProperties['c4s.mode']}")
    private String c4s_mode;


    @Override
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public void createNewAccount(UserModel userModel, String username, String password) {
        logger.debug("Invoking createNewAccount in SOA UserManagementAndSecurityModule with userInstance: " + userModel.<String>get(UserModel.USER_ACCOUNTNAME));

        // set roles for new user
        for (String role : isStandalone() ? UserModel.NEW_USER_STANDALONE_ROLES : UserModel.NEW_USER_FULL_ROLES)
            userModel.set(role, true);


        try {
            userManagementAndSecurityModuleSoaService.createNewAccount(new UserMapper().overWriteWith(userModel), username, password);
        } catch (SOAException e) {
            String msg = "An error occurred while creating the account for username: " + username;
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public UserModel getUserInstance(String userInstanceUriId) {
        UserInstance userInstance;
        try {
            userInstance = userManagementAndSecurityModuleSoaService.getUserInstance(userInstanceUriId);
        } catch (SOAException e) {
            String msg = "An error occurred while getting the user instance.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
        return new UserMapper().from(userInstance).toModel();
    }

    @Override
    public UserModel getCurrentUser() throws GwtSecurityException {
        return getUserInstance(c4sSubject.getCurrentUserUriId());
    }

    @Override
    @Deprecated
    public UserModel authenticateUser(String username, String password) throws GwtSecurityException {
        logger.debug("Invoking authenticateUser in SOA UserManagementAndSecurityModule with username: " + username);

//        if (c4sSubject.login(username, password))
//            return this.getUserInstance(c4sSubject.getCurrentUserUriId());

        return null;
    }

    @Override
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public UserModel currentUser() throws GwtSecurityException {
        String userUriId = c4sSubject.getCurrentUserUriId();
        return userUriId == null ? null : getUserInstance(userUriId);
    }

    @Override
    public void logout() {
//        c4sSubject.logout();
    }

    @Override
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public boolean isLoggedIn() {
        return c4sSubject.isLoggedIn();
    }

    @Override
    public boolean isUserInRole(String role) {
        return c4sSubject.hasRole(role);
    }

    @Override
    public void updateUserInstance(UserModel userModel) {

        logger.debug("Invoking updateUserInstance in SOA UserManagementAndSecurityModule with user: " + userModel.<String>get(UserModel.USER_ACCOUNTNAME));
        try {
            userManagementAndSecurityModuleSoaService.updateUserInstance(
                    new UserMapper()
                            .from(userManagementAndSecurityModuleSoaService.getUserInstance(userModel.getKey()))
                            .overWriteWith(userModel));
        } catch (Exception e) {
            String msg = "Error updating user instance " + userModel.<String>get(UserModel.USER_ACCOUNTNAME);
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

    }

    @Override
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public boolean isAccountNameInUse(String accountName) {
        logger.debug("Invoking isAccountNameInUse in SOA UserManagementAndSecurityModule with accountName: " + accountName);
        try {
            return userManagementAndSecurityModuleSoaService.isAccountNameInUse(accountName);
        } catch (Exception e) {
            String msg = "Error invoking isAccountNameInUse with accountName " + accountName;
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

    }

    //User credentials for PaaS Management methods
    @Override
    public void storeUserCredentialsForPaaS(UserCredentialsModel credentials) {
        logger.debug("Invoking storeUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                + " userInstanceUriId: " + credentials.get(UserCredentialsModel.USER_URIID)
                + ", paaSInstanceUriId: " + credentials.get(UserCredentialsModel.PAAS_URIID)
        );
        try {
            Response response = userManagementAndSecurityModuleSoaService.storeUserCredentialsForPaaS(
                    credentials.<String>get(UserCredentialsModel.USER_URIID),
                    credentials.<String>get(UserCredentialsModel.PAAS_URIID),
                    credentials.<String>get(UserCredentialsModel.PUBLIC_KEY),
                    credentials.<String>get(UserCredentialsModel.PRIVATE_KEY),
                    credentials.<String>get(UserCredentialsModel.ACCOUNT_NAME));
        } catch (Exception e) {
            String msg = "Error invoking storeUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                    + " userInstanceUriId: " + credentials.get(UserCredentialsModel.USER_URIID)
                    + ", paaSInstanceUriId: " + credentials.get(UserCredentialsModel.PAAS_URIID);
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void removeUserCredentialsForPaaS(UserCredentialsModel credentials) {
        logger.debug("Invoking removeUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                + " userInstanceUriId: " + credentials.get(UserCredentialsModel.USER_URIID)
                + ", paaSInstanceUriId: " + credentials.get(UserCredentialsModel.PAAS_URIID)
        );
        try {
            Response response = userManagementAndSecurityModuleSoaService.removeUserCredentialsForPaaS(
                    credentials.<String>get(UserCredentialsModel.USER_URIID),
                    credentials.<String>get(UserCredentialsModel.PAAS_URIID));
        } catch (Exception e) {
            String msg = "Error invoking removeUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                    + " userInstanceUriId: " + credentials.get(UserCredentialsModel.USER_URIID)
                    + ", paaSInstanceUriId: " + credentials.get(UserCredentialsModel.PAAS_URIID);
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void updateUserCredentialsForPaaS(UserCredentialsModel credentials) {
        logger.debug("Invoking updateUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                + " userInstanceUriId: " + credentials.get(UserCredentialsModel.USER_URIID)
                + ", paaSInstanceUriId: " + credentials.get(UserCredentialsModel.PAAS_URIID)
        );
        try {
            Response response = userManagementAndSecurityModuleSoaService.updateUserCredentialsForPaaS(
                    credentials.<String>get(UserCredentialsModel.USER_URIID),
                    credentials.<String>get(UserCredentialsModel.PAAS_URIID),
                    credentials.<String>get(UserCredentialsModel.PUBLIC_KEY),
                    credentials.<String>get(UserCredentialsModel.PRIVATE_KEY),
                    credentials.<String>get(UserCredentialsModel.ACCOUNT_NAME));
        } catch (Exception e) {
            String msg = "Error invoking updateUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                    + " userInstanceUriId: " + credentials.get(UserCredentialsModel.USER_URIID)
                    + ", paaSInstanceUriId: " + credentials.get(UserCredentialsModel.PAAS_URIID);
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public UserCredentialsModel readUserCredentialsForPaaS(String paaSInstanceUriId) {
        logger.debug("Invoking readUserCredentialsForPaaS in SOA UserManagementAndSecurityModule with"
                + " paaSInstanceUriId: " + paaSInstanceUriId
        );

        PaaSOfferingModel paaSOfferingModel = paaSOfferingRepository.findByUriId(paaSInstanceUriId);

        String provider = paaSOfferingModel != null ? paaSOfferingModel.getDisplayName() : Strings.EMPTY;

        if (c4sSubject.isLoggedIn()) {
            try {
                UserPaaSCredentials response = userManagementAndSecurityModuleSoaService
                        .readUserCredentialsForPaaS(c4sSubject.getCurrentUserUriId(), paaSInstanceUriId);
                return new UserCredentialsMapper(provider).from(response).toModel();

            } catch (Exception e) {

                return new UserCredentialsMapper(provider).from(new UserPaaSCredentials(
                        c4sSubject.getCurrentUserUriId(),
                        paaSInstanceUriId,
                        Strings.EMPTY,
                        Strings.EMPTY,
                        Strings.EMPTY
                )).toModel();
            }
        } else {
            logger.error("Cannot execute readUserCredentialsForPaaS(). The user is not logged in.");
            return null;
        }
    }

    @Override
    public List<UserCredentialsModel> readAllUserCredentialsForPaaS() {
        logger.debug("Invoking readAllUserCredentialsForPaaS in SOA UserManagementAndSecurityModule");

        if (c4sSubject.isLoggedIn()) {
            List<UserCredentialsModel> credentials = new ArrayList<UserCredentialsModel>();
            try {
                List<UserPaaSCredentials> response = userManagementAndSecurityModuleSoaService.readAllUserCredentialsForPaaS(c4sSubject.getCurrentUserUriId());
                for (UserPaaSCredentials credential : response)
                    credentials.add(
                            new UserCredentialsMapper(Strings.EMPTY)
                                    .from(credential)
                                    .toModel()
                    );

                return credentials;

            } catch (Exception e) {
                String msg = "Error invoking readAllUserCredentialsForPaaS in SOA UserManagementAndSecurityModule";
                logger.error(msg, e);
                throw new RuntimeException(msg, e);
            }
        } else {
            logger.error("Cannot execute readAllUserCredentialsForPaaS(). The user is not logged in.");
            return Collections.emptyList();
        }
    }

    private boolean isStandalone() {
        return "standalone".equals(c4s_mode);
    }

    @Override
    public String getC4sMode() {
        return c4s_mode;
    }
}
