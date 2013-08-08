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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.VERSION;
import static eu.cloud4soa.frontend.commons.client.gxt.WithDescription.DESCRIPTION;
import eu.cloud4soa.api.datamodel.core.utilBeans.APIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.CLIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelType;
import eu.cloud4soa.api.datamodel.core.utilBeans.WebInterfaceInstance;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.ChannelModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

public class ChannelMapper extends AbstractMapper<ChannelInstance, ChannelModel>{

	@Override
	protected ChannelModel readFrom(ChannelInstance soaInstance) {
		ChannelModel channelModel = 
			soaInstance == null ? new ChannelModel() : new ChannelModel(soaInstance.getUriId(), soaInstance.getTitle());

        if (soaInstance != null) {
        	channelModel.set(DESCRIPTION, soaInstance.getDescription());
        	channelModel.set(VERSION, soaInstance.getVersion());

        	channelModel.set("c4s-title", "Channel component");

            if (soaInstance instanceof CLIInstance) {
            	channelModel.setType(ChannelType.CLI.name());
            } else if (soaInstance instanceof WebInterfaceInstance) {
            	channelModel.setType(ChannelType.WebInterface.name());
            } else if (soaInstance instanceof APIInstance) {
            	channelModel.setType(ChannelType.API.name());
            }
        }

        return channelModel;
	}

	@Override
	protected ChannelInstance writeTo(ChannelInstance soaInstance,
			ChannelModel frontendModel) {
		
       if (soaInstance == null) {
            if (ChannelType.CLI.name().equals(frontendModel.getType()))
                soaInstance = new CLIInstance();
            else if (ChannelType.WebInterface.name().equals(frontendModel.getType()))
                soaInstance = new WebInterfaceInstance();
            else if (ChannelType.API.name().equals(frontendModel.getType()));
                soaInstance = new APIInstance();
        }

        soaInstance.setTitle(frontendModel.getDisplayName());
        soaInstance.setDescription(frontendModel.<String>get(DESCRIPTION));
        soaInstance.setVersion(frontendModel.<String>get(VERSION));

        return soaInstance;
	}

}
