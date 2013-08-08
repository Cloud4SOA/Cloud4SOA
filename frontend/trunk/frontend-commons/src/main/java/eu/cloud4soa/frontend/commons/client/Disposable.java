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

/*******************************************************************************
 * Copyright (c) 2012 Atos Spain S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the LGPLv3 Lesser General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * Contributors:
 *     Atos Spain S.A. - initial API and implementation
 *******************************************************************************/
package eu.cloud4soa.frontend.commons.client;

/**
 * Project: c4s-frontend-commons. Implement dispose method in any place activity
 * (subclass of Cloud4SoaActivity) to get invoked by MainActivity to release
 * resources allocated by the activity upon shifting to another place
 * 
 * @author "Yosu Gorroñogoitia" Creation time: Sep 17, 2012
 */
public interface Disposable {
	void dispose();
}
