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

import com.google.gwt.user.client.rpc.InvocationException;
import com.viceversatech.rdfbeans.exceptions.RDFBeanException;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.FacetValue;
import eu.cloud4soa.repository.utils.RepositoryManager;
import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.model.QueryResultTable;
import org.ontoware.rdf2go.model.QueryRow;
import org.ontoware.rdf2go.model.node.Literal;
import org.ontoware.rdf2go.model.node.Node;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Facet search service
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
@Transactional
@Service
public class FacetedSearch {

    private final Logger logger = LoggerFactory.getLogger(FacetedSearch.class);


    // Knowledge base (KB) access
    @Qualifier("repositoryManager")
    @Autowired
    private RepositoryManager repositoryManager;


    // KB namespaces and ontology properties
    private URI type = new URIImpl(
            "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", true);
    private URI label = new URIImpl(
            "http://www.w3.org/2000/01/rdf-schema#label", true);
    private URI comment = new URIImpl(
            "http://www.w3.org/2000/01/rdf-schema#comment", true);
    private URI range = new URIImpl(
            "http://www.w3.org/2000/01/rdf-schema#range", true);
    private URI PaaSOffering = new URIImpl(
            "http://www.cloud4soa.eu/v0.1/paas-model#PaaSOffering", true);
    private URI title = new URIImpl("http://purl.org/dc/terms/title", true);
    private URI description = new URIImpl("http://purl.org/dc/terms/description", true);
    private URI objectProperty = new URIImpl(
            "http://www.w3.org/2002/07/owl#ObjectProperty", true);
    private String C4S_NAMESPACE = "http://www.cloud4soa.eu/v0.1/paas-model#";
    private URI offerHardwareComponent = new URIImpl(
            "http://www.cloud4soa.eu/v0.1/paas-model#offerHardwareComponent", true);
    private URI offerSoftware = new URIImpl(
            "http://www.cloud4soa.eu/v0.1/paas-model#offerSoftware", true);
    private URI realisation_of_technology_capability = new URIImpl(
            "http://www.enterprise-architecture.org/essential-metamodel.owl#realisation_of_technology_capability", true);
    private URI related_sw_category = new URIImpl(
            "http://www.cloud4soa.eu/v0.1/infrastructural-domain#related_sw_category", true);


    private List<Facet> availableFacets;


    public List<Facet> filterFacets(List<String> offeringIds) {
        List<Facet> facets = new ArrayList<Facet>();

        filterPaaSPropertyFacet(facets, offeringIds);
        filterPaaSComponentCategoryFacet(offerHardwareComponent, facets, offeringIds);
        filterPaaSComponentCategoryFacet(offerSoftware, facets, offeringIds);

        return facets;
    }


    public List<Facet> getAvailableFacets() {
        if (availableFacets == null || availableFacets.size() == 0) {
            availableFacets = getFacets();
        }

        return availableFacets;
    }


    private List<String> readPaaSOfferingURIs(List<Map<String, String>> queryResults) {
        List<String> uris = new ArrayList<String>();
        for (Map<String, String> row : queryResults) {
            uris.add(row.get("po"));
        }

        return uris;
    }


