/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.dnd;

import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.ExamplesModel;
import com.extjs.gxt.samples.client.examples.model.Category;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.dnd.TreePanelDragSource;
import com.extjs.gxt.ui.client.dnd.TreePanelDropTarget;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.event.DNDListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;

public class TreePanelToTreePanelExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    StoreSorter<ModelData> sorter = new StoreSorter<ModelData>() {

      @Override
      public int compare(Store<ModelData> store, ModelData m1, ModelData m2, String property) {
        boolean m1Folder = m1 instanceof Category;
        boolean m2Folder = m2 instanceof Category;
        if (m1Folder && !m2Folder) {
          return -1;
        } else if (!m1Folder && m2Folder) {
          return 1;
        }
        String s1 = m1.get("name");
        String s2 = m2.get("name");
        return s1.compareTo(s2);
      }
    };

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    store.setStoreSorter(sorter);
    final TreeModel root = (ExamplesModel) Registry.get(Examples.MODEL);
    root.set("name", "Ext GWT");

    store.add(root, true);

    TreePanel<ModelData> tree = new TreePanel<ModelData>(store){
      @Override
      protected boolean hasChildren(ModelData m) {
        if ("Ext GWT".equals(m.get("name")) || m instanceof Category) {
          return true;
        }
        return super.hasChildren(m);
      }
    };
    tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-list"));
    tree.setAutoLoad(true);
    tree.setDisplayProperty("name");

    tree.addListener(Events.Render, new Listener<TreePanelEvent<ModelData>>() {
      public void handleEvent(TreePanelEvent<ModelData> be) {
        be.getTreePanel().setExpanded(root, true);
      }
    });

    BaseTreeModel root2 = new BaseTreeModel();
    root2.set("name", "My Files");

    store = new TreeStore<ModelData>();
    store.setStoreSorter(sorter);
    store.add(root2, false);

    TreePanel<ModelData> tree2 = new TreePanel<ModelData>(store) {
      @Override
      protected boolean hasChildren(ModelData m) {
        if ("My Files".equals(m.get("name")) || m instanceof Category) {
          return true;
        }
        return super.hasChildren(m);
      }
    };

    tree2.getStyle().setLeafIcon(IconHelper.createStyle("icon-list"));
    tree2.setAutoLoad(true);
    tree2.setDisplayProperty("name");

    HorizontalPanel hp = new HorizontalPanel();
    hp.setSpacing(10);

    hp.add(tree, new TableData("250px", null));
    hp.add(tree2, new TableData("250px", null));

    DNDListener listener = new DNDListener() {
      @SuppressWarnings({"unchecked", "rawtypes"})
      @Override
      public void dragStart(DNDEvent e) {
        TreePanel tree = ((TreePanel) e.getComponent());
        ModelData sel = tree.getSelectionModel().getSelectedItem();
        if (sel != null && tree.getStore().getParent(sel) == null) {
          e.setCancelled(true);
          e.getStatus().setStatus(false);
          return;
        }
        super.dragStart(e);
      }
    };

    TreePanelDragSource source = new TreePanelDragSource(tree);
    source.addDNDListener(listener);
    TreePanelDragSource source2 = new TreePanelDragSource(tree2);
    source2.addDNDListener(listener);

    new TreePanelDropTarget(tree);
    new TreePanelDropTarget(tree2);

    add(hp);

  }

}
