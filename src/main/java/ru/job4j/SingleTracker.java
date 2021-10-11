package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

import java.util.List;

/**
 * @author Evgenii Shegai
 * @since 03.09.2021
 * @version 1.0
 */

public final class SingleTracker {

    private MemTracker tracker;

    private static SingleTracker singleTracker = null;

    private SingleTracker() {
        this.tracker = new MemTracker();
    }

    public static SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
