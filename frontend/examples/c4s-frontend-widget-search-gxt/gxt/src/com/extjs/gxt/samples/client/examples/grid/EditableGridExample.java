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
import com.extjs.gxt.samples.resources.client.model.Plant;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.DateWrapper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;
public class EditableGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    List<Stock> stocks = TestData.getStocks();
    for (Stock s : stocks) {
      DateWrapper w = new DateWrapper();
      w = w.clearTime();
      w = w.addDays((int) (Math.random() * 1000));
      s.set("date", w.asDate());
    }

    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

    ColumnConfig column = new ColumnConfig();
    column.setId("name");
    column.setHeader("Common Name");
    column.setWidth(220);

    TextField<String> text = new TextField<String>();
    text.setAllowBlank(false);
    column.setEditor(new CellEditor(text));
    configs.add(column);

    final SimpleComboBox<String> combo = new SimpleComboBox<String>();
    combo.setForceSelection(true);
    combo.setTriggerAction(TriggerAction.ALL);
    combo.add("Shade");
    combo.add("Mostly Shady");
    combo.add("Sun or Shade");
    combo.add("Mostly Sunny");
    combo.add("Sunny");

    CellEditor editor = new CellEditor(combo) {
      @Override
      public Object preProcessValue(Object value) {
        if (value == null) {
          return value;
        }
        return combo.findModel(value.toString());
      }

      @Override
      public Object postProcessValue(Object value) {
        if (value == null) {
          return value;
        }
        return ((ModelData) value).get("value");
      }
    };

    column = new ColumnConfig();
    column.setId("light");
    column.setHeader("Light");
    column.setWidth(130);
    column.setEditor(editor);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("price");
    column.setHeader("Price");
    column.setAlignment(HorizontalAlignment.RIGHT);
    column.setWidth(70);
    column.setNumberFormat(NumberFormat.getCurrencyFormat());
    column.setEditor(new CellEditor(new NumberField()));

    configs.add(column);

    DateField dateField = new DateField();
    dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat("MM/dd/y"));

    column = new ColumnConfig();
    column.setId("available");
    column.setHeader("Available");
    column.setWidth(95);
    column.setEditor(new CellEditor(dateField));
    column.setDateTimeFormat(DateTimeFormat.getFormat("yyyy MMM dd"));
    configs.add(column);

    CheckColumnConfig checkColumn = new CheckColumnConfig("indoor", "Indoor?", 55);
    CellEditor checkBoxEditor = new CellEditor(new CheckBox());
    checkColumn.setEditor(checkBoxEditor);
    configs.add(checkColumn);

    final ListStore<Plant> store = new ListStore<Plant>();
    store.add(TestData.getPlants());

    ColumnModel cm = new ColumnModel(configs);

    ContentPanel cp = new ContentPanel();
    cp.setHeading("Edit Plants");
    cp.setFrame(true);
    cp.setIcon(Resources.ICONS.table());
    cp.setSize(600, 300);
    cp.setLayout(new FitLayout());

    final EditorGrid<Plant> grid = new EditorGrid<Plant>(store, cm);
    grid.setAutoExpandColumn("name");
    grid.setBorders(true);
    grid.addPlugin(checkColumn);
    cp.add(grid);

    ToolBar toolBar = new ToolBar();
    Button add = new Button("Add Plant");
    add.addSelectionListener(new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        Plant plant = new Plant();
        plant.setName("New Plant 1");
        plant.setLight("Mostly Shady");
        plant.setPrice(0);
        plant.setAvailable(new DateWrapper().clearTime().asDate());
        plant.setIndoor(false);

        grid.stopEditing();
        store.insert(plant, 0);
        grid.startEditing(store.indexOf(plant), 0);
      }

    });
    toolBar.add(add);
    cp.setTopComponent(toolBar);
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.addButton(new Button("Reset", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        store.rejectChanges();
      }
    }));

    cp.addButton(new Button("Save", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        store.commitChanges();
      }
    }));

    add(cp);
  }

}
