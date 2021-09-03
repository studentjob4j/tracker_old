package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * @author Evgenii Shegai
 * @since 03.09.2021
 * @version 1.0
 */

public final class SingleTracker {

    private Tracker tracker;

    private static SingleTracker singleTracker = null;

    private SingleTracker() {
        this.tracker = new Tracker();
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

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
