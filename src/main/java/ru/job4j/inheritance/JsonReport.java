package ru.job4j.inheritance;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class JsonReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator() + "name" + " : " + name + "," + System.lineSeparator()
                + "body" + " : " + body + System.lineSeparator() + "}";

    }

    public static void main(String[] args) {
        JsonReport report = new JsonReport();
        System.out.println(report.generate("name", "body"));
    }
}
