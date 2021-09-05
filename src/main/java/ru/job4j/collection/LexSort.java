package ru.job4j.collection;

import java.util.Comparator;

/**
 * @author Evgenii Shegai
 * @since 05.09.2021
 * @version 1.0
 */

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] one = o1.split("\\.");
        String[] two = o2.split("\\.");
        return Integer.compare(Integer.parseInt(one[0]), Integer.parseInt(two[0]));
    }
}
