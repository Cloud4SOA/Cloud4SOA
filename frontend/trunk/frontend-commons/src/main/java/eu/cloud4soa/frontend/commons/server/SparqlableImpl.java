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

package eu.cloud4soa.frontend.commons.server;

import eu.cloud4soa.repository.utils.RepositoryManager;
import org.ontoware.aifbcommons.collection.ClosableIterable;
import org.ontoware.rdf2go.exception.MalformedQueryException;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.exception.QueryLanguageNotSupportedException;
import org.ontoware.rdf2go.model.QueryResultTable;
import org.ontoware.rdf2go.model.Sparqlable;
import org.ontoware.rdf2go.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A sparql endpoint that delegates to the soa layer managed model.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Service
public class SparqlableImpl implements Sparqlable {

    @Autowired
    private RepositoryManager repositoryManager;

    @Override
    public ClosableIterable<Statement> queryConstruct(String query, String querylanguage) throws QueryLanguageNotSupportedException, MalformedQueryException, ModelRuntimeException {
        return repositoryManager.getModel().queryConstruct(query, querylanguage);
    }

    @Override
    public QueryResultTable querySelect(String query, String querylanguage) throws QueryLanguageNotSupportedException, MalformedQueryException, ModelRuntimeException {
        return repositoryManager.getModel().querySelect(query, querylanguage);
    }

    @Override
    public boolean sparqlAsk(String query) throws ModelRuntimeException, MalformedQueryException {
        return repositoryManager.getModel().sparqlAsk(query);
    }

    @Override
    public ClosableIterable<Statement> sparqlConstruct(String query) throws ModelRuntimeException, MalformedQueryException {
        return repositoryManager.getModel().sparqlConstruct(query);
    }

    @Override
    public ClosableIterable<Statement> sparqlDescribe(String query) throws ModelRuntimeException {
        return repositoryManager.getModel().sparqlDescribe(query);
    }

    @Override
    public QueryResultTable sparqlSelect(String queryString) throws MalformedQueryException, ModelRuntimeException {
        return repositoryManager.getModel().sparqlSelect(queryString);
    }
}
