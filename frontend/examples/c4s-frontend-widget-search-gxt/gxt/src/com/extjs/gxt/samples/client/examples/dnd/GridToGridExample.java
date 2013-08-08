/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.dnd;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;

public class GridToGridExample extends LayoutContainer {

  private GridDropTarget target;
  private GridDropTarget target2;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    ContentPanel cp = new ContentPanel();
    cp.setSize(600, 300);
    cp.setHeading("Grid DND Example");
    cp.setLayout(new RowLayout(Orientation.HORIZONTAL));

    ToolBar toolBar = new ToolBar();
    toolBar.add(new LabelToolItem("Feedback: "));
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
    type.setTriggerAction(TriggerAction.ALL);
    type.setEditable(false);
    type.setWidth(100);
    type.add("Append");
    type.add("Insert");
    type.setSimpleValue("Append");
    type.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        boolean append = type.getSimpleValue().equals("Append");
        Feedback f = append ? Feedback.APPEND : Feedback.INSERT;
        target.setFeedback(f);
        target2.setFeedback(f);
      }
    });

    toolBar.add(type);
    toolBar.add(new SeparatorToolItem());
    cp.setTopComponent(toolBar);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getStocks());

    Grid<Stock> grid = new Grid<Stock>(store, createColumnModel());
    grid.setBorders(false);
    grid.setAutoExpandColumn("name");
    grid.setBorders(true);
    
    RowData data = new RowData(.5, 1);
    data.setMargins(new Margins(6));
    cp.add(grid, data);

    store = new ListStore<Stock>();

    Grid<Stock> grid2 = new Grid<Stock>(store, createColumnModel());
    grid2.setBorders(false);
    grid2.setAutoExpandColumn("name");
    grid2.setBorders(true);
    
    data = new RowData(.5, 1);
    data.setMargins(new Margins(6, 6, 6, 0));
    cp.add(grid2, data);

    new GridDragSource(grid);
    new GridDragSource(grid2);

    target = new GridDropTarget(grid);
    target.setAllowSelfAsSource(false);

    target2 = new GridDropTarget(grid2);
    target2.setAllowSelfAsSource(false);

    add(cp);
    setStyleAttribute("margin", "10px");
  }

  private ColumnModel createColumnModel() {
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

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getStocks());

    return new ColumnModel(configs);
  }

}
