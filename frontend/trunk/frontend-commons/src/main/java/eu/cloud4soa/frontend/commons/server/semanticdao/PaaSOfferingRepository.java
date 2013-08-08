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

package eu.cloud4soa.frontend.commons.server.semanticdao;

import eu.cloud4soa.api.datamodel.semantic.paas.PaaSOffering;
import eu.cloud4soa.api.datamodel.semantic.user.PaaSUser;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.PaaSOfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PaaS Offering dao implementation
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
@Repository
@Secured("IS_AUTHENTICATED_FULLY")
public class PaaSOfferingRepository extends BaseRepository<PaaSOfferingModel, PaaSOffering> implements PaaSOfferingDao {

    @Autowired
    private C4sSubject c4sSubject;

    @Autowired
    private ProviderUserDao providerUserRepository;


    public PaaSOfferingRepository() {
        super(PaaSOfferingModel.class,
                PaaSOffering.class,
                new PaaSOfferMapper());
    }


    @Override
    public List<PaaSOfferingModel> retrieveCurrentUserPaaSOfferings() {

        String currentUserId = c4sSubject.getCurrentUserUriId();


        UserModel user = providerUserRepository.findByUriId(currentUserId);

        if (user == null || user.get(UserModel.PROVIDER_ID) == null || Strings.isEmpty(user.<String>get(UserModel.PROVIDER_ID)))
            return Collections.emptyList();

        String providerUriId = user.get(UserModel.PROVIDER_ID);

        List<PaaSOffering> result = new ArrayList<PaaSOffering>();


        for (PaaSOffering offering : all())
            if (offering.getPaaSProvider() != null && providerUriId.equals(offering.getPaaSProvider().getUriId()))
                result.add(offering);


        return map(result);
    }


    @Override
    protected void beforeCreate(PaaSOffering instance) {

        // when storing a new offering set the provider with the provider associated to the current user

        String currentUserId = c4sSubject.getCurrentUserUriId();
        PaaSUser user = retrieveSemanticEntityByUriId(currentUserId, PaaSUser.class);

        if (user != null && user.getPaaSProvider() != null)
            instance.setPaaSProvider(user.getPaaSProvider());
        else
            logger.warn("Unable to retrieve current user provider while storing a new offering. User: {}.", user);

    }
}
