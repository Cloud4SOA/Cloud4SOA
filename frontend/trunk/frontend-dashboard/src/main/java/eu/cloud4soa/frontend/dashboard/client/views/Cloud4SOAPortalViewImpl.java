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

import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.SimplePanel;

public class Cloud4SOAPortalViewImpl extends Composite implements Cloud4SOAPortalView {

    private Presenter presenter;

    private Portal portal;

    public Cloud4SOAPortalViewImpl() {
        initWidgets();
    }


    private void initWidgets() {

        portal = new Portal(2);
        portal.setBorders(false);
        portal.setStyleAttribute("backgroundColor", "transparent");
        portal.setColumnWidth(0, .5);
        portal.setColumnWidth(1, .5);

        initComponent(portal);
    }

    @Override
    public HasOneWidget createNewWidget(String heading, boolean allowClosing, Position pos) {
        int column = 0;
        boolean top = true;
        switch (pos) {
            case TOP_LEFT:
                column = 0;
                top = true;
                break;
            case BOTTOM_LEFT:
                column =0;
                top = false;
                break;
            case TOP_RIGHT:
                column = 1;
                top = true;
                break;
            case BOTTOM_RIGHT:
                column = 1;
                top = false;
                break;
        }


        if (top)
            return createNewWidget(heading, allowClosing, 0, column);
        else {
            LayoutContainer columnContainer= portal.getItem(column);
            int index = columnContainer.getItemCount();
            return createNewWidget(heading, allowClosing, index, column);
        }
    }

    public HasOneWidget createNewWidget(String heading, boolean allowClosing, int index, int column) {
        Portlet portlet = new Portlet();
        portlet.setHeading(heading);
        HasOneWidget container = configPanel(portlet, allowClosing);
        portal.insert(portlet, index, column);
        // TODO validate index and column
        return container;
    }

    private HasOneWidget configPanel(final ContentPanel panel, boolean allowClosing) {
        panel.setCollapsible(true);
        panel.setAnimCollapse(false);
        panel.setExpanded(true);
        if (allowClosing) {
            panel.getHeader().addTool(
                    new ToolButton("x-tool-close", new SelectionListener<IconButtonEvent>() {

                        @Override
                        public void componentSelected(IconButtonEvent ce) {
                            panel.removeFromParent();
                        }

                    }));
        }
        SimplePanel widget = new SimplePanel();
        panel.add(widget);
        return widget;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
