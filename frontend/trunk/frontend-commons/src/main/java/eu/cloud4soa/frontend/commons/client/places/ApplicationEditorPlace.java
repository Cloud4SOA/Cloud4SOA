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

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import eu.cloud4soa.frontend.commons.client.Strings;

import java.util.List;

/**
 * Contains the tools for editing an application profiles. Only users with role "developer" access this place.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorPlace extends Place implements ApplicationProfileAware {

    private String uriId;
    private String applicationTemplate;

    public ApplicationEditorPlace(String uriId) {
        this.uriId = uriId;
    }

    public ApplicationEditorPlace(String uriId, String template) {
        this.uriId = uriId;
        this.applicationTemplate = template;
    }

    @Override
    public String getApplicationProfileUriId() {
        return uriId;
    }

    public String getApplicationTemplate() {
        return applicationTemplate;
    }

    @Deprecated
    public String getUriId() {
        return getApplicationProfileUriId();
    }

    @Prefix("application")
    public static class Tokenizer implements PlaceTokenizer<ApplicationEditorPlace> {

        @Override
        public ApplicationEditorPlace getPlace(String token) {
            List<String> params = Strings.split(token);

            if (params.size() > 1)
                return new ApplicationEditorPlace(params.get(0), params.get(1));
            else if (params.isEmpty())
                return new ApplicationEditorPlace(null, null);
            else
                return new ApplicationEditorPlace(params.get(0), null);
        }

        @Override
        public String getToken(ApplicationEditorPlace place) {
            return Strings.join(Strings.defaultString(place.getApplicationProfileUriId()), Strings.defaultString(place.getApplicationTemplate()));
        }
    }
}