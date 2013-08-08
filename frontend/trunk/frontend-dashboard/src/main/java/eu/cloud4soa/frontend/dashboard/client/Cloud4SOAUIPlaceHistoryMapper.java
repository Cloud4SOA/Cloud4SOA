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

package eu.cloud4soa.frontend.dashboard.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import eu.cloud4soa.frontend.commons.client.places.*;

/**
 * Place tokenizer registering.
 */
@WithTokenizers({
        ApplicationEditorPlace.Tokenizer.class,
        BrowsePlace.Tokenizer.class,
        DeployPlace.Tokenizer.class,
        LoginPlace.Tokenizer.class,
        LostPasswordPlace.Tokenizer.class,
        MigratePlace.Tokenizer.class,
        MonitoringPlace.Tokenizer.class,
        OfferEditorPlace.Tokenizer.class,
        RegisterPlace.Tokenizer.class,
        SearchPlace.Tokenizer.class,
        UserProfilePlace.Tokenizer.class,
        WelcomePlace.Tokenizer.class,
        AdminPlace.Tokenizer.class
})
public interface Cloud4SOAUIPlaceHistoryMapper extends PlaceHistoryMapper {

}
