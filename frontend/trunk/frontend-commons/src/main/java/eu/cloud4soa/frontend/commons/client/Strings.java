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

package eu.cloud4soa.frontend.commons.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * String utilities that can be used also in the browser side code
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class Strings {

    public static final String SEPARATOR = ":";
    public static final String EMPTY = "";
    public static final String DOT = ".";
    public static final String DASH = "-";
    public static final String SPACE = " ";

    public static final String NEW_INSTANCE = "_new_";

    public static final String NEW_COMPONENT = "_new-component_";

    /**
     * Safely and efficiently check if a string is empty or null.
     *
     * @param s The string to check
     * @return true if the the string is null or empty
     */
    public static boolean isEmpty(String s) {
        if (s != null) {
            int len = s.length();
            for (int x = 0; x < len; ++x)
                if (s.charAt(x) > ' ')
                    return false;


        }
        return true;
    }

    /**
     * Safely and efficiently check if a string is not empty or null.
     *
     * @param s The string to check
     * @return true if the string is not null or empty.
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    /**
     * Split a string using the default separator, that is ':'.
     *
     * @param s String to split
     * @return Arrays of strings.
     */
    public static List<String> split(String s) {
        return split(s, SEPARATOR);
    }

    /**
     * Split a string using the given separator.
     *
     * @param str       The string
     * @param separator The separator
     * @return The array of strings
     */
    public static List<String> split(String str, String separator) {
        List<String> ret = new ArrayList<String>();
        List<String> parts = Arrays.asList(str.split(separator));
        for (String part : parts)
            if (!isEmpty(part))
                ret.add(part);

        return ret;
    }

    /**
     * Concatenate the strings in the array.
     *
     * @param strings Array of string to be concatenated.
     * @return The resulting concatenated string.
     */
    public static String join(String... strings) {
        return join(strings, SEPARATOR);
    }

    /**
     * Join the strings using the given separator.
     *
     * @param strings   Array of strings
     * @param separator Separator to be used
     * @return The string resulting from the concatenation of the strings in the array separated by the separator
     */
    public static String join(String[] strings, String separator) {
        StringBuilder result = new StringBuilder();

        for (String s : strings) {
            if (result.length() != 0)
                result.append(separator);

            result.append(s);
        }

        return result.toString();
    }

    /**
     * Return the given string or the default one is it's empty.
     *
     * @param s            The string
     * @param defaultValue The default value
     * @return The string or the default value
     */
    public static String defaultString(String s, String defaultValue) {
        return isEmpty(s) ? defaultValue : s;
    }

    /**
     * Return the given string or the first default if it's empty.
     * If the first default is empty too, return the second default.
     *
     * @param s The string
     * @param default1 The first default
     * @param default2 The second default
     * @return s1 or default1 if s1 is empty. If both s and default1 are empty, return default2.
     */
    public static String defaultString(String s, String default1, String default2) {
        return defaultString(defaultString(s, default1), default2);

    }

    /**
     * Return the value if it's not null. Otherwise return default value.
     *
     * @param value Value
     * @param defaultValue Default value
     * @param <T> Type of value
     * @return Value or default value if value is null
     */
    public static <T> T defaultObject(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }


    /**
     * Return the string or an empty string if the string is null.
     *
     * @param s The string
     * @return The string or an empty string if it's null
     */
    public static String defaultString(String s) {
        return defaultString(s, EMPTY);
    }

    /**
     * Extract the fragment from a string representation of an URI.
     *
     * @param uriId The string represented URI
     * @return The fragment
     */
    public static String extractFragment(String uriId) {
        if (isEmpty(uriId))
            return null;

        String[] sa = uriId.split("#");
        return sa[sa.length > 1 ? sa.length - 1 : 0];
    }

    /**
     * Join the strings with a dot.
     *
     * @param strings Strings to be joined
     * @return Dotted strings
     */
    public static String dotted(String... strings) {
        return join(strings, DOT);
    }

    public static String[] array(String... strings) {
        List<String> li = new ArrayList<String>();
        for (String s : strings)
            if (isNotEmpty(s))
                li.add(s);

        return li.toArray(new String[li.size()]);
    }

}
