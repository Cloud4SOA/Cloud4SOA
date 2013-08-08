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

package eu.cloud4soa.frontend.widget.deployment.client.views;

import com.google.gwt.user.client.ui.IsWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaPresenter;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;

/**
 * Contract for the migrate application view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public interface MigrateApplicationView extends IsWidget {

    enum MigrationStyle {UNKNOWN, CLI, ARCHIVE}

    enum ViewStatus {
        ASK_CREDENTIALS,
        DATABASE_MIGRATION_PROGRESS,
        SHOW_TARGET_ENVIRONMENT_DETAILS,
        UPLOAD_ARTIFACT,
        APPLICATION_MIGRATION_PROGRESS,
        END_SUMMARY,
        CLI_INSTRUCTIONS,
        ASK_MIGRATION_STYLE,
        SHOW_MANUAL_INSTRUCTIONS
    }

    static String ASK_CREDENTIALS = "ask-credentials";
    static String DATABASE_MIGRATION_PROGRESS = "database-migration-progress";
    static String SHOW_TARGET_ENVIRONMENT_DETAILS = "show-target-environment-details";
    static String UPLOAD_ARTIFACT = "upload-artifact";
    static String APPLICATION_MIGRATION_PROGRESS = "application-migration-progress";
    static String END_SUMMARY = "end-summary";
    static String CLI_INSTRUCTIONS = "cli-instructions";

    public void setPresenter(Presenter presenter);

    public void setViewStatus(ViewStatus viewStatus);

    void bindCredentialsForm(UserCredentialsModel credentialsModel);

    void bindPaaSOfferingForm(PaaSOfferingModel paasOfferingModel);

    void bindApplicationForm(ApplicationModel applicationModel);

    void submitNewArtifact();

    void bindDatabaseComponentForm(SoftwareComponentModel softwareComponentModel);

    void populateCliCard(String username, String applicationUriId, String targetOfferingUriId);

    public interface Presenter extends Cloud4SoaPresenter {

        void onCredentialsAccepted();

        void onDeployClick();

        void onDeployUploadComplete();

        void onTargetEnvironmentNextClick();

        void onMigrationStyleSelected(MigrationStyle migrationStyle);
    }
}
