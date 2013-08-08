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

package eu.cloud4soa.frontend.widget.monitoring.client.views.gxt.charts;

public interface IChart {
	final public String[] htmlColorCodes = new String[]{
			"#2E2EFE", //Blue
			"#B40431", //Red
			"#0B3B0B", //Green
			"#6A0888", //Magenta
			"#2A1B0A", //Brown
			"#B404AE", //Pink
			"#000000", //Black
			"#088A85", //Sky blue
			"#5E610B", //Yellow green
			"#B43104"  //Orange
		};
	public String getColorCodes(int i);
}
