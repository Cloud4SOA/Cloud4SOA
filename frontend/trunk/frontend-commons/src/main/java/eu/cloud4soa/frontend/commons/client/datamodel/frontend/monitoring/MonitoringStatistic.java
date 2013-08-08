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

import java.io.Serializable;
import java.util.Date;


/** 
 * Statistic object with metrics
 * 
 * @author denisneuling (dn@cloudcontrol.de)
 * @author yosu (jesus.gorronogoitia@atosresearch.eu) Adaptation to GWT
 */
public class MonitoringStatistic extends AbstractModel<MonitoringStatistic> implements IMonitoringStatistic, Serializable{
	private static final long serialVersionUID = -3343340281569961762L;

	private long id;
	private long monitoringJobId;
	private Date date;
	private long responseTime;
	private int responseCode;
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getMonitoringJobId() {
		return monitoringJobId;
	}

	public void setMonitoringJobId(long monitoringJobId) {
		this.monitoringJobId = monitoringJobId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		return "MonitoringStatistic [id=" + id + ", monitoringJobId=" + monitoringJobId + ", date=" + date + ", responseTime=" + responseTime
				+ ", responseCode=" + responseCode + ", message=" + message + "]";
	}
}
