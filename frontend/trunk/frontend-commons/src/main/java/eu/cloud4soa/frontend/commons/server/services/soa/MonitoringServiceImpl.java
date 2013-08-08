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

package eu.cloud4soa.frontend.commons.server.services.soa;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.MonitoringStatistic;
import eu.cloud4soa.frontend.commons.client.services.soa.MonitoringService;
import eu.cloud4soa.soa.MonitoringModule;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@SuppressWarnings({ "GwtServiceNotRegistered" })
@Secured("IS_AUTHENTICATED_FULLY")
public class MonitoringServiceImpl extends RemoteServiceServlet implements
		MonitoringService {
	final Logger logger = LoggerFactory.getLogger(MonitoringServiceImpl.class);

    @Qualifier("soaMonitoringModule")
    @Autowired
	private MonitoringModule monitoringModule;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				config.getServletContext());
	}

	@Override
	public void startMonitoring(String applicationUriId) {
		logger.debug("Starting monitoring for application " + applicationUriId);

		try {
			monitoringModule.startMonitoring(applicationUriId);
		} catch (SOAException e) {
			String msg = "Error in startMonitoring for application "
					+ applicationUriId;
			logger.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}

	@Override
	public void stopMonitoring(String applicationUriId) {
		logger.debug("Stopping monitoring for application " + applicationUriId);

		try {
			monitoringModule.stopMonitoring(applicationUriId);
		} catch (SOAException e) {
			String msg = "Error in stopMonitoring for application "
					+ applicationUriId;
			logger.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}

	@Override
	public List<IMonitoringStatistic> getMonitoringStatistics(
			String applicationUriId) {
		logger.debug("Getting monitoring statistics for application "
				+ applicationUriId);

		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistic;
		try {
			monitoringStatistic = monitoringModule
					.getMonitoringStatistics(applicationUriId);
			return translateMonitoringStatistic(monitoringStatistic);
		} catch (SOAException e) {
			String msg = "Error in getMonitoringStatistics for application "
					+ applicationUriId;
			logger.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}

	@Override
	public List<IMonitoringStatistic> getMonitoringStatisticsWhithinRange(
			String applicationUriId, Date start, Date end) {
		logger.debug("Getting monitoring statistics for application "
				+ applicationUriId + " between dates " + start.toString()
				+ " and " + end.toString());

		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistic;
		try {
			monitoringStatistic = monitoringModule
					.getMonitoringStatisticsWhithinRange(applicationUriId,
							start, end);
			return translateMonitoringStatistic(monitoringStatistic);
		} catch (SOAException e) {
			String msg = "Error in getMonitoringStatisticsWhithinRange for application "
					+ applicationUriId;
			logger.error(msg, e);
			throw new RuntimeException(msg, e);
		}

	}

	@Override
	public List<IMonitoringStatistic> getMonitoringStatisticsWhithinRangeLimited(
			String applicationUriId, Date start, Date end, int maxResults,
			int monitoringMaxNumDisplayableValues) {
		logger.debug("Getting monitoring statistics for application "
				+ applicationUriId + " between dates " + start.toString()
				+ " and " + end.toString() + " with maxResults " + maxResults);

		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistics;
		try {
			monitoringStatistics = monitoringModule
					.getMonitoringStatisticsWhithinRangeLimited(
							applicationUriId, start, end, maxResults);

			// Invert (time scale).
			monitoringStatistics = invertTimeScale(monitoringStatistics);

			// Filtering not valid statistics
			monitoringStatistics = filterNotValidStatistics(monitoringStatistics);

			// Resampling statistics
			monitoringStatistics = resamplingStatistics(monitoringStatistics,
					monitoringMaxNumDisplayableValues);

			return translateMonitoringStatistic(monitoringStatistics);
		} catch (SOAException e) {
			String msg = "Error in getMonitoringStatisticsWhithinRangeLimited for application "
					+ applicationUriId;
			logger.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}

	private List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> resamplingStatistics(
			List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistics,
			int monitoringMaxNumDisplayableValues) {

		if (monitoringStatistics.size() <= monitoringMaxNumDisplayableValues)
			return monitoringStatistics; // Resampling not required

		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> result = new ArrayList<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic>();

		float delta = (float) monitoringStatistics.size()
				/ (float) monitoringMaxNumDisplayableValues;
		float i = 0;
		while (i < monitoringStatistics.size()) {
			result.add(monitoringStatistics.get((int) Math.round(Math.floor(i))));
			i += delta;
		}

		return result;
	}

	/**
	 * Monitoring module offers monitoring statistics in time reverse order (for
	 * presentation), newest times before. This method reverts the time scale,
	 * starting with oldest times.
	 * 
	 * @param monitoringStatistics
	 * @return
	 */
	private List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> invertTimeScale(
			List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistics) {
		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> result = new ArrayList<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic>();

		for (int i = monitoringStatistics.size() - 1; i >= 0; i--)
			result.add(monitoringStatistics.get(i));

		return result;
	}

	@Override
	public Map<String, List<IMonitoringStatistic>> getMonitoringStatisticsWhithinRangeLimited(
			List<String> applicationUriIds, Date start, Date end,
			int maxResults, int monitoringMaxNumDisplayableValues) {
		logger.debug("Getting monitoring statistics for selected applications"
				+ " between dates " + start.toString() + " and "
				+ end.toString() + " with maxResults " + maxResults);

		Map<String, List<IMonitoringStatistic>> results = new HashMap<String, List<IMonitoringStatistic>>();
		for (String applicationUriId : applicationUriIds) {
			results.put(
					applicationUriId,
					getMonitoringStatisticsWhithinRangeLimited(
							applicationUriId, start, end, maxResults,
							monitoringMaxNumDisplayableValues));
		}

		return results;
	}

	private List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> filterNotValidStatistics(
			List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistics) {
		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> statistics = new ArrayList<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic>();

		for (eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic statistic : monitoringStatistics) {
			// Filtering on valid response times
			if (statistic.getResponseTime() >= 0) {
				statistics.add(statistic);
			}
		}

		return statistics;
	}

	private List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> cutDown(
			List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistics,
			int maxResults) {
		int size = monitoringStatistics.size();
		List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> statistics = new ArrayList<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic>();
		for (int i = maxResults; i > 0; i--) {
			statistics.add(monitoringStatistics.get(size - i));
		}
		return statistics;
	}

	public List<IMonitoringStatistic> translateMonitoringStatistic(
			List<eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic> monitoringStatistics) {
		List<IMonitoringStatistic> lms = new ArrayList<IMonitoringStatistic>();
		for (eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic monitoringStatistic : monitoringStatistics) {
			MonitoringStatistic ms = new MonitoringStatistic();
			ms.setDate(monitoringStatistic.getDate());
			ms.setMessage(monitoringStatistic.getMessage());
			ms.setMonitoringJobId(monitoringStatistic.getMonitoringJobId());
			ms.setResponseCode(monitoringStatistic.getResponseCode());
			ms.setResponseTime(monitoringStatistic.getResponseTime());
			lms.add(ms);
		}

		return lms;
	}

}
