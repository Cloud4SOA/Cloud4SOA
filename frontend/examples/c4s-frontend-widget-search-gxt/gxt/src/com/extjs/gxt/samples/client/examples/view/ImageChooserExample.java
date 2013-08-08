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
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
@SuppressWarnings("deprecation")
public class ImageChooserExample extends LayoutContainer {

  private ListStore<BeanModel> store;
  private SimpleComboBox<String> sort;
  private XTemplate detailTp;
  private ListView<BeanModel> view;
  private LayoutContainer details;
  private Dialog chooser;
  private Image image;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    detailTp = XTemplate.create(getDetailTemplate());

    final ExampleServiceAsync service = (ExampleServiceAsync) Registry.get(Examples.SERVICE);

    RpcProxy<List<Photo>> proxy = new RpcProxy<List<Photo>>() {
      @Override
      protected void load(Object loadConfig, AsyncCallback<List<Photo>> callback) {
        service.getPhotos(callback);
      }
    };

    ListLoader<ListLoadResult<BeanModel>> loader = new BaseListLoader<ListLoadResult<BeanModel>>(proxy,
        new BeanModelReader());
    store = new ListStore<BeanModel>(loader);
    loader.load();

    chooser = new Dialog();
    chooser.setId("img-chooser-dlg");
    chooser.setHeading("Choose an Image");
    chooser.setMinWidth(500);
    chooser.setMinHeight(300);
    chooser.setModal(true);
    chooser.setLayout(new BorderLayout());
    chooser.setBodyStyle("border: none;background: none");
    chooser.setBodyBorder(false);
    chooser.setButtons(Dialog.OKCANCEL);
    chooser.setHideOnButtonClick(true);
    chooser.addListener(Events.Hide, new Listener<WindowEvent>() {
      public void handleEvent(WindowEvent be) {
        BeanModel model = view.getSelectionModel().getSelectedItem();
        if (model != null) {
          Photo photo = model.getBean();
          if (be.getButtonClicked() == chooser.getButtonById("ok")) {
            image.setUrl(photo.getPath());
            image.setVisible(true);
          }
        }
      }
    });

    ContentPanel main = new ContentPanel();
    main.setBorders(true);
    main.setBodyBorder(false);
    main.setLayout(new FitLayout());
    main.setHeaderVisible(false);

    ToolBar bar = new ToolBar();
    bar.add(new LabelToolItem("Filter:"));

    StoreFilterField<BeanModel> field = new StoreFilterField<BeanModel>() {
      @Override
      protected boolean doSelect(Store<BeanModel> store, BeanModel parent, BeanModel record, String property,
          String filter) {
        Photo photo = record.getBean();
        String name = photo.getName().toLowerCase();
        if (name.indexOf(filter.toLowerCase()) != -1) {
          return true;
        }
        return false;
      }

      @Override
      protected void onFilter() {
        super.onFilter();
        view.getSelectionModel().select(0, false);
      }

    };
    field.setWidth(100);
    field.bind(store);

    bar.add(field);
    bar.add(new SeparatorToolItem());
    bar.add(new LabelToolItem("Sort By:"));

    sort = new SimpleComboBox<String>();
    sort.setTriggerAction(TriggerAction.ALL);
    sort.setEditable(false);
    sort.setForceSelection(true);
    sort.setWidth(90);
    sort.add("Name");
    sort.add("File Size");
    sort.add("Last Modified");
    sort.setSimpleValue("Name");
    sort.addListener(Events.Select, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        sort();
      }
    });

    bar.add(sort);

    main.setTopComponent(bar);

    view = new ListView<BeanModel>() {
      @Override
      protected BeanModel prepareData(BeanModel model) {
        Photo photo = model.getBean();
        long size = photo.getSize() / 1000;
        model.set("shortName", Format.ellipse(photo.getName(), 15));
        model.set("sizeString", NumberFormat.getFormat("#0").format(size) + "k");
        model.set("dateString", DateTimeFormat.getMediumDateTimeFormat().format(photo.getDate()));
        model.set("modPath", GWT.getHostPageBaseURL() + photo.getPath());
        return model;
      }
    };
    view.setId("img-chooser-view");
    view.setTemplate(getTemplate());
    view.setBorders(false);
    view.setStore(store);
    view.setItemSelector("div.thumb-wrap");
    view.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    view.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<BeanModel>>() {
      public void handleEvent(SelectionChangedEvent<BeanModel> be) {
        onSelectionChange(be);
      }
    });
    main.add(view);

    details = new LayoutContainer();
    details.setBorders(true);
    details.setStyleAttribute("backgroundColor", "white");

    BorderLayoutData eastData = new BorderLayoutData(LayoutRegion.EAST, 150, 150, 250);
    eastData.setSplit(true);

    BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
    centerData.setMargins(new Margins(0, 5, 0, 0));

    chooser.add(main, centerData);
    chooser.add(details, eastData);

    setLayout(new FlowLayout(10));
    add(new Button("Choose", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        chooser.show();
        view.getSelectionModel().select(0, false);
      }
    }));

    image = new Image();
    image.getElement().getStyle().setProperty("marginTop", "10px");
    image.setVisible(false);
    add(image);
  }

  private void sort() {
    String v = sort.getSimpleValue();
    if (v.equals("Name")) {
      store.sort("name", SortDir.ASC);
    } else if (v.equals("File Size")) {
      store.sort("size", SortDir.ASC);
    } else {
      store.sort("date", SortDir.ASC);
    }
  }

  private void onSelectionChange(SelectionChangedEvent<BeanModel> se) {
    if (se.getSelection().size() > 0) {
      detailTp.overwrite(details.getElement(), Util.getJsObject(se.getSelection().get(0)));
      chooser.getButtonById("ok").enable();
    } else {
      chooser.getButtonById("ok").disable();
      details.el().setInnerHtml("");
    }
  }

  private native String getTemplate() /*-{
    return ['<tpl for=".">',
    '<div class="thumb-wrap" id="{name}" style="border: 1px solid white">',
    '<div class="thumb"><img src="{modPath}" title="{name}"></div>',
    '<span class="x-editable">{shortName}</span></div>',
    '</tpl>',
    '<div class="x-clear"></div>'].join("");
  }-*/;

  public native String getDetailTemplate() /*-{
    return ['<div class="details">',
    '<tpl for=".">',
    '<img src="{modPath}"><div class="details-info">',
    '<b>Image Name:</b>',
    '<span>{name}</span>',
    '<b>Size:</b>',
    '<span>{sizeString}</span>',
    '<b>Last Modified:</b>',
    '<span>{dateString}</span></div>',
    '</tpl>',
    '</div>'].join("");
  }-*/;
}
