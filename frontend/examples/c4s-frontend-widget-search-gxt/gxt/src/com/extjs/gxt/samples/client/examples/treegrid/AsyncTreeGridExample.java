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
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelKeyProvider;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
@SuppressWarnings("deprecation")
public class AsyncTreeGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    final FileServiceAsync service = (FileServiceAsync) Registry.get(Examples.FILE_SERVICE);

    // data proxy
    RpcProxy<List<FileModel>> proxy = new RpcProxy<List<FileModel>>() {
      @Override
      protected void load(Object loadConfig, AsyncCallback<List<FileModel>> callback) {
        service.getFolderChildren((FileModel) loadConfig, callback);
      }
    };

    // tree loader
    final TreeLoader<FileModel> loader = new BaseTreeLoader<FileModel>(proxy) {
      @Override
      public boolean hasChildren(FileModel parent) {
        return parent instanceof FolderModel;
      }
    };

    // trees store
    final TreeStore<FileModel> store = new TreeStore<FileModel>(loader);
    store.setStoreSorter(new StoreSorter<FileModel>() {

      @Override
      public int compare(Store<FileModel> store, FileModel m1, FileModel m2, String property) {
        boolean m1Folder = m1 instanceof FolderModel;
        boolean m2Folder = m2 instanceof FolderModel;

        if (m1Folder && !m2Folder) {
          return -1;
        } else if (!m1Folder && m2Folder) {
          return 1;
        }

        return super.compare(store, m1, m2, property);
      }
    });

    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    name.setRenderer(new TreeGridCellRenderer<ModelData>());

    ColumnConfig date = new ColumnConfig("date", "Date", 100);
    date.setDateTimeFormat(DateTimeFormat.getMediumDateTimeFormat());

    ColumnConfig size = new ColumnConfig("size", "Size", 100);

    ColumnModel cm = new ColumnModel(Arrays.asList(name, date, size));

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(false);
    cp.setHeading("Async TreeGrid");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setFrame(true);
    cp.setSize(600, 300);

    TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm);
    tree.setStateful(true);
    // stateful components need a defined id
    tree.setId("statefullasynctreegrid");
    store.setKeyProvider(new ModelKeyProvider<FileModel>() {

      public String getKey(FileModel model) {
        return model.<String> get("id");
      }

    });
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-page"));
    tree.setSize(400, 400);
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);
    cp.add(tree);

    ToolTipConfig config = new ToolTipConfig();
    config.setTitle("Example Information");
    config.setShowDelay(1);
    config.setText("In this example state has been enabled for the treegrid. When enabled, the expand state of the treegrid is "
        + "saved and restored using the StateManager. Try refreshing the browser after expanding some nodes in the "
        + "treegrid. Notice that this works with asynchronous loading of nodes.");

    ToolButton btn = new ToolButton("x-tool-help");
    btn.setToolTip(config);

    cp.getHeader().addTool(btn);

    add(cp);
  }

}
