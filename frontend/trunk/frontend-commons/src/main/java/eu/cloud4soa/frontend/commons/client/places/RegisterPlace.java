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

/**
 * Place representing the page where a new user register a new account in the application.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class RegisterPlace extends Place {
    
    private String username;

    public RegisterPlace(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Prefix("register")
    public static class Tokenizer implements PlaceTokenizer<RegisterPlace> {
        @Override
        public RegisterPlace getPlace(String token) {
            return new RegisterPlace(token);
        }

        @Override
        public String getToken(RegisterPlace place) {
            return place.username;
        }
    }
}
