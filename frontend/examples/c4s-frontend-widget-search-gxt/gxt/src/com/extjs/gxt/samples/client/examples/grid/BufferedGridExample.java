/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.grid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.samples.client.examples.model.Post;
import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.DataField;
import com.extjs.gxt.ui.client.data.JsonPagingLoadResultReader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.ScriptTagProxy;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.BufferView;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;

public class BufferedGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    FlowLayout layout = new FlowLayout(10);
    setLayout(layout);

    String url = "http://www.extjs.com/forum/topics-browse-remote.php";
    ScriptTagProxy<PagingLoadResult<ModelData>> proxy = new ScriptTagProxy<PagingLoadResult<ModelData>>(url);

    ModelType type = new ModelType();
    type.setRoot("topics");
    type.setTotalName("totalCount");
    type.addField("title");
    type.addField("forumtitle");
    type.addField("forumid");
    type.addField("author");
    type.addField("replycount");
    type.addField("lastposter");
    type.addField("excerpt");
    type.addField("replycount");
    type.addField("threadid");

    DataField datefield = new DataField("lastpost");
    datefield.setType(Date.class);
    datefield.setFormat("timestamp");
    type.addField(datefield);

    JsonPagingLoadResultReader<PagingLoadResult<ModelData>> reader = new JsonPagingLoadResultReader<PagingLoadResult<ModelData>>(
        type);

    final PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy,
        reader);

    loader.addListener(Loader.BeforeLoad, new Listener<LoadEvent>() {
      public void handleEvent(LoadEvent be) {
        BasePagingLoadConfig m = be.<BasePagingLoadConfig> getConfig();
        m.set("start", m.get("offset"));
        m.set("ext", "js");
        m.set("lightWeight", true);
        m.set("sort", (m.get("sortField") == null) ? "" : m.get("sortField"));
        m.set("dir", (m.get("sortDir") == null || (m.get("sortDir") != null && m.<SortDir> get("sortDir").equals(
            SortDir.NONE))) ? "" : m.get("sortDir"));

      }
    });
    loader.setSortDir(SortDir.DESC);
    loader.setSortField("lastpost");

    loader.setRemoteSort(true);

    ListStore<ModelData> store = new ListStore<ModelData>(loader);

    final PagingToolBar toolBar = new PagingToolBar(500);
    toolBar.bind(loader);

    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

    RowNumberer rn = new RowNumberer();
    rn.setWidth(30);
    columns.add(rn);

    ColumnConfig title = new ColumnConfig("title", "Topic", 100);
    title.setRenderer(new GridCellRenderer<ModelData>() {

      public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<ModelData> store, Grid<ModelData> grid) {
        return "<b><a style=\"color: #385F95; text-decoration: none;\" href=\"http://extjs.com/forum/showthread.php?t="
            + model.get("threadid")
            + "\" target=\"_blank\">"
            + model.get("title")
            + "</a></b><br /><a style=\"color: #385F95; text-decoration: none;\" href=\"http://extjs.com/forum/forumdisplay.php?f="
            + model.get("forumid") + "\" target=\"_blank\">" + model.get("forumtitle") + " Forum</a>";
      }

    });
    columns.add(title);
    columns.add(new ColumnConfig("replycount", "Replies", 50));

    ColumnConfig last = new ColumnConfig("lastpost", "Last Post", 200);
    last.setRenderer(new GridCellRenderer<ModelData>() {

      public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<ModelData> store, Grid<ModelData> grid) {
        return model.get("lastpost") + "<br/>by " + model.get("lastposter");
      }

    });
    columns.add(last);

    ColumnModel cm = new ColumnModel(columns);

    Grid<ModelData> grid = new Grid<ModelData>(store, cm);
    grid.setTrackMouseOver(false);
    grid.addListener(Events.Attach, new Listener<GridEvent<Post>>() {
      public void handleEvent(GridEvent<Post> be) {
        loader.load(0, 500);
      }
    });
    grid.setTrackMouseOver(false);
    grid.setLoadMask(true);
    grid.setBorders(true);
    grid.setAutoExpandColumn("title");

    BufferView view = new BufferView();
    view.setRowHeight(32);

    grid.setView(view);

    ContentPanel panel = new ContentPanel();
    panel.setFrame(true);
    panel.setCollapsible(true);
    panel.setAnimCollapse(false);
    panel.setIcon(Resources.ICONS.table());
    panel.setHeading("Buffered Grid");
    panel.setLayout(new FitLayout());
    panel.add(grid);
    panel.setSize(600, 350);
    panel.setBottomComponent(toolBar);

    add(panel);
  }

}
