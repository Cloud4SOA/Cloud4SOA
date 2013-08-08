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

import eu.cloud4soa.api.datamodel.semantic.user.Developer;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.DeveloperUserMapper;
import eu.cloud4soa.relational.datamodel.User;
import eu.cloud4soa.relational.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The user model repository
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
@Repository
public class DeveloperUserRepository extends BaseRepository<UserModel, Developer> implements DeveloperUserDao {

    @Autowired
    private UserRepository userRepository;

    protected DeveloperUserRepository() {
        super(UserModel.class,
                eu.cloud4soa.api.datamodel.semantic.user.Developer.class,
                new DeveloperUserMapper());
    }

    @Override
    public String create(UserModel model) {
        throw new UnsupportedOperationException("Create user requires SOA API.");
    }

    @Override
    @Transactional
    protected void afterUpdate(UserModel model) {

        User user = findRelationalById(model.getKey());

        if (user != null) {
            user.setUsername(model.<String>get(UserModel.USER_ACCOUNTNAME));
            user.setFullname(model.getDisplayName());
            if (Strings.isNotEmpty(model.<String>get(UserModel.USER_PASSWORD)))
                user.setPassword(model.<String>get(UserModel.USER_PASSWORD));

            userRepository.update(user);

        }

    }

    private User findRelationalById(String uriId) {
        List<User> li = userRepository.findBy("uriID", uriId);
        return li.isEmpty() ? null : li.get(0);
    }

    @Override
    @Transactional
    protected void afterDelete(UserModel model) {

        User user = findRelationalById(model.getKey());

        if (user != null)
            userRepository.delete(user);
    }
}
