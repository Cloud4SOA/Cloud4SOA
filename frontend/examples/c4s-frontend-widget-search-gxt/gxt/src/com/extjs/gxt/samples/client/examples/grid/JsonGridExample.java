/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.grid;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.JsonLoadResultReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Element;

public class JsonGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));

    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
    columns.add(new ColumnConfig("Sender", "Sender", 100));
    columns.add(new ColumnConfig("Email", "Email", 165));
    columns.add(new ColumnConfig("Phone", "Phone", 100));
    columns.add(new ColumnConfig("State", "State", 50));
    columns.add(new ColumnConfig("Zip", "Zip Code", 65));

    // create the column model
    ColumnModel cm = new ColumnModel(columns);

    // defines the xml structure
    ModelType type = new ModelType();
    type.setRoot("records");
    type.addField("Sender", "name");
    type.addField("Email", "email");
    type.addField("Phone", "phone");
    type.addField("State", "state");
    type.addField("Zip", "zip");
    
    //Determine if Explorer or Example for JSON path
    String path =  GWT.getHostPageBaseURL() + (Examples.isExplorer() ? "" : "../../" ) + "data/data.json";

    // use a http proxy to get the data
    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, path);
    HttpProxy<String> proxy = new HttpProxy<String>(builder);

    // need a loader, proxy, and reader
    JsonLoadResultReader<ListLoadResult<ModelData>> reader = new JsonLoadResultReader<ListLoadResult<ModelData>>(type);

    final BaseListLoader<ListLoadResult<ModelData>> loader = new BaseListLoader<ListLoadResult<ModelData>>(proxy,
        reader);

    ListStore<ModelData> store = new ListStore<ModelData>(loader);
    final Grid<ModelData> grid = new Grid<ModelData>(store, cm);
    grid.setBorders(true);
    grid.setLoadMask(true);
    grid.getView().setEmptyText("Please hit the load button.");
    grid.setAutoExpandColumn("Sender");

    ContentPanel panel = new ContentPanel();
    panel.setFrame(true);
    panel.setCollapsible(true);
    panel.setAnimCollapse(false);
    panel.setButtonAlign(HorizontalAlignment.CENTER);
    panel.setIcon(Resources.ICONS.table());
    panel.setHeading("JSON Table Demo");
    panel.setLayout(new FitLayout());
    panel.add(grid);
    panel.setSize(575, 350);

    // add buttons
    Button load = new Button("Load JSON", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        loader.load();
      }
    });

    panel.addButton(load);
    grid.getAriaSupport().setLabelledBy(panel.getHeader().getId() + "-label");
    add(panel);

  }

}
