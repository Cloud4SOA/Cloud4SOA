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

import com.google.gwt.user.client.rpc.InvocationException;
import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.repository.utils.RepositoryManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.model.QueryResultTable;
import org.ontoware.rdf2go.model.QueryRow;
import org.ontoware.rdf2go.model.node.Literal;
import org.ontoware.rdf2go.model.node.Node;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/frontend.xml"})
public class RepositoryManagerTest {

    @Autowired
    private RepositoryManager repositoryManager;
    //Namespaces
    //	@prefix dcterms:  <http://purl.org/dc/terms/> .
    //	@prefix paas-m:  <http://www.cloud4soa.eu/v0.1/paas-model#> .
    //	@prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
    //	@prefix essential-metamodel:  <http://www.enterprise-architecture.org/essential-metamodel.owl#> .

    URI type = new URIImpl("http://www.w3.org/1999/02/22-rdf-syntax-ns#type", true);
    URI objectProperty = new URIImpl("http://www.w3.org/2002/07/owl#ObjectProperty", true);
    URI providedByPaaSProvider = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#providedByPaaSProvider", true);
    URI PaaSOffering = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#PaaSOffering", true);
    URI supportLanguage = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#supportLanguage", true);
    URI hasRating = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#hasRating", true);
    URI hasValue = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#hasValue", true);
    URI offerSoftware = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#offerSoftware", true);
    URI offerHardwareComponent = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#offerHardwareComponent", true);
    URI communicateThrough = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#communicateThrough", true);
    URI hasPricingPolicy = new URIImpl("http://www.cloud4soa.eu/v0.1/paas-model#hasPricingPolicy", true);
    URI title = new URIImpl("http://purl.org/dc/terms/title", true);
    URI description = new URIImpl("http://purl.org/dc/terms/description", true);
    URI realisation_of_technology_capability = new URIImpl("http://www.enterprise-architecture.org/essential-metamodel.owl#realisation_of_technology_capability", true);
    String C4S_NAMESPACE = "http://www.cloud4soa.eu/v0.1/paas-model#";

    private List<Map<String, String>> selectQuery(String query) {
        List<Map<String, String>> results = new ArrayList<Map<String, String>>();
        QueryResultTable qrt = repositoryManager.getManager().getModel().sparqlSelect(query);
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

//	SELECT DISTINCT ?ppname
//		WHERE {
//		    ?po rdf:type paas-m:PaaSOffering .
//			?po paas-m:providedByPaaSProvider ?pp .
//			?pp dcterms:title ?ppname
//		}


    @Test
    public void queryPaaSProviderTest() {
        System.out.println("Retriving PaaS Providers -----");
        String query = "SELECT DISTINCT ?ppname WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + providedByPaaSProvider.toSPARQL() + " ?pp . "
                + "?pp " + title.toSPARQL() + " ?ppname . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String r = row.get("ppname");
            System.out.println("PaaS Provider: " + r);
        }
    }


//	SELECT DISTINCT ?l
//			WHERE {
//			    ?po rdf:type paas-m:PaaSOffering .
//				?po paas-m:supportLanguage ?pol .
//				?pol dcterms:title ?l .
//			}


    @Test
    public void queryProgrammingLanguagesTest() {
        System.out.println("Retriving Programming Languages ----");
        String query = "SELECT DISTINCT ?l WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + supportLanguage.toSPARQL() + " ?pol . "
                + "?pol " + title.toSPARQL() + " ?l . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String l = row.get("l");
            System.out.println("Programming Language: " + l);
        }
    }

//	SELECT DISTINCT ?v
//	WHERE {
//	    ?po rdf:type paas-m:PaaSOffering .
//		?po paas-m:hasRating ?r .
//		?r paas-m:hasValue ?v .
//	}


    @Test
    public void queryRatingsTest() {
        System.out.println("Retriving Ratings ----");
        String query = "SELECT DISTINCT ?v WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + hasRating.toSPARQL() + " ?r . "
                + "?r " + hasValue.toSPARQL() + " ?v . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String v = row.get("v");
            System.out.println("Rating: " + v);
        }
    }