    /**
     * Multiple facet selection is understood as OR Different facet types are
     * understood as AND This version uses the SPARQL endpoint
     *
     * @param facets
     * @return
     * @throws com.viceversatech.rdfbeans.exceptions.RDFBeanException
     *
     */
    public List<PaaSInstance> facetedSearchSPARQL(List<Facet> facets)
            throws InvocationException {
        // Algorithm based on querying and matching PaaS Instances using the
        // SPARQL endpoint
        // Create SPARQL query from facets
        // Send query and collect results
        // Create matching PaaS offerings from received PaaS offerings URIs
        if (facets.isEmpty()) {
            return new ArrayList<PaaSInstance>();
        }

        String query = createQuery(facets);
        List<Map<String, String>> queryResults = selectQuery(query);
        List<String> uris = readPaaSOfferingURIs(queryResults);
        try {
            return getPaaSOfferings(uris);
        } catch (Exception e) {
            String msg = "Error in facetedSearchSPARQL retrieving matching PaaS offerings";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

    }


    private String createQuery(List<Facet> facets) {
        StringBuffer query = new StringBuffer("SELECT DISTINCT ?po where {\n");
        query.append("?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL()
                + " .\n");

        int i = 0; // Variable index
        for (Facet facet : facets) {
            switch (facet.getQueryType()) {
                case COMPONENT_TITLE:
                    addFacetTitleQuery(query, facet, i);
                    break;
                case COMPONENT_CATEGORY:
                    addFacetComponentCategoryQuery(query, facet, i);
                    break;
            }
            i++;
        }
        query.append("\n}");
        return query.toString();
    }


    private void addFacetTitleQuery(StringBuffer query, Facet facet, int index) {
        query.append("?po <" + facet.getType() + "> ?p" + index + " .\n");
        query.append("?p" + index + " " + title.toSPARQL() + " ?t" + index
                + " .\n");
        query.append("FILTER (");
        int numFacetValues = facet.getValues().size();
        String lastFacetValue = facet.getValues().get(numFacetValues - 1).getValue();
        for (FacetValue facetValue : facet.getValues()) {
            query.append("REGEX (?t" + index + ", '" + facetValue.getValue() + "', 'i')");
            if (numFacetValues > 1 && !facetValue.getValue().equals(lastFacetValue)) {
                query.append(" || ");
            }
        }
        query.append(").\n");
    }

    private void addFacetComponentCategoryQuery(StringBuffer query, Facet facet, int index) {
        query.append("?po <" + facet.getType() + "> ?co" + index + " .\n");
        query.append("?co" + index + " " + getCategoryProperty(new URIImpl(facet.getType())).toSPARQL() + " ?cat" + index + " .\n");
        query.append("?cat" + index + " " + type.toSPARQL() + " <" + facet.getCategory() + "> .\n");
        query.append("?cat" + index + " " + title.toSPARQL() + " ?t" + index + " .\n");
        query.append("FILTER (");
        int numFacetValues = facet.getValues().size();
        String lastFacetValue = facet.getValues().get(numFacetValues - 1).getValue();
        for (FacetValue facetValue : facet.getValues()) {
            query.append("REGEX (?t" + index + ", '" + facetValue.getValue() + "', 'i')");
            if (numFacetValues > 1 && !facetValue.getValue().equals(lastFacetValue)) {
                query.append(" || ");
            }
        }
        query.append(").\n");
    }

    private List<PaaSInstance> getPaaSOfferings(List<String> uris)
            throws RDFBeanException {
        List<PaaSInstance> result = new ArrayList<PaaSInstance>();
        for (String uri : uris) {
            if (uri.indexOf("#") != -1) {
                uri = uri.substring(uri.lastIndexOf("#") + 1);
            }

            if (uri.indexOf("/") != -1) {
                uri = uri.substring(uri.lastIndexOf("/") + 1);
            }
            eu.cloud4soa.api.datamodel.semantic.paas.PaaSOffering paaSOffering = repositoryManager
                    .getManager()
                    .get(uri, eu.cloud4soa.api.datamodel.semantic.paas.PaaSOffering.class);
            PaaSInstance paaSInstance = new PaaSInstance(paaSOffering);
            result.add(paaSInstance);
        }
        return result;
    }

    private List<Facet> filterPaaSPropertyFacet(List<Facet> facets, List<String> offeringIds) {
        // Get PaaSOffering property candidates for facet types from selected
        // offerings
        String query = "SELECT DISTINCT ?property ?label ?comment WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po ?property ?pp . "
                + "?property " + type.toSPARQL() + " " + objectProperty.toSPARQL() + " ."
                + "?property " + range.toSPARQL() + "?range ."
                + "?range " + label.toSPARQL() + " ?label ."
                + "?range " + comment.toSPARQL() + " ?comment .}";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String type = row.get("property");
            String label = row.get("label");
            String comment = row.get("comment");
            // Get Facet values
            List<FacetValue> values = new ArrayList<FacetValue>();
            Facet.QueryType queryType = getFilteredFacetValues(type, values, offeringIds);
            Facet facet = new Facet(type, null, label, comment, queryType, values);
            if (availableFacets.contains(facet) &&
                    !type.equals(offerHardwareComponent.toString()) &&
                    !type.equals(offerSoftware.toString())) // Filter only available facets
                facets.add(facet);
        }

        return facets;
    }


    private Facet.QueryType getFilteredFacetValues(String facetType, List<FacetValue> values,
                                                   List<String> offeringIds) {
        Facet.QueryType queryType = Facet.QueryType.COMPONENT_TITLE;
        // Trying dcterms:title
        StringBuffer query = new StringBuffer("SELECT DISTINCT ?" + FacetValue.FACET_VALUE_VARIABLE + " ?"
                + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + "  WHERE { ");
        queryAppendOfferingIds(facetType, offeringIds, query);
        query.append("?ft " + title.toSPARQL() + " ?" + FacetValue.FACET_VALUE_VARIABLE + " . ");
        query.append("OPTIONAL {?ft " + description.toSPARQL() + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " . } }");

        getValues(query.toString(), values);


        return values.isEmpty() ? Facet.QueryType.NONE : queryType;
    }


