/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treegrid;

import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.FileServiceAsync;
import com.extjs.gxt.samples.client.examples.model.FileModel;
import com.extjs.gxt.samples.client.examples.model.FolderModel;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseRemoteSortTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelKeyProvider;
import com.extjs.gxt.ui.client.data.RemoteSortTreeLoadConfig;
import com.extjs.gxt.ui.client.data.RemoteSortTreeLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * To enable remote sorting use a RemoteSortTreeLoader. The DataProxy will be
 * passed a RemoteSortTreeLoadConfig which will contain the parent model, sort
 * field, and sort direction.
 */
@SuppressWarnings("deprecation")
public class RemoteSortTreeGridExample extends LayoutContainer {
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    final FileServiceAsync service = (FileServiceAsync) Registry.get(Examples.FILE_SERVICE);

    // data proxy
    RpcProxy<List<FileModel>> proxy = new RpcProxy<List<FileModel>>() {
      @Override
      protected void load(Object loadConfig, AsyncCallback<List<FileModel>> callback) {
        service.getFolderChildren((RemoteSortTreeLoadConfig) loadConfig, callback);
      }
    };

    // tree loader
    final RemoteSortTreeLoader<FileModel> loader = new BaseRemoteSortTreeLoader<FileModel>(proxy) {
      @Override
      public boolean hasChildren(FileModel parent) {
        return parent instanceof FolderModel;
      }
    };
    loader.setRemoteSort(true);

    // trees store
    TreeStore<FileModel> store = new TreeStore<FileModel>(loader);

    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    name.setRenderer(new TreeGridCellRenderer<ModelData>());

    ColumnConfig date = new ColumnConfig("date", "Date", 140);
    date.setDateTimeFormat(DateTimeFormat.getMediumDateTimeFormat());

    ColumnConfig size = new ColumnConfig("size", "Size", 100);

    ColumnModel cm = new ColumnModel(Arrays.asList(name, date, size));

    ContentPanel cp = new ContentPanel();
    cp.setHeading("RemoteSort TreeGrid With State");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setFrame(true);
    cp.setSize(600, 300);

    final TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm);

    // by providing a key provider and enabling state, the trees expand state
    // will be restored when refreshing the page and also after sorting.
    tree.setStateful(true);
    // stateful components need a defined id
    tree.setId("statefullremotesorttreegrid");
    store.setKeyProvider(new ModelKeyProvider<FileModel>() {

      public String getKey(FileModel model) {
        return (String) model.get("id");
      }

    });
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-page"));
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);
    cp.add(tree);

    ToolBar toolbar = new ToolBar();
    Button btn = new Button("Clear State");
    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        tree.clearState();
      }
    });
    toolbar.add(btn);
    btn = new Button("Reload");
    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        loader.load();
      }
    });
    toolbar.add(btn);
    cp.setTopComponent(toolbar);
    
    add(cp);
  }
}
