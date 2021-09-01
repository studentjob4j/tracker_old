package ru.job4j.tracker;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] result = tracker.findAll();
        if (result.length == 0) {
            System.out.println("Хранилище не содержит заявок");
        } else {
            for (Item temp : result) {
                System.out.println(temp);
            }
        }
        return true;
    }
}
