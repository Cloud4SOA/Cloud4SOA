/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.layouts;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.Element;

public class AnchorLayoutExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));

    final Window w = new Window();
    w.setPlain(true);
    w.setSize(500, 300);
    w.setHeading("Resize Me");
    w.setLayout(new FitLayout());

    FormPanel panel = new FormPanel();
    panel.setBorders(false);
    panel.setBodyBorder(false);
    panel.setLabelWidth(55);
    panel.setPadding(5);
    panel.setHeaderVisible(false);

    TextField<String> field = new TextField<String>();
    field.setFieldLabel("Sent To");
    panel.add(field, new FormData("100%"));

    field = new TextField<String>();
    field.setFieldLabel("Subject");
    panel.add(field, new FormData("100%"));

    HtmlEditor html = new HtmlEditor();
    html.setHideLabel(true);
    panel.add(html, new FormData("100% -53"));

    w.addButton(new Button("Send"));
    w.addButton(new Button("Cancel"));
    w.add(panel);

    Button b = new Button("Open", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        w.show();
      }

    });
    add(b);
  }

}
