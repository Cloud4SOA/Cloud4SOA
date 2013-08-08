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

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseTreeModel;

import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.ChannelModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PricingPolicyModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.RatingModel;

public class OfferingStore {
	List<Offering> offerings = new ArrayList<Offering>();
	Folder treeOfferings = null;

	public List<Offering> getOfferings() {
		// if (offerings == null) {
		// loadOfferings();
		// }

		return offerings;
	}

	public Folder getTreeOfferings() {
		return treeOfferings;
	}

	private Folder getFolderWithName(List<Folder> folders, String name) {
		int i = 0;
		while (i < folders.size() && !folders.get(i).getName().equals(name)) {
			i++;
		}
		if (i < folders.size()) {
			return folders.get(i);
		} else
			return null;
	}

	public Folder getTestTreeModel() {
		List<Folder> folders = new ArrayList<Folder>();
		Folder tmpFolder = new Folder("language1",
				new NameAndValueTreeNode[] { new NameAndValueTreeNode("name1",
						"value1"), });
		folders.add(tmpFolder);

		Folder root = new Folder("root");
		for (int i = 0; i < folders.size(); i++) {
			root.add(folders.get(i));
		}
		treeOfferings = root;

		return root;
	}

	public Folder getTreeModel(PaaSOfferingModel offer) {
		List<Folder> folders = new ArrayList<Folder>();
		Folder tmpFolder = null;
		Folder hardwareFolder = null;
		Folder channelFolder = null;
		Folder applicationFolder = null;
		Folder softwareFolder = null;
		Folder pPolicyFolder = null;
		Folder ratingsFolder = null;

		List<HardwareComponentModel> hardwareList = offer
				.getHardwareComponents();
		if (hardwareList != null && hardwareList.size() > 0) {
			hardwareFolder = new Folder("Hardware");
			for (HardwareComponentModel hardware : hardwareList) {
				if (hardware.getDisplayName() != null) {
					NameOnlyTreeNode hardTreeNode = new NameOnlyTreeNode(
							hardware.getDisplayName());
					hardwareFolder.add(hardTreeNode);
				}
			}
		}

		List<ChannelModel> channelList = offer.getCommunicationChannelModels();
		if (channelList != null && channelList.size() > 0) {
			channelFolder = new Folder("Channels");
			NameOnlyTreeNode channelTreeNode = null;
			for (ChannelModel channel : channelList) {
				if (channel.getDisplayName() != null) {
					channelTreeNode = new NameOnlyTreeNode(
							channel.getDisplayName());
					channelFolder.add(channelTreeNode);
				}
			}
		}

		// TODO Update this code once the PaaSOffering has been migrated to GXT
		// DataModel
		// List<ApplicationModel> applicationList = offer.getHostsApplication();
		// if (applicationList != null && applicationList.size() > 0) {
		// applicationFolder = new Folder("Applications");
		// for (ApplicationModel application: applicationList) {
		// NameOnlyTreeNode applicationTreeNode = new
		// NameOnlyTreeNode(application.getDisplayName());
		// applicationFolder.add(applicationTreeNode);
		// }
		// }

		List<SoftwareComponentModel> softwareList = offer
				.getSoftwareComponents();
		if (softwareList != null && softwareList.size() > 0) {
			softwareFolder = new Folder("Software");
			for (SoftwareComponentModel software : softwareList) {
				if (software.getDisplayName() != null) {
					NameAndValueTreeNode softwareTreeNode = new NameAndValueTreeNode(
							software.getDisplayName(),
							software.getDisplayName());
					softwareFolder.add(softwareTreeNode);
				}
			}
		}

		List<PricingPolicyModel> pPolicyList = offer.getPricingPolicyModels();
		if (pPolicyList != null && pPolicyList.size() > 0) {
			pPolicyFolder = new Folder("Pricing Policies");
			NameOnlyTreeNode pPolicyTreeNode = null;
			for (PricingPolicyModel pPolicy : pPolicyList) {
				if (pPolicy.getDisplayName() != null) {
					pPolicyTreeNode = new NameOnlyTreeNode(
							pPolicy.getDisplayName());
					pPolicyFolder.add(pPolicyTreeNode);
				}
			}
		}

		List<RatingModel> ratingList = offer.getRatings();
		if (ratingList != null && ratingList.size() > 0) {
			ratingsFolder = new Folder("Ratings");
			NameOnlyTreeNode ratingsTreeNode = null;
			for (RatingModel rating : ratingList) {
				if (rating.getDisplayName() != null) {
					ratingsTreeNode = new NameOnlyTreeNode(rating
							.getDisplayName().toString());
					ratingsFolder.add(ratingsTreeNode);
				}
			}
		}

		tmpFolder = getFolderWithName(folders, offer.getTitle());
		if (tmpFolder == null) {
			tmpFolder = new Folder(offer.getTitle());
			List<BaseTreeModel> children = new ArrayList<BaseTreeModel>();
			if (offer.getProvider() != null)
				children.add(new NameAndValueTreeNode("PaaS Provider", offer
						.getProvider()));
			if (offer.getProgrammingLanguage() != null)
				children.add(new NameAndValueTreeNode("Programming Language",
						offer.getProgrammingLanguage().getDisplayName()));
			// if (offer.getStatus() != null)
			// children.add(new NameAndValueTreeNode("Status",
			// offer.getStatus()));
			// if (offer.getURL() != null) {
			// children.add(new NameAndValueTreeNode("URL", offer.getURL()));
			// }
			if (children.size() > 0)
				tmpFolder.addChildren(children);
		}

		if (hardwareFolder != null && hardwareFolder.getChildCount() > 0)
			tmpFolder.add(hardwareFolder);
		if (channelFolder != null && channelFolder.getChildCount() > 0)
			tmpFolder.add(channelFolder);
		if (applicationFolder != null && applicationFolder.getChildCount() > 0)
			tmpFolder.add(applicationFolder);
		if (softwareFolder != null && softwareFolder.getChildCount() > 0)
			tmpFolder.add(softwareFolder);
		if (pPolicyFolder != null && pPolicyFolder.getChildCount() > 0)
			tmpFolder.add(pPolicyFolder);
		if (ratingsFolder != null && ratingsFolder.getChildCount() > 0)
			tmpFolder.add(ratingsFolder);

		folders.add(tmpFolder);

		Folder root = new Folder("root");
		for (int i = 0; i < folders.size(); i++) {
			root.add(folders.get(i));
		}
		treeOfferings = root;

		return root;
	}

