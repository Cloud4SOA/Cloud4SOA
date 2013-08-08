/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.windows;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

public class AccordionWindowExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    setLayout(new FlowLayout(10));

    final Window complex = new Window();
    complex.setMaximizable(true);
    complex.setHeading("Accordion Window");
    complex.setWidth(200);
    complex.setHeight(350);

    ToolBar toolBar = new ToolBar();
    Button item = new Button();
    item.setIcon(Resources.ICONS.connect());
    toolBar.add(item);

    toolBar.add(new SeparatorToolItem());
    complex.setTopComponent(toolBar);

    item = new Button();
    item.setIcon(Resources.ICONS.user_add());
    toolBar.add(item);

    item = new Button();
    item.setIcon(Resources.ICONS.user_delete());
    toolBar.add(item);

    complex.setIcon(Resources.ICONS.accordion());
    complex.setLayout(new AccordionLayout());

    ContentPanel cp = new ContentPanel();
    cp.setAnimCollapse(false);
    cp.setHeading("Online Users");
    cp.setLayout(new FitLayout());
    cp.getHeader().addTool(new ToolButton("x-tool-refresh"));

    complex.add(cp);

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
    tree.setIconProvider(new ModelIconProvider<ModelData>() {

      public AbstractImagePrototype getIcon(ModelData model) {
        if (model.get("icon") != null) {
          return IconHelper.createStyle((String) model.get("icon"));
        } else {
          return null;
        }
      }

    });
    tree.setDisplayProperty("name");

    ModelData m = newItem("Family", null);
    store.add(m, false);
    tree.setExpanded(m, true);

    store.add(m, newItem("Darrell", "user"), false);
    store.add(m, newItem("Maro", "user-girl"), false);
    store.add(m, newItem("Lia", "user-kid"), false);
    store.add(m, newItem("Alec", "user-kid"), false);
    store.add(m, newItem("Andrew", "user-kid"), false);

    m = newItem("Friends", null);
    store.add(m, false);
    tree.setExpanded(m, true);
    store.add(m, newItem("Bob", "user"), false);
    store.add(m, newItem("Mary", "user-girl"), false);
    store.add(m, newItem("Sally", "user-girl"), false);
    store.add(m, newItem("Jack", "user"), false);

    cp.add(tree);

    cp = new ContentPanel();
    cp.setAnimCollapse(false);
    cp.setHeading("Settings");
    cp.setBodyStyleName("pad-text");
    cp.addText(TestData.DUMMY_TEXT_SHORT);
    complex.add(cp);

    cp = new ContentPanel();
    cp.setAnimCollapse(false);
    cp.setHeading("Stuff");
    cp.setBodyStyleName("pad-text");
    cp.addText(TestData.DUMMY_TEXT_SHORT);
    complex.add(cp);

    cp = new ContentPanel();
    cp.setAnimCollapse(false);
    cp.setHeading("More Stuff");
    cp.setBodyStyleName("pad-text");
    cp.addText(TestData.DUMMY_TEXT_SHORT);
    complex.add(cp);

    add(new Button("Open", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        complex.show();
      }
    }));
  }

  private ModelData newItem(String text, String iconStyle) {
    ModelData m = new BaseModelData();
    m.set("name", text);
    m.set("icon", iconStyle);
    return m;
  }

}
