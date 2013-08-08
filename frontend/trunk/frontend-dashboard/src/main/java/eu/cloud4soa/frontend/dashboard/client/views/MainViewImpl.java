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

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import eu.cloud4soa.frontend.commons.client.gxt.WidgetWrapper;

/**
 * The (GXT) implementation of the main view. This view defines the template of
 * the page, which is basically a border mainLayoutContainer with the header on
 * the north. Middle content may vary depending on the place (main page with
 * login, user registration or the portal).
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MainViewImpl extends Composite implements MainView {

    @UiTemplate("MainViewImpl.ui.xml")
    interface Binder extends UiBinder<Component, MainViewImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    @UiField
    ContentPanel mainPanel;

    private LayoutContainer northContainer;
    private LayoutContainer southContainer;

    private ContentPanel westContainer;
    private ContentPanel centerContainer;
    private ContentPanel eastContainer;

    private LayoutContainer leftColumn;
    private LayoutContainer centerColumn;
    private LayoutContainer rightColumn;

    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public MainViewImpl() {
        initComponent(binder.createAndBindUi(this));

        mainPanel.setLayout(new BorderLayout());

        northContainer = new LayoutContainer();
        northContainer.addStyleName("c4s-blue-background");

        westContainer = new ContentPanel();
        westContainer.setHeaderVisible(false);
        westContainer.setLayout(new FitLayout());
        westContainer.setScrollMode(Style.Scroll.NONE);
        westContainer.addStyleName("c4s-blue-background");

        centerContainer = new ContentPanel();
        centerContainer.setBodyBorder(false);
        centerContainer.setHeaderVisible(false);
        centerContainer.setLayout(new FitLayout());
        centerContainer.setScrollMode(Style.Scroll.NONE);
        centerContainer.addStyleName("c4s-blue-background");

        eastContainer = new ContentPanel();
        eastContainer.setHeaderVisible(false);
        eastContainer.setLayout(new FitLayout());
        eastContainer.setScrollMode(Style.Scroll.NONE);
        eastContainer.addStyleName("c4s-blue-background");

        southContainer = new LayoutContainer();
        southContainer.addStyleName("c4s-blue-background");

        BorderLayoutData northData = new BorderLayoutData(Style.LayoutRegion.NORTH, 100);
        northData.setCollapsible(false);
        northData.setFloatable(true);
        northData.setHideCollapseTool(true);
        northData.setSplit(false);
        northData.setMargins(new Margins(0, 0, 0, 0));

        BorderLayoutData westData = new BorderLayoutData(Style.LayoutRegion.WEST, 0.30f);
        westData.setCollapsible(true);
        westData.setHideCollapseTool(false);
        westData.setSplit(false);
        westData.setMargins(new Margins(0, 0, 0, 0));

        BorderLayoutData eastData = new BorderLayoutData(Style.LayoutRegion.EAST, 0.30f);
        eastData.setCollapsible(true);
        eastData.setHideCollapseTool(false);
        eastData.setSplit(false);
        eastData.setMargins(new Margins(0, 0, 0, 0));

        BorderLayoutData centerData = new BorderLayoutData(Style.LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0));

        BorderLayoutData southData = new BorderLayoutData(Style.LayoutRegion.SOUTH, 60);
        southData.setSplit(false);
        southData.setCollapsible(false);
        southData.setFloatable(true);
        southData.setMargins(new Margins(0, 0, 0, 0));

        mainPanel.add(northContainer, northData);
        mainPanel.add(westContainer, westData);
        mainPanel.add(centerContainer, centerData);
        mainPanel.add(eastContainer, eastData);
        mainPanel.add(southContainer, southData);

        leftColumn = new LayoutContainer(new FlowLayout());
        centerColumn = new LayoutContainer(new FlowLayout());
        rightColumn = new LayoutContainer(new FlowLayout());

        westContainer.add(leftColumn);
        centerContainer.add(centerColumn);
        eastContainer.add(rightColumn);

    }

    @Override
    public AcceptsOneWidget getCenter() {
        centerContainer.setLayout(new FitLayout());
        // if using this method the scroll must be disabled
        centerColumn.setScrollMode(Style.Scroll.NONE);
        return new WidgetWrapper(centerContainer);
    }

    @Override
    public AcceptsOneWidget getNorth() {
        return new WidgetWrapper(northContainer);
    }

    @Override
    public AcceptsOneWidget getSouth() {
        return new WidgetWrapper(southContainer);
    }

    @Override
    public AcceptsOneWidget getWest() {
        return new WidgetWrapper(westContainer);
    }

    @Override
    public AcceptsOneWidget getEast() {
        return new WidgetWrapper(eastContainer);
    }

    @Override
    public void hideCenter() {
        ((BorderLayout) mainPanel.getLayout()).hide(Style.LayoutRegion.CENTER);
    }

    @Override
    public void showNorth() {
        ((BorderLayout) mainPanel.getLayout()).show(Style.LayoutRegion.NORTH);
    }

    @Override
    public void showSouth() {
        ((BorderLayout) mainPanel.getLayout()).show(Style.LayoutRegion.SOUTH);
    }

    @Override
    public void showWest() {
        ((BorderLayout) mainPanel.getLayout()).show(Style.LayoutRegion.WEST);
    }

    @Override
    public void showEast() {
        ((BorderLayout) mainPanel.getLayout()).show(Style.LayoutRegion.EAST);
    }

    @Override
    public void showCenter() {
        ((BorderLayout) mainPanel.getLayout()).show(Style.LayoutRegion.CENTER);
    }

    @Override
    public void hideNorth() {
        ((BorderLayout) mainPanel.getLayout()).hide(Style.LayoutRegion.NORTH);
    }

    @Override
    public void hideSouth() {
        ((BorderLayout) mainPanel.getLayout()).hide(Style.LayoutRegion.SOUTH);
    }

    @Override
    public void hideWest() {
        ((BorderLayout) mainPanel.getLayout()).hide(Style.LayoutRegion.WEST);
    }

    @Override
    public void hideEast() {
        ((BorderLayout) mainPanel.getLayout()).hide(Style.LayoutRegion.EAST);
    }

    @Override
    public void collapseEast() {
        ((BorderLayout) mainPanel.getLayout())
                .collapse(Style.LayoutRegion.EAST);
    }

    @Override
    public void collapseWest() {
        ((BorderLayout) mainPanel.getLayout())
                .collapse(Style.LayoutRegion.WEST);
    }

    @Override
    public void expandWest() {
        ((BorderLayout) mainPanel.getLayout()).expand(Style.LayoutRegion.WEST);
    }

    @Override
    public void expandEast() {
        ((BorderLayout) mainPanel.getLayout()).expand(Style.LayoutRegion.EAST);
    }

    @Override
    public HasOneWidget addNewWidget(String heading, boolean allowClosing,
                                     Position position) {
        switch (position) {
            case TOP_LEFT:
                return createNewWidgetAtTop(heading, allowClosing, leftColumn);
            case BOTTOM_LEFT:
                return createNewWidgetAtBottom(heading, allowClosing, leftColumn);
            case TOP_RIGHT:
                return createNewWidgetAtTop(heading, allowClosing, rightColumn);
            case BOTTOM_RIGHT:
                return createNewWidgetAtBottom(heading, allowClosing, rightColumn);
            case TOP_CENTER:
                return createNewWidgetAtTop(heading, allowClosing, centerColumn);
            case BOTTOM_CENTER:
                return createNewWidgetAtBottom(heading, allowClosing, centerColumn);
            default:
                return createNewWidgetAtTop(heading, allowClosing, centerColumn);

        }
    }

    private HasOneWidget createNewWidgetAtTop(String heading,
                                              boolean allowClosing, LayoutContainer region) {
        return createNewWidget(heading, allowClosing, 0, region);
    }

    private HasOneWidget createNewWidgetAtBottom(String heading,
                                                 boolean allowClosing, LayoutContainer region) {
        return createNewWidget(heading, allowClosing, region.getItemCount(),
                region);
    }

    private HasOneWidget createNewWidget(String heading, boolean allowClosing,
                                         int index, LayoutContainer region) {
        ContentPanel contentPanel = new ContentPanel();
        // todo check if settings this borders is the right thing to do
        contentPanel.setBorders(true);
        if (heading == null)
            contentPanel.setHeaderVisible(false);
        else {
            contentPanel.setHeaderVisible(true);
            contentPanel.setHeading(heading);
        }
        SimplePanel container = configPanel(contentPanel, allowClosing);
        region.insert(contentPanel, index, new RowData(1, -1));
        return container;
    }

    private SimplePanel configPanel(final ContentPanel panel,
                                    boolean allowClosing) {
        // panel.setCollapsible(true);
        // panel.setAnimCollapse(false);
        // panel.setExpanded(true);
        if (allowClosing) {
            panel.getHeader().addTool(
                    new ToolButton("x-tool-close",
                            new SelectionListener<IconButtonEvent>() {

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
    public void layout() {
        mainPanel.layout();
    }

}