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

package eu.cloud4soa.frontend.commons.client.dialog;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eu.cloud4soa.frontend.commons.client.resources.Icons;

public class DialogHelper {

	/**
	 * Shows a dialog with a heading and a message.
	 * 
	 * @param heading
	 *            the dialog heading. If null, the default heading is Error
	 * 
	 @param message
	 *            the message to be shown to the user.
	 * 
	 */
	public static void showDialog(String heading, String message) {
		final Dialog dialog = new Dialog();
		if (heading == null)
			heading = "Error";
		dialog.setHeading(heading);
		dialog.setButtons(Dialog.CLOSE);
		dialog.setBodyStyleName("pad-text");
		dialog.addText(message);
		dialog.getItem(0).getFocusSupport().setIgnore(true);
		dialog.setScrollMode(Scroll.AUTO);
		dialog.setHideOnButtonClick(true);
		dialog.show();
	}

	public static Dialog showConfirmationDialog(String heading, String message) {
		final Dialog dialog = new Dialog();
		if (heading == null)
			heading = "Confirmation";
		dialog.setHeading(heading);
		dialog.setButtons(Dialog.YESNO);
		dialog.setBodyStyleName("pad-text");
		dialog.addText(message);
		dialog.getItem(0).getFocusSupport().setIgnore(true);
		dialog.setScrollMode(Scroll.AUTO);
		dialog.setHideOnButtonClick(true);
		dialog.show();
		return dialog;
	}

	public static Dialog showErrorDialog(String message) {
		final Dialog dialog = new Dialog();
		dialog.setHeading("Error");
		dialog.setButtons(Dialog.CLOSE);
		dialog.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.exclamationCircle()));
		dialog.addText(message);
		dialog.setHideOnButtonClick(true);
		dialog.show();
		return dialog;
	}
}
