/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treepanel;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.XmlReader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Element;

public class AsyncXmlTreePanelExample extends LayoutContainer {
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, GWT.getModuleBaseURL() + "xmltreeloader");
    HttpProxy<ListLoadResult<ModelData>> proxy = new HttpProxy<ListLoadResult<ModelData>>(builder);

    ModelType type = new ModelType();
    type.setRecordName("item");
    type.setRoot("items");
    type.addField("id", "@id");
    type.addField("name", "@name");
    type.addField("folder", "@folder");

    XmlReader<List<ModelData>> reader = new XmlReader<List<ModelData>>(type);

    TreeLoader<ModelData> loader = new BaseTreeLoader<ModelData>(proxy, reader) {
      @Override
      public boolean hasChildren(ModelData parent) {
        return "true".equals(parent.get("folder"));
      }

      @Override
      protected Object prepareLoadConfig(Object config) {
        // by default the load config will be the parent model
        // http proxy will set all properties of model into request
        // parameters, so the model name and id will be passed to server
        return super.prepareLoadConfig(config);
      }
    };

    TreeStore<ModelData> store = new TreeStore<ModelData>(loader);

    final TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
    tree.setDisplayProperty("name");
    tree.getStyle().setLeafIcon(IconHelper.createStyle("icon-music"));
    tree.setWidth(315);

    loader.load();

    ButtonBar buttonBar = new ButtonBar();

    buttonBar.add(new Button("Expand All", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        tree.expandAll();
      }
    }));
    buttonBar.add(new Button("Collapse All", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        tree.collapseAll();
      }
    }));

    addText("<div style='font-size: 12px;padding-bottom: 8px'>TreePanel which loads its children on demand using a remote service which returns xml.</div>");
    add(buttonBar, new FlowData(10));
    add(tree);
  }
}
