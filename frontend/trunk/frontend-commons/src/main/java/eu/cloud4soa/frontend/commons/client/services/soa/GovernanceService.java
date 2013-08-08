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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractServiceModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */

@RemoteServiceRelativePath("GovernanceService")
public interface GovernanceService extends RemoteService {
	public List<SLAViolationModel> getSLAViolations(Date start, Date end);
	public List<SLAViolationModel> getSLAViolations();
	public List<SLAViolationModel> getSLABreaches(Date start, Date end);
	public List<SLAViolationModel> getSLABreaches();
	public SLAContractModel getSLAContract(String slaContractId);
	
	/*
    The following two methods do nothing. For weird reason these classes
    in a service methods signature is the only way to get them included in the serialization white list.
    Usually the GWT compiler put classes in the while list if one of these condition is meet:
     1) The class is part of a GWT-RPC method signature
     2) The class is reachable navigation the properties of a class from 1)
     3) The class has the IsSerializable interface

     These classes theoretically meet 2) and 3), however they are not picked up.
     The following useless method allow them to meet 1).
    */

   SLAContractServiceModel whiteList1();
   SLAContractContextModel whiteList2();
   
}
