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

import static eu.cloud4soa.frontend.commons.client.Strings.join;

import java.util.HashMap;
import java.util.Map;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.metadata.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;

/**
 * Map the form code with the correspondent metadata instance.
 * 
 * @author Stefano Travelli (Cyntelix)
 * @author Yosu Gorroñogoitia (Atos)
 */
public class MetadataMapper {

	public static final String CONTEXT_APPLICATION_EDITOR = "application-editor";
	public static final String CONTEXT_APPLICATION_EDITOR_SLA = "application-editor-sla";
	public static final String CONTEXT_APPLICATION_SUMMARY = "application-summary";
	public static final String CONTEXT_OFFER_EDITOR = "offer-editor";
	public static final String CONTEXT_OFFER_EDITOR_SLA = "offer-editor-sla";
	public static final String CONTEXT_OFFER_VIEWER = "offer-viewer";
	public static final String CONTEXT_OFFER_VIEWER_SLA = "offer-viewer-sla";
	public static final String CONTEXT_SLA_TEMPLATE_EDITOR = "sla_template_editor";
	public static final String CONTEXT_SLA_CONTRACT_EDITOR = "sla_contract_editor";
	public static final String CONTEXT_DEPLOYMENT_FORM = "deployment_form";
	public static final String CONTEXT_DEPLOYMENT_REPORT = "deployment_report";
	public static final String CONTEXT_DBCREATION_FORM = "dbcreation_form";
	public static final String CONTEXT_DBCREATION_REPORT = "dbcreation_report";
	public static final String CONTEXT_SLA_POLICY_EDITOR = "sla-policy-editor";
    public static final String CONTEXT_USER_EDITOR = "user-editor";


	public static final String FORM_HARDWARE_GENERIC_COMPONENT = "hardware-component"; // not
																						// used
	public static final String FORM_HARDWARE_COMPUTE_COMPONENT = "hardware-compute-component";
	public static final String FORM_HARDWARE_HTTP_REQUEST_HANDLER_COMPONENT = "hardware-http-request-handler-component";
	public static final String FORM_HARDWARE_NETWORK_COMPONENT = "hardware-network-component";
	public static final String FORM_HARDWARE_STORAGE_COMPONENT = "hardware-storage-component";

	public static final String FORM_SOFTWARE_GENERIC_COMPONENT = "software-generic-component";
	public static final String FORM_SOFTWARE_DATABASE_COMPONENT = "software-db-storage-component"; // not
																									// used
	public static final String FORM_SOFTWARE_NO_SQL_DB_COMPONENT = "software-no-sql-db-component";
	public static final String FORM_SOFTWARE_SQL_DB_COMPONENT = "software-sql-db-storage-component";

	public static final String FORM_APPLICATION = "application";
	public static final String FORM_OFFER = "offer";
    public static final String FORM_USER = "user";

	// SLA Template (Yosu)
	public static final String FORM_SLA_TEMPLATE = "sla-template";
	public static final String FORM_SLA_TEMPLATE_CONTEXT = "sla-template-context";
	public static final String FORM_SLA_TEMPLATE_SERVICE = "sla-template-service";
	public static final String FORM_SLA_TEMPLATE_GT = "sla-template-gt";
	public static final String FORM_SLA_TEMPLATE_GT_SLO = "sla-template-gt-slo";
	public static final String FORM_SLA_TEMPLATE_GT_BLO = "sla-template-gt-blo";

	// SLA Contract (Yosu)
	public static final String FORM_SLA_CONTRACT = "sla-contract";
	public static final String FORM_SLA_CONTRACT_CONTEXT = "sla-contract-context";
	public static final String FORM_SLA_CONTRACT_SERVICE = "sla-contract-service";
	public static final String FORM_SLA_CONTRACT_GT = "sla-contract-gt";
	public static final String FORM_SLA_CONTRACT_GT_SLO = "sla-contract-gt-slo";
	public static final String FORM_SLA_CONTRACT_GT_BLO = "sla-contract-gt-blo";
	
	// SLA Policy (Yosu)
	public static final String FORM_SLA_POLICY = "sla-policy";

	// Deployment form (Yosu)
	public static final String USER_PAAS_GENERIC_CREDENTIALS = "user-paas-generic-credentials";
    public static final String USER_PAAS_CLOUDBEES_CREDENTIALS = "user-paas-cloudbees-credentials";
    public static final String USER_PAAS_BEANSTALK_CREDENTIALS = "user-paas-beanstalk-credentials";
    public static final String USER_PAAS_OPENSHIFT_CREDENTIALS = "user-paas-openshift-credentials";
    public static final String USER_PAAS_HEROKU_CREDENTIALS = "user-paas-heroku-credentials";
    public static final String USER_PAAS_CLOUDCONTROL_CREDENTIALS = "user-paas-cloudcontrol-credentials";


