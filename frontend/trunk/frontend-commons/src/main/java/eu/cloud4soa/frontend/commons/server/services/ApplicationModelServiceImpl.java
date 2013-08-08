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

import com.viceversatech.rdfbeans.exceptions.RDFBeanException;
import eu.cloud4soa.api.datamodel.semantic.inf.*;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValueTreeNode;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.SimpleKeyValueTreeNode;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareCategoryModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareCategoryModel;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.HardwareCategoryMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SoftwareCategoryMapper;
import eu.cloud4soa.repository.utils.RepositoryManager;
import org.ontoware.rdf2go.model.Sparqlable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A service meant to retrieve information about the application model
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Service
@SuppressWarnings({"GwtServiceNotRegistered"})
@Secured("IS_AUTHENTICATED_FULLY")
public class ApplicationModelServiceImpl implements ApplicationModelService {

    private Logger log = LoggerFactory.getLogger(ApplicationModelServiceImpl.class);

    @Autowired
    Sparqlable model;

    @Qualifier("repositoryManager")
    @Autowired
    RepositoryManager repositoryManager;

    @Override
    public List<DisplayableKeyValueTreeNode> getChildren(DisplayableKeyValueTreeNode parent) {
        List<DisplayableKeyValueTreeNode> results = new ArrayList<DisplayableKeyValueTreeNode>();

        if (parent == null) {
            results.add(new SimpleKeyValueTreeNode("root", "Requirements", true, parent, null));
        } else if (parent.getKey().equals("root")) {
            // provide the two root nodes
            results.add(new SimpleKeyValueTreeNode("hardware-requirements", "Hardware requirements", true, parent, null));
            results.add(new SimpleKeyValueTreeNode("software-requirements", "Software requirements", true, parent, null));

        } else if ("hardware-requirements".equals(parent.getKey())) {

            results.add(new SimpleKeyValueTreeNode("communication-requirement", "Communication", false, parent, null));
            results.add(new SimpleKeyValueTreeNode("computation-requirement", "Computation", false, parent, null));
            results.add(new SimpleKeyValueTreeNode("request-requirement", "HTTP requests handler", false, parent, null));
            results.add(new SimpleKeyValueTreeNode("storage-requirement", "Storage", false, parent, null));

        } else if ("software-requirements".equals(parent.getKey())) {

            results.add(new SimpleKeyValueTreeNode("software-requirements-db", "Database", true, parent, null));

        } else if ("software-requirements-db".equals(parent.getKey())) {

            results.add(new SimpleKeyValueTreeNode("software-requirements-db-sql", "SQL DB", false, parent, null));
            results.add(new SimpleKeyValueTreeNode("software-requirements-db-nosql", "NoSQL DB", false, parent, null));

        }

        return results;
    }

    private <H extends HardwareCategory> void retrieveHardwareCategories(List<DisplayableKeyValueTreeNode> results, Class<H> clazz, DisplayableKeyValueTreeNode parent) {
        try {
            Iterator<H> iterator = repositoryManager.getManager().getAll(clazz);

            while (iterator.hasNext()) {
                HardwareCategory category = iterator.next();

                if (Strings.isEmpty(category.getUriId()))
                    continue;

                if (Strings.isEmpty(category.getDescription()))
                    continue;

                HardwareCategoryModel hardwareCategoryModel = new HardwareCategoryMapper()
                        .from(category)
                        .toModel();

                DisplayableKeyValueTreeNode node = new SimpleKeyValueTreeNode(hardwareCategoryModel.getKey(), hardwareCategoryModel.getDisplayName(), false, parent, hardwareCategoryModel);

                results.add(node);

            }
        } catch (RDFBeanException e) {
            log.error("Error retrieving hardware categories", e);
        }

    }

    private <H extends SoftwareCategory> void retrieveSoftwareCategories(List<DisplayableKeyValueTreeNode> results, Class<H> clazz, DisplayableKeyValueTreeNode parent) {
        try {
            Iterator<H> iterator = repositoryManager.getManager().getAll(clazz);

            while (iterator.hasNext()) {
                SoftwareCategory category = iterator.next();

                if (Strings.isEmpty(category.getUriId()))
                    continue;

                if (Strings.isEmpty(category.getDescription()))
                    continue;

                SoftwareCategoryModel softwareCategoryModel = new SoftwareCategoryMapper()
                        .from(category)
                        .toModel();

                DisplayableKeyValueTreeNode node = new SimpleKeyValueTreeNode(softwareCategoryModel.getKey(), softwareCategoryModel.getDisplayName(), false, parent, softwareCategoryModel);

                results.add(node);

            }
        } catch (RDFBeanException e) {
            log.error("Error retrieving software categories", e);
        }

    }

}
