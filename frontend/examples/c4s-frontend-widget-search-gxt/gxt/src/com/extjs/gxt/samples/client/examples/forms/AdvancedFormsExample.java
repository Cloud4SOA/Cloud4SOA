/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.forms;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.aria.FocusManager;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.Element;

public class AdvancedFormsExample extends LayoutContainer {

  private VerticalPanel vp;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    vp = new VerticalPanel();
    vp.setSpacing(10);
    createColumnForm();
    createTabForm();
    add(vp);
  }

  private void createTabForm() {
    FormData formData = new FormData("100%");
    FormPanel panel = new FormPanel();
    panel.setBodyStyleName("example-bg");
    panel.setPadding(0);
    panel.setFrame(false);
    panel.setHeaderVisible(false);
    panel.setBodyBorder(false);
    panel.setButtonAlign(HorizontalAlignment.CENTER);
    panel.setLayout(new FitLayout());

    final TabPanel tabs = new TabPanel();

    TabItem personal = new TabItem();
    personal.setStyleAttribute("padding", "10px");
    personal.setText("Personal Details");
    personal.setLayout(new FormLayout());

    TextField<String> name = new TextField<String>();
    name.setFieldLabel("First Name");
    name.setValue("Darrell");
    personal.add(name, formData);

    TextField<String> last = new TextField<String>();
    last.setFieldLabel("Last Name");
    last.setValue("Meyer");
    personal.add(last, formData);

    TextField<String> company = new TextField<String>();
    company.setFieldLabel("Company");
    personal.add(company, formData);

    TextField<String> email = new TextField<String>();
    email.setFieldLabel("Email");
    personal.add(email, formData);

    tabs.add(personal);

    TabItem numbers = new TabItem();
    numbers.setStyleAttribute("padding", "10px");
    numbers.setText("Phone Numbers");
    numbers.setLayout(new FormLayout());

    TextField<String> home = new TextField<String>();
    home.setFieldLabel("Home");
    home.setValue("800-555-1212");
    numbers.add(home, formData);

    TextField<String> business = new TextField<String>();
    business.setFieldLabel("Business");
    numbers.add(business, formData);

    TextField<String> mobile = new TextField<String>();
    mobile.setFieldLabel("Mobile");
    numbers.add(mobile, formData);

    TextField<String> fax = new TextField<String>();
    fax.setFieldLabel("Fax");
    numbers.add(fax, formData);

    tabs.add(numbers);

    panel.add(tabs);
    panel.addButton(new Button("Cancel"));
    panel.addButton(new Button("Submit"));

    panel.setSize(340, 200);

    if (GXT.isFocusManagerEnabled()) {
      name.getFocusSupport().setPreviousId(panel.getButtonBar().getId());
      home.getFocusSupport().setPreviousId(panel.getButtonBar().getId());
      
      panel.getButtonBar().getFocusSupport().addListener(FocusManager.TabNext, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          tabs.getItem(tabs.getSelectedItem() == tabs.getItem(0) ? 0 : 1).getItem(0).focus();
          be.setCancelled(true);
        }
      });
      panel.getButtonBar().getFocusSupport().addListener(FocusManager.TabPrevious, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          TabItem item = tabs.getItem(tabs.getSelectedItem() == tabs.getItem(0) ? 0 : 1);
          item.getItem(item.getItemCount() - 1).focus();
          be.setCancelled(true);
        }
      });
    }

    vp.add(panel);
  }

  private void createColumnForm() {
    FormData formData = new FormData("100%");
    FormPanel panel = new FormPanel();
    panel.setFrame(true);
    panel.setIcon(Resources.ICONS.form());
    panel.setHeading("FormPanel");
    panel.setSize(600, -1);
    panel.setLabelAlign(LabelAlign.TOP);
    panel.setButtonAlign(HorizontalAlignment.CENTER);

    LayoutContainer main = new LayoutContainer();
    main.setLayout(new ColumnLayout());

    LayoutContainer left = new LayoutContainer();
    left.setStyleAttribute("paddingRight", "10px");
    FormLayout layout = new FormLayout();
    layout.setLabelAlign(LabelAlign.TOP);
    left.setLayout(layout);

    TextField<String> first = new TextField<String>();
    first.setFieldLabel("First Name");
    left.add(first, formData);

    TextField<String> company = new TextField<String>();
    company.setFieldLabel("Company");
    left.add(company, formData);

    DateField birthday = new DateField();
    birthday.setFieldLabel("Birthday");
    left.add(birthday, formData);

    LayoutContainer right = new LayoutContainer();
    right.setStyleAttribute("paddingLeft", "10px");
    layout = new FormLayout();
    layout.setLabelAlign(LabelAlign.TOP);
    right.setLayout(layout);

    TextField<String> last = new TextField<String>();
    last.setFieldLabel("Last");
    right.add(last, formData);

    TextField<String> email = new TextField<String>();
    email.setFieldLabel("Email");
    right.add(email, formData);

    Radio radio1 = new Radio();
    radio1.setBoxLabel("Yes");

    Radio radio2 = new Radio();
    radio2.setBoxLabel("No");

    RadioGroup group = new RadioGroup();
    group.setFieldLabel("Ext GWT User");
    group.add(radio1);
    group.add(radio2);
    right.add(group);

    main.add(left, new ColumnData(.5));
    main.add(right, new ColumnData(.5));

    panel.add(main, new FormData("100%"));

    HtmlEditor a = new HtmlEditor();
    a.setFieldLabel("Comment");
    a.setHeight(200);
    panel.add(a, new FormData("100%"));

    panel.addButton(new Button("Cancel"));
    panel.addButton(new Button("Submit"));

    vp.add(panel);
  }

}
