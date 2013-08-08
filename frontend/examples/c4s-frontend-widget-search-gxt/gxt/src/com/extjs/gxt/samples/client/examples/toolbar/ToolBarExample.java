/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.toolbar;

import java.util.List;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.custom.ThemeSelector;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.menu.AdapterMenuItem;
import com.extjs.gxt.ui.client.widget.menu.CheckMenuItem;
import com.extjs.gxt.ui.client.widget.menu.DateMenu;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;

public class ToolBarExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    setLayout(new FlowLayout(10));

    ToolBar toolBar = new ToolBar();

    Button item1 = new Button("Button w/ Menu");
    item1.setIcon(Resources.ICONS.menu_show());

    List<Stock> list = TestData.getStocks();
    final ListStore<Stock> store = new ListStore<Stock>();
    store.add(list);

    final ComboBox<Stock> combo = new ComboBox<Stock>();
    combo.setFieldLabel("Company");
    combo.setDisplayField("name");
    combo.setName("name");
    combo.setValueField("symbol");
    combo.setForceSelection(true);
    combo.setStore(store);
    combo.setTriggerAction(TriggerAction.ALL);

    AdapterMenuItem adapter = new AdapterMenuItem(combo);
    adapter.setManageFocus(true);
    adapter.setCanActivate(true);
    
    Menu menu = new Menu();
    menu.add(adapter);

    CheckMenuItem menuItem = new CheckMenuItem("I Like Cats");
    menuItem.setChecked(true);
    menu.add(menuItem);

    menuItem = new CheckMenuItem("I Like Dogs");
    menu.add(menuItem);
    item1.setMenu(menu);

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

    toolBar.add(item1);

    toolBar.add(new SeparatorToolItem());

    SplitButton splitItem = new SplitButton("Split Button");
    splitItem.setIcon(Resources.ICONS.list_items());

    menu = new Menu();
    menu.add(new MenuItem("<b>Bold</b>"));
    menu.add(new MenuItem("<i>Italic</i>"));
    menu.add(new MenuItem("<u>Underline</u>"));
    splitItem.setMenu(menu);

    toolBar.add(splitItem);

    toolBar.add(new SeparatorToolItem());

    ToggleButton toggle = new ToggleButton("Toggle");
    toggle.toggle(true);
    toolBar.add(toggle);

    toolBar.add(new SeparatorToolItem());

    Button scrollerButton = new Button("Scrolling Menu");

    Menu scrollMenu = new Menu();
    scrollMenu.setMaxHeight(200);
    for (int i = 0; i < 40; i++) {
      scrollMenu.add(new MenuItem("Item " + i));
    }

    scrollerButton.setMenu(scrollMenu);

    toolBar.add(scrollerButton);

    toolBar.add(new SeparatorToolItem());

    toolBar.add(new FillToolItem());
    ThemeSelector selector = new ThemeSelector();
    toolBar.add(selector);

    ContentPanel panel = new ContentPanel();
    panel.setCollapsible(true);
    panel.setFrame(true);
    panel.setHeading("ToolBar & Menu Demo");
    panel.setLayout(new FitLayout());
    panel.setSize(GXT.isAriaEnabled() ? 800 : 550, 300);
    panel.setTopComponent(toolBar);

    LayoutContainer c = new LayoutContainer();
    c.setStyleAttribute("backgroundColor", "white");
    c.setBorders(true);
    panel.add(c);

    add(panel);
  }

}
