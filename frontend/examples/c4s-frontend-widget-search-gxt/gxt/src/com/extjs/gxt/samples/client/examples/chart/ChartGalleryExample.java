/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.chart;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.ToolTip;
import com.extjs.gxt.charts.client.model.ToolTip.MouseStyle;
import com.extjs.gxt.charts.client.model.axis.Label;
import com.extjs.gxt.charts.client.model.axis.RadarAxis;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.AreaChart;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.CylinderBarChart;
import com.extjs.gxt.charts.client.model.charts.FilledBarChart;
import com.extjs.gxt.charts.client.model.charts.HorizontalBarChart;
import com.extjs.gxt.charts.client.model.charts.PieChart;
import com.extjs.gxt.charts.client.model.charts.SketchBarChart;
import com.extjs.gxt.charts.client.model.charts.BarChart.BarStyle;
import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.examples.model.ChartModelExample;
import com.extjs.gxt.samples.client.examples.model.GalleryChartModel;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SliderEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.SliderField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;

public class ChartGalleryExample extends LayoutContainer {

  private int updateSpeed = 1500;
  private int numSegments = 5;
  private Timer updater;
  private Command updateCmd;
  private ChartModelExample example = new AreaChartExample();

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    ContentPanel cp = new ContentPanel();
    cp.setHeading("Charts Gallery");
    cp.setFrame(true);
    cp.setSize(700, 350);
    cp.setLayout(new BorderLayout());

    BorderLayoutData eastData = new BorderLayoutData(LayoutRegion.EAST, 370);

    BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
    centerData.setMargins(new Margins(0, 5, 0, 0));

    cp.add(getChart(), centerData);
    cp.add(getDetails(), eastData);

