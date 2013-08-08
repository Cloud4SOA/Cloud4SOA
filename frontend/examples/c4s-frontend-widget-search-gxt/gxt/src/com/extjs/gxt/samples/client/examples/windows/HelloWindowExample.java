/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.windows;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.event.WindowListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;

public class HelloWindowExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    setLayout(new FlowLayout(10));

    final Window window = new Window();
    window.setSize(500, 300);
    window.setPlain(true);
    window.setModal(true);
    window.setBlinkModal(true);
    window.setHeading("Hello Window");
    window.setLayout(new FitLayout());
    window.addWindowListener(new WindowListener() {
      @Override
      public void windowHide(WindowEvent we) {
        Button open = we.getWindow().getData("open");
        open.focus();
      }
    });
    
    TabPanel panel = new TabPanel();
    panel.setBorders(false);
    TabItem item1 = new TabItem("Hello World 1");
    item1.addText("Hello...");
    item1.addStyleName("pad-text");

    TabItem item2 = new TabItem("Hello World 2");
    item2.addText("... World!");
    item2.addStyleName("pad-text");
    panel.add(item1);
    panel.add(item2);

    window.add(panel, new FitData(4));
    window.addButton(new Button("Close", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        window.hide();
      }
    }));
    window.setFocusWidget(window.getButtonBar().getItem(0));

    Button btn = new Button("Hello World", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        window.show();
      }
    });
    window.setData("open", btn);
    add(btn);

  }

}
