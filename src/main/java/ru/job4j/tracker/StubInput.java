package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class StubInput implements Input {

    private List<String> list = new ArrayList<>();
    private int position = 0;

    public StubInput(List<String> answers) {
        this.list = answers;
    }

    @Override
    public String askStr(String question) {
        return list.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
