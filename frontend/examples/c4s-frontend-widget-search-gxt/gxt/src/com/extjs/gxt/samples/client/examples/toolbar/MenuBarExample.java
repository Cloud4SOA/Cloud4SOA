/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.toolbar;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.menu.CheckMenuItem;
import com.extjs.gxt.ui.client.widget.menu.DateMenu;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.google.gwt.user.client.Element;

public class MenuBarExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    Menu menu = new Menu();

    MenuItem item1 = new MenuItem("New");
    menu.add(item1);

    MenuItem item2 = new MenuItem("Open File");
    menu.add(item2);

    Menu sub = new Menu();
    sub.add(new MenuItem("readme.txt"));
    sub.add(new MenuItem("helloworld.txt"));
    item2.setSubMenu(sub);

    MenuBar bar = new MenuBar();
    bar.setBorders(true);
    bar.setStyleAttribute("borderTop", "none");
    bar.add(new MenuBarItem("File", menu));

    Menu sub2 = new Menu();
    sub2.add(new MenuItem("Cut"));
    sub2.add(new MenuItem("Copy"));

    MenuBarItem edit = new MenuBarItem("Edit", sub2);
    bar.add(edit);

    sub = new Menu();
    sub.add(new MenuItem("Search"));
    sub.add(new MenuItem("File"));
    sub.add(new MenuItem("Java"));

    MenuBarItem item3 = new MenuBarItem("Search", sub);
    bar.add(item3);
    
    menu = new Menu();

    CheckMenuItem menuItem = new CheckMenuItem("I Like Cats");
    menuItem.setChecked(true);
    menu.add(menuItem);

    menuItem = new CheckMenuItem("I Like Dogs");
    menu.add(menuItem);


    menu.add(new SeparatorMenuItem());

    MenuItem radios = new MenuItem("Radio Options");
    menu.add(radios);

    Menu radioMenu = new Menu();
    CheckMenuItem r = new CheckMenuItem("Blue Theme");
    r.setGroup("radios");
    r.setChecked(true);
    radioMenu.add(r);
    r = new CheckMenuItem("Gray Theme");
    r.setGroup("radios");
    radioMenu.add(r);
    radios.setSubMenu(radioMenu);

    MenuItem date = new MenuItem("Choose a Date");
    date.setIcon(Resources.ICONS.calendar());
    menu.add(date);

    date.setSubMenu(new DateMenu());
    
    MenuBarItem item4 = new MenuBarItem("Foo", menu);
    bar.add(item4);

    ContentPanel panel = new ContentPanel();
    panel.setHeading("MenuBar Example");
    panel.setTopComponent(bar);
    panel.setSize(400, 300);

    add(panel, new FlowData(10));
  }

}
