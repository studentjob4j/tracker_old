package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Evgenii Shegai
 * @since 05.09.2021
 * @version 1.0
 */

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> result = new ArrayList<>();
        for (Folder temp : list) {
            if (pred.test(temp)) {
                result.add(temp);
            }
        }
        return result;
    }
}
