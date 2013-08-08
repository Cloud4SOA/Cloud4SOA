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

package eu.cloud4soa.frontend.commons.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eu.cloud4soa.frontend.commons.client.services.Version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implementation of the Version service.
 *
 * @author Stefano Travelli (Cyntelix)
 */
@SuppressWarnings({"GwtServiceNotRegistered"})
public class VersionImpl extends RemoteServiceServlet implements Version {

    private String version;
    
    @Override
    public String getVersion() {
        if (version == null)
            // use the version of the frontend-commons module
            version = retrieveVersion("eu.cloud4soa", "frontend-commons");

        return version;
    }


    public String retrieveVersion(String groupId, String artifactId)
    {

        InputStream is = getClass().getResourceAsStream("/META-INF/maven/" + groupId + "/" + artifactId + "/pom.properties");
        if (is == null)
            return "dev";

        Properties pom = new Properties();
        try
        {
            pom.load(is);
        } catch (IOException e)
        {
            return "-";
        }

        return pom.getProperty("version");

    }
    
}