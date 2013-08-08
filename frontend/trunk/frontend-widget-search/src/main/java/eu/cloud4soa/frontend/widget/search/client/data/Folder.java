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

package eu.cloud4soa.frontend.widget.search.client.data;

import java.io.Serializable;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseTreeModel;

public class Folder extends BaseTreeModel implements Serializable {

	private static int ID = 0;
  
	public Folder() {
		set("id", ID++);
	}

	public Folder(String name) {
		set("id", ID++);
		set("name", name);
	}

	public Folder(String name, BaseTreeModel[] children) {
		this(name);
		for (int i = 0; i < children.length; i++) {
			add(children[i]);
		}
	}
  
	public Folder(String name, List<BaseTreeModel> children) {
	    this(name);
	    if (children != null) {
	    	for (int i = 0; i < children.size(); i++) {
	    		add(children.get(i));
	    	}
	    }
	}
	
	public void addChildren(List<BaseTreeModel> children) {
		if (children != null) {
			for (int i = 0; i < children.size(); i++) {
				add(children.get(i));
			}
		}
	}
	
	public void addChild(BaseTreeModel child) {
		add(child);
	}

	public Integer getId() {
		return (Integer) get("id");
	}

	public String getName() {
		return (String) get("name");
	}

	public String toString() {
		return getName();
	}
}