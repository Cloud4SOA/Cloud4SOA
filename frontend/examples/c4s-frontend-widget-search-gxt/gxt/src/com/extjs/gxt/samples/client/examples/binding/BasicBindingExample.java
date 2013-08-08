/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.binding;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.binding.SimpleComboBoxFieldBinding;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeListener;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTML;

public class BasicBindingExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    El.fly(parent).addStyleName("binding-example");

    final Stock stock = TestData.getStocks().get(0);

    HorizontalPanel hp = new HorizontalPanel();
    hp.setSpacing(10);

    StringBuffer sb = new StringBuffer();
    sb.append("<div class=text style='line-height: 1.5em'>");
    sb.append("<b>Name:</b> {name}<br>");
    sb.append("<b>Symbol:</b> {symbol}<br>");
    sb.append("<b>Last:</b> {last}<br>");
    sb.append("<b>Change:</b> {[new Number(values.change).toFixed(2)]}<br>");
    sb.append("<b>Updated:</b> {date:date(\"MM/dd/y\")}<br>");
    sb.append("</div>");

    final XTemplate template = XTemplate.create(sb.toString());
    final HTML html = new HTML();
    html.setWidth("160px");
   
    template.overwrite(html.getElement(), Util.getJsObject(stock));
    hp.add(html);
    // update template when model changes
    stock.addChangeListener(new ChangeListener() {
      public void modelChanged(ChangeEvent event) {
        template.overwrite(html.getElement(), Util.getJsObject(stock));
      }
    });

    FormPanel panel = new FormPanel();
    panel.setHeaderVisible(false);
    panel.setWidth(350);

    TextField<String> name = new TextField<String>();
    name.setName("nameField");
    name.setFieldLabel("Name");
    panel.add(name);

    TextField<String> symbol = new TextField<String>();
    symbol.setName("symbol");
    symbol.setFieldLabel("Symbol");
    panel.add(symbol);

    NumberField open = new NumberField();
    open.setName("last");
    open.setFieldLabel("Last");
    panel.add(open);

    NumberField change = new NumberField();
    change.setName("change");
    change.setFieldLabel("Change");
    change.setFormat(NumberFormat.getDecimalFormat());
    panel.add(change);

    DateField last = new DateField();
    last.setName("date");
    last.setFieldLabel("Updated");
    panel.add(last);
    
    SimpleComboBox<String> scb = new SimpleComboBox<String>();
    for(Stock s: TestData.getStocks()) {
      scb.add(s.getName());
    }
    scb.setFieldLabel("Name");
    scb.setForceSelection(true);
    scb.setTypeAhead(true);
    scb.setName("company");
    scb.setTriggerAction(TriggerAction.ALL);
    panel.add(scb);
    
    hp.add(panel);

    FormBinding binding = new FormBinding(panel);
    // manually add bindings
    binding.addFieldBinding(new FieldBinding(name, "name"));
    binding.addFieldBinding(new FieldBinding(symbol, "symbol"));
    binding.addFieldBinding(new SimpleComboBoxFieldBinding(scb, "name"));

    // auto bind remaining fields, field name must match model property name
    binding.autoBind();
    binding.bind(stock);

    add(hp);
  }

}
