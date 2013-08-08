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

package eu.cloud4soa.frontend.commons.client.services.soa;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;

/**
*
* @author Yosu Gorroñogoitia (Atos)
*/
public interface MonitoringServiceAsync {
    public void startMonitoring(String applicationUriId, AsyncCallback<Void> callback);    
    public void stopMonitoring(String applicationUriId, AsyncCallback<Void> callback);  
    @Deprecated //UI should never invoke this method since it returns all statistics for given application, which can be high computational demanding
    public void getMonitoringStatistics(String applicationUriId, AsyncCallback<List<IMonitoringStatistic>> callback);    
    @Deprecated //UI should never invoke this method since it returns all statistics for given application for given time frame, which can be high computational demanding
    public void getMonitoringStatisticsWhithinRange(String applicationUriId, Date start, Date end, AsyncCallback<List<IMonitoringStatistic>> callback);    
    public void getMonitoringStatisticsWhithinRangeLimited(String applicationUriId, Date start, Date end, 
    		int maxResults, int monitoringMaxNumDisplayableValues, AsyncCallback<List<IMonitoringStatistic>> callback);
    public void getMonitoringStatisticsWhithinRangeLimited(List<String> applicationUriIds, Date start, Date end, 
    		int maxResults, int monitoringMaxNumDisplayableValues, AsyncCallback<Map<String, List<IMonitoringStatistic>>> callback);
}
