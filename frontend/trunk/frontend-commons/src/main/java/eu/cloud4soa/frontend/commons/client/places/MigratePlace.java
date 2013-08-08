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
 * Place representing the migrate page.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MigratePlace extends Place implements ApplicationProfileAware, PaaSOfferingAware {

    private String applicationProfileUriId;
    private String paaSOfferingUriId;


    public MigratePlace(String applicationProfileUriId, String paaSOfferingUriId) {
        this.applicationProfileUriId = applicationProfileUriId;
        this.paaSOfferingUriId = paaSOfferingUriId;
    }

    @Override
    public String getApplicationProfileUriId() {
        return applicationProfileUriId;
    }

    @Override
    public String getPaaSOfferingUriId() {
        return paaSOfferingUriId;
    }

    @Prefix("migrate")
    public static class Tokenizer implements PlaceTokenizer<MigratePlace> {

        @Override
        public MigratePlace getPlace(String token) {

            List<String> params = Strings.split(token);
            if (params.size() > 1)
                return new MigratePlace(params.get(0), params.get(1));
            else if (params.isEmpty())
                return new MigratePlace(null, null);
            else
                return new MigratePlace(params.get(0), null);

        }

        @Override
        public String getToken(MigratePlace place) {
            return Strings.join(Strings.defaultString(place.getApplicationProfileUriId()), Strings.defaultString(place.getPaaSOfferingUriId()));
        }
    }

}
