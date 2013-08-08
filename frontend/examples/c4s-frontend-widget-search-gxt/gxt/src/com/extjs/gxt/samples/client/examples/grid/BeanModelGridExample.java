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

import com.extjs.gxt.samples.client.ExampleServiceAsync;
import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.model.Customer;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BeanModelGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("padding", "20px");

    // gwt service
    final ExampleServiceAsync service = (ExampleServiceAsync) Registry.get(Examples.SERVICE);

    // proxy and reader
    RpcProxy<List<Customer>> proxy = new RpcProxy<List<Customer>>() {
      @Override
      public void load(Object loadConfig, AsyncCallback<List<Customer>> callback) {
        service.getCustomers(callback);
      }
    };
    BeanModelReader reader = new BeanModelReader();

    // loader and store
    ListLoader<ListLoadResult<ModelData>> loader = new BaseListLoader<ListLoadResult<ModelData>>(proxy, reader);
    ListStore<BeanModel> store = new ListStore<BeanModel>(loader);

    loader.load();

    // column model
    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
    columns.add(new ColumnConfig("name", "Name", 200));
    columns.add(new ColumnConfig("email", "Email", 100));
    columns.add(new ColumnConfig("age", "Age", 50));
    ColumnModel cm = new ColumnModel(columns);

    Grid<BeanModel> grid = new Grid<BeanModel>(store, cm);
    grid.setAutoExpandColumn("name");
    
    ContentPanel panel = new ContentPanel();
    panel.setHeading("BeanModel Grid Example");
    panel.setSize(400, 200);
    panel.setIcon(Resources.ICONS.table());
    panel.setLayout(new FitLayout());
    panel.add(grid);

    add(panel);
  }

}
