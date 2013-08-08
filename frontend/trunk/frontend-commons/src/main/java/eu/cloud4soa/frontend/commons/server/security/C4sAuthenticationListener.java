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

package eu.cloud4soa.frontend.commons.server.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;

/**
 * A listener for authentication events.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class C4sAuthenticationListener implements ApplicationListener<AbstractAuthenticationEvent> {

    final Logger logger = LoggerFactory.getLogger(C4sAuthenticationListener.class);


    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent abstractAuthenticationEvent) {

        logger.warn("Here comes an authentication event: {}.", abstractAuthenticationEvent);

    }
}
