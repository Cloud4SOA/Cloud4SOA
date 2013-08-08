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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring;

import java.io.Serializable;
/**
 * Abstract class for business models.
 * 
 * @author Denis Neuling (dn@cloudcontrol.de)
 *
 * @param <T>
 */
public abstract class AbstractModel<T extends AbstractModel<T>> implements Serializable{
	private static final long serialVersionUID = 4057310175334233152L;
	
	public abstract long getId();

	public abstract void setId(long id);
}
