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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend;

/**
 * Enumerates the various interaction styles.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 14/09/11 14.36
 */
public enum InteractionStyle
{

    /**
     * Information flow discrete, localized.
     * The user can create an application profile on the UMW.
     * When ready, she presses the Search button on the UMW to see the results.
     * If satisfied she can save the profile with save button on the UMW.
     */
    CASE_1("1) discrete, localized"),
    /**
     * Information flow discrete, distributed
     * Same as CASE 1 but the save button is now also on the SW.
     * When she pressed save, the profile appears also on the UMW
     */
    CASE_2("2) discrete, distributed"),
    /**
     * Information flow continuous, peer-to-peer, localized
     * The user can modify the search profile on the SW and the application profile
     * on the UMW.Both changes are reflected on the other widget and causes the search
     * results to change.
     * When finished the profile can be saved on the UMW
     */
    //CASE_3("3) continuous, peer-to-peer, distributed"),
    /**
     * Information flow continuous, peer-to-peer, distributed
     * Same as before but the save button is also on the SW
     * (no need to align since the info flows continuously)
     */
    CASE_4("4) continuous, peer-to-peer, distributed"),
    /**
     *  Information flow continuous,hierarchical,localized
     *  The user can modify the search profile on the SW and the application profile
     *  on the UMW, but only the change on the UMW are reflected on the SW, not the other
     *  way around.
     *  Both changes cause the search results to change.
     *  When finished the profile can be saved on the UMW
     */
    CASE_5("5) continuous, localized"),
    /**
     * Information flow continuous,hierarchical,distributed
     * The same as before, only when finished the profile can be saved on the UMW and on the SW.
     * If done on this last, the profile is aligned on the UMW
     */
    CASE_6("6) continuous, hierarchical, distributed");


    private String description;

    private InteractionStyle(String description)
    {
        this.description = description;
    }

    public String description()
    {
        return description;
    }
}