//	SELECT DISTINCT ?s
//			WHERE {
//			    ?po rdf:type paas-m:PaaSOffering .
//				?po paas-m:offerSoftware ?sc .
//				?sc dcterms:title ?s .
//			}


    @Test
    public void querySoftwareComponentsTest() {
        System.out.println("Retriving Software Components ----");
        String query = "SELECT DISTINCT ?s WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + offerSoftware.toSPARQL() + " ?sc . "
                + "?sc " + title.toSPARQL() + " ?s . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String s = row.get("s");
            System.out.println("Software component: " + s);
        }
    }

//	SELECT DISTINCT ?t ?h
//			WHERE {
//			    ?po rdf:type paas-m:PaaSOffering .
//				?po paas-m:offerHardwareComponent ?hc .
//				?hc essential-metamodel:realisation_of_technology_capability ?tc .
//				?tc rdf:type ?t .
//				?tc dcterms:title ?h .
//			}


    @Test
    public void queryHardwareComponentsTest() {
        System.out.println("Retriving Hardware Components ----");
        String query = "SELECT DISTINCT * WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + offerHardwareComponent.toSPARQL() + " ?hc . "
                + "?hc " + realisation_of_technology_capability.toSPARQL() + " ?tc . "
                + "?tc " + type.toSPARQL() + " ?t . "
                + "?tc " + title.toSPARQL() + " ?h . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String t = row.get("t");
            String h = row.get("h");
            System.out.println("Hardware component: " + h + " of type " + t);
        }
    }

//	SELECT DISTINCT ?t ?d
//			WHERE {
//			    ?po rdf:type paas-m:PaaSOffering .
//				?po paas-m:communicateThrough ?ch .
//				?ch rdf:type ?t .
//				?ch dcterms:description ?d .
//			}	


    @Test
    public void queryChannelsTest() {
        System.out.println("Retriving Channels ----");
        String query = "SELECT DISTINCT ?t ?d WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + communicateThrough.toSPARQL() + " ?ch . "
                + "?ch " + type.toSPARQL() + " ?t . "
                + "?tc " + description.toSPARQL() + " ?d . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String t = row.get("t");
            String d = row.get("d");
            System.out.println("Channel: " + d + " of type " + t);
        }
    }

