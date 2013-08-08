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

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.relational.datamodel.User;
import eu.cloud4soa.relational.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The C4sSubject represents state and security operations for a C4S dashboard user.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Component
@Scope("request")
@Transactional
public class C4sSubjectImpl implements Serializable, C4sSubject {

    final Logger logger = LoggerFactory.getLogger(C4sSubjectImpl.class);

    public C4sSubjectImpl() {
        this.securityContext = SecurityContextHolder.getContext();
    }

    private SecurityContext securityContext;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isLoggedIn() {
        Authentication authentication = getAuthentication();
        return authentication.isAuthenticated() && authentication instanceof C4sUserAuthentication;
    }

    @Override
    public String getCurrentUserUriId() {
        Authentication authentication = getAuthentication();

        if (authentication instanceof C4sUserAuthentication)
            return ((C4sUserAuthentication) authentication).getUriId();
        else
            return null;
    }

    private Authentication getAuthentication() {
        if (securityContext.getAuthentication() instanceof RememberMeAuthenticationToken) {

            // replace the remember-me authentication token with a C4sUserAuthentication
            String username = securityContext.getAuthentication().getName();
            logger.debug("Logging in user '{}' with remember me.", username);

            List<User> users = userRepository.findBy("username", username);
            if (users.isEmpty())
                throw new UsernameNotFoundException("User '" + username + "' not found.");

            User user = users.get(0);

            Collection<GrantedAuthority> authorities;
            if (SUPER_USER.equals(username)) {
                authorities = AuthorityUtils.createAuthorityList(USER_TYPE_DEVELOPER, USER_TYPE_PROVIDER, UserModel.USER_ROLE_ADMINISTRATOR);
            } else if ("developer".equals(user.getUsertype().getName())) {
                authorities = AuthorityUtils.createAuthorityList(USER_TYPE_DEVELOPER);
            } else if ("paasprovider".equals(user.getUsertype().getName())) {
                authorities = AuthorityUtils.createAuthorityList(USER_TYPE_PROVIDER);
            } else
                authorities = Collections.emptyList();

            securityContext.setAuthentication(new C4sUserAuthentication(authorities, securityContext.getAuthentication(), user.getUriID()));

            securityContext.getAuthentication().setAuthenticated(true);

        }

        return securityContext.getAuthentication();

    }

    @Override
    public boolean hasPermission(String permission) {
        logger.warn("Permission check is not managed yet.");
        return false;
    }


    @Override
    public boolean hasRole(String role) {

        if (isLoggedIn())
            for (GrantedAuthority authority : getAuthentication().getAuthorities())
                if (authority.getAuthority().equals(role))
                    return true;


        return false;
    }
}
