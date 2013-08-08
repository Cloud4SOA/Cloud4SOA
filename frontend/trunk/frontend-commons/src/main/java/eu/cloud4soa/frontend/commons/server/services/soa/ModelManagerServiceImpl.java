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

package eu.cloud4soa.frontend.commons.server.services.soa;

import com.extjs.gxt.ui.client.data.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.ss.client.exceptions.GwtSecurityException;
import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareCategoryType;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.StatusType;
import eu.cloud4soa.api.datamodel.repository.FiveStarsRate;
import eu.cloud4soa.api.datamodel.semantic.inf.*;
import eu.cloud4soa.api.soa.ApplicationDeployment;
import eu.cloud4soa.api.soa.ModelManager;
import eu.cloud4soa.api.soa.PaaSOfferingRecommendation;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.server.semanticdao.*;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.ApplicationMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.HardwareComponentMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SoftwareComponentMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@SuppressWarnings({"GwtServiceNotRegistered"})
@Secured("IS_AUTHENTICATED_FULLY")
public class ModelManagerServiceImpl extends RemoteServiceServlet implements ModelManagerService {
    final Logger logger = LoggerFactory.getLogger(ModelManagerServiceImpl.class);
    @Qualifier("modelManager")
    @Autowired
    private ModelManager modelManagerSoaService;
    @Autowired
    private C4sSubject c4sSubject;
    @Autowired
    private DynamicEntityManager dynamicEntityManager;
    @Qualifier("applicationDeployment")
    @Autowired
    private ApplicationDeployment applicationDeploymentSoaService;
    @Autowired
    private PaaSOfferingDao paaSOfferingRepository;
    @Autowired
    private DeveloperUserDao developerUserRepository;
    @Autowired
    private ProviderUserDao providerUserRepository;
    @Autowired
    private ApplicationDao applicationRepository;
    @Autowired
    private SqlDbDao sqlDbRepository;
    @Autowired
    private NoSqlDbDao noSqlDbRepository;
    @Autowired
    private DbDao dbRepository;
    @Autowired
    private SoftwareCategoryDao softwareCategoryRepository;
    @Autowired
    private StorageCategoryDao storageCategoryRepository;
    @Autowired
    private ComputationalCategoryDao computationalCategoryRepository;
    @Autowired
    private CommunicationalCategoryDao communicationalCategoryRepository;
    @Autowired
    private HardwareCategoryDao hardwareCategoryRepository;
    @Autowired
    private ProgrammingLanguageDao programmingLanguageRepository;


