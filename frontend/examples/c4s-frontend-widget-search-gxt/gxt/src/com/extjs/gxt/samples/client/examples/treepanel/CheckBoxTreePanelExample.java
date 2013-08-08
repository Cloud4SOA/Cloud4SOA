/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treepanel;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.CheckChangedEvent;
import com.extjs.gxt.ui.client.event.CheckChangedListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.CheckCascade;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.CheckNodes;
import com.google.gwt.user.client.Element;

public class CheckBoxTreePanelExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    Folder model = TestData.getTreeModel();

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    store.add(model.getChildren(), true);

    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
    tree.setDisplayProperty("name");
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setWidth(300);
    tree.setCheckable(true);
    tree.setAutoLoad(true);

    // overall checked state changes
    tree.addCheckListener(new CheckChangedListener<ModelData>() {
      @Override
      public void checkChanged(CheckChangedEvent<ModelData> event) {

      }
    });

    // change in node check state
    tree.addListener(Events.CheckChange, new Listener<TreePanelEvent<ModelData>>() {
      public void handleEvent(TreePanelEvent<ModelData> be) {

      }
    });

    final SimpleComboBox<String> cascade = new SimpleComboBox<String>();
    cascade.setTriggerAction(TriggerAction.ALL);
    cascade.setEditable(false);
    cascade.add("Parent");
    cascade.add("Children");
    cascade.add("None");
    cascade.setSimpleValue("Parent");
    cascade.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        String val = cascade.getSimpleValue();
        if ("Parent".equals(val)) {
          tree.setCheckStyle(CheckCascade.PARENTS);
        } else if ("Children".equals(val)) {
          tree.setCheckStyle(CheckCascade.CHILDREN);
        } else {
          tree.setCheckStyle(CheckCascade.NONE);
        }
      }
    });
    
    final SimpleComboBox<String> checkNodes = new SimpleComboBox<String>();
    checkNodes.setTriggerAction(TriggerAction.ALL);
    checkNodes.setEditable(false);
    checkNodes.add("Both");
    checkNodes.add("Leaf");
    checkNodes.add("Parent");
    checkNodes.setSimpleValue("Both");
    checkNodes.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        String val = checkNodes.getSimpleValue();
        if ("Parent".equals(val)) {
          tree.setCheckNodes(CheckNodes.PARENT);
        } else if ("Leaf".equals(val)) {
          tree.setCheckNodes(CheckNodes.LEAF);
        } else {
          tree.setCheckNodes(CheckNodes.BOTH);
        }
      }
    });

    ToolBar toolBar = new ToolBar();
    toolBar.setBorders(true);

    toolBar.add(new Button("Get Checked", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        StringBuffer sb = new StringBuffer();
        for (ModelData item : tree.getCheckedSelection()) {
          sb.append(", " + (String) item.get("name"));
        }
        String s = sb.toString();
        if (s.length() > 1) s = s.substring(2);
        
       
        Info.display("Checked Items",  Format.ellipse(s, 100), "");
      }
    }));
    toolBar.add(new SeparatorToolItem());
    toolBar.add(new LabelToolItem("Cascade Behavior: "));
    toolBar.add(cascade);
    toolBar.add(new SeparatorToolItem());
    toolBar.add(new LabelToolItem("CheckNode Behavior: "));
    toolBar.add(checkNodes);

    add(toolBar, new FlowData(10));
    add(tree, new FlowData(10));
  }
}
