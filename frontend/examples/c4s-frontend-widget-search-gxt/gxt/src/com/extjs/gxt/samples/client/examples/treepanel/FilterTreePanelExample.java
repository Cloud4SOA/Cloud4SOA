/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treepanel;

import java.util.List;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class FilterTreePanelExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    TreeLoader<ModelData> loader = new BaseTreeLoader<ModelData>(
        new TreeModelReader<List<ModelData>>());

    TreeStore<ModelData> store = new TreeStore<ModelData>(loader);

    TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
    tree.setAutoLoad(true);
    tree.setDisplayProperty("name");
    tree.setWidth(250);
    tree.setIconProvider(new ModelIconProvider<ModelData>() {
      public AbstractImagePrototype getIcon(ModelData model) {
        if (((TreeModel) model).isLeaf()) {
          return Resources.ICONS.music();
        }
        return null;
      }
    });

    loader.load(TestData.getTreeModel());

    StoreFilterField<ModelData> filter = new StoreFilterField<ModelData>() {

      @Override
      protected boolean doSelect(Store<ModelData> store, ModelData parent,
          ModelData record, String property, String filter) {
        // only match leaf nodes
        if (record instanceof Folder) {
          return false;
        }
        String name = record.get("name");
        name = name.toLowerCase();
        if (name.startsWith(filter.toLowerCase())) {
          return true;
        }
        return false;
      }

    };
    filter.bind(store);

    VerticalPanel panel = new VerticalPanel();
    panel.addStyleName("x-small-editor");
    panel.setSpacing(8);

    panel.add(new Html("<span class=text>Enter a search string such as 'vio'</span>"));
    panel.add(filter);
    panel.add(tree);

    add(panel);
  }
}