    private static Logger log = LoggerFactory.getLogger(MetadataMapper.class);

	private static final Map<String, Class<? extends EntityMetadata>> metadataMap = new HashMap<String, Class<? extends EntityMetadata>>();

	static {
		// application editor hardware components
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_HARDWARE_GENERIC_COMPONENT), ApplicationEditorHardwareGenericMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_HARDWARE_COMPUTE_COMPONENT), ApplicationEditorHardwareComputeMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_HARDWARE_HTTP_REQUEST_HANDLER_COMPONENT), ApplicationEditorHardwareHttpRequestHandlerMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_HARDWARE_NETWORK_COMPONENT), ApplicationEditorHardwareNetworkMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_HARDWARE_STORAGE_COMPONENT), ApplicationEditorHardwareStorageMetadata.class);

        // application editor software components
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_SOFTWARE_GENERIC_COMPONENT), ApplicationEditorSoftwareGenericMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_SOFTWARE_DATABASE_COMPONENT), ApplicationEditorSoftwareDatabaseMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_SOFTWARE_NO_SQL_DB_COMPONENT), ApplicationEditorSoftwareNoSqlDatabaseMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_SOFTWARE_SQL_DB_COMPONENT), ApplicationEditorSoftwareSqlDatabaseMetadata.class);

        // application editor main and sla sections
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR, FORM_APPLICATION), ApplicationEditorMetadata.class);
        metadataMap.put(join(CONTEXT_APPLICATION_EDITOR_SLA, FORM_APPLICATION), ApplicationEditorSlaMetadata.class);

        // application summary
        metadataMap.put(join(CONTEXT_APPLICATION_SUMMARY, FORM_APPLICATION), ApplicationSummaryMetadata.class);

        // offer editor hardware components
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_HARDWARE_GENERIC_COMPONENT), OfferEditorHardwareGenericMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_HARDWARE_COMPUTE_COMPONENT), OfferEditorHardwareComputeMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_HARDWARE_HTTP_REQUEST_HANDLER_COMPONENT), OfferEditorHardwareHttpRequestHandlerMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_HARDWARE_NETWORK_COMPONENT), OfferEditorHardwareNetworkMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_HARDWARE_STORAGE_COMPONENT), OfferEditorHardwareStorageMetadata.class);

        // offer editor software components
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_SOFTWARE_GENERIC_COMPONENT), OfferEditorSoftwareGenericMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_SOFTWARE_DATABASE_COMPONENT), OfferEditorSoftwareDatabaseMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_SOFTWARE_NO_SQL_DB_COMPONENT), OfferEditorSoftwareNoSqlDatabaseMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_SOFTWARE_SQL_DB_COMPONENT), OfferEditorSoftwareSqlDatabaseMetadata.class);

        // offer editor main and sla sections
        metadataMap.put(join(CONTEXT_OFFER_EDITOR, FORM_OFFER), OfferEditorMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_EDITOR_SLA, FORM_OFFER), OfferEditorSlaMetadata.class);

        // Offer Viewer
        // Offer Viewer hardware components
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_HARDWARE_GENERIC_COMPONENT), OfferViewerHardwareGenericMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_HARDWARE_COMPUTE_COMPONENT), OfferViewerHardwareComputeMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_HARDWARE_HTTP_REQUEST_HANDLER_COMPONENT),
                OfferViewerHardwareHttpRequestHandlerMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_HARDWARE_NETWORK_COMPONENT), OfferViewerHardwareNetworkMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_HARDWARE_STORAGE_COMPONENT), OfferViewerHardwareStorageMetadata.class);

        // Offer Viewer software components
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_SOFTWARE_GENERIC_COMPONENT), OfferViewerSoftwareGenericMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_SOFTWARE_DATABASE_COMPONENT), OfferViewerSoftwareDatabaseMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_SOFTWARE_NO_SQL_DB_COMPONENT), OfferViewerSoftwareNoSqlDatabaseMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_SOFTWARE_SQL_DB_COMPONENT), OfferViewerSoftwareSqlDatabaseMetadata.class);

        // Offer Viewer main and sla sections
        metadataMap.put(join(CONTEXT_OFFER_VIEWER, FORM_OFFER), OfferViewerMetadata.class);
        metadataMap.put(join(CONTEXT_OFFER_VIEWER_SLA, FORM_OFFER), OfferViewerSlaMetadata.class);

        // offer summary sla template details
        metadataMap.put(join(CONTEXT_SLA_TEMPLATE_EDITOR, FORM_SLA_TEMPLATE_CONTEXT), SLATemplateContextMetadata.class);
        metadataMap.put(join(CONTEXT_SLA_TEMPLATE_EDITOR, FORM_SLA_TEMPLATE_SERVICE), SLATemplateServiceMetadata.class);
        metadataMap.put(join(CONTEXT_SLA_TEMPLATE_EDITOR, FORM_SLA_TEMPLATE_GT_SLO), SLATemplateGuaranteeTermSLOMetadata.class);
        metadataMap.put(join(CONTEXT_SLA_TEMPLATE_EDITOR, FORM_SLA_TEMPLATE_GT_BLO), SLATemplateGuaranteeTermBLOMetadata.class);

        // Application SLA contract details
        metadataMap.put(join(CONTEXT_SLA_CONTRACT_EDITOR, FORM_SLA_CONTRACT_CONTEXT), SLAContractContextMetadata.class);
        metadataMap.put(join(CONTEXT_SLA_CONTRACT_EDITOR, FORM_SLA_CONTRACT_SERVICE), SLAContractServiceMetadata.class);
        metadataMap.put(join(CONTEXT_SLA_CONTRACT_EDITOR, FORM_SLA_CONTRACT_GT_SLO), SLAContractGuaranteeTermSLOMetadata.class);
        metadataMap.put(join(CONTEXT_SLA_CONTRACT_EDITOR, FORM_SLA_CONTRACT_GT_BLO), SLAContractGuaranteeTermBLOMetadata.class);

        // Deployment editor
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, FORM_APPLICATION), DeploymentFormApplicationMetadata.class);
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, FORM_OFFER), DeploymentFormOfferMetadata.class);
         metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, USER_PAAS_GENERIC_CREDENTIALS), DeploymentFormCredentialsMetadata.class);
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, USER_PAAS_BEANSTALK_CREDENTIALS), DeploymentFormCredentialsMetadata.class);
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, USER_PAAS_CLOUDBEES_CREDENTIALS), DeploymentFormCloudBeesCredentialsMetadata.class);
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, USER_PAAS_CLOUDCONTROL_CREDENTIALS), DeploymentFormCloudControlCredentialsMetadata.class);
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, USER_PAAS_HEROKU_CREDENTIALS), DeploymentFormHerokuCredentialsMetadata.class);
        metadataMap.put(join(CONTEXT_DEPLOYMENT_FORM, USER_PAAS_OPENSHIFT_CREDENTIALS), DeploymentFormOpenshiftCredentialsMetadata.class);

        metadataMap.put(join(CONTEXT_DEPLOYMENT_REPORT, FORM_APPLICATION), DeploymentReportApplicationMetadata.class);

        // DBCreation editor
        metadataMap.put(join(CONTEXT_DBCREATION_FORM, FORM_SOFTWARE_SQL_DB_COMPONENT), DBCreationFormSQLDBSoftwareComponentMetadata.class);
        metadataMap.put(join(CONTEXT_DBCREATION_FORM, FORM_SOFTWARE_NO_SQL_DB_COMPONENT), DBCreationFormNonSQLDBSoftwareComponentMetadata.class);
        metadataMap.put(join(CONTEXT_DBCREATION_REPORT, FORM_SOFTWARE_NO_SQL_DB_COMPONENT), DBCreationReportDBSoftwareComponentMetadata.class);
        metadataMap.put(join(CONTEXT_DBCREATION_REPORT, FORM_SOFTWARE_SQL_DB_COMPONENT), DBCreationReportDBSoftwareComponentMetadata.class);

        // DBCreationReport
        
        // SLA Policy Editor
        metadataMap.put(join(CONTEXT_SLA_POLICY_EDITOR, FORM_SLA_POLICY), SLAPolicyFormMetadata.class);

        // user editor
        metadataMap.put(join(CONTEXT_USER_EDITOR, FORM_USER), UserEditorMetadata.class);

    }

    public static EntityMetadata resolve(String formType) {
		if (metadataMap.containsKey(formType)) {
			// todo replace with a more elegant spring qualified resource
			Class<? extends EntityMetadata> clazz = metadataMap.get(formType);
			try {
				return clazz.newInstance();
			} catch (Exception e) {
				log.error("Problem instantiating the metadata for form type.", e);
			}
		}
		log.error("No metadata for form type {}.", formType);

		return new EntityMetadata();
	}
}
