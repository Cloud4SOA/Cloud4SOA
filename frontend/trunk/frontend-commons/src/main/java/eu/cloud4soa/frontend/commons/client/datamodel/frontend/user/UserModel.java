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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.user;

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT Model for the user profile.
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
public class UserModel extends DynamicFormModel implements IsSerializable {

    public static final String USER_ACCOUNTNAME = "accountName";
    public static final String USER_FIRSTNAME = "firstName";
    public static final String USER_FAMILYNAME = "familyname";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_BIRTHDAY = "birthday";
    public static final String USER_GEEKCODE = "geekcode";
    public static final String USER_TYPE = "type";
    public static final String EMAIL = "email";
    public static final String USER_TYPE_DEVELOPER = "c4s-user-developer";
    public static final String USER_TYPE_PROVIDER = "c4s-user-provider";
    public static final String USER_PASSWORD = "c4s-user-password";
    public static final String PROVIDER_ID = "c4s-provider-id";


    /**
     * Constant string identifying the role of an administrator.
     */
    public final static String USER_ROLE_ADMINISTRATOR = "c4s-role-administrator";

    public static final String USER_ROLE_BROWSE = "c4s-role-browse";
    public static final String USER_ROLE_MATCH = "c4s-role-match";
    public static final String USER_ROLE_DEPLOY = "c4s-role-deploy";
    public static final String USER_ROLE_MIGRATE = "c4s-role-migrate";
    public static final String USER_ROLE_MONITOR = "c4s-role-monitor";

    public static final String[] USER_ROLES = new String[]{USER_ROLE_ADMINISTRATOR, USER_ROLE_BROWSE, USER_ROLE_DEPLOY, USER_ROLE_MATCH, USER_ROLE_MIGRATE, USER_ROLE_MONITOR};

    /**
     * Set of roles to be assigned to limited user
     */
    public static final String[] NEW_USER_STANDALONE_ROLES = new String[]{USER_ROLE_BROWSE, USER_ROLE_MATCH};

    /**
     * Set of roles to be assigned to a full user
     */
    public static final String[] NEW_USER_FULL_ROLES = new String[]{USER_ROLE_BROWSE, USER_ROLE_DEPLOY, USER_ROLE_MATCH, USER_ROLE_MIGRATE, USER_ROLE_MONITOR};




    public UserModel() {
        setFormType(MetadataMapper.FORM_USER);
    }

    public UserModel(String key, String value) {
        super(key, value, MetadataMapper.FORM_USER);
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof UserModel && ((UserModel) o).getKey() != null) {
            result = ((UserModel) o).getKey().equals(
                    this.getKey());
        }

        return result;
    }

    public boolean isDeveloper() {
        return "fdandria".equals(get(USER_ACCOUNTNAME)) || USER_TYPE_DEVELOPER.equals(get(USER_TYPE));
    }

    public boolean isProvider() {
        return "fdandria".equals(get(USER_ACCOUNTNAME)) || USER_TYPE_PROVIDER.equals(get(USER_TYPE));
    }

    @Override
    public String getDisplayName() {
        return Strings.defaultString(Strings.join(new String[]{this.<String>get(USER_FIRSTNAME), this.<String>get(USER_SURNAME)}, Strings.SPACE).trim(), this.<String>get(USER_ACCOUNTNAME), "unknown");
    }
}
