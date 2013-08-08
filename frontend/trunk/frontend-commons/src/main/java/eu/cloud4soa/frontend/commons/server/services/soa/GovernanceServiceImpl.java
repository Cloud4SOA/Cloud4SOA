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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import com.ibm.icu.util.Calendar;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.governance.SLAViolation;
import eu.cloud4soa.api.datamodel.governance.SlaContract;
import eu.cloud4soa.api.governance.SLAModule;
import eu.cloud4soa.api.soa.ModelManager;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractServiceModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;
import eu.cloud4soa.frontend.commons.client.services.soa.GovernanceService;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SLAContractMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SLAViolationMapper;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@Secured("IS_AUTHENTICATED_FULLY")
@SuppressWarnings({ "GwtServiceNotRegistered" })
public class GovernanceServiceImpl extends RemoteServiceServlet implements
		GovernanceService {
	final Logger logger = LoggerFactory.getLogger(GovernanceServiceImpl.class);

	@Autowired
    @Qualifier("slaModule")
    private SLAModule slaModuleSoaService;
	
	@Autowired
    private C4sSubject c4sSubject;
	
	@Qualifier("modelManager")
    @Autowired
    private ModelManager modelManagerSoaService;
	
	// FIXME Mockup
//	SLAStore store = new SLAStore();
	
	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

	@Override
	public List<SLAViolationModel> getSLAViolations() {
		Calendar now = Calendar.getInstance();
		Date end = now.getTime();
		
		//Start date one day before by default
		now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH)-1);
		Date start = now.getTime();
		return getSLAViolations (start, end);
	}
	
	@Override
	public List<SLAViolationModel> getSLAViolations(Date start, Date end) {
		List<SLAViolation> slaViolations = slaModuleSoaService.getSlaViolations(c4sSubject.getCurrentUserUriId(), start, end);
		List<SLAViolationModel> violationModels = new ArrayList<SLAViolationModel> (slaViolations.size());
		//Map used for performance issues, when retriving a large number of violations corresponding to few applications for which
		//We need to obtain the application and provider name
		Map<String, ApplicationInstance> applicationMap = new HashMap<String, ApplicationInstance>();
		ApplicationInstance app;
		for (SLAViolation violation: slaViolations){
			SLAViolationModel model = new SLAViolationMapper().from(violation).toModel();
			try {
				if (!applicationMap.containsKey(violation.getApplication_instance_uri_id())){
					app = modelManagerSoaService.
						retrieveApplicationProfile(violation.getApplication_instance_uri_id(), c4sSubject.getCurrentUserUriId());
					applicationMap.put (violation.getApplication_instance_uri_id(), app);
				}else
					app = applicationMap.get(violation.getApplication_instance_uri_id());
				model.set(SLAViolationModel.APPLICATION, app.getTitle());
				model.set(SLAViolationModel.PROVIDER, app.getPaaSOfferingDeploymentName());
			} catch (SOAException e) {
				e.printStackTrace();
			}
			violationModels.add (model);
		}
		
		return violationModels;
	}

	@Override
	public List<SLAViolationModel> getSLABreaches(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SLAViolationModel> getSLABreaches() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.cloud4soa.frontend.commons.client.services.soa.GovernanceService#
	 * getSLAContract(java.lang.String)
	 */
	@Override
	public SLAContractModel getSLAContract(String slaContractId) {
		SlaContract slaContract = slaModuleSoaService.getSLAContract(slaContractId);
		return new SLAContractMapper()
			.from(slaContract).toModel();
	}

	/**
	 * Testing purpose. Loads an XML-based testing SLA Contract from classpath
	 * 
	 * @param xmlName
	 * @return
	 */
	private String loadSLAContractFromClasspath(String xmlName) {
		StringBuilder data = new StringBuilder();
		String fileContent = "";
		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream("/" + xmlName);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			while ((fileContent = br.readLine()) != null) {
				data = data.append(fileContent).append("\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// Ignored
				}
		}

		return data.toString();
	}
	
	/*
    The following methods do nothing. For weird reason using EntityMetadata and FieldMetadata classes
    in a service methods signature is the only way to get them included in the serialization white list.
    Usually the GWT compiler put classes in the while list if one of these condition is meet:
     1) The class is part of a GWT-RPC method signature
     2) The class is reachable navigating the properties of a class from 1)
     3) The class has the IsSerializable interface

     Both EntityMetadata and FieldMetadata theoretically meet 2) and 3), however they are not picked up.
     The following useless method allow them to meet 1).
    */

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.commons.client.services.soa.GovernanceService#whiteList1()
	 */
	@Override
	public SLAContractServiceModel whiteList1() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.commons.client.services.soa.GovernanceService#whiteList2()
	 */
	@Override
	public SLAContractContextModel whiteList2() {
		// TODO Auto-generated method stub
		return null;
	}
}
