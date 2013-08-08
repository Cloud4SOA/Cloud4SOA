/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.dnd;

import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.dnd.ListViewDragSource;
import com.extjs.gxt.ui.client.dnd.ListViewDropTarget;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

public class ListViewDNDExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("margin", "10px");
    ContentPanel cp = new ContentPanel();
    cp.setHeading("ListView Append Sorted");
    cp.setSize(500, 225);
    cp.setFrame(true);
    cp.setLayout(new RowLayout(Orientation.HORIZONTAL));
    
    ListView<Stock> list1 = new ListView<Stock>();
    list1.setDisplayProperty("name");
    ListStore<Stock> store = new ListStore<Stock>();
    store.setStoreSorter(new StoreSorter<Stock>());
    store.add(TestData.getStocks());
    list1.setStore(store);
    

    ListView<Stock> list2 = new ListView<Stock>();
    list2.setDisplayProperty("name");
    store = new ListStore<Stock>();
    store.setStoreSorter(new StoreSorter<Stock>());
    list2.setStore(store);

    new ListViewDragSource(list1);
    new ListViewDragSource(list2);

    new ListViewDropTarget(list1);
    new ListViewDropTarget(list2);

    RowData data = new RowData(.5, 1);
    data.setMargins(new Margins(5));
   
    cp.add(list1, data);
    cp.add(list2, data);
    add(cp);
    
    cp = new ContentPanel();
    cp.setHeading("ListView Insert");
    cp.setStyleAttribute("marginTop", "10px");
    cp.setSize(500, 225);
    cp.setFrame(true);
    cp.setLayout(new RowLayout(Orientation.HORIZONTAL));

    ListView<Stock> list3 = new ListView<Stock>();
    list3.setDisplayProperty("name");
    store = new ListStore<Stock>();
    store.add(TestData.getStocks());
    list3.setStore(store);

    ListView<Stock> list4 = new ListView<Stock>();
    list4.setDisplayProperty("name");
    store = new ListStore<Stock>();
    list4.setStore(store);

    cp.add(list3, data);
    cp.add(list4, data);
    
    ListViewDragSource source3 = new ListViewDragSource(list3);
    source3.setGroup("demo2");
    ListViewDragSource source4 = new ListViewDragSource(list4);
    source4.setGroup("demo2");

    ListViewDropTarget target3 = new ListViewDropTarget(list3);
    target3.setGroup("demo2");
    target3.setFeedback(Feedback.INSERT);
    ListViewDropTarget target4 = new ListViewDropTarget(list4);
    target4.setGroup("demo2");
    target4.setFeedback(Feedback.INSERT);
    add(cp);
    
  }
}
