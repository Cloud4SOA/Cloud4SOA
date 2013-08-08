/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.grid;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlexTable;
public class ColumnGroupingExample extends LayoutContainer {

  private NumberFormat currency = NumberFormat.getCurrencyFormat();
  private NumberFormat number = NumberFormat.getFormat("0.00");
  private NumberCellRenderer<Grid<Stock>> numberRenderer;
  private GridCellRenderer<Stock> change;
  private GridCellRenderer<Stock> gridNumber;
  private VerticalPanel vp;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);
    change = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
      }
    };

    gridNumber = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        return numberRenderer.render(null, property, model.get(property));
      }
    };

    vp = new VerticalPanel();
    vp.setSpacing(20);

    createGrid(false);
    createGrid(true);

    add(vp);
  }

  private void createGrid(boolean widget) {
    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(75);
    column.setRenderer(gridNumber);
    configs.add(column);

    column = new ColumnConfig("change", "Change", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setRenderer(change);
    configs.add(column);

    column = new ColumnConfig("date", 125);
    if (widget) {
      Button btn = new Button("Updated");
      btn.addListener(Events.OnClick, new Listener<ButtonEvent>() {
        public void handleEvent(ButtonEvent be) {
          // stop column from getting click and causing sort
          be.cancelBubble();
        }
      });
      btn.setStyleAttribute("float", "left");
      column.setWidget(btn, "Last Updated");
    } else {
      column.setAlignment(HorizontalAlignment.RIGHT);
      column.setHeader("Last Updated");
    }

    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getStocks());

    ColumnModel cm = new ColumnModel(configs);

    cm.addHeaderGroup(0, 0, new HeaderGroupConfig("Header Grouping Example", 1, 5));
    cm.addHeaderGroup(1, 2, new HeaderGroupConfig("Stock Performance", 1, 2));

    if (widget) {
      Slider s = new Slider();
      s.setWidth(100);

      // ugly, but centers slider
      FlexTable tbl = new FlexTable();
      tbl.setWidth("100%");
      tbl.setHTML(0, 0, "&nbsp;");
      tbl.setHTML(0, 1, "<span style='white-space: nowrap;font-size: 11px'>Slide Me: &nbsp;</span>");
      tbl.setWidget(0, 2, s);
      tbl.setHTML(0, 3, "&nbsp;");
      tbl.getCellFormatter().setWidth(0, 0, "50%");
      tbl.getCellFormatter().setWidth(0, 3, "50%");
      cm.addHeaderGroup(1, 0, new HeaderGroupConfig(tbl, 1, 2));
    } else {
      cm.addHeaderGroup(1, 0, new HeaderGroupConfig("Stock Information", 1, 2));
    }

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(false);
    cp.setIcon(Resources.ICONS.table());
    cp.setHeading(widget ? "Column Grouping with Widget" : "Column Grouping");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setSize(600, 300);

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setStyleAttribute("borderTop", "none");
    grid.getView().setForceFit(true);
    grid.setBorders(true);
    cp.add(grid);

    vp.add(cp);
  }
}
