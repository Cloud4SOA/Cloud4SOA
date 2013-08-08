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

import eu.cloud4soa.api.datamodel.semantic.inf.DBConfiguration;
import eu.cloud4soa.api.datamodel.semantic.inf.DBStorageComponent;
import eu.cloud4soa.api.datamodel.semantic.measure.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SoftwareComponentMapper;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Mapping test to nail down bug #704
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MapperTest {


    @Test
    public void testSoftwareComponentMapping() {

        DBStorageComponent soa = new DBStorageComponent();
        soa.setDBconfiguration(new DBConfiguration());
        soa.getDBconfiguration().setHasDBcache(new StorageRange());
        soa.getDBconfiguration().setHasDBcapacity(new StorageRange());

        soa.getDBconfiguration().getHasDBcache().setMin(new TeraByte());
        soa.getDBconfiguration().getHasDBcache().getMin().setValue(1f);

        soa.getDBconfiguration().getHasDBcache().setMax(new GigaByte());
        soa.getDBconfiguration().getHasDBcache().getMax().setValue(2f);

        soa.getDBconfiguration().getHasDBcapacity().setMin(new MegaByte());
        soa.getDBconfiguration().getHasDBcapacity().getMin().setValue(3f);

        soa.getDBconfiguration().getHasDBcapacity().setMax(new KiloByte());
        soa.getDBconfiguration().getHasDBcapacity().getMax().setValue(4f);

        SoftwareComponentModel model = new SoftwareComponentMapper()
                .from(soa)
                .toModel();

        Assert.assertEquals(1f, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MIN)).getMeasureValue()
        );

        Assert.assertEquals(2f, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MAX)).getMeasureValue()
        );

        Assert.assertEquals(3f, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MIN)).getMeasureValue()
        );

        Assert.assertEquals(4f, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MAX)).getMeasureValue()
        );

        Assert.assertEquals(MeasurementModel.STORAGE_TERABYTE, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MIN)).getMeasureUnit()
        );

        Assert.assertEquals(MeasurementModel.STORAGE_GIGABYTE, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MAX)).getMeasureUnit()
        );

        Assert.assertEquals(MeasurementModel.STORAGE_MEGABYTE, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MIN)).getMeasureUnit()
        );

        Assert.assertEquals(MeasurementModel.STORAGE_KILOBYTE, ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MAX)).getMeasureUnit()
        );

        // now change values in the model

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MIN)).setMeasureValue(21f);

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MIN)).setMeasureUnit(MeasurementModel.STORAGE_GIGABYTE);

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MAX)).setMeasureValue(22f);

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CACHE))
                .get(RangeModel.MAX)).setMeasureUnit(MeasurementModel.STORAGE_MEGABYTE);

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MIN)).setMeasureValue(23f);

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MIN)).setMeasureUnit(MeasurementModel.STORAGE_KILOBYTE);


        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MAX)).setMeasureValue(24f);

        ((MeasurementModel) ((RangeModel) ((DbConfigurationModel) model
                .get(SoftwareComponentModel.DB_CONFIGURATION))
                .get(DbConfigurationModel.CAPACITY))
                .get(RangeModel.MAX)).setMeasureUnit(MeasurementModel.STORAGE_TERABYTE);

        // reverse map
        new SoftwareComponentMapper()
                .from(soa)
                .overWriteWith(model);

        Assert.assertEquals(21f, soa.getDBconfiguration().getHasDBcache().getMin().getValue());
        Assert.assertEquals(22f, soa.getDBconfiguration().getHasDBcache().getMax().getValue());
        Assert.assertEquals(23f, soa.getDBconfiguration().getHasDBcapacity().getMin().getValue());
        Assert.assertEquals(24f, soa.getDBconfiguration().getHasDBcapacity().getMax().getValue());

        Assert.assertTrue("gigs", soa.getDBconfiguration().getHasDBcache().getMin() instanceof GigaByte);
        Assert.assertTrue("mega", soa.getDBconfiguration().getHasDBcache().getMax() instanceof MegaByte);
        Assert.assertTrue("kilo", soa.getDBconfiguration().getHasDBcapacity().getMin() instanceof KiloByte);
        Assert.assertTrue("tera", soa.getDBconfiguration().getHasDBcapacity().getMax() instanceof TeraByte);

    }
}