//	SELECT DISTINCT ?t
//			WHERE {
//			    ?po rdf:type paas-m:PaaSOffering .
//				?po paas-m:hasPricingPolicy ?pp .
//				?pp dcterms:title ?t
//			}


    @Test
    public void queryPricingPoliciesTest() {
        System.out.println("Retriving Pricing Policies ----");
        String query = "SELECT DISTINCT ?t WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po " + hasPricingPolicy.toSPARQL() + " ?pp . "
                + "?pp " + title.toSPARQL() + " ?t . }";
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            String t = row.get("t");
            System.out.println("Pricing Policy: " + t);
        }
    }

    //Dynamic Faceted Search by realtime inspecting of semantic repository


    @Test
    public void getFacetsTest() {
        List<Facet> facets = getFacets();
        Assert.assertTrue(facets != null & facets.size() != 0);
        for (Facet facet : facets) {
            System.out.println("Facet:  " + facet.getDisplayableType() + ". Values: " + facet.getValues());
        }
    }

    @Test
    public void filterFacetsTest() {
        List<Facet> facets = filterFacets(Arrays.asList(new String[]{"Heroku", "Azure"}));
        Assert.assertTrue(facets != null & facets.size() != 0);
        for (Facet facet : facets) {
            System.out.println("Facet:  " + facet.getDisplayableType() + ". Values: " + facet.getValues());
        }
    }


    public List<Facet> filterFacets(List<String> offeringIds) {
        //Get PaaSOffering property candidates for facet types from selected offerings
        String query = "SELECT DISTINCT ?property WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po ?property ?pp . "
                + "?property " + type.toSPARQL() + " " + objectProperty.toSPARQL() + " . }";
        List<Map<String, String>> results = selectQuery(query);
        List<Facet> facets = new ArrayList<Facet>();
        for (Map<String, String> row : results) {
            String type = row.get("property");
            //Get Facet values
            List<String> values = new ArrayList<String>();
            QueryType queryType = getFacetValues(type, values, offeringIds);
            facets.add(new Facet(type, queryType, values));
        }

        return facets;
    }


    public List<Facet> getFacets() {
        //Get PaaSOffering property candidates for facet types
        String query = "SELECT DISTINCT ?property WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po ?property ?pp . "
                + "?property " + type.toSPARQL() + " " + objectProperty.toSPARQL() + " . }";
        List<Map<String, String>> results = selectQuery(query);
        List<Facet> facets = new ArrayList<Facet>();
        for (Map<String, String> row : results) {
            String type = row.get("property");
            //Get Facet values
            List<String> values = new ArrayList<String>();
            QueryType queryType = getFacetValues(type, values);
            facets.add(new Facet(type, queryType, values));
        }

        return facets;
    }

    private QueryType getFacetValues(String facetType, List<String> values) {
        QueryType queryType = QueryType.TITLE;
        //Trying dcterms:title
        String query = "SELECT DISTINCT ?v  WHERE { "
                + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                + "?po <" + facetType + "> ?ft . "
                + "?ft " + title.toSPARQL() + " ?v . }";
        getValues(query, "v", values);

        if (values.isEmpty()) {
            //Trying rdf:type
            query = "SELECT DISTINCT ?v  WHERE { "
                    + "?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " . "
                    + "?po <" + facetType + "> ?ft . "
                    + "?ft " + type.toSPARQL() + " ?v . }";
            getValues(query, "v", values);
            queryType = QueryType.TYPE;
        }
        return queryType;
    }


    private QueryType getFacetValues(String facetType, List<String> values, List<String> offeringIds) {
        QueryType queryType = QueryType.TITLE;
        //Trying dcterms:title
        StringBuffer query = new StringBuffer("SELECT DISTINCT ?v  WHERE { ");
        queryAppendOfferingIds(facetType, offeringIds, query);
        query.append("?ft " + title.toSPARQL() + " ?v . }");
        getValues(query.toString(), "v", values);

        if (values.isEmpty()) {
            //Trying rdf:type
            query = new StringBuffer("SELECT DISTINCT ?v  WHERE { ");
            queryAppendOfferingIds(facetType, offeringIds, query);
            query.append("?ft " + type.toSPARQL() + " ?v . }");
            getValues(query.toString(), "v", values);
            queryType = QueryType.TYPE;
        }
        return queryType;
    }

    private void queryAppendOfferingIds(String facetType,
                                        List<String> offeringIds, StringBuffer query) {
        int numOfferings = offeringIds.size();
        String lastOffering = offeringIds.get(numOfferings - 1);
        for (String offerId : offeringIds) {
            query.append("{" + offeringToSPARQL(offerId) + " <" + facetType + "> ?ft . ");
            query.append("}\n");
            if (numOfferings > 1 && !offerId.equals(lastOffering)) {
                query.append("\nUNION\n");
            }
        }
    }

    private String offeringToSPARQL(String offerId) {
        return "<" + C4S_NAMESPACE + offerId + ">";
    }

    private void getValues(String query, String variable, List<String> values) {
        List<Map<String, String>> results = selectQuery(query);
        for (Map<String, String> row : results) {
            values.add(row.get(variable));
        }
    }


    @Test
    public void facetedSearchSPARQLTest() {
        List<Facet> facets = new ArrayList<Facet>();
        //Type based facet
        List<String> values = new ArrayList<String>();
        values.add("http://www.cloud4soa.eu/v0.1/paas-model#API");
        facets.add(new Facet("http://www.cloud4soa.eu/v0.1/paas-model#communicateThrough", QueryType.TYPE, values));

        //Type based facet
        values = new ArrayList<String>();
        values.add("CloudBees");
        values.add("Microsoft");
        facets.add(new Facet("http://www.cloud4soa.eu/v0.1/paas-model#providedByPaaSProvider", QueryType.TITLE, values));

        List<String> offerings = facetedSearchSPARQL(facets);
        Assert.assertTrue(offerings != null & offerings.size() != 0);
        for (String offer : offerings) {
            System.out.println("Offer:  " + offer);
        }
    }

    @Test
    public void facetedSearchSPARQLTitleQueryTest() {
        List<Facet> facets = new ArrayList<Facet>();
        String type = "http://www.cloud4soa.eu/v0.1/paas-model#providedByPaaSProvider";
        QueryType queryType = QueryType.TITLE;
        List<String> values = new ArrayList<String>();
        values.add("CloudBees");
        values.add("Microsoft");
        facets.add(new Facet(type, queryType, values));

        List<String> offerings = facetedSearchSPARQL(facets);
        Assert.assertTrue(offerings != null & offerings.size() != 0);
        for (String offer : offerings) {
            System.out.println("Offer:  " + offer);
        }
    }

    @Test
    public void facetedSearchSPARQLTypeQueryTest() {
        List<Facet> facets = new ArrayList<Facet>();
        String type = "http://www.cloud4soa.eu/v0.1/paas-model#communicateThrough";
        QueryType queryType = QueryType.TYPE;
        List<String> values = new ArrayList<String>();
        values.add("http://www.cloud4soa.eu/v0.1/paas-model#API");
        facets.add(new Facet(type, queryType, values));

        List<String> offerings = facetedSearchSPARQL(facets);
        Assert.assertTrue(offerings != null & offerings.size() != 0);
        for (String offer : offerings) {
            System.out.println("Offer:  " + offer);
        }
    }

    private List<String> facetedSearchSPARQL(List<Facet> facets) throws InvocationException {
        // Algorithm based on querying and matching PaaS Instances using the SPARQL endpoint
        // Create SPARQL query from facets
        // Send query and collect results
        // Create matching PaaS offerings from received PaaS offerings URIs
        if (facets.isEmpty()) {
            return new ArrayList<String>();
        }

        String query = createQuery(facets);
        List<Map<String, String>> queryResults = selectQuery(query);
        return readPaaSOfferingURIs(queryResults);
    }


    private String createQuery(List<Facet> facets) {
        StringBuffer query = new StringBuffer("SELECT DISTINCT ?po where {\n");
        query.append("?po " + type.toSPARQL() + " " + PaaSOffering.toSPARQL() + " .\n");
        int i = 0; //Variable index
        for (Facet facet : facets) {
            switch (facet.getQueryType()) {
                case TITLE:
                    addFacetTitleQuery(query, facet, i);
                    break;
                case TYPE:
                    addFacetTypeQuery(query, facet, i);
                    break;
            }
            i++;
        }
        query.append("\n}");
        return query.toString();
    }

    private void addFacetTitleQuery(StringBuffer query, Facet facet, int index) {
        query.append("?po <" + facet.getType() + "> ?p" + index + " .\n");
        query.append("?p" + index + " " + title.toSPARQL() + " ?ti .\n");
        query.append("FILTER (");
        int numFacetValues = facet.getValues().size();
        String lastFacetValue = facet.getValues().get(numFacetValues - 1);
        for (String facetValue : facet.getValues()) {
            query.append("REGEX (?ti, '" + facetValue + "', 'i')");
            if (numFacetValues > 1 && !facetValue.equals(lastFacetValue)) {
                query.append(" || ");
            }
        }
        query.append(").\n");
    }

    private void addFacetTypeQuery(StringBuffer query, Facet facet, int index) {
        query.append("?po <" + facet.getType() + "> ?p" + index + " .\n");
        int numFacetValues = facet.getValues().size();
        String lastFacetValue = facet.getValues().get(numFacetValues - 1);
        for (String facetValue : facet.getValues()) {
            query.append("{?p" + index + " " + type.toSPARQL() + " <" + facetValue + ">");
            query.append("}\n");
            if (numFacetValues > 1 && !facetValue.equals(lastFacetValue)) {
                query.append("\nUNION\n");
            }
        }
    }

    private List<String> readPaaSOfferingURIs(
            List<Map<String, String>> queryResults) {
        List<String> uris = new ArrayList<String>();
        for (Map<String, String> row : queryResults) {
            uris.add(row.get("po"));
        }

        return uris;
    }

    //TODO Move Facet to an external public class
    //TODO Insert QueryType as part of Facet
    enum QueryType {
        TITLE, TYPE
    }

    ;

    class Facet implements IsSerializable {

        private String type;
        private QueryType queryType;

        List<String> values = new ArrayList<String>();

        public Facet() {
        }

        public Facet(String type, QueryType queryType, List<String> values) {
            this.type = type;
            this.queryType = queryType;
            this.values = values;
        }

        public String getType() {
            return type;
        }

        public List<String> getValues() {
            return values;
        }

        public String getDisplayableType() {
            return type.substring(type.indexOf("#") + 1);
        }

        public QueryType getQueryType() {
            return queryType;
        }
    }
}
