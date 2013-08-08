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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas;

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ProgrammingLanguageModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;
import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;
import eu.cloud4soa.frontend.commons.client.gxt.WithTitle;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * GXT model for a PaaS offer
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class PaaSOfferingModel extends DynamicFormModel implements
        IsSerializable, WithTitle, WithDescription,
        Comparable<PaaSOfferingModel> {

    public final static String PROGRAMMING_LANGUAGE = "programmingLanguage";
    public final static String HARDWARE_COMPONENTS = "hardwareComponents";
    public final static String SOFTWARE_COMPONENTS = "softwareComponents";
    public final static String PRICING_POLICIES = "pricingPolicy";
    public final static String COMMUNICATIONCHANNELS = "communicationChannels";
    public final static String RATINGS = "ratings";
    public final static String SCORE = "score";
    public final static String PROVIDER = "provider";
    public final static String URL = "url";
    public final static String STATUS = "status";
    public final static String AVERAGE_RATING = "averageRating";

    public static final String COMPUTE_SCALING_FACTOR = "computeScalingFactor";
    public static final String WEB_SCALING_FACTOR = "webScalingFactor";

    public static final String SLA_UPTIME = "uptime";
    public static final String SLA_MAX_LATENCY = "maxLatency";

    public static final String SLA_TEMPLATE = "slaTemplate";
    public static final String GIT_SUPPORT = "gitSupport";
    public static final String ARCHIVE_SUPPORT = "archiveSupport";

    public PaaSOfferingModel() {
    }

    public PaaSOfferingModel(String key, String value) {
        super(key, value, MetadataMapper.FORM_OFFER);
    }

    public List<SoftwareComponentModel> getSoftwareComponents() {
        List<SoftwareComponentModel> softwareComponents = get(SOFTWARE_COMPONENTS);
        if (softwareComponents == null) {
            softwareComponents = new ArrayList<SoftwareComponentModel>();
            set(SOFTWARE_COMPONENTS, softwareComponents);
        }
        return softwareComponents;
    }

    public List<HardwareComponentModel> getHardwareComponents() {
        List<HardwareComponentModel> hardwareComponents = get(HARDWARE_COMPONENTS);
        if (hardwareComponents == null) {
            hardwareComponents = new ArrayList<HardwareComponentModel>();
            set(HARDWARE_COMPONENTS, hardwareComponents);
        }
        return hardwareComponents;
    }

    public void setProgrammingLanguage(
            ProgrammingLanguageModel programmingLanguageModel) {
        set(PROGRAMMING_LANGUAGE, programmingLanguageModel);
    }

    public ProgrammingLanguageModel getProgrammingLanguage() {
        ProgrammingLanguageModel programmingLanguage = get(PROGRAMMING_LANGUAGE);
        if (programmingLanguage == null) {
            programmingLanguage = new ProgrammingLanguageModel();
            set(PROGRAMMING_LANGUAGE, programmingLanguage);
        }
        return programmingLanguage;
    }

    public List<PricingPolicyModel> getPricingPolicyModels() {
        List<PricingPolicyModel> pricingPolicyModels = get(PRICING_POLICIES);
        if (pricingPolicyModels == null) {
            pricingPolicyModels = new ArrayList<PricingPolicyModel>();
            set(PRICING_POLICIES, pricingPolicyModels);
        }
        return pricingPolicyModels;
    }

    public List<ChannelModel> getCommunicationChannelModels() {
        List<ChannelModel> channelModels = get(COMMUNICATIONCHANNELS);
        if (channelModels == null) {
            channelModels = new ArrayList<ChannelModel>();
            set(COMMUNICATIONCHANNELS, channelModels);
        }
        return channelModels;
    }

    public List<RatingModel> getRatings() {
        List<RatingModel> ratingslModels = get(RATINGS);
        if (ratingslModels == null) {
            ratingslModels = new ArrayList<RatingModel>();
            set(RATINGS, ratingslModels);
        }
        return ratingslModels;
    }

    @Override
    public String getTitle() {
        return get(TITLE);
    }

    @Override
    public void setTitle(String title) {
        set(TITLE, title);
    }

    @Override
    public String getDescription() {
        return get(DESCRIPTION);
    }

    @Override
    public void setDescription(String description) {
        set(DESCRIPTION, description);
    }

    public float getScore() {
        return (Float) get(SCORE);
    }

    public void setScore(Float score) {
        set(SCORE, score);
    }

    public String getProvider() {
        return get(PROVIDER);
    }

    public void setProvider(String provider) {
        set(PROVIDER, provider);
    }

    @Override
    public int compareTo(PaaSOfferingModel o) {
        int result = 1;
        if (this.getScore() == o.getScore())
            result = 0;
        else if (this.getScore() < o.getScore())
            result = -1;
        return result;
    }

    public SLATemplateModel getSLATemplate() {
        return get(SLA_TEMPLATE);
    }

    public void setSLATemplate(SLATemplateModel template) {
        set(SLA_TEMPLATE, template);
    }

    public int getAverageRating() {
        return (Integer) get(AVERAGE_RATING);
    }

    /**
     * Check whether deployment and migration into this PaaS offering support GIT deployment.
     *
     * @return True if deployment and migration can be performed with GIT
     */
    public boolean isGitSupported() {
        return Boolean.TRUE.equals(get(GIT_SUPPORT));
    }


    /**
     * Check whether deployment and migration into this PaaS offering support archive deployment.
     *
     * @return true if archive deployment is supported
     */
    public boolean isArchiveSupported() {
        return Boolean.TRUE.equals(get(ARCHIVE_SUPPORT));
    }

}
