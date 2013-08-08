/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.misc;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FillData;
import com.google.gwt.user.client.Element;

public class CustomSliderExample extends LayoutContainer {
  public CustomSliderExample() {
    setScrollMode(Scroll.AUTO);
  }

  private int margins = 30;

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);

    final Slider slider4 = new Slider();
    slider4.setWidth(214);
    slider4.setMessage("{0}% complete");
    LayoutContainer lc = new LayoutContainer();
    lc.setId("custom-slider");
    lc.add(slider4);

    add(lc, new FillData(margins));

    add(new Button("set value to 40", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        slider4.setValue(40);
      }
    }), new FillData(margins));

  }

}
