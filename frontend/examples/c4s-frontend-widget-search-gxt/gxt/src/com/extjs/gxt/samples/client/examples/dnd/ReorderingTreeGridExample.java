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
import com.extjs.gxt.ui.client.dnd.TreeGridDragSource;
import com.extjs.gxt.ui.client.dnd.TreeGridDropTarget;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
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
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.user.client.Element;

public class ReorderingTreeGridExample extends LayoutContainer {

  private TreeGridDropTarget target;

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
    cp.setFrame(true);
    cp.setHeading("Reordering TreeGrid Example");
    cp.setButtonAlign(HorizontalAlignment.CENTER);

    cp.setLayout(new FitLayout());
    cp.setSize(500, 350);

    ToolBar toolBar = new ToolBar();
    toolBar.setBorders(true);
    toolBar.add(new LabelToolItem("Feedback: "));
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
    type.setTriggerAction(TriggerAction.ALL);
    type.setEditable(false);
    type.setWidth(100);
    type.add("Both");
    type.add("Append");
    type.add("Insert");
    type.setSimpleValue("Both");
    type.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        String v = type.getSimpleValue();
        if ("Both".equals(v)) {
          target.setFeedback(Feedback.BOTH);
        } else if ("Append".equals(v)) {
          target.setFeedback(Feedback.APPEND);
        } else {
          target.setFeedback(Feedback.INSERT);
        }
      }
    });
    toolBar.add(type);
    toolBar.add(new SeparatorToolItem());
    cp.setTopComponent(toolBar);

    TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm) {
      @Override
      protected boolean hasChildren(ModelData m) {
        if (m instanceof Folder) {
          return true;
        }
        return super.hasChildren(m);
      }
    };
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);

    new TreeGridDragSource(tree);

    target = new TreeGridDropTarget(tree);
    target.setAllowSelfAsSource(true);
    target.setFeedback(Feedback.BOTH);

    cp.add(tree);

    add(cp);
  }
}
