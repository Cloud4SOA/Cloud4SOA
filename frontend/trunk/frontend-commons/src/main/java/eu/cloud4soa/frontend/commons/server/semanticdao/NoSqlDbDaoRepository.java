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

import eu.cloud4soa.api.datamodel.semantic.inf.NoSQLDB;
import eu.cloud4soa.api.datamodel.semantic.inf.SoftwareCategory;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareCategoryModel;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SoftwareCategoryMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * No SQL DB repository
 *
 * @author Stefano Travelli (Cyntelix)
 */
@Transactional
@Repository
public class NoSqlDbDaoRepository extends BaseRepository<SoftwareCategoryModel, SoftwareCategory> implements NoSqlDbDao {

    public NoSqlDbDaoRepository() {
        super(SoftwareCategoryModel.class,
                NoSQLDB.class,
                new SoftwareCategoryMapper());
    }

}