    public List<Offering> load(List<PaaSOfferingModel> paaSofferings) {
        offerings = new ArrayList<Offering>();
        for (PaaSOfferingModel offer : paaSofferings) {
            Offering po = new Offering(offer.getTitle(), offer.getProvider(),
                    Strings.join(Strings.array(offer.isGitSupported() ? "Command line" : Strings.EMPTY, offer.isArchiveSupported() ? "Web interface" : Strings.EMPTY), " ,"),
                    offer.getAverageRating(),
                    offer.getScore());
            offerings.add(po);
        }
        return offerings;
    }

    public static List<OfferingDetails> getPaaSOfferingDetails(
			PaaSOfferingModel paaSOffering) {
		List<OfferingDetails> pods = new ArrayList<OfferingDetails>();

		if (paaSOffering == null) {
			return pods;
		}

		OfferingDetails pod;

		pod = new OfferingDetails(
				"Title",
				paaSOffering.getTitle() != null ? paaSOffering.getTitle() : "-",
				"PaaS Offering");
		pods.add(pod);

		// pod = new OfferingDetails ("Status",
		// paaSOffering.getStatus() != null? paaSOffering.getStatus(): "-",
		// "PaaS Offering"); pods.add(pod);

		// pod = new OfferingDetails ("URL",
		// paaSOffering.getURL() != null? paaSOffering.getURL(): "-",
		// "PaaS Offering"); pods.add(pod);

		pod = new OfferingDetails(
				"Programming Language",
				paaSOffering.getProgrammingLanguage().getDisplayName() != null ? paaSOffering
						.getProgrammingLanguage().getDisplayName() : "-",
				"PaaS Offering");
		pods.add(pod);

		pod = new OfferingDetails("Title",
				paaSOffering.getProvider() != null ? paaSOffering.getProvider()
						: "-", "PaaS Provider");
		pods.add(pod);

		// pod = new OfferingDetails ("Home page",
		// paaSOffering.getPaaSProvider().getHomepage() != null?
		// paaSOffering.getPaaSProvider().getHomepage(): "-",
		// "PaaS Provider"); pods.add(pod);

		return pods;
	}
}
