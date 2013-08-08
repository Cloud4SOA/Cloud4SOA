/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.toolbar;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.Style.ButtonArrowAlign;
import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;

public class AdvancedToolBarExample extends LayoutContainer {

  class SamplePanel extends ContentPanel {

    public SamplePanel() {
      setSize(500, 250);
      setBodyStyle("padding: 6px");
      setScrollMode(Scroll.AUTOY);
      addText(TestData.DUMMY_TEXT_LONG);
    }
  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);

    vp.add(createStandard());
    vp.add(createMulti());
    vp.add(createMulti2());
    vp.add(createMixed());
    add(vp);

  };

  private ContentPanel createStandard() {
    ContentPanel panel = new SamplePanel();
    panel.setHeading("Standard");

    ToolBar toolBar = new ToolBar();

    Button btn = new Button("Cool", IconHelper.createStyle("add16"));
    toolBar.add(btn);
    Menu menu = new Menu();
    menu.add(new MenuItem("Ribbons are cool"));
    btn.setMenu(menu);
    toolBar.add(new SeparatorToolItem());

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    toolBar.add(btn);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    toolBar.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    toolBar.add(btn);
    menu = new Menu();
    menu.add(new MenuItem("Ribbons are cool"));
    btn.setMenu(menu);
    toolBar.add(new SeparatorToolItem());

    ToggleButton toggleBtn = new ToggleButton("Format");
    toggleBtn.toggle(true);
    toolBar.add(toggleBtn);

    panel.setTopComponent(toolBar);

    return panel;
  }

  private ContentPanel createMulti() {
    ContentPanel panel = new SamplePanel();
    panel.setHeading("Multi Columns");

    ToolBar toolBar = new ToolBar();
    panel.setTopComponent(toolBar);

    ButtonGroup group = new ButtonGroup(2);
    group.setHeading("Clipboard");

    Button btn = new Button("Cool", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    Menu menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    group.add(btn);

    toolBar.add(group);

    group = new ButtonGroup(2);
    group.setHeading("Other Bugus Actions");

    btn = new Button("Cool", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    group.add(btn);

    toolBar.add(group);
    return panel;

  }

  private ContentPanel createMulti2() {
    ContentPanel panel = new SamplePanel();
    panel.setHeading("Multi Columns No Titles");

    ToolBar toolBar = new ToolBar();
    panel.setTopComponent(toolBar);

    ButtonGroup group = new ButtonGroup(2);
    group.setHeaderVisible(false);
    Button btn = new Button("Cool", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    Menu menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    group.add(btn);

    toolBar.add(group);

    group = new ButtonGroup(2);
    group.setHeaderVisible(false);

    btn = new Button("Cool", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    group.add(btn);

    toolBar.add(group);
    return panel;
  }

  private ContentPanel createMixed() {
    ContentPanel panel = new SamplePanel();
    panel.setHeading("Mix and match icon sizes");

    ToolBar toolBar = new ToolBar();
    panel.setTopComponent(toolBar);

    ButtonGroup group = new ButtonGroup(3);
    group.setHeading("Clipboard");
    toolBar.add(group);

    Button btn = new Button("Paste", Resources.ICONS.add32());
    btn.addStyleName("x-btn-as-arrow");
    btn.setScale(ButtonScale.LARGE);
    btn.setIconAlign(IconAlign.TOP);
    btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
    TableData data = new TableData();
    data.setRowspan(3);

    group.add(btn, data);

    btn = new Button("Format", Resources.ICONS.add32());
    btn.setScale(ButtonScale.LARGE);
    btn.setIconAlign(IconAlign.TOP);
    btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
    Menu menu = new Menu();
    menu.add(new MenuItem("Cool"));
    btn.setMenu(menu);
    group.add(btn, data);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    group.add(btn);

    group = new ButtonGroup(3);
    group.setHeading("Clipboard");
    toolBar.add(group);

    btn = new Button("Paste", Resources.ICONS.add32());
    btn.addStyleName("x-btn-as-arrow");
    btn.setScale(ButtonScale.LARGE);
    btn.setIconAlign(IconAlign.TOP);
    btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
    data = new TableData();
    data.setRowspan(3);

    group.add(btn, data);

    btn = new Button("Format", Resources.ICONS.add32());
    btn.setScale(ButtonScale.LARGE);
    btn.setIconAlign(IconAlign.TOP);
    btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
    menu = new Menu();
    menu.add(new MenuItem("Cool"));
    btn.setMenu(menu);
    group.add(btn, data);

    btn = new Button("Copy", IconHelper.createStyle("add16"));
    menu = new Menu();
    menu.add(new MenuItem("Copy me"));
    btn.setMenu(menu);
    group.add(btn);

    btn = new Button("Cut", IconHelper.createStyle("add16"));
    group.add(btn);

    btn = new Button("Paste", IconHelper.createStyle("add16"));
    group.add(btn);
    return panel;
  }

}
