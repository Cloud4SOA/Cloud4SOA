/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.chart;

import java.util.ArrayList;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.event.ChartEvent;
import com.extjs.gxt.charts.client.event.ChartListener;
import com.extjs.gxt.charts.client.model.BarDataProvider;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.LineDataProvider;
import com.extjs.gxt.charts.client.model.ScaleProvider;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.LineChart;
import com.extjs.gxt.charts.client.model.charts.BarChart.BarStyle;
import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.TeamSales;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.NumberPropertyEditor;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CellSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

public class AdvancedChartExample extends LayoutContainer {

  private EditorGrid<TeamSales> teamSalesGrid;
  private Radio selRadio;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    final ListStore<TeamSales> store = new ListStore<TeamSales>();
    store.add(TestData.getTeamSales());

    // chart
    String url = !Examples.isExplorer() ? "../../" : "";
    url += "gxt/chart/open-flash-chart.swf";
    final Chart chart = new Chart(url);

    ChartListener listener = new ChartListener() {
      public void chartClick(ChartEvent ce) {
        int row = ce.getChartConfig().getValues().indexOf(ce.getDataType());
        int col = ce.getChartModel().getChartConfigs().indexOf(ce.getChartConfig()) + 1;
        CellSelectionModel<TeamSales> csm = (CellSelectionModel<TeamSales>) teamSalesGrid.getSelectionModel();
        if (selRadio.getValue()) {
          csm.selectCell(row, col);
        } else {
          teamSalesGrid.startEditing(row, col);
        }
      }
    };

    ChartModel model = new ChartModel("Team Sales by Month",
        "font-size: 14px; font-family: Verdana; text-align: center;");
    model.setBackgroundColour("#fefefe");
    model.setLegend(new Legend(Position.TOP, true));
    model.setScaleProvider(ScaleProvider.ROUNDED_NEAREST_SCALE_PROVIDER);

    BarChart bar = new BarChart(BarStyle.GLASS);
    bar.setColour("#00aa00");
    BarDataProvider barProvider = new BarDataProvider("alphasales", "month");
    barProvider.bind(store);
    bar.setDataProvider(barProvider);
    bar.addChartListener(listener);
    model.addChartConfig(bar);

    bar = new BarChart(BarStyle.GLASS);
    bar.setColour("#0000cc");
    barProvider = new BarDataProvider("betasales");
    barProvider.bind(store);
    bar.setDataProvider(barProvider);
    bar.addChartListener(listener);
    model.addChartConfig(bar);

    bar = new BarChart(BarStyle.GLASS);
    bar.setColour("#ff6600");
    barProvider = new BarDataProvider("gammasales");
    barProvider.bind(store);
    bar.setDataProvider(barProvider);
    bar.addChartListener(listener);
    model.addChartConfig(bar);

    LineChart line = new LineChart();
    line.setAnimateOnShow(true);
    line.setText("Average");
    line.setColour("#FF0000");
    LineDataProvider lineProvider = new LineDataProvider("avgsales");
    lineProvider.bind(store);
    line.setDataProvider(lineProvider);
    model.addChartConfig(line);

    chart.setChartModel(model);

    // grid
    NumberPropertyEditor npe = new NumberPropertyEditor(Integer.class);
    ArrayList<ColumnConfig> cols = new ArrayList<ColumnConfig>();

    ColumnConfig qtr = new ColumnConfig("month", "Month", 100);
    cols.add(qtr);
    qtr.setEditor(new CellEditor(new TextField<String>()));

    ColumnConfig alpha = new ColumnConfig("alphasales", "Alpha ($M)", 100);
    cols.add(alpha);
    NumberField nf = new NumberField();
    nf.setPropertyEditor(npe);
    alpha.setEditor(new CellEditor(nf));

    ColumnConfig beta = new ColumnConfig("betasales", "Beta ($M)", 100);
    cols.add(beta);
    nf = new NumberField();
    nf.setPropertyEditor(npe);
    beta.setEditor(new CellEditor(nf));

    ColumnConfig gamma = new ColumnConfig("gammasales", "Gamma ($M)", 100);
    cols.add(gamma);
    nf = new NumberField();
    nf.setPropertyEditor(npe);
    gamma.setEditor(new CellEditor(nf));

    ColumnModel cm = new ColumnModel(cols);

    teamSalesGrid = new EditorGrid<TeamSales>(store, cm);
    teamSalesGrid.getView().setForceFit(true);
    teamSalesGrid.getView().setShowDirtyCells(false);
    teamSalesGrid.addListener(Events.AfterEdit, new Listener<GridEvent<TeamSales>>() {
      public void handleEvent(GridEvent<TeamSales> be) {
        store.commitChanges();
      }
    });

    Button reload = new Button("Reload Team Sales Data");
    reload.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        store.removeAll();
        store.add(TestData.getTeamSales());
      }
    });

    RadioGroup rg = new RadioGroup();
    rg.setFieldLabel("Chart click");
    Radio edRadio = new Radio();
    edRadio.setBoxLabel("Edits Cell");
    rg.add(edRadio);
    selRadio = new Radio();
    selRadio.setValue(true);
    selRadio.setBoxLabel("Selects Cell");
    rg.add(selRadio);
    LayoutContainer radForm = new LayoutContainer(new FormLayout(LabelAlign.RIGHT));
    radForm.add(rg);

    LayoutContainer lc = new LayoutContainer();
    RowLayout rl = new RowLayout();
    lc.setLayout(rl);
    lc.setSize(800, 600);

    RowData data;
    data = new RowData(1, 300, new Margins(10));
    ContentPanel cp = new ContentPanel(new FitLayout());
    cp.setHeading("Chart");
    cp.add(chart);
    lc.add(cp, data);

    data = new RowData(1, 1, new Margins(10));
    cp = new ContentPanel(new FitLayout());
    cp.setHeading("Teams Sales");
    cp.add(teamSalesGrid);
    lc.add(cp, data);

    data = new RowData(1, 60, new Margins(10));
    LayoutContainer bbar = new LayoutContainer(new RowLayout(Orientation.HORIZONTAL));
    bbar.add(reload);
    bbar.add(radForm, new RowData(1, -1));
    lc.add(bbar, data);

    add(lc);

  }
}
