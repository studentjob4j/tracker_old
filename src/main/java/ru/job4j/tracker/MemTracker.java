package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 * Этот вариант трекера хранит данные в листе
 */

public class MemTracker implements Store {

    private final List<Item> list = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        list.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? list.get(index) : null;
    }

    @Override
    public void init() {

    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item temp : list) {
            if (temp.getName().equals(key)) {
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        return list;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }

        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            list.set(index, item);
        }
        return index != -1;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        int temp = indexOf(id);
        if (temp != -1) {
            list.remove(temp);
            result = true;
        }
        return result;
    }


    @Override
    public void close() throws Exception {

    }
}
