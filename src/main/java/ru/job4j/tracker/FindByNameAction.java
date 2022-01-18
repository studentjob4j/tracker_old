package ru.job4j.tracker;

import java.util.List;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println("Заявки с таким именем найдены " + name);
            }
        } else {
            out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
