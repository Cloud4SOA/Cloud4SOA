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
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.google.gwt.user.client.Element;

public class DialogExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);

    final Dialog simple = new Dialog();
    simple.setHeading("Dialog Test");
    simple.setButtons(Dialog.YESNO);
    simple.setBodyStyleName("pad-text");
    simple.addText(TestData.DUMMY_TEXT_SHORT);
    simple.getItem(0).getFocusSupport().setIgnore(true);
    simple.setScrollMode(Scroll.AUTO);
    simple.setHideOnButtonClick(true);

    final Dialog complex = new Dialog();
    complex.setBodyBorder(false);
    complex.setIcon(Resources.ICONS.side_list());
    complex.setHeading("BorderLayout Dialog");
    complex.setWidth(400);
    complex.setHeight(225);
    complex.setHideOnButtonClick(true);

    BorderLayout layout = new BorderLayout();
    complex.setLayout(layout);

    // west
    ContentPanel panel = new ContentPanel();
    panel.setHeading("West");
    BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 150, 100, 250);
    data.setMargins(new Margins(0, 5, 0, 0));
    data.setSplit(true);
    data.setCollapsible(true);
    complex.add(panel, data);

    // center
    panel = new ContentPanel();
    panel.setHeading("Center");
    data = new BorderLayoutData(LayoutRegion.CENTER);
    complex.add(panel, data);

    ButtonBar buttons = new ButtonBar();

    buttons.add(new Button("Simple", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        simple.show();
      }
    }));

    buttons.add(new Button("Layout", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        complex.show();
      }
    }));

    add(buttons, new FlowData(10));
  }
}
