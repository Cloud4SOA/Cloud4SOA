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

import eu.cloud4soa.api.datamodel.semantic.measure.*;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel.*;

/**
 * Mapper for measurement unit
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MeasurementUnitMapper<U extends MeasurementUnit> extends AbstractMapper<U, MeasurementModel> {

    private Logger logger = LoggerFactory.getLogger(MeasurementUnitMapper.class);

    private Map<Class<? extends MeasurementUnit>, String> unitByClazz = new HashMap<Class<? extends MeasurementUnit>, String>();
    private Map<String, Class<? extends MeasurementUnit>> clazzByUnit = new HashMap<String, Class<? extends MeasurementUnit>>();
    private Map<Class<? extends MeasurementUnit>, String> unitClazzByClazz = new HashMap<Class<? extends MeasurementUnit>, String>();

    public MeasurementUnitMapper() {

        unitByClazz.put(Flops.class, COMPUTING_FLOPS);
        unitByClazz.put(KiloHertz.class, COMPUTING_KHZ);
        unitByClazz.put(MegaHertz.class, COMPUTING_MHZ);
        unitByClazz.put(GigaHertz.class, COMPUTING_GHZ);

        unitClazzByClazz.put(ComputingUnit.class, UNIT_COMPUTING);
        unitClazzByClazz.put(Flops.class, UNIT_COMPUTING);
        unitClazzByClazz.put(KiloHertz.class, UNIT_COMPUTING);
        unitClazzByClazz.put(MegaHertz.class, UNIT_COMPUTING);
        unitClazzByClazz.put(GigaHertz.class, UNIT_COMPUTING);

        unitByClazz.put(TeraByteperSecond.class, NETWORK_TERABYTES_S);
        unitByClazz.put(GigaByteperSecond.class, NETWORK_GIGABYTE_S);
        unitByClazz.put(KiloByteperSecond.class, NETWORK_KILOBYTE_S);
        unitByClazz.put(MegaByteperSecond.class, NETWORK_MEGABYTE_S);

        unitClazzByClazz.put(NetworkingUnit.class, UNIT_NETWORKING);
        unitClazzByClazz.put(TeraByteperSecond.class, UNIT_NETWORKING);
        unitClazzByClazz.put(GigaByteperSecond.class, UNIT_NETWORKING);
        unitClazzByClazz.put(KiloByteperSecond.class, UNIT_NETWORKING);
        unitClazzByClazz.put(MegaByteperSecond.class, UNIT_NETWORKING);

        unitByClazz.put(MilliSecond.class, TIME_MILLISECONDS);
        unitByClazz.put(Second.class, TIME_SECONDS);
        unitByClazz.put(Minute.class, TIME_MINUTES);
        unitByClazz.put(Hour.class, TIME_HOURS);

        unitClazzByClazz.put(TimeUnit.class, UNIT_TIME);
        unitClazzByClazz.put(MilliSecond.class, UNIT_TIME);
        unitClazzByClazz.put(Second.class, UNIT_TIME);
        unitClazzByClazz.put(Minute.class, UNIT_TIME);
        unitClazzByClazz.put(Hour.class, UNIT_TIME);


        unitByClazz.put(KiloByte.class, STORAGE_KILOBYTE);
        unitByClazz.put(MegaByte.class, STORAGE_MEGABYTE);
        unitByClazz.put(GigaByte.class, STORAGE_GIGABYTE);
        unitByClazz.put(TeraByte.class, STORAGE_TERABYTE);

        unitClazzByClazz.put(StorageUnit.class, UNIT_STORAGE);
        unitClazzByClazz.put(KiloByte.class, UNIT_STORAGE);
        unitClazzByClazz.put(MegaByte.class, UNIT_STORAGE);
        unitClazzByClazz.put(GigaByte.class, UNIT_STORAGE);
        unitClazzByClazz.put(TeraByte.class, UNIT_STORAGE);


        for (Map.Entry<Class<? extends MeasurementUnit>, String> me : unitByClazz.entrySet())
            clazzByUnit.put(me.getValue(), me.getKey());

    }

    @Override
    protected MeasurementModel readFrom(U soaInstance) {
        if (soaInstance == null)
            return new MeasurementModel(null);

        MeasurementModel measurementModel = new MeasurementModel(soaInstance.getUriId());

        measurementModel.setMeasureClass(Strings.defaultString(unitClazzByClazz.get(soaInstance.getClass()), UNIT_UNKNOWN));

        measurementModel.setMeasureUnit(Strings.defaultString(unitByClazz.get(soaInstance.getClass()), MEASURE_UNKNOWN));
        measurementModel.setMeasureValue(soaInstance.getValue());

        return measurementModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected U writeTo(U soaInstance, MeasurementModel frontendModel) {

        Class<? extends MeasurementUnit> unitClass = clazzByUnit.get(frontendModel.getMeasureUnit());

        if (unitClass != null) {
            try {
                soaInstance = (U) unitClass.newInstance();
            } catch (InstantiationException e) {
                logger.warn("Error creating the soa instance. ", e);
                soaInstance = (U) new MeasurementUnit();
            } catch (IllegalAccessException e) {
                logger.warn("Error creating the soa instance. ", e);
                soaInstance = (U) new MeasurementUnit();
            }
            soaInstance.setValue(frontendModel.getMeasureValue());
        } else if (soaInstance != null)
            soaInstance.setValue(frontendModel.getMeasureValue());

        return soaInstance != null && soaInstance.getValue() != null ?  soaInstance : null;

    }
}
