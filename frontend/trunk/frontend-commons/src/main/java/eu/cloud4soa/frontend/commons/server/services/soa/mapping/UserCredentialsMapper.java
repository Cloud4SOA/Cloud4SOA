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

import java.util.Date;

import eu.cloud4soa.api.datamodel.soa.UserPaaSCredentials;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the application profile.
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
public class UserCredentialsMapper extends AbstractMapper<UserPaaSCredentials, UserCredentialsModel> {

    private String provider;

    public UserCredentialsMapper(String provider) {
        this.provider = Strings.defaultString(provider).toLowerCase();
    }

    @Override
    protected UserCredentialsModel readFrom(UserPaaSCredentials userPaaSCredentials) {

    	UserCredentialsModel userModel = new UserCredentialsModel(Strings.EMPTY, userPaaSCredentials.getUserInstanceUriId());

        userModel.set(UserCredentialsModel.USER_URIID, userPaaSCredentials.getUserInstanceUriId());
        userModel.set(UserCredentialsModel.PAAS_URIID, userPaaSCredentials.getPaaSInstanceUriId());
        userModel.set(UserCredentialsModel.PUBLIC_KEY, userPaaSCredentials.getPublicKey());
        userModel.set(UserCredentialsModel.PRIVATE_KEY, userPaaSCredentials.getSecretKey());
        userModel.set(UserCredentialsModel.ACCOUNT_NAME, userPaaSCredentials.getAccountName());

        if (Strings.isEmpty(provider))
            userModel.setFormType(MetadataMapper.USER_PAAS_GENERIC_CREDENTIALS);
        else if (provider.contains("cloudbees"))
            userModel.setFormType(MetadataMapper.USER_PAAS_CLOUDBEES_CREDENTIALS);
        else if (provider.contains("cloudcontrol"))
            userModel.setFormType(MetadataMapper.USER_PAAS_CLOUDCONTROL_CREDENTIALS);
        else if (provider.contains("beanstalk"))
            userModel.setFormType(MetadataMapper.USER_PAAS_BEANSTALK_CREDENTIALS);
        else if (provider.contains("heroku"))
            userModel.setFormType(MetadataMapper.USER_PAAS_HEROKU_CREDENTIALS);
        else if (provider.contains("openshift") || provider.contains("open shift"))
            userModel.setFormType(MetadataMapper.USER_PAAS_OPENSHIFT_CREDENTIALS);
        else
            userModel.setFormType(MetadataMapper.USER_PAAS_GENERIC_CREDENTIALS);

        
        return userModel;
    }

    @Override
    protected UserPaaSCredentials writeTo(UserPaaSCredentials userPaaSCredentials, UserCredentialsModel frontendModel) {

    	userPaaSCredentials.setUserInstanceUriId(frontendModel.<String>get(UserCredentialsModel.USER_URIID));
    	userPaaSCredentials.setPaaSInstanceUriId(frontendModel.<String>get(UserCredentialsModel.PAAS_URIID));
    	userPaaSCredentials.setPublicKey(frontendModel.<String>get(UserCredentialsModel.PUBLIC_KEY));
    	userPaaSCredentials.setSecretKey(frontendModel.<String>get(UserCredentialsModel.PRIVATE_KEY));
    	userPaaSCredentials.setAccountName(frontendModel.<String>get(UserCredentialsModel.ACCOUNT_NAME));

        return userPaaSCredentials;

    }
}
