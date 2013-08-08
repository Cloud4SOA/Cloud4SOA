/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.DateWrapper;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Element;

public class TemplateExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    
    class Kid extends BaseModelData {
      public Kid(String name, int age, Date bday) {
        set("name", name);
        set("age", age);
        set("bday", bday);
      }
    }
    
    class Person extends BaseModelData {
      public Person(String name, String company, String product, String location, double income) {
        set("name", name);
        set("company", company);
        set("product", product);
        set("location", location);
        set("income", income);
      }
      
      public void setKids(List<Kid> kids) {
        set("kids", kids);
      }
    }

    final Person person = new Person("Darrell Meyer", "Sencha Inc", "Ext GWT", "Washington, DC", 1000000000d);

    List<Kid> kids = new ArrayList<Kid>();
    kids.add(new Kid("Alec", 4, new DateWrapper(2004, 1, 1).asDate()));
    kids.add(new Kid("Lia", 2, new DateWrapper(2005, 1, 1).asDate()));
    kids.add(new Kid("Andrew", 1, new DateWrapper(2007, 1, 1).asDate()));

    person.setKids(kids);

    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);

    final ContentPanel panel = new ContentPanel();
    panel.setHeading("Basic Template");
    panel.setWidth(300);
    panel.setBodyStyleName("pad-text");

    ToolBar toolbar = new ToolBar();
    Button apply = new Button("Apply Template");
    apply.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        Template template = new Template(getBasicTemplate());
        template.overwrite(panel.getBody().dom, Util.getJsObject(person));
      }
    });
    toolbar.add(apply);
    panel.setTopComponent(toolbar);

    final ContentPanel xpanel = new ContentPanel();
    xpanel.setHeading("XTemplate Playground");
    xpanel.setWidth(300);
    xpanel.setBodyStyleName("pad-text");

    ToolBar toolBar = new ToolBar();
    toolBar.add(new Button("Apply Template", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        XTemplate tpl = XTemplate.create(getTemplate());
        xpanel.removeAll();
        xpanel.addText(tpl.applyTemplate(Util.getJsObject(person, 3)));
        xpanel.layout();
      }
    }));
    xpanel.setTopComponent(toolBar);
    
    final ContentPanel cpanel = new ContentPanel();
    cpanel.setHeading("XTemplate Test");
    cpanel.setWidth(500);
    cpanel.setBodyStyleName("pad-text");
    
    final Html html = new Html();
    html.setStyleName("pad-text");

    final TextArea area = new TextArea();
    area.setSize(485, 150);
    
    toolBar = new ToolBar();
    toolBar.add(new Button("Apply Template", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        String template = area.getValue();
        XTemplate tpl = XTemplate.create(template);
        tpl.overwrite(html.getElement(), Util.getJsObject(person, 3));
      }
    }));
    cpanel.setTopComponent(toolBar);
    
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Name: {name}</p>\r\n");
    sb.append("<p>Company: {company}</p>\r\n");
    sb.append("<p>Location: {location}</p>\r\n");
    sb.append("<p>Salary: {income:currency}</p>\r\n");
    sb.append("<p>Kids:</p>\r\n");
    sb.append("<tpl for=\"kids\" if=\"name==\'Darrell Meyer\'\">\r\n");
    sb.append("<tpl if=\"age &gt; 1\"><p>{#}. {parent.name}\'s kid - {name} - {bday:date(\"M/d/yyyy\")}</p></tpl>");
    sb.append("</tpl>\r\n");
    

    area.setValue(sb.toString());
    cpanel.add(area);
    cpanel.add(html);

    vp.add(panel);
    vp.add(xpanel);
    vp.add(cpanel);
    add(vp);
  }

  private native String getBasicTemplate() /*-{
    return ['<p>Name: {name}</p>',
    '<p>Company: {company}</p>',
    '<p>Location: {location}</p>'].join("");
  }-*/;

  private native String getTemplate() /*-{
    var html = [
    '<p>Name: {name}</p>',
    '<p>Company: {company}</p>',
    '<p>Location: {location}</p>',
    '<p>Salary: {income:currency}</p>',
    '<p>Kids:</p>',
    '<tpl for="kids" if="name==\'Darrell Meyer\'">',
    '<tpl if="age &gt; 1"><p>{#}. {parent.name}\'s kid - {name} - {bday:date("M/d/yyyy")}</p></tpl>',
    '</tpl>'
    ];
    return html.join("");
  }-*/;

}
