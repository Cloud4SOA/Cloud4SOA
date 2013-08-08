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

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gwt.ss.client.GwtLoginAsync;
import com.gwt.ss.client.loginable.LoginEvent;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.events.UserLogInCancelledEvent;
import eu.cloud4soa.frontend.commons.client.places.LoginPlace;
import eu.cloud4soa.frontend.commons.client.places.LostPasswordPlace;
import eu.cloud4soa.frontend.commons.client.places.RegisterPlace;

/**
 * Activity of the Login Widget.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class LoginActivity extends Cloud4SoaActivity implements
        LoginView.Presenter {

    private LoginView view;

    private GwtLoginAsync loginService = GwtLoginAsync.Util.getInstance();


    public LoginActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {

        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        view = GWT.create(LoginView.class);
        view.setPresenter(this);

        if (place instanceof LoginPlace)
            view.getUsername().setValue(((LoginPlace) place).getUsername());

        container.setWidget(view.asWidget());

        registerViewDetacher(view);

    }

    @Override
    public void onCancel() {
        clientFactory.getEventBus().fireEvent(new UserLogInCancelledEvent());
    }

    @Override
    public void onLogin() {
        view.setMessage(Strings.EMPTY);
        final MessageBox mb = MessageBox.wait("Logging in...", Strings.EMPTY,
                "Checking credentials...");

        loginService.j_gwt_security_check(
                view.getUsername().getValue(),
                view.getPassword().getValue(),
                view.getRememberMe().getValue(),
                new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        mb.close();
                        view.setMessage(caught.getMessage());
                        clientFactory.getEventBus().fireEvent(new LoginEvent(false));
                    }

                    @Override
                    public void onSuccess(Void result) {
                        mb.close();
                        clientFactory.getEventBus().fireEvent(new LoginEvent(true));
                    }
                }
        );
    }

    @Override
    public void onLostPassword() {
        goTo(new LostPasswordPlace(view.getUsername().getValue()));
    }

    @Override
    public void onRegisterNewUser() {
        goTo(new RegisterPlace(view.getUsername().getValue()));
    }
}
