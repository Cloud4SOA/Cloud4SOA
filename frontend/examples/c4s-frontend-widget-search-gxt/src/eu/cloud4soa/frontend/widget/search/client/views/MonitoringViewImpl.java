package eu.cloud4soa.frontend.widget.search.client.views;
import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.charts.AreaChart;
import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.examples.model.ChartModelExample;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SliderEvent;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
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
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
  
public class MonitoringViewImpl extends LayoutContainer {
	public MonitoringViewImpl() {
	}  
  
  private int updateSpeed = 1500;  
  private int numSegments = 5;  
  private Timer updater;  
  private Command updateCmd;  
  private ChartModelExample example = new AreaChartExample();  
  
  @Override  
  protected void onRender(Element parent, int index) {  
    super.onRender(parent, index);  
    ContentPanel cp = new ContentPanel();  
    cp.setHeading("Monitoring View");  
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

    return lc;  
  }  
  
  private LayoutContainer getChart() {  
    FieldSet fs = new FieldSet();  
    fs.setHeading("Response Time");  
    fs.setLayout(new FitLayout());  
  
    String url = !Examples.isExplorer() ? "../../" : "";  
    url += "resources/chart/open-flash-chart.swf";  
  
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
  
//  private native String getTemplate(String base) /*-{ 
//    return ['<tpl for=".">',   
//    '<div class="thumb-wrap" id="{name}" style="border: 1px solid white">',   
//    '<div class="thumb"><img src="' + base + 'samples/images/thumbs/charts/{path}" title="{name}"></div>',   
//    '<span class="x-editable">{shortName}</span></div>',   
//    '</tpl>',   
//    '<div class="x-clear"></div>'].join(""); 
//  }-*/;  
  
  
  class AreaChartExample implements ChartModelExample {  
    public ChartModel getChartModel(int segments) {  
      ChartModel cm = new ChartModel("Response Time", "font-size: 14px; font-family: Verdana;");  
      cm.setBackgroundColour("#ffffff");  
      XAxis xa = new XAxis();  
      xa.setLabels("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");  
      cm.setXAxis(xa);  
      AreaChart area1 = new AreaChart();  
      area1.setFillAlpha(0f);  
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
      area2.setFillAlpha(0f);  
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
 
}  