/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treegrid;

import java.util.Arrays;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.filters.ListFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.StringFilter;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.extjs.gxt.ui.client.widget.treegrid.filters.TreeGridFilters;
import com.google.gwt.user.client.Element;

public class FilterTreeGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    Folder model = TestData.getTreeModel();

    TreeStore<ModelData> store = new TreeStore<ModelData>();

    store.add(model.getChildren(), true);

    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    name.setRenderer(new TreeGridCellRenderer<ModelData>());

    ColumnConfig date = new ColumnConfig("author", "Author", 100);

    ColumnConfig size = new ColumnConfig("genre", "Genre", 100);

    ColumnModel cm = new ColumnModel(Arrays.asList(name, date, size));

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(false);
    cp.setHeading("Filter TreeGrid");
    cp.setLayout(new FitLayout());
    cp.setFrame(true);
    cp.setSize(600, 300);

    TreeGridFilters filters = new TreeGridFilters();

    StringFilter nameFilter = new StringFilter("name");

    ListStore<ModelData> authorStore = new ListStore<ModelData>();
    authorStore.add(type("Beethoven"));
    authorStore.add(type("Brahms"));
    authorStore.add(type("Mozart"));
    ListFilter authorFilter = new ListFilter("author", authorStore);
    authorFilter.setDisplayProperty("type");

    ListStore<ModelData> genreStore = new ListStore<ModelData>();
    genreStore.add(type("Quartets"));
    genreStore.add(type("Sonatas"));
    genreStore.add(type("Concertos"));
    genreStore.add(type("Symphonies"));
    ListFilter genreFilter = new ListFilter("genre", genreStore);
    genreFilter.setDisplayProperty("type");

    filters.addFilter(nameFilter);
    filters.addFilter(genreFilter);
    filters.addFilter(authorFilter);

    TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm);
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);
    tree.addPlugin(filters);

    cp.add(tree);

    add(cp);
  }

  private ModelData type(String type) {
    ModelData model = new BaseModelData();
    model.set("type", type);
    return model;
  }
}
