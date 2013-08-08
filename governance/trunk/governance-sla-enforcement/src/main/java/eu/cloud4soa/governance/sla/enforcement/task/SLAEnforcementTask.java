/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.cloud4soa.governance.sla.enforcement.task;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.cloud4soa.api.datamodel.governance.SlaTemplate.ServiceGuaranteeType;
import eu.cloud4soa.api.governance.monitoring.IMonitoringStatistic;
import eu.cloud4soa.governance.monitoring.MonitoringModule;
import eu.cloud4soa.relational.datamodel.ApplicationInstance;
import eu.cloud4soa.relational.datamodel.Breach;
import eu.cloud4soa.relational.datamodel.GuaranteeTerm;
import eu.cloud4soa.relational.datamodel.ISLAEnforcementJob;
import eu.cloud4soa.relational.datamodel.SLAContract;
import eu.cloud4soa.relational.datamodel.SLAViolation;
import eu.cloud4soa.relational.persistence.ApplicationInstanceRepository;
import eu.cloud4soa.relational.persistence.BreachRepository;
import eu.cloud4soa.relational.persistence.RecoveryActionRepository;
import eu.cloud4soa.relational.persistence.SLAContractRepository;
import eu.cloud4soa.relational.persistence.SLAViolationRepository;


public class SLAEnforcementTask extends TimerTask implements Runnable{
	final Logger logger = LoggerFactory.getLogger(getClass());

	private BreachRepository	          breach_repository;
	private SLAViolationRepository        slaViolationRepository;
	private RecoveryActionRepository      recoveryActionRepository;	
	private ApplicationInstanceRepository applicationInstanceRepository;
	private SLAContractRepository         slaContractRepository;
	private ISLAEnforcementJob 	          slaEnforcementJob;
	private MonitoringModule 	          monitoringModule;
	private SLAContract			          slaContract;
	
	private Date called;
	
	private HashMap<ServiceGuaranteeType, ArrayList <Long>> violations;
		
	/*TODO Temporal solution until agreement of what type to use*/
	/* The good */
	private ApplicationInstance persistedApplicationInstance;
	/* The bad and the ugly */
	private eu.cloud4soa.api.datamodel.core.ApplicationInstance apiApplicationInstance;
	
	/*
	 * applicationInstance  = this.applicationProfilesRepository.getApplicationInstance(applicationUriId);
	 * */
	
	
	public SLAEnforcementTask(SLAViolationRepository   slaViolationRepository,
							  RecoveryActionRepository recoveryActionRepository,
							  ApplicationInstanceRepository applicationInstanceRepository,
							  SLAContractRepository    slaContractRepository,
							  ISLAEnforcementJob       slaEnforcementJob,
							  MonitoringModule         monitoringModule){
		this.recoveryActionRepository = recoveryActionRepository;
		this.slaEnforcementJob        = slaEnforcementJob;
		this.slaViolationRepository   = slaViolationRepository;
		this.applicationInstanceRepository = applicationInstanceRepository;
		this.slaContractRepository    = slaContractRepository;
		this.monitoringModule         = monitoringModule;
		this.violations				  =
				new HashMap<ServiceGuaranteeType, ArrayList<Long>>();
		
		/*TODO There could be more than one application instance per uri id?*/
		this.persistedApplicationInstance = applicationInstanceRepository.findByUriId(slaEnforcementJob.getApplicationInstanceUriId()).get(0);
		
		/*TODO Temporal solution until agreement of what type to use*/
		apiApplicationInstance = toApiApplicationInstance(persistedApplicationInstance);
	}

	@Override
	public void run() {
		called = new Date();
		
		// //TODO: hardcoding the SLA metrics for now, need to make these parameters fields, or incoming parameters to this method, perhaps after integrating with SLA templates
		int expectedResponseCode = 200;
		int expectedResponseTime = 200;
		int expectedResponseCodeCompliancePercentage = 99;
		int expectedResponseTimeCompliancePercentage = 80;
		
		//TODO: externalize this interval setting (use something like eu.cloud4soa.governance.slaenforcement.poll.interval.seconds from properties)
		// int slaEnforcementCheckInterval =  18000000; // 30 mins in milliseconds  
		int slaEnforcementCheckInterval = 30000; // Setting it to 30 secs for now for testing purposes
		
		//Get the SLAContract
		slaContract = slaContractRepository.retrieveAll(Long.parseLong(slaEnforcementJob.getSlaContractId())).get(0);
		
		//TODO: there might be a better way to do these time intervals
		Date end = new Date();
		Date start = new Date(end.getTime() - slaEnforcementCheckInterval ); 
		List<IMonitoringStatistic> stats =
				monitoringModule.getMonitoringStatisticsWhithinRange(apiApplicationInstance.getUriId(), start, end);
		
		// find the number of all the non-compliant calls
		int size = stats.size();		
		if (size > 0) {
			int numResponseCodeViolations = 0;
			int numResponseTimeViolations = 0;
			Iterator<IMonitoringStatistic> iterator = stats.iterator();
			while (iterator.hasNext()) {
				IMonitoringStatistic stat = iterator.next();			
				if (stat.getResponseCode() != expectedResponseCode) {
					numResponseCodeViolations ++;
				}	
				if (stat.getResponseTime() > expectedResponseTime) {
					numResponseTimeViolations ++;
				}			
			}
			
			//check the percentage of violations for ResponseCode
			float responseCodeCompliancePercentage =
					(size-numResponseCodeViolations)/size * 100 ;
			if (responseCodeCompliancePercentage < expectedResponseCodeCompliancePercentage) {
				createandStoreSLAViolation("ResponseCode",
										   expectedResponseCodeCompliancePercentage,
										   responseCodeCompliancePercentage);
			}		
			
			//check the percentage of violations for ResponseTime
			float responseTimeCompliancePercentage =
					(size-numResponseTimeViolations)/size * 100 ;
			if (responseTimeCompliancePercentage < expectedResponseTimeCompliancePercentage) {
				createandStoreSLAViolation("ResponseTime",
										   expectedResponseTimeCompliancePercentage,
										   responseTimeCompliancePercentage);		
			}
			
			//log the findings even if there aren't any violations
			logFindings("ResponseCode",
						expectedResponseCodeCompliancePercentage,
						responseCodeCompliancePercentage);
			logFindings("ResponseTime",
					    expectedResponseTimeCompliancePercentage,
					    responseTimeCompliancePercentage);
		}
	}
	
