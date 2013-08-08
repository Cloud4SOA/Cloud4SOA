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

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

/**
 * The GXT implementation for the Register view.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 14/02/12 23.50
 */
public class RegisterViewGxtImpl extends Composite implements RegisterView {

    @UiTemplate("RegisterViewGxtImpl.ui.xml")
    interface Binder extends UiBinder<Component, RegisterViewGxtImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    private Presenter presenter;

    @Override
    public HasValue<String> getPassword() {
        return null;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public HasValue<String> getUsername() {
        return null;
    }

    public RegisterViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));
    }
}