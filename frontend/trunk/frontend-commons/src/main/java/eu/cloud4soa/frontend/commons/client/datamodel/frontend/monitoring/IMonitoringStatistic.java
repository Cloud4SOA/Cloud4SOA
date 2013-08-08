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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring;

import java.util.Date;

/**
 * 
 * @author Denis Neuling (dn@cloudcontrol.de)
 */
public interface IMonitoringStatistic {
	
	/**
	 * (self-Explanatory) 
	 * The execution date of the poll. 
	 * 
	 * @return date
	 */
	Date getDate();
	
	/**
	 * (self-Explanatory) 
	 * The id of the concerning monitopringJob.
	 * 
	 * @return monitoringJobId the id of the concering monitoringJob.
	 */
	long getMonitoringJobId();
	
	/**
	 * (self-Explanatory) 
	 * The HTTP responseCode of the poll.
	 *  
	 * @return responseCode the HTTP response code
	 */
	int getResponseCode();
	
	/**
	 * (self-Explanatory) 
	 * The time in milliseconds the adapter needed to respond.
	 * 
	 * @return timemillis the milliseconds.
	 */
	long getResponseTime();
	
	/**
	 * A message.
	 * 
	 * @return message a message adapter, (e.g. database is down or something else) 
	 */
	String getMessage();
}
