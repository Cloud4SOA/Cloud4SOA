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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.core.Response;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.soa.AnnouncementModule;
import eu.cloud4soa.soa.PaaSOfferingDiscovery;
import eu.cloud4soa.soa.UserManagementAndSecurityModule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/soa.xml"})
public class UserManagementTest {
	private String userInstanceId;
	List<PaaSInstance> paasInstances;
	@Autowired
	private UserManagementAndSecurityModule userManagementAndSecurityModule;
	@Autowired
	private AnnouncementModule announcementModule;
	@Autowired
	private PaaSOfferingDiscovery paaSOfferingDiscovery;



	@Test
	@Ignore
	public void createUserTest() throws SOAException{
		DeveloperInstance developerInstance = new DeveloperInstance();
		developerInstance.setFirstName("Yosu");
		developerInstance.setFamilyname("Gorroñogoitia");
		developerInstance.setAccountname("yosu");
		developerInstance.setGeekcode("yosu");
		developerInstance.setSurname("Gorroñogoitia");
		Calendar calendar = Calendar.getInstance(Locale.ITALY);
		calendar.set(1967, 3, 11);
		developerInstance.setBirthday(Calendar.getInstance().getTime());
		developerInstance.setCloud4SoaAccountUriId("yosu");
		developerInstance.setAccountname("yosu");
		//developerInstance.setUriId("http://www.cloud4soa.eu/yosu#");
		
		Response resp = userManagementAndSecurityModule.createNewAccount(developerInstance, "username", "password");

        String userId = (String)resp.getEntity();
        System.out.println("UserID: " + userId);

	}
}
