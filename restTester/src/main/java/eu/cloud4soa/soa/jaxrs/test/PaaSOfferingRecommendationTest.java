/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.soa.jaxrs.test;

import eu.cloud4soa.api.datamodel.repository.FiveStarsRate;
import eu.cloud4soa.api.soa.PaaSOfferingRecommendation;
import eu.cloud4soa.api.util.exception.repository.RepositoryException;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author user
 */
public class PaaSOfferingRecommendationTest {

    final String BASE_URI = "http://localhost:8080/services/REST/PaaSOfferingRecommendationRS";
    private static final Logger logger = LoggerFactory.getLogger(PaaSOfferingRecommendationTest.class);

    public static void main(String[] args) {
        PaaSOfferingRecommendationTest recTest = new PaaSOfferingRecommendationTest();
        //   try {
        //       pdt.getAllAvailablePaaSInstances();
        //   } catch (SOAException ex) {
        //       logger.error(ex.getMessage());
        //   }
        try {
            //recTest.addUserExperienceRate();
            recTest.getSystemRating();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void addUserExperienceRate() throws SOAException {
        logger.info("******SearchForMatchingPlatform******");
        PaaSOfferingRecommendation paaSOfferingRecomendation = JAXRSClientFactory.create(BASE_URI, PaaSOfferingRecommendation.class);

        logger.info("Add new user experience rating");
        FiveStarsRate fsr = new FiveStarsRate(3);
        paaSOfferingRecomendation.deleteUserExperienceRate("testaki");
        FiveStarsRate f = paaSOfferingRecomendation.getUserExperienceRate("testaki");
        paaSOfferingRecomendation.storeUserExperienceRate("testaki", fsr);
        paaSOfferingRecomendation.updateUserExperienceRate("teskaki", "3");
        float average = paaSOfferingRecomendation.getAveragePaaSUserExperienceRate("teskaki");

    }
    
       public void getSystemRating() throws SOAException, RepositoryException {
        logger.info("******GetSystemRating******");
        PaaSOfferingRecommendation paaSOfferingRecomendation = JAXRSClientFactory.create(BASE_URI, PaaSOfferingRecommendation.class);

       
        System.out.println("Breaches/Day: "+paaSOfferingRecomendation.getPaaSBreachesPerDay("cloudBees_runAtCloud"));
      //  System.out.println("Breaches/Month: "+paaSOfferingRecomendation.getPaaSBreachesPerMonth("CloudControl"));
     //   System.out.println("Breaches/Week: "+paaSOfferingRecomendation.getPaaSBreachesPerWeek("CloudControl"));
        
        

    }
    
    
}
