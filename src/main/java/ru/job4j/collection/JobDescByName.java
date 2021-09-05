package ru.job4j.collection;

import java.util.Comparator;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class JobDescByName implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
