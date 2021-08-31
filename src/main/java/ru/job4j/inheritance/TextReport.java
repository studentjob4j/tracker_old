package ru.job4j.inheritance;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
