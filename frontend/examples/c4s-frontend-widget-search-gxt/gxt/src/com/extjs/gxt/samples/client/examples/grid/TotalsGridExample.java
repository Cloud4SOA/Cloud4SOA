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
import java.util.Map;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Task;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Element;

public class TotalsGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setLayout(new FlowLayout(10));

    List<Task> tasks = TestData.getTasks();
    GroupingStore<Task> store = new GroupingStore<Task>();
    store.groupBy("project");
    store.add(tasks);

    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

    SummaryColumnConfig<Integer> desc = new SummaryColumnConfig<Integer>("description", "Task", 65);
    desc.setSummaryType(SummaryType.COUNT);
    desc.setSummaryRenderer(new SummaryRenderer() {
      public String render(Number value, Map<String, Number> data) {
        return value.intValue() > 1 ? "(" + value.intValue() + " Tasks)" : "(1 Task)";
      }
    });

    SummaryColumnConfig<Double> project = new SummaryColumnConfig<Double>("project", "Project", 55);
    SummaryColumnConfig<Double> due = new SummaryColumnConfig<Double>("due", "Due Date", 20);

    SummaryColumnConfig<Double> estimate = new SummaryColumnConfig<Double>("estimate", "Estimate", 20);
    estimate.setRenderer(new GridCellRenderer<Task>() {
      public String render(Task model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Task> store, Grid<Task> grid) {
        return model.get(property) + " hours";
      }
    });
    estimate.setSummaryType(SummaryType.SUM);
    estimate.setSummaryRenderer(new SummaryRenderer() {
      public String render(Number value, Map<String, Number> data) {
        return value.intValue() + " hours";
      }
    });
    estimate.setEditor(new CellEditor(new NumberField()));

    SummaryColumnConfig<Double> rate = new SummaryColumnConfig<Double>("rate", "Rate", 20);
    rate.setNumberFormat(NumberFormat.getCurrencyFormat());
    rate.setSummaryFormat(NumberFormat.getCurrencyFormat());
    rate.setSummaryType(SummaryType.AVG);
    rate.setAlignment(HorizontalAlignment.RIGHT);

    NumberField nf = new NumberField();
    nf.setAutoValidate(true);
    CellEditor ce = new CellEditor(nf);
    ce.setCancelOnEsc(true);
    rate.setEditor(ce);

    SummaryColumnConfig<Double> cost = new SummaryColumnConfig<Double>("cost", "Cost", 20);
    cost.setSummaryFormat(NumberFormat.getCurrencyFormat());
    cost.setSummaryType(new SummaryType<Double>() {
      @Override
      public Double render(Object v, ModelData m, String field, Map<String, Object> data) {
        if (v == null) {
          v = 0d;
        }
        Task task = (Task) m;
        return ((Double) v).doubleValue() + (task.getEstimate() * task.getRate());
      }

    });
    cost.setAlignment(HorizontalAlignment.RIGHT);
    cost.setRenderer(new GridCellRenderer<Task>() {
      public String render(Task model, String property, ColumnData config, int rowIndex, int colIndex,
          ListStore<Task> store, Grid<Task> grid) {
        Task task = (Task) model;
        return NumberFormat.getCurrencyFormat().format(task.getRate() * task.getEstimate());
      }
    });

    columns.add(desc);
    columns.add(project);
    columns.add(due);
    columns.add(estimate);
    columns.add(rate);
    columns.add(cost);
    ColumnModel cm = new ColumnModel(columns);

    GroupSummaryView summary = new GroupSummaryView();
    summary.setForceFit(true);
    summary.setShowGroupedColumn(false);

    EditorGrid<Task> grid = new EditorGrid<Task>(store, cm);
    grid.setBorders(true);
    grid.setView(summary);
    grid.getView().setShowDirtyCells(false);

    ContentPanel panel = new ContentPanel();
    panel.setHeading("Sponsored Projects");
    panel.setIcon(Resources.ICONS.table());
    panel.setCollapsible(true);
    panel.setFrame(true);
    panel.setSize(800, 450);
    panel.setLayout(new FitLayout());
    panel.add(grid);
    add(panel);
  }

}
