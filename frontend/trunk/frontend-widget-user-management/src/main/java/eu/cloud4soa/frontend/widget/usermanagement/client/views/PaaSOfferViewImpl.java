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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;

import java.util.List;

/**
 * PaaS offer view implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 03/10/11 17.10
 */
public class PaaSOfferViewImpl extends Composite implements PaaSOfferView {
    interface PaaSOfferViewImplUiBinder extends UiBinder<Widget, PaaSOfferViewImpl> {
    }

    private static PaaSOfferViewImplUiBinder binder = GWT.create(PaaSOfferViewImplUiBinder.class);

    private Presenter presenter;

    @UiField
    TextBox title;

    @UiField
    TextBox paasProvider;

    @UiField
    TextBox userInfrastructure;

    @UiField
    TextBox programmingLanguage;

    @UiField
    ListBox pricingPolicyList;

    @UiField
    Button deploy;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public PaaSOfferViewImpl() {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public HasValue<String> getOfferTitle() {
        return title;
    }

    @Override
    public HasValue<String> getInfrastructure() {
        return userInfrastructure;
    }

    @Override
    public HasValue<String> getProvider() {
        return paasProvider;
    }

    @Override
    public HasValue<String> getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public <E extends DisplayableKeyValue> void setPricingPolicyValues(List<E> pricingPolicyValues) {
        pricingPolicyList.clear();
        for (DisplayableKeyValue v : pricingPolicyValues)
            pricingPolicyList.addItem(v.getDisplayName(), v.getKey());

    }

    @Override
    public void setDeployButtonEnabled(boolean enabled) {
        deploy.setEnabled(enabled);
    }

    @UiHandler("deploy")
    public void handleDeployClick(ClickEvent event) {
        presenter.onDeployClick();
    }
}