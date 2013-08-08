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

package eu.cloud4soa.frontend.commons.server.semanticdao;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.semantic.app.Application;
import eu.cloud4soa.api.datamodel.semantic.inf.DBStorageComponent;
import eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.ApplicationMapper2;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SoftwareComponentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Application repository
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
@Repository
public class ApplicationRepository extends BaseRepository<ApplicationModel, Application> implements ApplicationDao {

    @Autowired
    private ProgrammingLanguageDao programmingLanguageRepository;

    @Autowired
    private SqlDbRepository sqlDbRepository;

    public ApplicationRepository() {
        super(ApplicationModel.class,
                Application.class,
                new ApplicationMapper2());
    }


    @Override
    public ApplicationModel createApplicationFromTemplate(String templateName) {

        ApplicationModel model = mapper.from(new ApplicationInstance().getApplication()).toModel();

        // apply selected template
        if ("c4s-template-basic-java".equals(templateName)) {
            model.setTitle("MyJavaApplication");

            model.setProgrammingLanguage(programmingLanguageRepository.findByUriId("Java_1_6_0"));


        } else if ("c4s-template-basic-java-db".equals(templateName)) {
            model.setTitle("MyJavaApplicationWithDb");
            model.setProgrammingLanguage(programmingLanguageRepository.findByUriId("Java_1_6_0"));

            SoftwareComponent dbStorage = new DBStorageComponent();
            dbStorage.setTitle("MySQL Database");

            dbStorage.setRelatedswcategory(sqlDbRepository.retrieveSemanticEntityByUriId("MySQL"));

            model.getSoftwareComponents().add(new SoftwareComponentMapper().from(dbStorage).toModel());

        }

        return model;

    }
}
