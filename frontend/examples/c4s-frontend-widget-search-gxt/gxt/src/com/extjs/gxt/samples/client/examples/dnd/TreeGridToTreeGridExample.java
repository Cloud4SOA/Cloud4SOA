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
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.dnd.TreeGridDragSource;
import com.extjs.gxt.ui.client.dnd.TreeGridDropTarget;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.user.client.Element;

public class TreeGridToTreeGridExample extends LayoutContainer {

  private TreeGridDropTarget target;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);

    Folder model = TestData.getTreeModel();

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    store.add(model.getChildren(), true);

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(false);
    cp.setFrame(true);
    cp.setHeading("TreeGrid to TreeGrid Example");
    cp.setButtonAlign(HorizontalAlignment.CENTER);

    VBoxLayout layout = new VBoxLayout();
    layout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
    cp.setLayout(layout);
    cp.setSize(500, 500);

    ToolBar toolBar = new ToolBar();
    toolBar.setBorders(true);
    toolBar.add(new LabelToolItem("Feedback: "));
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
    type.setTriggerAction(TriggerAction.ALL);
    type.setEditable(false);
    type.setWidth(100);
    type.add("Append");
    type.add("Insert");
    type.setSimpleValue("Append");
    type.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        boolean append = type.getSimpleValue().equals("Append");
        Feedback f = append ? Feedback.APPEND : Feedback.INSERT;
        target.setFeedback(f);
      }
    });
    toolBar.add(type);
    toolBar.add(new SeparatorToolItem());
    cp.setTopComponent(toolBar);

    TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, createColumnModel());
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);

    new TreeGridDragSource(tree);

    VBoxLayoutData data = new VBoxLayoutData(6, 0, 6, 0);
    data.setFlex(10);
    cp.add(tree, data);

    Folder f = new Folder("My Music");
    TreeStore<ModelData> dropStore = new TreeStore<ModelData>();
    dropStore.add(f, false);

    tree = new TreeGrid<ModelData>(dropStore, createColumnModel()) {
      @Override
      protected boolean hasChildren(ModelData m) {
        if ("My Music".equals(m.get("name")) || m instanceof Folder) {
          return true;
        }
        return super.hasChildren(m);
      }
    };
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);

    target = new TreeGridDropTarget(tree);

    data = new VBoxLayoutData();
    data.setFlex(10);
    cp.add(tree, data);
    vp.add(cp);

    add(vp);

  }

  private ColumnModel createColumnModel() {
    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    name.setRenderer(new TreeGridCellRenderer<ModelData>());

    ColumnConfig date = new ColumnConfig("author", "Author", 100);
    ColumnConfig size = new ColumnConfig("genre", "Genre", 100);
    ColumnModel cm = new ColumnModel(Arrays.asList(name, date, size));
    return cm;
  }
}
