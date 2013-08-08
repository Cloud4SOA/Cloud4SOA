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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.ACRONYM;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.ADAPTER_URL;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.APPLICATION_CODE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.APPLICATION_SIZE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.APPLICATION_URIID;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.ARCHIVE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.COMPUTE_SCALING_FACTOR;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.DEPLOYMENT_URL;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.DIGEST;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.HARD_COMPONENTS;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.LICENSE_TYPE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.OWNER_URIID;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.PAAS_PROVIDER;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.PAAS_PROVIDER_URIID;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.SLA_CONTRACT_ID;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.SLA_MAX_LATENCY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.SLA_UPTIME;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.SOFT_COMPONENTS;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.STATUS;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.VERSION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.WEB_SCALING_FACTOR;
import static eu.cloud4soa.frontend.commons.client.gxt.WithDescription.DESCRIPTION;
import static eu.cloud4soa.frontend.commons.client.gxt.WithTitle.TITLE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.qos.LatencyInstance;
import eu.cloud4soa.api.datamodel.core.qos.ServiceQualityInstance;
import eu.cloud4soa.api.datamodel.core.qos.UptimeInstance;
import eu.cloud4soa.api.datamodel.semantic.inf.HardwareComponent;
import eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent;
import eu.cloud4soa.api.datamodel.semantic.measure.StorageUnit;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.NumericRangeModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the application profile.
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationMapper extends
		AbstractMapper<ApplicationInstance, ApplicationModel> {

	@Override
	protected ApplicationModel readFrom(ApplicationInstance soaInstance) {

		ApplicationModel applicationModel = new ApplicationModel(
				soaInstance.getUriId(), Strings.defaultString(soaInstance
						.getApplication().getTermsTitle(), Strings
						.defaultString(soaInstance.getApplication()
								.getApplicationcode(), Strings.defaultString(
								soaInstance.getApplication().getAlternative(),
								"Untitled"))));

		// set of properties to show in the form
		applicationModel.set(TITLE, soaInstance.getApplication()
				.getTermsTitle());
		applicationModel.set(VERSION, soaInstance.getVersion());
		if (soaInstance.getApplication().getUseProgrammingLanguage() != null)
			applicationModel
					.setProgrammingLanguage(new ProgrammingLanguageMapper()
							.from(soaInstance.getApplication()
									.getUseProgrammingLanguage()).toModel());
		applicationModel
				.set(APPLICATION_CODE, soaInstance.getApplicationcode());
		applicationModel.set(LICENSE_TYPE, soaInstance.getApplication()
				.getLicensetype());

		applicationModel.set(
				COMPUTE_SCALING_FACTOR,
				new NumericRangeMapper().from(
						soaInstance.getApplication()
								.getRequireComputeScalingFactor()).toModel());
		applicationModel.set(
				WEB_SCALING_FACTOR,
				new NumericRangeMapper().from(
						soaInstance.getApplication()
								.getRequireWebScalingFactor()).toModel());

		// other properties
		applicationModel.set(ACRONYM, soaInstance.getAcronym());
		applicationModel.set(ADAPTER_URL, soaInstance.getAdapterUrl());
		applicationModel
				.setDescription(soaInstance.getApplication() != null ? Strings
						.defaultString(soaInstance.getApplication()
								.getdescription()) : Strings.EMPTY);
		applicationModel.set(DIGEST, soaInstance.getDigest());
		applicationModel.set(DEPLOYMENT_URL, soaInstance.getDeploymentIP());
		applicationModel.set(OWNER_URIID, soaInstance.getOwnerUriId());

		applicationModel.set(
				APPLICATION_SIZE,
				new MeasurementUnitMapper<StorageUnit>().from(
						Strings.defaultObject(soaInstance.getApplication()
								.getSize(), new StorageUnit())).toModel());

		applicationModel.set(APPLICATION_URIID, soaInstance.getUriId());
		applicationModel.set(
				ARCHIVE,
				(soaInstance.getArchiveFileName() != null ? soaInstance
						.getArchiveFileName() : "")
						+ (soaInstance.getArchiveExtensionName() != null ? "."
								+ soaInstance.getArchiveExtensionName() : ""));
		applicationModel.set(PAAS_PROVIDER,
				soaInstance.getPaaSOfferingDeploymentName());
		applicationModel.set(PAAS_PROVIDER_URIID,
				soaInstance.getPaaSOfferingDeploymentUriId());
		applicationModel.set(STATUS,
				soaInstance.getStatus() != null ? soaInstance.getStatus()
						.name() : Strings.EMPTY);
		applicationModel.set(SLA_CONTRACT_ID, soaInstance.getSLAcontractID());
		
		soaInstance.getApplication().getRequireWebScalingFactor();

		// sla
		for (ServiceQualityInstance qosInstance : soaInstance
				.getServiceQualities())
			if (qosInstance instanceof UptimeInstance)
				applicationModel.set(SLA_UPTIME,
						((UptimeInstance) qosInstance).getHasPercentage());
			else if (qosInstance instanceof LatencyInstance)
				applicationModel.set(SLA_MAX_LATENCY,
						((LatencyInstance) qosInstance).getMaxValueMs());

		// software components
		List<SoftwareComponentModel> softwareComponents = new ArrayList<SoftwareComponentModel>();
		applicationModel.set(SOFT_COMPONENTS, softwareComponents);

		for (SoftwareComponent softwareComponent : soaInstance.getApplication()
				.getRequiresSoftwareComponent())
			softwareComponents.add(new SoftwareComponentMapper().from(
					softwareComponent).toModel());

		// hardware components
		List<HardwareComponentModel> hardwareComponents = new ArrayList<HardwareComponentModel>();
		applicationModel.set(HARD_COMPONENTS, hardwareComponents);

		for (HardwareComponent hardwareComponent : soaInstance.getApplication()
				.getRequiresResource())
			hardwareComponents.add(new HardwareComponentMapper().from(
					hardwareComponent).toModel());

		return applicationModel;
	}

	@Override
	protected ApplicationInstance writeTo(ApplicationInstance soaInstance,
			ApplicationModel frontendModel) {

		// set of properties to show in the form
		soaInstance.getApplication().setTermsTitle(
				frontendModel.<String> get(TITLE));
		soaInstance.setVersion(frontendModel.<String> get(VERSION));
		soaInstance.getApplication().setUseProgrammingLanguage(
				new ProgrammingLanguageMapper().from(
						soaInstance.getApplication()
								.getUseProgrammingLanguage()).overWriteWith(
						frontendModel.getProgrammingLanguage()));
		soaInstance.setApplicationcode(frontendModel
				.<String> get(APPLICATION_CODE));
		soaInstance.getApplication().setLicensetype(
				frontendModel.<String> get(LICENSE_TYPE));

		// other properties
		soaInstance.setAcronym(frontendModel.<String> get(ACRONYM));
		soaInstance.setAdapterUrl(frontendModel.<String> get(ADAPTER_URL));
		soaInstance.getApplication().setdescription(
				frontendModel.<String> get(DESCRIPTION));
		soaInstance.setDigest(frontendModel.<String> get(DIGEST));
		soaInstance.setDeploymentIP(frontendModel.<String> get(DEPLOYMENT_URL));
		soaInstance.setOwnerUriId(frontendModel.<String> get(OWNER_URIID));

		soaInstance
				.getApplication()
				.setSize(
						new MeasurementUnitMapper<StorageUnit>()
								.from(soaInstance.getApplication().getSize())
								.overWriteWith(
										frontendModel
												.<MeasurementModel> get(APPLICATION_SIZE)));

		soaInstance
				.getApplication()
				.setRequireComputeScalingFactor(
						new NumericRangeMapper()
								.from(soaInstance.getApplication()
										.getRequireComputeScalingFactor())
								.overWriteWith(
										frontendModel
												.<NumericRangeModel> get(COMPUTE_SCALING_FACTOR)));

		soaInstance.getApplication().setRequireWebScalingFactor(
				new NumericRangeMapper().from(
						soaInstance.getApplication()
								.getRequireWebScalingFactor()).overWriteWith(
						frontendModel
								.<NumericRangeModel> get(WEB_SCALING_FACTOR)));

		// sla
		List<ServiceQualityInstance> serviceQualityInstances = new ArrayList<ServiceQualityInstance>();
		Float upTime = frontendModel.<Float> get(SLA_UPTIME);
        UptimeInstance upTimeInstance = null;
        for (ServiceQualityInstance qosInstance : soaInstance
                .getServiceQualities()) {
            if (qosInstance instanceof UptimeInstance) {
                upTimeInstance = ((UptimeInstance) qosInstance);
            }
        }
        if (upTimeInstance == null) {
            upTimeInstance = new UptimeInstance();
        }
        upTimeInstance.setHasPercentage(upTime);
        serviceQualityInstances.add(upTimeInstance);

		Float latency = frontendModel.<Float> get(SLA_MAX_LATENCY);
        LatencyInstance latencyInstance = null;
        for (ServiceQualityInstance qosInstance : soaInstance
                .getServiceQualities()) {
            if (qosInstance instanceof LatencyInstance) {
                latencyInstance = ((LatencyInstance) qosInstance);
            }
        }
        if (latencyInstance == null) {
            latencyInstance = new LatencyInstance();
        }
        latencyInstance.setMaxValueMs(latency);
        serviceQualityInstances.add(latencyInstance);

        soaInstance.setServiceQualities(serviceQualityInstances);

		// replace or update the software component list
		Map<String, SoftwareComponent> softwareComponentByKey = new HashMap<String, SoftwareComponent>();
		for (SoftwareComponent softwareComponent : soaInstance.getApplication()
				.getRequiresSoftwareComponent())
			if (softwareComponent != null
					&& softwareComponent.getUriId() != null)
				softwareComponentByKey.put(softwareComponent.getUriId(),
						softwareComponent);

		List<SoftwareComponent> softwareComponents = new ArrayList<SoftwareComponent>();
		for (SoftwareComponentModel softwareComponentModel : frontendModel
				.getSoftwareComponents()) {
			SoftwareComponent softwareComponent = softwareComponentByKey
					.get(softwareComponentModel.getKey());

			softwareComponents.add(new SoftwareComponentMapper().from(
					softwareComponent).overWriteWith(softwareComponentModel));
		}

		soaInstance.getApplication().setRequiresSoftwareComponent(
				softwareComponents);

		// replace or update hardware component list
		Map<String, HardwareComponent> hardwareComponentByKey = new HashMap<String, HardwareComponent>();
		for (HardwareComponent hardwareComponent : soaInstance.getApplication()
				.getRequiresResource())
			if (hardwareComponent != null
					&& hardwareComponent.getUriId() != null)
				hardwareComponentByKey.put(hardwareComponent.getUriId(),
						hardwareComponent);

		List<HardwareComponent> hardwareComponents = new ArrayList<HardwareComponent>();
		for (HardwareComponentModel hardwareComponentModel : frontendModel
				.getHardwareComponents()) {
			HardwareComponent hardwareComponent = hardwareComponentByKey
					.get(hardwareComponentModel.getKey());

			hardwareComponents.add(new HardwareComponentMapper().from(
					hardwareComponent).overWriteWith(hardwareComponentModel));
		}

		soaInstance.getApplication().setRequiresResource(hardwareComponents);

		return soaInstance;

	}
}
