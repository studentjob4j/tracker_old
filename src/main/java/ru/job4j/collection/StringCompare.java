package ru.job4j.collection;

import java.util.Comparator;

/**
 * @author Evgenii Shegai
 * @since 05.09.2021
 * @version 1.0
 */

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int size = Math.min(o1.length(), o2.length());
        int result = -1;
        for (int i = 0; i < size; i++) {
           result = Character.compare(o1.charAt(i), o2.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return o1.length() - o2.length();
    }
}
