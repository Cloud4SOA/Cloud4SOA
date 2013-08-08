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


/**
 * The C4sSubject represents state and security operations for a C4S dashboard user.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public interface C4sSubject {


    public final static String SUPER_USER = "stefano";


    /**
     * Constant string identifying the role of developer.
     */
    public final static String USER_TYPE_DEVELOPER = "c4s-role-developer";

    /**
     * Constant string identifying the role of provider.
     */
    public final static String USER_TYPE_PROVIDER = "c4s-role-provider";



    /**
     * Check whether in the current session the user is logged in or not.
     *
     * @return true if the user is logged in.
     */
    boolean isLoggedIn();

    /**
     * Retrieve the uriId of the current user.
     *
     * @return The uriId of the current user
     */
    public String getCurrentUserUriId();


    /**
     * Check whether the currently logged in user (if any) has the given role.
     *
     * @param role String identifying the role to check.
     * @return true if the user has the role.
     */
    public boolean hasRole(String role);

    /**
     * Check whether the currently logged in user (if any) has the given permission.
     *
     * @param permission String identifying the permission to check.
     * @return true if the user has the permission.
     */
    public boolean hasPermission(String permission);
}
