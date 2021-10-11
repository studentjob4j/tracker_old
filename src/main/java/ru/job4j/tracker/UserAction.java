package ru.job4j.tracker;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public interface UserAction {

    String name();

    boolean execute(Input input, MemTracker tracker);
}
