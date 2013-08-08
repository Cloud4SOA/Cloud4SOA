/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.toolbar;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;

public class ToolBarOverflowExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    final Window window = new Window();

    window.setHeading("Overflow Example");
    window.setSize(400, 200);
    window.setMinWidth(50);
    window.setFrame(true);

    ToolBar toolBar = new ToolBar();

    ButtonGroup group = new ButtonGroup(2);
    group.setHeading("Clipboard");

    Button btn = new Button("Cool", Resources.ICONS.add16());
    group.add(btn);

    btn = new Button("Cut", Resources.ICONS.add16());
    Menu menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Copy", Resources.ICONS.add16());
    group.add(btn);

    btn = new Button("Paste", Resources.ICONS.add16());
    group.add(btn);

    toolBar.add(group);

    toolBar.add(new FillToolItem());

    group = new ButtonGroup(2);
    group.setHeading("Other Bugus Actions");

    btn = new Button("Cool", Resources.ICONS.add16());
    group.add(btn);

    btn = new Button("Cut", Resources.ICONS.add16());
    menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Copy", Resources.ICONS.add16());
    group.add(btn);

    btn = new Button("Paste", Resources.ICONS.add16());
    group.add(btn);

    toolBar.add(group);

    window.setTopComponent(toolBar);
    window.setButtonAlign(HorizontalAlignment.CENTER);
    window.addButton(new Button("Save"));
    window.addButton(new Button("Cancel"));
    window.addButton(new Button("Close"));
    window.addButton(new Button("Highlight"));
    window.addButton(new Button("Shutdown"));
    add(new Button("ToolBar Overflow Example", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        window.show();
      }

    }), new FlowData(10));
  }
}
