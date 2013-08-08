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
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HasValue;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;
import eu.cloud4soa.frontend.commons.client.gxt.GxtValue;

import java.util.Date;

/**
 * GXT implementation of the user profile form.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserProfileViewGxtImpl extends Composite implements UserProfileView {

    interface UserProfileViewGxtImplUiBinder extends UiBinder<Component, UserProfileViewGxtImpl> {
    }

    private static UserProfileViewGxtImplUiBinder binder = GWT.create(UserProfileViewGxtImplUiBinder.class);

    private Presenter presenter;

    @UiField
    TextField<String> username;

    @UiField
    TextField<String> name;

    @UiField
    TextField<String> surname;
    
    @UiField
    TextField<String> geekcode;

    @UiField
    TextField<String> email;

    @UiField
    DateField birthday;

    @UiField
    Button saveButton;

    public UserProfileViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HasValue<String> getUsername() {
        return new GxtValue<String>(username);
    }

    @Override
    public HasValue<String> getName() {
        return new GxtValue<String>(name);
    }

    @Override
    public HasValue<String> getSurname() {
        return new GxtValue<String>(surname);
    }
    
    @Override
    public HasValue<String> getGeekcode() {
        return new GxtValue<String>(geekcode);
    }

    @Override
    public HasValue<String> getEmail() {
        return new GxtValue<String>(email);
    }

    @Override
    public HasValue<Date> getBirthDate() {
        return new GxtValue<Date>(birthday);
    }

    @GxtUiHandler(uiField = "saveButton", eventType = GxtEvent.Select)
    public void handleSaveButtonClick(ButtonEvent event) {
        presenter.onSaveButtonClick();
    }

}
