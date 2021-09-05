package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс сортирует строки по номерам
 * @author Evgenii Shegai
 * @since 05.09.2021
 * @version 1.0
 */

public class LexSort implements Comparator<String> {


    /**
     *Метод принимает на вход 2 стринга и сравнивает их первые символы
     * @param o1
     * @param o2
     * @return число результат сравненеия
     */

    @Override
    public int compare(String o1, String o2) {
        String[] one = o1.split("\\.");
        String[] two = o2.split("\\.");
        return Integer.compare(Integer.parseInt(one[0]), Integer.parseInt(two[0]));
    }
}
