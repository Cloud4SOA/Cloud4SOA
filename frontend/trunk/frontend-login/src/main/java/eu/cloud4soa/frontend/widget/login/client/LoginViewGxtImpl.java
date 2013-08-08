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

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.HasValue;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.gxt.GxtUtils;
import eu.cloud4soa.frontend.commons.client.gxt.GxtValue;

/**
 * The GXT implementation of the Login dialog.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class LoginViewGxtImpl extends Composite implements LoginView {
    @UiTemplate("LoginViewGxtImpl.ui.xml")
    interface Binder extends UiBinder<Component, LoginViewGxtImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    public LoginViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));
    }

    private Presenter presenter;

    @UiField
    TextField<String> username;

    @UiField
    TextField<String> password;

    @UiField
    CheckBox rememberMe;

    @UiField
    Button cancelButton;

    @UiField
    Button loginButton;

    @UiField
    Button lostPasswordButton;

    @UiField
    Button registerButton;

    @UiField
    FormPanel loginForm;

    @UiField
    LabelField messageLabel;


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HasValue<String> getUsername() {
        return new GxtValue<String>(username);
    }

    public void setMessage(String message) {
        this.messageLabel.setText(message);
        this.messageLabel.setVisible(Strings.isNotEmpty(message));
    }

    @Override
    public HasValue<String> getPassword() {
        return new GxtValue<String>(password);
    }

    @Override
    public HasValue<Boolean> getRememberMe() {
        return new GxtValue<Boolean>(rememberMe);
    }

    @GxtUiHandler(uiField = "cancelButton", eventType = GxtEvent.Select)
    public void handleCancelButtonClick(ButtonEvent event) {
        presenter.onCancel();
    }

    @GxtUiHandler(uiField = "loginButton", eventType = GxtEvent.Select)
    public void handleLoginButtonClick(ButtonEvent event) {
        presenter.onLogin();
    }

    @GxtUiHandler(uiField = "lostPasswordButton", eventType = GxtEvent.Select)
    public void handleLostPasswordButtonClick(ButtonEvent event) {
        presenter.onLostPassword();
    }

    @GxtUiHandler(uiField = "registerButton", eventType = GxtEvent.Select)
    public void handleRegisterButtonClick(ButtonEvent event) {
        presenter.onRegisterNewUser();
    }

}
