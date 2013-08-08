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

package eu.cloud4soa.frontend.widget.monitoring.client.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;

public interface MonitoringView extends IsWidget{
	void setPresenter(Presenter presenter);
	
	//View specific methods to transfer data from the activity to the view
	void monitorApplications(List<ApplicationModel> apps, boolean alreadyMonitored);
	void activateMonitoring(boolean monitoringActivated);
	void renderMonitoringData(List<ApplicationModel> applications, Map<String, List<IMonitoringStatistic>> statistics);
	void stoppedMonitoring();
	void setMonitoredApplications(List<ApplicationModel> applications);
	void initializeWidget(boolean alreadyMonitored);

    public interface Presenter {
    	void goTo(Place place);
    	
        // Data service specific methods
        void getRTMonitoringStatistics(List<ApplicationModel> applicationUriIds);  
        void getMonitoringStatisticsWhithinRangeLimited(List<ApplicationModel> applicationUriIds, Date start, Date end);
        public int getMaxNumberMonitoringDisplayableValues();
        void stopRTMonitoring(); 
    }

}