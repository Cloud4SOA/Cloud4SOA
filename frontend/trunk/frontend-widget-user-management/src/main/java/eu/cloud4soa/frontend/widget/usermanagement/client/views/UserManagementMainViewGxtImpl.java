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

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.widget.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.gxt.WidgetWrapper;

import java.util.List;

/**
 * GXT Implementation of the ummv.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class UserManagementMainViewGxtImpl extends Composite implements UserManagementMainView {


    interface Binder extends UiBinder<Component, UserManagementMainViewGxtImpl> {
    }

    private static final Binder binder = GWT.create(Binder.class);

    private Presenter presenter;

    @UiField
    ContentPanel applicationProfileContainer;

    @UiField
    ContentPanel paasOfferContainer;

    @UiField
    TabPanel tabPanel;

    @UiField
    TabItem applicationProfileTab;

    @UiField
    TabItem paasOfferTab;

    @UiField
    LayoutContainer tabContainer;

    private DelayedTask resizeTask;

    public UserManagementMainViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));

        resizeTask = new DelayedTask(new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                tabContainer.layout(true);
            }
        });

        HandlerRegistration resizeHandler = Window.addResizeHandler(new ResizeHandler() {
            @Override
            public void onResize(ResizeEvent event) {
                resizeTask.delay(100);
            }
        });
    }

    @Override
    public AcceptsOneWidget getApplicationProfilePanel() {
        return new WidgetWrapper(applicationProfileContainer);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <E extends DisplayableKeyValue> void setInteractionStyleValues(List<E> interactionStyleValues) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AcceptsOneWidget getPaaSOfferPanel() {
        return new WidgetWrapper(paasOfferContainer);
    }

    @Override
    public void setSelectedInteractionStyle(String key) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void selectPaaSOfferPanel() {
        tabPanel.setSelection(paasOfferTab);
    }
}