	private void createandStoreSLAViolation(String metricName,
											int    expectedValue,
											float  actualValue) {
		SLAViolation violation = new SLAViolation(persistedApplicationInstance.getUriID(),
												  metricName,
												  expectedValue,
												  actualValue);
		violation.setDateAndTime(called);
		violation.setSLAEnforcementJobId(slaEnforcementJob.getId());
		slaViolationRepository.store(violation);
		//TODO: switch print out with logger after development    
		//logger.debug("SLAEnforcementTask found: " + violation);
		System.out.println("SLAEnforcementTask found: " + violation);
	}
	
	private void logFindings (String metricName,int expectedValue, float actualValue)  {
		//TODO: switch print out with logger after development
		//logger.debug("SLAEnforcementTask stats for" + metricName + ": Expected " + expectedValue + " percent compliance, found " + actualValue + " percent compliance");
		System.out.println("SLAEnforcementTask stats for" + metricName +
						   ": Expected " + expectedValue +
						   " percent compliance, found " + actualValue +
						   " percent compliance");
	}
	
	private void checkViolationsInPeriod (List <IMonitoringStatistic> stats,
										  ApplicationInstance		  application_instance,
										  SLAContract 				  sla_contract,
										  int 						  sla_enf_interval) {
		ArrayList <Long> new_times;
		ArrayList <Long> old_times;
		SLAViolation     violation;
		String			 ownerId = persistedApplicationInstance.getAccount().getUser().getUriID();
		
		for (GuaranteeTerm term : sla_contract.getGuaranteeTerms()) {
			for (IMonitoringStatistic stat : stats) {
				switch (stringToGTTypeEnum(term.getKpiName())) {
						case LATENCY:
							if (stat.getResponseTime() >
								Long.parseLong(term.getCustomServiceLevel())) {
								storeBreach(stat.getDate(),
											ownerId,
											term.getKpiName(),
											String.valueOf(stat.getResponseTime()));
							}
						case UPTIME:
							if (stat.getResponseTime() >
								Long.parseLong(term.getCustomServiceLevel())) {
								storeBreach(stat.getDate(),
											ownerId,
											term.getKpiName(),
											String.valueOf(stat.getResponseTime()));
							}
						default:
							System.out.println("Error, unrecognized service " +
											   "guarantee term: " + term.getKpiName());
				}
			}
		}
	}
	
	private ServiceGuaranteeType stringToGTTypeEnum(String string) {
		for (ServiceGuaranteeType sgt : ServiceGuaranteeType.values()) {
			if (string.equals(sgt.toString())) {
				return sgt;
			}
		}
		return ServiceGuaranteeType.UNRECOGNIZED;
	}
	
	private void storeBreach (Date   date,
							  String user_id,
							  String type,
							  String value) {
		Breach breach = new Breach();
		
		breach.setTimestamp(date);
		breach.setUser_id(user_id);
		breach.setType(type);
		breach.setValue(value);
		
		breach_repository.store(breach);
	}
	
	/*TODO Temporal solution until agreement of what type to use*/
	private eu.cloud4soa.api.datamodel.core.ApplicationInstance toApiApplicationInstance (ApplicationInstance appInstance) {
		eu.cloud4soa.api.datamodel.core.ApplicationInstance ret =
				new eu.cloud4soa.api.datamodel.core.ApplicationInstance();
		
		ret.setAdapterUrl(appInstance.getAdapterurl());
		ret.setApplicationDeploymentUriId(appInstance.getAppurl());		
		ret.setUriId(appInstance.getUriID());
		ret.setVersion(appInstance.getVersion());
		ret.setOwnerUriId(appInstance.getAccount().getUser().getUriID());
		
		return ret;
	}
}

