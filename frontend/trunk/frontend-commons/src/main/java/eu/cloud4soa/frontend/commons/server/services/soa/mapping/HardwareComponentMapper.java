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

import eu.cloud4soa.api.datamodel.semantic.inf.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.NumericRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.*;

/**
 * Mapper for the hardware component.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class HardwareComponentMapper extends AbstractMapper<HardwareComponent, HardwareComponentModel> {
    @Override
    protected HardwareComponentModel readFrom(HardwareComponent soaInstance) {

        HardwareComponentModel hardwareComponentModel = soaInstance == null ? new HardwareComponentModel() : new HardwareComponentModel(soaInstance.getUriId(), soaInstance.getTitle());

        if (soaInstance != null) {
            hardwareComponentModel.set(DESCRIPTION, soaInstance.getDescription());
            hardwareComponentModel.set(VERSION, soaInstance.getVersion());


            hardwareComponentModel.set(HARDWARE_CATEGORY,
                    new HardwareCategoryMapper()
                            .from(soaInstance.getRelatedhwcategory())
                            .toModel()
            );

            hardwareComponentModel.set("c4s-title", "Hardware component");

            if (soaInstance instanceof NetworkResource) {
                hardwareComponentModel.setType(TYPE_NETWORK);
                hardwareComponentModel.setFormType(MetadataMapper.FORM_HARDWARE_NETWORK_COMPONENT);
                hardwareComponentModel.setFormTitle("Network resource");

                NetworkResource networkResource = (NetworkResource) soaInstance;

                hardwareComponentModel.set(BANDWIDTH, new NetworkRangeMapper()
                        .from(networkResource.getBandwidth())
                        .toModel()
                );

                hardwareComponentModel.set(LATENCY, new TimeRangeMapper()
                        .from(networkResource.getLatency())
                        .toModel()
                );

            }

            if (soaInstance instanceof StorageResource) {
                hardwareComponentModel.setType(TYPE_STORAGE);
                hardwareComponentModel.setFormType(MetadataMapper.FORM_HARDWARE_STORAGE_COMPONENT);
                hardwareComponentModel.setFormTitle("Storage resource");
                StorageResource storageResource = (StorageResource) soaInstance;

                hardwareComponentModel.set(BANDWIDTH, new NetworkRangeMapper()
                        .from(storageResource.getBandwidth())
                        .toModel()
                );

                hardwareComponentModel.set(CAPACITY, new StorageRangeMapper()
                        .from(storageResource.getCapacity())
                        .toModel()
                );
            }

            if (soaInstance instanceof Processing) {
                hardwareComponentModel.setType(TYPE_COMPUTATION);
                hardwareComponentModel.set(POWER_FACTOR, new NumericRangeMapper()
                        .from(((Processing) soaInstance).getComputationalPowerFactor())
                        .toModel()
                );

            }

            if (soaInstance instanceof Compute) {
                hardwareComponentModel.setType(TYPE_COMPUTATION);
                hardwareComponentModel.setFormType(MetadataMapper.FORM_HARDWARE_COMPUTE_COMPONENT);
                hardwareComponentModel.setFormTitle("Compute resource");
                Compute compute = (Compute) soaInstance;

                hardwareComponentModel.set(ARCHITECTURE, compute.getArchitecture());

                hardwareComponentModel.set(CACHE, new StorageRangeMapper()
                        .from(compute.getCache())
                        .toModel()
                );

                hardwareComponentModel.set(MEMORY, new StorageRangeMapper()
                        .from(compute.getMemory())
                        .toModel()
                );

                hardwareComponentModel.set(CORES, new NumericRangeMapper()
                        .from(compute.getHasCores())
                        .toModel()
                );

                hardwareComponentModel.set(STATE, compute.getState());
                hardwareComponentModel.set(SUPPORT_ERROR_CORRECTION, compute.getSupportErrorCorrectCode());
            }

            if (soaInstance instanceof HttpRequestsHandler) {
                hardwareComponentModel.setType(TYPE_HTTP_REQUEST_HANDLER);
                hardwareComponentModel.setFormType(MetadataMapper.FORM_HARDWARE_HTTP_REQUEST_HANDLER_COMPONENT);
                hardwareComponentModel.setFormTitle("HTTP Request Handler");

                HttpRequestsHandler httpRequestsHandler = (HttpRequestsHandler) soaInstance;

                hardwareComponentModel.set(HTTP_REQUESTS, new NumericRangeMapper()
                        .from(httpRequestsHandler.getHTTPRequests())
                        .toModel());

            }

        }

        return hardwareComponentModel;
    }


    @Override
    protected HardwareComponent writeTo(HardwareComponent soaInstance, HardwareComponentModel frontendModel) {

        if (soaInstance == null) {
            if (TYPE_COMPUTATION.equals(frontendModel.getType()))
                soaInstance = new Compute();
            else if (TYPE_HTTP_REQUEST_HANDLER.equals(frontendModel.getType()))
                soaInstance = new HttpRequestsHandler();
            else if (TYPE_NETWORK.equals(frontendModel.getType()))
                soaInstance = new NetworkResource();
            else if (TYPE_STORAGE.equals(frontendModel.getType()))
                soaInstance = new StorageResource();
            else
                soaInstance = new HardwareComponent();
        }

        soaInstance.setTitle(frontendModel.getDisplayName());
        soaInstance.setDescription(frontendModel.<String>get(DESCRIPTION));
        soaInstance.setVersion(frontendModel.<String>get(VERSION));

        soaInstance.setRelatedhwcategory(
                new HardwareCategoryMapper()
                        .from(soaInstance.getRelatedhwcategory())
                        .overWriteWith(frontendModel.getHardwareCategory())
        );


        if (soaInstance instanceof NetworkResource) {
            NetworkResource networkResource = (NetworkResource) soaInstance;

            // bandwidth
            networkResource.setBandwidth(
                    new NetworkRangeMapper()
                            .from(networkResource.getBandwidth())
                            .overWriteWith(frontendModel.<MeasurementRangeModel>get(BANDWIDTH))
            );

            // latency
            networkResource.setLatency(
                    new TimeRangeMapper()
                            .from(networkResource.getLatency())
                            .overWriteWith(frontendModel.<MeasurementRangeModel>get(LATENCY))
            );

        }

        if (soaInstance instanceof StorageResource) {
            StorageResource storageResource = (StorageResource) soaInstance;

            // bandwith
            storageResource.setBandwidth(
                    new NetworkRangeMapper()
                            .from(storageResource.getBandwidth())
                            .overWriteWith(frontendModel.<MeasurementRangeModel>get(BANDWIDTH))
            );

            // capacity
            storageResource.setCapacity(
                    new StorageRangeMapper()
                            .from(storageResource.getCapacity())
                            .overWriteWith(frontendModel.<MeasurementRangeModel>get(CAPACITY))
            );

        }

        if (soaInstance instanceof Processing) {
            Processing processing = (Processing) soaInstance;

            // power factor
            processing.setComputationalPowerFactor(
                    new NumericRangeMapper()
                            .from(processing.getComputationalPowerFactor())
                            .overWriteWith(frontendModel.<NumericRangeModel>get(POWER_FACTOR))
            );

        }

        if (soaInstance instanceof Compute) {
            Compute compute = (Compute) soaInstance;

            compute.setArchitecture(frontendModel.<String>get(ARCHITECTURE));

            // cache
            compute.setCache(
                    new StorageRangeMapper()
                            .from(compute.getCache())
                            .overWriteWith(frontendModel.<MeasurementRangeModel>get(CACHE))
            );

            // memory
            compute.setMemory(
                    new StorageRangeMapper()
                            .from(compute.getMemory())
                            .overWriteWith(frontendModel.<MeasurementRangeModel>get(MEMORY))
            );

            // cores
            compute.setHasCores(
                    new NumericRangeMapper()
                            .from(compute.getHasCores())
                            .overWriteWith(frontendModel.<NumericRangeModel>get(CORES))
            );

            compute.setState(frontendModel.<String>get(STATE));
            compute.setSupportErrorCorrectCode(frontendModel.<Boolean>get(SUPPORT_ERROR_CORRECTION));
        }

        if (soaInstance instanceof HttpRequestsHandler) {

            ((HttpRequestsHandler) soaInstance).setHTTPRequests(
                    new NumericRangeMapper()
                            .from(((HttpRequestsHandler) soaInstance).getHTTPRequests())
                            .overWriteWith(frontendModel.<NumericRangeModel>get(HTTP_REQUESTS))
            );

        }


        return soaInstance;
    }
}
