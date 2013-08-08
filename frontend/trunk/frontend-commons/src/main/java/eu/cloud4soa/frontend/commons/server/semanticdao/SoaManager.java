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

import com.viceversatech.rdfbeans.exceptions.RDFBeanException;
import eu.cloud4soa.api.datamodel.semantic.Thing;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;
import eu.cloud4soa.repository.utils.RepositoryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

/**
 * Base class for services that deal with the SOA repository manager.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public abstract class SoaManager {

    final Logger logger = LoggerFactory.getLogger(SoaManager.class);
    @Qualifier("repositoryManager")
    @Autowired
    private RepositoryManager repositoryManager;

    protected <S extends Thing> List<S> retrieveRdfBeans(Class<? extends S> rdfClass) {

        List<S> rdfBeans = new ArrayList<S>();

        try {
            Iterator<? extends S> ite = repositoryManager.getManager().getAll(rdfClass);

            while (ite.hasNext())
                rdfBeans.add(ite.next());

        } catch (RDFBeanException e) {

            logger.error("Error retrieving rdf beans for class '{}'.", rdfClass);
        }

        return rdfBeans;

    }

    protected <E extends DisplayableKeyValueModelData, S extends Thing> List<E> retrieveModels(Class<? extends S> rdfClass, AbstractMapper<S, E> mapper) {
        return map(retrieveRdfBeans(rdfClass), mapper);
    }

    protected <E extends DisplayableKeyValueModelData, S extends Thing> List<E> map(List<S> rdfBeans, AbstractMapper<S, E> mapper) {
        List<E> entityModels = new ArrayList<E>();

        for (S rdfBean : rdfBeans)
            if (Strings.isNotEmpty(rdfBean.getUriId()))
                entityModels.add(
                        mapper
                                .from(rdfBean)
                                .toModel()
                );

        Collections.sort(entityModels, new Comparator<E>() {
            @Override
            public int compare(E model1, E model2) {
                return Strings.defaultString(model1.getDisplayName()).compareTo(Strings.defaultString(model2.getDisplayName()));
            }
        });

        return entityModels;
    }


    protected <S extends Thing> S retrieveRdfBeanByUriId(String uriId, Class<S> rdfClass) {
        try {
            return repositoryManager.getManager().get(uriId, rdfClass);
        } catch (RDFBeanException e) {
            logger.error("Error retrieving entity from the SOA layer.", e);
        }

        return null;
    }


    protected <E extends DisplayableKeyValueModelData, S extends Thing> E retrieveModelByUriId(String uriId, Class<S> rdfClass, AbstractMapper<S, E> mapper) {

        if (Strings.isEmpty(uriId) || Strings.NEW_INSTANCE.equals(uriId)) {
            try {
                return mapper.from(rdfClass.newInstance())
                        .toModel();
            } catch (InstantiationException e) {
                logger.error("Error instantiating the soa instance.", e);
            } catch (IllegalAccessException e) {
                logger.error("Error instantiating the soa instance.", e);
            }
        } else {
            try {
                return mapper
                        .from(repositoryManager.getManager().get(uriId, rdfClass))
                        .toModel();
            } catch (RDFBeanException e) {
                logger.error("Error retrieving entity from the SOA layer.", e);
            }
        }

        return null;
    }

    protected <E extends DisplayableKeyValueModelData, S extends Thing> void update(E model, Class<S> rdfClass, AbstractMapper<S, E> mapper) {
        try {
            repositoryManager.getManager().update(
                    mapper
                            .from(repositoryManager.getManager().get(model.getKey(), rdfClass))
                            .overWriteWith(model)
            );

        } catch (RDFBeanException e) {
            logger.error("Error updating entity in the SOA layer.", e);
        }
    }

    protected <E extends DisplayableKeyValueModelData, S extends Thing> String store(E model, AbstractMapper<S, E> mapper) {
        try {

            S instance = mapper.overWriteWith(model);
            instance.setUriId(getUUID());
            repositoryManager.getManager().add(instance);

            return instance.getUriId();
        } catch (RDFBeanException e) {
            logger.error("Error updating entity in the SOA layer.", e);
        }

        return null;
    }

    private String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


}