    add(cp, new MarginData(20));

  }

  private LayoutContainer getDetails() {
    LayoutContainer lc = new LayoutContainer();
    VBoxLayout vLayout = new VBoxLayout();
    vLayout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
    lc.setLayout(vLayout);

    FieldSet controls = new FieldSet();
    controls.setHeading("Controls");
    FormLayout fl = new FormLayout();
    fl.setLabelWidth(125);
    controls.setLayout(fl);

    Slider segments = new Slider();
    segments.setMaxValue(12);
    segments.setMinValue(1);
    segments.setIncrement(1);
    segments.setValue(numSegments);
    segments.addListener(Events.Change, new Listener<SliderEvent>() {
      public void handleEvent(SliderEvent be) {
        numSegments = be.getNewValue();
        adjustUpdateSpeed(updateSpeed);
      }
    });
    SliderField segFld = new SliderField(segments);
    segFld.setFieldLabel("Segments (#)");
    controls.add(segFld);

    final Slider update = new Slider() {
      @Override
      protected String onFormatValue(int value) {
        if (value == 0) return "Off";
        return super.onFormatValue(value);
      }
    };
    update.setMinValue(0);
    update.setMaxValue(3000);
    update.setIncrement(100);
    update.setValue(updateSpeed);
    update.setMessage("{0}ms");
    update.addListener(Events.Change, new Listener<SliderEvent>() {
      public void handleEvent(SliderEvent se) {
        adjustUpdateSpeed(se.getNewValue());
      }
    });
    SliderField updFld = new SliderField(update);
    updFld.setFieldLabel("Update Interval (ms)");
    controls.add(updFld);

    lc.add(controls);

    FieldSet gallery = new FieldSet();
    gallery.setHeading("Gallery");
    gallery.setLayout(new FitLayout());

    ListStore<GalleryChartModel> store = new ListStore<GalleryChartModel>();
    store.add(new GalleryChartModel("Area", "area.gif", new AreaChartExample()));
    store.add(new GalleryChartModel("Pie", "pie.gif", new PieChartExample()));
    store.add(new GalleryChartModel("Filled Bar", "filled.gif", new FilledBarChartExample()));
    store.add(new GalleryChartModel("Bar - Glass", "barglass.gif", new BarGlassChartExample()));
    store.add(new GalleryChartModel("Bar - 3D", "bar3d.gif", new Bar3DChartExample()));
    store.add(new GalleryChartModel("Radar", "radar.gif", new RadarChartExample()));
    store.add(new GalleryChartModel("Horizontal Bar", "horizontalbar.gif", new HorizontalChartExample()));
    store.add(new GalleryChartModel("Cylinder", "cylinder.gif", new CylinderChartExample()));
    store.add(new GalleryChartModel("Sketch Bar", "sketchbar.gif", new SketchChartExample()));

    ListView<GalleryChartModel> view = new ListView<GalleryChartModel>() {
      @Override
      protected GalleryChartModel prepareData(GalleryChartModel model) {
        String s = model.get("name");
        model.set("shortName", Format.ellipse(s, 15));
        return model;
      }

    };
    view.setId("img-chooser-view");
    view.setTemplate(getTemplate(!Examples.isExplorer() ? "../../" : ""));
    view.setStore(store);
    view.setItemSelector("div.thumb-wrap");
    view.getSelectionModel().select(0, false);
    view.getSelectionModel().addListener(Events.SelectionChange,
        new Listener<SelectionChangedEvent<GalleryChartModel>>() {

          public void handleEvent(SelectionChangedEvent<GalleryChartModel> be) {
            example = be.getSelectedItem().getExample();
            adjustUpdateSpeed(updateSpeed);
          }

        });
    gallery.add(view, new FitData(0, 0, 20, 0));

    VBoxLayoutData vFlex = new VBoxLayoutData();
    vFlex.setFlex(1);
    lc.add(gallery, vFlex);
    return lc;
  }

  private LayoutContainer getChart() {
    FieldSet fs = new FieldSet();
    fs.setHeading("Chart");
    fs.setLayout(new FitLayout());

    String url = !Examples.isExplorer() ? "../../" : "";
    url += "gxt/chart/open-flash-chart.swf";

    final Chart chart = new Chart(url);
    chart.setBorders(true);
    fs.add(chart, new FitData(0, 0, 20, 0));
    updateCmd = new Command() {
      public void execute() {
        chart.setChartModel(example.getChartModel(numSegments));
      }
    };

    adjustUpdateSpeed(updateSpeed);
    return fs;
  }

  @Override
  protected void onAttach() {
    updater.scheduleRepeating(updateSpeed);
    super.onAttach();
  }

  @Override
  protected void onDetach() {
    updater.cancel();
    super.onDetach();
  }

  private void adjustUpdateSpeed(int newSpeed) {
    updateSpeed = newSpeed;
    updateCmd.execute();

    if (updater != null) updater.cancel();
    if (updateSpeed == 0) {
      return;
    }
    updater = new Timer() {
      public void run() {
        updateCmd.execute();
      }
    };
    updater.scheduleRepeating(updateSpeed);
  }

  private native String getTemplate(String base) /*-{
    return ['<tpl for=".">',  
    '<div class="thumb-wrap" id="{name}" style="border: 1px solid white">',  
    '<div class="thumb"><img src="' + base + 'samples/images/thumbs/charts/{path}" title="{name}"></div>',  
    '<span class="x-editable">{shortName}</span></div>',  
    '</tpl>',  
    '<div class="x-clear"></div>'].join("");
  }-*/;

  class PieChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cd = new ChartModel("Sales per Month", "font-size: 14px; font-family: Verdana;");
      cd.setBackgroundColour("#fffff0");
      PieChart pie = new PieChart();
      pie.setAlpha(0.5f);
      pie.setTooltip("#label# $#val#<br>#percent#");
      pie.setAnimate(false);
      pie.setAlphaHighlight(true);
      pie.setGradientFill(true);
      pie.setColours("#ff0000", "#00aa00", "#0000ff", "#ff9900", "#ff00ff");

      for (int n = 0; n < segments; n++) {
        pie.addSlices(new PieChart.Slice(Random.nextInt(110) * 100, TestData.getMonths()[n]));
      }
      cd.addChartConfig(pie);
      return cd;
    }
  }

  class AreaChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Growth per Region", "font-size: 14px; font-family: Verdana;");
      cm.setBackgroundColour("#ffffff");
      XAxis xa = new XAxis();
      xa.setLabels("J", "F", "M", "A", "M", "J", "J", "A", "S", "O", "N", "D");
      cm.setXAxis(xa);
      AreaChart area1 = new AreaChart();
      area1.setFillAlpha(0.3f);
      area1.setColour("#ff0000");
      area1.setFillColour("#ff0000");
      for (int n = 0; n < 12; n++) {
        if (n % 3 != 0 && n != 11)
          area1.addNullValue();
        else
          area1.addValues(n * Random.nextDouble());
      }
      cm.addChartConfig(area1);
      AreaChart area2 = new AreaChart();
      area2.setFillAlpha(0.3f);
      area2.setColour("#00aa00");
      area2.setFillColour("#00aa00");
      int floor = Random.nextInt(3);
      double grade = (Random.nextInt(4) + 1) / 10.0;
      for (int n = 0; n < 12; n++) {
        if (n % 2 != 0 && n != 11)
          area2.addNullValue();
        else
          area2.addValues(n * grade + floor);
      }
      cm.addChartConfig(area2);
      return cm;

    }
  }

  class FilledBarChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Sales by Month",
          "font-size: 16px; font-weight: bold; font-family: Verdana; color:#008800;");
      cm.setBackgroundColour("#eeffee");
      cm.setDecimalSeparatorComma(true);
      XAxis xa = new XAxis();
      xa.setLabels(TestData.getShortMonths(segments));
      xa.getLabels().setColour("#009900");
      xa.setGridColour("#eeffee");
      xa.setColour("#009900");
      cm.setXAxis(xa);
      YAxis ya = new YAxis();
      ya.setRange(5000, 20000);
      ya.setSteps(1000);
      ya.setGridColour("#eeffee");
      ya.setColour("#009900");
      cm.setYAxisLabelStyle(10, "#009900");
      cm.setYAxis(ya);
      FilledBarChart bchart = new FilledBarChart("#6666ff", "#000066");
      bchart.setTooltip("$#val#");
      for (int t = 0; t < segments; t++) {
        bchart.addValues(Random.nextInt(5000) + 10000);
      }
      cm.addChartConfig(bchart);
      return cm;
    }
  }

  class BarGlassChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Sales by Month 2007", "font-size: 14px; font-family: Verdana;");
      cm.setBackgroundColour("-1");
      XAxis xa = new XAxis();
      for (String m : TestData.getMonths()) {
        Label l = new Label(m, 45);
        l.setSize(10);
        l.setColour("#000000");
        xa.addLabels(l);
      }
      xa.setGridColour("-1");
      cm.setXAxis(xa);
      YAxis ya = new YAxis();
      ya.setSteps(16);
      ya.setMax(160);
      ya.setGridColour("#8888FF");
      cm.setYAxis(ya);
      BarChart bchart = new BarChart(BarStyle.GLASS);
      bchart.setColour("#FF00CC");
      bchart.setTooltip("$#val#");
      for (int t = 0; t < 12; t++) {
        if (t == segments - 1) {
          bchart.addBars(new BarChart.Bar(Random.nextInt(50) + 50, "#8888FF"));
        } else {
          bchart.addValues(Random.nextInt(50) + 50);
        }
      }
      cm.addChartConfig(bchart);
      return cm;
    }
  }

  class Bar3DChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Sales by Month 2008", "font-size: 14px; font-family: Verdana; color:#ffff00;");
      cm.setBackgroundColour("#000077");
      XAxis xa = new XAxis();
      xa.setLabels(TestData.getShortMonths(segments));
      xa.getLabels().setColour("#ffff00");
      xa.setGridColour("-1");
      xa.setColour("#aa5500");
      xa.setZDepth3D(5);
      cm.setXAxis(xa);
      YAxis ya = new YAxis();
      ya.setSteps(16);
      ya.setMax(160);
      ya.setGridColour("#000099");
      ya.setColour("#ffff00");
      cm.setYAxis(ya);
      cm.setYAxisLabelStyle(10, "#ffff00");
      BarChart bchart = new BarChart(BarStyle.THREED);
      bchart.setColour("#CC6600");
      bchart.setTooltip("$#val#");
      for (int t = 0; t < segments; t++) {
        bchart.addValues(Random.nextInt(50) + 50);
      }
      cm.addChartConfig(bchart);
      return cm;
    }
  }

  class RadarChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Popularity", "font-size: 12px; text-align: left;");
      cm.setBackgroundColour("#f0f0f0");
      RadarAxis ra = new RadarAxis();
      ra.setMax(segments + 1);
      ra.setStroke(2);
      ra.setColour("#A1D4B5");
      ra.setGridColour("#C0DEBF");
      ra.setSpokeLabels("Ext", "Web", "Java", "AJAX", "PHP");
      cm.setRadarAxis(ra);
      AreaChart area = new AreaChart();
      area.setFillAlpha(0.3f);
      area.setColour("#ff9900");
      area.setFillColour("#ff6600");
      area.setLoop(true);
      area.addValues(segments);
      area.addValues(Random.nextInt(segments + 1));
      area.addValues(Random.nextInt(segments + 1));
      area.addValues(Random.nextInt(segments + 1));
      area.addValues(Random.nextInt(segments + 1));
      cm.addChartConfig(area);
      return cm;
    }
  }

  class HorizontalChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Voted Best AJAX Framework",
          "font-size: 14px; font-family: Verdana; text-align: center;");
      XAxis xa = new XAxis();
      xa.setRange(0, 200, 50);
      cm.setXAxis(xa);
      YAxis ya = new YAxis();
      ya.addLabels("Ext", "Dojo", "jQuery", "YUI");
      ya.setOffset(true);
      cm.setYAxis(ya);
      HorizontalBarChart bchart = new HorizontalBarChart();
      bchart.setTooltip("#val# mph");
      bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(47) + 100, "#ffff00"));
      bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(44) + 100, "#0000ff"));
      bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(23) + 100, "#00ff00"));
      bchart.addBars(new HorizontalBarChart.Bar(Random.nextInt(50) + 150, "#ff0000"));
      cm.addChartConfig(bchart);
      cm.setTooltipStyle(new ToolTip(MouseStyle.FOLLOW));
      return cm;
    }
  }

  class CylinderChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Licenses by Quarter 2008",
          "font-size: 14px; font-family: Verdana; text-align: center;");
      cm.setBackgroundColour("#ffffff");
      XAxis xa = new XAxis();
      xa.setLabels("Q1", "Q2", "Q3", "Q4");
      xa.setZDepth3D(5);
      xa.setTickHeight(4);
      xa.setOffset(true);
      xa.setColour("#909090");
      cm.setXAxis(xa);
      YAxis ya = new YAxis();
      ya.setSteps(16);
      ya.setMax(160);
      cm.setYAxis(ya);
      CylinderBarChart bchart = new CylinderBarChart();
      bchart.setColour("#440088");
      bchart.setAlpha(.8f);
      bchart.setTooltip("$#val#");
      for (int t = 0; t < 4; t++) {
        if ((t + 1) == (Math.ceil(segments / 3.0))) {
          bchart.addBars(new BarChart.Bar(Random.nextInt(50) + 50, "#aa88ff"));
        } else {
          bchart.addValues(Random.nextInt(50) + 50);
        }
      }
      cm.addChartConfig(bchart);
      return cm;
    }
  }

  class SketchChartExample implements ChartModelExample {
    public ChartModel getChartModel(int segments) {
      ChartModel cm = new ChartModel("Smartest kid at school!", "font-size: 14px; font-family: Verdana;");
      cm.setBackgroundColour("#ffffff");
      XAxis xa = new XAxis();
      xa.setLabels("John", "Frank", "Mary", "Alec", "Mike", "James");
      cm.setXAxis(xa);
      SketchBarChart sketch = new SketchBarChart("#00aa00", "#009900", 6);
      sketch.setTooltip("#val# points");
      sketch.addValues(Random.nextInt(6) + 1, Random.nextInt(5) + 1, Random.nextInt(3) + 1);
      SketchBarChart.SketchBar skb = new SketchBarChart.SketchBar(Random.nextInt(5) + 5);
      skb.setColour("#6666ff");
      skb.setTooltip("Winner!<br>#val# points");
      sketch.addBars(skb);
      sketch.addValues(Random.nextInt(5) + 1, Random.nextInt(5) + 1);
      cm.addChartConfig(sketch);
      return cm;
    }
  }
}