    private void filterPaaSComponentCategoryFacet(URI facetType, List<Facet> facets, List<String> offeringIds) {
        String query = "SELECT DISTINCT ?cattype ?label ?comment WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + facetType.toSPARQL() + " ?co . "
                + "?co " + getCategoryProperty(facetType).toSPARQL() + " ?cat ."
                + "?cat " + type.toSPARQL() + " ?cattype ."
                + "?cattype " + label.toSPARQL() + " ?label ."
                + "optional {?cattype " + comment.toSPARQL() + " ?comment .} }";
        List<Map<String, String>> results = selectQuery(query);

        for (Map<String, String> row : results) {
            String label = row.get("label");
            String comment = row.get("comment");
            String catType = row.get("cattype");

            // Get Facet values
            List<FacetValue> values = new ArrayList<FacetValue>();
            Facet.QueryType queryType = getFilteredComponentFacetValues(facetType, catType, values, offeringIds);
            Facet facet = new Facet(facetType.toString(), catType, label, comment, queryType, values);
            if (availableFacets.contains(facet)) {
                facets.add(facet);
            }
        }
    }


    private Facet.QueryType getFilteredComponentFacetValues(URI facetType, String catType, List<FacetValue> values, List<String> offeringIds) {
        Facet.QueryType queryType = Facet.QueryType.COMPONENT_CATEGORY;

        // Trying dcterms:title obtained from property range objects
        StringBuffer query = new StringBuffer("SELECT DISTINCT ?" + FacetValue.FACET_VALUE_VARIABLE
                + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " WHERE { ");
        queryAppendOfferingIds(facetType.toString(), offeringIds, query);
        query.append("?ft " + getCategoryProperty(facetType).toSPARQL() + " ?cat .");
        query.append("?cat " + type.toSPARQL() + " <" + catType + "> .");
        query.append("?cat " + title.toSPARQL() + " ?" + FacetValue.FACET_VALUE_VARIABLE + " . ");
        query.append("OPTIONAL {?cat " + description.toSPARQL() + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " .} }");

        getValues(query.toString(), values);

        return values.isEmpty() ? Facet.QueryType.NONE : queryType;

    }


    private void queryAppendOfferingIds(String facetType,
                                        List<String> offeringIds, StringBuffer query) {
        int numOfferings = offeringIds.size();
        String lastOffering = offeringIds.get(numOfferings - 1);
        for (String offerId : offeringIds) {
            query.append("{" + offeringToSPARQL(offerId) + " <" + facetType
                    + "> ?ft . ");
            query.append("}\n");
            if (numOfferings > 1 && !offerId.equals(lastOffering)) {
                query.append("\nUNION\n");
            }
        }
    }


    private String offeringToSPARQL(String offerId) {
        return "<" + C4S_NAMESPACE + offerId + ">";
    }


    /**
     * Obtain facets by inspecting PaaS Offering properties.
     * Special cases are hardware and software components, which are treated separately
     */
    private List<Facet> getFacets() {
        List<Facet> facets = new ArrayList<Facet>();
        getPaaSPropertyFacet(facets);
        getPaaSComponentCategoryFacet(offerHardwareComponent, facets);
        getPaaSComponentCategoryFacet(offerSoftware, facets);
        return facets;
    }


    private void getPaaSPropertyFacet(List<Facet> facets) {
        // Get PaaSOffering property candidates for facet types
        String query = "SELECT DISTINCT ?property ?label ?comment WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po ?property ?pp . "
                + "?property " + type.toSPARQL() + " " + objectProperty.toSPARQL() + " ."
                + "?property " + range.toSPARQL() + " ?range ."
                + "?range " + label.toSPARQL() + " ?label ."
                + "?range " + comment.toSPARQL() + " ?comment .}";
        List<Map<String, String>> results = selectQuery(query);
        //TODO Evaluate how to generalise the access to facet values without using specific cases for software and hardware components
        //TODO Encode the facet query into the Facet entity to simplify querying
        for (Map<String, String> row : results) {
            String type = row.get("property");
            String label = row.get("label");
            String comment = row.get("comment");
            // Get Facet values
            List<FacetValue> values = new ArrayList<FacetValue>();
            Facet.QueryType queryType = getFacetValues(type, values);
            if (!values.isEmpty() &&
                    !type.equals(offerHardwareComponent.toString()) &&
                    !type.equals(offerSoftware.toString()))
                facets.add(new Facet(type, null, label, comment, queryType, values));
        }
    }


