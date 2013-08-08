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

package eu.cloud4soa.frontend.commons.server.services.soa.mapping;

import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel.*;

/**
 * Mapper for the application profile.
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
public class UserMapper extends AbstractMapper<UserInstance, UserModel> {

    @Override
    protected UserModel readFrom(UserInstance soaInstance) {

        UserModel userModel = soaInstance == null ? new UserModel() : new UserModel(soaInstance.getUriId(), soaInstance.getAccountname());

        if (soaInstance != null) {
            userModel.set(USER_ACCOUNTNAME, soaInstance.getAccountname());
            userModel.set(USER_FIRSTNAME, soaInstance.getFirstName());
            userModel.set(USER_FAMILYNAME, soaInstance.getFamilyname());
            userModel.set(USER_SURNAME, soaInstance.getSurname());
            userModel.set(USER_EMAIL, soaInstance.getPersonalmailbox());
            userModel.set(USER_BIRTHDAY, soaInstance.getBirthday());
            userModel.set(USER_GEEKCODE, soaInstance.getGeekcode());
            userModel.set(EMAIL, soaInstance.getPersonalmailbox());

            if (soaInstance instanceof PaaSUserInstance) {
                userModel.set(USER_TYPE, UserModel.USER_TYPE_PROVIDER);
                if (((PaaSUserInstance) soaInstance).getPaaSProviderInstance() != null)
                    userModel.set(PROVIDER_ID, ((PaaSUserInstance) soaInstance).getPaaSProviderInstance().getUriId());
            } else {
                userModel.set(USER_TYPE, UserModel.USER_TYPE_DEVELOPER);
            }

            String roles = Strings.defaultString(soaInstance.getUser().getPlan());

            for (String role : UserModel.USER_ROLES)
                userModel.set(role, roles.contains(role));

        }

        return userModel;
    }

    @Override
    protected UserInstance writeTo(UserInstance soaInstance, UserModel frontendModel) {

        if (frontendModel == null)
            return soaInstance;

        if (soaInstance == null)
            soaInstance = frontendModel.isDeveloper() ? new DeveloperInstance() : new PaaSUserInstance();

        soaInstance.setUriId(frontendModel.getKey());
        soaInstance.setAccountname(frontendModel.<String>get(USER_ACCOUNTNAME));
        soaInstance.setFirstName(frontendModel.<String>get(USER_FIRSTNAME));
        soaInstance.setFamilyname(frontendModel.<String>get(USER_FAMILYNAME));
        soaInstance.setSurname(frontendModel.<String>get(UserModel.USER_SURNAME));
        soaInstance.setPersonalmailbox(frontendModel.<String>get(UserModel.USER_EMAIL));
        soaInstance.setBirthday(frontendModel.<Date>get(UserModel.USER_BIRTHDAY));
        soaInstance.setGeekcode(frontendModel.<String>get(UserModel.USER_GEEKCODE));
        soaInstance.setPersonalmailbox(frontendModel.<String>get(UserModel.EMAIL));

        List<String> roles = new ArrayList<String>();
        for (String role : UserModel.USER_ROLES)
            if (Boolean.TRUE.equals(frontendModel.get(role)))
                roles.add(role);

        soaInstance.getUser().setPlan(Strings.join(roles.toArray(new String[roles.size()]), ","));

        return soaInstance;

    }
}
