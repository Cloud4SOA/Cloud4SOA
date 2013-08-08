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

package eu.cloud4soa.frontend.dashboard.client.views;

import com.extjs.gxt.ui.client.widget.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import eu.cloud4soa.frontend.commons.client.gxt.GxtValue;

/**
 * The header view implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SouthViewImpl extends Composite implements SouthView {

    @UiTemplate("SouthViewImpl.ui.xml")
    interface Binder extends UiBinder<Widget, SouthViewImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    private Presenter presenter;

    @UiField
    Label version;


    public SouthViewImpl() {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setVersion(String version) {
        this.version.setText(version);
    }

}
