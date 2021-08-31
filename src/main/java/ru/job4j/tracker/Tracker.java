package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int newsize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[newsize++] = items[i];
            }
        }
        return Arrays.copyOf(result, newsize);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
        }
        return index != -1;
    }

    public boolean delete(int id) {
        boolean result = false;
        int temp = indexOf(id);
        if (temp != -1) {
            System.arraycopy(items, temp + 1, items, temp, size - temp);
            items[size - 1] = null;
            size--;
            result = true;
        }
        return result;
    }

}
