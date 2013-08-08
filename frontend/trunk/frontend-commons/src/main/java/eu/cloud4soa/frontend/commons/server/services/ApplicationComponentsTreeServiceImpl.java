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

package eu.cloud4soa.frontend.commons.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.ss.client.exceptions.GwtSecurityException;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValueTreeNode;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueTreeModelData;
import eu.cloud4soa.frontend.commons.client.services.ApplicationComponentsTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

/**
 * RPC service for building the software components tree in the application editor tool's panel.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@SuppressWarnings({"GwtServiceNotRegistered"})
@Secured("IS_AUTHENTICATED_FULLY")
public class ApplicationComponentsTreeServiceImpl extends RemoteServiceServlet implements ApplicationComponentsTreeService {

    @Autowired
    ApplicationModelService applicationModelService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }


    @Override
    public List<DisplayableKeyValueModelData> getComponentChildren(DisplayableKeyValueTreeModelData parentComponent) throws GwtSecurityException {

        List<DisplayableKeyValueModelData> li = new ArrayList<DisplayableKeyValueModelData>();

        for (DisplayableKeyValueTreeNode child : applicationModelService.getChildren(parentComponent))
            li.add(new DisplayableKeyValueTreeModelData(child));

        return li;
    }
}