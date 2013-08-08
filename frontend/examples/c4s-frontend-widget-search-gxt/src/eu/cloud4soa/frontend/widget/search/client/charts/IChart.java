package eu.cloud4soa.frontend.widget.search.client.charts;

import java.util.List;

import com.extjs.gxt.charts.client.model.ChartModel;

public interface IChart {
	public void setCharModelAxes (List<List<ChartPoint>> chartValues, int numberHorizontalLabels, int numberVerticalLabels);
	public void addLineChart(List<ChartPoint>values, String color, String label);
	public ChartModel getChartModel();
}
