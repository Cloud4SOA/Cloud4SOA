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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.cloud4soa.frontend.commons.server.services.soa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.ss.client.exceptions.GwtSecurityException;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.governance.SlaPolicy;
import eu.cloud4soa.api.datamodel.repository.FiveStarsRate;
import eu.cloud4soa.api.datamodel.soa.ApplicationDeploymentParameters;
import eu.cloud4soa.api.soa.ApplicationDeployment;
import eu.cloud4soa.api.soa.ApplicationMigration;
import eu.cloud4soa.api.soa.ModelManager;
import eu.cloud4soa.api.soa.PaaSOfferingRecommendation;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentService;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.ApplicationMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SLAPolicyMapper;
import eu.cloud4soa.frontend.upload.ArtifactsHolder;
import eu.cloud4soa.frontend.upload.FileItem;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@SuppressWarnings({"GwtServiceNotRegistered"})
@Secured("IS_AUTHENTICATED_FULLY")
public class ApplicationDeploymentServiceImpl extends RemoteServiceServlet
        implements ApplicationDeploymentService {
    final Logger logger = LoggerFactory
            .getLogger(ApplicationDeploymentServiceImpl.class);
    @Autowired
    ArtifactsHolder artifactsHolder;
    @Autowired
    C4sSubject c4sSubject;
    @Autowired
    @Qualifier("applicationDeployment")
    private ApplicationDeployment applicationDeploymentSoaService;
    @Qualifier("applicationMigration")
    @Autowired
    private ApplicationMigration applicationMigration;
    @Autowired
    @Qualifier("modelManager")
    private ModelManager modelManagerSoaService;
    @Qualifier("paaSOfferingRecommendation")
    @Autowired
    private PaaSOfferingRecommendation offeringRecommendationSoaService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    public String deployApplication(String applicationUriId, String paaSInstanceUriId, 
        String archiveName, String slaTemplateId, List<SLAPolicyModel> slaPolicies) throws GwtSecurityException {
        try {
            FileItem fileItem = getFileByName(
                    artifactsHolder.getUploadedFiles(), "app-binary");

            ApplicationInstance applicationInstance = modelManagerSoaService
                    .retrieveApplicationProfile(applicationUriId,
                            c4sSubject.getCurrentUserUriId());

            String archiveFileName = archiveName.lastIndexOf(".") != -1 ? archiveName
                    .substring(0, archiveName.lastIndexOf(".")) : archiveName;
            String archiveExtensionName = archiveName.lastIndexOf(".") != -1 ? archiveName
                    .substring(archiveName.lastIndexOf(".") + 1,
                            archiveName.length()) : "";
            applicationInstance.setArchiveFileName(archiveFileName);
            applicationInstance.setArchiveExtensionName(archiveExtensionName);

            modelManagerSoaService
                    .updateApplicationProfile(applicationInstance);

            // pass just the paaSInstance UriId
            InputStream archiveFileStream = new FileInputStream(fileItem.getFile());

            logger.debug("Invoking deployApplication in SOA ApplicationDeployment with "
                    + " applicationInstanceUriId: " + applicationUriId
                    + " paaSInstanceUriId: " + paaSInstanceUriId);
            
            //Preparing SLA policies
            List<SlaPolicy> penalties = new ArrayList<SlaPolicy> (slaPolicies.size());
            for (SLAPolicyModel policy: slaPolicies){
            	SlaPolicy penalty = new SlaPolicy();
            	penalties.add(new SLAPolicyMapper().writeTo (penalty, policy));
            }
            
            ApplicationDeploymentParameters parameters = new ApplicationDeploymentParameters();
            parameters.setApplicationInstanceUriId(applicationUriId);
            parameters.setPaaSInstanceUriId(paaSInstanceUriId);
            parameters.setArchiveFileStream(archiveFileStream);
            parameters.setSlaTemplateId(slaTemplateId);
            parameters.setPenalties(penalties);
            
            Response response = applicationDeploymentSoaService.deployApplication(parameters);
            
//            Response response = applicationDeploymentSoaService
//                    .deployApplication(applicationUriId, paaSInstanceUriId, archiveFileStream, slaTemplateId);

            return response.getEntity().toString();
        } catch (Exception e) {
            String msg = "An error occurred while deploying the application: "
                    + e.toString();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    /**
     * @param uploadedFiles
     * @return
     */
    private FileItem getFileByName(List<FileItem> uploadedFiles, String name)
            throws FileNotFoundException {
        FileItem file = null;
        for (FileItem item : uploadedFiles) {
            if (item.getName().equals(name)) {
                file = item;
                break;
            }
        }
        if (file == null)
            throw new FileNotFoundException(
                    "Uploaded file corresponding to name " + name
                            + " not found");

        return file;
    }

    @Override
    public void startApplication(String applicationInstanceUriId,
                                 String publicKey, String secretKey) throws GwtSecurityException {
        logger.debug("Invoking startStopApplication (start) in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: "
                + applicationInstanceUriId
                + " publicKey: " + publicKey + " secretKey: " + secretKey);

        try {
            applicationDeploymentSoaService.startStopApplication(
                    applicationInstanceUriId, "start", publicKey, secretKey);
        } catch (SOAException e) {
            String msg = "An error occurred while starting the application: "
                    + e.toString() + ". Status: " + e.getResponseStatus();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void stopApplication(String applicationInstanceUriId,
                                String publicKey, String secretKey) throws GwtSecurityException {
        logger.debug("Invoking startStopApplication (stop) in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: "
                + applicationInstanceUriId
                + " publicKey: " + publicKey + " secretKey: " + secretKey);
        try {
            applicationDeploymentSoaService.startStopApplication(
                    applicationInstanceUriId, "stop", publicKey, secretKey);
        } catch (SOAException e) {
            String msg = "An error occurred while stopping the application: "
                    + e.toString() + ". Status: " + e.getResponseStatus();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void removeApplication(String applicationInstanceUriId,
                                  String publicKey, String secretKey) throws GwtSecurityException {
        logger.debug("Invoking removeApplication in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: " + applicationInstanceUriId);
        try {
            applicationDeploymentSoaService.removeApplication(
                    applicationInstanceUriId, publicKey, secretKey);
        } catch (SOAException e) {
            String msg = "An error occurred while removing the application: "
                    + e.toString() + ". Status: " + e.getResponseStatus();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public ListLoadResult<ApplicationModel> retrieveAllDeployedApplicationProfiles(ListLoadConfig config) throws GwtSecurityException {

        List<ApplicationInstance> applications;
        List<ApplicationModel> pagedApplications = new ArrayList<ApplicationModel>();

        try {

            applications = modelManagerSoaService.retrieveAllApplicationProfile(c4sSubject.getCurrentUserUriId());


            for (ApplicationInstance application : applications) {
                ApplicationModel appModel = new ApplicationMapper().from(application)
                        .toModel();
                pagedApplications.add(appModel);

                // Rating
                int rating = 0;
                FiveStarsRate fsr = offeringRecommendationSoaService.getUserExperienceRate(application.getUriId());
                if (fsr != null)
                    rating = fsr.getRate();
                appModel.<Integer>set(ApplicationModel.RATING, rating);
            }
        } catch (SOAException e) {
            String msg = "An error occurred while retrieving the application profile list. ";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        return new BaseListLoadResult<ApplicationModel>(pagedApplications);
    }

    @Override
    public void clearFiles() throws GwtSecurityException {
        artifactsHolder.clear();
    }

    @Override
    public void undeployApplication(String applicationInstanceUriId,
                                    String publicKey, String secretKey) {
        logger.debug("Invoking undeployApplication in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: "
                + applicationInstanceUriId
                + " publicKey: " + publicKey + " secretKey: " + secretKey);
        try {
            applicationDeploymentSoaService.removeApplication(
                    applicationInstanceUriId, publicKey, secretKey);
        } catch (SOAException e) {
            String msg = "An error occurred while undeploying the application: "
                    + e.toString() + ". Status: " + e.getResponseStatus();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    // Database creation/initialization/dump methods

    @Override
    public void createDatabase(String applicationInstanceUriId,
                               String paaSInstanceUriId, String dbStorageComponentUriId) throws GwtSecurityException {
        logger.debug("Invoking createDatabase in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: "
                + applicationInstanceUriId
                + " paaSInstanceUriId: "
                + paaSInstanceUriId
                + " dbStorageComponentUriId: " + dbStorageComponentUriId);
        try {
            applicationDeploymentSoaService.createDatabase(
                    applicationInstanceUriId, paaSInstanceUriId,
                    dbStorageComponentUriId);
        } catch (SOAException e) {
            String msg = "An error occurred while creating the database: "
                    + e.toString() + ". Status: " + e.getResponseStatus();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void initializeDatabase(String applicationInstanceUriId,
                                   String paaSInstanceUriId, String dbStorageComponentUriId) throws GwtSecurityException {
        logger.debug("Invoking initializeDatabase in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: "
                + applicationInstanceUriId
                + " paaSInstanceUriId: "
                + paaSInstanceUriId
                + " dbStorageComponentUriId: " + dbStorageComponentUriId);
        try {
            FileItem fileItem = getFileByName(
                    artifactsHolder.getUploadedFiles(), "app-binary");

            // pass just the paaSInstance UriId
            InputStream is = new FileInputStream(fileItem.getFile());

            applicationDeploymentSoaService.initializeDatabase(
                    applicationInstanceUriId, paaSInstanceUriId,
                    dbStorageComponentUriId, is);
        } catch (Exception e) {
            String msg = "An error occurred while initialising the database: "
                    + e.getMessage();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void dumpDatabase(String applicationInstanceUriId,
                             String paaSInstanceUriId, String dbStorageComponentUriId) throws GwtSecurityException {
        logger.debug("Invoking dumpDatabase in SOA ApplicationDeployment with "
                + " applicationInstanceUriId: " + applicationInstanceUriId
                + " paaSInstanceUriId: " + paaSInstanceUriId
                + " dbStorageComponentUriId: " + dbStorageComponentUriId);
        try {
            InputStream is = applicationDeploymentSoaService.dumpDatabase(
                    applicationInstanceUriId, paaSInstanceUriId,
                    dbStorageComponentUriId);
            // TODO Save dump and expose it through C4S to be downloaded by
            // client
        } catch (SOAException e) {
            String msg = "An error occurred while dumping the database: "
                    + e.toString() + ". Status: " + e.getResponseStatus();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void migrateDatabase(String applicationUriId, String paaSOfferingUriId) throws GwtSecurityException {
        try {
            applicationMigration.migrateDatabases(applicationUriId, paaSOfferingUriId);
        } catch (SOAException e) {
            logger.error("Error migrating database.", e);
            throw new RuntimeException("Database migration failed: " + e.toString());
        }
    }

    @Override
    public void commitMigration(String applicationUriId) throws GwtSecurityException {
        try {
            applicationMigration.commitMigration(applicationUriId);
        } catch (SOAException e) {
            logger.error("Error committing migration.", e);
            throw new RuntimeException("Migration failed: " + e.toString());
        }
    }

    @Override
    public void migrateApplication(String applicationUriId, String paaSOfferingUriId) throws GwtSecurityException {
        try {
            FileItem fileItem = getFileByName(artifactsHolder.getUploadedFiles(), "app-binary");
            InputStream is = new FileInputStream(fileItem.getFile());
            applicationMigration.migrateApplication(applicationUriId, paaSOfferingUriId, is);
        } catch (FileNotFoundException e) {
            logger.error("Error reading artifact.", e);
            throw new RuntimeException("Application migration failed: " + e.toString());

        } catch (SOAException e) {
            logger.error("Error migrating the application.", e);
            throw new RuntimeException("Application migration failed: " + e.toString());
        }
    }

    @Override
    public void rollbackMigration(String applicationUriId) throws GwtSecurityException {
        try {
            applicationMigration.rollbackMigration(applicationUriId);
        } catch (SOAException e) {
            logger.error("Error rolling back migration.", e);
            throw new RuntimeException("Migration rollback failed: " + e.toString());
        }
    }

    @Override
    public void storeUserExperienceRate(String appURI, int rating) throws GwtSecurityException {
        try {
            //Checking whether to store or update existing rating
            FiveStarsRate fsr = offeringRecommendationSoaService.getUserExperienceRate(appURI);
            if (fsr != null)
                offeringRecommendationSoaService.updateUserExperienceRate(appURI, Integer.toString(rating));
            else {
                fsr = new FiveStarsRate(rating);
                offeringRecommendationSoaService.storeUserExperienceRate(appURI, fsr);
            }
        } catch (SOAException e) {
            logger.error("Error migrating the application.", e);
            throw new RuntimeException("Store user experience rate failed: " + e.toString());
        }
    }
}