    /**
     * Personalise the way Hardware/Software Component facet are obtained through their categories
     *
     * @param facets
     */
    private void getPaaSComponentCategoryFacet(URI facetType, List<Facet> facets) {

        String query = "SELECT DISTINCT ?cattype ?label ?comment WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + facetType.toSPARQL() + " ?co . "
                + "?co " + getCategoryProperty(facetType).toSPARQL() + " ?cat ."
                + "?cat " + type.toSPARQL() + " ?cattype ."
                + "?cattype " + label.toSPARQL() + " ?label ."
                + "optional {?cattype " + comment.toSPARQL() + " ?comment .} }";
        List<Map<String, String>> results = selectQuery(query);

        for (Map<String, String> row : results) {
            String label = row.get("label");
            String comment = row.get("comment");
            String catType = row.get("cattype");

            // Get Facet values
            List<FacetValue> values = new ArrayList<FacetValue>();
            Facet.QueryType queryType = getComponentFacetValues(facetType, catType, values);
            if (!values.isEmpty())
                facets.add(new Facet(facetType.toString(), catType, label, comment, queryType, values));

        }
    }


    /**
     * Get the property that relates the component with its category depending on the component type
     *
     * @param type Component type corresponds to the kind of PaaS Offering property, either offerSoftware or offerHardwareComponent
     * @return
     */
    private URI getCategoryProperty(URI type) {
        URI categoryProperty = null;
        if (type.toSPARQL().equals(offerSoftware.toSPARQL()))
            categoryProperty = related_sw_category;
        else if (type.toSPARQL().equals(offerHardwareComponent.toSPARQL()))
            categoryProperty = realisation_of_technology_capability;
        return categoryProperty;
    }


    /**
     * Populates facet values corresponding to given facet type (property of PaaS Offering)
     *
     * @param facetType property of PaaS Offering
     * @param values    facet values as instances connected to the
     * @return QueryType used to obtain facet values @see QueryType
     */
    private Facet.QueryType getFacetValues(String facetType, List<FacetValue> values) {
        Facet.QueryType queryType = Facet.QueryType.COMPONENT_TITLE;

        // Trying dcterms:title obtained from property range objects
        String query = "SELECT DISTINCT ?" + FacetValue.FACET_VALUE_VARIABLE
                + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po <" + facetType + "> ?ft . "
                + "?ft " + title.toSPARQL() + " ?" + FacetValue.FACET_VALUE_VARIABLE + " . "
                + "OPTIONAL {?ft " + description.toSPARQL() + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " .} }";
        getValues(query, values);

        return values.isEmpty() ? Facet.QueryType.NONE : queryType;
    }


    /**
     * Populates facet values corresponding to given facet type category (property of PaaS Offering)
     *
     * @param facetType property of PaaS Offering
     * @param values    facet values as instances connected to the
     * @return QueryType used to obtain facet values @see QueryType
     */
    private Facet.QueryType getComponentFacetValues(URI facetType, String catType, List<FacetValue> values) {
        Facet.QueryType queryType = Facet.QueryType.COMPONENT_CATEGORY;

        // Trying dcterms:title obtained from property range objects
        String query = "SELECT DISTINCT ?" + FacetValue.FACET_VALUE_VARIABLE
                + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + facetType.toSPARQL() + " ?co . "
                + "?co " + getCategoryProperty(facetType).toSPARQL() + " ?cat ."
                + "?cat " + type.toSPARQL() + " <" + catType + "> ."
                + "?cat " + title.toSPARQL() + " ?" + FacetValue.FACET_VALUE_VARIABLE + " . "
                + "OPTIONAL {?cat " + description.toSPARQL() + " ?" + FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE + " .} }";
        getValues(query, values);

        return values.isEmpty() ? Facet.QueryType.NONE : queryType;

    }


    private void getValues(String query, List<FacetValue> values) {
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            FacetValue fv = new FacetValue(
                    row.get(FacetValue.FACET_VALUE_VARIABLE),
                    row.get(FacetValue.FACET_VALUE_DESCRIPTION_VARIABLE));
            values.add(fv);
        }
    }


    private List<Map<String, String>> selectQuery(String query) {
        List<Map<String, String>> results = new ArrayList<Map<String, String>>();
        QueryResultTable qrt = repositoryManager.getManager().getModel()
                .sparqlSelect(query);
        ClosableIterator<QueryRow> ci = qrt.iterator();

        List<String> variables = qrt.getVariables();
        while (ci.hasNext()) {
            QueryRow row = ci.next();
            Map<String, String> rowResults = new HashMap<String, String>();
            for (String v : variables) {
                Node node = row.getValue(v);
                String value = null;
                if (node instanceof Literal) {
                    value = node.asLiteral().getValue();
                } else if (node instanceof Resource) {
                    value = node.asResource().toString();
                }
                rowResults.put(v, value);
            }
            results.add(rowResults);
        }

        return results;
    }

}
