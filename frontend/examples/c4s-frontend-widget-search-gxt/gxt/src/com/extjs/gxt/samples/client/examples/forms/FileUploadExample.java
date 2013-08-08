/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.forms;

import java.util.List;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.google.gwt.user.client.Element;

public class FileUploadExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("margin", "10px");

    final FormPanel panel = new FormPanel();
    panel.setHeading("File Upload Example");
    panel.setFrame(true);
    panel.setAction("myurl");
    panel.setEncoding(Encoding.MULTIPART);
    panel.setMethod(Method.POST);
    panel.setButtonAlign(HorizontalAlignment.CENTER);
    panel.setWidth(350);

    TextField<String> name = new TextField<String>();
    name.setFieldLabel("Name");
    panel.add(name);

    FileUploadField file = new FileUploadField();
    file.setAllowBlank(false);
    file.setName("uploadedfile");
    file.setFieldLabel("File");
    panel.add(file);

    List<Stock> list = TestData.getStocks();
    final ListStore<Stock> store = new ListStore<Stock>();
    store.add(list);

    final ComboBox<Stock> combo = new ComboBox<Stock>();
    combo.setFieldLabel("Company");
    combo.setDisplayField("name");
    combo.setName("name");
    combo.setValueField("symbol");
    combo.setForceSelection(true);
    combo.setStore(store);
    combo.setTriggerAction(TriggerAction.ALL);
    panel.add(combo);

    Button btn = new Button("Reset");
    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        panel.reset();
      }
    });
    panel.addButton(btn);

    btn = new Button("Submit");
    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        if (!panel.isValid()) {
          return;
        }
        // normally would submit the form but for example no server set up to
        // handle the post
        // panel.submit();
        MessageBox.info("Action", "You file was uploaded", null);
      }
    });
    panel.addButton(btn);

    add(panel);
  }

}
