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

package eu.cloud4soa.frontend.widget.usermanagement.client.views;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HasValue;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.gxt.GxtValue;

import java.util.List;

/**
 * GXT implementation of the Paas offer view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class PaaSOfferViewGxtImpl extends Composite implements PaaSOfferView {

    interface Binder extends UiBinder<Component, PaaSOfferViewGxtImpl> {
    }


    private static Binder binder = GWT.create(Binder.class);


    private Presenter presenter;

    @UiField
    TextField<String> offerName;

    @UiField
    TextField<String> provider;

    @UiField
    TextField<String> infrastructure;

    @UiField
    TextField<String> programmingLanguage;

    @UiField
    Button deployButton;

    public PaaSOfferViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));
    }

    @Override
    public HasValue<String> getOfferTitle() {
        return new GxtValue<String>(offerName);
    }

    @Override
    public HasValue<String> getProvider() {
        return new GxtValue<String>(provider);
    }

    @Override
    public HasValue<String> getInfrastructure() {
        return new GxtValue<String>(infrastructure);
    }

    @Override
    public HasValue<String> getProgrammingLanguage() {
        return new GxtValue<String>(programmingLanguage);
    }

    @Override
    public <E extends DisplayableKeyValue> void setPricingPolicyValues(List<E> pricingPolicyValues) {
        // todo remove
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setDeployButtonEnabled(boolean enabled) {
        if (enabled)
            deployButton.enable();
        else
            deployButton.disable();
    }

    @GxtUiHandler(uiField = "deployButton", eventType = GxtEvent.Select)
    public void handleDeployButtonClick(ButtonEvent event) {
        presenter.onDeployClick();
    }

}
