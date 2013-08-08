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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.SLA_MAX_LATENCY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.SLA_UPTIME;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.APIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.CLIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.WebInterfaceInstance;
import eu.cloud4soa.api.datamodel.semantic.ea.Latency;
import eu.cloud4soa.api.datamodel.semantic.ea.Technology_Service_Quality;
import eu.cloud4soa.api.datamodel.semantic.ea.Uptime;
import eu.cloud4soa.api.datamodel.semantic.inf.HardwareComponent;
import eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent;
import eu.cloud4soa.api.datamodel.semantic.paas.API;
import eu.cloud4soa.api.datamodel.semantic.paas.CLI;
import eu.cloud4soa.api.datamodel.semantic.paas.Channel;
import eu.cloud4soa.api.datamodel.semantic.paas.PaaSOffering;
import eu.cloud4soa.api.datamodel.semantic.paas.Rating;
import eu.cloud4soa.api.datamodel.semantic.paas.WebInterface;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.NumericRangeModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.ChannelModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PricingPolicyModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.RatingModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the PaaSOffering
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class PaaSOfferMapper extends AbstractMapper<PaaSOffering, PaaSOfferingModel> {
		
    @Override
    protected PaaSOfferingModel readFrom(PaaSOffering soaInstance) {


        PaaSOfferingModel offeringModel = soaInstance == null ? new PaaSOfferingModel() : new PaaSOfferingModel(soaInstance.getUriId(), soaInstance.getTitle());

        if (soaInstance != null) {

            offeringModel.setTitle(soaInstance.getTitle());
            offeringModel.setDescription(soaInstance.getDescription());

            offeringModel.setProgrammingLanguage(new ProgrammingLanguageMapper()
                    .from(soaInstance.getSupportedLanguage())
                    .toModel()
            );


            // software components
            List<SoftwareComponentModel> softwareComponents = offeringModel.getSoftwareComponents();

            for (SoftwareComponent softwareComponent : soaInstance.getOfferedSoftware())
                softwareComponents.add(
                        new SoftwareComponentMapper()
                                .from(softwareComponent)
                                .toModel()
                );

            // hardware components
            List<HardwareComponentModel> hardwareComponents = offeringModel.getHardwareComponents();

            for (HardwareComponent hardwareComponent : soaInstance.getOfferedHardwareComponents())
                hardwareComponents.add(
                        new HardwareComponentMapper()
                                .from(hardwareComponent)
                                .toModel()
                );

            // Pricing policies
            List<PricingPolicyModel> pricingPolicies = offeringModel.getPricingPolicyModels();

            //FIXME Actually getting URI instead of PricingPolicy
            //TODO Report bug
//            for (Object object : soaInstance.getPricingPolicies()){ 
//            	if (object instanceof URI){
//            		URI uri = (URI) object;
//	            	PricingPolicy pricingPolicy = new PricingPolicy();
//	            	pricingPolicy.setUriId(uri.toString());
//	            	pricingPolicy.setDescription(uri.toString());
//	            	pricingPolicy.setTitle(uri.toString());
//	            	
//	            	pricingPolicies.add(
//	                        new PricingPolicyMapper()
//	                                .from(pricingPolicy)
//	                                .toModel()
//	                );
//	            }
//            }

            // CommunicationChannels
            List<ChannelModel> communicationChannels = offeringModel.getCommunicationChannelModels();

            for (ChannelInstance channel : getChannels(soaInstance))
                communicationChannels.add(
                        new ChannelMapper()
                                .from(channel)
                                .toModel()
                );

            // Ratings
            List<RatingModel> ratings = offeringModel.getRatings();

            for (Rating rating : soaInstance.getRating())
                ratings.add(
                        new RatingMapper()
                                .from(rating)
                                .toModel()
                );
            

            offeringModel.set(STATUS, soaInstance.getStatus());
            offeringModel.set(URL, soaInstance.getURL());

            offeringModel.set(COMPUTE_SCALING_FACTOR,
                    new NumericRangeMapper()
                            .from(soaInstance.getOfferComputeScalingFactor())
                            .toModel()
            );

            offeringModel.set(WEB_SCALING_FACTOR,
                    new NumericRangeMapper()
                            .from(soaInstance.getOfferWebScalingFactor())
                            .toModel()
            );

            //sla
            // sla
            for (Technology_Service_Quality qosInstance : soaInstance.getProvidesServiceQuality())
                if (qosInstance instanceof Uptime)
                    offeringModel.set(SLA_UPTIME, ((Uptime) qosInstance).getHasPercentage());
                else if (qosInstance instanceof Latency)
                	if (((Latency) qosInstance).getHasTimeRangeValue().getMax()!= null)
                		offeringModel.set(SLA_MAX_LATENCY, ((Latency) qosInstance).getHasTimeRangeValue().getMax().getValue());

            // check whether the provider supports GIT, CLI or both. Reuse the "instance" class facilities
            PaaSInstance paasInstance = new PaaSInstance(soaInstance);

            offeringModel.set(GIT_SUPPORT, paasInstance.getGITsupport());
            offeringModel.set(ARCHIVE_SUPPORT, paasInstance.getArchiveSupport());

        }

        return offeringModel;
    }

    public List<ChannelInstance> getChannels(PaaSOffering soaInstance) {
        List<Channel> offeredCommunicationChannels = soaInstance.getCommunicationChannels();
        List<ChannelInstance> communicationChannelsInstances = new ArrayList<ChannelInstance>();
        for (Channel channel : offeredCommunicationChannels) {
            if (channel instanceof API)
                communicationChannelsInstances.add(new APIInstance((API) channel));
            if (channel instanceof CLI)
                communicationChannelsInstances.add(new CLIInstance((CLI) channel));
            if (channel instanceof WebInterface)
                communicationChannelsInstances.add(new WebInterfaceInstance((WebInterface) channel));
        }
//        return communicationChannelsInstances.iterator();
        return communicationChannelsInstances;
    }

    @Override
    protected PaaSOffering writeTo(PaaSOffering soaInstance, PaaSOfferingModel frontendModel) {

        if (soaInstance == null) {
            soaInstance = new PaaSOffering();
            soaInstance.setUriId(frontendModel.getKey());
        }

        soaInstance.setTitle(frontendModel.getTitle());
        soaInstance.setDescription(frontendModel.getDescription());

        soaInstance.setSupportedLanguage(new ProgrammingLanguageMapper()
                .from(soaInstance.getSupportedLanguage())
                .overWriteWith(frontendModel.getProgrammingLanguage())
        );

        // replace or update the software component list
        Map<String, SoftwareComponent> softwareComponentByKey = new HashMap<String, SoftwareComponent>();
        for (SoftwareComponent softwareComponent : soaInstance.getOfferedSoftware())
            if (softwareComponent != null && softwareComponent.getUriId() != null)
                softwareComponentByKey.put(softwareComponent.getUriId(), softwareComponent);

        List<SoftwareComponent> softwareComponents = new ArrayList<SoftwareComponent>();
        for (SoftwareComponentModel softwareComponentModel : frontendModel.getSoftwareComponents()) {
            SoftwareComponent softwareComponent = softwareComponentByKey.get(softwareComponentModel.getKey());
            softwareComponents.add(new SoftwareComponentMapper()
                    .from(softwareComponent)
                    .overWriteWith(softwareComponentModel)
            );
        }

        soaInstance.setOfferedSoftware(softwareComponents);

        // replace or update the hardware component list
        Map<String, HardwareComponent> hardwareComponentByKey = new HashMap<String, HardwareComponent>();
        for (HardwareComponent hardwareComponent : soaInstance.getOfferedHardwareComponents())
            if (hardwareComponent != null && hardwareComponent.getUriId() != null)
                hardwareComponentByKey.put(hardwareComponent.getUriId(), hardwareComponent);

        List<HardwareComponent> hardwareComponents = new ArrayList<HardwareComponent>();
        for (HardwareComponentModel hardwareComponentModel : frontendModel.getHardwareComponents()) {
            HardwareComponent hardwareComponent = hardwareComponentByKey.get(hardwareComponentModel.getKey());
            hardwareComponents.add(new HardwareComponentMapper()
                    .from(hardwareComponent)
                    .overWriteWith(hardwareComponentModel)
            );
        }

        soaInstance.setOfferedHardwareComponents(hardwareComponents);


        // Pricing policies
        for (int i = 0; i < soaInstance.getPricingPolicies().size(); i++)
            if (i < frontendModel.getPricingPolicyModels().size())
                new PricingPolicyMapper()
                        .from(soaInstance.getPricingPolicies().get(i))
                        .overWriteWith(frontendModel.getPricingPolicyModels().get(i));

        // Communication Channels
        for (int i = 0; i < soaInstance.getCommunicationChannels().size(); i++)
            if (i < frontendModel.getCommunicationChannelModels().size())
                new ChannelMapper()
                        .from(getChannels(soaInstance).get(i))
                        .overWriteWith(frontendModel.getCommunicationChannelModels().get(i));

        // Ratings
        for (int i = 0; i < soaInstance.getRating().size(); i++)
            if (i < frontendModel.getRatings().size())
                new RatingMapper()
                        .from(soaInstance.getRating().get(i))
                        .overWriteWith(frontendModel.getRatings().get(i));


        soaInstance.setStatus(frontendModel.<String>get(STATUS));
        soaInstance.setURL(frontendModel.<String>get(URL));

        soaInstance.setOfferComputeScalingFactor(
                new NumericRangeMapper()
                        .from(soaInstance.getOfferComputeScalingFactor())
                        .overWriteWith(frontendModel.<NumericRangeModel>get(ApplicationModel.COMPUTE_SCALING_FACTOR))
        );

        soaInstance.setOfferWebScalingFactor(
                new NumericRangeMapper()
                        .from(soaInstance.getOfferWebScalingFactor())
                        .overWriteWith(frontendModel.<NumericRangeModel>get(ApplicationModel.WEB_SCALING_FACTOR))
        );


        // sla
        List<Technology_Service_Quality> serviceQualityInstances = new ArrayList<Technology_Service_Quality>();

        Float upTimeValue = frontendModel.<Float>get(SLA_UPTIME);
        if (upTimeValue != null) {
            Uptime upTime = null;
            for (Technology_Service_Quality qosInstance : soaInstance.getProvidesServiceQuality()) {
                if (qosInstance instanceof Uptime) {
                    upTime = ((Uptime) qosInstance);
                }
            }
            if (upTime == null) {
                upTime = new Uptime();
            }
            upTime.setHasPercentage(upTimeValue);
            serviceQualityInstances.add(upTime);
        }

        Float latencyValue = frontendModel.<Float>get(SLA_MAX_LATENCY);
        if (latencyValue != null) {
            Latency latency = null;
            for (Technology_Service_Quality qos : soaInstance.getProvidesServiceQuality()) {
                if (qos instanceof Latency) {
                    latency = ((Latency) qos);
                }
            }
            if (latency == null) {
                latency = new Latency();
            }
            latency.getHasTimeRangeValue().getMax().setValue(latencyValue);
            serviceQualityInstances.add(latency);
        }
        soaInstance.setProvidesServiceQuality(serviceQualityInstances);


        return soaInstance;
    }
}
