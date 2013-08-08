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
public abstract class BaseRepository<M extends DisplayableKeyValueModelData, S extends Thing> implements Dao<M> {

    final Logger logger = LoggerFactory.getLogger(BaseRepository.class);
    @Qualifier("repositoryManager")
    @Autowired
    private RepositoryManager repositoryManager;
    private Class<M> modelClass;
    private Class<? extends S> semanticClass;
    protected AbstractMapper<S, M> mapper;

    protected BaseRepository(Class<M> modelClass, Class<? extends S> semanticClass, AbstractMapper<S, M> mapper) {
        this.modelClass = modelClass;
        this.semanticClass = semanticClass;
        this.mapper = mapper;
    }

    @Override
    public String create(M model) {
        try {
            S instance = mapper.overWriteWith(model);
            instance.setUriId(getUUID());
            beforeCreate(instance);
            repositoryManager.getManager().add(instance);
            afterCreate(model);
            return instance.getUriId();
        } catch (RDFBeanException e) {
            logger.error("Error updating entity in the semantic repository.", e);
        }

        return null;
    }

    @Override
    public List<M> pagedList(int offset, int size) {
        return page(map(all()), offset, size);
    }

    @Override
    public List<M> list() {
        return map(all());
    }

    @Override
    public void update(M model) {
        try {
            repositoryManager.getManager().update(
                    mapper
                            .from(beforeUpdate(repositoryManager.getManager().get(model.getKey(), semanticClass)))
                            .overWriteWith(model)
            );
            afterUpdate(model);
        } catch (RDFBeanException e) {
            logger.error("Error updating entity in semantic repository.", e);
        }
    }

    @Override
    public void delete(M model) {
        try {
            beforeDelete(repositoryManager.getManager().get(model.getKey(), semanticClass));
            repositoryManager.getManager().delete(model.getKey(), semanticClass);
            afterDelete(model);
        } catch (RDFBeanException e) {
            logger.error("Error deleting entity {} in semantic repository.", model.getKey());
        }
    }

    @Override
    public M findByUriId(String uriId) {
        if (Strings.isEmpty(uriId) || Strings.NEW_INSTANCE.equals(uriId)) {
            try {
                return mapper.from(semanticClass.newInstance())
                        .toModel();
            } catch (InstantiationException e) {
                logger.error("Error instantiating the semantic instance.", e);
            } catch (IllegalAccessException e) {
                logger.error("Error instantiating the semantic instance.", e);
            }
        } else {
            return mapper
                    .from(retrieveSemanticEntityByUriId(uriId))
                    .toModel();
        }

        return null;
    }

    @Override
    public int count() {
        return all().size();
    }

    protected List<S> all() {

        List<S> semanticObjects = new ArrayList<S>();

        try {
            Iterator<? extends S> ite = repositoryManager.getManager().getAll(semanticClass);

            while (ite.hasNext())
                semanticObjects.add(ite.next());

        } catch (RDFBeanException e) {

            logger.error("Error retrieving semantic objects for class '{}'.", semanticClass);
        }

        return semanticObjects;

    }

    protected S retrieveSemanticEntityByUriId(String uriId) {
        return retrieveSemanticEntityByUriId(uriId, semanticClass);
    }

    protected <X extends Thing> X retrieveSemanticEntityByUriId(String uriId, Class<X> semanticClass) {
        try {
            return repositoryManager.getManager().get(uriId, semanticClass);
        } catch (RDFBeanException e) {
            logger.error("Error retrieving entity from the semantic repository.", e);
        }

        return null;
    }


    private <A> List<A> page(List<A> li, int offset, int limit) {
        return new ArrayList<A>(li.subList(Math.min(offset, li.size()),
                Math.min(offset + limit, li.size())));

    }

    protected List<M> map(List<S> semanticObjects) {
        List<M> entityModels = new ArrayList<M>();

        for (S semanticObject : semanticObjects)
            if (Strings.isNotEmpty(semanticObject.getUriId()))
                entityModels.add(
                        mapper
                                .from(semanticObject)
                                .toModel()
                );

        Collections.sort(entityModels, new Comparator<M>() {
            @Override
            public int compare(M model1, M model2) {
                return Strings.defaultString(model1.getDisplayName()).compareTo(Strings.defaultString(model2.getDisplayName()));
            }
        });

        return entityModels;
    }

    private String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    protected void beforeCreate(S instance) { }

    protected S beforeUpdate(S instance) {
        return instance;
    }

    protected void beforeDelete(S instance) { }

    protected void afterCreate(M model) {}

    protected void afterUpdate(M model) {}

    protected void afterDelete(M model) {}

}
