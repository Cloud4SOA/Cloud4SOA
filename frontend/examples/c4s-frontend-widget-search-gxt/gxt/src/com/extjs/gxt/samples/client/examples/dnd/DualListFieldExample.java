/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.dnd;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DualListField;
import com.extjs.gxt.ui.client.widget.form.DualListField.Mode;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.ListField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.Element;

public class DualListFieldExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("margin", "10px");

    FormPanel panel = new FormPanel();
    panel.setFrame(true);
    panel.setHeading("DualListField Example");

    TextField<String> name = new TextField<String>();
    name.setFieldLabel("Name");
    panel.add(name, new FormData("98%"));

    final DualListField<Stock> lists = new DualListField<Stock>();
    lists.setMode(Mode.INSERT);
    lists.setFieldLabel("Stocks");

    ListField<Stock> from = lists.getFromList();
    from.setDisplayField("name");
    ListStore<Stock> store = new ListStore<Stock>();
    store.add(TestData.getShortStocks());
    from.setStore(store);
    ListField<Stock> to = lists.getToList();
    to.setDisplayField("name");
    store = new ListStore<Stock>();
    to.setStore(store);

    panel.add(lists, new FormData("98%"));

    TextField<String> email = new TextField<String>();
    email.setFieldLabel("Email");
    panel.add(email, new FormData("98%"));

    panel.addButton(new Button("Cancel"));
    panel.addButton(new Button("Save"));

    panel.setWidth(550);

    add(panel);

  }

}
