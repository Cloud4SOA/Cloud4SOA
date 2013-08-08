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
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treegrid.CellTreeGridSelectionModel;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridSelectionModel;
import com.google.gwt.user.client.Element;

public class TreeGridExample extends LayoutContainer {

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
    cp.setHeading("TreeGrid");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setFrame(true);
    cp.setSize(600, 300);

    final TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm);
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);
    tree.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
    cp.add(tree);

    ToolBar toolBar = new ToolBar();
    toolBar.getAriaSupport().setLabel("TreeGrid Options");
    toolBar.setBorders(true);
    toolBar.add(new LabelToolItem("Selection Mode: "));
    
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
    type.getAriaSupport().setLabelledBy(toolBar.getItem(0).getId());
    type.setTriggerAction(TriggerAction.ALL);
    type.setEditable(false);
    type.setFireChangeEventOnSetValue(true);
    type.setWidth(100);
    type.add("Row");
    type.add("Cell");
    type.setSimpleValue("Row");
    type.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        boolean cell = type.getSimpleValue().equals("Cell");
        tree.getSelectionModel().deselectAll();
        if (cell) {
          tree.setSelectionModel(new CellTreeGridSelectionModel<ModelData>());
        } else {
          tree.setSelectionModel(new TreeGridSelectionModel<ModelData>());
        }
      }
    });
    toolBar.add(type);

    cp.setTopComponent(toolBar);

    add(cp);
  }
}
