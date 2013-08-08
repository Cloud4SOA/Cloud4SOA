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
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.dnd.TreePanelDragSource;
import com.extjs.gxt.ui.client.dnd.TreePanelDropTarget;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.event.DNDListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;

public class ReorderingTreePanelExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));

    LayoutContainer container = new LayoutContainer();
    container.setSize(290, 400);
    container.setBorders(true);
    container.setLayout(new FitLayout());

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    final TreeModel root = (ExamplesModel) Registry.get(Examples.MODEL);
    root.set("name", "Ext GWT");
    store.add(root, true);

    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store) {
      @Override
      public boolean hasChildren(ModelData m) {
        if ("My Files".equals(m.get("name")) ||m instanceof Category) {
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

    TreePanelDragSource source = new TreePanelDragSource(tree);
    source.addDNDListener(new DNDListener() {
      @Override
      public void dragStart(DNDEvent e) {
        ModelData sel = tree.getSelectionModel().getSelectedItem();
        if (sel != null && sel == tree.getStore().getRootItems().get(0)) {
          e.setCancelled(true);
          e.getStatus().setStatus(false);
          return;
        }
        super.dragStart(e);
      }
    });

    TreePanelDropTarget target = new TreePanelDropTarget(tree);
    target.setAllowSelfAsSource(true);
    target.setFeedback(Feedback.BOTH);
    target.setScrollElementId(container.getId());

    container.add(tree);
    add(container);
  }
}
