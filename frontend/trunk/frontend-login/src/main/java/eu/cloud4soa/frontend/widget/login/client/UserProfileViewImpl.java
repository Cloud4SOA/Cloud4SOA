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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

import java.util.Date;

/**
 * User profile view implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 03/10/11 17.09
 */
public class UserProfileViewImpl extends Composite implements UserProfileView {
    interface UserProfileViewImplUiBinder extends UiBinder<Widget, UserProfileViewImpl> {
    }

    private static UserProfileViewImplUiBinder binder = GWT.create(UserProfileViewImplUiBinder.class);

    private Presenter presenter;

    @UiField
    TextBox username;

    @UiField
    TextBox name;

    @UiField
    TextBox surname;

    @UiField
    TextBox email;

    @UiField
    DateBox birthDate;

    @UiField
    Button saveButton;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public UserProfileViewImpl() {
        initWidget(binder.createAndBindUi(this));
        birthDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd/MM/yyyy")));
    }

    @Override
    public HasValue<Date> getBirthDate() {
        return birthDate;
    }

    @Override
    public HasValue<String> getUsername() {
        return username;
    }

    @Override
    public HasValue<String> getName() {
        return name;
    }

    @Override
    public HasValue<String> getSurname() {
        return surname;
    }
    
    @Override
    public HasValue<String> getGeekcode() {
        return null; //Not implemented in this view
    }

    @Override
    public HasValue<String> getEmail() {
        return email;
    }


    @UiHandler("saveButton")
    public void handleSaveButtonClick(ClickEvent event) {
        if (presenter != null)
            presenter.onSaveButtonClick();
    }
}