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

package eu.cloud4soa.frontend.widget.login.client;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gwt.ss.client.GwtLoginAsync;
import com.gwt.ss.client.loginable.LoginEvent;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.places.WelcomePlace;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;

/**
 * Register a new user.
 *
 * @author Stefano Travelli (Cyntelix)
 * @author Yosu Gorroñogoitia (Atos)
 * @since 14/02/12 19.52
 */
// public class RegisterActivity extends Cloud4SoaActivity implements
// RegisterView.Presenter {
public class RegisterActivity extends Cloud4SoaActivity implements
        RegistrationView.Presenter {

    private RegistrationView view;

    private GwtLoginAsync loginService = GwtLoginAsync.Util.getInstance();

    private UserManagementAndSecurityServiceAsync userService = GWT.create(UserManagementAndSecurityService.class);

    public RegisterActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        // view = GWT.create(RegisterView.class);
        view = GWT.create(RegistrationView.class);
        view.setPresenter(this);

        // if (place instanceof RegisterPlace)
        // view.getUsername().setValue(((RegisterPlace) place).getUsername());

        container.setWidget(view.asWidget());
        registerViewDetacher(view);
    }

    @Override
    public void onRegister() {

        final UserModel user = new UserModel();
        user.set(UserModel.USER_ACCOUNTNAME, view.getUserAccountProperty(RegistrationView.UserAccountProperty.USERNAME).getValue());
        user.set(UserModel.USER_FIRSTNAME, view.getUserAccountProperty(RegistrationView.UserAccountProperty.FIRSTNAME).getValue());
        user.set(UserModel.USER_FAMILYNAME, view.getUserAccountProperty(RegistrationView.UserAccountProperty.SURNAME).getValue());
        user.set(UserModel.USER_SURNAME, view.getUserAccountProperty(RegistrationView.UserAccountProperty.SURNAME).getValue());
        user.set(UserModel.USER_TYPE, view.getAccountType());

        // userInstance.setGeekcode(view.getUserAccountProperty(RegistrationView.UserAccountProperty.GEEKCODE).getValue());
        // userInstance.setBirthday(view.getUserAccountBirthday().getValue());
        user.set(UserModel.EMAIL, view.getUserAccountProperty(RegistrationView.UserAccountProperty.EMAIL).getValue());

        final String username = view.getUserAccountProperty(
                RegistrationView.UserAccountProperty.USERNAME).getValue();
        final String password = view.getUserAccountProperty(
                RegistrationView.UserAccountProperty.PASSWORD).getValue();

        // Check if username already exists
        userService.isAccountNameInUse(
                user.<String>get(UserModel.USER_ACCOUNTNAME),
                new AsyncCallback<Boolean>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        handleRPCFailure(caught);
                    }

                    @Override
                    public void onSuccess(Boolean inUse) {
                        if (!inUse) {
                            // Proceed with the registration
                            userService.createNewAccount(user, username,
                                    password, new AsyncCallback<Void>() {
                                @Override
                                public void onFailure(
                                        Throwable throwable) {
                                    // handleRPCFailure(throwable);
                                    DialogHelper
                                            .showDialog(
                                                    "Registration error",
                                                    "There was an error during the processing of your account registration. Please, contact this site administrator");
                                }

                                @Override
                                public void onSuccess(Void result) {
                                    Info.display("Welcome", "You are now registered to Cloud4SOA. You will be now redirected to the Cloud4SOA Dashboard....");

                                    loginService.j_gwt_security_check(username, password, true, new ActivityCallback<Void>() {
                                        @Override
                                        public void onSuccess(Void result) {
                                            clientFactory.getEventBus().fireEvent(new LoginEvent(true));
                                        }
                                    });
                                }
                            });
                        } else {
                            DialogHelper
                                    .showDialog("Registration",
                                            "Account name is in use, please, select another one");
                        }
                    }
                });
    }

    @Override
    public void onCancelRegisterNewUser() {
        goTo(new WelcomePlace());
    }

}
