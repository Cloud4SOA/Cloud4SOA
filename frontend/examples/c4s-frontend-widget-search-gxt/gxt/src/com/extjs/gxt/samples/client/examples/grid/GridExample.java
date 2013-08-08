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
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.CellSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.tips.QuickTip;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
public class GridExample extends LayoutContainer {

  private ColumnModel cm;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));
    getAriaSupport().setPresentation(true);

    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);

    GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : GXT.isHighContrastMode ? "#00ff5a" : "green";
        String v = number.format(val);

        return "<span qtitle='" + cm.getColumnById(property).getHeader() + "' qtip='" + v
            + "' style='font-weight: bold;color:" + style + "'>" + v + "</span>";
      }
    };

    GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        return numberRenderer.render(null, property, model.get(property));
      }
    };

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    column.setRowHeader(true);
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

    column = new ColumnConfig("date", "Last Updated", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));
    configs.add(column);
    
    ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getStocks());

    cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(true);
    cp.setIcon(Resources.ICONS.table());
    cp.setHeading("Basic Grid");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.getHeader().setIconAltText("Grid Icon");
    cp.setSize(600, 300);

    final Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setStyleAttribute("borderTop", "none");
    grid.setAutoExpandColumn("name");
    grid.setBorders(false);
    grid.setStripeRows(true);
    grid.setColumnLines(true);
    grid.setColumnReordering(true);
    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
    cp.add(grid);

    ToolBar toolBar = new ToolBar();
    toolBar.getAriaSupport().setLabel("Grid Options");

    toolBar.add(new LabelToolItem("Selection Mode: "));
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
    type.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
    type.setTriggerAction(TriggerAction.ALL);
    type.setEditable(false);
    type.setFireChangeEventOnSetValue(true);
    type.setWidth(100);
    type.add("Row");
    type.add("Cell");
    type.setSimpleValue("Row");
    type.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        boolean cell = type.getSimpleValue().equals("Cell");
        grid.getSelectionModel().deselectAll();
        if (cell) {
          grid.setSelectionModel(new CellSelectionModel<Stock>());
        } else {
          grid.setSelectionModel(new GridSelectionModel<Stock>());
        }
      }
    });
    toolBar.add(type);

    cp.setTopComponent(toolBar);

    add(cp);

    // needed to enable quicktips (qtitle for the heading and qtip for the
    // content) that are setup in the change GridCellRenderer
    new QuickTip(grid);
  }

}
