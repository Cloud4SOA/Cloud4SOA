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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.charts.PieChart;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;


public class ResponseCodePieChart implements IChart{

	Map<Integer, Double> rcStats = new HashMap<Integer, Double>();
	
	public ResponseCodePieChart(String applicationTitle, List<IMonitoringStatistic> stats) {
    	//Calculating RC percentages
		for (IMonitoringStatistic stat: stats){
			int rc = stat.getResponseCode();
			Double sum = rcStats.get(rc);
			if (sum == null){
				rcStats.put (rc, 1.0);
			}else{
				rcStats.put(rc, ++sum);
			}
		}
		//Normalizing
		int total = 0;
		for (Integer rc:rcStats.keySet()){
			total += rcStats.get(rc);
		}
		for (Integer rc:rcStats.keySet()){
			rcStats.put(rc, rcStats.get(rc)/total);
		}
	}

	public ChartModel getChartModel(String applicationTitle) {  
	      ChartModel cd = new ChartModel("Response Codes for " + applicationTitle, "font-size: 14px; font-family: Verdana;");  
	      cd.setBackgroundColour("#fffff0");  
	      PieChart pie = new PieChart();  
	      pie.setAlpha(0.5f);  
	      pie.setTooltip("#label#<br>#percent#");  
	      pie.setAnimate(false);  
	      pie.setAlphaHighlight(true);  
	      pie.setGradientFill(true);
	      
	      List<String> colours = new ArrayList<String>();
	      for (int i=0; i<rcStats.size(); i++){
	    	  colours.add(getColorCodes(i));
	      }
	      pie.setColours(colours);  
	      
	      for (Integer rc: rcStats.keySet()) {  
	        pie.addSlices(new PieChart.Slice(rcStats.get(rc), rc.toString()));  
	      }  
	      
	      cd.addChartConfig(pie);  
	      return cd;  
	} 
	
	@Override
	public String getColorCodes(int i) {
		return htmlColorCodes[i];
	}
}
