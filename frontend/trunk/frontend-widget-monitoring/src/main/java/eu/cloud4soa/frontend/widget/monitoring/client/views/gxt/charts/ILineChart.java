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

import java.util.List;
import java.util.Map;

import com.extjs.gxt.charts.client.model.ChartModel;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;

public interface ILineChart extends IChart{
	public List<List<ChartPoint>> setCharModelAxes (Map<String, List<IMonitoringStatistic>> statistics, int numberHorizontalLabels, int numberVerticalLabels);
	public void addLineChart(List<ChartPoint>values, String color, String label);
	public ChartModel getChartModel();
}
