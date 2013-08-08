/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.widget.monitoring.client.views.gxt.charts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.LineChart;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;

public class ChartImpl implements ILineChart {

	private ChartModel cm;
	private int maxNumberMonitoringStatisticSamples;

	public ChartImpl(String title, int maxNumberMonitoringStatisticSamples) {
		this.maxNumberMonitoringStatisticSamples = maxNumberMonitoringStatisticSamples;
		cm = new ChartModel(title, "font-size: 12px; font-family: Verdana;");
		cm.setBackgroundColour("#ffffff");

		// LEYEND
		Legend legend = new Legend(Position.TOP, true);
		legend.setPadding(10);
		cm.setLegend(legend);
	}

	@Override
	public ChartModel getChartModel() {
		return cm;
	}

	@Override
	public List<List<ChartPoint>> setCharModelAxes(
			Map<String, List<IMonitoringStatistic>> statistics,
			int numberHorizontalLabels, int numberVerticalLabels) {
		// AXIS
		// FIXME (Assumed all charts have the same horizontal values, which may
		// not be true)
		List<List<ChartPoint>> chartValues = getChartValues(statistics);
		if (chartValues.size() == 0)
			return chartValues; // No values to set axes.

		XAxis xa = new XAxis();

		if (chartValues.get(0).size() < numberHorizontalLabels) // Recalculating
																// the number of
																// x axis labels
			numberHorizontalLabels = chartValues.get(0).size();
		List<String> xAxisLabels = getXAxisLabels(chartValues.get(0),
				numberHorizontalLabels);
		xa.setLabels(xAxisLabels);
		int deltax = chartValues.get(0).size() / (numberHorizontalLabels - 1);
		xa.setSteps(deltax);

		cm.setXAxis(xa);

		YAxis ya = new YAxis();
		double minY = getYMinForMultipleCharts(chartValues);
		double maxY = getYMaxForMultipleCharts(chartValues);

		List<String> yAxisLabels = getYAxisLabels(minY, maxY,
				numberVerticalLabels);
		ya.setLabels(yAxisLabels);
		double deltay = (maxY - minY) / (numberVerticalLabels - 1);
		ya.setSteps(deltay);

		// Set Y axis range [min, max]
		ya.setRange(minY, maxY);

		cm.setYAxis(ya);
		return chartValues;
	}

	@Override
	public void addLineChart(List<ChartPoint> values, String color, String label) {
		LineChart graph = new LineChart();
		graph.setText(label);
		graph.setColour(color);

		for (ChartPoint value : values) {
			graph.addValues(value.getY());
		}
		cm.addChartConfig(graph);
	}

	// public ChartModel getChartModel(String title, Map<String,
	// List<IMonitoringStatistic>> statistics) {
	// ChartModel cm = new ChartModel(title,
	// "font-size: 12px; font-family: Verdana;");
	// cm.setBackgroundColour("#ffffff");
	//
	// //FIXME Currently using first application statistics to obtain labels and
	// axis ranges
	// List<ChartPoint> values =
	// getChartValues(statistics.values().iterator().next());
	// if (values.size() != 0){
	//
	// XAxis xa = new XAxis();
	// List<String> xAxisLabels = getXAxisLabels(values);
	// xa.setLabels(xAxisLabels);
	// cm.setXAxis(xa);
	//
	// YAxis ya = new YAxis();
	// // List<String> yAxisLabels = getYAxisLabels(values);
	// // ya.setLabels(yAxisLabels);
	//
	// ya.setMin(getYAxisMin(values));
	// ya.setMax(getYAxisMax(values));
	//
	// //In case of horizontal graph = all values are the same ones
	// if (ya.getMin() == ya.getMax()){
	// ya.setMin(ya.getMin().doubleValue() - 1);
	// ya.setMax(ya.getMax().doubleValue() + 1);
	// }
	// cm.setYAxis(ya);
	// }
	//
	// // cm.setXLegend(new Text("date(hh:mm:ss)"));
	// // cm.setYLegend(new Text("RT(ms)"));
	//
	// int iColor = 0;
	// for (List<IMonitoringStatistic> stats: statistics.values()){
	// values = getChartValues(stats);
	//
	// LineChart graph = new LineChart();
	// graph.setColour(htmlColorCodes[iColor++]); //FIXME limited number of
	// available colors
	//
	// for (ChartPoint value : values) {
	// graph.addValues(value.getY());
	// }
	//
	// cm.addChartConfig(graph);
	// }
	// return cm;
	//
	// }

	private List<ChartPoint> getChartValues(
			List<IMonitoringStatistic> statistics) {
		List<ChartPoint> values = new ArrayList<ChartPoint>();
		// FIXME: , int maxNumberMonitoringStatisticSamples

		// Displaying the last RTCHART_MAX_NUM_DISPLAYABLE_VALUES
		DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyy HH:mm:ss");
		int start = statistics.size() - maxNumberMonitoringStatisticSamples;
		if (start < 0) {
			start = 0;
		}
		for (int i = start; i < statistics.size(); i++) {
			IMonitoringStatistic statistic = statistics.get(i);
			values.add(new ChartPoint(fmt.format(statistic.getDate()),
					statistic.getResponseTime()));
		}
		return values;
	}

