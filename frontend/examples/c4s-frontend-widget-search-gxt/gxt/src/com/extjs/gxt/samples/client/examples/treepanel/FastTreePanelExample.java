/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treepanel;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelKeyProvider;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.CheckCascade;
import com.google.gwt.user.client.Element;

public class FastTreePanelExample extends LayoutContainer {
  private int counter = 0;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(12));

    final Html html = new Html("This tree is handling 1 child. Expand to get more!");
    html.setStyleName("pad-text");

    LayoutContainer container = new LayoutContainer();
    container.setSize(300, 350);
    container.setBorders(true);
    container.setLayout(new FitLayout());

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store) {
      @Override
      protected boolean hasChildren(ModelData m) {
        return true;
      }
    };
    tree.setTrackMouseOver(false);
    tree.setCheckable(true);
    tree.setCheckStyle(CheckCascade.CHILDREN);
    tree.setDisplayProperty("name");
    store.setKeyProvider(new ModelKeyProvider<ModelData>() {

      public String getKey(ModelData model) {
        return model.get("id");
      }

    });
    ModelData m = createModel("Fast Tree");
    store.add(m, false);
    tree.addListener(Events.BeforeExpand, new Listener<TreePanelEvent<ModelData>>() {

      public void handleEvent(TreePanelEvent<ModelData> be) {
        if (be.getNode().getItemCount() != 0) {
          return;
        }
        List<ModelData> list = new ArrayList<ModelData>();
        for (int i = 0; i < 500; i++) {
          ModelData m = createModel("Tree Item " + i);
          list.add(m);
        }
        tree.getStore().insert(be.getNode().getModel(), list, 0, true);
      }
    });

    tree.addListener(Events.Expand, new Listener<TreePanelEvent<ModelData>>() {

      public void handleEvent(TreePanelEvent<ModelData> be) {
        html.setHtml("<span>This tree is handling " + tree.getStore().getAllItems().size()
            + " children. Expand to get more!</span>");

      }

    });

    add(html);
    container.add(tree);
    add(container);
    tree.getSelectionModel().select(store.getRootItems(), true);
  }

  private ModelData createModel(String n) {
    ModelData m = new BaseModelData();
    m.set("name", n);
    m.set("id", String.valueOf(counter++));
    return m;
  }

}
