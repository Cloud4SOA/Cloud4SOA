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

package eu.cloud4soa.frontend.commons.client.places;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;

/**
 * Contains the tools for deploying, un-deploying and migrating a deployed application from the current PaaS Provider to another.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DeployPlace extends Place implements ApplicationProfileAware, PaaSOfferingAware, SLAAware {

    private String applicationProfileUriId;
    private String paaSOfferingUriId;
    private SLATemplateModel slaTemplate;

    public DeployPlace(String applicationProfileUriId, String paaSOfferingUriId, SLATemplateModel slaTemplate) {
        this.applicationProfileUriId = applicationProfileUriId;
        this.paaSOfferingUriId = paaSOfferingUriId;
        this.slaTemplate = slaTemplate;
    }

    @Deprecated
    public String getApplicationUriId() {
        return applicationProfileUriId;
    }

    @Deprecated
    public String getOfferUriId() {
        return paaSOfferingUriId;
    }

    @Override
    public String getApplicationProfileUriId() {
        return applicationProfileUriId;
    }

    @Override
    public String getPaaSOfferingUriId() {
        return paaSOfferingUriId;
    }

    @Prefix("deploy")
    public static class Tokenizer implements PlaceTokenizer<DeployPlace> {

        @Override
        public DeployPlace getPlace(String token) {

            List<String> params = Strings.split(token);
            if (params.size() > 1)
                return new DeployPlace(params.get(0), params.get(1), null);
            else if (params.isEmpty())
                return new DeployPlace(null, null, null);
            else
                return new DeployPlace(params.get(0), null, null);

        }

        @Override
        public String getToken(DeployPlace place) {
            return Strings.join(place.getApplicationProfileUriId(), place.getPaaSOfferingUriId());
        }
    }

	@Override
	public SLATemplateModel getSLATemplate() {
		return slaTemplate;
	}
}
