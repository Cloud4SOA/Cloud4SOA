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

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.AggregationRenderer;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;

public class AggregationGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    
    setLayout(new FlowLayout(15));
    
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);

    GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        double val = (Double)model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
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

    final ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getStocks());

    ColumnModel cm = new ColumnModel(configs);
    
    cm.addHeaderGroup(0, 2, new HeaderGroupConfig("Stock Performance", 1, 2));
    cm.addHeaderGroup(0, 0, new HeaderGroupConfig("Stock Information", 1, 2));
 
    AggregationRowConfig<Stock> averages = new AggregationRowConfig<Stock>();
    averages.setHtml("name", "Average");
    
    // with summary type and format
    averages.setSummaryType("last", SummaryType.AVG);
    averages.setSummaryFormat("last", NumberFormat.getCurrencyFormat());
    
    // with renderer
    averages.setSummaryType("change", SummaryType.AVG);
    averages.setRenderer("change", new AggregationRenderer<Stock>() {
      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {
        // you can return html here
        return number.format(value.doubleValue());
      }
    });
    cm.addAggregationRow(averages);
    
    averages = new AggregationRowConfig<Stock>();
    averages.setHtml("name", "Maximum");
    
    
    averages.setSummaryType("last", SummaryType.MAX);
    averages.setSummaryFormat("last", NumberFormat.getCurrencyFormat());

    averages.setSummaryType("change", SummaryType.MAX);
    averages.setRenderer("change", new AggregationRenderer<Stock>() {
      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {
        return number.format(value.doubleValue());
      }
    });
    cm.addAggregationRow(averages);
    
    ContentPanel cp = new ContentPanel();
    cp.setCollapsible(true);
    cp.setAnimCollapse(false);
    cp.setFrame(true);
    cp.setHeading("Aggregation Rows");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setBounds(10, 10, 600, 350);

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setBorders(false);
    grid.setAutoExpandColumn("name");
    grid.setBorders(true);
    cp.add(grid);
    
    add(cp);
  }
  
}
