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
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.widget.grid.filters.BooleanFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.DateFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.GridFilters;
import com.extjs.gxt.ui.client.widget.grid.filters.ListFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.NumericFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.StringFilter;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;

public class FilterGridExample extends LayoutContainer {

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
        return "<span style='font-weight: bold;color:" + style + "'>" + number.format(val) + "</span>";
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
    column.setWidth(100);
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

    column = new ColumnConfig("split", "Split", 75);
    column.setRenderer(new GridCellRenderer<Stock>() {
      public Object render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        Boolean b = model.get(property);
        return b != null && b.booleanValue() ? "Yes" : "No";
      }
    });
    configs.add(column);

    column = new ColumnConfig("type", "Type", 75);
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getStocks());

    ColumnModel cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(true);
    cp.setIcon(Resources.ICONS.table());
    cp.setHeading("Filter Grid");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setSize(660, 300);

    GridFilters filters = new GridFilters();
    filters.setLocal(true);

    NumericFilter last = new NumericFilter("last");
    NumericFilter filter = new NumericFilter("change");
    StringFilter nameFilter = new StringFilter("name");
    DateFilter dateFilter = new DateFilter("date");
    BooleanFilter booleanFilter = new BooleanFilter("split");

    ListStore<ModelData> typeStore = new ListStore<ModelData>();
    typeStore.add(type("Auto"));
    typeStore.add(type("Media"));
    typeStore.add(type("Medical"));
    typeStore.add(type("Tech"));
    ListFilter listFilter = new ListFilter("type", typeStore);
    listFilter.setDisplayProperty("type");

    filters.addFilter(last);
    filters.addFilter(nameFilter);
    filters.addFilter(filter);
    filters.addFilter(dateFilter);
    filters.addFilter(booleanFilter);
    filters.addFilter(listFilter);

    final Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.getView().setForceFit(true);
    grid.setStyleAttribute("borderTop", "none");
    grid.setAutoExpandColumn("name");
    grid.setBorders(false);
    grid.setStripeRows(true);
    grid.setColumnLines(true);
    grid.addPlugin(filters);
    cp.add(grid);

    ToolBar toolBar = new ToolBar();
    toolBar.getAriaSupport().setLabel("Grid Options");

    toolBar.add(new LabelToolItem("Selection Mode: "));
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
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
  }

  private ModelData type(String type) {
    ModelData model = new BaseModelData();
    model.set("type", type);
    return model;
  }

}
