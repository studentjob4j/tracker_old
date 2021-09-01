package ru.job4j.tracker;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
