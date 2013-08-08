/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.portal;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;

public class PortalExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new BorderLayout());

    LayoutContainer north = new LayoutContainer();
    BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 30);

    ContentPanel west = new ContentPanel();
    west.setBodyBorder(false);
    west.setHeading("West");
    west.setLayout(new AccordionLayout());

    ContentPanel nav = new ContentPanel();
    nav.setHeading("Navigation");
    nav.setBorders(false);
    nav.setBodyStyle("fontSize: 12px; padding: 6px");
    nav.addText(TestData.DUMMY_TEXT_SHORT);
    west.add(nav);

    ContentPanel settings = new ContentPanel();
    settings.setHeading("Settings");
    settings.setBorders(false);
    west.add(settings);

    BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 200, 100, 300);
    westData.setMargins(new Margins(5, 0, 5, 5));
    westData.setCollapsible(true);

    Portal portal = new Portal(3);
    portal.setBorders(true);
    portal.setStyleAttribute("backgroundColor", "white");
    portal.setColumnWidth(0, .33);
    portal.setColumnWidth(1, .33);
    portal.setColumnWidth(2, .33);

    Portlet portlet = new Portlet();
    portlet.setHeading("Grid in a Portlet");
    configPanel(portlet);
    portlet.setLayout(new FitLayout());
    portlet.add(createGrid());
    portlet.setHeight(250);

    portal.add(portlet, 0);

    portlet = new Portlet();
    portlet.setHeading("Another Panel 1");
    configPanel(portlet);
    portlet.addText(getBogusText());
    portal.add(portlet, 0);

    portlet = new Portlet();
    portlet.setHeading("Panel 2");
    configPanel(portlet);
    portlet.addText(getBogusText());
    portal.add(portlet, 1);

    portlet = new Portlet();
    portlet.setHeading("Another Panel 2");
    configPanel(portlet);
    portlet.addText(getBogusText());
    portal.add(portlet, 1);

    portlet = new Portlet();
    portlet.setHeading("Panel 3");
    configPanel(portlet);
    portlet.addText(getBogusText());
    portal.add(portlet, 2);

    BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
    centerData.setMargins(new Margins(5));

    add(north, northData);
    add(west, westData);
    add(portal, centerData);
  }

  private Grid<Stock> createGrid() {
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);

    GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex,
          int colIndex, ListStore<Stock> store, Grid<Stock> grid) {
        return numberRenderer.render(null, property, model.get(property));
      }
    };

    List<Stock> stocks = TestData.getStocks();

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(50);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(50);
    column.setRenderer(gridNumber);
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(stocks);

    ColumnModel cm = new ColumnModel(configs);

    Grid<Stock> g = new Grid<Stock>(store, cm);
    g.setAutoExpandColumn("name");
    g.setBorders(true);
    return g;
  }

  private String getBogusText() {
    return "<div class=text style='padding: 5px'>" + TestData.DUMMY_TEXT_SHORT + "</div>";
  }

  private void configPanel(final ContentPanel panel) {
    panel.setCollapsible(true);
    panel.setAnimCollapse(false);
    panel.getHeader().addTool(new ToolButton("x-tool-gear"));
    panel.getHeader().addTool(
        new ToolButton("x-tool-close", new SelectionListener<IconButtonEvent>() {

          @Override
          public void componentSelected(IconButtonEvent ce) {
            panel.removeFromParent();
          }

        }));
  }

}
