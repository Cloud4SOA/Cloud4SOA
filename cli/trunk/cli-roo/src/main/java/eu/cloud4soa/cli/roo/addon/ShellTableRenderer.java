/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package eu.cloud4soa.cli.roo.addon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Listener for Shell events to support automatic Git repository commits.
 *
 * @author James Tyrrell
 * @since 1.1.3
 */
public class ShellTableRenderer {

	// Constants
	private static final int COLUMN_PADDING = 5;

	// Fields
	private final Map<Integer, List<String>> columnMap = new HashMap<Integer, List<String>>();
	private final String title;

	/**
	 * Constructor
	 *
	 * @param title
	 * @param headings
	 */
	public ShellTableRenderer(final String title, final String... headings) {
		this.title = title;
		for (String heading : headings) {
			addColumn(heading);
		}
	}

	public void addColumn(final String heading) {
		int position = columnMap.isEmpty() ? 0 : columnMap.size();
		List<String> list = new ArrayList<String>();
		list.add(heading);
		list.add(getUnderline(heading.length()));
		columnMap.put(position, list);
	}

	public void addRow(final String... values) {
		for (int i = 0; i < columnMap.size(); i++) {
			String value = values[i];
                        if(value == null)
                            value = "";
			List<String> list = columnMap.get(i);
			list.add(value);
		}
	}

	public int getColumnWidth(final int columnNumber) {
		List<String> stringList = columnMap.get(columnNumber);
		if (stringList == null) {
			return 0;
		}
		int largestValue = 0;
		for (String value : stringList) {
			if (value.length() > largestValue) {
				largestValue = value.length();
			}
		}
		return largestValue + COLUMN_PADDING;
	}

	public String getOutput() {
		StringBuilder table = new StringBuilder();
		int i = 0;
		int longestRow = 0;
		while (true) {
			StringBuilder entry = new StringBuilder();
			boolean timeToStop = false;
			for (int j = 0; j < columnMap.size(); j++) {
				List<String> list = columnMap.get(j);
				if (i >= list.size()) {
					timeToStop = true;
					continue;
				}
				int columnWidth = getColumnWidth(j);
				String text = columnMap.get(j).get(i);
				entry.append(text);
				if (j < columnMap.size() - 1) {
					entry.append(getPadding(columnWidth - text.length()));
				}
			}
			i++;
			if (entry.length() > longestRow) {
				longestRow = entry.length();
			}
			entry.append("\n");
			table.append(entry);
			if (timeToStop) {
				break;
			}
		}
		StringBuilder titleBuilder = new StringBuilder();
		titleBuilder.append("\n");
		if (longestRow > title.length() + 2) {
			int titleLengthPlusPadding = title.length() + 2;
			String padding = " ";
			String emphasis = getRepeatingChars('=', (longestRow - titleLengthPlusPadding) / 2);
			String extra = "";
			if (titleLengthPlusPadding % 2 != 0) {
				extra = "=";
			}
			titleBuilder.append(emphasis).append(padding).append(title).append(padding).append(emphasis).append(extra).append("\n\n");
		} else {
			titleBuilder.append("= ").append(title).append(" =").append("\n\n");
		}
		titleBuilder.append(table);
		return titleBuilder.toString();
	}

	private String getPadding(final int paddingRequired) {
		return getRepeatingChars(' ', paddingRequired);
	}

	private String getUnderline(final int underlineRequired) {
		return getRepeatingChars('-', underlineRequired);
	}

	private String getRepeatingChars(final char c, final int repeat) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < repeat; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}
