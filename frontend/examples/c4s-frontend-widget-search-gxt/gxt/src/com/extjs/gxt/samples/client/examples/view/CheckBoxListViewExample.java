/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.view;

import java.util.List;

import com.extjs.gxt.samples.client.ExampleServiceAsync;
import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.examples.model.Photo;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CheckBoxListViewExample extends LayoutContainer {
  public CheckBoxListViewExample() {
    setLayout(new FlowLayout(10));
  }

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    final ExampleServiceAsync service = (ExampleServiceAsync) Registry.get(Examples.SERVICE);

    RpcProxy<List<Photo>> proxy = new RpcProxy<List<Photo>>() {
      @Override
      protected void load(Object loadConfig, AsyncCallback<List<Photo>> callback) {
        service.getPhotos(callback);
      }
    };

    ListLoader<ListLoadResult<Photo>> loader = new BaseListLoader<ListLoadResult<Photo>>(
        proxy, new BeanModelReader());
    ListStore<BeanModel> store = new ListStore<BeanModel>(loader);
    loader.load();

    final ContentPanel panel = new ContentPanel();
    panel.setCollapsible(true);
    panel.setAnimCollapse(false);
    panel.setFrame(true);
    panel.setHeading("CheckBox ListView (0 items selected)");
    panel.setWidth(300);
    panel.setAutoHeight(true);
    panel.setBodyBorder(false);

    final CheckBoxListView<BeanModel> view = new CheckBoxListView<BeanModel>() {
      @Override
      protected BeanModel prepareData(BeanModel model) {
        String s = model.get("name");
        model.set("shortName", Format.ellipse(s, 15));
        return model;
      }

    };

    view.setStore(store);
    view.setDisplayProperty("name");
    view.getSelectionModel().addListener(Events.SelectionChange,
        new Listener<SelectionChangedEvent<BeanModel>>() {

          public void handleEvent(SelectionChangedEvent<BeanModel> be) {
            panel.setHeading("CheckBox ListView (" + be.getSelection().size()
                + " items selected)");
          }

        });
    panel.add(view);

    panel.addButton(new Button("get checked items", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        Info.display("Checked Items", "There are " + view.getChecked().size()
            + " items checked!");

      }

    }));
    add(panel);
  }

}
