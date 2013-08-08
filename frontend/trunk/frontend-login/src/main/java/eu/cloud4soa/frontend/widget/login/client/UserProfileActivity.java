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
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwt.ss.client.loginable.LoginEvent;
import com.gwt.ss.client.loginable.LoginHandler;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.CurrentUserProfileUpdatedEvent;
import eu.cloud4soa.frontend.commons.client.events.UserLoggedOutEvent;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;

import java.util.Date;

/**
 * The user profile activity.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserProfileActivity extends Cloud4SoaActivity implements
        UserProfileView.Presenter {
    private UserProfileView view = GWT.create(UserProfileView.class);

    private UserManagementAndSecurityServiceAsync userService = GWT.create(UserManagementAndSecurityService.class);

    private UserModel userModel;

    public UserProfileActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        loadCurrentUserProfile();
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
        registerViewDetacher(view);
    }

    private void loadCurrentUserProfile() {

        userService.getCurrentUser(new ActivityCallback<UserModel>() {

            @Override
            public void onSuccess(UserModel user) {
                userModel = user;
                view.getUsername().setValue(userModel.<String>get(UserModel.USER_ACCOUNTNAME));
                view.getName().setValue(userModel.<String>get(UserModel.USER_FIRSTNAME));
                view.getSurname().setValue(userModel.<String>get(UserModel.USER_SURNAME));
                view.getEmail().setValue(userModel.<String>get(UserModel.USER_EMAIL));
                view.getGeekcode().setValue(userModel.<String>get(UserModel.USER_GEEKCODE));
                view.getBirthDate().setValue(userModel.<Date>get(UserModel.USER_BIRTHDAY));

            }
        });
    }

    @Override
    public void onSaveButtonClick() {

        if (userModel != null) {

            userModel.set(UserModel.USER_ACCOUNTNAME, view.getUsername().getValue());
            userModel.set(UserModel.USER_FIRSTNAME, view.getName().getValue());
            userModel.set(UserModel.USER_SURNAME, view.getSurname().getValue());
            userModel.set(UserModel.USER_BIRTHDAY, view.getBirthDate().getValue());
            userModel.set(UserModel.USER_FAMILYNAME, view.getSurname().getValue());
            userModel.set(UserModel.USER_GEEKCODE, view.getGeekcode().getValue());
            userModel.set(UserModel.USER_EMAIL, view.getEmail().getValue());

            userService.updateUserInstance(userModel, new ActivityCallback<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Info.display("Saved", "The user profile was saved successfully.");
                    clientFactory.setCurrentUser(userModel);
                    clientFactory.getEventBus().fireEvent(new CurrentUserProfileUpdatedEvent());
                }
            });
        }
    }

}
