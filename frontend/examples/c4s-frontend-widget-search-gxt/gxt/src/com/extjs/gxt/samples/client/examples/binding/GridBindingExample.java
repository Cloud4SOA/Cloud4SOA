/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.binding;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
public class GridBindingExample extends LayoutContainer {

  private FormBinding formBindings;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("margin", "10px");

    ContentPanel cp = new ContentPanel();

    cp.setHeading("Form Bindings");
    cp.setFrame(true);
    cp.setSize(800, 400);
    cp.setLayout(new RowLayout(Orientation.HORIZONTAL));

    Grid<Stock> grid = createGrid();
    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    grid.getSelectionModel().addListener(Events.SelectionChange,
        new Listener<SelectionChangedEvent<Stock>>() {
          public void handleEvent(SelectionChangedEvent<Stock> be) {
            if (be.getSelection().size() > 0) {
              formBindings.bind((ModelData) be.getSelection().get(0));
            } else {
              formBindings.unbind();
            }
          }
        });
    cp.add(grid, new RowData(.6, 1));

    FormPanel panel = createForm();
    formBindings = new FormBinding(panel, true);

    cp.add(panel, new RowData(.4, 1));

    add(cp);
  }

  private FormPanel createForm() {
    FormPanel panel = new FormPanel();
    panel.setHeaderVisible(false);

    TextField<String> name = new TextField<String>();
    name.setName("name");
    name.setFieldLabel("Name");
    panel.add(name);

    TextField<String> symbol = new TextField<String>();
    symbol.setName("symbol");
    symbol.setFieldLabel("Symbol");
    panel.add(symbol);

    NumberField open = new NumberField();
    open.setName("last");
    open.setFieldLabel("Last");
    panel.add(open);

    NumberField change = new NumberField();
    change.setName("change");
    change.setFieldLabel("Change");
    change.setFormat(NumberFormat.getDecimalFormat());
    panel.add(change);

    DateField last = new DateField();
    last.setName("date");
    last.setFieldLabel("Updated");
    panel.add(last);

    return panel;
  }

  private Grid<Stock> createGrid() {
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(
        currency);

    GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {

      public String render(Stock model, String property, ColumnData config, int rowIndex,
          int colIndex, ListStore<Stock> store, Grid<Stock> grid) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
      }
    };

    GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex,
          int colIndex, ListStore<Stock> store, Grid<Stock> grid) {
        return numberRenderer.render(null, property, model.get(property));
      }
    };

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(75);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(75);
    column.setRenderer(gridNumber);
    configs.add(column);

    column = new ColumnConfig("change", "Change", 90);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setRenderer(change);
    configs.add(column);

    column = new ColumnConfig("date", "Last Updated", 90);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.setMonitorChanges(true);
    store.add(TestData.getStocks());

    ColumnModel cm = new ColumnModel(configs);

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.getView().setEmptyText("sdfd");
    grid.setBorders(false);
    grid.setAutoExpandColumn("name");
    grid.setBorders(true);

    return grid;
  }

}