	private List<List<ChartPoint>> getChartValues(
			Map<String, List<IMonitoringStatistic>> statistics) {
		List<List<ChartPoint>> result = new ArrayList<List<ChartPoint>>();

		for (List<IMonitoringStatistic> stats : statistics.values()) {
			result.add(getChartValues(stats));
		}

		return result;
	}

	// private double getMaxValue(List<Double> numbers){
	// double maxValue = numbers.get(0);
	// for(int i=1;i < numbers.size();i++){
	// if(numbers.get(i) > maxValue){
	// maxValue = numbers.get(i);
	// }
	// }
	// return maxValue;
	// }
	//
	// private double getMinValue(List<Double> numbers){
	// double minValue = numbers.get(0);
	// for(int i=1;i<numbers.size();i++){
	// if(numbers.get(i)< minValue){
	// minValue = numbers.get(i);
	// }
	// }
	// return minValue;
	// }

	private double getYMinForMultipleCharts(List<List<ChartPoint>> values) {
		double result = Double.POSITIVE_INFINITY;
		for (List<ChartPoint> vals : values) {
			if (vals.isEmpty())
				continue;
			double min = getYMin(vals);
			if (min < result)
				result = min;
		}
		return result;
	}

	private double getYMaxForMultipleCharts(List<List<ChartPoint>> values) {
		double result = Double.NEGATIVE_INFINITY;
		for (List<ChartPoint> vals : values) {
			if (vals.isEmpty())
				continue;
			double max = getYMax(vals);
			if (max > result)
				result = max;
		}
		return result;
	}

	// private List<String> getXAxisLabels(List<ChartPoint> values) {
	// // NumberFormat fmt = NumberFormat.getFormat("###.#");
	// List<String> xValues = new ArrayList<String>();
	// for (ChartPoint value : values) {
	// xValues.add(value.getX());
	// }
	// return xValues;
	// }

	private List<String> getXAxisLabels(List<ChartPoint> values,
			int maxNumberLabels) {
		List<String> xValues = new ArrayList<String>();
		if (values.isEmpty())
			return xValues;

		int delta = values.size() / (maxNumberLabels - 1);
		int i = 0;
		for (ChartPoint value : values) {
			if (i % delta == 0)
				xValues.add(value.getX());
			else
				xValues.add("");
			i++;
		}
		return xValues;
	}

	private List<String> getYAxisLabels(double minY, double maxY,
			int maxNumberLabels) {
		NumberFormat fmt = NumberFormat.getFormat("###.#");
		List<String> yValues = new ArrayList<String>();
		double delta = (maxY - minY) / (maxNumberLabels - 1);
		double label = minY;

		int i = 0;
		while (label <= (maxY + delta) && i < maxNumberLabels) {
			yValues.add(fmt.format(Math.round(label)));
			label += delta;
			i++;
		}

		return yValues;
	}

	// private List<String> getYAxisLabels(List<ChartPoint> values) {
	// NumberFormat fmt = NumberFormat.getFormat("###.#");
	// List<String> yAxisValues = new ArrayList<String>();
	// List<Double> yValues = new ArrayList<Double>();
	// for (ChartPoint value : values) {
	// yValues.add(value.getY());
	// }
	//
	// double minval = getMinValue(yValues);
	// double maxval = getMaxValue(yValues);
	//
	// double delta = (maxval - minval)/(yValues.size()-1);
	//
	// for (double y = minval; y<=maxval; y+=delta) {
	// yAxisValues.add(fmt.format(y));
	// }
	// return yAxisValues;
	// }

	// private double getYAxisMin(List<ChartPoint> values) {
	// List<Double> yValues = new ArrayList<Double>();
	// for (ChartPoint value : values) {
	// yValues.add(value.getY());
	// }
	//
	// return getMinValue(yValues);
	// }
	//
	// private double getYAxisMax(List<ChartPoint> values) {
	// List<Double> yValues = new ArrayList<Double>();
	// for (ChartPoint value : values) {
	// yValues.add(value.getY());
	// }
	//
	// return getMaxValue(yValues);
	// }

	private double getYMax(List<ChartPoint> values) {
		double max = values.get(0).getY();
		for (ChartPoint cp : values) {
			if (cp.getY() > max)
				max = cp.getY();
		}
		return max;
	}

	private double getYMin(List<ChartPoint> values) {
		double min = values.get(0).getY();
		for (ChartPoint cp : values) {
			if (cp.getY() < min)
				min = cp.getY();
		}
		return min;
	}

	@Override
	public String getColorCodes(int i) {
		return htmlColorCodes[i];
	}
}