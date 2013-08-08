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
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Application editor guide view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SearchGuideViewImpl extends Composite implements SearchGuideView {

    interface Binder extends UiBinder<Widget, SearchGuideViewImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    private Presenter presenter;

    @UiField
    AnchorElement browseLink;

    @UiField
    AnchorElement monitoringLink;


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public SearchGuideViewImpl() {
        initWidget(binder.createAndBindUi(this));
        addBrowseLinkClickListener(this, browseLink);
        addMonitoringLinkClickListener(this, monitoringLink);
    }

    void browseClickHandler() {
        presenter.onBrowseLinkClick();
    }

    void monitoringClickHandler() {
        presenter.onMonitoringLinkClick();
    }

    /**
     * Add a click listener to the element that calls back the browse handler method.
     */
    public native void addBrowseLinkClickListener(SearchGuideViewImpl x, Element element) /*-{
        element.onclick = function () {
            x.@eu.cloud4soa.frontend.widget.usermanagement.client.views.SearchGuideViewImpl::browseClickHandler()();
        };
    }-*/;

    /**
     * Add a click listener to the element that calls back the monitoring handler method.
     */
    public native void addMonitoringLinkClickListener(SearchGuideViewImpl x, Element element) /*-{
        element.onclick = function () {
            x.@eu.cloud4soa.frontend.widget.usermanagement.client.views.SearchGuideViewImpl::monitoringClickHandler()();
        };
    }-*/;


}
