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
import com.extjs.gxt.samples.client.examples.model.BeanPost;
import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PagingBeanModelGridExample extends LayoutContainer {
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    final ExampleServiceAsync service = (ExampleServiceAsync) Registry.get(Examples.SERVICE);

    if (service == null) {
      MessageBox box = new MessageBox();
      box.setButtons(MessageBox.OK);
      box.setIcon(MessageBox.INFO);
      box.setTitle("Information");
      box.setMessage("No service detected");
      box.show();
      return;
    }

    FlowLayout layout = new FlowLayout(10);
    setLayout(layout);

    RpcProxy<PagingLoadResult<BeanPost>> proxy = new RpcProxy<PagingLoadResult<BeanPost>>() {
      @Override
      public void load(Object loadConfig,
          AsyncCallback<PagingLoadResult<BeanPost>> callback) {
        service.getBeanPosts((PagingLoadConfig) loadConfig, callback);
      }
    };

    // loader
    final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(
        proxy, new BeanModelReader());
    loader.setRemoteSort(true);

    ListStore<BeanModel> store = new ListStore<BeanModel>(loader);

    final PagingToolBar toolBar = new PagingToolBar(50);
    toolBar.bind(loader);

    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
    columns.add(new ColumnConfig("forum", "Forum", 150));
    columns.add(new ColumnConfig("username", "Username", 100));
    columns.add(new ColumnConfig("subject", "Subject", 200));
    ColumnConfig date = new ColumnConfig("date", "Date", 100);
    date.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/y"));
    columns.add(date);

    ColumnModel cm = new ColumnModel(columns);

    Grid<BeanModel> grid = new Grid<BeanModel>(store, cm);
    grid.addListener(Events.Attach, new Listener<GridEvent<BeanModel>>() {
      public void handleEvent(GridEvent<BeanModel> be) {
        loader.load(0, 50);
      }
    });
    grid.setLoadMask(true);
    grid.setBorders(true);
    grid.setAutoExpandColumn("forum");

    ContentPanel panel = new ContentPanel();
    panel.setFrame(true);
    panel.setCollapsible(true);
    panel.setAnimCollapse(false);
    panel.setButtonAlign(HorizontalAlignment.CENTER);
    panel.setIcon(Resources.ICONS.table());
    panel.setHeading("Paging Grid");
    panel.setLayout(new FitLayout());
    panel.add(grid);
    panel.setSize(600, 350);
    panel.setBottomComponent(toolBar);

    add(panel);

  }
}
