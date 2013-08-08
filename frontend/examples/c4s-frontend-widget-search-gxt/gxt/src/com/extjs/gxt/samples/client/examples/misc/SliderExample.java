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

public class SliderExample extends LayoutContainer {

  private int margins = 30;

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    setScrollMode(Scroll.AUTO);
    final Slider slider = new Slider();
    slider.setWidth(200);
    slider.setIncrement(1);
    slider.setMaxValue(200);
    slider.setClickToChange(false);
    add(slider, new FillData(margins));

    add(new Button("set value to 40", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        slider.setValue(40);
      }
    }), new FillData(margins));

    final Slider slider2 = new Slider();
    slider2.setHeight(207);
    slider2.setVertical(true);
    add(slider2, new FillData(margins));

    add(new Button("set value to 40", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        slider2.setValue(40);
      }
    }), new FillData(margins));

  }

}
