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

import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.semantic.user.PaaSUser;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for provider user entities.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ProviderUserMapper extends AbstractMapper<PaaSUser, UserModel> {
    private UserMapper userMapper = new UserMapper();

    @Override
    protected UserModel readFrom(PaaSUser soaInstance) {
        return userMapper.readFrom(new UserInstance(soaInstance));
    }

    @Override
    protected PaaSUser writeTo(PaaSUser soaInstance, UserModel frontendModel) {
        return (PaaSUser) userMapper.writeTo(new UserInstance(soaInstance), frontendModel).getUser();
    }

}
