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
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;

public class GroupingGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));

    GroupingStore<Stock> store = new GroupingStore<Stock>();
    store.add(TestData.getCompanies());
    store.groupBy("industry");

    ColumnConfig company = new ColumnConfig("name", "Company", 60);
    ColumnConfig price = new ColumnConfig("open", "Price", 20);
    ColumnConfig change = new ColumnConfig("change", "Change", 20);
    ColumnConfig industry = new ColumnConfig("industry", "Industry", 20);
    ColumnConfig last = new ColumnConfig("date", "Last Updated", 20);
    last.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/y"));

    List<ColumnConfig> config = new ArrayList<ColumnConfig>();
    config.add(company);
    config.add(price);
    config.add(change);
    config.add(industry);
    config.add(last);

    final ColumnModel cm = new ColumnModel(config);

    GroupingView view = new GroupingView();
    view.setShowGroupedColumn(false);
    view.setForceFit(true);
    view.setGroupRenderer(new GridGroupRenderer() {
      public String render(GroupColumnData data) {
        String f = cm.getColumnById(data.field).getHeader();
        String l = data.models.size() == 1 ? "Item" : "Items";
        return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";
      }
    });

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setView(view);
    grid.setBorders(true);

    ContentPanel panel = new ContentPanel();
    panel.setHeading("Grouping Example");
    panel.setIcon(Resources.ICONS.table());
    panel.setCollapsible(true);
    panel.setFrame(true);
    panel.setSize(700, 450);
    panel.setLayout(new FitLayout());
    panel.add(grid);
    grid.getAriaSupport().setLabelledBy(panel.getHeader().getId() + "-label");
    add(panel);
  }

}
