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
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowExpander;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
public class GridPluginsExample extends LayoutContainer {

  private VerticalPanel panel;
  private GridCellRenderer<Stock> gridNumber;
  private GridCellRenderer<Stock> change;

  public GridPluginsExample() {
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Stock>> numberRenderer = new NumberCellRenderer<Grid<Stock>>(currency);

    change = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
      }
    };

    gridNumber = new GridCellRenderer<Stock>() {
      public String render(Stock model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Stock> store, Grid<Stock> grid) {
        return numberRenderer.render(null, property, model.get(property));
      }
    };

    panel = new VerticalPanel();
    panel.setSpacing(20);

  }

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    createExpander();
    createCheckBox();
    createNumberer();
    createFramed();
    add(panel);
  }

  private void createCheckBox() {
    List<Stock> stocks = TestData.getStocks();

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();
    // selection model supports the SIMPLE selection mode
    // sm.setSelectionMode(SelectionMode.SIMPLE);

    configs.add(sm.getColumn());

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(300);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(75);
    column.setRenderer(gridNumber);
    configs.add(column);

    column = new ColumnConfig("change", "Change", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setRenderer(change);
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(stocks);

    ColumnModel cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    cp.setHeading("Framed with Checkbox Selection and Horizontal Scrolling");
    cp.setFrame(true);
    cp.setIcon(Resources.ICONS.table());
    cp.setLayout(new FitLayout());
    cp.setSize(600, 300);

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setSelectionModel(sm);
    grid.setBorders(true);
    grid.setColumnReordering(true);
    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
    grid.addPlugin(sm);
    
    ToolBar toolBar = new ToolBar();
    toolBar.getAriaSupport().setLabel("Grid Options");
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
    cp.setTopComponent(toolBar);

    cp.add(grid);
    panel.add(cp);
  }

  private void createExpander() {
    List<Stock> stocks = TestData.getStocks();
    for (Stock s : stocks) {
      s.set(
          "desc",
          "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.<br/><br/>Aliquam commodo ullamcorper erat. Nullam vel justo in neque porttitor laoreet. Aenean lacus dui, consequat eu, adipiscing eget, nonummy non, nisi. Morbi nunc est, dignissim non, ornare sed, luctus eu, massa. Vivamus eget quam. Vivamus tincidunt diam nec urna. Curabitur velit.");
    }

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    XTemplate tpl = XTemplate.create("<p><b>Company:</b> {name}</p><br><p><b>Summary:</b> {desc}</p>");

    RowExpander expander = new RowExpander();
    expander.setTemplate(tpl);

    configs.add(expander);

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(75);
    column.setRenderer(gridNumber);
    configs.add(column);

    column = new ColumnConfig("change", "Change", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setRenderer(change);
    configs.add(column);

    column = new ColumnConfig("date", "Last Updated", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(stocks);

    ColumnModel cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    cp.setHeading("Expander Rows, Collapse and Auto Fill");
    cp.setIcon(Resources.ICONS.table());
    cp.setAnimCollapse(false);
    cp.setCollapsible(true);
    cp.setLayout(new FitLayout());
    cp.setSize(600, 300);

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.addPlugin(expander);
    grid.setColumnReordering(true);
    grid.getView().setAutoFill(true);
    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
    cp.add(grid);

    panel.add(cp);
  }

  private void createFramed() {
    List<Stock> stocks = TestData.getStocks();

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();

    configs.add(sm.getColumn());

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(75);
    column.setRenderer(gridNumber);
    configs.add(column);

    column = new ColumnConfig("change", "Change", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setRenderer(change);
    configs.add(column);

    column = new ColumnConfig("date", "Last Updated", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setDateTimeFormat(DateTimeFormat.getFormat("MM/dd/yyyy"));
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(stocks);

    ColumnModel cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    cp.setHeading("Support for standard Panel features such as framing, buttons and toolbars");
    cp.setFrame(true);
    cp.setIcon(Resources.ICONS.table());
    cp.addButton(new Button("Save"));
    cp.addButton(new Button("Cancel"));
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setSize(600, 300);

    ToolBar toolBar = new ToolBar();
    toolBar.getAriaSupport().setLabel("Grid Options");
    toolBar.add(new Button("Add", Resources.ICONS.add()));
    toolBar.add(new SeparatorToolItem());
    toolBar.add(new Button("Remove", Resources.ICONS.delete()));
    toolBar.add(new SeparatorToolItem());
    toolBar.add(new Button("Configure", Resources.ICONS.plugin()));
    cp.setTopComponent(toolBar);

    Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.setSelectionModel(sm);
    grid.setAutoExpandColumn("name");
    grid.setColumnReordering(true);
    grid.setBorders(true);
    grid.addPlugin(sm);
    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
    cp.add(grid);
    panel.add(cp);
  }

  private void createNumberer() {
    List<Stock> stocks = TestData.getStocks();

    RowNumberer r = new RowNumberer();

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    configs.add(r);

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Company");
    column.setWidth(200);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("symbol");
    column.setHeader("Symbol");
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("last");
    column.setHeader("Last");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(75);
    column.setRenderer(gridNumber);
    configs.add(column);

    column = new ColumnConfig("change", "Change", 100);
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setRenderer(change);
    configs.add(column);

    ListStore<Stock> store = new ListStore<Stock>();
    store.add(stocks);

    ColumnModel cm = new ColumnModel(configs);

    final Grid<Stock> grid = new Grid<Stock>(store, cm);
    grid.addPlugin(r);
    grid.getView().setForceFit(true);
    

    Button btn = new Button("Remove a Row", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        grid.getStore().remove(grid.getStore().getAt(0));
        if (grid.getStore().getCount() == 0) {
          ce.<Component> getComponent().disable();
        }
      }

    });
    btn.setIcon(Resources.ICONS.delete());

    ContentPanel cp = new ContentPanel();
    cp.setHeading("Grid with Numbered Rows and Force Fit");
    cp.setIcon(Resources.ICONS.table());
    cp.setLayout(new FitLayout());
    cp.setSize(600, 300);
    cp.add(grid);
    cp.addButton(btn);
    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
    panel.add(cp);
  }

}
