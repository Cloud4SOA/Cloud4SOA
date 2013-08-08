/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.forms;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.DataField;
import com.extjs.gxt.ui.client.data.JsonPagingLoadResultReader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.ScriptTagProxy;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.Element;

public class AdvancedComboBoxExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    String url = "http://www.extjs.com/forum/topics-remote.php";
    ScriptTagProxy<PagingLoadResult<ModelData>> proxy = new ScriptTagProxy<PagingLoadResult<ModelData>>(url);

    ModelType type = new ModelType();
    type.setRoot("topics");
    type.setTotalName("totalCount");
    type.addField("title", "topic_title");
    type.addField("topicId", "topic_id");
    type.addField("author", "author");
    type.addField("excerpt", "post_text");

    DataField date = new DataField("lastPost", "post_time");
    date.setType(Date.class);
    date.setFormat("timestamp");
    type.addField(date);

    JsonPagingLoadResultReader<PagingLoadResult<ModelData>> reader = new JsonPagingLoadResultReader<PagingLoadResult<ModelData>>(
        type);

    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy, reader);

    loader.addListener(Loader.BeforeLoad, new Listener<LoadEvent>() {
      public void handleEvent(LoadEvent be) {
        be.<ModelData> getConfig().set("start", be.<ModelData> getConfig().get("offset"));
      }
    });

    ListStore<ModelData> store = new ListStore<ModelData>(loader);

    ComboBox<ModelData> combo = new ComboBox<ModelData>();
    combo.setWidth(580);
    combo.setDisplayField("title");
    combo.setItemSelector("div.search-item");
    combo.setTemplate(getTemplate());
    combo.setStore(store);
    combo.setHideTrigger(true);
    combo.setPageSize(10);

    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);

    vp.addText("<span class='text'><b>Combo with Templates and Ajax</b><br>This is a more advanced example that shows how you can combine paging, XTemplate and a remote data store to create a 'live search' feature.</span>");
    vp.add(combo);

    add(vp);
  }

  private native String getTemplate() /*-{
    return [
    '<tpl for="."><div class="search-item">',
    '<h3><span>{lastPost:date("MM/dd/y")}<br />by {author}</span>{title}</h3>',
    '{excerpt}',
    '</div></tpl>'
    ].join("");
  }-*/;
}