    @Qualifier("paaSOfferingRecommendation")
    @Autowired
    private PaaSOfferingRecommendation offeringRecommendationSoaService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public String storeApplicationProfile(ApplicationModel applicationModel) throws GwtSecurityException {

        String userInstanceUriId = c4sSubject.getCurrentUserUriId();

        logger.debug("Invoking storeApplicationProfile in SOA ModelManager with "
                + " coreApplicationInstance: " + applicationModel.getDisplayName()
                + " userInstanceUriId: " + userInstanceUriId
        );

        try {
            return modelManagerSoaService.storeApplicationProfile(new ApplicationMapper()
                    .from(new ApplicationInstance())
                    .overWriteWith(applicationModel), userInstanceUriId);
        } catch (SOAException e) {
            String msg = "An error occurred while storing the application profile.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void updateApplicationProfile(ApplicationModel applicationModel) throws GwtSecurityException {

        String userInstanceUriId = c4sSubject.getCurrentUserUriId();

        logger.debug("Invoking updateApplicationProfile in SOA ModelManager with uriId {}.", applicationModel.getKey());

        try {
            modelManagerSoaService.updateApplicationProfile(
                    new ApplicationMapper()
                            .from(modelManagerSoaService.retrieveApplicationProfile(applicationModel.getKey(), userInstanceUriId))
                            .overWriteWith(applicationModel)
            );
        } catch (SOAException e) {
            String msg = "Error updating Application Profile: " + applicationModel.getTitle();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public void removeApplicationProfile(String applicationInstanceUriId) throws GwtSecurityException {

        logger.debug("Invoking removeApplicationProfile in SOA ModelManager with user {}. ", applicationInstanceUriId);

        try {
            modelManagerSoaService.removeApplicationProfile(applicationInstanceUriId);
        } catch (SOAException e) {
            String msg = "An error occurred while removing an application profile.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    @Override
    public PagingLoadResult<ApplicationModel> retrieveCurrentUserApplicationProfiles(PagingLoadConfig config) throws GwtSecurityException {

        return cutPageAndMap(retrieveAllApplicationInstances(), config, new ApplicationMapper());
    }

    private List<ApplicationInstance> retrieveAllApplicationInstances() throws GwtSecurityException {

        try {
            List<ApplicationInstance> applicationInstances = modelManagerSoaService.retrieveAllApplicationProfile(c4sSubject.getCurrentUserUriId());

            Collections.sort(applicationInstances, new Comparator<ApplicationInstance>() {
                @Override
                public int compare(ApplicationInstance o1, ApplicationInstance o2) {
                    return Strings.defaultString(o1.getTitle(), o1.getUriId()).toLowerCase()
                            .compareTo(Strings.defaultString(o2.getTitle(), o2.getUriId()).toLowerCase()
                            );
                }
            });

            return applicationInstances;

        } catch (SOAException e) {
            String msg = "An error occurred while retrieving current user application profiles.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    /**
     * Retrieve current user's application having selected status.
     *
     * @param config Paging configuration
     * @return Applications
     */
    @Override
    public PagingLoadResult<ApplicationModel> retrieveCurrentUserApplications(PagingLoadConfig config) throws GwtSecurityException {

        List<ApplicationInstance> applicationInstances = retrieveAllApplicationInstances();

        List<ApplicationInstance> filtered = new ArrayList<ApplicationInstance>();

        // unfair use of the sortField property. No other way around for passing a parameter in the list store.
        String status = config.getSortField();

        for (ApplicationInstance applicationInstance : applicationInstances)
            if ("all".equals(status)
                    || status == null && applicationInstance.getStatus() == null
                    || "stopped".equals(status) && applicationInstance.getStatus() == StatusType.Stopped
                    || "running".equals(status) && applicationInstance.getStatus() == StatusType.Running
                    || "undeployed".equals(status) && applicationInstance.getStatus() == StatusType.Undeployed
                    || "unreachable".equals(status) && applicationInstance.getStatus() == StatusType.Unreachable
                    || "dbmigrated".equals(status) && applicationInstance.getStatus() == StatusType.DBMigrated
                    || "dbmigrating".equals(status) && applicationInstance.getStatus() == StatusType.DBMigrating
                    || "deployed".equals(status) && applicationInstance.getStatus() == StatusType.Deployed
                    || "undeployed".equals(status) && applicationInstance.getStatus() == StatusType.Undeployed
                    || "error".equals(status) && applicationInstance.getStatus() == StatusType.Error
                    || "migrationg".equals(status) && applicationInstance.getStatus() == StatusType.Migrating)
                filtered.add(applicationInstance);


        return cutPageAndMap(filtered, config, new ApplicationMapper());
    }

    /**
     * Extract a page of instances from the list according to the paging load config and map the results using the
     * provided mapper.
     *
     * @param rdfInstances     List of all instances
     * @param pagingLoadConfig Page loading configuration
     * @param mapper           Mapper for the instance
     * @param <M>              Type of model
     * @param <O>              Type of instance
     * @return The resulting page of models.
     */
    private <M extends DisplayableKeyValueModelData, O> PagingLoadResult<M> cutPageAndMap(List<O> rdfInstances, PagingLoadConfig pagingLoadConfig, AbstractMapper<O, M> mapper) {

        List<O> page = new ArrayList<O>(rdfInstances.subList(Math.min(pagingLoadConfig.getOffset(), rdfInstances.size()),
                Math.min(pagingLoadConfig.getOffset() + pagingLoadConfig.getLimit(), rdfInstances.size())));


        List<M> models = map(page, mapper);


        PagingLoadResult<M> pagingLoadResult = new BasePagingLoadResult<M>(models);

        pagingLoadResult.setOffset(pagingLoadConfig.getOffset());
        pagingLoadResult.setTotalLength(rdfInstances.size());

        return pagingLoadResult;

    }

    private <M extends DisplayableKeyValueModelData, O> List<M> map(List<O> rdfInstances, AbstractMapper<O, M> mapper) {

        List<M> models = new ArrayList<M>(rdfInstances.size());

        for (O rdfInstance : rdfInstances)
            models.add(mapper
                    .from(rdfInstance)
                    .toModel());

        return models;

    }

    @Override
    public ListLoadResult<ApplicationModel> retrieveAllDeployedApplicationProfiles(ListLoadConfig config) throws GwtSecurityException {

        List<ApplicationInstance> applications;
        List<ApplicationModel> lam;

        try {
            applications = applicationDeploymentSoaService.retrieveAllDeployedApplicationProfiles(c4sSubject.getCurrentUserUriId());

            lam = map(applications, new ApplicationMapper());
            //Obtaining ratings
            for (ApplicationModel am : lam) {
                int rating = 0;
                FiveStarsRate fsr = offeringRecommendationSoaService.getUserExperienceRate(am.getKey());
                if (fsr != null)
                    rating = fsr.getRate();
                am.<Integer>set(ApplicationModel.RATING, rating);
            }
        } catch (SOAException e) {
            String msg = "An error occurred while retrieving the list of deployed applications.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        return new BaseListLoadResult<ApplicationModel>(lam);
    }

    @Override
    public ListLoadResult<ProgrammingLanguageModel> retrieveProgrammingLanguages() throws GwtSecurityException {
        return new BaseListLoadResult<ProgrammingLanguageModel>(programmingLanguageRepository.list());
    }

    @Override
    public ListLoadResult<HardwareCategoryModel> retrieveHardwareCategories() throws GwtSecurityException {
        return new BaseListLoadResult<HardwareCategoryModel>(hardwareCategoryRepository.list());
    }

    @Override
    public ListLoadResult<HardwareCategoryModel> retrieveCommunicationCategories() throws GwtSecurityException {
        return new BaseListLoadResult<HardwareCategoryModel>(communicationalCategoryRepository.list());
    }

    @Override
    public ListLoadResult<HardwareCategoryModel> retrieveComputationCategories() throws GwtSecurityException {
        return new BaseListLoadResult<HardwareCategoryModel>(computationalCategoryRepository.list());
    }

    @Override
    public ListLoadResult<HardwareCategoryModel> retrieveStorageCategories() throws GwtSecurityException {
        return new BaseListLoadResult<HardwareCategoryModel>(storageCategoryRepository.list());
    }

    @Override
    public ListLoadResult<SoftwareCategoryModel> retrieveSoftwareCategories() throws GwtSecurityException {
        return new BaseListLoadResult<SoftwareCategoryModel>(softwareCategoryRepository.list());
    }

    @Override
    public ListLoadResult<SoftwareCategoryModel> retrieveDatabaseCategories() throws GwtSecurityException {
        return new BaseListLoadResult<SoftwareCategoryModel>(dbRepository.list());
    }

    @Override
    public ListLoadResult<SoftwareCategoryModel> retrieveSqlDatabaseCategories() throws GwtSecurityException {
        return new BaseListLoadResult<SoftwareCategoryModel>(sqlDbRepository.list());
    }

    @Override
    public ListLoadResult<SoftwareCategoryModel> retrieveNoSqlDatabaseCategories() throws GwtSecurityException {
        return new BaseListLoadResult<SoftwareCategoryModel>(noSqlDbRepository.list());
    }

    @Override
    public ListLoadResult<DisplayableKeyValueModelData> retrieveDynamicEntityList(String type) throws GwtSecurityException {
        List<DisplayableKeyValue> results = dynamicEntityManager.retrieveAllEntities(type);

        List<DisplayableKeyValueModelData> resultsModelData = new ArrayList<DisplayableKeyValueModelData>(results.size());

        for (DisplayableKeyValue result : results)
            resultsModelData.add(new DisplayableKeyValueModelData(result));

        return new BaseListLoadResult<DisplayableKeyValueModelData>(resultsModelData);


    }

    @Override
    public DisplayableKeyValueModelData retrieveOneDynamicEntity(String type, String key) throws GwtSecurityException {
        return new DisplayableKeyValueModelData(dynamicEntityManager.retrieveOneEntity(type, key));
    }

    @Override
    public ApplicationModel retrieveOneApplicationInstance(String uriId) throws GwtSecurityException {

        if (Strings.isEmpty(uriId) || Strings.NEW_INSTANCE.equals(uriId)) {
            // return the model for a new application
            // let the ApplicationInstance and the ApplicationMapper perform all the initializations
            return new ApplicationMapper()
                    .from(new ApplicationInstance())
                    .toModel();

        } else {

            try {
                return new ApplicationMapper()
                        .from(modelManagerSoaService.retrieveApplicationProfile(uriId, c4sSubject.getCurrentUserUriId()))
                        .toModel();
            } catch (Exception e) {
                String msg = "Error in retrieveOneApplicationInstance with uriId " + uriId;
                logger.error(msg, e);
                throw new RuntimeException(msg, e);
            }
        }
    }

    @Override
    public ApplicationModel createApplicationFromTemplate(String template) throws GwtSecurityException {
        return applicationRepository.createApplicationFromTemplate(template);
    }

    @Override
    public void updateApplicationInstance(ApplicationModel applicationModel) throws GwtSecurityException {

        try {
            ApplicationInstance applicationInstance = new ApplicationMapper()
                    .from(modelManagerSoaService.retrieveApplicationProfile(applicationModel.getKey(), c4sSubject.getCurrentUserUriId()))
                    .overWriteWith(applicationModel);
            modelManagerSoaService.updateApplicationProfile(applicationInstance);
        } catch (SOAException e) {
            String msg = "Error in updateApplicationInstance for application " + applicationModel.getTitle();
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

    }

    @Override
    public void addApplicationHardwareComponent(String applicationUriId, String componentType) throws GwtSecurityException {

        ApplicationInstance applicationInstance;
        try {
            applicationInstance = modelManagerSoaService.retrieveApplicationProfile(applicationUriId, c4sSubject.getCurrentUserUriId());
        } catch (SOAException e) {
            String msg = "Error in addApplicationHardwareComponent for applicationUriId " + applicationUriId;
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        HardwareComponentInstance hardwareComponentInstance = null;

        if (HardwareComponentModel.TYPE_NETWORK.equals(componentType))
            hardwareComponentInstance = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkCategory);
        else if (HardwareComponentModel.TYPE_COMPUTATION.equals(componentType))
            hardwareComponentInstance = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.ComputationalCategory);
        else if (HardwareComponentModel.TYPE_STORAGE.equals(componentType))
            hardwareComponentInstance = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageCategory);
        else if (HardwareComponentModel.TYPE_HTTP_REQUEST_HANDLER.equals(componentType))
            hardwareComponentInstance = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.HttpRequestHandlerCategory);

        if (hardwareComponentInstance != null) {
            try {
                modelManagerSoaService.updateApplicationProfile(applicationInstance);
            } catch (SOAException e) {
                String msg = "An error occurred in addApplicationHardwareComponent";
                logger.error(msg, e);
                throw new RuntimeException(msg, e);
            }

        } else {
            logger.error("unhandled hardware category type");
        }
    }

    @Override
    public void addApplicationSoftwareComponent(String applicationUriId, String componentType) throws GwtSecurityException {
        ApplicationInstance applicationInstance;

        try {
            applicationInstance = modelManagerSoaService.retrieveApplicationProfile(applicationUriId, c4sSubject.getCurrentUserUriId());
        } catch (SOAException e) {
            String msg = "An error occurred in addApplicationSoftwareComponent";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        if (SoftwareComponentModel.TYPE_GENERIC.equals(componentType))
            applicationInstance.getApplication().getRequiresSoftwareComponent().add(new SoftwareComponent());
        else
            applicationInstance.getApplication().getRequiresSoftwareComponent().add(new DBStorageComponent());

        try {
            modelManagerSoaService.updateApplicationProfile(applicationInstance);
        } catch (SOAException e) {
            String msg = "An error occurred while updating the application profile.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

    }

    @Override
    public void removeApplicationHardwareComponent(String applicationUriId, HardwareComponentModel hardwareComponentModel) throws GwtSecurityException {
        ApplicationInstance applicationInstance;
        try {
            applicationInstance = modelManagerSoaService.retrieveApplicationProfile(applicationUriId, c4sSubject.getCurrentUserUriId());
        } catch (SOAException e) {
            String msg = "Error in removeApplicationHardwareComponent for applicationUriId " + applicationUriId;
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        HardwareComponent componentToRemove = null;
        String componentToRemoveUriId = Strings.defaultString(hardwareComponentModel.getKey());

        for (HardwareComponent hardwareComponent : applicationInstance.getApplication().getRequiresResource())
            if (componentToRemoveUriId.equals(hardwareComponent.getUriId()))
                componentToRemove = hardwareComponent;

        if (componentToRemove != null) {
            applicationInstance.getApplication().getRequiresResource().remove(componentToRemove);

            try {
                modelManagerSoaService.updateApplicationProfile(applicationInstance);
            } catch (SOAException e) {
                String msg = "An error occurred while updating the application profile. ";
                logger.error(msg, e);
                throw new RuntimeException(msg, e);
            }

        }
    }

    @Override
    public void removeApplicationSoftwareComponent(String applicationUriId, SoftwareComponentModel softwareComponentModel) throws GwtSecurityException {
        ApplicationInstance applicationInstance;
        try {
            applicationInstance = modelManagerSoaService.retrieveApplicationProfile(applicationUriId, c4sSubject.getCurrentUserUriId());
        } catch (SOAException e) {
            String msg = "Error in removeApplicationSoftwareComponent for applicationUriId " + applicationUriId;
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        SoftwareComponent componentToRemove = null;
        String componentToRemoveUriId = Strings.defaultString(softwareComponentModel.getKey());

        for (SoftwareComponent softwareComponent : applicationInstance.getApplication().getRequiresSoftwareComponent())
            if (componentToRemoveUriId.equals(softwareComponent.getUriId()))
                componentToRemove = softwareComponent;

        if (componentToRemove != null) {
            applicationInstance.getApplication().getRequiresSoftwareComponent().remove(componentToRemove);

            try {
                modelManagerSoaService.updateApplicationProfile(applicationInstance);
            } catch (SOAException e) {
                String msg = "An error occurred while updating an application profile.";
                logger.error(msg, e);
                throw new RuntimeException(msg, e);
            }

        }
    }

    @Override
    public PagingLoadResult<PaaSOfferingModel> retrieveCurrentUserPaaSOfferings(PagingLoadConfig config) throws GwtSecurityException {

        List<PaaSOfferingModel> all = paaSOfferingRepository.retrieveCurrentUserPaaSOfferings();

        PagingLoadResult<PaaSOfferingModel> pagingLoadResult = new BasePagingLoadResult<PaaSOfferingModel>(
                new ArrayList<PaaSOfferingModel>(all.subList(Math.min(config.getOffset(), all.size()),
                        Math.min(config.getOffset() + config.getLimit(), all.size()))));

        pagingLoadResult.setOffset(config.getOffset());
        pagingLoadResult.setTotalLength(all.size());

        return pagingLoadResult;

    }

    @Override
    public PaaSOfferingModel retrieveOnePaaSOffering(String uriId) throws GwtSecurityException {
        return paaSOfferingRepository.findByUriId(uriId);
    }

    @Override
    public void updatePaaSOffering(PaaSOfferingModel paaSOfferingModel) throws GwtSecurityException {
        paaSOfferingRepository.update(paaSOfferingModel);
    }

    @Override
    public String storePaaSOffering(PaaSOfferingModel paaSOfferingModel) throws GwtSecurityException {
        return paaSOfferingRepository.create(paaSOfferingModel);
    }

    @Override
    public HardwareComponentModel createHardwareComponent(String hardwareComponentType) throws GwtSecurityException {
        logger.debug("createHardwareComponent()");


        HardwareComponentModel hardwareComponentModel = new HardwareComponentModel();
        hardwareComponentModel.setType(hardwareComponentType);

        HardwareComponent emptySoaInstance;

        if (HardwareComponentModel.TYPE_STORAGE.equals(hardwareComponentType)) {
            emptySoaInstance = new StorageResource();
        } else if (HardwareComponentModel.TYPE_NETWORK.equals(hardwareComponentType)) {
            emptySoaInstance = new NetworkResource();
        } else if (HardwareComponentModel.TYPE_HTTP_REQUEST_HANDLER.equals(hardwareComponentType)) {
            emptySoaInstance = new HttpRequestsHandler();
        } else if (HardwareComponentModel.TYPE_COMPUTATION.equals(hardwareComponentType)) {
            emptySoaInstance = new Compute();
        } else {
            emptySoaInstance = new HardwareComponent();
        }

        return new HardwareComponentMapper()
                .from(emptySoaInstance)
                .toModel();

    }

    @Override
    public SoftwareComponentModel createSoftwareComponent(String softwareComponentType) throws GwtSecurityException {
        logger.debug("createSoftwareComponent()");

        SoftwareComponentModel softwareComponentModel = new SoftwareComponentModel();
        softwareComponentModel.setType(softwareComponentType);

        // create a fake soa instance with the right types and let the mapper
        // build the new empty software component model
        SoftwareComponent emptySoaInstance;

        if (SoftwareComponentModel.TYPE_GENERIC.equals(softwareComponentType)) {
            emptySoaInstance = new SoftwareComponent();
            emptySoaInstance.setRelatedswcategory(new SoftwareCategory());
        } else if (SoftwareComponentModel.TYPE_DATABASE.equals(softwareComponentType)) {
            emptySoaInstance = new DBStorageComponent();
            emptySoaInstance.setRelatedswcategory(new DB());
        } else if (SoftwareComponentModel.TYPE_SQL_DATABASE.equals(softwareComponentType)) {
            emptySoaInstance = new DBStorageComponent();
            emptySoaInstance.setRelatedswcategory(new SQLDB());
        } else if (SoftwareComponentModel.TYPE_NO_SQL_DATABASE.equals(softwareComponentType)) {
            emptySoaInstance = new DBStorageComponent();
            emptySoaInstance.setRelatedswcategory(new NoSQLDB());
        } else {
            emptySoaInstance = new SoftwareComponent();
            emptySoaInstance.setRelatedswcategory(new SoftwareCategory());
        }

        return new SoftwareComponentMapper()
                .from(emptySoaInstance)
                .toModel();

    }

    @Override
    public void removeOfferHardwareComponent(String offerUriId, HardwareComponentModel hardwareComponentModel) throws GwtSecurityException {
        logger.error("removeOfferHardwareComponent() not implemented yet");
    }

    @Override
    public void removeOfferSoftwareComponent(String offerUriId, SoftwareComponentModel softwareComponentModel) throws GwtSecurityException {
        logger.error("removeOfferSoftwareComponent() not implemented yet");
    }

    @Override
    public EntityMetadata retrieveEntityMetadata(String context, String entity) throws GwtSecurityException {
        return MetadataMapper.resolve(Strings.join(context, entity));
    }

    @Override
    public PagingLoadResult<UserModel> retrieveAllUsers(PagingLoadConfig config) {

        return new BasePagingLoadResult<UserModel>(
                developerUserRepository.pagedList(config.getOffset(), config.getLimit()),
                config.getOffset(),
                developerUserRepository.count()
        );

    }

    @Override
    public UserModel retrieveOneUser(String uriId) {
        UserModel user = developerUserRepository.findByUriId(uriId);
        if (user == null)
            user = providerUserRepository.findByUriId(uriId);

        return user;
    }

    @Override
    public void removeUser(String uriId) {
        UserModel user = retrieveOneUser(uriId);
        if (user.isDeveloper())
            developerUserRepository.delete(user);
        else
            providerUserRepository.delete(user);
    }

    @Override
    public FieldMetadata whiteList2() {
        return null;
    }

    @Override
    public EditType whiteList3() {
        return null;
    }

    @Override
    public MeasurementModel whiteList4() {
        return null;
    }


}
