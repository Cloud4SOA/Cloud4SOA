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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.relational.datamodel;

import eu.cloud4soa.api.governance.monitoring.IMonitoringMetric;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author vervas
 */
@Entity
@Table(name = "MonitoringMetric")
public class MonitoringMetric extends AbstractModel<MonitoringMetric> implements IMonitoringMetric, Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monitoringJob", nullable = false)
    private MonitoringJob monitoringJob;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column
    private String metricKey;   
    
    @Column
    private String metricValue;  

    public MonitoringJob getMonitoringJob() {
        return monitoringJob;
    }

    public void setMonitoringJob(MonitoringJob monitoringJob) {
        this.monitoringJob = monitoringJob;
    }

    @Override
    public String getMetricKey() {
        return metricKey;
    }

    public void setMetricKey(String metricKey) {
        this.metricKey = metricKey;
    }

    @Override
    public String getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(String metricValue) {
        this.metricValue = metricValue;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
