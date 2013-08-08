/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.button;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.google.gwt.user.client.Element;

public class ButtonAlignExample extends LayoutContainer {
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    SelectionListener<ButtonEvent> l = new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        Info.display("Click", ce.getButton().getText() + " clicked");

      }

    };
    int i = 1;
    for (HorizontalAlignment align : HorizontalAlignment.values()) {
      ContentPanel cp = new ContentPanel();
      cp.setHeading("ButtonAligning Example: " + align.name().toLowerCase());
      for (int j = 0; j < 3; i++, j++) {
        cp.addButton(new Button("Button " + i, l));
      }
      cp.setButtonAlign(align);
      cp.setFrame(true);
      cp.setSize(500, 150);
      cp.setLayout(new FitLayout());
      LayoutContainer c = new LayoutContainer();
      c.setStyleAttribute("backgroundColor", "white");
      c.setBorders(true);
      cp.add(c);
      add(cp, new FlowData(10));
    }
  }
}
