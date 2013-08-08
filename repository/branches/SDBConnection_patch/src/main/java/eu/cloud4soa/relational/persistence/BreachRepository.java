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


package eu.cloud4soa.relational.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.cloud4soa.relational.datamodel.Account;
import eu.cloud4soa.relational.datamodel.ApplicationInstance;
import eu.cloud4soa.relational.datamodel.Breach;
import eu.cloud4soa.relational.datamodel.Paas;
import eu.cloud4soa.relational.datamodel.SLAViolation;
import eu.cloud4soa.relational.persistence.support.AbstractHbmDao;

@Repository
public class BreachRepository extends AbstractHbmDao<Breach> {
	
	@Autowired
	public BreachRepository(SessionFactory sessionFactory) {
		super(sessionFactory, Breach.class);
	}
	
	public void store(Breach breach) {
		this.saveOrUpdate(breach);
	}

	public void update(Breach breach) {
		super.update(breach);
	}

	public void delete(Breach breach) {
		super.delete(breach);
	}

	public List<Breach> retrieveAll() {
		return this.findAll();
	}
	
	public List<Breach> retrieveAll(Long breachId) {		
		return this.find("id = ?", breachId);
	}
	
	public List<Breach> retrieveAllInRange(String user_id, Date start,Date end){
		return this.find("user_id=? AND date>=? AND date<=? ORDER BY date DESC ",
						  user_id, start, end);
	}
	
	public List<Breach> retrieveAllForOffering (String offeringId) {
		DetachedCriteria pass_criteria = DetachedCriteria.forClass(Paas.class)
				.add(Restrictions.eq("url", offeringId));
		
		DetachedCriteria acc_criteria  = DetachedCriteria.forClass(Account.class)
				.add(Property.forName("paas").in(pass_criteria));
		
		DetachedCriteria app_criteria  = DetachedCriteria.forClass(ApplicationInstance.class)
				.add(Property.forName("account").in(acc_criteria))
				.setProjection(Projections.property("id"));
		
		return (List<Breach>) getSession().createCriteria(Breach.class)
				.add(Subqueries.geAll("applicationInstanceUriId", app_criteria))
				.list();		
	}
}
