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
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;

public class ContextMenuTreePanelExample extends LayoutContainer {
  private int count = 1;

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);

    final Folder model = TestData.getTreeModel();

    final TreeStore<ModelData> store = new TreeStore<ModelData>();
    store.add(model.getChildren(), true);

    add(new Button("Reset", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        store.removeAll();
        store.add(model.getChildren(), true);
      }
    }),new FlowData(10));

    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
    tree.setDisplayProperty("name");
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setWidth(260);

    Menu contextMenu = new Menu();

    MenuItem insert = new MenuItem();
    insert.setText("Insert Item");
    insert.setIcon(Resources.ICONS.add());
    insert.addSelectionListener(new SelectionListener<MenuEvent>() {
      public void componentSelected(MenuEvent ce) {
        ModelData folder = tree.getSelectionModel().getSelectedItem();
        if (folder != null) {
          Folder child = new Folder("Add Child " + count++);
          store.add(folder, child, false);
          tree.setExpanded(folder, true);
        }
      }
    });
    contextMenu.add(insert);

    MenuItem remove = new MenuItem();
    remove.setText("Remove Selected");
    remove.setIcon(Resources.ICONS.delete());
    remove.addSelectionListener(new SelectionListener<MenuEvent>() {
      public void componentSelected(MenuEvent ce) {
        List<ModelData> selected = tree.getSelectionModel().getSelectedItems();
        for (ModelData sel : selected) {
          store.remove(sel);
        }
      }
    });
    contextMenu.add(remove);

    tree.setContextMenu(contextMenu);

    setLayout(new FlowLayout(8));
    add(tree);

  }
}
