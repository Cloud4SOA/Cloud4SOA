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
//import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Application editor guide view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorGuideViewImpl extends Composite implements ApplicationEditorGuideView {

    interface Binder extends UiBinder<Widget, ApplicationEditorGuideViewImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    private Presenter presenter;

    @UiField
    AnchorElement newLink;

    @UiField
    DivElement editParagraph;

    @UiField
    DivElement searchParagraph;


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public ApplicationEditorGuideViewImpl() {
        initWidget(binder.createAndBindUi(this));

        addNewLinkClickListener(this, newLink);

    }

    @Override
    public void setApplicationSelected(boolean selected) {
        if (selected) {
            editParagraph.addClassName("c4s-hidden");
            searchParagraph.removeClassName("c4s-hidden");
        } else {
            editParagraph.removeClassName("c4s-hidden");
            searchParagraph.addClassName("c4s-hidden");
        }
    }

    void newLinkClickHandler() {
        presenter.onNewLinkClick();
    }

    /**
     * Add a click listener to the element that calls back the newHandler method.
     */
    public native void addNewLinkClickListener(ApplicationEditorGuideViewImpl x, Element element) /*-{
        element.onclick = function () {
            x.@eu.cloud4soa.frontend.widget.usermanagement.client.views.ApplicationEditorGuideViewImpl::newLinkClickHandler()();
        };
    }-*/;


}
