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
import com.extjs.gxt.samples.client.examples.model.Post;
import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.DateWrapper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.BufferView;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EditableBufferedGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    final ExampleServiceAsync service = (ExampleServiceAsync) Registry.get(Examples.SERVICE);

    FlowLayout layout = new FlowLayout(10);
    setLayout(layout);

    RpcProxy<PagingLoadResult<Post>> proxy = new RpcProxy<PagingLoadResult<Post>>() {
      @Override
      public void load(Object loadConfig, AsyncCallback<PagingLoadResult<Post>> callback) {
        service.getPosts((PagingLoadConfig) loadConfig, callback);
      }
    };

    // loader
    final PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(
        proxy);
    loader.setRemoteSort(true);
    loader.addListener(Loader.Load, new LoadListener() {
      @Override
      public void loaderLoad(LoadEvent le) {
        BasePagingLoadResult<Post> r = le.<BasePagingLoadResult<Post>> getData();
        for (Post p : r.getData()) {
          if (p.getSubject().equals("")) {
            p.setSubject(null);
          }
          p.setDate(new DateWrapper(p.getDate()).clearTime().asDate());
        }
      }

    });

    ListStore<Post> store = new ListStore<Post>(loader);

    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

    ColumnConfig column;

    column = new ColumnConfig("forum", "Forum", 150);
    column.setEditor(new CellEditor(new TextField<String>()));
    columns.add(column);

    column = new ColumnConfig("username", "Username", 100);
    column.setEditor(new CellEditor(new TextField<String>()));
    columns.add(column);

    column = new ColumnConfig("subject", "Subject", 200);
    column.setEditor(new CellEditor(new TextField<String>()));
    columns.add(column);

    ColumnConfig date = new ColumnConfig("date", "Date", 100);
    date.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/y"));
    DateField dateField = new DateField();
    dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat("MM/dd/y"));
    date.setEditor(new CellEditor(dateField));
    columns.add(date);

    ColumnModel cm = new ColumnModel(columns);

    EditorGrid<Post> grid = new EditorGrid<Post>(store, cm);
    grid.addListener(Events.Attach, new Listener<GridEvent<Post>>() {
      public void handleEvent(GridEvent<Post> be) {
        loader.load(0, 1000);
      }
    });
    grid.setTrackMouseOver(false);
    grid.setLoadMask(true);
    grid.setBorders(true);
    grid.setAutoExpandColumn("forum");
    grid.setView(new BufferView());
    ContentPanel panel = new ContentPanel();
    panel.setFrame(true);
    panel.setCollapsible(true);
    panel.setAnimCollapse(false);
    panel.setIcon(Resources.ICONS.table());
    panel.setHeading("Editable Buffered Grid (1000 rows)");
    panel.setLayout(new FitLayout());
    panel.add(grid);
    panel.setSize(600, 350);

    add(panel);
  }
}
