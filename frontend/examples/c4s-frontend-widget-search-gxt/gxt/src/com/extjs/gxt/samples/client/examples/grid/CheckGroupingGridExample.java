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

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Element;

public class CheckGroupingGridExample extends LayoutContainer {

  private GroupingView view;
  private String checkedStyle = "x-grid3-group-check";
  private String uncheckedStyle = "x-grid3-group-uncheck";
  
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    GroupingStore<Stock> store = new GroupingStore<Stock>();
    store.setMonitorChanges(true);
    store.add(TestData.getCompanies());
    store.groupBy("industry");

    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>() {
      @Override
      public void deselectAll() {
        super.deselectAll();
        NodeList<com.google.gwt.dom.client.Element> groups = view.getGroups();
        for (int i = 0; i < groups.getLength(); i++) {
          com.google.gwt.dom.client.Element group = groups.getItem(i).getFirstChildElement();
          setGroupChecked((Element)group, false);
        }
      }

      @Override
      public void selectAll() {
        super.selectAll();
        NodeList<com.google.gwt.dom.client.Element> groups = view.getGroups();
        for (int i = 0; i < groups.getLength(); i++) {
          com.google.gwt.dom.client.Element group = groups.getItem(i).getFirstChildElement();
          setGroupChecked((Element)group, true);
        }
      }

      @Override
      protected void doDeselect(List<Stock> models, boolean supressEvent) {
        super.doDeselect(models, supressEvent);
        NodeList<com.google.gwt.dom.client.Element> groups = view.getGroups();
        search : for (int i = 0; i < groups.getLength(); i++) {
          com.google.gwt.dom.client.Element group = groups.getItem(i);
          NodeList<Element> rows = El.fly(group).select(".x-grid3-row");
          for (int j = 0, len = rows.getLength(); j < len; j++) {
            Element r = rows.getItem(j);
            int idx = grid.getView().findRowIndex(r);
            Stock m = grid.getStore().getAt(idx);
            if (!isSelected(m)) {
              setGroupChecked((Element)group, false);
              continue search;
            }
          }
        }

      }
      
      @Override
      protected void doSelect(List<Stock> models, boolean keepExisting, boolean supressEvent) {
        super.doSelect(models, keepExisting, supressEvent);
        NodeList<com.google.gwt.dom.client.Element> groups = view.getGroups();
        search : for (int i = 0; i < groups.getLength(); i++) {
          com.google.gwt.dom.client.Element group = groups.getItem(i);
          NodeList<Element> rows = El.fly(group).select(".x-grid3-row");
          for (int j = 0, len = rows.getLength(); j < len; j++) {
            Element r = rows.getItem(j);
            int idx = grid.getView().findRowIndex(r);
            Stock m = grid.getStore().getAt(idx);
            if (!isSelected(m)) {
              continue search;
            }
          }
          setGroupChecked((Element)group, true);
          
        }
      }
    };

    ColumnConfig company = new ColumnConfig("name", "Company", 60);
    ColumnConfig price = new ColumnConfig("open", "Price", 20);
    ColumnConfig change = new ColumnConfig("change", "Change", 20);
    ColumnConfig industry = new ColumnConfig("industry", "Industry", 20);
    ColumnConfig last = new ColumnConfig("date", "Last Updated", 20);
    last.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/y"));

    List<ColumnConfig> config = new ArrayList<ColumnConfig>();
    config.add(sm.getColumn());
    config.add(company);
    config.add(price);
    config.add(change);
    config.add(industry);
    config.add(last);

    final ColumnModel cm = new ColumnModel(config);

    view = new GroupingView() {

      @Override
      protected void onMouseDown(GridEvent<ModelData> ge) {
        El hd = ge.getTarget(".x-grid-group-hd", 10);
        El target = ge.getTargetEl();
        if (hd != null && target.hasStyleName(uncheckedStyle) || target.hasStyleName(checkedStyle)) {
          boolean checked = !ge.getTargetEl().hasStyleName(uncheckedStyle);
          checked = !checked;
          if (checked) {
            ge.getTargetEl().replaceStyleName(uncheckedStyle, checkedStyle);
          } else {
            ge.getTargetEl().replaceStyleName(checkedStyle, uncheckedStyle);
          }

          Element group = (Element) findGroup(ge.getTarget());
          if (group != null) {
            NodeList<Element> rows = El.fly(group).select(".x-grid3-row");
            List<ModelData> temp = new ArrayList<ModelData>();
            for (int i = 0; i < rows.getLength(); i++) {
              Element r = rows.getItem(i);
              int idx = findRowIndex(r);
              ModelData m = grid.getStore().getAt(idx);
              temp.add(m);
            }
            if (checked) {
              grid.getSelectionModel().select(temp, true);
            } else {
              grid.getSelectionModel().deselect(temp);
            }
          }
          return;
        }
        super.onMouseDown(ge);
      }

    };
    view.setShowGroupedColumn(false);
    view.setForceFit(true);
    view.setGroupRenderer(new GridGroupRenderer() {
      public String render(GroupColumnData data) {
        String f = cm.getColumnById(data.field).getHeader();
        String l = data.models.size() == 1 ? "Item" : "Items";
        return "<div class='x-grid3-group-checker'><div class='" + uncheckedStyle + "'>&nbsp;</div></div>&nbsp;" + f
            + ": " + data.group + " (" + data.models.size() + " " + l + ")";
      }
    });

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setView(view);
    grid.setBorders(true);
    grid.addPlugin(sm);
    grid.setSelectionModel(sm);

    ContentPanel panel = new ContentPanel();
    panel.setHeading("Grouping Example");
    panel.setIcon(Resources.ICONS.table());
    panel.setCollapsible(true);
    panel.setFrame(true);
    panel.setSize(700, 450);
    panel.setLayout(new FitLayout());
    panel.add(grid);
    
    ToolBar toolBar = new ToolBar();
    toolBar.add(new LabelToolItem("Selection Mode: "));
    final SimpleComboBox<String> type = new SimpleComboBox<String>();
    type.setTriggerAction(TriggerAction.ALL);
    type.setEditable(false);
    type.setFireChangeEventOnSetValue(true);
    type.setWidth(100);
    type.add("Multi");
    type.add("Simple");
    type.setSimpleValue("Multi");
    type.addListener(Events.Change, new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        boolean simple = type.getSimpleValue().equals("Simple");
        sm.deselectAll();
        sm.setSelectionMode(simple ? SelectionMode.SIMPLE : SelectionMode.MULTI);
      }
    });

    toolBar.add(type);
    toolBar.add(new SeparatorToolItem());
    panel.setTopComponent(toolBar);

    add(panel);
  }
  
  private El findCheck(Element group) {
    return El.fly(group).selectNode(".x-grid3-group-checker").firstChild();
  }
  
  private void setGroupChecked(Element group, boolean checked) {
    findCheck(group).replaceStyleName(checked ? uncheckedStyle : checkedStyle, checked ? checkedStyle : uncheckedStyle);
  }

}
