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

import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.soa.UserManagementAndSecurityModule;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.server.semanticdao.DeveloperUserDao;
import eu.cloud4soa.frontend.commons.server.semanticdao.ProviderUserDao;
import eu.cloud4soa.relational.datamodel.User;
import eu.cloud4soa.relational.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * The Spring Security authentication provider for C4S.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
public class C4sAuthenticationProvider implements AuthenticationProvider, UserDetailsService {

    final Logger logger = LoggerFactory.getLogger(C4sAuthenticationProvider.class);

    @Qualifier("userManagementAndSecurityModule")
    @Autowired
    UserManagementAndSecurityModule userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeveloperUserDao developerUserRepository;

    @Autowired
    ProviderUserDao providerUserRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserInstance userInstance;

        try {
            userInstance = userService.authenticateUser(username, password);
        } catch (Throwable e) {
            if (e.getMessage().contains("wrong username") || e.getMessage().contains("No user instance"))
                throw new BadCredentialsException("Bad username or password.");

            String msg = "An error occurred while authenticating user '" + Strings.defaultString(username) + "': " + e.getMessage();
            logger.debug(msg, e);
            throw new BadCredentialsException(msg, e);
        }

        Authentication auth = new C4sUserAuthentication(loadUserByUsername(username).getAuthorities(), authentication, userInstance.getUriId());
        auth.setAuthenticated(true);

        return auth;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(clazz);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> users = userRepository.findBy("username", username);
        if (users.isEmpty())
            throw new UsernameNotFoundException("User '" + username + "' not found.");

        User user = users.get(0);

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (C4sSubject.SUPER_USER.equals(username)) {
            authorities.addAll(AuthorityUtils.createAuthorityList(UserModel.USER_ROLES));
        } else if ("developer".equals(user.getUsertype().getName())) {
            authorities.addAll(AuthorityUtils.createAuthorityList(C4sSubject.USER_TYPE_DEVELOPER));
        } else if ("paasprovider".equals(user.getUsertype().getName())) {
            authorities.addAll(AuthorityUtils.createAuthorityList(C4sSubject.USER_TYPE_PROVIDER));
        }


        UserModel userModel = "developer".equals(user.getUsertype().getName()) ?
                developerUserRepository.findByUriId(user.getUriID()) : providerUserRepository.findByUriId(user.getUriID());

        if (userModel != null)
            for (String role : UserModel.USER_ROLES)
                if (Boolean.TRUE.equals(userModel.get(role)))
                    authorities.addAll(AuthorityUtils.createAuthorityList(role));


        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);

    }
}
