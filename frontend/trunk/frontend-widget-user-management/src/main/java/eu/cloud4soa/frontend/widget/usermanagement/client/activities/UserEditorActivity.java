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

package eu.cloud4soa.frontend.widget.usermanagement.client.activities;

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.places.AdminPlace;
import eu.cloud4soa.frontend.commons.client.places.UserAware;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.UserEditorView;

/**
 * User editor presenter.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserEditorActivity extends Cloud4SoaActivity implements UserEditorView.Presenter {

    private UserEditorView view = GWT.create(UserEditorView.class);

    private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

    private UserManagementAndSecurityServiceAsync userManagement = GWT.create(UserManagementAndSecurityService.class);

    private UserModel instance;

    public UserEditorActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
        loadData();
        registerViewDetacher(view);

    }

    @Override
    public UserModel getInstance() {
        return instance;
    }

    @Override
    public void onCloseButtonClick() {
        goTo(new AdminPlace());
    }

    @Override
    public void onSaveButtonClick() {
        if (instance.getKey() != null)

            userManagement.updateUserInstance(instance, new ActivityCallback<Void>() {

                @Override
                public void onSuccess(Void result) {
                    Info.display("debug", "Successful updated");
                    loadData();
                }
            });
        else
            userManagement.createNewAccount(instance, instance.<String>get(UserModel.USER_ACCOUNTNAME), instance.<String>get(UserModel.USER_PASSWORD), new ActivityCallback<Void>() {
                @Override
                public void onSuccess(Void result) {
                    goTo(new AdminPlace());
                }
            });
    }

    @Override
    public void onDeleteButtonClick() {
        modelManagerService.removeUser(getInstanceUriId(), new ActivityCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                Info.display("User", "User was deleted.");
                goTo(new AdminPlace());
            }
        });
    }

    private void loadData() {
        modelManagerService.retrieveOneUser(getInstanceUriId(), new ActivityCallback<UserModel>() {
            @Override
            public void onSuccess(UserModel result) {
                instance = result;
                view.bindInstance();
            }
        });
    }

    private String getInstanceUriId() {
        if (place instanceof UserAware)
            return ((UserAware) place).getUserUriId();

        return null;
    }
}
