/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.misc;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.fx.Resizable;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;

public class ResizableExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    setLayout(new FlowLayout());

    for (int i = 0; i < 2; i++) {
      ContentPanel cp = new ContentPanel();
      cp.setHeading("8-Way Resizing " + (i == 1 ? "Dynamic" : ""));
      cp.setIcon(Resources.ICONS.text());
      cp.setBodyStyleName("pad-text");
      cp.addText(TestData.DUMMY_TEXT_SHORT);

      cp.setSize(200, 125);
      cp.setPosition(10, 10  + (i == 1 ? 20 : 0));

      Draggable d = new Draggable(cp);
      if (getParent() instanceof Component) {
        d.setContainer((Component) getParent());
      }
      Resizable r = new Resizable(cp);
      r.setDynamic(i == 1);

      add(cp);
    }
  }

}
