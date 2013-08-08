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

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.SimpleKeyValue;
import org.ontoware.rdf2go.model.QueryResultTable;
import org.ontoware.rdf2go.model.QueryRow;
import org.ontoware.rdf2go.model.Sparqlable;
import org.ontoware.rdf2go.model.node.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An implementation of the dynamic entity manager that retrieve entities from the SPARQL database
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
@Component
public class SoaDynamicEntityManager implements DynamicEntityManager {

    private Logger log = LoggerFactory.getLogger(SoaDynamicEntityManager.class);

    @Autowired
    private Sparqlable model;


    @Override
    public List<DisplayableKeyValue> retrieveAllEntities(String type) {

        StringBuilder sb = new StringBuilder()
                .append(" PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>")
                .append(" PREFIX dcterms:<http://purl.org/dc/terms/>")
                .append(" SELECT ?ent ?title WHERE {")
                .append("   ?ent a <").append(type).append("> .")
                .append("   ?ent dcterms:title ?title")
                .append(" }")
                .append(" ORDER BY ?title");

        QueryResultTable resultTable = model.sparqlSelect(sb.toString());

        List<DisplayableKeyValue> results = new ArrayList<DisplayableKeyValue>();

        for (QueryRow row : resultTable)
            if (row.getValue("ent") instanceof URI) {
                results.add(new SimpleKeyValue(
                        row.getValue("ent").asURI().asJavaURI().getFragment(),
                        row.getLiteralValue("title")
                ));
            } else
                log.warn("Entity {} is not an URI.", row.getValue("ent").toString());


        return results;
    }

    @Override
    public DisplayableKeyValue retrieveOneEntity(String type, String key) {

        StringBuilder sb = new StringBuilder()
                .append(" PREFIX dcterms:<http://purl.org/dc/terms/> ")
                .append(" PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> ")
                .append(" SELECT ?title")
                .append("  WHERE {")
                .append(" <").append(key).append("> dcterms:title ?title")
                .append("}");

        QueryResultTable resultTable = model.sparqlSelect(sb.toString());

        Iterator<QueryRow> iter = resultTable.iterator();

        if (iter.hasNext()) {
            QueryRow row = iter.next();
            return new SimpleKeyValue(key, row.getLiteralValue("title"));
        } else {
            log.warn("No title found for key {}.", key);
            return null;
        }
    }
}
