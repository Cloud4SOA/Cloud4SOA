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

package eu.cloud4soa.frontend.commons.server.services.soa.mapping;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.semantic.app.Application;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Same as ApplicationMapper but use the real Application instead of ApplicationInstance
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationMapper2 extends AbstractMapper<Application, ApplicationModel> {

    private ApplicationMapper applicationMapper = new ApplicationMapper();

    @Override
    protected ApplicationModel readFrom(Application soaInstance) {
        return applicationMapper.readFrom(soaInstance == null ? new ApplicationInstance() : new ApplicationInstance(soaInstance));
    }

    @Override
    protected Application writeTo(Application soaInstance, ApplicationModel frontendModel) {
        return applicationMapper.writeTo(soaInstance == null ? new ApplicationInstance() : new ApplicationInstance(soaInstance), frontendModel).getApplication();
    }
}
