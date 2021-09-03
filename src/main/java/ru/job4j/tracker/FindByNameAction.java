package ru.job4j.tracker;

import java.util.List;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
