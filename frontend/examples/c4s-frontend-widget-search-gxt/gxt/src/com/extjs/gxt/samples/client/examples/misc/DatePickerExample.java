/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.misc;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;
public class DatePickerExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));
    
    final DatePicker picker = new DatePicker();
    picker.addListener(Events.Select, new Listener<ComponentEvent>() {

      public void handleEvent(ComponentEvent be) {
        //String d = DateTimeFormat.getShortDateFormat().format(picker.getValue());
        String d = DateTimeFormat.getFormat("MM/dd/yyyy").format(picker.getValue());
        Info.display("Date Selected", "You selected {0}.", new Params(d));
      }

    });
    add(picker);
  }

}
