/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.dnd;

import java.util.Arrays;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.dnd.ListViewDragSource;
import com.extjs.gxt.ui.client.dnd.ListViewDropTarget;
import com.extjs.gxt.ui.client.dnd.TreeGridDragSource;
import com.extjs.gxt.ui.client.dnd.TreeGridDropTarget;
import com.extjs.gxt.ui.client.dnd.TreePanelDragSource;
import com.extjs.gxt.ui.client.dnd.TreePanelDropTarget;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;

public class MultiComponentExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    TableLayout layout = new TableLayout(2);
    layout.setCellSpacing(10);
    setLayout(layout);

    createTree();
    createList();
    createTreeGrid();
    createGrid();
  }

  private void createGrid() {
    ListStore<ModelData> store = new ListStore<ModelData>();

    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    ColumnConfig date = new ColumnConfig("author", "Author", 100);
    ColumnConfig size = new ColumnConfig("genre", "Genre", 100);

    ColumnModel cm = new ColumnModel(Arrays.asList(name, date, size));

    Grid<ModelData> grid = new Grid<ModelData>(store, cm);
    grid.setBorders(false);
    grid.setAutoExpandColumn("name");
    grid.setTrackMouseOver(false);

    ContentPanel cp = new ContentPanel();
    cp.setHeading("Grid");
    cp.setSize(400, 300);
    cp.setLayout(new FitLayout());
    cp.add(grid);

    new GridDragSource(grid);
    new GridDropTarget(grid);

    add(cp);
  }

  private void createTreeGrid() {
    TreeStore<ModelData> store = new TreeStore<ModelData>();

    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    name.setRenderer(new TreeGridCellRenderer<ModelData>());

    ColumnConfig date = new ColumnConfig("author", "Author", 100);
    ColumnConfig size = new ColumnConfig("genre", "Genre", 100);
    ColumnModel cm = new ColumnModel(Arrays.asList(name, date, size));

    TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm);
    tree.setBorders(false);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);

    new TreeGridDropTarget(tree);
    new TreeGridDragSource(tree);

    ContentPanel cp = new ContentPanel();
    cp.setHeading("TreeGrid");
    cp.setSize(400, 300);
    cp.setLayout(new FitLayout());
    cp.add(tree);

    add(cp);
  }

  private void createTree() {
    Folder model = TestData.getTreeModel();

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    store.add(model.getChildren(), true);

    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
    tree.setDisplayProperty("name");
    tree.getStyle().setLeafIcon(Resources.ICONS.music());

    ContentPanel cp = new ContentPanel();
    cp.setHeading("TreePanel");
    cp.setSize(400, 200);
    cp.add(tree);
    cp.setLayout(new FitLayout());

    new TreePanelDragSource(tree);
    new TreePanelDropTarget(tree);

    add(cp);
  }

  private void createList() {
    ListView<ModelData> view = new ListView<ModelData>();
    view.setBorders(false);
    view.setStore(new ListStore<ModelData>());
    view.setSimpleTemplate("{name}");
    view.setDisplayProperty("name");

    ContentPanel cp = new ContentPanel();
    cp.setHeading("ListView");
    cp.setSize(400, 200);
    cp.add(view);
    cp.setLayout(new FitLayout());

    new ListViewDragSource(view);
    new ListViewDropTarget(view);

    add(cp);
  }

}
