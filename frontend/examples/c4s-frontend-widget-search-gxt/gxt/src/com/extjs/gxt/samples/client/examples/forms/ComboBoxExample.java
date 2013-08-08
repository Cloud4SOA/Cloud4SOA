/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.forms;

import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Country;
import com.extjs.gxt.samples.resources.client.model.State;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.google.gwt.user.client.Element;

public class ComboBoxExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);

    ListStore<State> states = new ListStore<State>();
    states.add(TestData.getStates());

    ComboBox<State> combo = new ComboBox<State>();
    combo.setEmptyText("Select a state...");
    combo.setDisplayField("name");
    combo.setWidth(150);
    combo.setStore(states);
    combo.setTypeAhead(true);
    combo.setTriggerAction(TriggerAction.ALL);
    vp.add(combo);

    states = new ListStore<State>();
    states.add(TestData.getStates());
    combo = new ComboBox<State>();
    combo.setEmptyText("Select a state...");
    combo.setDisplayField("name");
    combo.setTemplate(getTemplate());
    combo.setWidth(150);
    combo.setStore(states);
    combo.setTypeAhead(true);
    combo.setTriggerAction(TriggerAction.ALL);
    vp.add(combo);

    ListStore<Country> countries = new ListStore<Country>();
    countries.add(TestData.getCountries());

    ComboBox<Country> combo2 = new ComboBox<Country>();
    combo2.setWidth(150);
    combo2.setStore(countries);
    combo2.setTemplate(getFlagTemplate(Examples.isExplorer() ? "" : "../../"));
    combo2.setDisplayField("name");
    combo2.setTypeAhead(true);
    combo2.setTriggerAction(TriggerAction.ALL);

    vp.add(combo2);
    add(vp);
  }

  private native String getTemplate() /*-{
    return  [
    '<tpl for=".">',
    '<div class="x-combo-list-item" qtip="{slogan}" qtitle="State Slogan">{name}</div>',
    '</tpl>'
    ].join("");
  }-*/;

  private native String getFlagTemplate(String base) /*-{
    return  [
    '<tpl for=".">',
    '<div class="x-combo-list-item"><img width="16px" height="11px" src="' + base + 'samples/images/icons/fam/flags/{[values.abbr]}.png">&nbsp;{[values.name]}</div>',
    '</tpl>'
    ].join("");
  }-*/;

}
