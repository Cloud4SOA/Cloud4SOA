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

package eu.cloud4soa.frontend.widget.deployment.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * View providing instruction to migrate the application by mean of the Cloud4SOA Command Line Interface.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class CliMigrateView extends Composite {

    private static CliMigrateViewUiBinder binder = GWT.create(CliMigrateViewUiBinder.class);

    @UiField
        SpanElement c4s_address;

       @UiField
       SpanElement c4s_username;

       @UiField
       SpanElement c4s_gitproxy;

       @UiField
       SpanElement c4s_appUriId;

       @UiField
       SpanElement c4s_paasUriId;



    public CliMigrateView() {
        initWidget(binder.createAndBindUi(this));
    }

    interface CliMigrateViewUiBinder extends UiBinder<HTMLPanel, CliMigrateView> {
    }

    public void populateInfo(String c4sHost, String c4sBaseUrl, String username, String appUriId, String paasUriId) {
        c4s_address.setInnerText(c4sBaseUrl);
        c4s_username.setInnerText(username);
        c4s_gitproxy.setInnerText(c4sHost);
        c4s_appUriId.setInnerText(appUriId);
        c4s_paasUriId.setInnerText(paasUriId);

    }

}